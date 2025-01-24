package com.example.mobileappfoot.club;

import androidx.appcompat.app.AppCompatActivity;
import com.example.mobileappfoot.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ClubProfil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.club_activity_profil);

        Button suite = (Button) this.findViewById(R.id.table);

        Intent intent = getIntent();
        String id  = intent.getStringExtra("id");

        suite.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Create a Intent:
                // (This object contains content that will be sent to Example5Activity).
                Intent myIntent = new Intent(ClubProfil.this, ClubRecherche.class);

                myIntent.putExtra("id",id);

                // Start Example5Activity.
                ClubProfil.this.startActivity(myIntent);
            }
        });
    }
}