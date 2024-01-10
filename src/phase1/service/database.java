package phase1.service;
import phase1.models.*;
import phase1.models.Module;

//import models.Module;
import java.util.ArrayList;


public class database {
    public static int DEPT_ID = 0;
    public static int ENS_ID = 0;
    public static int ETD_ID = 0;
    public static int FIL_ID = 0;
    public static int MOD_ID = 0;
    public static ArrayList<Departement> departements = new ArrayList<Departement>();
    public static ArrayList<Enseignant> enseignants = new ArrayList<Enseignant>();
    public static ArrayList<Filliere> fillieres = new ArrayList<Filliere>();
    public static ArrayList<Module> modules = new ArrayList<Module>();
    public static ArrayList<etudiant> etudiants = new ArrayList<etudiant>();
    public static ArrayList<Note> notes = new ArrayList<Note>();

    public  static int getDeptId(){
        DEPT_ID++;
        return DEPT_ID;
    }
    public  static int getEnsId(){
        ENS_ID++;
        return ENS_ID;
    }
    public  static int getEtdId(){
        ETD_ID++;
        return ETD_ID;
    }
    public  static int getFilId(){
        FIL_ID++;
        return FIL_ID;
    }
    public  static int getModId(){
        MOD_ID++;
        return MOD_ID;
    }
}
