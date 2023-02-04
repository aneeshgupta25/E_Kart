package com.example.acmegradefinalassessment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.textfield.TextInputEditText;

public class RegistrationActivity extends AppCompatActivity {

    TextInputEditText name, email, password, confirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration2);

        //to hide action bar
        getSupportActionBar().hide();
        //initialize the views...
        init();

    }

    private void init() {
        name = findViewById(R.id.textInputEditTextName);
        email = findViewById(R.id.textInputEditTextEmail);
        password = findViewById(R.id.textInputEditTextPassword);
        confirmPassword = findViewById(R.id.textInputEditTextConfirmPassword);
    }
}