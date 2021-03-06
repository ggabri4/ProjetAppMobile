package com.dut2.projetappmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private double mode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonfacile = (Button) findViewById(R.id.button_facile);
        Button buttondifficile = (Button) findViewById(R.id.button_difficile);
        Button buttonexpert = (Button) findViewById(R.id.button_expert);
        Button buttonregle = (Button) findViewById(R.id.button_regle);
        Button buttonconnection = findViewById(R.id.button_connecter);
        Button buttoninscrire = findViewById(R.id.button_inscrire);

        //CLICK DU BOUTON FACILE
        buttonfacile.setOnClickListener(v -> {
            mode = 1;
            Intent ActivityJeux = new Intent(MainActivity.this, GameActivity.class);
            ActivityJeux.putExtra("valmode", mode);
            startActivity(ActivityJeux);
        });

        //CLICK DU BOUTON DIFFICILE
        buttondifficile.setOnClickListener(v -> {
            mode = 1.5;
            Intent ActivityJeux = new Intent(MainActivity.this, GameActivity.class);
            ActivityJeux.putExtra("valmode", mode);
            startActivity(ActivityJeux);
        });

        //CLICK DU BOUTON EXPERT
        buttonexpert.setOnClickListener(v -> {
            mode = 3;
            Intent ActivityJeux = new Intent(MainActivity.this, GameActivity.class);
            ActivityJeux.putExtra("valmode", mode);
            startActivity(ActivityJeux);
        });
        //CLICK DU BOUTON REGLE
        buttonregle.setOnClickListener(v -> {
            Intent ActivityRegles = new Intent(MainActivity.this, ActivityRegle.class);
            startActivity(ActivityRegles);
        });
        //CLICK DU BOUTON CONNECTION
        buttonconnection.setOnClickListener(v -> {
            Intent ActivityConnection = new Intent(MainActivity.this, Connection.class);
            startActivity(ActivityConnection);
        });
        //CLICK DU BOUTON S'INSCRIRE
        buttoninscrire.setOnClickListener(v -> {
            Intent ActivityInscrire = new Intent(MainActivity.this, Inscription.class);
            startActivity(ActivityInscrire);
        });
    }
}