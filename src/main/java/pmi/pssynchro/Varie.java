package pmi.pssynchro;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author nicola
 */
public class Varie {

    /*Controllo se un file esiste*/
    public static boolean esiste(String URLName) {
        try {
            HttpURLConnection.setFollowRedirects(false);
            // note : you may also need
            //        HttpURLConnection.setInstanceFollowRedirects(false)
            HttpURLConnection con
                    = (HttpURLConnection) new URL(URLName).openConnection();
            con.setRequestMethod("HEAD");
            return (con.getResponseCode() == HttpURLConnection.HTTP_OK);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean esisteFile(String percorsoFile) {
        File esisteFile;
        esisteFile = new File(percorsoFile);
        return esisteFile.isFile();
    }
}
