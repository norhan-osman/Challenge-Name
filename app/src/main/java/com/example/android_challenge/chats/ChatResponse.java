package com.example.android_challenge.chats;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ChatResponse{

	@SerializedName("Messages")
	private List<MessagesItem> messages;

	@SerializedName("Pic")
	private String pic;

	@SerializedName("Name")
	private String name;

	public List<MessagesItem> getMessages(){
		return messages;
	}

	public String getPic(){
		return pic;
	}

	public String getName(){
		return name;
	}
}