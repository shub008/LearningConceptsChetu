package com.example.myapplication.interfaces;

import com.example.myapplication.retrofitConcepts.PostResponse;

import java.util.List;

public interface OnItemClickListener {
    void onItemClick(List<PostResponse> list, int position);
}
