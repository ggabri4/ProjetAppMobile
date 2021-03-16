package com.dut2.projetappmobile;


import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity2 extends AppCompatActivity {

    private ImageView bluebutton;
    private ImageView redbutton;
    private ImageView greenbutton;
    private ImageView orangebutton;
    private Button beginbutton;
    private String sequence;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        bluebutton = findViewById(R.id.blue_button);
        redbutton = findViewById(R.id.red_button);
        greenbutton = findViewById(R.id.green_button);
        orangebutton = findViewById(R.id.orange_button);
        beginbutton = (Button) findViewById(R.id.begin_button);

        int nbtour=5;
        String chars = "1234";

        sequence = "";
        for(int x=0;x<nbtour;x++)
        {
            int i =  (int)(Math.random() * ((3) + 1));
            sequence += chars.charAt(i);
        }

        beginbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                ImageView nombouton;
                //Toast toast= Toast.makeText(MainActivity2.this,"le chiffre :"+sequence, Toast.LENGTH_LONG);
                //toast.show();

                firstVisibility(0);
                for(int i=1; i<nbtour;i++)
                {
                    //Toast chiffre= Toast.makeText(MainActivity2.this,""+sequence.charAt(i), Toast.LENGTH_LONG);
                    //chiffre.show();

                    Handler handler = new Handler();
                    Handler handler2 = new Handler();

                    int finalI = i;
                    handler.postDelayed(new Runnable(){
                        @Override
                        public void run(){
                            firstVisibility(finalI);
                        }
                    },1000);


                    handler2.postDelayed(new Runnable(){
                        @Override
                        public void run(){
                            secondVisibility();
                        }
                    },800);


                }
            }
        });


    }
    private void firstVisibility(int i){
        switch (sequence.charAt(i))
        {
            case '1'://vert
                greenbutton.setImageAlpha(150);
                break;

            case '2'://rouge
                redbutton.setImageAlpha(150);
                break;

            case '3'://orange
                orangebutton.setImageAlpha(150);
                break;

            case '4'://bleu
                bluebutton.setImageAlpha(150);
                break;
        }
    }
    private void secondVisibility(){

        //Toast alpha= Toast.makeText(MainActivity2.this,""+greenbutton.getAlpha(), Toast.LENGTH_LONG);
        //alpha.show();
        //if(greenbutton.getAlpha()==255)
            greenbutton.setImageAlpha(255);

        //if(bluebutton.getAlpha()==255)
            bluebutton.setImageAlpha(255);

        //if(orangebutton.getAlpha()==255)
            orangebutton.setImageAlpha(255);

        //if(redbutton.getAlpha()==255)
            redbutton.setImageAlpha(255);
    }

}