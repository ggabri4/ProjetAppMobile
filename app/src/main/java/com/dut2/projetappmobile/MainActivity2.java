package com.dut2.projetappmobile;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    private ImageView bluebutton;
    private ImageView redbutton;
    private ImageView greenbutton;
    private ImageView orangebutton;
    private Button beginbutton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        bluebutton = findViewById(R.id.blue_button);
        redbutton = findViewById(R.id.red_button);
        greenbutton = findViewById(R.id.green_button);
        orangebutton = findViewById(R.id.orange_button);

        //beginbutton.setOnClickListener(new View.OnClickListener(){
        //    @Override
        //    public void onClick(View v) {
//
        //        Random numbutton = new Random(4);
        //        Toast toast= Toast.makeText(MainActivity2.this,"c'est une notification", Toast.LENGTH_LONG);
        //        toast.show();
//
        //        //for(){}
        //    }
        //});


    }

}