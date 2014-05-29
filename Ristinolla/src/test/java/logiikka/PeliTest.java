/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Henri
 */
public class PeliTest {
    private Peli peli;
    private Ruudukko ruudukko;
    
    public PeliTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ruudukko = new Ruudukko();
        peli = new Peli(ruudukko);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void vuoronVoiPelataJaSeVaihtuuOikein() {
        peli.aloitaPeli();
        peli.pelaaVuoro(0, 0);
        peli.pelaaVuoro(1, 1);
        peli.pelaaVuoro(2, 1);
        
        assertEquals(Ruutu.RISTI,ruudukko.getRuutu(0, 0));
        assertEquals(Ruutu.NOLLA,ruudukko.getRuutu(1, 1));
        assertEquals(Ruutu.RISTI,ruudukko.getRuutu(2, 1));
    }
    @Test
    public void vuoroEiVaihduJosMerkkiLaitetaanVarattuunRuutuun() {
        peli.aloitaPeli();
        peli.pelaaVuoro(0, 0);
        peli.pelaaVuoro(0, 0);
        peli.pelaaVuoro(1, 1);
        
        assertEquals(Ruutu.RISTI,ruudukko.getRuutu(0, 0));
        assertEquals(Ruutu.NOLLA,ruudukko.getRuutu(1, 1));
    }
    
    @Test
    public void vaakaTarkistusToimii() {
        peli.aloitaPeli();
        peli.pelaaVuoro(0, 0);
        peli.pelaaVuoro(1, 1);
        peli.pelaaVuoro(1, 0);
        peli.pelaaVuoro(1, 2);
        peli.pelaaVuoro(2, 0);
        
        assertEquals(Ruutu.RISTI,ruudukko.getRuutu(0, 0));
        assertEquals(Ruutu.RISTI,ruudukko.getRuutu(1, 0));
        assertEquals(Ruutu.RISTI,ruudukko.getRuutu(2, 0));
        
        assertEquals(true, peli.voittajaTarkistus());
    }
    
    @Test
    public void pystyTarkistusToimii() {
        peli.aloitaPeli();
        peli.pelaaVuoro(0, 0);
        peli.pelaaVuoro(1, 1);
        peli.pelaaVuoro(0, 1);
        peli.pelaaVuoro(1, 2);
        peli.pelaaVuoro(0, 2);
        
        assertEquals(Ruutu.RISTI,ruudukko.getRuutu(0, 0));
        assertEquals(Ruutu.RISTI,ruudukko.getRuutu(0, 1));
        assertEquals(Ruutu.RISTI,ruudukko.getRuutu(0, 2));
        
        assertEquals(true, peli.voittajaTarkistus());
    }
    
    @Test
    public void vinoTarkistusToimii1() {
        peli.aloitaPeli();
        peli.pelaaVuoro(0, 0);
        peli.pelaaVuoro(1, 0);
        peli.pelaaVuoro(1, 1);
        peli.pelaaVuoro(1, 2);
        peli.pelaaVuoro(2, 2);
        
        assertEquals(Ruutu.RISTI,ruudukko.getRuutu(0, 0));
        assertEquals(Ruutu.RISTI,ruudukko.getRuutu(1, 1));
        assertEquals(Ruutu.RISTI,ruudukko.getRuutu(2, 2));
        
        assertEquals(true, peli.voittajaTarkistus());
    }
    
    @Test
    public void vinoTarkistusToimii2() {
        peli.aloitaPeli();
        peli.pelaaVuoro(0, 2);
        peli.pelaaVuoro(1, 0);
        peli.pelaaVuoro(1, 1);
        peli.pelaaVuoro(1, 2);
        peli.pelaaVuoro(2, 0);
        
        assertEquals(Ruutu.RISTI,ruudukko.getRuutu(2, 0));
        assertEquals(Ruutu.RISTI,ruudukko.getRuutu(1, 1));
        assertEquals(Ruutu.RISTI,ruudukko.getRuutu(0, 2));
        
        assertEquals(true, peli.voittajaTarkistus());
    }
    
    
}
