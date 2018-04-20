package pmi.pssynchro;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPConnectionClosedException;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.net.ftp.FTPSClient;


public class UploadImmagini {
    public void FtpUpload(String server, String username, String password, String percorsoRemoto, String percorsoLocale, String fileImmagine, String all, String check) throws NoSuchAlgorithmException, InterruptedException {
        boolean storeFile = false, binaryTransfer = false, error = false;
        final String remote;
        String local;
        String protocol = "TLS";    // SSL/TLS
        FTPSClient ftps;
        storeFile = true;
        binaryTransfer = true;
        URL sito = null;
        String sUrl = Config.getString("URL");
        local = percorsoLocale.concat(fileImmagine);
        remote = fileImmagine;
        ftps = new FTPSClient(protocol);
        ftps.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
        URLConnection yc = null;
        BufferedReader in;
        
            /*Stampe di test*/
            System.out.println("Percorso locale: " + percorsoLocale);
            System.out.println("File di check: " + check + " - Esiste? " + Varie.esiste(check));
            System.out.println("File immagine locale: " + local + " - Esiste? " + Varie.esisteFile(local));
            /*Fine stampe di test*/
            
        if (!(Varie.esiste(check)) && !(Varie.esisteFile(local))) {  /* Procedo solo se non esiste il file ok.txt e il file imageFTP*/
            /* Prima richiesta di generazione immagini da caricare */

            try {
                sito = new URL(sUrl + "?aggiornamento=arimmagini1" + all);
            } catch (MalformedURLException ex) {
                System.out.println("Indirizzo del sito mal formato o inesistente");
            }

            try {
                yc = sito.openConnection();
                System.out.println(sito + " - Apertura connessione");/*test*/
            } catch (IOException ex) {
                System.out.println("Errore di connessione _ ");
            }

            try {
                in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
                System.out.println(sito + " - Comunicazione");/*test*/
            } catch (IOException ex) {
                System.out.println(": Errore in ricezione dati: verificare che il "
                        + "server sia avviato o che l'indirizzo sia corretto");
                return;
            }

            /*Verifico l'esistenza del file di check che mi informa che posso proseguire*/
            while (!(Varie.esiste(check))) {
                System.out.print("-");
                TimeUnit.SECONDS.sleep(5);
            }

        }
        /*Procedura di upload vera e propria*/
   
        try {
            int reply;

            ftps.connect(server);
            System.out.println("Connesso a " + server + ".");

            // After connection attempt, you should check the reply code to verify
            // success.
            reply = ftps.getReplyCode();

            if (!FTPReply.isPositiveCompletion(reply)) {
                ftps.disconnect();
                System.err.println("Il server FTP ha rifiutato la connessione.");
            }
        } catch (IOException e) {
            if (ftps.isConnected()) {
                try {
                    ftps.disconnect();
                } catch (IOException f) {
                    // do nothing
                }
            }
            System.err.println("Non riesco a collegarmi al server FTP.");
        }

        __main:
        try {
            ftps.setBufferSize(1000);

            if (!ftps.login(username, password)) {
                ftps.logout();
                error = true;
                break __main;
            }

            ftps.changeWorkingDirectory(percorsoRemoto);
            System.out.println("Remote system is " + ftps.getSystemName());

            if (binaryTransfer) {
                ftps.setFileType(FTP.BINARY_FILE_TYPE);
            }

            // Use passive mode as default because most of us are
            // behind firewalls these days.
            ftps.enterLocalPassiveMode();
          
            if (storeFile) {
                /*upload*/
                System.out.println("Il file esiste");
                InputStream input;
                input = new FileInputStream(local);
                ftps.setControlKeepAliveTimeout(180); // set timeout to 3 minutes
                ftps.storeFile(remote, input);
                input.close();
                System.out.println("Upload terminato");
            } 

            ftps.logout();
        } catch (FTPConnectionClosedException e) {
            error = true;
            System.err.println("Server closed connection.");
        } catch (IOException e) {
            error = true;
        } finally {
            if (ftps.isConnected()) {
                try {
                    ftps.disconnect();
                    System.out.println("Disconnessione effettuata");
                } catch (IOException f) {
                    // do nothing
                }

            }
        }
        try {
            sito = new URL(sUrl + "?aggiornamento=arimmagini2" + all);
        } catch (MalformedURLException ex) {
            System.out.println("Indirizzo del sito mal formato o inesistente");
        }
        try {
            yc = sito.openConnection();
            System.out.println(sito + " - Apertura connessione");/*test*/
        } catch (IOException ex) {
            System.out.println("Errore di connessione _ ");
        }
        try {
            in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            System.out.println(sito + " - Comunicazione");/*test*/
        } catch (IOException ex) {
            System.out.println(": Errore in ricezione dati: verificare che il "
                    + "server sia avviato o che l'indirizzo sia corretto");
        }       //System.exit(error ? 1 : 0);
        /*Fine procedura upload vera e propria*/

        
    } // end main    

}
