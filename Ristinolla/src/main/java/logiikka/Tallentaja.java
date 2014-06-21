/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *Tallentaja vastaa pelin ruudukon ja vuoron tallentamisesta tekstitiedostoon ja sieltä lataamisesta.
 * 
 * @author Henri
 */
public class Tallentaja {
    
    public Tallentaja() {
        
    }
    
    /**
     * Tallentaa saadun ruudukon tekstitiedostoon.
     * 
     * @param ruudukko
     * @throws IOException 
     */
    
    public void tallennaPeli(Ruudukko ruudukko) throws  IOException {      
        FileWriter kirjoittaja = new FileWriter("tallennus.txt");
        kirjoittaja.write(ruudukko.toString());
        kirjoittaja.close();
    }
    
    /**
     * Tallentaa saadun vuoron tekstitiedostoon.
     * 
     * @param peli
     * @throws IOException 
     */
    
    public void tallennaVuoro(Peli peli) throws IOException {
        FileWriter vuoroKirjo = new FileWriter("vuoro.txt");
        if(peli.getVuoro() == Ruutu.RISTI) {
            vuoroKirjo.write("0");
        } else if(peli.getVuoro() == Ruutu.NOLLA) {
            vuoroKirjo.write("1");
        }
        vuoroKirjo.close();
    }
    
    /**
     * Lataa tekstitiedostosta sinne tallennetun ruudukon ja palauttaa sen ruudukko oliona.
     * 
     * @return 
     * @throws FileNotFoundException 
     */
    
    public Ruudukko lataaPeli() throws FileNotFoundException {
        String teksti = "";
        
        
        Scanner lukija;
        File tiedosto = new File("tallennus.txt");
        
        lukija = new Scanner(tiedosto);
        
        while(lukija.hasNextLine()) {
            teksti = teksti + lukija.nextLine();
        }
        lukija.close();    
        
        char[] merkit = teksti.toCharArray();
        
        Ruudukko ruudukko = new Ruudukko();
        ruudukko.asetaRuudukko();
        
          int i = 0;
          for(int j = 0; j<3;j++) {
            for(int k = 0; k<3;k++) {
                if(merkit[i] == 'X') {
                    ruudukko.asetaX(j, k);
                } else if(merkit[i]=='0') {
                    ruudukko.aseta0(j, k);
                }
                i ++;
            }
          }
          
            
        
        return ruudukko;
    }
    
    /**
     * Lataa tekstitiedostoon tallennetun vuoron.
     * 
     * @return
     * @throws FileNotFoundException 
     */
    
    public Ruutu lataaVuoro() throws FileNotFoundException {
        int i = 0;
        Ruutu ruutu;
        File tiedosto = new File("vuoro.txt");
        Scanner lukija = new Scanner(tiedosto);
        
        while(lukija.hasNext()) {
            i = i + Integer.parseInt(lukija.next());
        }
        
        if(i == 0) {
            ruutu = Ruutu.RISTI;
        } else if (i == 1) {
            ruutu = Ruutu.NOLLA;
        } else {
            ruutu = Ruutu.RISTI;
        }
        return ruutu;
    }
    
}
