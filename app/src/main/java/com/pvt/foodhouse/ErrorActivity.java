package com.pvt.foodhouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class ErrorActivity extends AppCompatActivity {
    /**
     * Design & Developed by Kuldeep Sahu on 04/05/2021.
     * E-mail: sahukuldeep912001@gmail.com
     * http://skywarrior09.gq
     */

    private Button retryBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_error);

        retryBtn = (Button)findViewById(R.id.retry_button_error_ac);

        retryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ErrorActivity.this, "Please wait...", Toast.LENGTH_SHORT).show();
                Timer timer_error = new Timer();
                timer_error.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        startActivity(new Intent(ErrorActivity.this, LoginActivity.class));
                        finish();
                    }
                },1500);
            }
        });
    }

}