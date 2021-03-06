/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import logiikka.Peli;
import logiikka.Ruudukko;
import logiikka.Ruutu;


/**
 *Käyttöliittymä luokka. Vastaa pelilaudan piirtämisestä.
 * 
 * @author Henri
 */
public class GUI implements Runnable{
    private JFrame gui;
    private Peli peli;
    private Ruudukko ruudukko;
    private JButton[][] ruudut;
    private JPanel pelilauta;
    private JLabel vuoro;
    
    public GUI() {
        this.ruudukko = new Ruudukko();
        this.peli = new Peli(ruudukko);
    }

    /**
     * Luo ikkunan, kutuu luoKomponentit metodia ja asettaa ikkunan näkyväksi.
     * 
     */
    
    @Override
    public void run() {
        gui = new JFrame("Ristinolla");
        gui.setPreferredSize(new Dimension(700, 700));
        
        gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(gui.getContentPane());
        
        gui.pack();
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
    }
    
    /**
     * Luo painikkeet jotka edustavat ruudukkoa sekä menu palkin josta voidaan aloittaa uusi peli tai lopettaa pelaaminen, näyttää tilastot sekä ladata ja tallentaa pelin.
     * 
     * @param container 
     */    
    
    private void luoKomponentit(Container container){

        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("Menu");
        menu.getAccessibleContext().setAccessibleDescription("Menu");
        menuBar.add(menu);
        
        JMenuItem uusiPeli = new JMenuItem("Uusi peli");
        uusiPeli.setActionCommand("UUSI");
        uusiPeli.addActionListener(new Kuuntelija(this, this.peli, this.ruudukko));
        menu.add(uusiPeli);
        
        
        JMenuItem tallennaPeli = new JMenuItem("Tallenna peli");
        tallennaPeli.setActionCommand("TALLENNA");
        tallennaPeli.addActionListener(new Kuuntelija(this, this.peli,this.ruudukko) {
             @Override
                        public void actionPerformed(ActionEvent e) {
                try {
                    JOptionPane.showMessageDialog(null, "Peli tallennettu.");
                    peli.tallenna();
                    
                } catch (Exception ex) {
                    
                }
             }});
        
        menu.add(tallennaPeli);
        
        JMenuItem lataaPeli = new JMenuItem("Lataa peli");
        lataaPeli.setActionCommand("LATAA");
        lataaPeli.addActionListener(new Kuuntelija(this, this.peli,this.ruudukko));
        menu.add(lataaPeli);
        
        JMenuItem tilasto = new JMenuItem("Tilasto");
        tilasto.setActionCommand("TILASTO");
        tilasto.addActionListener(new Kuuntelija(this, this.peli,this.ruudukko));
        menu.add(tilasto);
        
        
        JMenuItem lopeta = new JMenuItem("Lopeta peli");
        lopeta.setActionCommand("LOPETA");
        lopeta.addActionListener(new Kuuntelija(this, this.peli,this.ruudukko));
        menu.add(lopeta);
        
        
        pelilauta = new JPanel();
        pelilauta.setLayout(new GridLayout(3, 3));
        gui.add(pelilauta);

        ruudut = new JButton[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ruudut[i][j] = new JButton();
                pelilauta.add(ruudut[i][j]);
                ruudut[i][j].addActionListener(new Kuuntelija(this, this.peli,this.ruudukko,i,j));
                ruudut[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
                ruudut[i][j].setFont(new Font("Font", Font.BOLD, 200));  
            }  
        }

        

        JPanel alareuna = new JPanel();
        GridLayout alareunaL = new GridLayout(1, 3);
        alareuna.setLayout(alareunaL);
        this.vuoro = new JLabel("");
        this.vuoro.setHorizontalAlignment(JLabel.CENTER);
        alareuna.add(this.vuoro);

        container.add(menuBar, BorderLayout.NORTH);
        container.add(pelilauta, BorderLayout.CENTER);
        container.add(alareuna, BorderLayout.SOUTH);
        alustaJaAloita();
        


    }
    
    /**
     * Alustaa ruudukon ja aloittaa uuden pelin
     * 
     */
        
    public void alustaJaAloita() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ruudut[i][j].setText("");
                ruudut[i][j].setBackground(Color.WHITE);
                ruudut[i][j].setEnabled(true);
            }
            vuoro.setText("X:n vuoro");
            peli.aloitaUusiPeli();
        }
    }
       
    /**
     * Lataa tallennetun pelin ja muuttaa ruudukon ja vuoron sen mukaisiksi.
     * 
     * @throws FileNotFoundException 
     */
    public void lataus() throws FileNotFoundException {
        peli.lataa();
        this.gui.repaint();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(peli.getRuutu(i, j).equals(Ruutu.RISTI)) {
                    ruudut[i][j].setText("X");
                    ruudut[i][j].setBackground(Color.WHITE);
                    ruudut[i][j].setEnabled(false);
                } else if(peli.getRuutu(i, j).equals(Ruutu.NOLLA)) {
                    ruudut[i][j].setText("0");
                    ruudut[i][j].setBackground(Color.WHITE);
                    ruudut[i][j].setEnabled(false);
                } else {
                    ruudut[i][j].setText("");
                    ruudut[i][j].setBackground(Color.WHITE);
                    ruudut[i][j].setEnabled(true); 
                }
                
                
                
            }
        }
        if (peli.getVuoro().equals(Ruutu.RISTI)) {
            this.vuoro.setText("X:n vuoro");
        } else {
            this.vuoro.setText("0:n vuoro");
        }
        
        
        
    }
    
    /**
     * Asettaa ruutuun vuorosta riippuen joko x tai 0
     * 
     * @param ruutu haluttu ruutu
     * @param merkki ruutuun asetettava merkki
     */
    
    public void muutaRuutu(JButton ruutu, String merkki) {
        ruutu.setEnabled(false);
        ruutu.setText(merkki);
    }
    
    /**
     * Päivittää ruudukon
     * 
     */
    
    public void paivita() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (peli.tulostaRuutu(i, j).equals("X") || peli.tulostaRuutu(i, j).equals("0")) {
                    muutaRuutu(ruudut[i][j], peli.tulostaRuutu(i, j));
                }
            }
        }
        
        if (peli.getVuoro().equals(Ruutu.RISTI)) {
            this.vuoro.setText("X:n vuoro");
        } else {
            this.vuoro.setText("0:n vuoro");
        }
    }
    
    /**
     * Tarkistaa haluaako pelaaja jatkaa pelaamista, sammuttaa ohjelman jos vastaus ei.
     * 
     * @return 
     */
    
    public boolean jatkuuko() {
        int valinta = JOptionPane.showConfirmDialog(null, "Uusi peli?", "" + peli.getVoittaja(),
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (valinta == JOptionPane.YES_OPTION) {
            return true;
        } else if (valinta == JOptionPane.CLOSED_OPTION) {
            return false;
        }
        
        return false;
    }
    
    /**
     * Näyttää tilastoikkunan.
     * 
     */
    public void tilasto() {
        JOptionPane.showMessageDialog(null, "Ristin voitot: " + peli.getVoitot(Ruutu.RISTI) + 
                "\n Nollan voitot: " + peli.getVoitot(Ruutu.NOLLA) + "\n Tasapelit: " + peli.getTasapelit());
    }
}    

