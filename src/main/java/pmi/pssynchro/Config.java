package pmi.pssynchro;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

    //FILE PROPERTIES
    private static  String fileProperties="config.properties";

      private Config() {
        
      }
      /**
       * 
public static synchronized String getString(String key) 

       * QUESTO METODO PERMETTE DI RECUPERARE UN VALORE DAL FILE CONFIG.PROPERTIES
       *  
       * 
ReadOnly

       * @param pKey DI TIPO STRING
     * @return VALORE DI KEY SE PRESENTE - ALTRIMENTI STRINGA VUOTA
     * 
     */
      public static synchronized String getString(String pKey) {
          //VALORE DI RITORNO
          String myReturn="";
          //NUOVA ISTANZA PROPERTIES
          Properties props = new Properties();

          try {
              //CARICO IL FILE DI CONFIGURAZIONE
              props.load(new FileInputStream(fileProperties));
              //LEGGO IL VALORE DI RITORNO
              myReturn = props.getProperty(pKey);
          } catch(IOException e) {
                // utility.showSimpleMessage("ERRORE NELLA LETTURA DEL FILE CONFIG.PRPERTIES NELLA CHIAVE: " + pKey + "\nERRORE: " + e.getMessage());
          }
          //RITORNA myReturn OPPURE UNA STRINGA VUOTA
          return myReturn ;

      }
      
    /**
     * 
public static synchronized void  setProperty(String key, String value)

     * QUESTO METODO PERMETTE DI SCRIVERE UN VALORE NEL FILE CONFIG.PROPERTIES
     *  
     * 
WriteOnly

     * @param pKey DI TIPO STRING - RAPPRESENTA LA CHIAVE DA INSERIRE
     * @param pValue DI TIPO STRING - RAPPRESENTA IL VALORE CHE SI VUOLE ATTRIBUIRE ALLA CHIAVE
     * 
     * 
     */
      public static synchronized void  setProperty(String pKey, String pValue)  {
          //CREO UNA NUOVA ISTANZA DI PROPERTIES
          Properties properties = new Properties();
          
          try {
              //CARICO IL FILE
              properties.load(new FileInputStream(fileProperties));
                  //SCRIVO LA CHIAVE
              properties.setProperty(pKey, pValue);
            } catch (IOException e) {
                 
                //Utility.showSimpleMessage("ERRORE NELLA LETTURA DEL FILE: " + fileProperties + "\nERRORE: " + e.getMessage());
                System.out.println("ERRORE NELLA LETTURA DEL FILE: " + fileProperties + "\nERRORE: " + e.getMessage());
            }
            

            
            //SALVO IL FILE
            try {
                properties.store(new FileOutputStream("config.properties"), null);
            } catch (IOException e) {
                //Utility.showSimpleMessage("ERRORE NEL SALVATAGGIO DEL FILE " + fileProperties + "\nERRORE: " + e.getMessage());
                 System.out.println("ERRORE NEL SALVATAGGIO DEL FILE " + fileProperties + "\nERRORE: " + e.getMessage());
            }




    }
      

}
