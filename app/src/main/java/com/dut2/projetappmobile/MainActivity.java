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
    private Button buttondifficile;
    private Button buttonexpert;
    private double mode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonfacile = (Button) findViewById(R.id.button_facile);
        buttondifficile = (Button) findViewById(R.id.button_difficile);
        buttonexpert = (Button) findViewById(R.id.button_expert);

        //CLICK DU BOUTON FACILE
        buttonfacile.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    mode = 1;
                    Intent ActivityJeux = new Intent(MainActivity.this, GameActivity.class);
                    ActivityJeux.putExtra("valmode", mode);
                    startActivity(ActivityJeux);
                }
            });

        //CLICK DU BOUTON DIFFICILE
        buttondifficile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mode = 1.5;
                Intent ActivityJeux = new Intent(MainActivity.this, GameActivity.class);
                ActivityJeux.putExtra("valmode", mode);
                startActivity(ActivityJeux);
            }
        });

        //CLICK DU BOUTON EXPERT
        buttonexpert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mode = 3;
                Intent ActivityJeux = new Intent(MainActivity.this, GameActivity.class);
                ActivityJeux.putExtra("valmode", mode);
                startActivity(ActivityJeux);
            }
        });
    }
}