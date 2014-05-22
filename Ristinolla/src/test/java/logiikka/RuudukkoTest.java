/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;


import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Henri
 */
public class RuudukkoTest {
    
    private Ruudukko ruudukko;
    
    public RuudukkoTest() {
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
        
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void ruudukkoAsettuuOikein() {

        assertEquals(true,ruudukko.onkoTyhja(1, 1));
        assertEquals(true,ruudukko.onkoTyhja(2, 1));
    }
    
    @Test
    public void ruutuVaihtuuOikein() {
        ruudukko.aseta0(1, 1);
        ruudukko.asetaX(2, 1);
        assertEquals(Ruutu.NOLLA,ruudukko.getRuutu(1, 1));
        assertEquals(Ruutu.RISTI,ruudukko.getRuutu(2, 1));
    }
    
    @Test
    public void varattuaRuutuaEiVoiVaihtaa() {
        ruudukko.aseta0(1, 1);
        ruudukko.asetaX(1, 1);
        assertEquals(Ruutu.NOLLA,ruudukko.getRuutu(1, 1));
    }
    
    @Test
    public void syoteEiVoiOllaVaarin() {
        assertFalse(ruudukko.kelvollinenSyote(4, 8));
    
    }
}
