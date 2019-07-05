package com.test.cryptostring;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class EncryptActivity extends AppCompatActivity implements View.OnClickListener {

    private AppCompatEditText edtEncryptString;
    private Button btnSubmit;
    private TextView tvEncrypt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encrypt);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Encryption");
        }
        init();
        setListener();
    }

    private void init() {
        edtEncryptString = findViewById(R.id.edtEncryptString);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvEncrypt = findViewById(R.id.tvEncrypt);
    }

    private void setListener() {
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean isSuccess = false;
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            isSuccess = true;
        }
        return isSuccess;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSubmit: {
                if (!TextUtils.isEmpty(edtEncryptString.getText().toString())) {
                    tvEncrypt.setText(encryptString(edtEncryptString.getText().toString()));
                } else {
                    Toast.makeText(this, "Please enter the string", Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }
    }

    private String encryptString(String input) {
        char[] inputArr = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 0; i < inputArr.length; i++) {
            if (i < inputArr.length - 1) {
                if (inputArr[i] == inputArr[i + 1]) {
                    count++;
                    continue;
                } else {
                    sb.append(inputArr[i]);
                    sb.append(count);
                    count = 1;
                }
            } else {
                sb.append(inputArr[i]);
                sb.append(count);
                count = 1;
            }
        }
        return sb.toString();

    }
}
