package com.example.mobileappfoot.club;

import androidx.appcompat.app.AppCompatActivity;
import com.example.mobileappfoot.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import bd.Club;
import bd.Joueur;
import traitementApp.TraitementCsv;

public class ClubRecherche extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.club_activity_recherche);

        EditText age            = (EditText) this.findViewById(R.id.age);
        EditText niveaux        = (EditText) this.findViewById(R.id.niveaux);
        EditText exp            = (EditText) this.findViewById(R.id.exp);
        EditText posteRecherche = (EditText) this.findViewById(R.id.posteRecherche);
        EditText loca           = (EditText) this.findViewById(R.id.loca);
        EditText pF             = (EditText) this.findViewById(R.id.pF);

        Button recherche = (Button) this.findViewById(R.id.find);

        Intent intent = getIntent();
        String id  = intent.getStringExtra("id");

        InputStream i = getResources().openRawResource(R.raw.club);
        ArrayList<String[]> c = TraitementCsv.lireClub(i);
        String[] clubs = new String[10];

        InputStream j = getResources().openRawResource(R.raw.joueur);
        ArrayList<Joueur> player = TraitementCsv.lireJoueurArray(j);

        for(String[] s : c){
            if (s[0].equals(id))
                clubs = s;
        }

        Club club = new Club(Integer.parseInt(clubs[0]),clubs[1],clubs[2]);

        HashMap<String,String> critere = new HashMap<>();


        recherche.setOnClickListener(new Button.OnClickListener() {

            ArrayList<Integer> crArray = new ArrayList<>();

            @Override
            public void onClick(View v) {

                // Create a Intent:
                // (This object contains content that will be sent to Example5Activity).
                Intent myIntent = new Intent(ClubRecherche.this, ClubJoueurMatch.class);

                critere.put("age", age.getText().toString());
                critere.put("niveaux", niveaux.getText().toString());
                critere.put("experience", exp.getText().toString());
                critere.put("poste", posteRecherche.getText().toString());
                critere.put("pieds fort", pF.getText().toString());

                crArray = club.rechercheNbCritere(critere,player);


                myIntent.putIntegerArrayListExtra("crArray", crArray);
                myIntent.putExtra("club",club);
                // Start Example5Activity
                ClubRecherche.this.startActivity(myIntent);
            }
        });
    }
}