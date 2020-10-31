package com.example.android_challenge.contacts;

import android.widget.ImageView;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.MutableLiveData;

import com.example.android_challenge.R;
import com.squareup.picasso.Picasso;


public class PostItemViewModel extends BaseObservable {
    private PostModel postModel;
    private MutableLiveData<Integer> itemClick;

    public PostItemViewModel(PostModel postModel) {
        itemClick = new MutableLiveData<>();
        this.postModel = postModel;
    }

    public MutableLiveData<Integer> getItemClick() {
        return itemClick;
    }

    @Bindable
    public PostModel getPostModel() {
        return postModel;
    }

    public void itemAction() {
        itemClick.setValue(2);
    }

    @BindingAdapter({"postImg"})
    public static void loadImage(ImageView view, String postImg) {
        Picasso.get().load(postImg).placeholder(R.color.colorPrimary).into(view);
    }

}
