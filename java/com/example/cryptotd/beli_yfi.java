package com.example.cryptotd_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class beli_yfi extends AppCompatActivity {

    private Button btnBeli,btnKembali;
    private EditText editTextbeliyfi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beli_yfi);

        editTextbeliyfi = findViewById(R.id.editTextbeliyfi);
        btnKembali = findViewById(R.id.btnKembali);
        btnBeli = findViewById(R.id.btnBeli);
    }
    public void beliyfi1 (View v){
        boolean temp = true;
        String beliyfi = editTextbeliyfi.getText().toString();
        Intent intent = new Intent(this, MainActivity.class);

        if (beliyfi.equals("")) {
            editTextbeliyfi.setError("Nominal Pembelian wajib diisi");
        } else {
            float jumlah = Float.parseFloat(beliyfi); // konversi string ke float
            if (jumlah > 10000000) {
                editTextbeliyfi.setError("Nominal Pembelian melebihi saldo");
            } else {
                float hasil = jumlah / 38540000;
                float saldo = 10000000 - jumlah;  // 10.000.000 nanti diubah ke textview
                Toast.makeText(this,
                        "Anda mendapatkan BNB sebesar  = " + hasil + " ETH \nSisa Saldo = Rp." + saldo,
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