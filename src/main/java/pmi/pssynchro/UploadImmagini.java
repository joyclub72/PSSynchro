package pmi.pssynchro;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPConnectionClosedException;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.net.ftp.FTPSClient;

public class UploadImmagini {

    public void FtpUpload(/*poi gestirò i parametri*/) throws NoSuchAlgorithmException {
        boolean storeFile = false, binaryTransfer = false, error = false;
        String server, username, password, remote, local;
        String protocol = "TLS";    // SSL/TLS
        FTPSClient ftps;
        storeFile = true;
        binaryTransfer = true;
        server = "81.29.220.70";
        username = "ftpsuput@pmisoftware.it";
        password = "R50=j8@2017";
        remote = "test.png";
        local = "c://test.zip";

        ftps = new FTPSClient(protocol);

        ftps.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));

        try {
            int reply;

            ftps.connect(server);
            System.out.println("Connesso a " + server + ".");

            // After connection attempt, you should check the reply code to verify
            // success.
            reply = ftps.getReplyCode();

            if (!FTPReply.isPositiveCompletion(reply)) {
                ftps.disconnect();
                System.err.println("FTP server refused connection.");
                //System.exit(1);
            }
        } catch (IOException e) {
            if (ftps.isConnected()) {
                try {
                    ftps.disconnect();
                } catch (IOException f) {
                    // do nothing
                }
            }
            System.err.println("Could not connect to server.");
        }

        __main:
        try {
            ftps.setBufferSize(1000);

            if (!ftps.login(username, password)) {
                ftps.logout();
                error = true;
                break __main;
            }

            ftps.changeWorkingDirectory("shop");
            System.out.println("Remote system is " + ftps.getSystemName());

            if (binaryTransfer) {
                ftps.setFileType(FTP.BINARY_FILE_TYPE);
            }

            // Use passive mode as default because most of us are
            // behind firewalls these days.
            ftps.enterLocalPassiveMode();

            if (storeFile) {   /*upload*/
                InputStream input;
                input = new FileInputStream(local);
                ftps.storeFile(remote, input);
                input.close();
            } else {          /*download*/
                OutputStream output;
                output = new FileOutputStream(local);
                ftps.retrieveFile(remote, output);
                output.close();
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
                } catch (IOException f) {
                    // do nothing
                }
            }
        }
        //System.exit(error ? 1 : 0);
    } // end main    
    
}
