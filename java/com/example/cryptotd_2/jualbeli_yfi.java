package com.example.cryptotd_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class jualbeli_yfi extends AppCompatActivity {

    private Button btnKembali, btnBeli, btnJual;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jualbeli_yfi);

        btnKembali = findViewById(R.id.btnKembali);
        btnBeli = findViewById(R.id.btnBeli);
        btnJual = findViewById(R.id.btnJual);
    }

    public void kembali1 (View v){
        Intent intent = new Intent(this, home.class);
        startActivity(intent);

    }
    public void beliyfi (View v){
        Intent intent = new Intent(this, beli_yfi.class);
        startActivity(intent);

    }
    public void jualyfi (View v) {
        Intent intent = new Intent(this, jual_yfi.class);
        startActivity(intent);
    }
}