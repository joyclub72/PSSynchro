package pmi.pssynchro;

import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.Statement;
import java.net.URL;
import java.sql.SQLException;

public class UpdateMagazzinoEsternoPS {

    public void dbConnect(
            String db_connect_string,
            String db_userid,
            String db_password,
            String db_database) {
        try {
            URL sitoMag=null;
            sitoMag = new URL(Config.getString("URLMAGAZZINO"));
            String codMagEst = Config.getString("CODICEMAGAZZINO");
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(db_connect_string, db_userid, db_password);
            System.out.println("Connessione per update magazzino esterno effettuata");
            Statement statement = conn.createStatement();
            String queryString = "exec " + db_database + ".dbo.xasp_PSImpGiacFor " +"'"+sitoMag+"'" + ", " + "'"+codMagEst+"'";
            int rs = statement.executeUpdate(queryString);
            if (rs > -1) {
                System.out.println("Update magazzino "+ codMagEst +" effettuato");
                System.out.println("Inserite "+rs+" giacenze.");
            } else {
                System.out.println("Update categorie su SQL FALLITO! (" + rs + ")");
            }
        } catch (MalformedURLException e) {
            System.out.println(e.toString());
            System.out.println("La struttura delle categorie web non è stata aggiornata");
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
            System.out.println("La struttura delle categorie web non è stata aggiornata");
        } catch (SQLException e) {
            System.out.println(e.toString());
            System.out.println("La struttura delle categorie web non è stata aggiornata");
        }
    }
}
