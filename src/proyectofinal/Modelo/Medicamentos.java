/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.Modelo;

/**
 *
 * @author osito
 */
public class Medicamentos {
    private int idMedicamento;
    private int idPaciente;
    private String dosis;
    private String nombreMedicamento;
    private String Fecha;

    public Medicamentos(int idPaciente, String dosis, String nombreMedicamento, String Fecha) {
        this.idPaciente = idPaciente;
        this.dosis = dosis;
        this.nombreMedicamento = nombreMedicamento;
        this.Fecha = Fecha;
    }

    public Medicamentos() {
    }

    public int getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(int idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    public void setNombreMedicamento(String nombreMedicamento) {
        this.nombreMedicamento = nombreMedicamento;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    @Override
    public String toString() {
        return "Medicamentos{" + "idMedicamento=" + idMedicamento + ", idPaciente=" + idPaciente + ", dosis=" + dosis + ", nombreMedicamento=" + nombreMedicamento + ", Fecha=" + Fecha + '}';
    }
    
    
    
}
