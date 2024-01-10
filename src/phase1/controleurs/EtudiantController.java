package phase1.controleurs;

import phase1.Main;
import phase1.service.Etudiantserv;
import phase1.models.etudiant;
import phase1.service.*;
import phase1.service.FilliereServ;

import java.sql.SQLException;

public class EtudiantController {
    public static void showMenu()  {
        System.out.println("-------------------------[ Etudiants ]---------------------------");


        System.out.println("1: Pour ajouter un etudiant");
        System.out.println("2: Pour afficher les etudiants");
        System.out.println("3: Pour modifier un etudiant");
        System.out.println("4: Pour supprimer un etudiant");
        System.out.println("0: Pour retourner au menu principal");

        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch (option) {
            case 1:
                createEtudiant();
                break;
            case 2:
                showEtudiants();
                break;
            case 3:
                editEtudiant();
                break;
            case 4:
                destroyEtudiant();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }
    public static void showEtudiants() {
        for (etudiant etudiantt : database.etudiants) {
            System.out.print("Id : " + etudiantt.getId());
            System.out.print(" | Nom : " + etudiantt.getNom() + " " + etudiantt.getPrenom());
            System.out.print(" | Email : " + etudiantt.getEmail());
            System.out.print(" | Apogee: " + etudiantt.getApogee());


            System.out.println("");
        }
    }
    public static void createEtudiant() {
        String nom = Main.getStringInput("Entrez le nom :");
        String prenom = Main.getStringInput("Entrez le prenom :");
        String email = Main.getStringInput("enter l eamil:");
        int apogee = Main.getIntInput("enter l apogee:");
        DepartementController.showDepartements();
        int id = Main.getIntInput("Sélecionnez une filliere par id :");
        Etudiantserv.addEtd(nom, prenom, email, apogee, FilliereServ.getFileById(id));

        showEtudiants();
        showMenu();

    }
    public static void editEtudiant() {
        showEtudiants();
        int id = Main.getIntInput("Sélecionnez un etudiant par id :");
        String nom = Main.getStringInput("Entrez nom :");
        String prenom = Main.getStringInput("Entrez prenom :");
        String email = Main.getStringInput("Entrez email :");
        int apogee = Main.getIntInput("Entrez apogee :");

        DepartementController.showDepartements();
        int idFil = Main.getIntInput("Sélecionnez une filliere par id :");

        Etudiantserv.updateEtd(id, nom, prenom, email, apogee, FilliereServ.getFileById(idFil));

        showEtudiants();
        showMenu();
    }
    public static void destroyEtudiant() {
        showEtudiants();
        int id = Main.getIntInput("Sélecionnez un etudiant par id :");
        Etudiantserv.deleteEtdById(id);
        showEtudiants();

    }

}
