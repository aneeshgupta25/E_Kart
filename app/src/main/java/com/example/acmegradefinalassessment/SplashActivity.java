package com.example.acmegradefinalassessment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class SplashActivity extends AppCompatActivity {
    //time duration for which splash screen is visible
    private static final int SPLASH_SCREEN_TIME_OUT = 2000;
    SharedPreferences sharedPreferences;
    SplashActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        init();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean logInStatus = sharedPreferences.getBoolean("isLoggedIn", false);
                if(logInStatus) {
                    Intent intent = new Intent(activity, MainActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(activity, RegistrationActivity.class);
                    startActivity(intent);
                }
                finish();
            }
        }, SPLASH_SCREEN_TIME_OUT);

    }
    private void init() {
        sharedPreferences = getSharedPreferences("PREF_CONSTANT", MODE_PRIVATE);
        activity = this;
    }
}