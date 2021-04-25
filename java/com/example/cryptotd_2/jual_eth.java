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

public class jual_eth extends AppCompatActivity {

    private Button btnJual,btnKembali;
    private EditText editTextjualeth;
    private TextView sisasaldokoin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jual_eth);

        editTextjualeth = findViewById(R.id.editTextjualeth);
        btnKembali = findViewById(R.id.btnKembali);
        btnJual = findViewById(R.id.btnJual);
        sisasaldokoin = findViewById(R.id.sisasaldokoin);


        Intent intent = getIntent();
        String sisasaldo1 = intent.getStringExtra("jualeth");
        float sisasaldonew = 5;
        if (sisasaldo1 == null) {
            sisasaldokoin.setText("5 ETH");
        }else{
            Float sisasaldo = Float.parseFloat(sisasaldo1);
            sisasaldonew = sisasaldonew - sisasaldo;
            sisasaldokoin.setText(""+sisasaldonew+" ETH");
        }
    }

    public void jualeth1 (View v){
        NumberFormat rupiah = NumberFormat.getCurrencyInstance(new Locale("in","ID"));
        boolean temp = true;
        String jualeth= editTextjualeth.getText().toString();
        Intent intent = new Intent(this, jual_eth.class);

        if (jualeth.equals("")) {
            editTextjualeth.setError("Nominal Pembelian wajib diisi");
        } else {
            float jumlah = Float.parseFloat(jualeth); // konversi string ke float
            if (jumlah > 5) { // 5 ini nanti diubah ke saldo koin aktif
                editTextjualeth.setError("Nominal Pembelian melebihi saldo");
            } else {
                float hasil = jumlah * 37840000; // nominal harga jual
                float sisasaldo = 5 - jumlah;  // sisasaldo yang dibagian jual nanti diubah
                intent.putExtra("jualeth",jualeth);
                Toast.makeText(this,
                        "Anda mendapatkan IDR sebesar  : "+rupiah.format(hasil) + "\nSaldo saat ini : "+sisasaldo+" ETH",
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