package com.example.cryptotd_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class home extends AppCompatActivity {

    private Button btnkemain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    }


    public void btn_home(View v) {
        Intent intent = new Intent(this, home.class);
        startActivity(intent);
    }

    public void btn_berita(View v) {
        Intent intent = new Intent(this, berita.class);
        startActivity(intent);
    }

    public void btn_akun (View v) {
        Intent intent = new Intent(this, akun.class);
        startActivity(intent);
    }

    public void btn_wallet(View v) {
        Intent intent = new Intent(this, wallet.class);
        startActivity(intent);
    }

    public void btn_btcc(View v) {
        Intent intent = new Intent(this, jualbeli_btc.class);
        startActivity(intent);
    }

    public void btn_eth(View v) {
        Intent intent = new Intent(this, jualbeli_eth.class);
        startActivity(intent);
    }

    public void btn_bnb(View v) {
        Intent intent = new Intent(this, jualbeli_bnb.class);
        startActivity(intent);
    }

    public void btn_link(View v) {
        Intent intent = new Intent(this, jualbeli_link.class);
        startActivity(intent);
    }
    public void btn_yfi(View v) {
        Intent intent = new Intent(this, jualbeli_yfi.class);
        startActivity(intent);
    }
}