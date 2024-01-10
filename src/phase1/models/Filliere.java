package phase1.models;

import java.util.ArrayList;

public class Filliere {
    private int id;
    private String intitule;
    private Enseignant responsable;
    private Departement departement;

    ArrayList<Module> Modules= new ArrayList<>();
    public Filliere(){
    }
    public Filliere(String intitule, Enseignant responsable,Departement departement){
        this.intitule=intitule;
        this.responsable=responsable;
        this.departement=departement;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }
    public String getIntitule(){
        return intitule;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setResponsable(Enseignant responsable) {
        this.responsable = responsable;
    }

    public Enseignant getResponsable() {
        return responsable;
    }

    public ArrayList<Module> getModules() {
        return Modules;
    }

    public void setModules(ArrayList<Module> modules) {
        Modules = modules;
    }

}