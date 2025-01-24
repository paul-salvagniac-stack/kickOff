package com.example.mobileappfoot.joueur;

import androidx.appcompat.app.AppCompatActivity;
import com.example.mobileappfoot.R;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;

import traitementApp.TraitementCsv;

public class JoueurProfil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joueur_activity_profil);

        TextView nomPrenom = (TextView) this.findViewById(R.id.nomPrenom);
        TextView agePoste = (TextView) this.findViewById(R.id.agePoste);
        TextView localisation = (TextView) this.findViewById(R.id.localisation);
        TextView descrption = (TextView) this.findViewById(R.id.description);
        TextView niveau = (TextView) this.findViewById(R.id.niveau);
        TextView experience = (TextView) this.findViewById(R.id.experience);
        TextView piedfort = (TextView) this.findViewById(R.id.piedFort);

        InputStream i = getResources().openRawResource(R.raw.joueur);
        ArrayList<String[]> player = TraitementCsv.lireJoueur(i);
        String[] joueurProfil = new String[10];

        Intent intent = getIntent();
        String id  = intent.getStringExtra("id");


        for(String[] s : player){
            if (s[0].equals(id))
                joueurProfil = s;
        }

        nomPrenom.setText(joueurProfil[1]+" "+joueurProfil[2]);
        agePoste.setText(joueurProfil[3]+" ans | "+joueurProfil[7]);
        localisation.setText(joueurProfil[8]);
        descrption.setText(joueurProfil[6]);
        niveau.setText(joueurProfil[4]);
        experience.setText(joueurProfil[5]);
        piedfort.setText(joueurProfil[9]);

    }
}