package bd;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Club implements Parcelable {

    private int id;
    private String nom;
    private String localisation;
    //private ArrayList<Equipe> equipes;
    //private ArrayList<Joueur> joueurs;

    /**
     * @param nom
     * @param localisation
     //* @param equipes
     */
    public Club(int id, String nom, String localisation/*, ArrayList<Equipe> equipes,ArrayList<Joueur> joueurs*/) {
        this.id = id;
        this.nom = nom;
        this.localisation = localisation;
        //this.equipes = equipes;
        //this.joueurs = joueurs;
    }

    protected Club(Parcel in) {
        id = in.readInt();
        nom = in.readString();
        localisation = in.readString();
    }

    public static final Creator<Club> CREATOR = new Creator<Club>() {
        @Override
        public Club createFromParcel(Parcel in) {
            return new Club(in);
        }

        @Override
        public Club[] newArray(int size) {
            return new Club[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the localisation
     */
    public String getLocalisation() {
        return localisation;
    }

    /**
     * @param localisation the localisation to set
     */
    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    /**
     * @return the equipes
     */
    /*public ArrayList<Equipe> getEquipes() {
        return equipes;
    }*/

    /**
     //* @param equipes the equipes to set
     */
    /*public void setEquipes(ArrayList<Equipe> equipes) {
        this.equipes = equipes;
    }*/

    public ArrayList<Integer> rechercheId(ArrayList<Joueur> joueurs) {

        ArrayList<Integer> idJoueur = new ArrayList<>();

        for (Joueur j : joueurs) {

            idJoueur.add(j.getId());

        }
        return idJoueur;
    }

    public ArrayList<Integer> rechercheNbCritere(HashMap<String,String> critere, ArrayList<Joueur> joueurs) {

        ArrayList<Integer> nbCritere= new ArrayList<>();

        for (Joueur j : joueurs) {

            int nbC = 0;

            for (Map.Entry<String , String> m : critere.entrySet()) {


                if (m.getKey().equals("age")) {
                    if (j.getAge() == Integer.parseInt(m.getValue()))
                        nbC++;
                }

                if (m.getKey().equals("niveaux")) {
                    if (j.getNiveaux().equals(m.getValue()))
                        nbC++;
                }

                if (m.getKey().equals("experience")) {
                    if (j.getExperience() == Integer.parseInt(m.getValue()))
                        nbC++;
                }

                if (m.getKey().equals("poste")) {
                    if (j.getPoste().equals(m.getValue()))
                        nbC++;
                }

                if (m.getKey().equals("pieds fort")) {
                    if (j.getPiedsFort().equals(m.getValue()))
                        nbC++;
                }
            }
            nbCritere.add(nbC);
        }
        return nbCritere;
    }


    public ArrayList<Integer> tri (ArrayList<Integer> id, ArrayList<Integer> nbCritere) {

        ArrayList<Integer> triId = new ArrayList();
        ArrayList<Integer> triCr = new ArrayList();

        int i = 0;
        int matchCri = 0;
        int k = 0;

        while (k != nbCritere.size()){
            while (i != nbCritere.size()) {
                if (matchCri==nbCritere.get(i)) {
                    triId.add( id.get(i));
                    triCr.add( nbCritere.get(i));
                }
                i++;
            }
            i=0;
            matchCri++;
            k++;
        }
        Collections.sort(nbCritere);
        Collections.reverse(nbCritere);

        Collections.reverse(triId);
        return triId;
    }

    public Joueur trouverJoueur (ArrayList<Joueur> j , int id) {

        for (Joueur jo : j) {
            if (jo.getId() == id) {
                return jo;
            }
        }
        return null;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(nom);
        parcel.writeString(localisation);
    }


}