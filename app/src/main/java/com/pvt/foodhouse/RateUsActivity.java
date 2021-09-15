package com.pvt.foodhouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

public class RateUsActivity extends AppCompatActivity {
    /**
     * Design & Developed by Kuldeep Sahu on 04/05/2021.
     * E-mail: sahukuldeep912001@gmail.com
     * http://skywarrior09.gq
     */

    private RatingBar ratingBar;
    private Button submitBtn;
    private ImageView backBtnn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_rate_us);

        ratingBar = (RatingBar)findViewById(R.id.ratingBar);
        submitBtn = (Button)findViewById(R.id.star_submit_btn);
        backBtnn = (ImageView)findViewById(R.id.back_btn_rateUsAc);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RateUsActivity.this, "Thank you", Toast.LENGTH_SHORT).show();

                String to, subject, message, num_rate;
                to = "rafalestudio2020@gmail.com";
                subject = "Food House|Rate Us";
                message = "Food house version 1.0.1\nConsumer rating:";
                num_rate = String.valueOf(ratingBar.getRating());

                Intent emailSend = new Intent(Intent.ACTION_SEND);
                emailSend.putExtra(Intent.EXTRA_TEXT, new String[]{ to});
                emailSend.putExtra(Intent.EXTRA_TEXT, subject);
                emailSend.putExtra(Intent.EXTRA_TEXT, num_rate);
                emailSend.putExtra(Intent.EXTRA_TEXT, message);

                emailSend.setType("message/rfc822");
                startActivity(Intent.createChooser(emailSend, "Choose an Email client :"));
            }
        });

        backBtnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RateUsActivity.this, DashBoardActivity.class));
                finish();
            }
        });

    }
}