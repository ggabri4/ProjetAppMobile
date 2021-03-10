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

    private Button leSecondBouton;
    EditText id_email;
    ImageView Img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id_email=findViewById(R.id.id_email);
        leSecondBouton = findViewById(R.id.id_secondbouton);

        leSecondBouton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);

                Bundle bundle = new Bundle();
                bundle.putString("email", id_email.getText().toString());
                bundle.putInt("img", R.id.Img);
                intent.putExtras(bundle);
                startActivity(intent);
                startActivityForResult(intent, 1000);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1000) {
            if(resultCode == Activity.RESULT_OK) {
                if (data.hasExtra("msg1")) {
                    Toast.makeText(getApplicationContext(), "MSG1 :" + data.getExtras().getString("msg1"), Toast.LENGTH_LONG).show();
                }
            }
            if(resultCode == Activity.RESULT_CANCELED){
                if(data.hasExtra("msg2")) {
                    Toast.makeText(getApplicationContext(),"MSG2 :"+data.getExtras().getString("msg2"),Toast.LENGTH_LONG).show();
                }

            }
        }

    }
}