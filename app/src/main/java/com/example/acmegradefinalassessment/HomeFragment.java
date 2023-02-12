package com.example.acmegradefinalassessment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.acmegradefinalassessment.adapter.FiltersAdapter;
import com.example.acmegradefinalassessment.adapter.ShoppingAdapter;
import com.example.acmegradefinalassessment.model.ClothesShoppingList;
import com.example.acmegradefinalassessment.model.Filter;
import com.example.acmegradefinalassessment.model.Item;
import com.example.acmegradefinalassessment.model.ShoppingList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HomeFragment extends Fragment implements FiltersAdapter.onFliterClick, ShoppingAdapter.onItemClick{

    RecyclerView itemRecyclerView, filterRecyclerView;
    ShoppingAdapter shoppingAdapter;
    FiltersAdapter filtersAdapter;
    LinearLayoutManager itemLayoutManager, filterLayoutManager;
    ShoppingList shoppingList;
    List<Filter> filerList;

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

        shoppingList = new ShoppingList();
        filerList = new ArrayList<>();
        for(Map.Entry<Filter, List<Item>> mapElement: shoppingList.getShoppingList().entrySet()) {
            filerList.add(mapElement.getKey());
        }

        //initialise both recyclerviews
        itemRecyclerView = view.findViewById(R.id.recyclerViewShopping);
        filterRecyclerView = view.findViewById(R.id.recyclerViewFilters);
        //initialise both layout managers
        itemLayoutManager = new LinearLayoutManager(this.getActivity());
        itemLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        filterLayoutManager = new LinearLayoutManager(this.getActivity());
        filterLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        filtersAdapter = new FiltersAdapter(this.getActivity(), filerList, this);
        shoppingAdapter = new ShoppingAdapter(this.getActivity(), shoppingList.getShoppingList().get(filerList.get(0)));

        //set adapters and layoutmanagers to recyclers

        itemRecyclerView.setLayoutManager(itemLayoutManager);
        itemRecyclerView.setAdapter(shoppingAdapter);

        filterRecyclerView.setLayoutManager(filterLayoutManager);
        filterRecyclerView.setAdapter(filtersAdapter);
    }

    @Override
    public void onClick(Filter filter) {
        shoppingAdapter.updateList(shoppingList.getShoppingList().get(filter));
    }

    @Override
    public void updateCart(Item item) {

    }
}