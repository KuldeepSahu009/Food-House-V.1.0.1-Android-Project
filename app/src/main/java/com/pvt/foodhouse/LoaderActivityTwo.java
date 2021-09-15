package com.pvt.foodhouse;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;

public class LoaderActivityTwo extends AppCompatActivity {
    /**
     * Design & Developed by Kuldeep Sahu on 07/05/2021.
     * E-mail: sahukuldeep912001@gmail.com
     * http://skywarrior09.gq
     */

    private GifImageView walletGif;
    private static int SPLASH_WALLET = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_loader_two);

        walletGif = (GifImageView)findViewById(R.id.wallet_loader_gif);

        String newString = getIntent().getStringExtra("keyAmount");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent burger_intent = new Intent(LoaderActivityTwo.this, PaymentActivity.class);

                Pair[] walletPairs = new Pair[1];
                walletPairs[0] = new Pair<View,String>(walletGif,"loader_wallet_one");

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions burgerOptions = ActivityOptions.makeSceneTransitionAnimation(LoaderActivityTwo.this, walletPairs);
                    burger_intent.putExtra("keyAmountNew", newString);
                    startActivity(burger_intent, burgerOptions.toBundle());
                    finish();
                }
            }
        }, SPLASH_WALLET);
    }
}