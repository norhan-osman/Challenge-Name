package com.example.android_challenge.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android_challenge.chats.ChatActivity;
import com.example.android_challenge.contacts.ContactsAdapter;
import com.example.android_challenge.contacts.FavoritesItem;
import com.example.android_challenge.contacts.PostModel;
import com.example.android_challenge.contacts.PostViewModel;
import com.example.android_challenge.R;
import com.example.android_challenge.databinding.FragmentHomeBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;

public class HomeFragment extends Fragment {
    PostViewModel postViewModel;
    FragmentHomeBinding homeBinding;
    ContactsAdapter contactsAdapter;

    private Context context;

    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        homeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        postViewModel = new PostViewModel();
        homeBinding.setHomeViewModel(postViewModel);
        postViewModel.getPosts();
        setEvents();
        return homeBinding.getRoot();

    }

    private void setEvents() {
        postViewModel.postMutableLiveData.observe(((LifecycleOwner) context), result -> {
            if (result == View.VISIBLE || result == View.GONE) {
                showLoader(result);
            }
        });
    }

    private void showLoader(Integer result) {
        if (result == View.VISIBLE)
            homeBinding.postsProgress.setVisibility(View.VISIBLE);
        else
            homeBinding.postsProgress.setVisibility(View.GONE);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }
}
