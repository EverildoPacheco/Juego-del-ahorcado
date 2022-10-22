package Backend;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author josue
 */
public class NIntermedio extends Nivel {
    public String[] palabrasIntermedio = {"ESCUELA", "MENSAJE", "ENFERMO", "HORMIGA", "MAESTRO"};
    char[] palabras;
    String palabraElegida;
    int intentos = 4;
    
    public NIntermedio(){
    
    }
    
    public String getPalabraElegida() {
        return palabraElegida;
    }

    public void setPalabraElegida(String palabraElegida) {
        this.palabraElegida = palabraElegida;
    }

    public void compararLetra(char letra, JLabel lblChar0, JLabel lblChar1, JLabel lblChar2, 
            JLabel lblChar3, JLabel lblChar4, JLabel lblChar5, JLabel lblChar6, JLabel lblPersonaje, 
            JFrame niveles) {
        //this.setPalabraElegida(super.obtenerPalabra(palabrasFaciles));
        //JOptionPane.showMessageDialog(null, this.getPalabraElegida());
        boolean decision = false;
        palabras = super.caracterPalabra(this.getPalabraElegida());//this.getPalabraElegida()
        for (int i = 0; i < palabras.length; i++) {
            if (palabras[i] == letra) {
                decision = true;
                switch (i) {
                    case 0:
                        lblChar0.setText(String.valueOf(letra));
                        break;
                    case 1:
                        lblChar1.setText(String.valueOf(letra));
                        break;
                    case 2:
                        lblChar2.setText(String.valueOf(letra));
                        break;
                    case 3:
                        lblChar3.setText(String.valueOf(letra));
                        break;
                    case 4:
                        lblChar4.setText(String.valueOf(letra));
                        break;
                    case 5:
                        lblChar5.setText(String.valueOf(letra));
                        break;
                    case 6:
                        lblChar6.setText(String.valueOf(letra));
                        break;
                    default:
                    //JOptionPane.showMessageDialog(null, "La letra " + letra + " no se encuentra en la palabra");
                }
            } else {
                if (i == 6 && decision == false) {
                    intentos--;
                    Nivel nivel = new Nivel();
                    nivel.intentos(intentos, lblPersonaje);
                    JOptionPane.showMessageDialog(null, "La letra " + letra + " no se encuentra en la palabra. Te quedan " + intentos + " intentos.");
                    if(intentos == 0){
                        JOptionPane.showMessageDialog(null, "Ohh ya no tienes mas intentos, has perdido... :(");
                        niveles.setVisible(false);
                    }
                }
            }
        }
    }

    public void mostrarFrase(JTextArea lblFigura) {
        //String ubiImagen;
        switch (this.getPalabraElegida()) {//this.getPalabraElegida()
            case "ESCUELA":
                lblFigura.setText("Institución destinada a la enseñanza, en especial la primaria.");
                break;
            case "MENSAJE":
                lblFigura.setText("Es lo que podemos enviar y recibir como texto en un chat.");
                break;
            case "ENFERMO":
                lblFigura.setText("Persona que se encuentra mal de salud.");
                break;
            case "HORMIGA":
                lblFigura.setText("Insecto pequeño, que se toma como ejemplo al trabajo en equipo.");
                break;
            case "MAESTRO":
                lblFigura.setText("Persona encargada de enseñar en escuelas, colegios, universidades, etc.");
                break;
//            default:
//                throw new AssertionError();
        }
    }

    //Verifica si el label contiene un caracter o se encuentra vacio
    public void camposCaracter(JButton btnNuevaPalabra ,JLabel lblChar0, JLabel lblChar1, JLabel lblChar2, JLabel lblChar3, JLabel lblChar4, JLabel lblChar5, JLabel lblChar6) {
        int camposLlenos = 0;
        //for (int i = 0; i < this.getPalabraElegida().length(); i++) {
        if (!lblChar0.getText().isEmpty()) {
            camposLlenos++;
        }
        if (!lblChar1.getText().isEmpty()) {
            camposLlenos++;
        }
        if (!lblChar2.getText().isEmpty()) {
            camposLlenos++;
        }
        if (!lblChar3.getText().isEmpty()) {
            camposLlenos++;
        }
        if (!lblChar4.getText().isEmpty()) {
            camposLlenos++;
        }
        if (!lblChar5.getText().isEmpty()) {
            camposLlenos++;
        }
        if (!lblChar6.getText().isEmpty()) {
            camposLlenos++;
        }
        if(camposLlenos == 7){
            JOptionPane.showMessageDialog(null, "Enhorabuena!!! Has completado la palabra");
            btnNuevaPalabra.setVisible(true);
        }
    }
}
