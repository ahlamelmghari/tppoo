package phase1;
import phase1.controleurs.*;
import phase1.models.Enseignant;
import phase1.models.etudiant;
import phase1.service.database;
import java.util.Scanner;
import  phase2.*;
import java.sql.*;

public class Main {
    public static boolean isNull(Object obj) {
        return obj == null;
    }

    public static int getIntInput(String... msg) {
        Scanner scan = new Scanner(System.in);
        String message = "Entrez un nombre entier : ";
        if (msg.length > 0)
            message = msg[0];
        System.out.print(message);


        // This method reads the number provided using keyboard
        int num = scan.nextInt();

        // Closing Scanner after the use
        //  scan.close();
        return num;
    }

    public static String getStringInput(String... msg) {
        Scanner scan = new Scanner(System.in);
        String message = "Entrez un texte : ";
        if (msg.length > 0)
            message = msg[0];
        System.out.print(message);

        // This method reads the number provided using keyboard
        String str = scan.nextLine();

        // Closing Scanner after the use
        //  scan.close();
        return str;
    }

    public static void showPrincipalMenu()  {
      System.out.println("-------------------------[ Bienvenu ]---------------------------");


        System.out.println("1: Pour gérer les départements");
        System.out.println("2: Pour gérer les filières");
        System.out.println("3: Pour gérer les enseignants");
        System.out.println("4: Pour gérer les modules");
        System.out.println("5: Pour gérer les étudiants");
        System.out.println("0: Pour sortir");

        //"Veuillez sélectionner une option : ")
        int option = getIntInput("Veuillez sélectionner une option : ");
        switch (option) {
            case 1:
                DepartementController.showMenu();
                break;
            case 2:
                FilliereController.showMenu();
                break;
            case 3:
                EnseignantController.showMenu();
                break;
            case 4:
                ModuleController.showMenu();
                break;
            case 5:
                EtudiantController.showMenu();
                break;
            default:
                // code block
        }}
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Enseignant enseignant = new Enseignant();
        enseignant.setNom("meryam");
        enseignant.setPrenom("oualmam");
        enseignant.setEmail("meryam@gmail.com");
        enseignant.setGrade("PES");
        enseignant.setId(database.getEnsId());
        database.enseignants.add(enseignant);
        showPrincipalMenu();


    }


    }



