package com.pvt.foodhouse;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class PaymentActivity extends AppCompatActivity {
    /**
     * Design & Developed by Kuldeep Sahu on 08/05/2021.
     * E-mail: sahukuldeep912001@gmail.com
     * http://skywarrior09.gq
     */

    private ImageView backBtnPayment;
    private TextView ShowAmount;
    private RadioButton Payment_One, Payment_Two, Payment_Three, Payment_Four;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_payment);

        backBtnPayment = (ImageView)findViewById(R.id.back_btn_payment_ac);
        Payment_One = (RadioButton)findViewById(R.id.debit_card_btn);
        Payment_Two = (RadioButton)findViewById(R.id.credit_card_btn);
        Payment_Three = (RadioButton)findViewById(R.id.upi_btn);
        Payment_Four = (RadioButton)findViewById(R.id.net_banking_btn);
        ShowAmount = (TextView)findViewById(R.id.amount_show_area_payment);

        String str_keyamount = getIntent().getStringExtra("keyAmountNew");
        ShowAmount.setText(str_keyamount);

        backBtnPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                canclePaymentDilogBox();
            }
        });
    }

    private void canclePaymentDilogBox() {
        AlertDialog.Builder builder_dilog = new AlertDialog.Builder(this);
        builder_dilog.setTitle("Cancel Payment?");
        builder_dilog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startActivity(new Intent(PaymentActivity.this, WalletActivity.class));
                finish();
            }
        });

        builder_dilog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(PaymentActivity.this, "Proceed", Toast.LENGTH_SHORT).show();
            }
        });

        builder_dilog.create();
        builder_dilog.show();
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Cancle Payment?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startActivity(new Intent(PaymentActivity.this, WalletActivity.class));
                finish();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(PaymentActivity.this, "Proceed", Toast.LENGTH_SHORT).show();
            }
        });

        builder.create();
        builder.show();
    }
}