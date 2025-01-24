package com.example.mobileappfoot.lancementApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mobileappfoot.R;
import com.example.mobileappfoot.club.ClubProfil;
import com.example.mobileappfoot.joueur.JoueurProfil;

import java.io.InputStream;
import java.util.ArrayList;

import traitementApp.TraitementCsv;

public class Connexion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        Button connexion = this.findViewById(R.id.connexion);
        EditText email = this.findViewById(R.id.emailConnexion);
        EditText mdp = this.findViewById(R.id.mdpConnexion);

        connexion.setOnClickListener(new Button.OnClickListener() {

            final InputStream i = getResources().openRawResource(R.raw.login);
            final ArrayList<String[]> log = TraitementCsv.lireLogin(i);

            @Override
            public void onClick(View v) {
                int tmp = 0;
                String id = "";
                String type ="";
                for(String[] s : log ){
                    if (s[0].equals(email.getText().toString()) && s[2].contentEquals(mdp.getText().toString())){
                        tmp = 1;
                        id = s[3];
                        type = s[4];
                        break;
                    }
                }

                if (tmp == 1) {
                    if (type.equals("joueur")){
                        Intent myIntent = new Intent(Connexion.this, JoueurProfil.class);
                        //envoyer l'id vers JoueurProfil
                        myIntent.putExtra("id",id);
                        //Start JoueurProfil
                        Connexion.this.startActivity(myIntent);
                    }else {
                        Intent myIntent = new Intent(Connexion.this, ClubProfil.class);
                        //envoyer l'id vers clubProfil
                        myIntent.putExtra("id",id);
                        //Start JoueurProfil
                        Connexion.this.startActivity(myIntent);
                    }

                }else
                    tmp=2;
                //verif.setText("identifiants invalide");
            }
        });
    }
}