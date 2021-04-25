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

public class jual_link extends AppCompatActivity {

    private Button btnJual,btnKembali;
    private EditText editTextjuallink;
    private TextView sisasaldokoin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jual_link);

        editTextjuallink = findViewById(R.id.editTextjuallink);
        btnKembali = findViewById(R.id.btnKembali);
        btnJual = findViewById(R.id.btnJual);
        sisasaldokoin = findViewById(R.id.sisasaldokoin);

        Intent intent = getIntent();
        String sisasaldo1 = intent.getStringExtra("juallink");
        float sisasaldonew = 10;
        if (sisasaldo1 == null) {
            sisasaldokoin.setText("10 LINK");
        }else{
            Float sisasaldo = Float.parseFloat(sisasaldo1);
            sisasaldonew = sisasaldonew - sisasaldo;
            sisasaldokoin.setText(""+sisasaldonew+" LINK");
        }


    }

    public void juallink1 (View v){
        boolean temp = true;
        NumberFormat rupiah = NumberFormat.getCurrencyInstance(new Locale("in","ID"));
        String juallink = editTextjuallink.getText().toString();
        Intent intent = new Intent(this, jual_link.class);

        if (juallink.equals("")) {
            editTextjuallink.setError("Nominal Pembelian wajib diisi");
        } else {
            float jumlah = Float.parseFloat(juallink); // konversi string ke float
            if (jumlah > 10) { // 10 ini nanti diubah ke saldo koin aktif
                editTextjuallink.setError("Nominal Pembelian melebihi saldo");
            } else {
                float hasil = jumlah * 581600; // nominal harga jual
                float sisasaldo = 10- jumlah;  // sisasaldo yang dibagian jual nanti diubah
                intent.putExtra("juallink",juallink);
                Toast.makeText(this,
                        "Anda mendapatkan IDR sebesar  : "+rupiah.format(hasil)+ "\nSaldo saat ini : "+sisasaldo+" LINK",
                        Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        }

    }
    public void kembali11 (View v){
        Intent intent = new Intent(this, jualbeli_link.class);
        startActivity(intent);

    }
}