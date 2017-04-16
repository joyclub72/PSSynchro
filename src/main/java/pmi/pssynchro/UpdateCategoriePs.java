package pmi.pssynchro;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.Statement;

public class UpdateCategoriePs
{
   public void dbConnect(
            String db_connect_string,
            String db_userid,
            String db_password,
            String db_database)
   {
      try {
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         Connection conn = DriverManager.getConnection(db_connect_string, db_userid, db_password);
         System.out.println("Connessione per update categorie effettuata");
         Statement statement = conn.createStatement();
         String queryString = db_database+".dbo.xasp_PSCategorie";
         int rs = statement.executeUpdate(queryString);
         if(rs==1)
             System.out.println("Update categorie su SQL eseguito");
         else
             System.out.println("Update categorie su SQL FALLITO! ("+rs+")");
      } catch (Exception e) {
         //e.printStackTrace();
         System.out.println(e.toString());
         System.out.println("La struttura delle categorie web non è stata aggiornata");
      }
   }
}
