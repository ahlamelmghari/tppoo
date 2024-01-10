package phase1.models;

public class Module {
    private int id;
    private String intitule;
    private Enseignant proffesseur;
    private Filliere filliere;

    public Module() {
    }

    public Module(String intitule, Enseignant proffesseur, Filliere filliere) {
        this.intitule = intitule;
        this.proffesseur = proffesseur;
        this.filliere = filliere;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Enseignant getChef() {
        return proffesseur;
    }

    public void setChef(Enseignant proffesseur) {
        this.proffesseur = proffesseur;
    }

    public Filliere getFilliere() {
        return filliere;
    }

    public void setFilliere(Filliere filliere) {
        this.filliere = filliere;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
