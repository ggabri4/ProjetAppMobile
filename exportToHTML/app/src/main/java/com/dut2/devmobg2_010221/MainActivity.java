package com.dut2.devmobg2_010221;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView monRecyclerView;
    private List<Utilisateur> desUtilisateurs;
    private UtilisateurAdapteur monUtilisateurAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        monRecyclerView=findViewById(R.id.id_mon_recyclerview);

        desUtilisateurs=new ArrayList<>();

        desUtilisateurs.add(new Utilisateur("A","B"));
        desUtilisateurs.add(new Utilisateur("A","B"));
        desUtilisateurs.add(new Utilisateur("A","B"));
        desUtilisateurs.add(new Utilisateur("A","B"));
        desUtilisateurs.add(new Utilisateur("A","B"));

        monUtilisateurAdapter=new UtilisateurAdapteur(desUtilisateurs);
        monRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        monRecyclerView.setAdapter(monUtilisateurAdapter);
    }
}