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
import com.example.acmegradefinalassessment.presentation.activity.MainActivity;
import com.example.acmegradefinalassessment.presentation.adapter.ShoppingAdapter;
import com.example.acmegradefinalassessment.repository.RepoInterface;

public class CartFragment extends Fragment implements ShoppingAdapter.onItemClick{

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    ShoppingAdapter adapter;
    MainActivity activity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cart, container, false);

        init(view);

        return view;
    }
    private void init(View view) {

        activity = (MainActivity) getActivity();
        recyclerView = view.findViewById(R.id.recyclerViewCart);
        linearLayoutManager = new LinearLayoutManager(activity);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        adapter = new ShoppingAdapter(activity, activity.getRepository().getUserCart(), this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void updateCart(int id, boolean addToCart) {
        activity.getRepository().updateUserCart(id, addToCart);
        adapter.updateList(activity.getRepository().getUserCart());
        Toast.makeText(this.getActivity(), "Item removed from cart...", Toast.LENGTH_SHORT).show();
    }
}