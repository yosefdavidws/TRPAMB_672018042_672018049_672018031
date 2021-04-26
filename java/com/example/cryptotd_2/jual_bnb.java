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

public class jual_bnb extends AppCompatActivity {

    private Button btnJual,btnKembali;
    private EditText editTextjualbnb;
    private TextView sisasaldokoin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jual_bnb);

        editTextjualbnb = findViewById(R.id.editTextjualbnb);
        btnKembali = findViewById(R.id.btnKembali);
        btnJual = findViewById(R.id.btnJual);
        sisasaldokoin = findViewById(R.id.sisasaldokoin);

        Intent intent = getIntent();
        String sisasaldo1 = intent.getStringExtra("jualbnb");
        float sisasaldonew =  3;
        if (sisasaldo1 == null) {
            sisasaldokoin.setText("3 BNB");
        }else{
            Float sisasaldo = Float.parseFloat(sisasaldo1);
            sisasaldonew = sisasaldonew - sisasaldo;
            sisasaldokoin.setText(""+sisasaldonew+" BNB");
        }
    }

    public void jualbnb1 (View v){
        NumberFormat rupiah = NumberFormat.getCurrencyInstance(new Locale("in","ID"));
        boolean temp = true;
        String jualbnb = editTextjualbnb.getText().toString();
        Intent intent = new Intent(this, jual_bnb.class);

        if (jualbnb.equals("")) {
            editTextjualbnb.setError("Nominal Pembelian wajib diisi");
        } else {
            float jumlah = Float.parseFloat(jualbnb); // konversi string ke float
            if (jumlah > 3) { // 3.5 ini nanti diubah ke saldo koin aktif
                editTextjualbnb.setError("Nominal Pembelian melebihi saldo");
            } else {
                float hasil = jumlah * 8150200; // nominal harga jual
                float sisasaldo = 3 - jumlah;  // sisasaldo yang dibagian jual nanti diubah
                intent.putExtra("jualbnb",jualbnb);
                Toast.makeText(this,
                        "Anda mendapatkan IDR sebesar  = "+rupiah.format(hasil) + "\nSaldo saat ini = " +sisasaldo+" BNB",
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