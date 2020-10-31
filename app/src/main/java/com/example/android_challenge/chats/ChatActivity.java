package com.example.android_challenge.chats;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.android_challenge.R;
import com.example.android_challenge.databinding.ActivityChatBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;

public class ChatActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ActivityChatBinding chatBinding;
    private ChatViewModel chatViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        chatBinding = DataBindingUtil.setContentView(this, R.layout.activity_chat);
        chatViewModel = new ChatViewModel();
        chatBinding.setChatViewModel(chatViewModel);
        chatViewModel.getMessages();
        setEvent();
    }

    private void setEvent() {
        chatViewModel.postMutableLiveData.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                if (integer == View.VISIBLE || integer == View.GONE) {
                    showProgress(integer);
                } else if (integer == 10) {
                    finish();
                }
            }
        });
    }

    private void showProgress(int visi) {
        chatBinding.chatProgress.setVisibility(visi);
        chatBinding.chatProgress.setVisibility(visi);


    }
}