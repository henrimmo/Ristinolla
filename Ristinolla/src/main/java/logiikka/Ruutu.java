/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

/**
 *
 * @author Henri
 */
public enum Ruutu {
    
    TYHJA {
        @Override
      public String toString() {
            return "_";
        }
    }
        ,
    RISTI {
        @Override
      public String toString() {
            return "X";
        }    
    } 
        ,
    NOLLA {
        @Override
      public String toString() {
            return "0";
        }
    }
}
