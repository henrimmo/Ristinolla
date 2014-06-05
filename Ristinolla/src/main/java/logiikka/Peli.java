/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

/**
 *
 * @author Henri
 */
public final class Peli {
    
    
    private final Ruudukko ruudukko;
    private Ruutu vuoro;
    
    public Peli(Ruudukko ruudukko) {
        this.ruudukko = ruudukko;
        aloitaPeli();
        
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
                System.out.println("Tasapeli");
                return true;
            }
        }
        return false;
    }
    
    public String tulostaRuutu(int x, int y) {
        return ruudukko.getRuutu(x, y).toString();
    }
    
    
    
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
    
    public boolean loppuukoPeli() {
        if(voittajaTarkistus() == true) {
            System.out.println(ruudukko.getVoittaja().toString() + " voitti");
            return true;
        
        } else if(tasaPeliTarkistus()) {
            System.out.println("Tasapeli");
            return true;
        }
        return false;
    }
    
    public boolean syoteOikein(int i) {
        return (i < 3 && i >= 0);
        
    }
}
