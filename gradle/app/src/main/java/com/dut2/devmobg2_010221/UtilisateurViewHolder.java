package com.dut2.devmobg2_010221;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UtilisateurViewHolder extends RecyclerView.ViewHolder {

    private TextView prenomTextView;
    private TextView nomTextView;

    public UtilisateurViewHolder(@NonNull View itemView) {
        super(itemView);

        prenomTextView=itemView.findViewById(R.id.id_prenom_textview);
        nomTextView=itemView.findViewById(R.id.id_mon_recyclerview);
    }
    public void afficherUtilisateur(Utilisateur unUtilisateur){
        prenomTextView.setText(unUtilisateur.getPrenom());
        nomTextView.setText(unUtilisateur.getPrenom());

    }
}
