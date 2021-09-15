package com.pvt.foodhouse;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;

import pl.droidsonroids.gif.GifImageView;

public class LoaderActivityOne extends AppCompatActivity {
    /**
     * Design & Developed by Kuldeep Sahu on 07/05/2021.
     * E-mail: sahukuldeep912001@gmail.com
     * http://skywarrior09.gq
     */

    private GifImageView burgerGif;
    private static int SPLASH_BURGER = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_loader_one);

        burgerGif = (GifImageView)findViewById(R.id.burger_loder_gif);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent burger_intent = new Intent(LoaderActivityOne.this, DashBoardActivity.class);

                Pair[] burgerPairs = new Pair[1];
                burgerPairs[0] = new Pair<View,String>(burgerGif,"loader_burger_one");

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions burgerOptions = ActivityOptions.makeSceneTransitionAnimation(LoaderActivityOne.this, burgerPairs);
                    startActivity(burger_intent, burgerOptions.toBundle());
                    finish();
                }
            }
        }, SPLASH_BURGER);
    }
}