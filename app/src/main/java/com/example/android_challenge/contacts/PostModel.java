package com.example.android_challenge.contacts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostModel {
    @SerializedName("New")
    @Expose
    private int latest;
    @SerializedName("Message")
    @Expose
    private String message;

    @SerializedName("Time")
    @Expose
    private String time;

    @SerializedName("Pic")
    @Expose
    private String pic;

    @SerializedName("Name")
    @Expose
    private String name;

    public int getLatest() {
        return latest;
    }

    public String getMessage() {
        return message;
    }

    public String getTime() {
        return time;
    }

    public String getPic() {
        return pic;
    }

    public String getName() {
        return name;
    }
}