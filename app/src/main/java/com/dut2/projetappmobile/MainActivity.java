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

                    Intent ActivityJeux = new Intent(MainActivity.this, GameActivity.class);
                    startActivity(ActivityJeux);
                }
            });
    }
}