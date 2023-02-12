package com.example.acmegradefinalassessment.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.acmegradefinalassessment.HomeFragment;
import com.example.acmegradefinalassessment.R;
import com.example.acmegradefinalassessment.model.Filter;
import java.util.List;

public class FiltersAdapter extends RecyclerView.Adapter<FiltersAdapter.FiltersViewHolder> {

    Integer currentSelected;
    List<Filter> list;
    Context context;
    onFliterClick onFliterClick;
    public FiltersAdapter(Context context, List<Filter> list, onFliterClick onFliterClick) {
        this.list = list;
        this.context = context;
        currentSelected = 0;
        this.onFliterClick = onFliterClick;
    }

    @NonNull
    @Override
    public FiltersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.filter_card_layout, parent, false);
        return new FiltersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FiltersViewHolder holder, int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentSelected = holder.getAdapterPosition();
                onFliterClick.onClick(list.get(holder.getAdapterPosition()));
                notifyDataSetChanged();
            }
        });
        holder.bind(list.get(position), currentSelected== holder.getAdapterPosition());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class FiltersViewHolder extends RecyclerView.ViewHolder{
        TextView categoryTextView;
        CardView filterCardView;
        public FiltersViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryTextView = itemView.findViewById(R.id.categoryTextView);
            filterCardView = itemView.findViewById(R.id.filterCardView);
        }
        public void bind(Filter filter, boolean selected) {
            if(!selected) {
                filterCardView.setCardBackgroundColor(Color.parseColor("#D1C4E9"));
                categoryTextView.setTextColor(Color.parseColor("#000000"));
            } else {
                filterCardView.setCardBackgroundColor(Color.parseColor("#4A148C"));
                categoryTextView.setTextColor(Color.parseColor("#ffffff"));
            }
            categoryTextView.setText(filter.getCategory());
        }
    }
    public interface onFliterClick {
        public void onClick(Filter filter);
    }
}
