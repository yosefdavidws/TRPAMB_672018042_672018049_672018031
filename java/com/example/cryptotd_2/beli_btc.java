package com.example.cryptotd_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.icu.util.ULocale;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;


import java.text.NumberFormat;
import java.util.Locale;

public class beli_btc extends AppCompatActivity {

    private Button btnBeli,btnKembali;
    private EditText editTextbelibtc;

    private ProgressDialog loading;
    private TextView sisasaldorp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beli_btc);

        NumberFormat rupiah = NumberFormat.getCurrencyInstance(new Locale("in", "ID"));

        editTextbelibtc = findViewById(R.id.editTextbelibtc);
        btnKembali = findViewById(R.id.btnKembali);
        sisasaldorp = findViewById(R.id.sisasaldorp);
        btnBeli = findViewById(R.id.btnBeli);





        Intent intent = getIntent();
        String sisasaldo1 = intent.getStringExtra("belibtc");
        float sisasaldonew = 10000000;
        if (sisasaldo1 == null) {
            sisasaldorp.setText("Rp.10.000.000");
        }else{
            Float sisasaldo = Float.parseFloat(sisasaldo1);
            sisasaldonew = sisasaldonew - sisasaldo;
            sisasaldorp.setText(rupiah.format(sisasaldonew));
        }
    }


    public void belibtc1 (View v) {
        boolean temp = true;
        NumberFormat rupiah = NumberFormat.getCurrencyInstance(new Locale("in","ID"));
        String belibtc = editTextbelibtc.getText().toString();
        Intent intent = new Intent(this, beli_btc.class);


        if (belibtc.equals("")) {
            editTextbelibtc.setError("Nominal Pembelian wajib diisi");
        } else {
            float jumlah = Float.parseFloat(belibtc); // konversi string ke float
            if (jumlah > 10000000) {
                editTextbelibtc.setError("Nominal Pembelian melebihi saldo");
            } else {
                float hasil = jumlah / 817772000;
                float sisasaldo = 10000000 - jumlah;  // 10.000.000 nanti diubah ke textview
                intent.putExtra("belibtc",belibtc);
                intent.putExtra("jumlah",jumlah);


                Toast.makeText(this,
                        "Anda mendapatkan BTC sebesar  = " + hasil + " BTC \nSisa Saldo = " +rupiah.format(sisasaldo),
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