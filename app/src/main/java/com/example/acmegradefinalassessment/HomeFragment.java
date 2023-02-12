package com.example.acmegradefinalassessment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.acmegradefinalassessment.adapter.ShoppingAdapter;
import com.example.acmegradefinalassessment.model.ClothesShoppingList;

public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    ShoppingAdapter shoppingAdapter;
    LinearLayoutManager linearLayoutManager;
    ClothesShoppingList clothesShoppingList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        init(view);
        return view;
    }
    private void init(View view) {

        clothesShoppingList = new ClothesShoppingList();

        recyclerView = view.findViewById(R.id.recyclerViewShopping);
        linearLayoutManager = new LinearLayoutManager(this.getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        shoppingAdapter = new ShoppingAdapter(this.getActivity(), clothesShoppingList.getClothesList());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(shoppingAdapter);
    }
}