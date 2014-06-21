/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

import java.io.FileNotFoundException;

/**
 *Sisältää ristinollan pelaamiseen tarvittavia metodeja.
 * 
 * @author Henri
 */
public final class Peli {
    
    
    private Ruudukko ruudukko;
    private Ruutu vuoro;
    private int xVoitot;
    private int oVoitot;
    private int tasaPelit;
    private Tallentaja tallentaja;
    
    public Peli(Ruudukko ruudukko) {
        this.ruudukko = ruudukko;
        xVoitot = 0;
        oVoitot = 0;
        tasaPelit = 0;
        vuoro = Ruutu.RISTI;
        this.tallentaja = new Tallentaja();
        
    }
    
    
    
    /**
     * Asettaa tyhjän ruudukon ja vuoron ristille.
     * 
     */
    
    public void aloitaUusiPeli() {
        ruudukko.asetaRuudukko();
        
        vuoro = Ruutu.RISTI;
    }
    
    
    /**
     * Palauttaa halutun pelaajan voittojen lukumäärän.
     * 
     * @param pelaaja
     * @return voittojen lukumäärä
     */
    
    public int getVoitot(Ruutu pelaaja) {
        int voitot = 0;
        if(pelaaja == Ruutu.RISTI) {
            voitot = xVoitot;
        } else if(pelaaja == Ruutu.NOLLA) {
            voitot = oVoitot;
        } else if(pelaaja == Ruutu.TYHJA) {
            System.out.println("Senkin hölmö, tyhjä ei voi voittaa");
        }
        return voitot;
    }
    
    public int getTasapelit() {
        return tasaPelit;
    }
    
    /**
     * Tarkistaa kumpi pelaajista voitti pelin ja lisää tälle yhden voiton voittotilastoon
     * 
     */
    
    public void lisaaVoitto() {
        if(ruudukko.getVoittaja() == Ruutu.RISTI) {
            xVoitot++;
        } else if(ruudukko.getVoittaja() == Ruutu.NOLLA) {
            oVoitot++;
        }
    }
    
    /**
     * Lisää tasapelin voittotilastoon.
     * 
     */
    
    public void lisaaTasaPeli() {
        tasaPelit++;
    }
    
    /**
     * Pelaa yhden vuoron eli asettaa vuorosta riippuen joko ristin tai nollan ruudukkoon ja vaihtaa vuoron
     * 
     * @param x halutun ruudun x-koordinaatti
     * @param y halutun ruudun y-koordinaatti
     */
    
    public void pelaaVuoro(int x, int y) {
        if(ruudukko.onkoTyhja(x, y)) {
            if (vuoro == Ruutu.RISTI) {
            ruudukko.asetaX(x,y);
            
            }
            if(vuoro == Ruutu.NOLLA) {
                ruudukko.aseta0(x,y);

            }
            vaihdaVuoro();
        }
        
    }
    
    /**
     * Vaihtaa vuoron
     * 
     */
    
    public void vaihdaVuoro() {
        if(vuoro == Ruutu.NOLLA) {
            vuoro= Ruutu.RISTI;
        } else if(vuoro == Ruutu.RISTI) {
            vuoro= Ruutu.NOLLA;
        }
    }
    
    /**
     * Tarkistaa onko tilanne tasapeli eli ruudukko on täynnä mutta voittoehto ei toteudu
     * 
     * @return true jos on, false jos ei
     */
    
    public boolean tasaPeliTarkistus() {
        if(ruudukko.onkoRuudukkoTaysi()) {
            if(!voittajaTarkistus()) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Tulostaa halutuissa koordinaateissa olevan ruudun merkin.
     * 
     * @param x
     * @param y
     * @return X jos ruutu on risti, 0 jos ruutu on nolla, _ jos ruutu on tyhjä
     */
    
    public String tulostaRuutu(int x, int y) {
        return ruudukko.getRuutu(x, y).toString();
    }
    
    
    /**
     * Tarkistaa toteutuuko voittoehto missään suunnassa
     * 
     * @return true jos toteutuu, false jos ei
     */
    
    public boolean voittajaTarkistus() {
        if(ruudukko.tarkistaVaaka()) {
            return true;
        } 
        else
        if(ruudukko.tarkistaPysty()) {
            return true;
        } 
        else
        if(ruudukko.tarkistaVino()) {
            return true;
        } 
        else {
            return false;
        }
        
    }
    
    /**
     * Tarkistaa loppuuko peli ja lisää yhden pisteen voittoihin tai tasapeleihin
     * 
     * @return true jos peli loppuu, false jos ei
     */
    
    
    public boolean loppuukoPeli() {
        if(voittajaTarkistus() == true) {
            lisaaVoitto();
            return true;
        
        } else if(tasaPeliTarkistus()) {
            lisaaTasaPeli();
            return true;
        }
        return false;
    }
    
    /**
     * Tarkistaa onko annettu syöte ruudukon rajojen sisällä
     * 
     * @param i
     * @return  true jos on, false jos ei
     */
    
    public boolean syoteOikein(int i) {
        return (i < 3 && i >= 0);
        
    }
    
    public Ruutu getVuoro() {
        return vuoro;
    }
    
    public Ruutu getRuutu(int x,int y) {
        return ruudukko.getRuutu(x, y);
    }
    
    /**
     * Palauttaa merkkijonona voittajan tai tasapelin
     * 
     * @return Tasapeli! jos tasapeli, X voitti! tai 0 voitti!
     */
    
    public String getVoittaja() {
        if(tasaPeliTarkistus()) {
            return "Tasapeli!";
        } else {
            return ruudukko.getVoittaja().toString() + " voitti!";
        }
    }
    
    /**
     * Tallentaa ruudukon ja vuoron.
     * 
     * @throws Exception 
     */
    
    public void tallenna() throws Exception {
        tallentaja.tallennaPeli(ruudukko);
        tallentaja.tallennaVuoro(this);

    }
    
    
    /**
     * Lataa ruudukon ja vuoron.
     * 
     * @throws FileNotFoundException 
     */
    
    public void lataa() throws FileNotFoundException {
        this.ruudukko = tallentaja.lataaPeli();
        this.vuoro = tallentaja.lataaVuoro();
        
        
        
    } 
    
}
