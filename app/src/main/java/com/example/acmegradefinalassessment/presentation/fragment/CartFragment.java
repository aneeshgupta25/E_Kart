package com.example.acmegradefinalassessment.presentation.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.acmegradefinalassessment.R;
import com.example.acmegradefinalassessment.data.model.Item;
import com.example.acmegradefinalassessment.presentation.activity.MainActivity;
import com.example.acmegradefinalassessment.presentation.adapter.ShoppingAdapter;
import com.example.acmegradefinalassessment.repository.RepoInterface;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class CartFragment extends Fragment implements ShoppingAdapter.onItemClick{

    MaterialCardView placeOrderButton;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    ShoppingAdapter adapter;
    MainActivity activity;
    View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_cart, container, false);

        init(view);
        setListeners();

        return view;
    }
    private void init(View view) {

        activity = (MainActivity) getActivity();
        recyclerView = view.findViewById(R.id.recyclerViewCart);
        linearLayoutManager = new LinearLayoutManager(activity);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        List<Item> list = activity.getRepository().getUserCart();
        updateLayout(list);
        adapter = new ShoppingAdapter(activity, list, this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        placeOrderButton = view.findViewById(R.id.buttonPlaceOrder);
    }

    @Override
    public void updateCart(int id, boolean addToCart) {
        activity.getRepository().updateUserCart(id, addToCart);
        List<Item> list = activity.getRepository().getUserCart();
        updateLayout(list);
        adapter.updateList(list);
        Toast.makeText(this.getActivity(), "Item removed from cart...", Toast.LENGTH_SHORT).show();
    }
    public void updateLayout(List<Item> list) {
        if(list.size() == 0) {
            //hide recyclerview and display image
            view.findViewById(R.id.recyclerViewLayout).setVisibility(View.GONE);
            view.findViewById(R.id.nothing_added_layout).setVisibility(View.VISIBLE);
        } else {
            //hide image and display recyclerview
            view.findViewById(R.id.nothing_added_layout).setVisibility(View.GONE);
            view.findViewById(R.id.recyclerViewLayout).setVisibility(View.VISIBLE);
        }
    }
    private void setListeners() {
        placeOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.getRepository().placeOrder(activity);
            }
        });
    }
}