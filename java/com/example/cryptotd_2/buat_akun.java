package com.example.cryptotd_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class buat_akun extends AppCompatActivity {
    EditText email ;
    EditText password, confirmpassword;
    Button register;
    FirebaseAuth firebaseAuth;
    private TextView txt_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_akun);
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseApp.initializeApp(this);
        email = findViewById(R.id.username);
        password = findViewById(R.id.createpassword);
        confirmpassword = findViewById(R.id.confirmpassword);
        register = findViewById(R.id.btn_daftar);
        txt_view = findViewById(R.id.login_ahref);
        // txt_view.setMovementMethod(LinkMovementMethod.getInstance());
        Linkify.addLinks(txt_view, Linkify.ALL);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(buat_akun.this, "Registered successfully", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(buat_akun.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            
        });
    }

    public void txt_login(View view) {
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    }
}