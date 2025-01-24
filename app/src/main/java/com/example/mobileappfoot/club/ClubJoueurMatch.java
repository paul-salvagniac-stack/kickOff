package com.example.mobileappfoot.club;

import androidx.appcompat.app.AppCompatActivity;
import com.example.mobileappfoot.R;
import com.example.mobileappfoot.joueur.JoueurProfil;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;

import bd.Club;
import bd.Joueur;
import traitementApp.TraitementCsv;

public class ClubJoueurMatch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.club_activity_joueur_match);

        TableLayout table = (TableLayout) this.findViewById(R.id.table);
        EditText id = (EditText) this.findViewById(R.id.renterId);
        Button voirProfile = (Button) this.findViewById(R.id.accederProfil);

        Intent intent = getIntent();
        Club club  = intent.getParcelableExtra("club");
        ArrayList<Integer> crArray = intent.getIntegerArrayListExtra("crArray");

        InputStream j = getResources().openRawResource(R.raw.joueur);
        ArrayList<Joueur> player = TraitementCsv.lireJoueurArray(j);
        ArrayList<Integer> idArray = club.rechercheId(player);

        idArray = club.tri(idArray,crArray);

        TableRow row;
        TextView tv1, tv2, tv3;
        int a = 0;
        String nomPrenom = "";
        //faire la table à partir du modéle premier
        //problèmeau niveaux de l'implémentation du tableau les nom (idArray) des Joueur ne se mette pas dans le bonn ordre
        for ( Integer i : idArray) {
            row = new TableRow(this);

            nomPrenom = club.trouverJoueur(player,i).getNom() +" "+ club.trouverJoueur(player,i).getPrenom();

            tv1 = new TextView(this); // création cellul
            tv1.setText(nomPrenom); // ajout du texte
            tv1.setGravity(Gravity.CENTER); // centrage dans la cellule
            tv1.setTextColor(getColor(R.color.black));
            tv1.setTextSize(17);
            // adaptation de la largeur de colonne à l'écran :
            tv1.setLayoutParams(new TableRow.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1));
            //ligne joueur;


            // idem 2ème colonne
            tv2 = new TextView(this);
            float pourcentage = (float) crArray.get(a)/5*100;
            tv2.setText(pourcentage+" %");
            tv2.setGravity(Gravity.CENTER);
            tv2.setTextColor(getColor(R.color.black));
            tv2.setTextSize(17);
            tv2.setLayoutParams(new TableRow.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1));

            String idJoueur = club.trouverJoueur(player,i).getId()+"";

            tv3 = new TextView(this); // création cellul
            tv3.setText(idJoueur); // ajout du texte
            tv3.setGravity(Gravity.CENTER); // centrage dans la cellule
            tv3.setTextColor(getColor(R.color.black));
            tv3.setTextSize(17);
            // adaptation de la largeur de colonne à l'écran :
            tv3.setLayoutParams(new TableRow.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1));

            // ajout des cellules à la ligne
            row.addView(tv3);
            row.addView(tv1);
            row.addView(tv2);

            // ajout de la ligne au tableau
            table.addView(row);
            a++;
        }


        voirProfile.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Create a Intent:
                // (This object contains content that will be sent to Example5Activity).
                Intent myIntent = new Intent(ClubJoueurMatch.this, JoueurProfil.class);
                //envoyer l'id vers JoueurProfil
                myIntent.putExtra("id", id.getText().toString());
                //Start JoueurProfil
                // Start Example5Activity
                ClubJoueurMatch.this.startActivity(myIntent);
            }
        });

    }
}