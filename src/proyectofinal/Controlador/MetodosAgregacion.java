/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.Controlador;

import proyectofinal.Modelo.ActividadFisica;
import proyectofinal.Modelo.Alimentacion;
import proyectofinal.Modelo.Glucosa;
import proyectofinal.Modelo.Presion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import proyectofinal.Modelo.Conexion;
import proyectofinal.Modelo.Medicamentos;
import proyectofinal.Modelo.Paciente;

/**
 *
 * @author osito
 */
public class MetodosAgregacion {

    //para la conexion
     public Statement stmt;
      ResultSet rs;
      Paciente pa;
      
    public MetodosAgregacion() {
    }
    //para registrar nuevo usuario
    public void AgregarDB(Paciente p){
         try{
                 stmt = Conexion.obtener().createStatement();// para evitar consultas a la BD
                   stmt.executeUpdate("INSERT INTO `PACIENTE` (`idPaciente`, `Nombre`, `Apellido`, `Edad`, `Genero`, `Estatura`, `Peso`, `NombreUsuario`, `Contraseña`) "
                           + "VALUES (DEFAULT, '"+p.getNombre()+"', '"+p.getApellido()+"',"+p.getEdad()+", '"+p.getSexo()+"', "+p.getAltura()+", "+p.getPeso()+", '"+p.getNombreusuario()+"', '"+p.getContrasena()+"')");
     
             }catch(SQLException ex){
                 System.err.println("Ocurrio excepcion"+ex);
             }
    }
        
    //para agregar glucosa
          public void AgregarDBGlucosa(Glucosa glu){
         try{
                 stmt = Conexion.obtener().createStatement();// para evitar consultas a la BD
                   stmt.executeUpdate("INSERT INTO GLUCOSA(idGlucosa,idPaciente,Fecha,Nivel_Glucosa,EstatusGl) "
                           + "VALUES (DEFAULT, "+glu.getIdUsuario()+",'"+glu.getFecha()+"', "+glu.getNivelGlucosa()+",'"+glu.getEstatus()+"')");
     
             }catch(SQLException ex){
                 System.err.println("Ocurrio excepcion"+ex);
             }
            }
          
          public void AgregarDBPresion(Presion pre){
         try{
                 stmt = Conexion.obtener().createStatement();// para evitar consultas a la BD
                   stmt.executeUpdate("INSERT INTO PRESION(idPresion,idPaciente,Fecha,PresionSistolica,PresionDiastolica,EstatusPr) "
                           + "VALUES (DEFAULT, "+pre.getIdUsuario()+",'"+pre.getFecha()+"', "+pre.getPresionSistolica()+", "+pre.getPresionDiastolica()+",'"+pre.getEstatus()+"')");
     
             }catch(SQLException ex){
                 System.err.println("Ocurrio excepcion"+ex);
             }
         }
          
          public void AgregarDBAlimentacion(Alimentacion ali){
         try{
                 stmt = Conexion.obtener().createStatement();// para evitar consultas a la BD
                   stmt.executeUpdate("INSERT INTO ALIMENTACION(idAlimentacion,idPaciente,Fecha,CantidadCarbohidratos,CantidadLiquidos,EstatusAl) "
                           + "VALUES (DEFAULT, "+ali.getIdUsuario()+",'"+ali.getFecha()+"', "+ali.getCantidadCarbohidratos()+", "+ali.getCantidadLiquidos()+",'"+ali.getEstatus()+"')");
     
             }catch(SQLException ex){
                 System.err.println("Ocurrio excepcion"+ex);
             }
         }
          
          public void AgregarActividadFisica(ActividadFisica act){
           try{
                 stmt = Conexion.obtener().createStatement();// para evitar consultas a la BD
                   stmt.executeUpdate("INSERT INTO ACTIVIDADFISICA(idActividadFisica,idPaciente,Fecha,HorasActividad,TipoActividad,EstatusAF) "
                           + "VALUES (DEFAULT, "+act.getIdUsuario()+",'"+act.getFecha()+"', "+act.getHorasActividad()+", '"+act.getTipoActividad()+"','"+act.getEstatus()+"')");
     
             }catch(SQLException ex){
                 System.err.println("Ocurrio excepcion"+ex);
             }
         }
          
          public void AgregarMedicamento(Medicamentos med){
           try{
                 stmt = Conexion.obtener().createStatement();// para evitar consultas a la BD
                   stmt.executeUpdate("INSERT INTO MEDICAMENTOS(idMedicamentos,idPaciente,Dosis,NombreMedicamento,Fecha)"
                           + " VALUES (DEFAULT, "+med.getIdPaciente()+",'"+med.getDosis()+"', '"+med.getNombreMedicamento()+"', '"+med.getFecha()+"')");
     
             }catch(SQLException ex){
                 System.err.println("Ocurrio excepcion"+ex);
             }
         }
    
}
