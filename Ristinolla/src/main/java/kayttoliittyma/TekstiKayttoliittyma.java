/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kayttoliittyma;

import logiikka.Peli;
import logiikka.Ruudukko;

/**
 *
 * @author Henri
 */
public class TekstiKayttoliittyma {
    
    private Peli peli;
    private Ruudukko ruudukko;
    private boolean jatkuu;
    
    public TekstiKayttoliittyma() {
        peli = new Peli(ruudukko);
    }
    
    public void aloita() {
        jatkuu = true;
        while(jatkuu) {
            tulostaRuudukko();
            
            
        }
    }
    
    public void tulostaRuudukko() {
        for (int i=3; i>=3; i--) {
            for(int j=0; j<3; j++) {
                if(!ruudukko.onkoTyhja(j, i)) {
                    System.out.print("|" + ruudukko.getRuutu(j, i).toString());
                } else {
                    System.out.print("|_");
                }
            }
            System.out.println("|");
        }
    }
    
    
    
    
    
}
