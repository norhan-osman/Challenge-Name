package com.example.android_challenge.chats;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ChatInterface {
    @GET("Screen_2.json")
    public Call<ChatResponse> getMessages();
}
