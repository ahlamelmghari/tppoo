package phase1.service;
import phase1.models.Departement;
import phase1.models.Filliere;
import phase1.models.Enseignant;

import java.util.ArrayList;

public class FilliereServ {
    public static Filliere addFilliere(String intitule, Enseignant responsable, Departement departement) {
        Filliere filliere = new Filliere();
        filliere.setIntitule(intitule);
        filliere.setResponsable(responsable);
        filliere.setDepartement(departement);
        filliere.setId(database.getEtdId());
        database.fillieres.add(filliere);
        return filliere;
    }



    public static Filliere updateFiliere(int id , String intitule, Enseignant responsable, Departement dept){
        for (Filliere filliere:database.fillieres){
            if (filliere.getId()==id){
                filliere.setIntitule(intitule);
                filliere.setResponsable(responsable);
                filliere.setDepartement(dept);}
            return filliere;
            }

        return  new Filliere();
    }
    public static ArrayList<Filliere> deleteFiliereById(int id){
        database.fillieres.remove(getFileById(id));

        return  database.fillieres;
    }

    public static Filliere getFileById(int id) {
        for (Filliere filliere : database.fillieres) {
            if (filliere.getId() == id) {
                return filliere;
            }

        }
        return new Filliere();
    }

        public static ArrayList<Filliere> getAllFil() {
            return database.fillieres;
        }

    }


