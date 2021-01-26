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
public class Presion {
    private int IdPresion;
    private int IdUsuario;
    private String Fecha;
    int PresionSistolica;
    int PresionDiastolica;
    
    private String estatus;

    public String getEstatus() {
        return estatusp();
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    
 MetodosSeleccion ms= new MetodosSeleccion();
    Paciente p= new Paciente();
    
    public Presion(int IdUsuario, String Fecha, int PresionSistolica, int PresionDiastolica) {
        this.IdUsuario = IdUsuario;
        this.Fecha = Fecha;
        this.PresionSistolica = PresionSistolica;
        this.PresionDiastolica = PresionDiastolica;
    }

    public int getIdPresion() {
        return IdPresion;
    }

    public void setIdPresion(int IdPresion) {
        this.IdPresion = IdPresion;
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

    public int getPresionSistolica() {
        return PresionSistolica;
    }

    public void setPresionSistolica(int PresionSistolica) {
        this.PresionSistolica = PresionSistolica;
    }

    public int getPresionDiastolica() {
        return PresionDiastolica;
    }

    public void setPresionDiastolica(int PresionDiastolica) {
        this.PresionDiastolica = PresionDiastolica;
    }

    @Override
    public String toString() {
        return "Presion{" + "IdPresion=" + IdPresion + ", IdUsuario=" + IdUsuario + ", Fecha=" + Fecha + ", PresionSistolica=" + PresionSistolica + ", PresionDiastolica=" + PresionDiastolica + '}';
    }
    
    public String estatusp(){
    String e="";
     p= ms.BuscarPacienteId(IdUsuario);
    if(p.getPresionSIdeal()>this.PresionSistolica)e="Presion Baja";
    else if (this.PresionSistolica<= p.getPresionSIdeal()+10 && this.PresionSistolica>=p.presionSIdeal-10) e="Presion Normal";
    else if (this.PresionSistolica>p.presionSIdeal) e="Presion alta";
    return e;
    }
    
    
    
}
