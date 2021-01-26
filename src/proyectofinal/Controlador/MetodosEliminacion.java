/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.Controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import proyectofinal.Modelo.Conexion;
import proyectofinal.Modelo.Paciente;

/**
 *
 * @author osito
 */
public class MetodosEliminacion {
    
     ///para la base de datos
    public Statement stmt;
      ResultSet rs;

    public MetodosEliminacion() {
    }
   
    //metodo que elimina todos los datos de un paciente
    public void EliminarDatos(Paciente pa){
        try{
                 stmt = Conexion.obtener().createStatement();// para evitar consultas a la BD
                   stmt.execute("DELETE FROM GLUCOSA WHERE idPaciente="+pa.getId()+"");
                   stmt.execute("DELETE FROM PRESION WHERE idPaciente="+pa.getId()+"");
                   stmt.execute("DELETE FROM ALIMENTACION WHERE idPaciente="+pa.getId()+"");
                   stmt.execute("DELETE FROM ACTIVIDADFISICA WHERE idPaciente="+pa.getId()+"");
                   stmt.execute("DELETE FROM MEDICAMENTOS WHERE idPaciente="+pa.getId()+"");
                   
     
             }catch(SQLException ex){
                 System.err.println("Ocurrio excepcion"+ex);
             }
    
    }
     
    public void EliminarCuenta(Paciente pa){
        try{
                 stmt = Conexion.obtener().createStatement();// para evitar consultas a la BD
                   stmt.execute("DELETE FROM PACIENTE WHERE idPaciente="+pa.getId()+"");
                   
             }catch(SQLException ex){
                 System.err.println("Ocurrio excepcion"+ex);
             }
    
    }
    
    public void Eliminarregistro(String NI,int idreg,String tabla){
        String t="id"+NI;
        try{
                 stmt = Conexion.obtener().createStatement();// para evitar consultas a la BD
                   stmt.execute("DELETE FROM "+ tabla+ " WHERE  "+t+"="+idreg+"");
                   
             }catch(SQLException ex){
                 System.err.println("Ocurrio excepcion"+ex);
             }
    
    }
}
