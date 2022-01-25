package com.example.myapplication.retrofitConcepts;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiCall {

  @GET("/posts")
  Call<List<PostResponse>> getPosts();

  @GET("/users")
  Call<List<UsersResponse>> getUsers();

}
