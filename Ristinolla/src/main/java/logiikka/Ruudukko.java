/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

/**
 * Koostuu ruuduista ja pitää kirjaa niiden tilasta. Tarjoaa metodeja ruutujen tilan vaihtamiseen ja voittoehtojen tarksistamiseksi
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
        
        
    }
    
    /**
     * Asetta ruudukon täyteen tyhjiä ruutuja.
     */    
    
    public void asetaRuudukko() {
        for ( int i = 0; i < laudanKoko; i++) {
            for (int j = 0; j < laudanKoko; j++) {
                ruudut[i][j] = Ruutu.TYHJA;
            }
        }
    }
      
    /**
     * Tarkistaa onko annettu syöte ruudukon sisällä.
     * 
     * @return true mikäli on, false jos ei ole.
     */
    public boolean kelvollinenSyote(int x, int y) {
       return(x >= 0 && x < laudanKoko && y >= 0 && y < laudanKoko);
    }
    
    /**
     * Asettaa x- ja y-koordinaateissa sijaitsevan ruudun tilaksi ristin.
     * 
     * @param x haluttu x-koordinaatti
     * @param y haluttu y-koordinaatti
     */
    public void asetaX(int x, int y) {
        ruudut[x][y]=Ruutu.RISTI;
    }
 
    /**
     * Asettaa x- ja y-koordinaateissa sijaitsevan ruudun tilaksi nolla.
     * 
     * @param x haluttu x-koordinaatti
     * @param y haluttu y-koordinaatti
     */    
    
    public void aseta0(int x, int y) {
        ruudut[x][y]=Ruutu.NOLLA;
    }
    
    /**
     * Asettaa x- ja y-koordinaateissa sijaitsevan ruudun tilaksi tyhjä.
     * 
     * @param x
     * @param y 
     */
    
    public void asetaTyhja(int x, int y) {
        ruudut[x][y]=Ruutu.TYHJA;
    }
    
    
    
    public Ruutu getRuutu(int x, int y) {
        return ruudut[x][y];
    }
    
    /**
     * Tarkistaa onko annetuissa koordinaateissa sijaitseva ruutu tyhjä.
     * 
     * @param x haluttu x-koordinaatti
     * @param y haluttu y-koordinaatti
     * 
     * @return true jos tyhjä, false jos ei.
     */
    
    public boolean onkoTyhja(int x, int y) {
        if(kelvollinenSyote(x,y)) {
            return ruudut[x][y] == Ruutu.TYHJA;
        }
        return false;
    }
    
    /**
     * Tarkistaa onko ruudukko täynnä
     * 
     * @return true jos ei sisällä yhtäkään tyhää ruutua, false jos sisältää
     */
    
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
    
    /**
     * Tarkistaa vaakasuunassa täyttyykö voittoehto eli 3 samaa merkkiä vierekkäin
     * 
     * @return true jos ehto toteutuu, false jos ei
     */
    
    public boolean tarkistaVaaka() {
        for (int korkeus = 0; korkeus < 3; korkeus++) {
            if(ruudut[1][korkeus]!=Ruutu.TYHJA)  {
                if(ruudut[0][korkeus] == ruudut[1][korkeus] && ruudut[1][korkeus] == ruudut[2][korkeus]) {
                    voittaja = ruudut[1][korkeus];
                    return true;
            }
            }
        }
        return false;
    }
    
    /**
     * Tarkistaa toteutuuko voittoehto pystysuunnassa
     * 
     * @return true jos toteutuu, false jos ei
     */
    
    public boolean tarkistaPysty() {
        for (int leveys = 0; leveys < 3; leveys++) {
            if(ruudut[leveys][1]!=Ruutu.TYHJA)  {
                if(ruudut[leveys][0] == ruudut[leveys][1] && ruudut[leveys][1] == ruudut[leveys][2]) {
                    voittaja = ruudut[leveys][1];
                    return true;
            }
            }
        }
        return false;
            
    }
    
    /**
     * Tarkistaa toteutuuko voittoehto vinottain
     * 
     * @return true jos toteutuu, false jos ei
     */
    
    public boolean tarkistaVino() {
        if(getRuutu(1,1) != Ruutu.TYHJA) {
            if(getRuutu(0,0) == getRuutu(1,1) && getRuutu(1,1) == getRuutu(2,2)) {
                voittaja = ruudut[1][1];
                return true;
            } else 
                if(getRuutu(2,0) == getRuutu(1,1) && getRuutu(1,1) == getRuutu(0,2)) {
                    voittaja = ruudut[1][1];
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
    
    /**
     * Tallentaja luokka käyttää kyseistä metodia ruudukon tallentamiseen tekstitiedostoon.
     * 
     * @return 
     */
    
    @Override
    public String toString() {
        String merkit = "";
        for (int x=0; x < 3; ++x) {
            for (int y=0; y < 3; ++y) {
                merkit += this.ruudut[x][y];
            }
        }
        return merkit;
    }   
}
