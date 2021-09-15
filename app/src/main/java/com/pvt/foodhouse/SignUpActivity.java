package com.pvt.foodhouse;

import androidx.appcompat.app.AppCompatActivity;

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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Timer;
import java.util.TimerTask;

public class SignUpActivity extends AppCompatActivity {
    /**
     * Design & Developed by Kuldeep Sahu on 04/05/2021.
     * E-mail: sahukuldeep912001@gmail.com
     * http://skywarrior09.gq
     */

    private TextInputEditText username_input, mail_input, phoneNo_input, createP_input, confirmP_input;
    private Button Go_Btn_signUp, already_ac;
    private ImageView img_regi;

    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);

        username_input = (TextInputEditText) findViewById(R.id.full_name);
        mail_input = (TextInputEditText) findViewById(R.id.email_address);
        phoneNo_input = (TextInputEditText) findViewById(R.id.phone_number);
        createP_input = (TextInputEditText) findViewById(R.id.create_pass);
        confirmP_input = (TextInputEditText) findViewById(R.id.confirm_pass);
        Go_Btn_signUp = (Button) findViewById(R.id.go_bt_regi_ac);
        already_ac = (Button) findViewById(R.id.already_user_btn);
        img_regi = (ImageView) findViewById(R.id.img_regi_ac);

        already_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
                finish();
            }
        });

        Go_Btn_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                database = FirebaseDatabase.getInstance();
                myRef = database.getReference("Users");
                auth = FirebaseAuth.getInstance();

                String str_fullName, str_mail, str_phoneN, str_createP, str_confirm_P;
                str_fullName = username_input.getText().toString();
                str_mail = mail_input.getText().toString();
                str_phoneN = phoneNo_input.getText().toString();
                str_createP = createP_input.getText().toString();
                str_confirm_P = confirmP_input.getText().toString();

                if (str_fullName.isEmpty()) {
                    username_input.setError("*required field.");
                    username_input.requestFocus();
                    return;
                } else {
                    if (str_mail.isEmpty()) {
                        mail_input.setError("*required field.");
                        mail_input.requestFocus();
                        return;
                    } else {
                        if (str_phoneN.isEmpty()) {
                            phoneNo_input.setError("*required field.");
                            phoneNo_input.requestFocus();
                            return;
                        } else {
                            if (str_phoneN.length() < 10) {
                                phoneNo_input.setError("*invalid number.");
                                phoneNo_input.requestFocus();
                                return;
                            } else {
                                if (str_createP.isEmpty()) {
                                    createP_input.setError("*required field.");
                                    createP_input.requestFocus();
                                    return;
                                } else {
                                    if (str_confirm_P.isEmpty()) {
                                        confirmP_input.setError("*required field.");
                                        confirmP_input.requestFocus();
                                        return;
                                    } else {
                                        if (str_createP.length() < 8) {
                                            createP_input.setError("*password must be 8 in length.");
                                            createP_input.requestFocus();
                                            return;
                                        } else {
                                            if (str_createP.equals(str_confirm_P)) {
                                                Toast.makeText(SignUpActivity.this, "loading...S", Toast.LENGTH_SHORT).show();
                                                Intent doneIntent = new Intent(SignUpActivity.this, OTPActivityTwo.class);
                                                doneIntent.putExtra("keyNumShowOtp", "+91 " + str_phoneN);

                                                Pair[] pairs_ab = new Pair[1];
                                                pairs_ab[0] = new Pair<View, String>(already_ac, "last_tra_name");

                                                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                                                    ActivityOptions options_ab = ActivityOptions.makeSceneTransitionAnimation(SignUpActivity.this, pairs_ab);
                                                    UserHandlerClass userHandlerClass = new UserHandlerClass(str_fullName, str_mail, str_phoneN, str_confirm_P);
                                                    myRef.child(str_phoneN).setValue(userHandlerClass);
                                                    doneIntent.putExtra("mobile", "+91"+str_phoneN.replace("", ""));
                                                    startActivity(doneIntent, options_ab.toBundle());
                                                    finish();
                                                } else {
                                                    Toast.makeText(SignUpActivity.this, "Please wait...", Toast.LENGTH_SHORT).show();
                                                    Timer timer = new Timer();
                                                    timer.schedule(new TimerTask() {
                                                        @Override
                                                        public void run() {
                                                            startActivity(new Intent(SignUpActivity.this, ErrorActivity.class));
                                                            finish();
                                                        }
                                                    }, 1500);
                                                }
                                            } else {
                                                confirmP_input.setError("*password mismatch.");
                                                createP_input.requestFocus();
                                                return;
                                            }
                                        }
                                    }
                                }
                            }
                        }

                    }
                }
            }
        });
    }
}
