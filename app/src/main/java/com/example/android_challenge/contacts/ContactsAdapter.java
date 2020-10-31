package com.example.android_challenge.contacts;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android_challenge.R;
import com.example.android_challenge.chats.ChatActivity;
import com.example.android_challenge.databinding.ChatRecyclerBinding;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {
    public List<PostModel> postModels;
    Context context;

    public ContactsAdapter() {
        postModels = new ArrayList<>();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_recycler,
                parent, false);
        context = parent.getContext();
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PostModel dataModel = postModels.get(position);
        PostItemViewModel homeItemViewModels = new PostItemViewModel(dataModel);
        homeItemViewModels.getItemClick().observe(((LifecycleOwner) context), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                if (integer == 2) {
//                    holder.itemBinding.chatmsg.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
                    context.startActivity(new Intent(context, ChatActivity.class));
                }
            }
        });
        holder.setViewModel(homeItemViewModels);

    }

    @Override
    public int getItemCount() {
        return this.postModels.size();
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

    public void updateData(@Nullable List<PostModel> data) {
        this.postModels.clear();
        this.postModels.addAll(data);
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ChatRecyclerBinding itemBinding;

        ViewHolder(View itemView) {

            super(itemView);
            bind();


          /*  itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position=getAdapterPosition();
                    if(listener !=null && position!=RecyclerView.NO_POSITION);
                    listener.onClick(postModels.get(position));
                }
            });*/


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

        void setViewModel(PostItemViewModel itemViewModels) {
            if (itemBinding != null) {
                itemBinding.setItemViewModel(itemViewModels);
            }
        }
    }

}
