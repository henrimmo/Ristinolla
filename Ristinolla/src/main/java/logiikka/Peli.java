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
    private boolean vuoro;
    
    public Peli(Ruudukko ruudukko) {
        this.ruudukko = ruudukko;
        
    }
    
    public void aloitaPeli() {
        vuoro = true;
    }
    
    public void pelaaVuoro(int x, int y) {
        if(ruudukko.onkoTyhja(x, y)) {
            if (vuoro == true) {
            ruudukko.asetaX(x,y);
            
            }
            if(vuoro == false) {
                ruudukko.aseta0(x,y);

            }
            vaihdaVuoro();
        }
        
    }
    
    public void vaihdaVuoro() {
        vuoro = !vuoro;
    }
    
    public boolean tasaPeli(int x, int y) {
        if(ruudukko.onkoRuudukkoTaysi()) {
            if(!voittajaTarkistus(x,y)) {
                return true;
            }
        }
        return false;
    }
    
    
    
    public boolean voittajaTarkistus(int x, int y) {
        if(tarkistaVaaka(x,y)) {
            return true;
        }
        if(tarkistaPysty(x,y)) {
            return true;
        }
        if(tarkistaVino(x,y)) {
            return true;
        }
        return false;
    }
    
    public boolean tarkistaVaaka(int x, int y) {
        int merkit = 0;
        for(int i = 0; i < ruudukko.getPituus(); i++) {
            for(int j = 0; j < ruudukko.getPituus(); j ++) {
                if(ruudukko.getRuutu(i, j)==ruudukko.getRuutu(x, y)) {
                    merkit ++;
                }
            }
            if(merkit == 3) {
                return true;
            } else {
                merkit = 0;
            }
        }
        return false;
    }
    
    public boolean tarkistaPysty(int x, int y) {
        int merkit = 0;
        for(int i = 0; i < ruudukko.getPituus(); i++) {
            for(int j = 0; j < ruudukko.getPituus(); j ++) {
                if(ruudukko.getRuutu(j, i)==ruudukko.getRuutu(x, y)) {
                    merkit ++;
                }
            }
            if(merkit == 3) {
                return true;
            } else {
                merkit = 0;
            }
        }
        return false;
    }
    
    public boolean tarkistaVino(int x, int y) {
        
        if(ruudukko.getRuutu(0, 0) ==ruudukko.getRuutu(x, y) && ruudukko.getRuutu(1, 1) ==ruudukko.getRuutu(x, y) && ruudukko.getRuutu(2, 2) ==ruudukko.getRuutu(x, y)) {
            return true;
        }
        
        if(ruudukko.getRuutu(2, 0) ==ruudukko.getRuutu(x, y) && ruudukko.getRuutu(1, 1) ==ruudukko.getRuutu(x, y) && ruudukko.getRuutu(2, 0) ==ruudukko.getRuutu(x, y)) {
            return true;
        }
        
        return false;
    }
}
