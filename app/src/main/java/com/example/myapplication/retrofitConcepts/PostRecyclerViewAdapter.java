package com.example.myapplication.retrofitConcepts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.LayoutPostBinding;
import com.example.myapplication.interfaces.OnItemClickListener;

import java.util.List;

public class PostRecyclerViewAdapter extends RecyclerView.Adapter<PostRecyclerViewAdapter.MyVoiewHolder>{
    Context context;
    List<PostResponse> postResponses;
    private OnItemClickListener listener;

    public PostRecyclerViewAdapter(Context context, List<PostResponse> postResponses) {
        this.context = context;
        this.postResponses = postResponses;
    }

    public PostRecyclerViewAdapter(Context context, List<PostResponse> postResponses, OnItemClickListener listener) {
        this.context = context;
        this.postResponses = postResponses;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyVoiewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutPostBinding postBinding = LayoutPostBinding.inflate(LayoutInflater.from(context), parent, false);
        return new MyVoiewHolder(postBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PostRecyclerViewAdapter.MyVoiewHolder holder, int position) {
        holder.binding.itemRetUserId.setText(String.valueOf(postResponses.get(position).getUserId()));
        holder.binding.itemRetId.setText(String.valueOf(postResponses.get(position).getUserId()));
        holder.binding.itemTitle.setText(postResponses.get(position).getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(postResponses, position);
            }
        });
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
