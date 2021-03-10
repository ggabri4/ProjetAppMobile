package com.dut2.devmobg2_010221;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class UtilisateurAdapteur extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private TextView PrenomTextView;
    private TextView nomTextView;
    private List<Utilisateur> LesUtilisateurs;

    public UtilisateurAdapteur(List<Utilisateur> lesUtilisateurs) {
        LesUtilisateurs = lesUtilisateurs;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder res=null;
        LayoutInflater monLayoutInflater=LayoutInflater.from(parent.getContext());
        View maView=monLayoutInflater.inflate(R.layout.layout_ligne_utilisateur,parent,false);

        res=new UtilisateurViewHolder(maView);

        return res;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        UtilisateurViewHolder monUtilisateurViewHolder;

        monUtilisateurViewHolder=(UtilisateurViewHolder)holder;

        monUtilisateurViewHolder.afficherUtilisateur(LesUtilisateurs.get(position));
    }

    @Override
    public int getItemCount() {
        return LesUtilisateurs.size();
    }
}
