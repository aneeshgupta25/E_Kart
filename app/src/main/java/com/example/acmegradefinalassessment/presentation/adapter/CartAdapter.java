package com.example.acmegradefinalassessment.presentation.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.acmegradefinalassessment.data.model.Item;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter {
//
//    List<Item> list;
//    Context context;
//    public CartAdapter(Context context, List<Item>) {
//        this.list = list;
//        this.context = context;
//    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class CartViewHolder extends RecyclerView.ViewHolder {

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
