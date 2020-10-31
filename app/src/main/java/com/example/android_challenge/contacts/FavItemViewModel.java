package com.example.android_challenge.contacts;

import android.widget.ImageView;

import com.example.android_challenge.R;
import com.squareup.picasso.Picasso;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;

public class FavItemViewModel extends BaseObservable {
    private PostModel favoritesItem;
    
    public FavItemViewModel(PostModel favoritesItem){
        this.favoritesItem=favoritesItem;
        
    }
    public void itemAction() {

    }
    @Bindable
    public PostModel getFavoritesItem(){

        return favoritesItem;
    }
    @BindingAdapter({"postImg"})
    public static void loadImage(ImageView view, String postImg) {
        Picasso.get().load(postImg).placeholder(R.color.colorPrimary).into(view);

    }
}
