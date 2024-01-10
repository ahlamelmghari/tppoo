package phase1.models;

public class Note {

    private float note;
    private etudiant etudiantt;
    private Filliere filliere;

    public Note() {
    }

    public Note(float note, etudiant etudiantt, Filliere filliere) {
        this.note = note;
        this.etudiantt = etudiantt;
        this.filliere = filliere;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public etudiant getEtudiant() {
        return etudiantt;
    }

    public void setEtudiant(etudiant etudiantt) {
        this.etudiantt = etudiantt;
    }

    public Filliere getFiliere() {
        return filliere;
    }

    public void setFilliere(Filliere filliere) {
        this.filliere = filliere;
    }
}