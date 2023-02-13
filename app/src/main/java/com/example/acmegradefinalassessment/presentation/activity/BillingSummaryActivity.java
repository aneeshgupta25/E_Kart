package com.example.acmegradefinalassessment.presentation.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.acmegradefinalassessment.R;
import com.example.acmegradefinalassessment.data.model.Item;
import com.example.acmegradefinalassessment.presentation.adapter.BillingAdapter;
import com.example.acmegradefinalassessment.presentation.adapter.ShoppingAdapter;
import com.example.acmegradefinalassessment.repository.RepoImpl;
import com.example.acmegradefinalassessment.repository.RepoInterface;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class BillingSummaryActivity extends AppCompatActivity{

    MaterialCardView checkoutButton;
    TextView billTextView;
    BillingAdapter adapter;
    LinearLayoutManager linearLayoutManager;
    RecyclerView recyclerView;
    RepoInterface repoInterface;
    Long totalBill;
    BillingSummaryActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billing_summary);
        init();
        setValues();
        setListeners();
    }

    private void setValues() {
        billTextView.setText("TOTAL: " + "\u20B9" + totalBill);
    }

    private void init() {

        activity = this;

        totalBill = 0L;
        repoInterface = new RepoImpl(this);
        List<Item> list = repoInterface.getUserCart();
        for(int i = 0; i < list.size(); i++) {
            totalBill += list.get(i).getPrice();
            totalBill += list.get(i).getDelivery();
        }
        checkoutButton = this.findViewById(R.id.checkoutButton);
        billTextView = this.findViewById(R.id.total_bill_textView);
        recyclerView = this.findViewById(R.id.bill_recycler_view);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        adapter = new BillingAdapter(this, repoInterface.getUserCart());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }
    private void setListeners() {
        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                repoInterface.clearUserCart();
                repoInterface.checkout(activity);
                finish();
            }
        });
    }
}