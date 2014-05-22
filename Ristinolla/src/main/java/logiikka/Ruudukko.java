/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

/**
 *
 * @author Henri
 */
public class Ruudukko {
    
    private Ruutu[][] ruudut;
    private int laudanKoko;
    
    public Ruudukko() {
        this.laudanKoko = 3;
        ruudut = new Ruutu[laudanKoko][laudanKoko];
        asetaRuudukko();
        
    }
    
    public void asetaRuudukko() {
        for ( int i = 0; i < laudanKoko; i++) {
            for (int j = 0; j < laudanKoko; j++) {
                ruudut[i][j] = Ruutu.TYHJA;
            }
        }
    }
    
    public boolean kelvollinenSyote(int x, int y) {
       return(x >= 0 && x < laudanKoko && y >= 0 && y < laudanKoko);
    }
    
    public void asetaX(int x, int y) {
        if(kelvollinenSyote(x,y) == true) {
            if(ruudut[x][y]==Ruutu.TYHJA) {
                ruudut[x][y]=Ruutu.RISTI;
            }
        }
    }
    
    public void aseta0(int x, int y) {
        if(kelvollinenSyote(x,y) == true) {
            if(ruudut[x][y]==Ruutu.TYHJA) {
                ruudut[x][y]=Ruutu.NOLLA;
            }
        }
    }
    
    public Ruutu getRuutu(int x, int y) {
        return ruudut[x][y];
    }
    
    public int getPituus() {
        return laudanKoko;
    }
    
    public boolean onkoTyhja(int x, int y) {
        if(kelvollinenSyote(x,y)) {
            if(ruudut[x][y] == Ruutu.TYHJA) {
                return true;
            }
            return false;
        }
        return false;
    }
    
    public boolean onkoRuudukkoTaysi() {
        for ( int i = 0; i < laudanKoko; i++) {
            for (int j = 0; j < laudanKoko; j++) {
                if(ruudut[i][j] == Ruutu.TYHJA) {
                    return false;
                }
            }
        }
        return true;
    }
    

    
}
