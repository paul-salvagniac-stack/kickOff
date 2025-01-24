package bd;

public class Joueur {

    private int id;
    private String nom;
    private String prenom;
    private int age;
    private String niveaux;
    private int experience;
    private String Description;
    private String poste;
    private String localisation; //voir si on peut pas le faire passer par un type spéciale
    private String piedsFort;

    /**
     * @param nom
     * @param prenom
     * @param age
     * @param niveaux
     * @param experience
     * @param description
     * @param poste
     * @param localisation
     * @param piedsFort
     */
    public Joueur(int id, String nom, String prenom, int age, String niveaux, int experience, String description, String poste, String localisation, String piedsFort) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.niveaux = niveaux;
        this.experience = experience;
        this.Description = description;
        this.poste = poste;
        this.localisation = localisation;
        this.piedsFort = piedsFort;
    }



    /**
     * @return the id
     */
    public int getId() {
        return id;
    }



    /**
     * @param id the id to set
     */
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
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the niveaux
     */
    public String getNiveaux() {
        return niveaux;
    }

    /**
     * @param niveaux the niveaux to set
     */
    public void setNiveaux(String niveaux) {
        this.niveaux = niveaux;
    }

    /**
     * @return the experience
     */
    public int getExperience() {
        return experience;
    }

    /**
     * @param experience the experience to set
     */
    public void setExperience(int experience) {
        this.experience = experience;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        Description = description;
    }

    /**
     * @return the poste
     */
    public String getPoste() {
        return poste;
    }

    /**
     * @param poste the poste to set
     */
    public void setPoste(String poste) {
        this.poste = poste;
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
     * @return the piedsFort
     */
    public String getPiedsFort() {
        return piedsFort;
    }

    /**
     * @param piedsFort the piedsFort to set
     */
    public void setPiedsFort(String piedsFort) {
        this.piedsFort = piedsFort;
    }




}
