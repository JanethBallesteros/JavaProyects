/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.Modelo;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author osito
 */
public class HoraSistema {

    public HoraSistema() {
    }
        
        
        public String TiempoActual(){
             ///=============== AQUI COMINEZA LA CONFIGURACIOON DE LA HORA DEL SISTEMA=======//
    //Instanciamos el objeto Calendar
        //en fecha obtenemos la fecha y hora del sistema
        Calendar fecha = new GregorianCalendar();
        Date d = new Date();
        SimpleDateFormat plantilla = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String tiempo = plantilla.format(d);
        Timestamp Fecha = new Timestamp(d.getTime());
        //Obtenemos el valor del año, mes, día,
        //hora, minuto y segundo del sistema
        //usando el método get y el parámetro correspondiente
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int minuto = fecha.get(Calendar.MINUTE);
        int segundo = fecha.get(Calendar.SECOND);
     ///////TERMINA ============CONFIGURACION DE LA HORA DEL SISTEMA  
        return tiempo;
        }
        public static void main(String[] args) {
        HoraSistema h= new HoraSistema();
            System.out.println(h.TiempoActual());
    }
}
