package com.example.acmegradefinalassessment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    LinearLayout linearLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    FrameLayout frameLayout;
    NavigationView navigationView;
    MaterialToolbar topAppBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        setUpToolBar();
        setUpDrawer();
        setNavigationViewListeners();
    }

    private void setUpToolBar() {
        setSupportActionBar(topAppBar);
    }

    private void init() {
        frameLayout = this.findViewById(R.id.frame);
        navigationView = this.findViewById(R.id.navigation_view_drawer);
        topAppBar = this.findViewById(R.id.topAppBar);
        drawerLayout = this.findViewById(R.id.drawer_layout);
        linearLayout= this.findViewById(R.id.linearLayout);
    }

    private void setUpDrawer() {
        topAppBar.setNavigationOnClickListener(v -> drawerLayout.open());
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    private void setNavigationViewListeners() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                return true;
            }
        });
    }

    //on back press, if drawer is open, close the drawer instead of exiting the app
    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}