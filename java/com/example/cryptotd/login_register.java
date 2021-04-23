package com.example.cryptotd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class login_register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);
    }

    public void txt_buatakun(View view){
        Intent intent = new Intent(this, buat_akun.class);
        startActivity(intent);
    }
}