/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

/**
 *
 * @author Henri
 */
public class Peli {
    
    
    private Ruudukko ruudukko;
    private Ruutu vuoro;
    
    public Peli(Ruudukko ruudukko) {
        this.ruudukko = ruudukko;
        
    }
    
    public void aloitaPeli() {
        vuoro = Ruutu.RISTI;
    }
    
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
    
    public void vaihdaVuoro() {
        if(vuoro == Ruutu.NOLLA) {
            vuoro= Ruutu.RISTI;
        } else if(vuoro == Ruutu.RISTI) {
            vuoro= Ruutu.NOLLA;
        }
    }
    
    public boolean tasaPeliTarkistus() {
        if(ruudukko.onkoRuudukkoTaysi()) {
            if(!voittajaTarkistus()) {
                return true;
            }
        }
        return false;
    }
    
    
    
    public boolean voittajaTarkistus() {
        if(ruudukko.tarkistaVaaka()) {
            return true;
        }
        if(ruudukko.tarkistaPysty()) {
            return true;
        }
        if(ruudukko.tarkistaVino()) {
            return true;
        }
        return false;
    }
    
    public boolean loppuukoPeli() {
        if(voittajaTarkistus() == true) {
            return true;
        } else if(tasaPeliTarkistus() == true) {
            return true;
        } else {
            return false;
        }
    }
}
