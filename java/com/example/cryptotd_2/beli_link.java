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

public class beli_link extends AppCompatActivity {

    private Button btnBeli,btnKembali;
    private EditText editTextbelilink;
    private TextView sisasaldorp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beli_link);
        NumberFormat rupiah = NumberFormat.getCurrencyInstance(new Locale("in", "ID"));

        editTextbelilink = findViewById(R.id.editTextbelieth);
        btnKembali = findViewById(R.id.btnKembali);
        btnBeli = findViewById(R.id.btnBeli);
        sisasaldorp = findViewById(R.id.sisasaldorp);

        Intent intent = getIntent();
        String sisasaldo1 = intent.getStringExtra("belilink");
        float sisasaldonew = 10000000;
        if (sisasaldo1 == null) {
            sisasaldorp.setText("Rp.10.000.000");
        }else{
            Float sisasaldo = Float.parseFloat(sisasaldo1);
            sisasaldonew = sisasaldonew - sisasaldo;
            sisasaldorp.setText(rupiah.format(sisasaldonew));
        }
    }

    public void belilink1 (View v){
        boolean temp = true;
        NumberFormat rupiah = NumberFormat.getCurrencyInstance(new Locale("in","ID"));
        String belilink = editTextbelilink.getText().toString();
        Intent intent = new Intent(this, beli_link.class);

        if (belilink.equals("")) {
            editTextbelilink.setError("Nominal Pembelian wajib diisi");
        } else {
            float jumlah = Float.parseFloat(belilink); // konversi string ke float
            if (jumlah > 10000000) {
                editTextbelilink.setError("Nominal Pembelian melebihi saldo");
            } else {
                float hasil = jumlah / 38540000;
                float sisasaldo = 10000000 - jumlah;  // 10.000.000 nanti diubah ke textview
                intent.putExtra("belilink",belilink);
                Toast.makeText(this,
                        "Anda mendapatkan LINK sebesar  = " + hasil + " LINK \nSisa Saldo = "+rupiah.format(sisasaldo),
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