package com.example.android_challenge.contacts;


import android.util.Log;
import android.view.View;

import java.util.List;
import java.util.Observable;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostViewModel extends BaseObservable {
    public MutableLiveData<Integer> postMutableLiveData = new MutableLiveData<>();
    private ContactsAdapter contactsAdapter;
    private FavoritesAdapter favoritesAdapter;

    public PostViewModel() {
    }

    public void getPosts() {
        postMutableLiveData.setValue(View.VISIBLE);
        PostClient.getINSTANCE().getPosts().enqueue(new Callback<PostResponse>() {
            @Override
            public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {
                postMutableLiveData.setValue(View.GONE);
                Log.e("onResponse", "onResponse: " + response.body());
                if (response.body() != null) {
                    getContactsAdapter().updateData(response.body().getRecent());
                    getFavoritesAdapter().updateData(response.body().getFavorites());
                }
            }


            @Override
            public void onFailure(Call<PostResponse> call, Throwable t) {
                Log.e("onFailure", "onFailure: " + t.getMessage());
                postMutableLiveData.setValue(View.GONE);
            }
        });
    }

    @BindingAdapter({"app:contactsAdapter"})
    public static void getCatBinding(RecyclerView recyclerView, ContactsAdapter contactsAdapter) {
        recyclerView.setAdapter(contactsAdapter);

    }

    @BindingAdapter({"app:favoritesAdapter"})
    public static void getFavBinding(RecyclerView recyclerView, FavoritesAdapter favoritesAdapter) {
        recyclerView.setAdapter(favoritesAdapter);

    }

    @Bindable
    public ContactsAdapter getContactsAdapter() {
        return this.contactsAdapter == null ? this.contactsAdapter = new ContactsAdapter() : this.contactsAdapter;
    }

    @Bindable
    public FavoritesAdapter getFavoritesAdapter() {
        return this.favoritesAdapter == null ? this.favoritesAdapter = new FavoritesAdapter() : this.favoritesAdapter;
    }

}
