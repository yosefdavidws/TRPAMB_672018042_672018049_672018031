package com.example.cryptotd_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class jual_eth extends AppCompatActivity {

    private Button btnJual,btnKembali;
    private EditText editTextjualeth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jual_eth);

        editTextjualeth = findViewById(R.id.editTextjualeth);
        btnKembali = findViewById(R.id.btnKembali);
        btnJual = findViewById(R.id.btnJual);
    }

    public void jualeth1 (View v){
        boolean temp = true;
        String jualeth= editTextjualeth.getText().toString();
        Intent intent = new Intent(this, MainActivity.class);

        if (jualeth.equals("")) {
            editTextjualeth.setError("Nominal Pembelian wajib diisi");
        } else {
            float jumlah = Float.parseFloat(jualeth); // konversi string ke float
            if (jumlah > 5) { // 5 ini nanti diubah ke saldo koin aktif
                editTextjualeth.setError("Nominal Pembelian melebihi saldo");
            } else {
                float hasil = jumlah * 37840000; // nominal harga jual
                float sisasaldo = jumlah*37840000;  // sisasaldo yang dibagian jual nanti diubah
                Toast.makeText(this,
                        "Anda mendapatkan IDR sebesar  = Rp. " + hasil + "\nSaldo saat ini = Rp." + sisasaldo,
                        Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        }
    }
    public void kembali11 (View v){
        Intent intent = new Intent(this, jualbeli_eth.class);
        startActivity(intent);

    }
}