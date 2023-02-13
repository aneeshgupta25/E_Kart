package com.example.acmegradefinalassessment.presentation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.acmegradefinalassessment.R;
import com.example.acmegradefinalassessment.data.model.Item;

import java.util.List;

public class BillingAdapter extends RecyclerView.Adapter<BillingAdapter.BillingViewHolder> {

    List<Item> list;
    Context context;

    public BillingAdapter(Context context, List<Item> list) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public BillingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.bill_item_card_layout, parent, false);
        return new BillingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BillingViewHolder holder, int position) {
        Item item = list.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class BillingViewHolder extends RecyclerView.ViewHolder{
        TextView nameTextView, priceTextView, deliveryTextView;
        public BillingViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.item_name_textView);
            priceTextView = itemView.findViewById(R.id.item_price_textView);
            deliveryTextView = itemView.findViewById(R.id.item_delivery_textView);
        }

        public void bind(Item item) {
            nameTextView.setText(item.getName());
            priceTextView.setText("\u20B9" + item.getPrice());
            deliveryTextView.setText("Delivery: " + "\u20B9" + item.getDelivery());
        }

    }
}
