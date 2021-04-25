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

public class beli_bnb extends AppCompatActivity {

    private Button btnBeli,btnKembali;
    private EditText editTextbelibnb;
    private TextView sisasaldorp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beli_bnb);
        NumberFormat rupiah = NumberFormat.getCurrencyInstance(new Locale("in", "ID"));

        editTextbelibnb = findViewById(R.id.editTextbelibnb);
        btnKembali = findViewById(R.id.btnKembali);
        btnBeli = findViewById(R.id.btnBeli);
        sisasaldorp = findViewById(R.id.sisasaldorp);

        Intent intent = getIntent();
        String sisasaldo1 = intent.getStringExtra("belibnb");
        float sisasaldonew = 10000000;
        if (sisasaldo1 == null) {
            sisasaldorp.setText("Rp.10.000.000");
        }else{
            Float sisasaldo = Float.parseFloat(sisasaldo1);
            sisasaldonew = sisasaldonew - sisasaldo;
            sisasaldorp.setText(rupiah.format(sisasaldonew));
        }
    }

    public void belibnb1 (View v) {
        boolean temp = true;
        NumberFormat rupiah = NumberFormat.getCurrencyInstance(new Locale("in","ID"));
        String belibnb = editTextbelibnb.getText().toString();
        Intent intent = new Intent(this, beli_bnb.class);

        if (belibnb.equals("")) {
            editTextbelibnb.setError("Nominal Pembelian wajib diisi");
        } else {
            float jumlah = Float.parseFloat(belibnb); // konversi string ke float
            if (jumlah > 10000000) {
                editTextbelibnb.setError("Nominal Pembelian melebihi saldo");
            } else {
                float hasil = jumlah / 8226554;
                float sisasaldo = 10000000 - jumlah;  // 10.000.000 nanti diubah ke textview
                intent.putExtra("belibnb",belibnb);
                Toast.makeText(this,
                        "Anda mendapatkan BNB sebesar  = " + hasil + " BNB \nSisa Saldo = "+rupiah.format(sisasaldo),
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