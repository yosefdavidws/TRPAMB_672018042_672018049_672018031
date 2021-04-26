package com.example.cryptotd_2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Locale;

public class akun extends AppCompatActivity {
    Button Logout,bahasa;
    TextView userEmail;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akun);
        loadLocale();
        userEmail = findViewById(R.id.username);
        firebaseAuth =firebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        userEmail.setText(firebaseUser.getEmail());
        Logout = findViewById(R.id.btn_keluar);
        bahasa = findViewById(R.id.btn_bahasa);
        ActionBar actionBar = getSupportActionBar();
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(akun.this, login.class);
                startActivity(intent);
            }
        });
        bahasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showChangeLanguageDialog();
            }
        });
    }private void  showChangeLanguageDialog() {
        final String[] ListItems = {"English","Indonesia"};
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(akun.this);
        mBuilder.setTitle("Choose Language");
        mBuilder.setSingleChoiceItems(ListItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    setLocale("en");
                    recreate();
                }
                else if (i == 1) {
                    setLocale("in");
                    recreate();
                }
                dialogInterface.dismiss();


            }
        });
        AlertDialog mDialog = mBuilder.create();
        mDialog.show();
    }

    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext() .getResources() .getDisplayMetrics());
        //Save data
        SharedPreferences.Editor editor = getSharedPreferences("Settings",MODE_PRIVATE).edit();
        editor.putString("My_Lang",lang);
        editor.apply();

    }
    public  void  loadLocale(){
        SharedPreferences prefs = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = prefs.getString("My_Lang","");
        setLocale(language);
    }
}
