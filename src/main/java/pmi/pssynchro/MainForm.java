package pmi.pssynchro;


import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.net.URL;
import java.net.MalformedURLException;
import java.awt.*;
import java.awt.event.*;
import java.io.OutputStream;
import java.io.PrintStream;
import javax.swing.SwingUtilities;

public class MainForm extends javax.swing.JFrame {

    boolean stopped = false;
    public static Timer timer;
    String sUrl = Config.getString("URL");
    int magRitardo = Integer.parseInt((Config.getString("MAGAZZINO") + "000"))*60;    //ritardo aggiornamento magazzino esterno
    int giacRitardo = Integer.parseInt((Config.getString("GIACENZA") + "000"))*60;
    int cliRitardo = Integer.parseInt((Config.getString("CLIENTI") + "000"))*60;
    int artRitardo = Integer.parseInt((Config.getString("ARTICOLI") + "000"))*60;
    int forRitardo = Integer.parseInt((Config.getString("FORNITORI") + "000"))*60;
    int immRitardo = Integer.parseInt((Config.getString("IMMAGINI") + "000"))*60;
    int allRitardo = Integer.parseInt((Config.getString("ALLEGATI") + "000"))*60;
    int scaRitardo = Integer.parseInt((Config.getString("SCADENZARIO") + "000"))*60;
    int staRitardo = Integer.parseInt((Config.getString("STATISTICHE") + "000"))*60;
    int marRitardo = Integer.parseInt((Config.getString("MARCHE") + "000"))*60;
    int ordRitardo = Integer.parseInt((Config.getString("ORDINI") + "000"))*60;
    int linRitardo = Integer.parseInt((Config.getString("LINGUE") + "000"))*60;
    int clearEvery = Integer.parseInt((Config.getString("PULIZIAAREA") + "000"))*60;
    Date dataErrore;

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        jScrollPane1 = new javax.swing.JScrollPane();
        esito = new javax.swing.JTextArea();
        clearArea = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        runOnceOrd = new javax.swing.JButton();
        sysTray = new javax.swing.JButton();
        runOnceSca = new javax.swing.JButton();
        mostraStream = new javax.swing.JRadioButton();
        runOnceSta = new javax.swing.JButton();
        runOnceGiac = new javax.swing.JButton();
        runOnceArt = new javax.swing.JButton();
        stop = new javax.swing.JButton();
        runOnceImm = new javax.swing.JButton();
        runOnceFor = new javax.swing.JButton();
        start = new javax.swing.JButton();
        stato = new javax.swing.JLabel();
        runOnceCli = new javax.swing.JButton();
        runOnceMar = new javax.swing.JButton();
        config = new javax.swing.JButton();
        runOnceLin = new javax.swing.JButton();
        runOnceAll = new javax.swing.JButton();
        esci = new javax.swing.JButton();
        runOnceMagEst = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("PrestaShopSync");

        esito.setColumns(20);
        esito.setRows(5);
        jScrollPane1.setViewportView(esito);
        esito.getAccessibleContext().setAccessibleParent(esito);

        clearArea.setBackground(java.awt.Color.white);
        clearArea.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        clearArea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clean.png"))); // NOI18N
        clearArea.setToolTipText("Pulisci Text Area");
        clearArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearAreaActionPerformed(evt);
            }
        });

        runOnceOrd.setBackground(java.awt.Color.white);
        runOnceOrd.setText("Ordini");
        runOnceOrd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runOnceOrdActionPerformed(evt);
            }
        });

        sysTray.setBackground(java.awt.Color.white);
        sysTray.setIcon(new javax.swing.ImageIcon(getClass().getResource("/to_tray.png"))); // NOI18N
        sysTray.setToolTipText("System Tray");
        sysTray.setFocusable(false);
        sysTray.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sysTray.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        sysTray.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sysTrayActionPerformed(evt);
            }
        });

        runOnceSca.setBackground(java.awt.Color.white);
        runOnceSca.setText("Scadenze");
        runOnceSca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runOnceScaActionPerformed(evt);
            }
        });

        mostraStream.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        mostraStream.setText("Mostra Stream");

        runOnceSta.setBackground(java.awt.Color.white);
        runOnceSta.setText("Statistiche");
        runOnceSta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runOnceStaActionPerformed(evt);
            }
        });

        runOnceGiac.setBackground(java.awt.Color.white);
        runOnceGiac.setText("Giacenze");
        runOnceGiac.setMaximumSize(new java.awt.Dimension(79, 23));
        runOnceGiac.setMinimumSize(new java.awt.Dimension(79, 23));
        runOnceGiac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runOnceGiacActionPerformed(evt);
            }
        });

        runOnceArt.setBackground(java.awt.Color.white);
        runOnceArt.setText("Articoli");
        runOnceArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runOnceArtActionPerformed(evt);
            }
        });

        stop.setBackground(java.awt.Color.white);
        stop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stop.png"))); // NOI18N
        stop.setToolTipText("Stop");
        stop.setFocusable(false);
        stop.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        stop.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopActionPerformed(evt);
            }
        });

        runOnceImm.setBackground(java.awt.Color.white);
        runOnceImm.setText("Immagini");
        runOnceImm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runOnceImmActionPerformed(evt);
            }
        });

        runOnceFor.setBackground(java.awt.Color.white);
        runOnceFor.setText("Fornitori");
        runOnceFor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runOnceForActionPerformed(evt);
            }
        });

        start.setBackground(java.awt.Color.white);
        start.setIcon(new javax.swing.ImageIcon(getClass().getResource("/start.png"))); // NOI18N
        start.setToolTipText("Start");
        start.setFocusable(false);
        start.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        start.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });

        stato.setToolTipText("");

        runOnceCli.setBackground(java.awt.Color.white);
        runOnceCli.setText("Clienti");
        runOnceCli.setMaximumSize(new java.awt.Dimension(79, 23));
        runOnceCli.setMinimumSize(new java.awt.Dimension(79, 23));
        runOnceCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runOnceCliActionPerformed(evt);
            }
        });

        runOnceMar.setBackground(java.awt.Color.white);
        runOnceMar.setText("Marche");
        runOnceMar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runOnceMarActionPerformed(evt);
            }
        });

        config.setBackground(java.awt.Color.white);
        config.setIcon(new javax.swing.ImageIcon(getClass().getResource("/config.png"))); // NOI18N
        config.setToolTipText("Configura");
        config.setFocusable(false);
        config.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        config.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        config.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configActionPerformed(evt);
            }
        });

        runOnceLin.setBackground(java.awt.Color.white);
        runOnceLin.setText("Lingue");
        runOnceLin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runOnceLinActionPerformed(evt);
            }
        });

        runOnceAll.setBackground(java.awt.Color.white);
        runOnceAll.setText("Allegati");
        runOnceAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runOnceAllActionPerformed(evt);
            }
        });

        esci.setBackground(java.awt.Color.white);
        esci.setIcon(new javax.swing.ImageIcon(getClass().getResource("/exit.png"))); // NOI18N
        esci.setToolTipText("Esci");
        esci.setFocusable(false);
        esci.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        esci.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        esci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                esciActionPerformed(evt);
            }
        });

        runOnceMagEst.setBackground(java.awt.Color.white);
        runOnceMagEst.setText("Mag. Est.");
        runOnceMagEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runOnceMagEstActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(runOnceArt, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(runOnceMar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(runOnceSta, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(runOnceImm, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(runOnceOrd, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(runOnceLin, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(start)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stop)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sysTray)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(esci)))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(mostraStream, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                            .addComponent(runOnceFor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(stato, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(config, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(runOnceCli, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(runOnceAll, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(runOnceSca, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(runOnceGiac, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(runOnceMagEst, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(config, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(start, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(stop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sysTray, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(esci, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(stato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(mostraStream)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(runOnceMar)
                    .addComponent(runOnceSta)
                    .addComponent(runOnceFor)
                    .addComponent(runOnceAll)
                    .addComponent(runOnceCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(runOnceArt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(runOnceLin)
                    .addComponent(runOnceGiac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(runOnceImm)
                    .addComponent(runOnceOrd)
                    .addComponent(runOnceSca)
                    .addComponent(runOnceMagEst))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clearArea)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clearArea)
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


// Gestione della riduzione a System tray
    private void sysTrayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sysTrayActionPerformed
        if (!SystemTray.isSupported()) {
            System.out.println("System tray non supportato ");
            return;
        }
        //get the systemTray of the system
        ClassLoader.getSystemResource("pssynchro.png");
        ClassLoader.getSystemResourceAsStream("pssynchro.png");
        SystemTray systemTray = SystemTray.getSystemTray();
        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/pssynchro.png"));

        //popupmenu
        PopupMenu trayPopupMenu = new PopupMenu();
        //1o menuitem del popupmenu
        MenuItem action = new MenuItem("Apri");
        action.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(true);
            }
        });
        trayPopupMenu.add(action);

        //2o menuitem del popupmenu
        MenuItem close = new MenuItem("Esci");
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        trayPopupMenu.add(close);

        //setting tray icon
        TrayIcon trayIcon = new TrayIcon(image, "PSSynchro", trayPopupMenu);
        //adjust to default size as per system recommendation 
        trayIcon.setImageAutoSize(true);

        try {
            systemTray.add(trayIcon);
        } catch (AWTException awtException) {
        }
        this.setVisible(false);
    }//GEN-LAST:event_sysTrayActionPerformed
    //____________fine Gestione SystemTray

    // Redirect dei messaggi di sistema su jtextarea
    private void updateTextArea(final String text) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                esito.append(text);
            }
        });
    }

    private void redirectSystemStreams() {
        OutputStream out = new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                updateTextArea(String.valueOf((char) b));
            }

            @Override
            public void write(byte[] b, int off, int len) throws IOException {
                updateTextArea(new String(b, off, len));
            }

            @Override
            public void write(byte[] b) throws IOException {
                write(b, 0, b.length);
            }
        };
        System.setOut(new PrintStream(out, true));
        System.setErr(new PrintStream(out, true));
    }
    //Fine Gestione redirect messaggi di sistema (viene eseguito richiamando redirectSystemStreams(); )


    private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed
        this.start.setBackground(Color.green);
        this.stop.setBackground(Color.lightGray);
        if (stopped) {
            timer.cancel();
        }
        stopped = false;
        stato.setText("Avviato");
        timer = new Timer();
        if(giacRitardo>0)
            timer.schedule(new TaskSchedulato("argiacenze"), giacRitardo, giacRitardo);//parti dopo x secondi e itera ogni x secondi
        if(cliRitardo>0)
            timer.schedule(new TaskSchedulato("arclienti"), cliRitardo, cliRitardo);//parti dopo x secondi e itera ogni x secondi
        if(artRitardo>0)
            timer.schedule(new TaskSchedulato("ararticoli"), artRitardo, artRitardo);//parti dopo x secondi e itera ogni x secondi
        if(forRitardo>0)
            timer.schedule(new TaskSchedulato("arfornitori"), forRitardo, forRitardo);//parti dopo x secondi e itera ogni x secondi
        if(scaRitardo>0)
            timer.schedule(new TaskSchedulato("arscadenze"), scaRitardo, scaRitardo);//parti dopo x secondi e itera ogni x secondi
        if(staRitardo>0)
            timer.schedule(new TaskSchedulato("arstatistiche"), staRitardo, staRitardo);//parti dopo x secondi e itera ogni x secondi
        if(ordRitardo>0)
            timer.schedule(new TaskSchedulato("arordini"), ordRitardo, ordRitardo);//parti dopo x secondi e itera ogni x secondi
        //timer.schedule(new TaskSchedulato("argiacenze"), allRitardo, allRitardo);//parti dopo x secondi e itera ogni x secondi
        if(marRitardo>0)
            timer.schedule(new TaskSchedulato("armarche"), marRitardo, marRitardo);//parti dopo x secondi e itera ogni x secondi
        //timer.schedule(new TaskSchedulato("argiacenze"), immRitardo, immRitardo);//parti dopo x secondi e itera ogni x secondi
        if(linRitardo>0)
            timer.schedule(new TaskSchedulato("arlingue"), linRitardo, linRitardo);//parti dopo x secondi e itera ogni x secondi
        if(magRitardo>0)
            timer.schedule(new TaskSchedulato("magazzinoesterno"), magRitardo, magRitardo);//parti dopo x secondi e itera ogni x secondi        
        if(clearEvery>0)
            timer.schedule(new TaskClear(), clearEvery, clearEvery);//parti dopo x secondi e itera ogni x secondi        
    }//GEN-LAST:event_startActionPerformed

    private void esciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_esciActionPerformed
        System.exit(0);
    }//GEN-LAST:event_esciActionPerformed

    private void stopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopActionPerformed
        this.stop.setBackground(Color.green);
        this.start.setBackground(Color.lightGray);
        stopped = true;
        stato.setText("Stoppato");
        timer.cancel();
    }//GEN-LAST:event_stopActionPerformed

    private void configActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configActionPerformed
        Configurazione form = new Configurazione();
        form.setVisible(true);
    }//GEN-LAST:event_configActionPerformed

    private void runOnceGiacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runOnceGiacActionPerformed
        timer = new Timer();
        timer.schedule(new TaskSchedulato("argiacenze"), 10);
    }//GEN-LAST:event_runOnceGiacActionPerformed

    private void runOnceCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runOnceCliActionPerformed
        timer = new Timer();
        timer.schedule(new TaskSchedulato("arclienti"), 10);
    }//GEN-LAST:event_runOnceCliActionPerformed

    private void runOnceForActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runOnceForActionPerformed
        timer = new Timer();
        timer.schedule(new TaskSchedulato("arfornitori"), 10);
    }//GEN-LAST:event_runOnceForActionPerformed

    private void runOnceArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runOnceArtActionPerformed
        timer = new Timer();
        timer.schedule(new TaskSchedulato("ararticoli"), 10);
    }//GEN-LAST:event_runOnceArtActionPerformed

    private void runOnceMarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runOnceMarActionPerformed
        timer = new Timer();
        timer.schedule(new TaskSchedulato("armarche"), 10);
    }//GEN-LAST:event_runOnceMarActionPerformed

    private void runOnceImmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runOnceImmActionPerformed
        timer = new Timer();
        timer.schedule(new TaskSchedulato("arimmagini"), 10);
    }//GEN-LAST:event_runOnceImmActionPerformed

    private void runOnceAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runOnceAllActionPerformed
        timer = new Timer();
        timer.schedule(new TaskSchedulato("arallegati"), 10);
    }//GEN-LAST:event_runOnceAllActionPerformed

    private void runOnceScaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runOnceScaActionPerformed
        timer = new Timer();
        timer.schedule(new TaskSchedulato("arscadenzario"), 10);
    }//GEN-LAST:event_runOnceScaActionPerformed

    private void runOnceStaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runOnceStaActionPerformed
        timer = new Timer();
        timer.schedule(new TaskSchedulato("arstatistiche"), 10);
    }//GEN-LAST:event_runOnceStaActionPerformed

    private void runOnceOrdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runOnceOrdActionPerformed
        timer = new Timer();
        timer.schedule(new TaskSchedulato("arordini"), 10);
    }//GEN-LAST:event_runOnceOrdActionPerformed

    private void runOnceLinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runOnceLinActionPerformed
        timer = new Timer();
        timer.schedule(new TaskSchedulato("arlingue"), 10);
    }//GEN-LAST:event_runOnceLinActionPerformed

    private void clearAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearAreaActionPerformed
        esito.setText("");
    }//GEN-LAST:event_clearAreaActionPerformed

    private void runOnceMagEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runOnceMagEstActionPerformed
        timer = new Timer();
        timer.schedule(new TaskSchedulato("magazzinoesterno"), 10);
    }//GEN-LAST:event_runOnceMagEstActionPerformed

    /**
     * @param args the command line arguments
     */
    public void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearArea;
    private javax.swing.JButton config;
    private javax.swing.JButton esci;
    private javax.swing.JTextArea esito;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton mostraStream;
    private javax.swing.JButton runOnceAll;
    private javax.swing.JButton runOnceArt;
    private javax.swing.JButton runOnceCli;
    private javax.swing.JButton runOnceFor;
    private javax.swing.JButton runOnceGiac;
    private javax.swing.JButton runOnceImm;
    private javax.swing.JButton runOnceLin;
    private javax.swing.JButton runOnceMagEst;
    private javax.swing.JButton runOnceMar;
    private javax.swing.JButton runOnceOrd;
    private javax.swing.JButton runOnceSca;
    private javax.swing.JButton runOnceSta;
    public javax.swing.JButton start;
    private javax.swing.JLabel stato;
    private javax.swing.JButton stop;
    private javax.swing.JButton sysTray;
    // End of variables declaration//GEN-END:variables

    class TaskSchedulato extends TimerTask {
        String stringa;
        boolean inVoid=false;
        public TaskSchedulato(String stringa){
            this.stringa=stringa;
        }
        @Override
        public void run() {
            redirectSystemStreams();
            DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            URL sito = null;
            System.out.println("Procedura: " + stringa);            
            // Carico le informazioni di collegamento a SQL            
            String server=Config.getString("SERVER");
            server="jdbc:sqlserver://"+server;
            String database=Config.getString("DATABASE");
            server = server+";mydb="+database;
            String username=Config.getString("USERNAME");
            String password=Config.getString("PASSWORD");
            //Aggiorno le categorie web            
            if (stringa.equals("ararticoli")) {
                UpdateCategoriePs connServer = new UpdateCategoriePs();
                connServer.dbConnect(server, username, password, database);
            }
            //
            // Carico i dati del magazzino esterno 
            if (stringa.equals("magazzinoesterno")) {            
            UpdateMagazzinoEsternoPS connServerMag = new UpdateMagazzinoEsternoPS();
            connServerMag.dbConnect(server, username, password, database); 
            return;
            }
            //
            
            try {
                sito = new URL(sUrl + "?aggiornamento="+stringa);
            } catch (MalformedURLException ex) {
                System.out.println("Indirizzo del sito mal formato o inesistente");
            }
            URLConnection yc = null;
            try {
                yc = sito.openConnection();
            } catch (IOException ex) {
                System.out.println("Errore di connessione _ ");
            }
            BufferedReader in = null;
            try {
                in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            } catch (IOException ex) {
                dataErrore = new Date();
                //Logger.getLogger(TaskSchedulato.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(sdf.format(dataErrore)+": Errore in ricezione dati: verificare che il "+
                        "server sia avviato o che l'indirizzo sia corretto");
                inVoid=true;
            }
            //potrebbe bloccare la form
            if (mostraStream.isSelected()) {
                String inputLine;
                try {
                    if (!inVoid) {
                    while ((inputLine = in.readLine()) != null) {
                        System.out.println(inputLine);
                    }
                    }
                } catch (IOException ex) {
                    //Logger.getLogger(TaskSchedulato.class.getName()).log(Level.SEVERE, null, ex);
                dataErrore = new Date();
                System.out.println(sdf.format(dataErrore));
                System.out.println("Errore di connessione: " + dataErrore);                    
                }
            }
            //potrebbe bloccare la form - Fine
            try {
                if (!inVoid)
                in.close();
            } catch (IOException ex) {
                //Logger.getLogger(TaskSchedulato.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("errore in chiusura");
            }
        }
    }

    
   
    class TaskClear extends TimerTask {
        @Override
        public void run() {
        esito.setText("");
        }
    }    
        
}
