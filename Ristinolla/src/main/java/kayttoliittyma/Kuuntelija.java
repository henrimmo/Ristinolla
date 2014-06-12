/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import logiikka.Peli;


/**
 * Kuuntelija luokka, vastaa pelaajan toimintojen kuuntelemisesta
 * 
 *
 * @author Henri
 */
public class Kuuntelija implements ActionListener{

    private GUI gui;
    private Peli peli;
    private int x;
    private int y;

    public Kuuntelija(GUI gui, Peli peli){
        this.gui = gui;
        this.peli = peli;   
    }
    
    public Kuuntelija(GUI gui, Peli peli, int x, int y){
        this.gui = gui;
        this.peli = peli;  
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
