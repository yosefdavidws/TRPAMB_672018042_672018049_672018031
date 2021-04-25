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

public class beli_eth extends AppCompatActivity {

    private Button btnBeli,btnKembali;
    private EditText editTextbelieth;
    private TextView sisasaldorp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beli_eth);
        NumberFormat rupiah = NumberFormat.getCurrencyInstance(new Locale("in", "ID"));

        sisasaldorp = findViewById(R.id.sisasaldorp);
        editTextbelieth = findViewById(R.id.editTextbelieth);
        btnKembali = findViewById(R.id.btnKembali);
        btnBeli = findViewById(R.id.btnBeli);


        Intent intent = getIntent();
        String sisasaldo1 = intent.getStringExtra("belieth");
        float sisasaldonew = 10000000;
        if (sisasaldo1 == null) {
            sisasaldorp.setText("Rp.10.000.000");
        }else{
            Float sisasaldo = Float.parseFloat(sisasaldo1);
            sisasaldonew = sisasaldonew - sisasaldo;
            sisasaldorp.setText(rupiah.format(sisasaldonew));
        }
    }

    public void belieth1 (View v){
        boolean temp = true;
        NumberFormat rupiah = NumberFormat.getCurrencyInstance(new Locale("in","ID"));
        String belieth = editTextbelieth.getText().toString();
        Intent intent = new Intent(this, beli_eth.class);

        if (belieth.equals("")) {
            editTextbelieth.setError("Nominal Pembelian wajib diisi");
        } else {
            float jumlah = Float.parseFloat(belieth); // konversi string ke float
            if (jumlah > 10000000) {
                editTextbelieth.setError("Nominal Pembelian melebihi saldo");
            } else {
                float hasil = jumlah / 38540000;
                float saldo = 10000000 - jumlah;  // 10.000.000 nanti diubah ke textview
                intent.putExtra("belieth",belieth);
                Toast.makeText(this,
                        "Anda mendapatkan ETH sebesar  = " + hasil + " ETH \nSisa Saldo = "+rupiah.format(saldo),
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