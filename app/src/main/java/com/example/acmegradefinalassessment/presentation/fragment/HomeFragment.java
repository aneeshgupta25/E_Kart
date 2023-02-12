package com.example.acmegradefinalassessment.presentation.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.acmegradefinalassessment.R;
import com.example.acmegradefinalassessment.presentation.activity.MainActivity;
import com.example.acmegradefinalassessment.presentation.adapter.FiltersAdapter;
import com.example.acmegradefinalassessment.presentation.adapter.ShoppingAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements FiltersAdapter.onFliterClick, ShoppingAdapter.onItemClick{

    RecyclerView itemRecyclerView, filterRecyclerView;
    ShoppingAdapter shoppingAdapter;
    FiltersAdapter filtersAdapter;
    LinearLayoutManager itemLayoutManager, filterLayoutManager;
    MainActivity activity;
    List<String> filterList;

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

        activity = (MainActivity) this.getActivity();

        filterList = new ArrayList<>();
        filterList.add("CLOTHES");
        filterList.add("BOOKS");
        filterList.add("FRUITS");
        filterList.add("ELECTRONICS");

        //initialise both recyclerviews
        itemRecyclerView = view.findViewById(R.id.recyclerViewShopping);
        filterRecyclerView = view.findViewById(R.id.recyclerViewFilters);
        //initialise both layout managers
        itemLayoutManager = new LinearLayoutManager(this.getActivity());
        itemLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        filterLayoutManager = new LinearLayoutManager(this.getActivity());
        filterLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        filtersAdapter = new FiltersAdapter(this.getActivity(), filterList, this);
        shoppingAdapter = new ShoppingAdapter(this.getActivity(), activity.getRepository().getList(filterList.get(0)), this);

        //set adapters and layoutmanagers to recyclers

        itemRecyclerView.setLayoutManager(itemLayoutManager);
        itemRecyclerView.setAdapter(shoppingAdapter);

        filterRecyclerView.setLayoutManager(filterLayoutManager);
        filterRecyclerView.setAdapter(filtersAdapter);
    }

    @Override
    public void onClick(String  filter) {
        shoppingAdapter.updateList(activity.getRepository().getList(filter));
    }

    @Override
    public void updateCart(int id, boolean addToCart) {
        Log.d("ANEESH", id + " -> " + addToCart);
        activity.getRepository().updateUserCart(id, addToCart);
    }
}