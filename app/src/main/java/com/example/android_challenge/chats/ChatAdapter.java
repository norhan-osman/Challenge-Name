package com.example.android_challenge.chats;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android_challenge.R;
import com.example.android_challenge.contacts.ContactsAdapter;
import com.example.android_challenge.contacts.PostItemViewModel;
import com.example.android_challenge.contacts.PostModel;
import com.example.android_challenge.databinding.ChatRecyclerBinding;
import com.example.android_challenge.databinding.ReceiverRecyclerBinding;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {
    public List<MessagesItem> messagesItems;
    Context context;

    public ChatAdapter() {
        messagesItems = new ArrayList<>();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.receiver_recycler,
                parent, false);
        context = parent.getContext();
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MessagesItem dataModel = messagesItems.get(position);
        ChatItemViewModel homeItemViewModels = new ChatItemViewModel(dataModel);
        if (dataModel.getSender() == 0) {
            holder.itemBinding.chatConatiner.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
            holder.itemBinding.tvMsg.setBackground(context.getResources().getDrawable(R.drawable.recieve_msg));
            holder.itemBinding.tvMsg.setTextColor(context.getResources().getColor(R.color.white));
        }else {
            holder.itemBinding.chatConatiner.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
            holder.itemBinding.tvMsg.setBackground(context.getResources().getDrawable(R.drawable.message));
            holder.itemBinding.tvMsg.setTextColor(context.getResources().getColor(R.color.black));
        }
        holder.setViewModel(homeItemViewModels);

    }

    @Override
    public int getItemCount() {
        return this.messagesItems.size();
    }

    @Override
    public void onViewAttachedToWindow(ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        holder.bind();
    }

    @Override
    public void onViewDetachedFromWindow(ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.unbind();
    }

    private static final String TAG = "ChatAdapter";
    public void updateData(@Nullable List<MessagesItem> data) {
        Log.e(TAG, "updateData: "+data );
        this.messagesItems.clear();
        this.messagesItems.addAll(data);
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ReceiverRecyclerBinding itemBinding;

        ViewHolder(View itemView) {

            super(itemView);
            bind();


        }


        void bind() {
            if (itemBinding == null) {
                itemBinding = DataBindingUtil.bind(itemView);
            }
        }

        void unbind() {
            if (itemBinding != null) {
                itemBinding.unbind();
            }
        }

        void setViewModel(ChatItemViewModel itemViewModels) {
            if (itemBinding != null) {
                itemBinding.setReceiverViewModel(itemViewModels);
            }
        }
    }
}
