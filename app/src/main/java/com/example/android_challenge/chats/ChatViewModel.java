package com.example.android_challenge.chats;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.android_challenge.BR;
import com.example.android_challenge.R;
import com.example.android_challenge.contacts.ContactsAdapter;
import com.example.android_challenge.contacts.FavoritesAdapter;
import com.squareup.picasso.Picasso;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChatViewModel extends BaseObservable {
    private ChatAdapter chatAdapter;
    public MutableLiveData<Integer> postMutableLiveData = new MutableLiveData<>();
    private ChatResponse chatResponse;

    public ChatViewModel() {
        chatResponse = new ChatResponse();
    }

    public void getMessages() {
        postMutableLiveData.setValue(View.VISIBLE);
        ChatClient.getINSTANCE().getMessages().enqueue(new Callback<ChatResponse>() {

            @Override
            public void onResponse(Call<ChatResponse> call, Response<ChatResponse> response) {
                if (response != null) {
                    postMutableLiveData.setValue(View.GONE);
                    getChatAdapter().updateData(response.body().getMessages());
                    setChatResponse(response.body());
                }
            }

            @Override
            public void onFailure(Call<ChatResponse> call, Throwable t) {
            }
        });
    }

    @BindingAdapter({"app:chatAdapter"})
    public static void getCatBinding(RecyclerView recyclerView, ChatAdapter chatAdapter) {
        recyclerView.setAdapter(chatAdapter);
    }

    @Bindable
    public ChatAdapter getChatAdapter() {
        return this.chatAdapter == null ? this.chatAdapter = new ChatAdapter() : this.chatAdapter;
    }

    @Bindable
    public ChatResponse getChatResponse() {
        return chatResponse;
    }


    @Bindable
    public void setChatResponse(ChatResponse chatResponse) {
        notifyPropertyChanged(BR.chatResponse);
        this.chatResponse = chatResponse;
    }

    @BindingAdapter({"userImage"})
    public static void loadImage(ImageView view, String postImg) {
        Picasso.get().load(postImg).placeholder(R.color.colorPrimary).into(view);
    }

    public void goBack() {
        postMutableLiveData.setValue(10);
    }
}
