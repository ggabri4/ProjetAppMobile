package com.dut2.projetappmobile;


import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
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
    private TextView scoretext;
    private ImageView bluebutton;
    private ImageView redbutton;
    private ImageView greenbutton;
    private ImageView orangebutton;
    private ImageView uncoeur;
    private ImageView deuxcoeur;
    private Button beginbutton;
    private String sequence;

    private int nbtour=3;
    private int incr;
    private char val = '0';
    private boolean click=false;
    private int vie=0;
    private int viemax;
    private int etape=0;
    private int score=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        gametext = findViewById(R.id.game_text);
        scoretext = findViewById(R.id.score_text);
        bluebutton = findViewById(R.id.blue_button);
        redbutton = findViewById(R.id.red_button);
        greenbutton = findViewById(R.id.green_button);
        orangebutton = findViewById(R.id.orange_button);
        beginbutton = (Button) findViewById(R.id.begin_button);
        uncoeur = findViewById(R.id.un_coeur);
        deuxcoeur = findViewById(R.id.deux_coeur);

        //Initialisation debut page
        String chars = "1234";
        sequence = "";
        for(int x=0;x<nbtour+1;x++)//+1 pour éviter le out of range
        {
            int i =  (int)(Math.random() * ((3) + 1));
            sequence += chars.charAt(i);
        }
        System.out.println(sequence);
        viemax=2;
        gametext.setText("Clique sur Démarrer pour lancer !");
        scoretext.setText("score : "+score);

        beginbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                //Initialisation clique bouton
                ImageView nombouton;
                boolean error=false;
                click=false;
                vie=0;
                incr=0;
                etape=0;
                val=0;
                score=0;
                uncoeur.clearColorFilter();
                deuxcoeur.clearColorFilter();

                ControleSequence(0);
                CkeckColor();

                System.out.println("Fin");
            }
        });


    }
    //---------------------Fonction--et--procédure------------------------------
    private void CkeckColor(){
        ColorMatrix cm = new ColorMatrix();
        cm.setSaturation(0);
        final ColorFilter filter = new ColorMatrixColorFilter(cm);

        ButtonListener();
        if(etape>=nbtour-1 && incr==etape && etape!=0)
        {
            if(vie<viemax)
                gametext.setText("\t\t\t\t\t\t\t\tTu as gagné !"+"\n\nClique sur démarrer pour rejouer.");
            else
                gametext.setText("\t\t\t\t\t\t\t\tTu as perdu."+"\n\nClique sur démarrer pour rejouer.");
        }
        else if(val == sequence.charAt(incr) && vie<viemax)
        {
            System.out.println("correct");
            System.out.println("val ="+val+" ,sequence(i) ="+ sequence.charAt(incr));
            System.out.println("incr ="+incr+" ,etape ="+etape);

            if(etape>=nbtour)
                gametext.setText("\t\t\t\t\t\t\t\tTu as gagné !"+"\n\nClique sur démarrer pour rejouer.");
            else
            {
                gametext.setText("Bien joué ! Continues");
                if(incr==etape && etape <nbtour-1)
                {
                    incr=0;
                    etape++;
                    ControleSequence(etape);
                    System.out.println("etape++");
                    score = (etape+1);//* mode <----------------------------------------------------------------------------------------------------
                    scoretext.setText("score : "+score);
                }else if(etape<nbtour) {
                    incr++;
                    System.out.println("incr++");
                }else{
                    etape++;System.out.println("error");//Gestion de problèmes
                }

            }
        }
        else if (click && vie<viemax && etape <nbtour)
        {

            System.out.println("incorrect");
            System.out.println("val ="+val+" ,sequence(i) ="+ sequence.charAt(incr));
            System.out.println("incr ="+incr+" ,etape ="+etape);
            vie++;

            if(vie==viemax && etape <nbtour)
            {
                gametext.setText("\t\t\t\t\t\t\t\tTu as perdu."+"\n\nClique sur démarrer pour rejouer.");
                deuxcoeur.setColorFilter(filter);
            }else if(etape <nbtour)
            {
                incr=0;
                gametext.setText("Raté ! -"+vie+" vie");
                uncoeur.setColorFilter(filter);
                ControleSequence(etape);
            }else
                System.out.println("NON");

        }
        else {System.out.println("Redemarrer");}

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
                CkeckColor();
            }});
        redbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val = '2';
                click=true;
                ButtonClick(redbutton);
                CkeckColor();
            }});
        orangebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val = '3';
                click=true;
                ButtonClick(orangebutton);
                CkeckColor();
            }});
        bluebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val = '4';
                click=true;
                ButtonClick(bluebutton);
                CkeckColor();
            }});
        //}
    }

    private void ControleSequence(int j){
        Handler handler = new Handler();
        gametext.setText("Retiens bien l'ordre d'allumage !");
        for (int i=0;i<j+1;i++)
        {
            int finalI = i;
            handler.postDelayed(new Runnable(){
                @Override
                public void run(){
                    handler.postDelayed(new Runnable(){
                        @Override
                        public void run(){
                            Visibility(finalI, 150);
                        }
                    },(finalI)*1000);
                    handler.postDelayed(new Runnable(){
                        @Override
                        public void run(){
                            Visibility(finalI, 255);
                            if(finalI ==etape)gametext.setText("A toi de jouer !");
                        }
                    },(finalI +1)*1000);
                }
            },(i+1)*1000+100);
        }
    }

    private void Visibility(int i, int alpha){
        switch (sequence.charAt(i))
        {
            case '1'://vert
                greenbutton.setImageAlpha(alpha);
                break;

            case '2'://rouge
                redbutton.setImageAlpha(alpha);
                break;

            case '3'://orange
                orangebutton.setImageAlpha(alpha);
                break;

            case '4'://bleu
                bluebutton.setImageAlpha(alpha);
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