package com.pvt.foodhouse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ImageViewCompat;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    /**
     * Design & Developed by Kuldeep Sahu on 04/05/2021.
     * E-mail: sahukuldeep912001@gmail.com
     * http://skywarrior09.gq
     */

    private static int SPLASH_SCREEN = 4000;

    private Animation topAnim, bottonAnim;
    private ImageView imageView;
    private TextView logo, slogam, copyright;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottonAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        imageView = (ImageView)findViewById(R.id.splash_logo);
        logo = (TextView)findViewById(R.id.splash_text_one);
        slogam = (TextView)findViewById(R.id.splash_text_two);
        copyright = (TextView)findViewById(R.id.copyright_text_one);

        imageView.setAnimation(topAnim);
        logo.setAnimation(bottonAnim);
        slogam.setAnimation(bottonAnim);
        copyright.setAnimation(bottonAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);

                Pair[] pairs = new Pair[3];
                pairs[0] = new Pair<View,String>(imageView, "home_logo_img");
                pairs[1] = new Pair<View,String>(logo, "home_logo_text");
                pairs[2] = new Pair<View,String>(slogam, "home_text_two");

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
                    startActivity(intent,options.toBundle());
                    finish();
                }
            }
        },SPLASH_SCREEN);

    }
}