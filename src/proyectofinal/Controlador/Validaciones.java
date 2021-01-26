/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.Controlador;

import javax.swing.JOptionPane;

/**
 *
 * @author osito
 */
public class Validaciones {
        public static boolean isNumerico(String str){
            try{
                double d = Double.parseDouble(str);
            } catch(NumberFormatException nfe) {  
                JOptionPane.showMessageDialog(null, "Ingrese Cantidades", "Solo permite ingresar numeros", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            return true;
        }
}
