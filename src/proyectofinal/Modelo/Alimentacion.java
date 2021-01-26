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
public class Alimentacion {
    private int IdAlimentacion;
    private int IdUsuario;
     private String Fecha;
    private double CantidadCarbohidratos;
    private double CantidadLiquidos;

    private String estatus;
    private String EstatusIMC;

    public String getEstatusIMC() {
        return estatusPeso() ;
    }
    public String getEstatus() {
        return estatusal();
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    
    MetodosSeleccion ms= new MetodosSeleccion();
    Paciente p= new Paciente();
    
    public int getIdAlimentacion() {
        return IdAlimentacion;
    }

    public void setIdAlimentacion(int IdAlimentacion) {
        this.IdAlimentacion = IdAlimentacion;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario= IdUsuario;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public double getCantidadCarbohidratos() {
        return CantidadCarbohidratos;
    }

    public void setCantidadCarbohidratos(double CantidadCarbohidratos) {
        this.CantidadCarbohidratos = CantidadCarbohidratos;
    }

    public double getCantidadLiquidos() {
        return CantidadLiquidos;
    }

    public void setCantidadLiquidos(double CantidadLiquidos) {
        this.CantidadLiquidos = CantidadLiquidos;
    }

    public Alimentacion(int IdUsuario, String Fecha, double CantidadCarbohidratos, double CantidadLiquidos) {
        this.IdUsuario = IdUsuario;
        this.Fecha = Fecha;
        this.CantidadCarbohidratos = CantidadCarbohidratos;
        this.CantidadLiquidos = CantidadLiquidos;
    }

    @Override
    public String toString() {
        return "Alimentacion{" + "IdAlimentacion=" + IdAlimentacion + ", IdPaciente=" + IdUsuario + ", Fecha=" + Fecha + ", CantidadCarbohidratos=" + CantidadCarbohidratos + ", CantidadLiquidos=" + CantidadLiquidos + '}';
    }
   
    public String estatusPeso(){
    String e="";
    p= ms.BuscarPacienteId(IdUsuario);
    if(p.IMC>25.0){e="Sobrepeso";}
    else if(p.IMC<25 && p.IMC>20) e= "Normal";
    else if(p.IMC<=20) e="desnutricion";
    
    return e;
    }
    public String estatusal(){
    String e="";
    p= ms.BuscarPacienteId(IdUsuario);
    if(p.getAliemntacionIdeal()-20>this.CantidadCarbohidratos) e="Muy pocas calorias";
    else if(p.getAliemntacionIdeal()-20<=this.CantidadCarbohidratos && p.getAliemntacionIdeal()+20>=this.CantidadCarbohidratos) e="Calorias Correctas";
    else if(p.getAliemntacionIdeal()+20<this.CantidadCarbohidratos) e="Muchas Calorias";
    return e;
    
    }
    
}
