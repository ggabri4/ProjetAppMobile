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

public class MainActivity extends AppCompatActivity {

    private Button buttonfacile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonfacile = (Button) findViewById(R.id.button_facile);
        //CLICK DU BOUTON FACILE
        buttonfacile.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {

                    Intent ActivityJeux = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(ActivityJeux);
                }
            });
    }
    EditText name,email,password;
    Button send;
    SQLiteHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name= findViewById(R.id.nom);
        password=findViewById(R.id.password);
        email=findViewById(R.id.email);
        send=findViewById(R.id.send);

        db=new  SQLiteHelper(getApplicationContext());

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (db.addGamer(name.getText().toString(),email.getText().toString(),password.getText().toString(),0)){
                    Intent intent = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(MainActivity.this, "Erreur d'insertion!", Toast.LENGTH_SHORT).show();
                }
        });
    }




}