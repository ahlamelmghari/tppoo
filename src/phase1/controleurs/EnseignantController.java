package phase1.controleurs;
import phase1.models.Enseignant;
import phase1.service.DepartementServ;
import phase1.service.EnseignantServ;
import phase1.service.database;

import phase1.Main;

import java.sql.SQLException;


public class EnseignantController {
    public static void showMenu() {
        System.out.println("-------------------------[ Enseignants ]---------------------------");


        System.out.println("1: Pour ajouter un enseignant");
        System.out.println("2: Pour afficher les enseignants");
        System.out.println("3: Pour modifier un enseignant");
        System.out.println("4: Pour supprimer un enseignant");
        System.out.println("0: Pour retourner au menu principal");

        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch (option) {
            case 1:
                createEnseignant();
                break;
            case 2:
                showEnseignants();
                break;
            case 3:
                editEnseignant();
                break;
            case 4:
                destroyEnseignant();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }

    public static void showEnseignants() {
        for (Enseignant enseignant : database.enseignants) {
            System.out.print("Id : " + enseignant.getId());
            System.out.print(" | Nom : " + enseignant.getNom() + " " + enseignant.getPrenom());
            System.out.print(" | Email : " + enseignant.getEmail());


            System.out.println("");
        }
    }

    public static void createEnseignant()  {
        String nom = Main.getStringInput("Entrez le nom :");
        String prenom = Main.getStringInput("Entrez le prenom :");
        String email = Main.getStringInput("enter l eamil:");
        String grade = Main.getStringInput("enter le grade:");
        DepartementController.showDepartements();
        int id = Main.getIntInput("Sélecionnez un deparetement par id :");
        EnseignantServ.addEns(nom, prenom, email, grade, DepartementServ.getDeptById(id));

        showEnseignants();
        showMenu();

    }

    public static void editEnseignant() {
        showEnseignants();
        int id = Main.getIntInput("Sélecionnez un enseignant par id :");
        String nom = Main.getStringInput("Entrez nom :");
        String prenom = Main.getStringInput("Entrez prenom :");
        String email = Main.getStringInput("Entrez email :");
        String grade = Main.getStringInput("Entrez grade :");

        DepartementController.showDepartements();
        int idDepart = Main.getIntInput("Sélecionnez un enseignant par id :");

        EnseignantServ.updateEns(id, nom, prenom, email, grade, DepartementServ.getDeptById(idDepart));

        showEnseignants();
        showMenu();
    }

    public static void destroyEnseignant() {
        showEnseignants();
        int id = Main.getIntInput("Sélecionnez un enseignant par id :");
        EnseignantServ.deleteEnsById(id);
        showEnseignants();

    }
}
