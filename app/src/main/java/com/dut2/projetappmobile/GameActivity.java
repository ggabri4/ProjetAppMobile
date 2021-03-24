package com.dut2.projetappmobile;


import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import java.io.Console;
import java.util.Timer;
import java.util.TimerTask;


public class GameActivity extends AppCompatActivity {

    private TextView gametext;
    private ImageView bluebutton;
    private ImageView redbutton;
    private ImageView greenbutton;
    private ImageView orangebutton;
    private Button beginbutton;
    private String sequence;

    private int nbtour=5;
    private int incr=0;
    private char val = '0';
    private boolean click=false;
    private int vie=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        gametext = findViewById(R.id.game_text);
        bluebutton = findViewById(R.id.blue_button);
        redbutton = findViewById(R.id.red_button);
        greenbutton = findViewById(R.id.green_button);
        orangebutton = findViewById(R.id.orange_button);
        beginbutton = (Button) findViewById(R.id.begin_button);


        String chars = "1234";

        sequence = "";
        for(int x=0;x<nbtour;x++)
        {
            int i =  (int)(Math.random() * ((3) + 1));
            sequence += chars.charAt(i);
        }
        System.out.println(sequence);
        gametext.setText("Clique sur Démarrer pour lancer !");

        beginbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                ImageView nombouton;
                boolean error=false;
                click=false;
                vie=0;

                gametext.setText("Retiens bien l'ordre d'allumage !");

                for (incr=0;incr<nbtour;incr++)
                {
                    ControleSequence(incr);
                }

                incr=0;

                //while(!error && incr<nbtour)
                //{
                CkeckColor(incr);
                //}

                System.out.println("Fin");
            }
        });



    }
    //---------------------Fonction--et--procédure------------------------------
    private void CkeckColor(int i){


        ButtonListener();
        if(i>nbtour-1)
        {
            if(vie<2)
                gametext.setText("\t\t\t\t\t\t\t\tTu as gagné !"+"\n\nClique sur démarrer pour rejouer.");
            else
                gametext.setText("\t\t\t\t\t\t\t\tTu as perdu."+"\n\nClique sur démarrer pour rejouer.");
        }
        else if(val == sequence.charAt(i) && vie<2)
        {
            System.out.println("correct");
            System.out.println("val ="+val+" ,sequence(i) ="+ sequence.charAt(i));
            System.out.println("incr ="+incr);
            if(i==nbtour-1)
                gametext.setText("\t\t\t\t\t\t\t\tTu as gagné !"+"\n\nClique sur démarrer pour rejouer.");
            else
                gametext.setText("Bien joué ! Continues");
        }
        else if (click && vie<2)
        {

            System.out.println("incorrect");
            System.out.println("val ="+val+" ,sequence(i) ="+ sequence.charAt(i));
            System.out.println("incr ="+incr);
            vie++;

            if(vie==2)
            {
                gametext.setText("\t\t\t\t\t\t\t\tTu as perdu."+"\n\nClique sur démarrer pour rejouer.");
            }else
                gametext.setText("Raté ! -"+vie+" vie");
        }
        else {System.out.println("pas clické");}

    }

    private void ButtonListener() {
        //if(!click){
        //System.out.println("test");
        greenbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val = '1';
                click=true;
                ButtonClick(greenbutton);
                CkeckColor(incr);
                incr++;
            }});
        redbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val = '2';
                click=true;
                ButtonClick(redbutton);
                CkeckColor(incr);
                incr++;
            }});
        orangebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val = '3';
                click=true;
                ButtonClick(orangebutton);
                CkeckColor(incr);
                incr++;
            }});
        bluebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val = '4';
                click=true;
                ButtonClick(bluebutton);
                CkeckColor(incr);
                incr++;
            }});
        //}
    }

    private void ControleSequence(int i){
        Handler handler = new Handler();

        handler.postDelayed(new Runnable(){
            @Override
            public void run(){
                handler.postDelayed(new Runnable(){
                    @Override
                    public void run(){
                        firstVisibility(i);
                    }
                },(i)*1000);



                handler.postDelayed(new Runnable(){
                    @Override
                    public void run(){
                        secondVisibility(i);
                        if(i==nbtour-1)gametext.setText("A toi de jouer !");
                    }
                },(i +1)*1000);
            }
        },(i+1)*1000+100);
    }

    private void firstVisibility(int i){
        switch (sequence.charAt(i))
        {
            case '1'://vert
                greenbutton.setImageAlpha(150);
                System.out.println("vert");
                break;

            case '2'://rouge
                redbutton.setImageAlpha(150);
                System.out.println("rouge");
                break;

            case '3'://orange
                orangebutton.setImageAlpha(150);
                System.out.println("orange");
                break;

            case '4'://bleu
                bluebutton.setImageAlpha(150);
                System.out.println("bleu");
                break;
        }
    }

    private void secondVisibility(int i){

        switch (sequence.charAt(i))
        {
            case '1'://vert
                greenbutton.setImageAlpha(255);
                break;

            case '2'://rouge
                redbutton.setImageAlpha(255);
                break;

            case '3'://orange
                orangebutton.setImageAlpha(255);
                break;

            case '4'://bleu
                bluebutton.setImageAlpha(255);
                break;
        }
    }

    private void ButtonClick(ImageView image) {
        final ImageView b = image;
        b.postDelayed(new Runnable() {

            @Override

            public void run() {
                b.setImageAlpha(150);
            }

        }, 0);
        b.postDelayed(new Runnable() {

            @Override

            public void run() {
                b.setImageAlpha(255);
            }

        }, 300);
    }
}