/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.Modelo;

import proyectofinal.Controlador.MetodosSeleccion;

/**
 *
 * @author House
 */
public class ActividadFisica {
    private int IdActividad;
    private int IdUsuario;
    private String Fecha;
    private double horasActividad;
    private String tipoActividad;
    
    private String estatus;
    private String EstatusIMC;

    public String getEstatusIMC() {
        return estatusPeso() ;
    }
    
    public String getEstatus() {
        return estatusActividad();
    }

    
    
    MetodosSeleccion ms= new MetodosSeleccion();
    Paciente p= new Paciente();
    
    
    
    
    public ActividadFisica(int IdUsuario, String Fecha, double horasActividad, String tipoActividad) {
        this.IdUsuario = IdUsuario;
        this.Fecha = Fecha;
        this.horasActividad = horasActividad;
        this.tipoActividad = tipoActividad;
    }

    public int getIdActividad() {
        return IdActividad;
    }

    public void setIdActividad(int IdActividad) {
        this.IdActividad = IdActividad;
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

    public double getHorasActividad() {
        return horasActividad;
    }

    public void setHorasActividad(double horasActividad) {
        this.horasActividad = horasActividad;
    }

    public String getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    @Override
    public String toString() {
        return "ActividadFisica{" + "IdActividad=" + IdActividad + ", IdUsuario=" + IdUsuario + ", Fecha=" + Fecha + ", horasActividad=" + horasActividad + ", tipoActividad=" + tipoActividad + '}';
    }
    
    public String estatusPeso(){
    String e="";
    p= ms.BuscarPacienteId(IdUsuario);
    if(p.getIMC()>25.0){e="Sobrepeso";}
    else if(p.getIMC()<25 && p.getIMC()>20) e= "Normal";
    else if(p.getIMC()<=20) e="desnutricion";
    return e;
    }
    
    public String estatusActividad(){
    String e="";
    p= ms.BuscarPacienteId(IdUsuario);
    if(this.horasActividad<p.actividadIdeal) e="Necesitas hacer mas Ejercicio";
    else if(this.horasActividad>=p.actividadIdeal-.05 &&this.horasActividad<=p.actividadIdeal+.05) e="Has cumplido la meta";
    else if(this.horasActividad>p.actividadIdeal) e="Hiciste mas ejercicio del requerido";
    return e;
    
    }
    
}
