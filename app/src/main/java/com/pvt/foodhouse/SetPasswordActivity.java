package com.pvt.foodhouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Set;

public class SetPasswordActivity extends AppCompatActivity {
    /**
     * Design & Developed by Kuldeep Sahu on 04/05/2021.
     * E-mail: sahukuldeep912001@gmail.com
     * http://skywarrior09.gq
     */

    private ImageView BackButton;
    private TextInputEditText NewPassET, ConfirmPassET;
    private Button GoButtonSP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_set_password);

        BackButton = (ImageView)findViewById(R.id.backBtn_setAC);
        NewPassET = (TextInputEditText) findViewById(R.id.newPass_input);
        ConfirmPassET = (TextInputEditText) findViewById(R.id.confirmPass_input);
        GoButtonSP = (Button) findViewById(R.id.GoBtn_new_Ac);

        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SetPasswordActivity.this, "Denied!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(SetPasswordActivity.this, LoginActivity.class));
                finish();
            }
        });

        GoButtonSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_newPet, str_conPet;
                str_newPet = NewPassET.getText().toString();
                str_conPet = ConfirmPassET.getText().toString();

                if (str_newPet.isEmpty()) {
                    NewPassET.setError("*required field.");
                    NewPassET.requestFocus();
                    return;
                } else {
                    if (str_conPet.isEmpty()) {
                        ConfirmPassET.setError("*required field.");
                        ConfirmPassET.requestFocus();
                        return;
                    } else {
                        if (str_newPet.length()<8) {
                            NewPassET.setError("*password must be eight in length.");
                            NewPassET.requestFocus();
                            return;
                        } else {
                            if (str_newPet.equals(str_conPet)) {
                                Toast.makeText(SetPasswordActivity.this, "Password reset successfully.", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(SetPasswordActivity.this, SignUpDoneActivity.class));
                                Toast.makeText(SetPasswordActivity.this, "Please LogIn", Toast.LENGTH_SHORT).show();
                                finish();
                            } else {
                                ConfirmPassET.setError("*password mismatch.");
                                ConfirmPassET.requestFocus();
                                return;
                            }
                        }
                    }
                }
            }
        });

    }
}