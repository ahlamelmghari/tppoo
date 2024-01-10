package phase1.service;
import phase1.models.etudiant;
import phase1.models.Filliere;

import java.util.ArrayList;


public class Etudiantserv {
    public static etudiant addEtd(String nom,String prenom ,String email ,int apogee,Filliere filliere){
        etudiant etudiant=new etudiant();
        etudiant.setNom(nom);
        etudiant.setApogee(apogee);
        etudiant.setEmail(email);
        etudiant.setPrenom(prenom);
        etudiant.setFiliere(filliere);
        etudiant.setId(database.getEtdId());
        database.etudiants.add(etudiant);
        return etudiant;
    }
    public static etudiant updateEtd(int id,String nom, String prenom, String email, int apogee, Filliere filliere){
        for (etudiant etudiant:database.etudiants){
            if (etudiant.getId()==id){
                etudiant.setNom(nom);
                etudiant.setPrenom(prenom);
                etudiant.setEmail(email);
                etudiant.setFiliere(filliere);
            }return etudiant;
        }
        return  new etudiant();
    }
    public static ArrayList<etudiant> deleteEtdById(int id){
        database.etudiants.remove(getEtdById(id));
        return  database.etudiants;
    }

    public static etudiant getEtdById(int id){
        for (etudiant etudiant:database.etudiants){
            if (etudiant.getId()==id){
                return etudiant;
            }
        }
        return  new etudiant();
    }

    public static ArrayList<etudiant> getAllEtd(){
        return  database.etudiants;
    }

}
