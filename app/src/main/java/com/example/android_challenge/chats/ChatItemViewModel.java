package com.example.android_challenge.chats;

import android.widget.ImageView;

import com.example.android_challenge.R;
import com.squareup.picasso.Picasso;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;

public class ChatItemViewModel extends BaseObservable {

    private MessagesItem chatModel;

    public ChatItemViewModel(MessagesItem chatModel){
        this.chatModel=chatModel;
    }


    @Bindable
    public MessagesItem getChatModel(){return chatModel;}


    @BindingAdapter({"postImg"})
    public static void loadImage(ImageView view, String postImg) {
        Picasso.get().load(postImg).placeholder(R.color.colorPrimary).into(view);
    }
}
