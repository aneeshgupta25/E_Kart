package com.example.acmegradefinalassessment.presentation.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.acmegradefinalassessment.R;
import com.example.acmegradefinalassessment.data.db.userdb.UserDatabase;
import com.example.acmegradefinalassessment.repository.RepoImpl;
import com.example.acmegradefinalassessment.repository.RepoInterface;
import com.example.acmegradefinalassessment.utils.InputValidation;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    TextInputLayout mailLayout, passwordLayout;
    EditText mail, password;
    InputValidation inputValidation;
    CardView buttonLogin;
    TextView textViewReg;
    UserDatabase db;
    LoginActivity activity;
    RepoInterface repoInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inputValidation.isInputEditTextFilled(mail, mailLayout, "Enter Your Email ID")
                && inputValidation.validateEmail(mail, mailLayout)) {
                    //further steps
                    boolean checkIfAccountExists = db.checkEmailAlreadyExists(mail.getText().toString().trim());
                    if(checkIfAccountExists) {
                        repoInterface.saveLoginDetails(mail.getText().toString().trim());
                        Intent intent = new Intent(activity, MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(activity, "Account doesn't exists!!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        textViewReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
    private void init() {
        repoInterface = new RepoImpl(this);
        inputValidation = new InputValidation(this);

        mailLayout = findViewById(R.id.textInputLayoutLoginEmail);
        passwordLayout = findViewById(R.id.textInputLayoutLoginPassword);
        mail = findViewById(R.id.textInputEditTextLoginEmail);
        password = findViewById(R.id.textInputEditTextLoginPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        textViewReg = findViewById(R.id.textViewNewReg);

        db = new UserDatabase(this);
        activity = this;
    }
}