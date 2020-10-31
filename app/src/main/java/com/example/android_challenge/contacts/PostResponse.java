package com.example.android_challenge.contacts;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostResponse {

    @SerializedName("Recent")
    @Expose
    private List<PostModel> recent;

    @SerializedName("Favorites")
    @Expose
    private List<PostModel> favorites;

    public List<PostModel> getRecent() {
        return recent;
    }

    public List<PostModel> getFavorites() {
        return favorites;
    }
}