package com.example.acmegradefinalassessment.presentation.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.acmegradefinalassessment.R;
import com.example.acmegradefinalassessment.data.model.User;
import com.example.acmegradefinalassessment.repository.RepoImpl;
import com.example.acmegradefinalassessment.repository.RepoInterface;
import com.example.acmegradefinalassessment.utils.InputValidation;
import com.google.android.material.textfield.TextInputLayout;

public class RegistrationActivity extends AppCompatActivity {

    TextInputLayout nameLayout, emailLayout, passwordLayout, confirmPasswordLayout;
    EditText name, email, password, confirmPassword;
    TextView textViewAlready;
    CardView buttonRegister;
    InputValidation inputValidation;
    RegistrationActivity activity;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    RepoInterface repoInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration2);

        //initialize the views...
        init();
        initListeners();

    }

    private void init() {

        repoInterface = new RepoImpl(this);

        activity = this;
        textViewAlready = findViewById(R.id.textViewAlready);

        nameLayout = findViewById(R.id.textInputLayoutName);
        emailLayout = findViewById(R.id.textInputLayoutEmail);
        passwordLayout = findViewById(R.id.textInputLayoutPassword);
        confirmPasswordLayout = findViewById(R.id.textInputLayoutConfirmPassword);

        name = findViewById(R.id.textInputEditTextName);
        email = findViewById(R.id.textInputEditTextEmail);
        password = findViewById(R.id.textInputEditTextPassword);
        confirmPassword = findViewById(R.id.textInputEditTextConfirmPassword);
        buttonRegister = findViewById(R.id.buttonRegister);

        inputValidation = new InputValidation(this);
        sharedPreferences = getSharedPreferences("PREF_CONSTANT", MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }
    private void initListeners() {

        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().trim().length() > 0) {
                    nameLayout.setErrorEnabled(false);
                }
            }
        });
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().trim().length() > 0) {
                    if (inputValidation.validateEmail(email, emailLayout)) {
                        emailLayout.setErrorEnabled(false);
                    }
                }
            }
        });
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().trim().length() > 0) {
                    passwordLayout.setErrorEnabled(false);
                }
            }
        });
        confirmPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().trim().length() > 0) {
                    confirmPasswordLayout.setErrorEnabled(false);
                }
            }
        });

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //validate fields
                if (inputValidation.isInputEditTextFilled(name, nameLayout, "Enter Your Name")
                        && inputValidation.isInputEditTextFilled(email, emailLayout, "Enter Your Email ID")
                        && inputValidation.validateEmail(email, emailLayout)
                        && inputValidation.isInputEditTextFilled(password, passwordLayout, "Enter Password")
                        && inputValidation.isInputEditTextFilled(confirmPassword, confirmPasswordLayout, "Verify Password")
                        && inputValidation.passwordMatcher(password, confirmPassword, confirmPasswordLayout)) {
                    //check if user already exists
                    if(repoInterface.userExists(email.getText().toString().trim())) {
                        Toast.makeText(activity, "This email has already been taken", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        repoInterface.registerUser(new User(name.getText().toString().trim(),
                                                email.getText().toString().trim(),
                                                password.getText().toString().trim()));
                        Toast.makeText(activity, "Registration successful!!", Toast.LENGTH_SHORT).show();
                        //setup item database
                        repoInterface.fillItemCartDatabase();
                        //update shared_preferences
                        saveLoginDetails();
                        //navigate to main activity
                        Intent intent = new Intent(activity, MainActivity.class);
                        startActivity(intent);
                    }

                }
            }
        });
        textViewAlready.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //login
                Intent intent = new Intent(activity, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void saveLoginDetails() {
        //storing email will help to retrieve the user cart on re-login
        editor.putString("user_email", email.getText().toString().trim());
        editor.putBoolean("isLoggedIn", true);
        editor.apply();
    }
}