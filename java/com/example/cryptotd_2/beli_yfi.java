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

public class beli_yfi extends AppCompatActivity {

    private Button btnBeli,btnKembali;
    private EditText editTextbeliyfi;
    private TextView sisasaldorp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beli_yfi);
        NumberFormat rupiah = NumberFormat.getCurrencyInstance(new Locale("in","ID"));

        editTextbeliyfi = findViewById(R.id.editTextbeliyfi);
        btnKembali = findViewById(R.id.btnKembali);
        btnBeli = findViewById(R.id.btnBeli);
        sisasaldorp = findViewById(R.id.sisasaldorp);

        Intent intent = getIntent();
        String sisasaldo1 = intent.getStringExtra("beliyfi");
        float sisasaldonew = 10000000;
        if (sisasaldo1 == null) {
            sisasaldorp.setText("Rp.10.000.000");
        }else{
            Float sisasaldo = Float.parseFloat(sisasaldo1);
            sisasaldonew = sisasaldonew - sisasaldo;
            sisasaldorp.setText(rupiah.format(sisasaldonew));
        }

    }
    public void beliyfi1 (View v){
        boolean temp = true;
        NumberFormat rupiah = NumberFormat.getCurrencyInstance(new Locale("in","ID"));
        String beliyfi = editTextbeliyfi.getText().toString();
        Intent intent = new Intent(this, beli_yfi.class);


        if (beliyfi.equals("")) {
            editTextbeliyfi.setError("Nominal Pembelian wajib diisi");
        } else {
            float jumlah = Float.parseFloat(beliyfi); // konversi string ke float
            if (jumlah > 10000000) {
                editTextbeliyfi.setError("Nominal Pembelian melebihi saldo");
            } else {
                float hasil = jumlah / 38540000;
                float sisasaldo = 10000000 - jumlah;  // 10.000.000 nanti diubah ke textview
                intent.putExtra("beliyfi",beliyfi);
                Toast.makeText(this,
                        "Anda mendapatkan YFI sebesar  = " + hasil + " YFI \nSisa Saldo = "+rupiah.format(sisasaldo),
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