package phase1.controleurs;
import phase1.Main;

import phase1.models.Module;

import phase1.service.EnseignantServ;
import phase1.service.FilliereServ;
import phase1.service.ModuleServer;
import phase1.service.database;

import java.sql.SQLException;

public class ModuleController {
    public static void showMenu()  {
        System.out.println("-------------------------[ Modules]---------------------------");


        System.out.println("1: Pour ajouter une module");
        System.out.println("2: Pour afficher les modules");
        System.out.println("3: Pour modifier une modules");
        System.out.println("4: Pour supprimer une module");
        System.out.println("0: Pour retourner au menu principal");

        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch (option) {
            case 1:
                createModule();
                break;
            case 2:
                showModule();
                break;
            case 3:
                editModule();
                break;
            case 4:
                destroyModule();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }
    public static void showModule() {
        for (Module module: database.modules) {
            System.out.print("Id : " + module.getId());
            System.out.print(" |intitule : " +  module.getIntitule() );
            if (!Main.isNull(module.getChef())) {
                System.out.print(" | Responsable : " +module.getChef().getNom() + " " + module.getChef().getPrenom());
            }

            System.out.println("");
        }
    }
    public static void createModule ()  {
        String intitule = Main.getStringInput("Entrez l'intitulé :");
        EnseignantController.showEnseignants();
        int id = Main.getIntInput("Sélecionnez un enseignant par id :");
        DepartementController.showDepartements();
        int idFil = Main.getIntInput("Sélecionnez une filiere par id :");
        ModuleServer.addModule(intitule, FilliereServ.getFileById(idFil),EnseignantServ.getEnsById(id));


        showModule();
        showMenu();

    }
    public static void editModule()  {
        showModule();
        int id = Main.getIntInput("Sélecionnez une filliere par id :");
        String intitule = Main.getStringInput("Entrez l'intitulé :");
        EnseignantController.showEnseignants();
        int idEns = Main.getIntInput("Sélecionnez un enseignant par id :");
        DepartementController.showDepartements();
        int idFil = Main.getIntInput("Sélecionnez une filiere par id :");

        ModuleServer.updateModule(id, intitule,FilliereServ.getFileById(idFil),EnseignantServ.getEnsById(idEns));

        showModule();
        showMenu();
    }
    public static void destroyModule () {
        showModule();
        int id = Main.getIntInput("Sélecionnez une filliere par id :");
        ModuleServer.deleteModuleById(id);
        showModule();

    }

}
