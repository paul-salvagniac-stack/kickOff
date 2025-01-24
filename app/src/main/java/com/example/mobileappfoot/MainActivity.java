package com.example.mobileappfoot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.mobileappfoot.lancementApp.Accueil;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Timer t = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent pageSuivante = new Intent(MainActivity.this, Accueil.class);
                MainActivity.this.startActivity(pageSuivante);
            }
        };

        t.schedule(task, 3000);
    }
}