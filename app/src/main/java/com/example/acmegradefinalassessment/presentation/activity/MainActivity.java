package com.example.acmegradefinalassessment.presentation.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.acmegradefinalassessment.R;
import com.example.acmegradefinalassessment.presentation.fragment.AccountFragment;
import com.example.acmegradefinalassessment.presentation.fragment.CartFragment;
import com.example.acmegradefinalassessment.presentation.fragment.HomeFragment;
import com.example.acmegradefinalassessment.repository.RepoImpl;
import com.example.acmegradefinalassessment.repository.RepoInterface;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    LinearLayout linearLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    FrameLayout frameLayout;
    NavigationView navigationView;
    MaterialToolbar topAppBar;
    HomeFragment homeFragment;
    CartFragment cartFragment;
    AccountFragment accountFragment;
    RepoInterface repoInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        setUpToolBar();
        setUpDrawer();
        setUpHomeFragmentAsDefault();
        setNavigationViewListeners();
    }

    private void setUpHomeFragmentAsDefault() {
        //This will set the text in toolbar to home as a default value
        getSupportActionBar().setTitle("HOME");
        navigationView.setCheckedItem(R.id.home);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame, new HomeFragment())
                .commit();
    }

    private void setUpToolBar() {
        setSupportActionBar(topAppBar);
    }

    private void init() {

        repoInterface = new RepoImpl(this);
        //fill item cart database with static data
        repoInterface.fillItemCartDatabase();
        frameLayout = this.findViewById(R.id.frame);
        navigationView = this.findViewById(R.id.navigation_view_drawer);
        topAppBar = this.findViewById(R.id.topAppBar);
        drawerLayout = this.findViewById(R.id.drawer_layout);
        linearLayout= this.findViewById(R.id.linearLayout);
        //Avoid creating fragments instances again and again
        homeFragment = new HomeFragment();
        cartFragment = new CartFragment();
        accountFragment = new AccountFragment();

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

                // This ensures smooth fallback of the drawer
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        drawerLayout.closeDrawer(GravityCompat.START);
                    }
                },100);

                if(item.getItemId() == navigationView.getCheckedItem().getItemId()) return false;

                switch (item.getItemId()) {
                    case R.id.home:
                        navigationView.setCheckedItem(R.id.home);
                        getSupportActionBar().setTitle("HOME");
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frame, homeFragment)
                                .commit();
                        break;
                    case R.id.cart:
                        navigationView.setCheckedItem(R.id.cart);
                        getSupportActionBar().setTitle("CART");
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frame, cartFragment)
                                .commit();
                        break;
                    case R.id.account_info:
                        navigationView.setCheckedItem(R.id.account_info);
                        getSupportActionBar().setTitle("MY PROFILE");
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frame, accountFragment)
                                .commit();
                        break;
                }
                return true;
            }
        });
    }

    //on back press, if drawer is open, close the drawer instead of exiting the app
    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else if(navigationView.getCheckedItem().getItemId() != R.id.home) {
            //update checked item
            navigationView.setCheckedItem(R.id.home);
            //update title on toolbar back to home
            getSupportActionBar().setTitle("HOME");
            //display home fragment
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame, homeFragment)
                    .commit();
        } else {
            super.onBackPressed();
        }
    }

    public RepoInterface getRepository() {
        return repoInterface;
    }
}