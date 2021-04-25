package com.example.cryptotd_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;

public class jual_yfi extends AppCompatActivity {

    private Button btnJual,btnKembali;
    private EditText editTextjualyfi;
    private TextView sisasaldokoin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jual_yfi);

        editTextjualyfi = findViewById(R.id.editTextjualyfi);
        btnKembali = findViewById(R.id.btnKembali);
        btnJual = findViewById(R.id.btnJual);
        sisasaldokoin = findViewById(R.id.sisasaldokoin);


        Intent intent = getIntent();
        String sisasaldo1 = intent.getStringExtra("jualyfi");
        float sisasaldonew = 1;
        if (sisasaldo1 == null) {
            sisasaldokoin.setText("1 YFI");
        }else{
            Float sisasaldo = Float.parseFloat(sisasaldo1);
            sisasaldonew = sisasaldonew - sisasaldo;
            sisasaldokoin.setText(""+sisasaldonew+" YFI");
        }
    }

    public void jualyfi1 (View v){
        boolean temp = true;
        NumberFormat rupiah = NumberFormat.getCurrencyInstance(new Locale("in","ID"));
        String jualyfi = editTextjualyfi.getText().toString();
        Intent intent = new Intent(this, jual_yfi.class);

        if (jualyfi.equals("")) {
            editTextjualyfi.setError("Nominal Pembelian wajib diisi");
        } else {
            float jumlah = Float.parseFloat(jualyfi); // konversi string ke float
            if (jumlah > 1) { // 1 ini nanti diubah ke saldo koin aktif
                editTextjualyfi.setError("Nominal Pembelian melebihi saldo");
            } else {
                float hasil = jumlah * 728150000; // nominal harga jual
                float sisasaldo = 1- jumlah;  // sisasaldo yang dibagian jual nanti diubah
                intent.putExtra("jualyfi",jualyfi);
                Toast.makeText(this,
                        "Anda mendapatkan IDR sebesar  : "+rupiah.format(hasil)+ "\nSaldo saat ini : "+sisasaldo+" YFI",
                        Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        }

    }
    public void kembali11 (View v){
        Intent intent = new Intent(this, jualbeli_yfi.class);
        startActivity(intent);

    }
}