package com.pvt.foodhouse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ImageViewCompat;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.hbb20.CountryCodePicker;

public class ForgotPasswordActivity extends AppCompatActivity {
    /**
     * Design & Developed by Kuldeep Sahu on 04/05/2021.
     * E-mail: sahukuldeep912001@gmail.com
     * http://skywarrior09.gq
     */

    private ImageView backBtnForgotAC, lock_icon_img;
    private TextInputEditText phoneInputFrogotAC;
    private Button nextBtnForgotAC;
    private CountryCodePicker ccp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_forgot_password);

        backBtnForgotAC = (ImageView)findViewById(R.id.backBtn_forgot);
        phoneInputFrogotAC = (TextInputEditText)findViewById(R.id.forgot_phoe_input);
        nextBtnForgotAC = (Button)findViewById(R.id.go_btn_forgot);
        lock_icon_img = (ImageView)findViewById(R.id.lock_iocn);
        ccp = (CountryCodePicker)findViewById(R.id.country_CodePicker);

        backBtnForgotAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backIntent = new Intent(ForgotPasswordActivity.this, LoginActivity.class);

                Pair[] pairs_a = new  Pair[1];
                pairs_a[0] = new Pair<View,String>(backBtnForgotAC, "forgot_ter_btn");

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options_a = ActivityOptions.makeSceneTransitionAnimation(ForgotPasswordActivity.this,pairs_a);
                    startActivity(backIntent, options_a.toBundle());
                    finish();
                }
            }
        });

        nextBtnForgotAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String phone_string = phoneInputFrogotAC.getText().toString();

                if (phone_string.isEmpty()) {
                    phoneInputFrogotAC.setError("*required field.");
                    phoneInputFrogotAC.requestFocus();
                    return;
                }
                else {
                    if (phone_string.length()<10) {
                        phoneInputFrogotAC.setError("*invalid number.");
                        phoneInputFrogotAC.requestFocus();
                        return;
                    }
                    else {
                        Toast.makeText(ForgotPasswordActivity.this, "OTP sent!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ForgotPasswordActivity.this, OTPActivity.class);

                        Pair[] pairs_bc = new Pair[1];
                        pairs_bc[0] = new Pair<View,String>(lock_icon_img,"lock_tra_img");

                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                            ActivityOptions activityOptions_bc = ActivityOptions.makeSceneTransitionAnimation(ForgotPasswordActivity.this, pairs_bc);
                            startActivity(intent, activityOptions_bc.toBundle());
                            finish();
                        }
                    }
                }
            }
        });

    }
}