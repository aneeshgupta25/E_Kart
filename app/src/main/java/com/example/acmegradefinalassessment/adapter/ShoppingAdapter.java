package com.example.acmegradefinalassessment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.acmegradefinalassessment.R;
import com.example.acmegradefinalassessment.model.Item;
import java.util.List;

public class ShoppingAdapter extends RecyclerView.Adapter<ShoppingAdapter.ShoppingViewHolder> {

    List<Item> list;
    Context context;
    public ShoppingAdapter(Context context, List<Item> list) {
        this.context = context;
        this.list = list;
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
        holder.ratingImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ShoppingViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView, descTextView, deliveryTextView, ratingTextView, priceTextView;
        ImageView ratingImageView;
        public ShoppingViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.textViewItemTitle);
            descTextView = itemView.findViewById(R.id.textViewItemDesc);
            deliveryTextView = itemView.findViewById(R.id.textViewDelivery);
            ratingTextView = itemView.findViewById(R.id.textViewRating);
            priceTextView = itemView.findViewById(R.id.textViewPrice);
            ratingImageView = itemView.findViewById(R.id.imageViewRating);
        }

        private void bind(Item item) {
            titleTextView.setText(item.getName());
            descTextView.setText(item.getDesc());
            deliveryTextView.setText("Delivery " + "\u20B9" + item.getDelivery());
            ratingTextView.setText(item.getRating() + "");
            priceTextView.setText("\u20B9" + item.getPrice() + "");
        }
    }

    public void updateList(List<Item> newList) {
        list = null;
        list = newList;
        notifyDataSetChanged();
    }

    public interface onItemClick {
        public void updateCart(Item item);
    }

}
