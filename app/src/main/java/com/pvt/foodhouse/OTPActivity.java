package com.pvt.foodhouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chaos.view.PinView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class OTPActivity extends AppCompatActivity {
    /**
     * Design & Developed by Kuldeep Sahu on 05/05/2021.
     * E-mail: sahukuldeep912001@gmail.com
     * http://skywarrior09.gq
     */

    private PinView pinView;
    private ImageView backButton;
    private Button verifyBtn, resendBtn;
    private TextView codeIcon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_otpactivity);

        pinView = (PinView)findViewById(R.id.pinView);
        verifyBtn = (Button)findViewById(R.id.verify_btn_otp);
        backButton = (ImageView)findViewById(R.id.back_btn_otp_ac);
        resendBtn = (Button)findViewById(R.id.Resend_otp_btn);
        codeIcon = (TextView)findViewById(R.id.code_icon_text);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_de = new Intent(OTPActivity.this, ForgotPasswordActivity.class);

                Pair[] pairs_de =  new Pair[1];
                pairs_de[0] = new Pair<View,String >(backButton,"new_trs");

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options_de = ActivityOptions.makeSceneTransitionAnimation(OTPActivity.this,pairs_de);
                    startActivity(intent_de);
                    finish();
                }
            }
        });

        resendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(OTPActivity.this, "Resend Successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(OTPActivity.this, OTPActivity.class));
                finish();
            }
        });

        verifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_pinView = pinView.getText().toString();

                if (str_pinView.isEmpty()) {
                    pinView.setError("*Empty field!");
                    pinView.requestFocus();
                    return;
                } else {
                    Intent intent = new Intent(OTPActivity.this, SetPasswordActivity.class);

                    Pair[] pairs_cd = new Pair[1];
                    pairs_cd[0] = new Pair<View,String>(codeIcon,"tra_code");

                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                        ActivityOptions options_cd = ActivityOptions.makeSceneTransitionAnimation(OTPActivity.this,pairs_cd);
                        Toast.makeText(OTPActivity.this, "Verified", Toast.LENGTH_SHORT).show();
                        startActivity(intent,options_cd.toBundle());
                        finish();
                    }

                }
            }
        });

    }
}