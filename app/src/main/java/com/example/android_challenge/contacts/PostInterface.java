package com.example.android_challenge.contacts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostInterface {
    @GET("Screen_1.json")
    public Call<PostResponse> getPosts();
    public Call<PostResponse> getfavorites();
}
