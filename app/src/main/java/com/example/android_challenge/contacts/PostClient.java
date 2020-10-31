package com.example.android_challenge.contacts;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public class PostClient {
    private static final String BASE_URL = "https://emlenotes.com/challenges/android/";
    private PostInterface postInterface;
    private static PostClient INSTANCE;

    public PostClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        postInterface = retrofit.create(PostInterface.class);
    }

    public static PostClient getINSTANCE() {

        if (null == INSTANCE) {

            INSTANCE = new PostClient();


        }
        return INSTANCE;
    }

    public Call<PostResponse> getPosts() {
        return postInterface.getPosts();
    }
}