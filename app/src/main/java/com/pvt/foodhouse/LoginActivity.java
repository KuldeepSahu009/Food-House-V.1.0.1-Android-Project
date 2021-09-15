package com.pvt.foodhouse;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.w3c.dom.Text;

import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
    /**
     * Design & Developed by Kuldeep Sahu on 04/05/2021.
     * E-mail: sahukuldeep912001@gmail.com
     * http://skywarrior09.gq
     */

    private long backPressedTime;
    private Toast backToast;
    private TextInputEditText email, password;
    private Button forgotPassBtn, GoBtn, newUserBtn;
    private ImageView login_logo_img;
    private TextView lpgin_logo_text, login_text_two;
    private TextInputLayout one_layout;
    private TextInputEditText email_input, password_input;
    private Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        email = (TextInputEditText) findViewById(R.id.login_emil_real);
        password = (TextInputEditText) findViewById(R.id.login_password_real);
        forgotPassBtn = (Button) findViewById(R.id.login_forgot_btn);
        GoBtn = (Button) findViewById(R.id.login_go_btn);
        newUserBtn = (Button) findViewById(R.id.login_newuser_btn);
        login_logo_img = (ImageView) findViewById(R.id.Login_logo_img);
        lpgin_logo_text = (TextView) findViewById(R.id.login_text_one);
        login_text_two = (TextView) findViewById(R.id.login_text_two);
        one_layout = (TextInputLayout) findViewById(R.id.login_email);
        email_input = (TextInputEditText) findViewById(R.id.login_emil_real);
        password_input = (TextInputEditText) findViewById(R.id.login_password_real);
        vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);

        GoBtn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (Build.VERSION.SDK_INT >= 26) {
                    vibrator.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE));
                }
                else {
                    vibrator.vibrate(50);
                }
                Toast.makeText(LoginActivity.this, "Warning: Admin Panel!", Toast.LENGTH_SHORT).show();
                CreateAlartDilog();
                return true;
            }
        });

        GoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String str_email, str_password;
                str_email = email_input.getText().toString();
                str_password = password_input.getText().toString();

                if (str_email.isEmpty()) {
                    email_input.setError("*required field.");
                    email_input.requestFocus();
                    return;
                } else {
                    if (str_password.isEmpty()) {
                        password_input.setError("*required field.");
                        password_input.requestFocus();
                        return;
                    } else {

                        if (str_email.equals("skywarrior123@gmail.com") && str_password.equals("Skywarrior@123")) {
                            Toast.makeText(LoginActivity.this, "Verifying", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this, LoaderActivityOne.class));
                            finish();
                        }
                        else {
                            Toast.makeText(LoginActivity.this, "Please wait...", Toast.LENGTH_SHORT).show();
                            Timer timer = new Timer();
                            timer.schedule(new TimerTask() {
                                @Override
                                public void run() {
                                    startActivity(new Intent(LoginActivity.this, ErrorActivity.class));
                                    finish();
                                }
                            },1500);
                        }
                    }
                }
            }
        });

        newUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regiIntent = new Intent(LoginActivity.this, SignUpActivity.class);

                Pair[] pairs_register = new Pair[6];
                pairs_register[0] = new Pair<View, String>(login_logo_img, "home_logo_img");
                pairs_register[1] = new Pair<View, String>(lpgin_logo_text, "home_logo_text");
                pairs_register[2] = new Pair<View, String>(login_text_two, "hone_text_two");
                pairs_register[3] = new Pair<View, String>(one_layout, "email_tr_name");
                pairs_register[4] = new Pair<View, String>(GoBtn, "gobtn_tra_name");
                pairs_register[5] = new Pair<View, String>(newUserBtn, "last_tra_name");

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this, pairs_register);
                    startActivity(regiIntent, activityOptions.toBundle());
                }

            }
        });

        forgotPassBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent forgot_intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);

                Pair[] forgot_pair = new Pair[1];
                forgot_pair[0] = new Pair(newUserBtn, "last_tra_name");

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options_forgot = ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this, forgot_pair);
                    startActivity(forgot_intent, options_forgot.toBundle());
                }

            }
        });

    }//@Override

    private void CreateAlartDilog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Warning!");
        builder.setMessage("Note: \bThis is Admin Panel.\b\nIf you are not an admin then you will be restated and if anything is found you will be prosecuted.");
        builder.setPositiveButton("I Agree", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(LoginActivity.this, "warning: admin panal!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this, AdminVerificationActivity.class));
                finish();
            }
        });

        builder.setNegativeButton("Return", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(LoginActivity.this, "Redirecting", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();
            }
        });
        builder.create();
        builder.show();
    }

    private void PasswordVaidation(String password_vali) {
        Pattern uppercase = Pattern.compile("[A-Z]");
        Pattern lowercase = Pattern.compile("[a-z]");
        Pattern digitcase = Pattern.compile("[0-9]");
        Pattern specialCarecter = Pattern.compile("[@]");
    }

    @Override
    public void onBackPressed() {

        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            super.onBackPressed();
            return;
        } else {
            backToast = Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }
}