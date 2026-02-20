package com.training.libraryofalltopics.manifest.api;


import com.training.libraryofalltopics.manifest.UserData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("posts")
    Call<List<UserData>> getPosts();
}
