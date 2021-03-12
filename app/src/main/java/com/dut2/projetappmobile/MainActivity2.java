package com.dut2.projetappmobile;


import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
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

                for(int i=0; i<nbtour;i++)
                {
                    //Toast chiffre= Toast.makeText(MainActivity2.this,""+sequence.charAt(i), Toast.LENGTH_LONG);
                    //chiffre.show();
                    Timer rotationTimer = new Timer(true);

                    TimerTask vert = new TimerTask() {
                        @Override
                        public void run() {
                            greenbutton.setImageAlpha(100);
                        }
                    };
                    TimerTask rouge = new TimerTask() {
                        @Override
                        public void run() {
                            redbutton.setImageAlpha(100);
                        }
                    };
                    TimerTask orange = new TimerTask() {
                        @Override
                        public void run() {
                            orangebutton.setImageAlpha(100);
                        }
                    };
                    TimerTask bleu = new TimerTask() {
                        @Override
                        public void run() {
                            bluebutton.setImageAlpha(100);
                        }
                    };


                    switch (sequence.charAt(i))
                    {

                        case '1'://vert
                            rotationTimer.schedule(vert,1000);
                            break;

                        case '2'://rouge
                            rotationTimer.schedule(rouge,1000);
                            break;

                        case '3'://orange
                            rotationTimer.schedule(orange,1000);
                            break;

                        case '4'://bleu
                            rotationTimer.schedule(bleu,1000);
                            break;
                    }

                    //Thread.sleep(1000);

                    greenbutton.setImageAlpha(255);
                    bluebutton.setImageAlpha(255);
                    orangebutton.setImageAlpha(255);
                    redbutton.setImageAlpha(255);


                }
            }
        });


    }

}