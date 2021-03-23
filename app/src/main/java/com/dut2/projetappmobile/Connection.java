package com.dut2.projetappmobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.net.ConnectException;

public class Connection extends AppCompatActivity {
    EditText email, pass;
    Button connect;
    ImageButton inscription;
    SQLiteHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inscription_main);

        email=findViewById(R.id.email);
        pass=findViewById(R.id.password);
        connect=findViewById(R.id.connection);
        inscription=findViewById(R.id.inscription);

        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(db.connection(email.getText().toString(),pass.getText().toString())){
                Intent intent = new Intent(Connection.this, MainActivity.class);
                startActivity(intent);
            }
                else {
                    Toast.makeText(Connection.this,"Login ou Mot de passe Incorrect",Toast.LENGTH_SHORT).show();
                }
        });

        inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Connection.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
