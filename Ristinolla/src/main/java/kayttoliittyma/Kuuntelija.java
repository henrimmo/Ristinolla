/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import logiikka.Peli;
import logiikka.Ruudukko;


/**
 * Kuuntelija luokka, vastaa pelaajan toimintojen kuuntelemisesta
 * 
 *
 * @author Henri
 */
public class Kuuntelija implements ActionListener{

    private GUI gui;
    private Peli peli;
    private Ruudukko ruudukko;
    private int x;
    private int y;

    public Kuuntelija(GUI gui, Peli peli, Ruudukko ruudukko){
        this.gui = gui;
        this.peli = peli; 
        this.ruudukko = ruudukko;
    }
    
    public Kuuntelija(GUI gui, Peli peli, Ruudukko ruudukko, int x, int y){
        this.gui = gui;
        this.peli = peli;
        this.ruudukko = ruudukko;
        this.x = x;
        this.y = y;
    }    
    
    @Override
    public void actionPerformed(ActionEvent e) {

        String komento = e.getActionCommand();
        switch (komento) {
            case "UUSI":
                gui.alustaJaAloita();
                peli.aloitaUusiPeli();
                break;
            case "TALLENNA":
                try {
                    peli.tallenna();
                } catch (Exception ex) {
                    Logger.getLogger(Kuuntelija.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "LATAA":
                try {
                    gui.lataus();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Kuuntelija.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "TILASTO":
                gui.tilasto();
                break;
            case "LOPETA":
                System.exit(0);
                break;
            default:
                peli.pelaaVuoro(x, y);
                gui.paivita();
                if(peli.loppuukoPeli()) {
                    if(!gui.jatkuuko()) {
                        System.exit(0);
                    } else {
                        gui.alustaJaAloita();
                        peli.aloitaUusiPeli();
                    }
                }
                break;
        }
        
        
        
        
        
        
        
        
        
        


    }
    
}
