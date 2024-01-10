package phase1.models;

import java.util.ArrayList;


import java.util.ArrayList;

public class Enseignant{
    private int id ;
    private String nom;
    private String prenom;
    private Departement deparetement;
    private String email ;
    private  String grade;
    ArrayList<Module> Modules =new ArrayList<>();
    public Enseignant(){
    }
    public Enseignant(int id , String nom, String prenom, String email , String grade  ){
        this.id=id;
        this.nom=nom;
        this.prenom=prenom;
        this.email=email;
        this.grade=grade;

    }

    public String getNom(){
        return nom;
    }
    public void setNom(String nom){
        this.nom=nom;
    }
    public String getPrenom(){
        return prenom;
    }
    public void setPrenom(String prenom){
        this.prenom=prenom;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getGrade(){
        return grade;
    }
    public void setGrade(String grade){
        this.grade=grade;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }

    public ArrayList<Module> getModules() {
        return Modules;
    }

    public void setModules(ArrayList<Module> Modules) {
        this.Modules = Modules;
    }

    public void setDeparetement(Departement deparetement) {
        this.deparetement = deparetement;
    }

    public Departement getDeparetement() {
        return deparetement;
    }
}


