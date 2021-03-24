package com.dut2.projetappmobile;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Inscription extends AppCompatActivity {

    EditText name, email, password;
    Button inscrire;
    SQLiteHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inscription_main);

        name = findViewById(R.id.editTextName);
        password = findViewById(R.id.editTextTextPassword);
        email = findViewById(R.id.editTextTextEmailAddress);
        inscrire = findViewById(R.id.inscription);

        db = new SQLiteHelper(getApplicationContext());

        inscrire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (db.addGamer(name.getText().toString(), email.getText().toString(), password.getText().toString(), 0)) {
                    Intent intent = new Intent(Inscription.this, Connection.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(Inscription.this, "Erreur d'insertion!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
