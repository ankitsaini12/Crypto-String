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

public class DecryptActivity extends AppCompatActivity implements View.OnClickListener {

    private AppCompatEditText edtDecryptString;
    private Button btnSubmit;
    private TextView tvDecrypt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decrypt);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Decryption");
        }
        init();
        setListener();
    }

    private void init() {
        edtDecryptString = findViewById(R.id.edtDecryptString);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvDecrypt = findViewById(R.id.tvDecrypt);
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
        switch (view.getId()){
            case R.id.btnSubmit:{
                if (!TextUtils.isEmpty(edtDecryptString.getText().toString())){
                    tvDecrypt.setText(decryptString(edtDecryptString.getText().toString()));
                }else{
                    Toast.makeText(this,"Please enter the string",Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }
    }

    private static String decryptString(String input) {
        char[] inputArr = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<inputArr.length; i++ ) {
            if (i < inputArr.length-1 ) {
                if(String.valueOf(inputArr[i]).equalsIgnoreCase(" ")) {
                    sb.append(" ");
                }else {
                    if(((int)inputArr[i])>48 && ((int)inputArr[i])<=57) {
                        for(int j =0;j< Integer.parseInt(String.valueOf(inputArr[i])); j++) {
                            sb.append(inputArr[i-1]);
                        }
                    }
                }
            }else {
                if(((int)inputArr[i])>48 && ((int)inputArr[i])<=57) {
                    for(int j =0;j< Integer.parseInt(String.valueOf(inputArr[i])); j++) {
                        sb.append(inputArr[i-1]);
                    }
                }
            }
        }
        return sb.toString();
    }
}
