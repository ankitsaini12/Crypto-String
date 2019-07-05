package com.test.cryptostring;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnEncrypt, btnDecrypt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Crypto String");
        }
        init();
        setListener();
    }


    private void init() {
        btnEncrypt = findViewById(R.id.btnEncrypt);
        btnDecrypt = findViewById(R.id.btnDecrypt);
    }


    private void setListener() {
        btnEncrypt.setOnClickListener(this);
        btnDecrypt.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnEncrypt:{
                Intent intent = new Intent(this, EncryptActivity.class);
                startActivity(intent);
                break;
            }

            case R.id.btnDecrypt:{
                Intent intent = new Intent(this, DecryptActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}
