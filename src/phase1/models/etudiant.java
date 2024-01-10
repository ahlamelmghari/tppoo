package phase1.models;

import java.util.ArrayList;

public class etudiant{
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private int apogee;
    private Filliere filliere;
    ArrayList<Note> notes = new ArrayList<Note>();


    public etudiant() {
    }

    public etudiant(int apogee,String nom, String prenom, String email,  Filliere filliere) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.apogee = apogee;
        this.filliere = filliere;
    }
    public etudiant(int apogee,String nom, String prenom, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.apogee = apogee;

    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getApogee() {
        return apogee;
    }

    public void setApogee(int apogee) {
        this.apogee = apogee;
    }

    public Filliere getFiliere() {
        return filliere;
    }

    public void setFiliere(Filliere filiere) {
        this.filliere = filiere;
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public void setNotes(ArrayList<Note> notes) {
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id=id;
    }
}
