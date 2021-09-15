package com.pvt.foodhouse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.security.Permission;

public class SupportActivity extends AppCompatActivity {
    /**
     * Design & Developed by Kuldeep Sahu on 07/05/2021.
     * E-mail: sahukuldeep912001@gmail.com
     * http://skywarrior09.gq
     */

    private ImageView backBtnSupport;
    private LinearLayout callSupport, emailSupport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_support);

        backBtnSupport = (ImageView)findViewById(R.id.back_btn_support_ac);
        callSupport = (LinearLayout)findViewById(R.id.call_support_area);
        emailSupport = (LinearLayout)findViewById(R.id.email_support_area);

        backBtnSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SupportActivity.this, DashBoardActivity.class));
                finish();
            }
        });

        callSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(SupportActivity.this, new String[]{Manifest.permission.CALL_PHONE}, PackageManager.PERMISSION_GRANTED);

                String phoneNumber = "7970057806";

                Intent intentPhone = new Intent(Intent.ACTION_CALL);
                intentPhone.setData(Uri.parse("tel:"+phoneNumber));
                startActivity(intentPhone);
            }
        });

        emailSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String subject = "Support | Food House";
                String more = "I got some problem with Food House app please support me:";
                String to = "rafalestudio2020@gmail.com";
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, new String[]{ to});
                intent.putExtra(Intent.EXTRA_TEXT, subject);
                intent.putExtra(Intent.EXTRA_TEXT, more);

                intent.setType("message/rfc822");
                startActivity(Intent.createChooser(intent, "Choose an Email client :"));
            }
        });
        
    }
}