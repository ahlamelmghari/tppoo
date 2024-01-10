package phase1.models;
import java.util.ArrayList;

public class Departement {
    private int id;
    private String intitule;
    private Enseignant responsable;
    ArrayList<Filliere> fillieres = new ArrayList<Filliere>();
    public Departement(String intitule,int id_Enseignant ){
        this.intitule=intitule;
        this.id=id_Enseignant;
    }
    public Departement(){
    }
    public Departement(int id,String intitule, Enseignant responsable) {
        this.id=id;
        this.intitule = intitule;
        this.responsable = responsable;
    }



    public String getIntitule(){
        return intitule;
    }
    public void setIntitule(String intitule){
        this.intitule=intitule;
    }
    public int getResponsable(){
        return responsable.getId();
    }
    public void setResponsable(Enseignant responsable){
        this.responsable=responsable;
    }
    public ArrayList<Filliere> getFillieres(){
      return fillieres;
    }

    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
}
