package com.example.acmegradefinalassessment.presentation.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.acmegradefinalassessment.R;
import com.example.acmegradefinalassessment.data.model.Item;
import java.util.List;

public class ShoppingAdapter extends RecyclerView.Adapter<ShoppingAdapter.ShoppingViewHolder> {

    List<Item> list;
    Context context;
    onItemClick onItemClick;
    public ShoppingAdapter(Context context, List<Item> list, onItemClick onItemClick) {
        this.context = context;
        this.list = list;
        this.onItemClick = onItemClick;
        for(int i = 0; i < list.size(); i++) {
            Log.d("ADAPTER", list.get(i).isAddedToCart() + "");
        }
        Log.d("ADAPTER", "------------");
    }

    @NonNull
    @Override
    public ShoppingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_card_layout, parent, false);
        return new ShoppingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingViewHolder holder, int position) {
        holder.bind(list.get(position));
        holder.cartImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.get(holder.getAdapterPosition()).setAddedToCart(!list.get(holder.getAdapterPosition()).isAddedToCart());
                onItemClick.updateCart(list.get(holder.getAdapterPosition()).getId(), list.get(holder.getAdapterPosition()).isAddedToCart());
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ShoppingViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView, descTextView, deliveryTextView, ratingTextView, priceTextView;
        ImageView ratingImageView, cartImageView, itemImageView;
        public ShoppingViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.textViewItemTitle);
            descTextView = itemView.findViewById(R.id.textViewItemDesc);
            deliveryTextView = itemView.findViewById(R.id.textViewDelivery);
            ratingTextView = itemView.findViewById(R.id.textViewRating);
            priceTextView = itemView.findViewById(R.id.textViewPrice);
            ratingImageView = itemView.findViewById(R.id.imageViewRating);
            cartImageView = itemView.findViewById(R.id.imageViewCart);
            itemImageView = itemView.findViewById(R.id.imageViewItem);
        }

        private void bind(Item item) {
            titleTextView.setText(item.getName());
            descTextView.setText(item.getDesc());
            deliveryTextView.setText("Delivery " + "\u20B9" + item.getDelivery());
            ratingTextView.setText(item.getRating() + "");
            priceTextView.setText("\u20B9" + item.getPrice() + "");

            Glide.with(context).load(item.getUrl()).into(itemImageView);

            if(item.isAddedToCart()) {
                cartImageView.setImageResource(R.drawable.ic_baseline_shopping_cart_24_added);
            } else {
                cartImageView.setImageResource(R.drawable.ic_baseline_shopping_cart_24_not_addded);
            }
        }
    }

    public void updateList(List<Item> newList) {
        list = newList;
        notifyDataSetChanged();
    }

    public interface onItemClick {
        public void updateCart(int id, boolean addToCart);
    }

}
