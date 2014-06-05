/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import logiikka.Peli;

/**
 *
 * @author Henri
 */
public class GUI implements Runnable{
    private JFrame gui;
    private Peli peli;
    
    public GUI() {
        
    }

    @Override
    public void run() {
        gui = new JFrame("Ristinolla");
        gui.setPreferredSize(new Dimension(300, 150));
        
        gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(gui.getContentPane());
        
        gui.pack();
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
    }
    
        private void luoKomponentit(Container container){

        JPanel paneeli  = new JPanel(new BorderLayout());
        paneeli.add(new JLabel("Tervetuloa pelaamaan! Klikkaa aloittaakesi."));
        
        JPanel alaPaneeli = new JPanel(new BorderLayout());
        
        JButton uusiPeli = new JButton("Aloita uusi peli");

        
        
        Kuuntelija kuuntelija = new Kuuntelija(uusiPeli);
        
        uusiPeli.addActionListener(kuuntelija);

        
        alaPaneeli.add(uusiPeli);
        
        container.add(paneeli, BorderLayout.NORTH);
        container.add(alaPaneeli, BorderLayout.CENTER);
    }
    
}
