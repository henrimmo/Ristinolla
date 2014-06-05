/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

/**
 *Sisältää ristinollan pelaamiseen tarvittavia metodeja.
 * 
 * @author Henri
 */
public final class Peli {
    
    
    private final Ruudukko ruudukko;
    private Ruutu vuoro;
    private int xVoitot;
    private int oVoitot;
    private int tasaPelit;
    
    public Peli(Ruudukko ruudukko) {
        this.ruudukko = ruudukko;
        xVoitot = 0;
        oVoitot = 0;
        tasaPelit = 0;
        aloitaPeli();
        
    }
    
    /**
     * asettaa vuoron ristille
     * 
     */
    
    public void aloitaPeli() {
        vuoro = Ruutu.RISTI;
    }
    
    
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
        } else if(tasaPeliTarkistus()) {
            tasaPelit++;
        }
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
            System.out.println(ruudukko.getVoittaja().toString() + " voitti");
            System.out.println("Tilasto:");
            System.out.println("X:n voitot: " + getVoitot(Ruutu.RISTI));
            System.out.println("0:n voitot: " + getVoitot(Ruutu.NOLLA));
            System.out.println("Tasapelit: " + getTasapelit());
            return true;
        
        } else if(tasaPeliTarkistus()) {
            lisaaVoitto();
            System.out.println("Tasapeli");
            System.out.println("Tilasto:");
            System.out.println("X:n voitot: " + getVoitot(Ruutu.RISTI));
            System.out.println("0:n voitot: " + getVoitot(Ruutu.NOLLA));
            System.out.println("Tasapelit: " + getTasapelit());
            return true;
        }
        return false;
    }
    
    public boolean syoteOikein(int i) {
        return (i < 3 && i >= 0);
        
    }
}
