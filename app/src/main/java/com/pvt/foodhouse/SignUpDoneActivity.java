package com.pvt.foodhouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.Toast;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class SignUpDoneActivity extends AppCompatActivity {
    /**
     * Design & Developed by Kuldeep Sahu on 04/05/2021.
     * E-mail: sahukuldeep912001@gmail.com
     * http://skywarrior09.gq
     */

    private static int SPLASH_SCREEN_2 = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up_done);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(SignUpDoneActivity.this, "Please Login!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(SignUpDoneActivity.this, LoginActivity.class));
                finish();
            }
        }, SPLASH_SCREEN_2);
    }
}