package com.example.android_challenge.contacts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android_challenge.R;
import com.example.android_challenge.databinding.ItemRecyclerBinding;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.ViewHolder> {
    public List<PostModel> favoritesItemList;
    Context context;

    public FavoritesAdapter() {

        favoritesItemList = new ArrayList<>();

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler,
                parent, false);
        context = parent.getContext();

        return new ViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PostModel dataModel = favoritesItemList.get(position);
        FavItemViewModel homeItemViewModels = new FavItemViewModel(dataModel);

        holder.setViewModel(homeItemViewModels);


    }

    @Override
    public int getItemCount() {
        return this.favoritesItemList.size();
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
        this.favoritesItemList.clear();
        this.favoritesItemList.addAll(data);
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemRecyclerBinding itemBinding;

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

        void setViewModel(FavItemViewModel favItemViewModel) {
            if (itemBinding != null) {
                itemBinding.setFavViewModel(favItemViewModel);
            }

        }

    }


}
