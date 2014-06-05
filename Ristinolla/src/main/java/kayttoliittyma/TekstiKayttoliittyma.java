/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kayttoliittyma;

import java.util.Scanner;
import logiikka.Peli;
import logiikka.Ruudukko;

/**
 *
 * @author Henri
 */
public class TekstiKayttoliittyma {
    
    private final Peli peli;
    private Ruudukko ruudukko;
    private boolean jatkuu;
    Scanner lukija = new Scanner(System.in);
    
    public TekstiKayttoliittyma() {
        peli = new Peli(new Ruudukko());
    }
    
    public void aloita() {
        jatkuu = true;
        tulostaRuudukko();
        while(jatkuu) {
            
            kysyKomento();
            
            if(!jatkuu) {
                break;
            }
            
            if(peli.loppuukoPeli()) {
                break;
            }
        }
    }
    
    public void tulostaRuudukko() {
        for (int i=2; i>=0; i--) {
            for(int j=0; j<3; j++) {
               
                System.out.print("|" + peli.tulostaRuutu(j, i));    
            }
            System.out.println("|");
        }  
    }
    
    public void kysyKomento() {
        
//        do { 
//            System.out.println("Anna x-koordinaatti");
//            String xSyote = lukija.nextLine();
//            if(xSyote.isEmpty()) {
//                break;
//            }
//            int xKoord;
//            try {
//                xKoord = Integer.parseInt(xSyote);
//            } catch (NumberFormatException nfe) {
//                System.out.println("Anna kunnollinen luku!");
//                break;
//            }
//            
//            System.out.println("Anna y-koordinaatti");
//            String ySyote = lukija.nextLine();
//            if(ySyote.isEmpty()) {
//                break;
//            }
//            int yKoord;
//            try {
//                yKoord = Integer.parseInt(ySyote);
//            } catch (NumberFormatException nfe) {
//                System.out.println("Anna kunnollinen luku!");
//                break;
//            }
//            
//            peli.pelaaVuoro(xKoord, yKoord);
//        }   while (jatkuu);
        
        int xKoord;
        int yKoord;
        
        do {
            System.out.println("Anna x-koordinaatti");
            xKoord = lukija.nextInt();
        }while(!peli.syoteOikein(xKoord));
        
        
        do {
            System.out.println("Anna y-koordinaatti");
            yKoord = lukija.nextInt();
        }while(!peli.syoteOikein(yKoord));
        
        peli.pelaaVuoro(xKoord, yKoord);
        tulostaRuudukko();
    }
}

