package com.dut2.projetappmobile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class TableauDesScore  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonaccueil = (Button) findViewById(R.id.button_accueil);

        //CLICK DU BOUTON ACCUEIL
        buttonaccueil.setOnClickListener(v -> {
            Intent ActivityAccueil = new Intent(TableauDesScore.this, Connection.class);
            startActivity(ActivityAccueil);
        });
    }
}
