package com.example.cryptotd_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class beli_btc extends AppCompatActivity {

    private Button btnBeli,btnKembali;
    private EditText editTextbelibtc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beli_btc);

        editTextbelibtc = findViewById(R.id.editTextbelibtc);
        btnKembali = findViewById(R.id.btnKembali);
        btnBeli = findViewById(R.id.btnBeli);
    }
    public void belibtc1 (View v) {
        boolean temp = true;
        String belibtc = editTextbelibtc.getText().toString();
        Intent intent = new Intent(this, MainActivity.class);

        if (belibtc.equals("")) {
            editTextbelibtc.setError("Nominal Pembelian wajib diisi");
        } else {
            float jumlah = Float.parseFloat(belibtc); // konversi string ke float
            if (jumlah > 10000000) {
                editTextbelibtc.setError("Nominal Pembelian melebihi saldo");
            } else {
                float hasil = jumlah / 817772000;
                float sisasaldo = 10000000 - jumlah;  // 10.000.000 nanti diubah ke textview
                Toast.makeText(this,
                        "Anda mendapatkan BTC sebesar  = " + hasil + " BTC \nSisa Saldo = Rp." + sisasaldo,
                        Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        }
    }
    public void kembali11 (View v){
        Intent intent = new Intent(this, jualbeli_btc.class);
        startActivity(intent);

    }
}