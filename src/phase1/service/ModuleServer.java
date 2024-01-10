package phase1.service;
import phase1.models.Filliere;
import phase1.models.Enseignant;
import phase1.models.Module;
import phase1.service.database;

import java.util.ArrayList;

public class ModuleServer {
    public static Module addModule(String intitule, Filliere filliere , Enseignant proffesseur){
        Module module =new Module ();
        module.setIntitule(intitule);
        module.setFilliere(filliere);
        module.setChef(proffesseur);
        module.setId(database.getModId());
        database.modules.add((module));

        return module;
    }
    public static Module updateModule(int id,String intitule, Filliere filliere , Enseignant proffesseur){
        for (Module module:database.modules){
            if(module.getId()==id){
                module.setIntitule(intitule);
                module.setFilliere(filliere);
                module.setChef(proffesseur);
                return module;
            }
        }

        return new Module();
    }
    public static ArrayList<Module> deleteModuleById(int id){
        database.modules.remove(getModuleById(id));
        return database.modules;
    }
    public static Module getModuleById(int id){
        for (Module module:database.modules){
            if (module.getId()==id){
                return module;
            }
        }
        return  new Module();
    }

    public static ArrayList<Module> getAllModule(){
        return  database.modules;
    }

}
