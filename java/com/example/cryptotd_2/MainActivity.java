package com.example.cryptotd_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin,btnLogin2, btnLogin3, btnLogin4, btnLogin5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnLogin);
        btnLogin2 = findViewById(R.id.btnLogin2);
        btnLogin3 = findViewById(R.id.btnLogin3);
        btnLogin4 = findViewById(R.id.btnLogin4);
        btnLogin5 = findViewById(R.id.btnLogin5);

        Intent intent = getIntent();
        String belibtc = intent.getStringExtra("belibtc");
        intent.putExtra("belibtc",belibtc);



    }
    public void btcc (View v){
        Intent intent = new Intent(this, jualbeli_btc.class);

        MainActivity.this.startActivity(intent);

    }
    public void eth (View v){
        Intent intent = new Intent(this, jualbeli_eth.class);
        startActivity(intent);

    }
    public void bnb (View v){
        Intent intent = new Intent(this, jualbeli_bnb.class);
        startActivity(intent);

    }
    public void link (View v){
        Intent intent = new Intent(this, jualbeli_link.class);
        startActivity(intent);

    }
    public void yfi (View v){
        Intent intent = new Intent(this, jualbeli_yfi.class);
        startActivity(intent);

    }

}