package com.example.android_challenge.chats;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ChatClient {
    private static final String BASE_URL = "https://emlenotes.com/challenges/android/";
    private ChatInterface chatInterface;
    private static ChatClient INSTANCE;


    public ChatClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        chatInterface= retrofit.create(ChatInterface.class);
    }

    public static ChatClient getINSTANCE(){
        if (null == INSTANCE) {

        INSTANCE = new ChatClient();


    }
        return INSTANCE;
    }
    public Call<ChatResponse> getMessages() {
        return chatInterface.getMessages();
    }
}
