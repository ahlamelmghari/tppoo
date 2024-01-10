package phase1.service;
import phase1.models.Departement;
import phase1.models.Enseignant;
import phase1.models.Filliere;

import java.util.ArrayList;
public class EnseignantServ {


    public static Enseignant addEns(String nom, String prenom, String email, String grade, Departement dept) {
        Enseignant enseignant = new Enseignant();
        enseignant.setNom(nom);
        enseignant.setPrenom(prenom);
        enseignant.setGrade(grade);
        enseignant.setEmail(email);
        enseignant.getDeparetement();
        enseignant.setDeparetement(dept);
        enseignant.setId(database.getDeptId());
        database.enseignants.add(enseignant);


        return new Enseignant();
    }

    public static Enseignant updateEns(int id, String nom, String prenom, String email, String grade, Departement dept) {
        for (Enseignant enseignant : database.enseignants) {
            if (enseignant.getId() == id) {
                enseignant.setNom(nom);
                enseignant.setPrenom(prenom);
                enseignant.setGrade(grade);
                enseignant.setDeparetement(dept);
            }
            return enseignant;
        }
        return new Enseignant();
    }

    public static ArrayList<Enseignant> deleteEnsById(int id) {
        database.enseignants.remove(getEnsById(id));
        return database.enseignants;
    }

    public static Enseignant getEnsById(int id) {
        for (Enseignant enseignant : database.enseignants) {
            if (enseignant.getId() == id) {
                return enseignant;
            }
        }
            return new Enseignant();
        }

        public static ArrayList<Enseignant> getAllEns () {
            return database.enseignants;
        }
    }




