/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import logiikka.Peli;
import logiikka.Ruudukko;

/**
 *
 * @author Henri
 */
public class Kuuntelija implements ActionListener{

    JButton uusiPeli;

    public Kuuntelija(JButton uusiPeli){

        this.uusiPeli = uusiPeli;
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        

    }
    
}
