package com.example.mobileappfoot.lancementApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mobileappfoot.R;

public class Accueil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        Button inscrire = (Button) this.findViewById(R.id.inscrire);
        Button connexion = (Button) this.findViewById(R.id.connecter);


        inscrire.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Create a Intent:
                // (This object contains content that will be sent to Example4Activity).
                Intent myIntent = new Intent(Accueil.this, CreationCompte.class);

                // Start Example4Activity.
                Accueil.this.startActivity(myIntent);
            }
        });

        connexion.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Create a Intent:
                // (This object contains content that will be sent to Example4Activity).
                Intent myIntent = new Intent(Accueil.this, Connexion.class);

                // Start Example4Activity.
                Accueil.this.startActivity(myIntent);
            }
        });
    }
}