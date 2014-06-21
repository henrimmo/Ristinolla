/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

import java.io.IOException;
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
public class TallentajaTest {
    
    private Peli peli;
    private Ruudukko ruudukko;
    private Tallentaja tallentaja;
    
    public TallentajaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        this.ruudukko = new Ruudukko();
        this.peli = new Peli(ruudukko);
        this.tallentaja = new Tallentaja();
        peli.aloitaUusiPeli();
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void pelinTallennusJaLatausToimii() throws IOException {
        
        ruudukko.aseta0(1, 1);
        ruudukko.asetaX(2, 2);
        
        tallentaja.tallennaPeli(ruudukko);
        
        tallentaja.lataaPeli();
        
        assertEquals("X",ruudukko.getRuutu(2, 2).toString());
        assertEquals("0",ruudukko.getRuutu(1, 1).toString());
        
    }
    
    @Test
    public void vuoronTallennusJaLatausToimii() throws IOException {
        peli.pelaaVuoro(1, 1);
        
        tallentaja.tallennaVuoro(peli);
        tallentaja.lataaVuoro();
        
        assertEquals(Ruutu.NOLLA,peli.getVuoro());
    }
}
