package traitementApp;


import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;

import bd.Club;
import bd.Joueur;
import bd.Login;


public class TraitementCsv {

    public static void incrireUtilisateur (EditText email, EditText num, EditText mdp, FileOutputStream out) throws IOException {

        String TestString = "";
        OutputStreamWriter osw  = new OutputStreamWriter(out);

        System.out.println("Je suis dans incrireUtilisateur dans traitementCsv !!!!");

        TestString = "email,Numero,Mdp \n";
        TestString = email.getText().toString()+","+num.getText().toString()+","+mdp.getText().toString()+"\n";

        osw.write(TestString);
        osw.flush();
        osw.close();

    }

    public static ArrayList<String[]> lireLogin (InputStream i ){

        ArrayList<String[]> liste = new ArrayList<>();
        ArrayList<Login> l = new ArrayList<>();
        BufferedReader buff = new BufferedReader( new InputStreamReader( i , Charset.forName("UTF-8") ));

        String line = "";

        try{
            while ( (line = buff.readLine()) != null){

                String[] tokens = line.split(",");

                Login j = new Login(tokens[0],tokens[1],tokens[2], Integer.parseInt(tokens[3]),tokens[4]);
                l.add(j);

            }
        }catch (IOException e){
            System.err.println("PROBLEMO MON FRERO !!!!");
        }
        int k = 0;

        for (Login j : l){
            liste.add(new String[]{j.getEmail(), j.getNum(), j.getMdp(), Integer.toString(j.getId()), j.getType()});
            k++;
        }
        return liste;
    }

    public static ArrayList<String[]> lireJoueur (InputStream i ){

        ArrayList<String[]> liste = new ArrayList<>();
        ArrayList<Joueur> l = new ArrayList<>();
        BufferedReader buff = new BufferedReader( new InputStreamReader( i , Charset.forName("UTF-8") ));

        String line = "";

        try{
            while ( (line = buff.readLine()) != null){

                String[] tokens = line.split(",");

                Joueur j = new Joueur(Integer.parseInt(tokens[0]),tokens[1],tokens[2],Integer.parseInt(tokens[3]),tokens[4],Integer.parseInt(tokens[5]),tokens[6],tokens[7],tokens[8],tokens[9]);
                l.add(j);
            }
        }catch (IOException e){
            System.err.println("PROBLEMO MON FRERO !!!!");
        }
        int k = 0;

        for (Joueur j : l){
            liste.add(new String[]{Integer.toString(j.getId()), j.getNom(), j.getPrenom(), Integer.toString(j.getAge()), j.getNiveaux(), Integer.toString(j.getExperience()), j.getDescription(), j.getPoste(), j.getLocalisation(), j.getPiedsFort()});
            k++;
        }
        return liste;
    }

    public static ArrayList<Joueur> lireJoueurArray (InputStream i ){

        ArrayList<String[]> liste = new ArrayList<>();
        ArrayList<Joueur> l = new ArrayList<>();
        BufferedReader buff = new BufferedReader( new InputStreamReader( i , Charset.forName("UTF-8") ));

        String line = "";

        try{
            while ( (line = buff.readLine()) != null){

                String[] tokens = line.split(",");

                Joueur j = new Joueur(Integer.parseInt(tokens[0]),tokens[1],tokens[2],Integer.parseInt(tokens[3]),tokens[4],Integer.parseInt(tokens[5]),tokens[6],tokens[7],tokens[8],tokens[9]);
                l.add(j);
            }
        }catch (IOException e){
            System.err.println("PROBLEMO MON FRERO !!!!");
        }
        return l;
    }

    public static ArrayList<String[]> lireClub (InputStream i ){

        ArrayList<String[]> liste = new ArrayList<>();
        ArrayList<Club> l = new ArrayList<>();
        BufferedReader buff = new BufferedReader( new InputStreamReader( i , Charset.forName("UTF-8") ));

        String line = "";

        try{
            while ( (line = buff.readLine()) != null){

                String[] tokens = line.split(",");

                Club c = new Club(Integer.parseInt(tokens[0]),tokens[1],tokens[2]);
                l.add(c);
            }
        }catch (IOException e){
            System.err.println("PROBLEMO MON FRERO !!!!");
        }
        int k = 0;

        for (Club c : l){
            liste.add(new String[]{Integer.toString(c.getId()), c.getNom(), c.getLocalisation()});
            k++;
        }
        return liste;
    }

}
