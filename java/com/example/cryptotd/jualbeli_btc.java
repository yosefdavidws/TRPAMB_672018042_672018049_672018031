package com.example.cryptotd_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class jualbeli_btc extends AppCompatActivity {

    private Button btnKembali, btnBeli, btnJual;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jualbeli_btc);

        btnKembali = findViewById(R.id.btnKembali);
        btnBeli = findViewById(R.id.btnBeli);
        btnJual = findViewById(R.id.btnJual);


    }
    public void belibtc (View v){
        Intent intent = new Intent(this, beli_btc.class);
        startActivity(intent);

    }
    public void jualbtc (View v) {
        Intent intent = new Intent(this, jual_btc.class);
        startActivity(intent);
    }

    public void kembali1 (View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}