package com.pvt.foodhouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Timer;
import java.util.TimerTask;

public class AdminVerificationActivity extends AppCompatActivity {
    /**
     * Design & Developed by Kuldeep Sahu on 07/05/2021.
     * E-mail: sahukuldeep912001@gmail.com
     * http://skywarrior09.gq
     */

    private Animation topanim, bottomanim;
    private TextInputEditText passcode;
    private Button AdminVerifyBtn;
    private Vibrator vibrator;
    private TextView copytext;
    private LinearLayout foranim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_admin_verification);

        topanim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomanim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        passcode = (TextInputEditText)findViewById(R.id.admin_passcode_input);
        AdminVerifyBtn = (Button)findViewById(R.id.admin_verify_btn);
        vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        copytext = (TextView)findViewById(R.id.copyright_text_two);
        foranim = (LinearLayout)findViewById(R.id.main_area_admin);

        foranim.setAnimation(bottomanim);
        copytext.setAnimation(bottomanim);

        AdminVerifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String passcode_str = passcode.getText().toString();
                if (passcode_str.isEmpty()) {
                    passcode.setError("warning!");
                    passcode.requestFocus();
                    return;
                }
                else if (passcode_str.equals("Admin@123")) {
                    Toast.makeText(AdminVerificationActivity.this, "Under Construction!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(AdminVerificationActivity.this, AdminPanalActivity.class));
                    finish();
                }
                else {
                    Toast.makeText(AdminVerificationActivity.this, "warning: not found!", Toast.LENGTH_SHORT).show();
                    Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            startActivity(new Intent(AdminVerificationActivity.this, ErrorActivity.class));
                            finish();
                        }
                    },1500);
                }

            }
        });

        AdminVerifyBtn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (Build.VERSION.SDK_INT >= 26) {
                    vibrator.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE));
                }
                else {
                    vibrator.vibrate(50);
                }
                Toast.makeText(AdminVerificationActivity.this, "Warring: 💻Developer Area!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(AdminVerificationActivity.this, MainActivity.class));
                finish();
                return true;
            }
        });

    }
}