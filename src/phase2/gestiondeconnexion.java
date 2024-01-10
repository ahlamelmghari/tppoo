package phase2;
import phase1.models.Departement;
import phase1.models.Enseignant;
import phase1.service.database;
import phase1.Main;
import java.sql.Statement;
import java.sql.Connection;


import java.sql.*;
import java.util.ArrayList;

public class gestiondeconnexion {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/system";
        String user = "root";
        String pwd = "";
        try {
            Connection cx = DriverManager.getConnection(url, user, pwd);
            System.out.println("Good Connection");


            //createDepart(cx);
            //createEnseignant(cx);
            getdepart(cx);
            //ajouteEnse(new Enseignant(1, "mounia", "mghari", "mounia@gmail.com", "prof"), cx);
            //ajouteDepart(new Departement(1, "info", new Enseignant(1, "aya", "raoui", "aya@gmail.com", "grade2")), cx);
            //ArrayList<Departement> departements= getdepart(cx);
           // for (Departement departement:departements){
             //   System.out.println(departement.toString());}


        } catch (SQLException e) {
            System.out.println("Bad Connection");
            e.printStackTrace();
        }
    }

   /* public static void createDepart(Connection cx) throws SQLException {
        String req = "CREATE TABLE IF NOT EXISTS Departement (\n" +
                "iddep INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "intitule VARCHAR(50) CHARACTER SET utf8 NULL,\n" +
                "enseignant INT,\n" +
                "FOREIGN KEY (enseignant) REFERENCES Enseignant (idens)\n" +
                ");";

        Statement stmt = cx.createStatement();
        stmt.executeUpdate(req);
        System.out.println(" departement a été crée avec succès.");
    }

    /*public static void createEnseignant(Connection cx) throws SQLException {
        String req1 = "CREATE TABLE IF NOT EXISTS Enseignant (\n" +
                "idens INT AUTO_INCREMENT PRIMARY KEY,\n" +
                " nom VARCHAR(50) CHARACTER SET utf8 NULL,\n" +
                "prenom VARCHAR(50) CHARACTER SET utf8 NULL,\n" +
                "email VARCHAR(50) CHARACTER SET utf8 NULL,\n" +
                "grade VARCHAR(50) CHARACTER SET utf8 NULL\n" +
                ");";
        try (Statement smt = cx.createStatement()) {
            smt.executeUpdate(req1);
            System.out.println("une nouvelle table 'enseignant' a ete cree avec succes.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

    /*public static void ajouteDepart(Departement departement,Connection cx ) throws SQLException {
        String rep = "insert into Departement (iddep,intitule,enseignant)values (?,?,?)";
        try (PreparedStatement stmt = cx.prepareStatement(rep)) {
            stmt.setInt(1, departement.getId());
            stmt.setString(2, departement.getIntitule());
            stmt.setInt(3, departement.getResponsable());
            stmt.executeUpdate();
            database.departements.add(departement);
            System.out.println("ajout avec succes");


        }

}
   /* public static void ajouteEnse (Enseignant enseignant, Connection cx) throws SQLException {
        String rep1 = "insert into Enseignant (idens,nom,prenom,email,grade)values (?,?,?,?,?)";

        try (PreparedStatement statement = cx.prepareStatement(rep1)) {
            statement.setInt(1, enseignant.getId());
            statement.setString(2, enseignant.getNom());
            statement.setString(3, enseignant.getPrenom());
            statement.setString(4, enseignant.getEmail());
            statement.setString(5, enseignant.getGrade());
            statement.executeUpdate();
            database.enseignants.add(enseignant);
        }
}
    /*public static void deletedepartement ( int id, Connection cx) throws SQLException {
        String req2 = "delete from Departement where iddep=?";
        PreparedStatement ps = cx.prepareStatement(req2);
        ps.setInt(1, id);
        ps.executeUpdate();
        System.out.println("votre deparetement a ete surpprime");
    }*/
public static ArrayList<Departement> getdepart( Connection cx) throws SQLException{
        String req3="select *from Departement";
        ArrayList<Departement> departements= new ArrayList<>();
        Statement statement=cx.createStatement();
        ResultSet rslt = statement.executeQuery(req3);
        while (rslt.next()){
            Departement departement1=new Departement();
            departement1.setId(rslt.getInt("iddep"));
            departement1.setIntitule(rslt.getString("intitule"));
            Enseignant chef =new Enseignant();
            chef.setId(rslt.getInt("enseignant"));
            departement1.setResponsable(chef);
            departements.add(departement1);
        }
        return departements;
}

public static  void modifieEnseignant(Enseignant enseignant,Connection cx)throws SQLException{
    String req5="UPDATE Enseignant SET nom=?,prenom=? ,email =?,grade=?  where idens=?";
    try (PreparedStatement stmt=cx.prepareStatement(req5)){
        stmt.setString(1,enseignant.getNom());
        stmt.setString(2,enseignant.getPrenom());
        stmt.setString(3,enseignant.getEmail());
        stmt.setString(4,enseignant.getGrade());
        stmt.setInt(5,enseignant.getId());
        stmt.executeUpdate();
        System.out.println("modification avec succes");
    }
}
}

















