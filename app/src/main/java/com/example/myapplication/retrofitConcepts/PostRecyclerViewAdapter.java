package com.example.myapplication.retrofitConcepts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.LayoutPostBinding;

import java.util.List;

public class PostRecyclerViewAdapter extends RecyclerView.Adapter<PostRecyclerViewAdapter.MyVoiewHolder>{
    Context context;
    List<PostResponse> postResponses;

    public PostRecyclerViewAdapter(Context context, List<PostResponse> postResponses) {
        this.context = context;
        this.postResponses = postResponses;
    }

    @NonNull
    @Override
    public MyVoiewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutPostBinding postBinding = LayoutPostBinding.inflate(LayoutInflater.from(context), parent, false);
        return new MyVoiewHolder(postBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PostRecyclerViewAdapter.MyVoiewHolder holder, int position) {
//        holder.binding.itemUserId.setText(postResponses.get(position).getUserId());
        holder.binding.itemUserIdId.setText(postResponses.get(position).getUserId());
        holder.binding.itemTitle.setText(postResponses.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return postResponses.size();
    }

    public class MyVoiewHolder extends RecyclerView.ViewHolder{
        LayoutPostBinding binding;
        public MyVoiewHolder(LayoutPostBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
