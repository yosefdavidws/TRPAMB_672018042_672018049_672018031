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

public class jual_btc extends AppCompatActivity {

    private Button btnJual,btnKembali;
    private EditText editTextjualbtc;
    private TextView sisasaldokoin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jual_btc);

        editTextjualbtc = findViewById(R.id.editTextjualbtc);
        btnKembali = findViewById(R.id.btnKembali);
        btnJual = findViewById(R.id.btnJual);
        sisasaldokoin = findViewById(R.id.sisasaldokoin);

        Intent intent = getIntent();
        String sisasaldo1 = intent.getStringExtra("jualbtc");
        float sisasaldonew = 1;
        if (sisasaldo1 == null) {
            sisasaldokoin.setText("1 BTC");
        }else{
            Float sisasaldo = Float.parseFloat(sisasaldo1);
            sisasaldonew = sisasaldonew - sisasaldo;
            sisasaldokoin.setText(""+sisasaldonew+" BTC");
        }


    }
    public void jualbtc1 (View v){
        boolean temp = true;
        NumberFormat rupiah = NumberFormat.getCurrencyInstance(new Locale("in","ID"));
        String jualbtc = editTextjualbtc.getText().toString();
        Intent intent = new Intent(this, jual_btc.class);

        if (jualbtc.equals("")) {
            editTextjualbtc.setError("Nominal Pembelian wajib diisi");
        } else {
            float jumlah = Float.parseFloat(jualbtc); // konversi string ke float
            if (jumlah > 1) { // 1 ini nanti diubah ke saldo koin aktif
                editTextjualbtc.setError("Nominal Pembelian melebihi saldo");
            } else {
                float hasil =  jumlah*817772000; // nominal harga jual
                float sisasaldo = 1-jumlah;  // sisasaldo yang dibagian jual nanti diubah
                intent.putExtra("jualbtc",jualbtc);
                Toast.makeText(this,
                        "Anda mendapatkan IDR sebesar  = "+rupiah.format(hasil) + "\nSaldo saat ini = "+sisasaldo+" BTC",
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