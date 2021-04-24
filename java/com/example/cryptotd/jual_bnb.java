package com.example.cryptotd_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class jual_bnb extends AppCompatActivity {

    private Button btnJual,btnKembali;
    private EditText editTextjualbnb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jual_bnb);

        editTextjualbnb = findViewById(R.id.editTextjualbnb);
        btnKembali = findViewById(R.id.btnKembali);
        btnJual = findViewById(R.id.btnJual);
    }

    public void jualbnb1 (View v){
        boolean temp = true;
        String jualbnb = editTextjualbnb.getText().toString();
        Intent intent = new Intent(this, MainActivity.class);

        if (jualbnb.equals("")) {
            editTextjualbnb.setError("Nominal Pembelian wajib diisi");
        } else {
            float jumlah = Float.parseFloat(jualbnb); // konversi string ke float
            if (jumlah > 5) { // 5 ini nanti diubah ke saldo koin aktif
                editTextjualbnb.setError("Nominal Pembelian melebihi saldo");
            } else {
                float hasil = jumlah * 8150200; // nominal harga jual
                float sisasaldo = jumlah*8150200;  // sisasaldo yang dibagian jual nanti diubah
                Toast.makeText(this,
                        "Anda mendapatkan IDR sebesar  = Rp. " + hasil + "\nSaldo saat ini = Rp." + sisasaldo,
                        Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        }

    }
    public void kembali11 (View v){
        Intent intent = new Intent(this, jualbeli_bnb.class);
        startActivity(intent);

    }
}