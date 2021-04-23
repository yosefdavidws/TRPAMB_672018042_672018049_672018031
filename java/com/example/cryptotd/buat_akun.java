package com.example.cryptotd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.View;
import android.widget.TextView;

public class buat_akun extends AppCompatActivity {

    private TextView txt_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_akun);

        txt_view = findViewById(R.id.login_ahref);
       // txt_view.setMovementMethod(LinkMovementMethod.getInstance());
        Linkify.addLinks(txt_view, Linkify.ALL);
    }

    public void txt_login(View view) {
        Intent intent = new Intent(this, login_register.class);
        startActivity(intent);
    }
}