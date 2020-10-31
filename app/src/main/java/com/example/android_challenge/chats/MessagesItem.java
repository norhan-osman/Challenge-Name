package com.example.android_challenge.chats;

import com.google.gson.annotations.SerializedName;

public class MessagesItem{

	@SerializedName("Sender")
	private int sender;

	@SerializedName("Message")
	private String message;

	public int getSender(){
		return sender;
	}

	public String getMessage(){
		return message;
	}
}