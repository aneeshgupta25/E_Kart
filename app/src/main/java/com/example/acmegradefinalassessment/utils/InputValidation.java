package com.example.acmegradefinalassessment.utils;

import android.content.Context;
import android.util.Patterns;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class InputValidation {

    Context context;
    public InputValidation(Context context) {
        this.context = context;
    }

    public boolean isInputEditTextFilled(EditText editText, TextInputLayout layout, String errorMessage) {
        if(editText.getText().toString().trim().isEmpty()) {
            layout.setError(errorMessage);
            return false;
        }
        layout.setErrorEnabled(false);
        return true;
    }

    public boolean validateEmail(EditText email, TextInputLayout emailLayout) {
        if (!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()) {
            emailLayout.setError("Invalid Email ID");
            return false;
        };
        emailLayout.setErrorEnabled(false);
        return true;
    }
    public boolean passwordMatcher(EditText password, EditText confirmPassword, TextInputLayout confirmPasswordLayout) {
        if(!password.getText().toString().equals(confirmPassword.getText().toString())) {
            confirmPasswordLayout.setError("Password doesn't match!");
            return false;
        }
        confirmPasswordLayout.setErrorEnabled(false);
        return true;
    }

}
