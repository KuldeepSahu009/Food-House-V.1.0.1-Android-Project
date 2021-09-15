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

public class OTPActivityTwo extends AppCompatActivity {
    /**
     * Design & Developed by Kuldeep Sahu on 06/05/2021.
     * E-mail: sahukuldeep912001@gmail.com
     * http://skywarrior09.gq
     */

    private PinView pinViewTwo;
    private ImageView backButtonTwo;
    private Button verifyBtnTwo, resendBtnTwo;
    private TextView codeIcon, numShowKey;
    private FirebaseAuth mAuth;
    private String otpId, phonenumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_otptwo);

        pinViewTwo = (PinView) findViewById(R.id.PinView_two);
        verifyBtnTwo = (Button) findViewById(R.id.verify_btn_otp_two);
        backButtonTwo = (ImageView) findViewById(R.id.back_btn_otp_two);
        resendBtnTwo = (Button) findViewById(R.id.resend_otp_two);
        numShowKey = (TextView) findViewById(R.id.num_show_otp_now);

        String str_phone_show = getIntent().getStringExtra("keyNumShowOtp");
        numShowKey.setText(str_phone_show);

        phonenumber = getIntent().getStringExtra("mobile").toString();
        mAuth = FirebaseAuth.getInstance();

        backButtonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OTPActivityTwo.this, SignUpActivity.class));
                finish();
            }
        });

        resendBtnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(OTPActivityTwo.this, "Resend Successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(OTPActivityTwo.this, OTPActivityTwo.class));
                finish();
            }
        });

        verifyBtnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_pinViewTwo = pinViewTwo.getText().toString();

                if (str_pinViewTwo.isEmpty()) {
                    pinViewTwo.setError("*Empty field!");
                    pinViewTwo.requestFocus();
                    return;
                } else {
                    Toast.makeText(OTPActivityTwo.this, "Verified", Toast.LENGTH_SHORT).show();
                    //PhoneAuthCredential credential = PhoneAuthProvider.getCredential(otpId, pinViewTwo.getText().toString());
                    //signInWithPhoneAuthCredential(credential);

                    startActivity(new Intent(OTPActivityTwo.this, SignUpDoneActivity.class));
                    finish();
                }
            }
        });

        initiateotp();

    }// @override

    private void initiateotp() {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phonenumber,                  // phone number to verify
                60,                           // Timeout duration
                TimeUnit.SECONDS,             // Unit of timeout
                this,                         // Activity (for callback binding)
                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                    //When SIM is On Device!
                    @Override
                    public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        otpId = s;
                    }

                    //When SIM is Not On Device!
                    @Override
                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                        signInWithPhoneAuthCredential(phoneAuthCredential);
                    }

                    //When Verification is Faild
                    @Override
                    public void onVerificationFailed(@NonNull FirebaseException e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential phoneAuthCredential) {
        mAuth.signInWithCredential(phoneAuthCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                startActivity(new Intent(OTPActivityTwo.this, SignUpDoneActivity.class));
                finish();
            }
        });
    }
}