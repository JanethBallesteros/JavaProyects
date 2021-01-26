/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.Modelo;

import java.sql.Timestamp;
import proyectofinal.Controlador.MetodosSeleccion;

/**
 *
 * @author House
 */
public class Glucosa {
    private int IdGlucosa;
    private int IdUsuario;
    private String Fecha;
    double NivelGlucosa;
    
    
    private String estatus;

    public String getEstatus() {
        return estatusgl();
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    
    MetodosSeleccion ms= new MetodosSeleccion();
    Paciente p= new Paciente();
    //Constructor

    public Glucosa(int IdUsuario, String Fecha, double NivelGlucosa) {
        this.IdUsuario = IdUsuario;
        this.Fecha = Fecha;
        this.NivelGlucosa = NivelGlucosa;
    }
    // geters and setters

    public int getIdGlucosa() {
        return IdGlucosa;
    }

    public void setIdGlucosa(int IdGlucosa) {
        this.IdGlucosa = IdGlucosa;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public double getNivelGlucosa() {
        return NivelGlucosa;
    }

    public void setNivelGlucosa(double NivelGlucosa) {
        this.NivelGlucosa = NivelGlucosa;
    }
    
    
    //toString

    @Override
    public String toString() {
        return "Glucosa{" + "IdGlucosa=" + IdGlucosa + ", IdUsuario=" + IdUsuario + ", Fecha=" + Fecha + ", NivelGlucosa=" + NivelGlucosa + '}';
    }
    public String estatusgl(){
    String e="";
    p= ms.BuscarPacienteId(IdUsuario);
    if(this.NivelGlucosa<=p.glucosaIdeal+15){e="Tu Nivel es Excelente";}
    else if(this.NivelGlucosa>p.glucosaIdeal+15 && this.NivelGlucosa<=p.glucosaIdeal+115 ) e= "Tu Nivel Es Bueno";
    else if(this.NivelGlucosa>p.glucosaIdeal+115 ) e="Alerta!!! esta muy alto";
    
    return e;
    }
    
}
