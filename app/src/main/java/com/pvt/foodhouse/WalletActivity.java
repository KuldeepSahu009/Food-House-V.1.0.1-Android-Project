package com.pvt.foodhouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class WalletActivity extends AppCompatActivity {
    /**
     * Design & Developed by Kuldeep Sahu on 08/05/2021.
     * E-mail: sahukuldeep912001@gmail.com
     * http://skywarrior09.gq
     */

    private ImageView backBtnWallet;
    private EditText inputAmountWallet;
    private Button proceedBtnWallet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_wallet);

        backBtnWallet = (ImageView)findViewById(R.id.back_btn_wallet_ac);
        inputAmountWallet = (EditText)findViewById(R.id.Amount_input_wallet);
        proceedBtnWallet = (Button)findViewById(R.id.proceed_btn_wallet);

        backBtnWallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WalletActivity.this, DashBoardActivity.class));
                finish();
            }
        });

        proceedBtnWallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_amountInput = inputAmountWallet.getText().toString().trim();

                if (str_amountInput.isEmpty()) {
                    inputAmountWallet.setError("Please enter amount!");
                    inputAmountWallet.requestFocus();
                    return;
                }
                else if (str_amountInput.equals("0")) {
                    inputAmountWallet.setError("Enter valid amount!");
                    inputAmountWallet.requestFocus();
                    return;
                }
                else if (str_amountInput.equals("00")) {
                    inputAmountWallet.setError("Enter valid amount!");
                    inputAmountWallet.requestFocus();
                    return;
                }
                else if (str_amountInput.equals("000")) {
                    inputAmountWallet.setError("Enter valid amount!");
                    inputAmountWallet.requestFocus();
                    return;
                }
                else if (str_amountInput.equals("0000")) {
                    inputAmountWallet.setError("Enter valid amount!");
                    inputAmountWallet.requestFocus();
                    return;
                }
                else {
                    Intent intent = new Intent(WalletActivity.this, LoaderActivityTwo.class);
                    intent.putExtra("keyAmount", str_amountInput);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }
}