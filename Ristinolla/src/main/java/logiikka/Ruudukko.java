/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

/**
 *
 * @author Henri
 */
public final class Ruudukko {
    
    private final Ruutu[][] ruudut;
    private final int laudanKoko;
    private Ruutu voittaja = Ruutu.TYHJA;
    
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
        ruudut[x][y]=Ruutu.RISTI;
    }
    
    public void aseta0(int x, int y) {
        ruudut[x][y]=Ruutu.NOLLA;
    }
    
    public Ruutu getRuutu(int x, int y) {
        return ruudut[x][y];
    }
    
    public int getPituus() {
        return laudanKoko;
    }
    
    public boolean onkoTyhja(int x, int y) {
        if(kelvollinenSyote(x,y)) {
            return ruudut[x][y] == Ruutu.TYHJA;
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
    
    public boolean tarkistaVaaka() {
        int merkit = 0;
        Ruutu ruutu;
        for(int i = 0; i < getPituus(); i++) {
            for(int j = 0; j < getPituus(); j ++) {
                ruutu = ruudut[i][j];
                if(getRuutu(i, j)==ruutu && getRuutu(i,j) != Ruutu.TYHJA) {
                    merkit ++;
                    if(merkit == 3) {
                        voittaja = ruudut[i][j];
                    }
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
    
        public boolean tarkistaPysty() {
        int merkit = 0;
        Ruutu ruutu = Ruutu.TYHJA;
        for(int i = 0; i < getPituus(); i++) {
            for(int j = 0; j < getPituus(); j ++) {
                ruutu = ruudut[i][j];
                if(getRuutu(j, i)==ruutu && getRuutu(i,j) != Ruutu.TYHJA)  {
                    merkit ++;
                    if(merkit == 3) {
                        voittaja = ruudut[i][j];
                    }
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
    
    public boolean tarkistaVino() {
        if(getRuutu(1,1) != Ruutu.TYHJA) {
            if(getRuutu(0,0) == getRuutu(1,1) && getRuutu(1,1) == getRuutu(2,2)) {
                return true;
            } else 
                if(getRuutu(2,0) == getRuutu(1,1) && getRuutu(1,1) == getRuutu(0,2)) {
                    return true;
                } else {
                    return false;
                }
        }
        return false;
    } 
    public Ruutu getVoittaja() {
        return voittaja;
    }

  
}
