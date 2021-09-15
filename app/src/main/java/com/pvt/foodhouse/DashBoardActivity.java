package com.pvt.foodhouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.Timer;
import java.util.TimerTask;

public class DashBoardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    /**
     * Design & Developed by Kuldeep Sahu on 06/05/2021.
     * E-mail: sahukuldeep912001@gmail.com
     * http://skywarrior09.gq
     */

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar_b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dash_board);

        drawerLayout = (DrawerLayout)findViewById(R.id.drawable_layout);
        navigationView = (NavigationView)findViewById(R.id.nav_view);
        toolbar_b = findViewById(R.id.toolBarDashBoardAc);

        setSupportActionBar(toolbar_b);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar_b, R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.bringToFront();
        navigationView.setCheckedItem(R.id.nav_home);


    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item){

        switch (item.getItemId()) {
            case R.id.nav_home:
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_offer:
                Toast.makeText(this, "My Offers", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_Order:
                Toast.makeText(this, "My Orders", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_profile:
                Toast.makeText(this, "My Profile", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_wallet:
                Toast.makeText(this, "My Wallet", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(DashBoardActivity.this, WalletActivity.class));
                break;
            case R.id.nav_logout:
                Toast.makeText(this, "loading...", Toast.LENGTH_SHORT).show();
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        startActivity(new Intent(DashBoardActivity.this, LoginActivity.class));
                        finish();
                    }
                }, 1000);
                break;
            case R.id.nav_share:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                String body = "Download this App";
                String sub = "http://skywarrior09.gq";

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("Also share with...");
                intent.putExtra(Intent.EXTRA_TEXT, body);
                intent.putExtra(Intent.EXTRA_TEXT, sub);
                startActivity(Intent.createChooser(intent,"Share using"));
                break;
            case R.id.nav_rateUs:
                Toast.makeText(this, "Rate Us", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(DashBoardActivity.this,RateUsActivity.class));
                break;
            case R.id.nav_support:
                Toast.makeText(this, "Support", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(DashBoardActivity.this,SupportActivity.class));
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;

    }

}