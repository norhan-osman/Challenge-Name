package com.example.android_challenge.contacts;

import com.google.gson.annotations.SerializedName;

public class FavoritesItem extends PostModel {

	@SerializedName("Pic")
	private String pic;

	@SerializedName("Name")
	private String name;

	public String getPic(){
		return pic;
	}

	public String getName(){
		return name;
	}
}