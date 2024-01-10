package phase1.controleurs;
import phase1.models.Departement;
import phase1.Main;
import phase1.models.Enseignant;
import phase1.service.database;
import phase1.service.DepartementServ;
import phase1.service.EnseignantServ;

import java.sql.SQLException;


public class DepartementController {
    public static void showMenu()  {
        System.out.println("-------------------------[ Départements ]---------------------------");


        System.out.println("1: Pour ajouter un département");
        System.out.println("2: Pour afficher les départements");
        System.out.println("3: Pour modifier un département");
        System.out.println("4: Pour supprimer un département");
        System.out.println("0: Pour retourner au menu principal");


        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch (option) {
            case 1:
                createDepartement();
                break;
            case 2:
                showDepartements();
                break;
            case 3:
                editDepartement();
                break;
            case 4:
                destroyDepartement();
                break;
            default:
                Main.showPrincipalMenu();
        }}
        public static void showDepartements()  {

            for (Departement departement:database.departements){
                System.out.println(departement.getId());
                System.out.println(departement.getIntitule());

            if (!Main.isNull(departement.getResponsable())) {
                System.out.print(" | Responsable : " +departement.getResponsable());
            }
            System.out.println("");
    }}
            public static void createDepartement () {
                String intitule = Main.getStringInput("Entrez l'intitulé :");
                EnseignantController.showEnseignants();
                int id = Main.getIntInput("Sélecionnez un enseignant par id :");

                DepartementServ.addDepart(intitule,EnseignantServ.getEnsById(id) );

                showDepartements();
                showMenu();


            }
            public static void editDepartement()  {
                showDepartements();
                int id = Main.getIntInput("Sélecionnez un departement par id :");
                String intitule = Main.getStringInput("Entrez l'intitulé :");
                EnseignantController.showEnseignants();
                int idEns = Main.getIntInput("Sélecionnez un enseignant par id :");

                DepartementServ.updateDepart(id, intitule, EnseignantServ.getEnsById(idEns));

                showDepartements();
                showMenu();
            }
            public static void destroyDepartement ()  {
                showDepartements();
                int id = Main.getIntInput("Sélecionnez un departement par id :");
                DepartementServ.deleteDeptById(id);
                showDepartements();

            }


        }



