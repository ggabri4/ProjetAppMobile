package com.dut2.projetappmobile;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
    TextView text;
    ImageView img;
    Button change;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        text=findViewById(R.id.TextNom);
        change=findViewById(R.id.buttonColor);
        img = findViewById(R.id.ImageProfil);

        Intent intent= getIntent();
        Bundle bundle=intent.getExtras();

        String email=bundle.getString("email");
        int img2= bundle.getInt("img");

        text.setText("Vous avez :"+email);
        img.setImageResource(img2);
    }
    public void changeColor(View view){
        Random rand = new Random();




    }
}