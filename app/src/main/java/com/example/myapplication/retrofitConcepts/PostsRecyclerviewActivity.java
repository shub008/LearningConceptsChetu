package com.example.myapplication.retrofitConcepts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.example.myapplication.R;
import com.example.myapplication.activities.BaseActivity;
import com.example.myapplication.adapters.MyRecyclerViewAdapter;
import com.example.myapplication.databinding.ActivityPostsRecyclerviewBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostsRecyclerviewActivity extends BaseActivity {
    ActivityPostsRecyclerviewBinding binding;
    List<PostResponse> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPostsRecyclerviewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getPostsData();

    }

    private void getPostsData(){
        ProgressDialog dialog = new ProgressDialog(PostsRecyclerviewActivity.this);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("Please wait...");
        dialog.setCancelable(false);
        dialog.show();

       ApiCall apiCall = RetrofitInstance.createInstances(ApiCall.class);
       Call<List<PostResponse>> call =  apiCall.getPosts();
       call.enqueue(new Callback<List<PostResponse>>() {
           @Override
           public void onResponse(Call<List<PostResponse>> call, Response<List<PostResponse>> response) {
               dialog.dismiss();
               Log.d("REST:", ""+response.code());
               List<PostResponse> responses = response.body();

               for (PostResponse postResponse : responses){
//                   Log.d("RESPONSES:", postResponse.getUserId()+"\n"+postResponse.getId()+"\n"+postResponse.getTitle()+"\n"+postResponse.getBody());
                   list.add(postResponse);
               }

               PostRecyclerViewAdapter adapter = new PostRecyclerViewAdapter(PostsRecyclerviewActivity.this, list);
               binding.recyclerViewPost.setLayoutManager(new LinearLayoutManager(PostsRecyclerviewActivity.this));
               binding.recyclerViewPost.setAdapter(adapter);
               adapter.notifyDataSetChanged();

           }

           @Override
           public void onFailure(Call<List<PostResponse>> call, Throwable t) {
               dialog.dismiss();
               Log.d("FAILED:", t.getMessage());

           }
       });
    }
}