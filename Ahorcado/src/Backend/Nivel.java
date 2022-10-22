package Backend;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author josue
 */
public class Nivel {
    
    public Nivel(){
    
    }
    
    public String obtenerPalabra(String [] palabra) {
        int randomNum = (int) (Math.random() * ((palabra.length) - 0)); //max_val - min-vale
        return palabra[randomNum];
    }
    
    public char[] caracterPalabra(String palabra){
        int tamanioPalabra = palabra.length();
        char [] caracter = new char[tamanioPalabra];
        
        for (int i = 0; i < tamanioPalabra; i++) {
            caracter[i] = palabra.charAt(i);
        }
        return caracter;
    }
    
    public void intentos(int intentos, JLabel lblPersonaje){
        
        switch (intentos) {
            case 3:
                lblPersonaje.setIcon(new ImageIcon("src/Imagen/personajeCabeza.png"));
                break;
            case 2:
                lblPersonaje.setIcon(new ImageIcon("src/Imagen/personajeCuerpo.png"));
                break;
            case 1:
                lblPersonaje.setIcon(new ImageIcon("src/Imagen/personajeManos.png"));
                break;
            case 0:
                lblPersonaje.setIcon(new ImageIcon("src/Imagen/personajeCompleto.png"));
                break;
            default:
                throw new AssertionError();
        }
        
    }
}
