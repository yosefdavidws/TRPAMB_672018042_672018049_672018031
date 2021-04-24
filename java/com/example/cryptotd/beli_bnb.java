package com.example.cryptotd_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class beli_bnb extends AppCompatActivity {

    private Button btnBeli,btnKembali;
    private EditText editTextbelibnb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beli_bnb);

        editTextbelibnb = findViewById(R.id.editTextbelibnb);
        btnKembali = findViewById(R.id.btnKembali);
        btnBeli = findViewById(R.id.btnBeli);
    }

    public void belibnb1 (View v) {
        boolean temp = true;
        String belibnb = editTextbelibnb.getText().toString();
        Intent intent = new Intent(this, MainActivity.class);

        if (belibnb.equals("")) {
            editTextbelibnb.setError("Nominal Pembelian wajib diisi");
        } else {
            float jumlah = Float.parseFloat(belibnb); // konversi string ke float
            if (jumlah > 10000000) {
                editTextbelibnb.setError("Nominal Pembelian melebihi saldo");
            } else {
                float hasil = jumlah / 8226554;
                float saldo = 10000000 - jumlah;  // 10.000.000 nanti diubah ke textview
                Toast.makeText(this,
                        "Anda mendapatkan BNB sebesar  = " + hasil + " BNB \nSisa Saldo = Rp." + saldo,
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