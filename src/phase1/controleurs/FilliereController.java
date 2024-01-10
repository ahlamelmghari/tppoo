package phase1.controleurs;
import phase1.Main;

import phase1.models.Filliere;
import phase1.service.EnseignantServ;
import phase1.service.DepartementServ;
import phase1.service.FilliereServ;
import phase1.service.database;

import java.sql.SQLException;

public class FilliereController {
    public static void showMenu()  {
        System.out.println("-------------------------[ Fillieres]---------------------------");


        System.out.println("1: Pour ajouter une filliere");
        System.out.println("2: Pour afficher les fillieres");
        System.out.println("3: Pour modifier une fillieres");
        System.out.println("4: Pour supprimer une fillieres");
        System.out.println("0: Pour retourner au menu principal");

        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch (option) {
            case 1:
                createFilliere();
                break;
            case 2:
                showFillieres();
                break;
            case 3:
                editFilliere();
                break;
            case 4:
                destroyFilliere();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }
    public static void showFillieres() {
        for (Filliere filliere: database.fillieres) {
            System.out.print("Id : " + filliere.getId());
            System.out.print(" |intitule : " +  filliere.getIntitule() );
            if (!Main.isNull(filliere.getResponsable())) {
                System.out.print(" | Responsable : " +filliere.getResponsable().getNom() + " " + filliere.getResponsable().getPrenom());
            }

            System.out.println("");
        }
    }
    public static void createFilliere ()  {
        String intitule = Main.getStringInput("Entrez l'intitulé :");
        EnseignantController.showEnseignants();
        int id = Main.getIntInput("Sélecionnez un enseignant par id :");
        DepartementController.showDepartements();
        int iddep = Main.getIntInput("Sélecionnez un departement par id :");
        FilliereServ.addFilliere(intitule, EnseignantServ.getEnsById(id),DepartementServ.getDeptById(iddep));

        showFillieres();
        showMenu();

    }
    public static void editFilliere () {
        showFillieres();
        int id = Main.getIntInput("Sélecionnez une filliere par id :");
        String intitule = Main.getStringInput("Entrez l'intitulé :");
        EnseignantController.showEnseignants();
        int idEns = Main.getIntInput("Sélecionnez un enseignant par id :");
        DepartementController.showDepartements();
        int iddept = Main.getIntInput("Sélecionnez un departement par id :");

        FilliereServ.updateFiliere(id, intitule, EnseignantServ.getEnsById(idEns),DepartementServ.getDeptById(iddept));

        showFillieres();
        showMenu();
    }
    public static void destroyFilliere () {
        showFillieres();
        int id = Main.getIntInput("Sélecionnez une filliere par id :");
        FilliereServ.deleteFiliereById(id);
        showFillieres();

    }



}

