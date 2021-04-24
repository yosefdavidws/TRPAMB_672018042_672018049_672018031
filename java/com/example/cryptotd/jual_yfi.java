package com.example.cryptotd_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class jual_yfi extends AppCompatActivity {

    private Button btnJual,btnKembali;
    private EditText editTextjualyfi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jual_yfi);

        editTextjualyfi = findViewById(R.id.editTextjualyfi);
        btnKembali = findViewById(R.id.btnKembali);
        btnJual = findViewById(R.id.btnJual);
    }

    public void jualyfi1 (View v){
        boolean temp = true;
        String jualyfi = editTextjualyfi.getText().toString();
        Intent intent = new Intent(this, MainActivity.class);

        if (jualyfi.equals("")) {
            editTextjualyfi.setError("Nominal Pembelian wajib diisi");
        } else {
            float jumlah = Float.parseFloat(jualyfi); // konversi string ke float
            if (jumlah > 5) { // 5 ini nanti diubah ke saldo koin aktif
                editTextjualyfi.setError("Nominal Pembelian melebihi saldo");
            } else {
                float hasil = jumlah * 728150000; // nominal harga jual
                float sisasaldo = jumlah*728150000;  // sisasaldo yang dibagian jual nanti diubah
                Toast.makeText(this,
                        "Anda mendapatkan IDR sebesar  = Rp. " + hasil + "\nSaldo saat ini = Rp." + sisasaldo,
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