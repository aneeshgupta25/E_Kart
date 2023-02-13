package com.example.acmegradefinalassessment.presentation.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.acmegradefinalassessment.R;
import com.example.acmegradefinalassessment.repository.RepoImpl;
import com.example.acmegradefinalassessment.repository.RepoInterface;

public class OrderPlacedActivity extends AppCompatActivity {

    Button greatButton;
    RepoInterface repoInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_placed);

        init();
        setListeners();

    }
    private void init() {
        greatButton = this.findViewById(R.id.greatButton);
        repoInterface = new RepoImpl(this);
    }
    private void setListeners() {
        greatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                repoInterface.gotToMainActivity(OrderPlacedActivity.this);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        repoInterface.gotToMainActivity(OrderPlacedActivity.this);
        finish();
    }
}