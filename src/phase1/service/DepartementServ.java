package phase1.service;
import phase1.models.Departement;
import phase1.models.Enseignant;

import java.util.ArrayList;

public class DepartementServ {
    public static Departement addDepart( String intitule, Enseignant... responsable) {
        Departement departement = new Departement();
        departement.setIntitule(intitule);
        departement.setId(database.getDeptId());
        if (responsable.length > 0) {
            departement.setResponsable(responsable[0]);
        }
        database.departements.add(departement);

        return departement;
    }

    public static Departement updateDepart(int id, String intitule, Enseignant... responsable) {
        for (Departement departement : database.departements) {
            if (departement.getId() == id) {
                departement.setIntitule(intitule);
                if (responsable.length > 0) {
                    departement.setResponsable(responsable[0]);
                }
                return departement;
            }
        }
        return  new Departement();
        }
    public static Departement getDeptById(int id){
        for (Departement departement : database.departements) {
            if (departement.getId() == id) return  departement;
        }
        return  new Departement();
    }
      public static ArrayList<Departement> deleteDeptById(int id){
        database.departements.remove(getDeptById(id));
        return database.departements ;
    }
    public static ArrayList<Departement> getAllDept(){

        return  database.departements;
    }


}

