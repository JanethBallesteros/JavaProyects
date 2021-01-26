/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.Controlador;


import proyectofinal.Modelo.Glucosa;
import proyectofinal.Modelo.Presion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyectofinal.Modelo.ActividadFisica;
import proyectofinal.Modelo.Alimentacion;
import proyectofinal.Modelo.Conexion;
import proyectofinal.Modelo.Medicamentos;

/**
 *
 * @author osito
 */
import proyectofinal.Modelo.Paciente;

import proyectofinal.Vista.Principales.Login;

public class MetodosSeleccion {

    
    
    
    
    //metodo que busca  unn paciente para logearlo y lo regresa como objeto para su uso posterior
     public Paciente CrearPaciente(String nombre,String pass){
        Paciente PacienteLogeado= new Paciente();
        
        String sql= "SELECT * FROM PACIENTE WHERE  NombreUsuario='"+nombre+"' AND Contraseña= '"+pass+"'";
    
        try {
            Statement st = Conexion.obtener().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                PacienteLogeado.setId(rs.getObject(1).hashCode());
             PacienteLogeado.setNombre(rs.getObject(2).toString());
             PacienteLogeado.setApellido(rs.getObject(3).toString());
             PacienteLogeado.setEdad(rs.getObject(4).hashCode());
              PacienteLogeado.setSexo(rs.getObject(5).toString());
               PacienteLogeado.setAltura(Double.parseDouble(rs.getObject(6).toString()));
                PacienteLogeado.setPeso(Double.parseDouble(rs.getObject(7).toString()));
                 PacienteLogeado.setNombreusuario(rs.getObject(8).toString());
                  PacienteLogeado.setContrasena(rs.getObject(9 ).toString());
                  
                
               
                            }else{
                System.out.println("No coindiden los datos");
                       
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return PacienteLogeado;
     }
//metodo que busca  unn paciente para logearlo y lo regresa como objeto para su uso posterior
     public Paciente BuscarPacienteId (int id){
        Paciente PacienteLogeado= new Paciente();
        
        String sql= "SELECT * FROM PACIENTE WHERE  idPaciente="+id+"";
    
        try {
            Statement st = Conexion.obtener().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                PacienteLogeado.setId(rs.getObject(1).hashCode());
             PacienteLogeado.setNombre(rs.getObject(2).toString());
             PacienteLogeado.setApellido(rs.getObject(3).toString());
             PacienteLogeado.setEdad(rs.getObject(4).hashCode());
              PacienteLogeado.setSexo(rs.getObject(5).toString());
               PacienteLogeado.setAltura(Double.parseDouble(rs.getObject(6).toString()));
                PacienteLogeado.setPeso(Double.parseDouble(rs.getObject(7).toString()));
                 PacienteLogeado.setNombreusuario(rs.getObject(8).toString());
                  PacienteLogeado.setContrasena(rs.getObject(9 ).toString());
                  
                
               
                            }else{
                System.out.println("No coindiden los datos");
                       
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return PacienteLogeado;
    }
    
     //====================metodo que valida que no haya nombres repetidos=============//
     public boolean NombresRepetido(String nombre){
    
    String sql= "SELECT NombreUsuario FROM PACIENTE WHERE NombreUsuario='"+nombre+"'";
    boolean resultado = false;
        try {
            
            Statement st = Conexion.obtener().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
            resultado= false;
            System.out.println("el nombre esta repetido");
            }else{
            resultado= true;
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(MetodosSeleccion.class.getName()).log(Level.SEVERE, null, ex);
        }
       return resultado; 
    }
     
     //===========metodo que retorna el nombre del usuario logeado================//
     public String NombreUsuario(Paciente p){
    String nombre= "";  
    String sql= "SELECT NombreUsuario FROM PACIENTE WHERE idPaciente='"+p.getId()+"'";
    
        try {
            Statement st = Conexion.obtener().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
             nombre=rs.getObject(1).toString();
                System.out.println("los datos coinciden la persona es "+nombre);
            }else{
                JOptionPane.showMessageDialog(null, "El nombre ya existe");
                System.out.println("No coindiden los datos");
                       
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
       return nombre;
    }
     
   ///========retorna el numero de registros de la tabla que necesitemos==========//
         public int NumeroRegistros(String NombreTabla, int id){
    String sql= "SELECT COUNT (*) FROM "+NombreTabla+" WHERE idPaciente="+id+"";
    int Registros=0;
        try {
            Statement st = Conexion.obtener().createStatement();
            ResultSet rs = st.executeQuery(sql);
             Registros=rs.getObject(1).hashCode();
             
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Registros;
    }  
    //========RECUPERA TODOS LOS ELEMENTOS EN UN PACIENTE=========//
       public List<Paciente> recuperarPacientes() throws SQLException{
      List<Paciente> pacientes = new ArrayList<>();
      String sql= "SELECT * FROM PACIENTE";
      try{
         PreparedStatement consulta = Conexion.obtener().prepareStatement(sql);
         ResultSet resultado = consulta.executeQuery();
         while(resultado.next()){
             Paciente temp= new Paciente(resultado.getString("Nombre"),resultado.getString("Apellido"),resultado.getString("NombreUsuario"),resultado.getString("Contraseña"),resultado.getString("Genero"),resultado.getInt("Edad"),resultado.getDouble("Estatura"),resultado.getDouble("Peso"));
            temp.setId(resultado.getInt("idPaciente"));
             pacientes.add(temp);
         }
      }catch(SQLException ex){
         throw new SQLException(ex);
      }
      return pacientes;
   }
       
       //======== RECUPERA TODOS LOS ELEMENTOS DE TIPO GLUCOSA======//
       public List<Glucosa> recuperarGlucosa(Paciente p) throws SQLException{
      List<Glucosa> glu = new ArrayList<>();
      String sql= "SELECT * FROM GLUCOSA WHERE idPaciente="+p.getId()+"";
      try{
         PreparedStatement consulta = Conexion.obtener().prepareStatement(sql);
         ResultSet resultado = consulta.executeQuery();
         while(resultado.next()){
             Glucosa temp= new Glucosa(resultado.getInt("idPaciente"),resultado.getString("Fecha"),resultado.getDouble("Nivel_Glucosa"));
            temp.setIdGlucosa(resultado.getInt("idGlucosa"));
             glu.add(temp);
         }
      }catch(SQLException ex){
         throw new SQLException(ex);
      }
      return glu;
   }
    //=======RECUPERA TODOS LOS REFISTROS DE PRESION EN UN PACIENTE=======//   
        public List<Presion> recuperarPresion(Paciente p) throws SQLException{
      List<Presion> pre = new ArrayList<>();
      String sql= "SELECT * FROM PRESION WHERE idPaciente="+p.getId()+"";
      try{
         PreparedStatement consulta = Conexion.obtener().prepareStatement(sql);
         ResultSet resultado = consulta.executeQuery();
         while(resultado.next()){
             Presion temp= new Presion(resultado.getInt("idPaciente"),resultado.getString("Fecha"),resultado.getInt("PresionSistolica"),resultado.getInt("PresionDiastolica"));
            temp.setIdPresion(resultado.getInt("idPresion"));
             pre.add(temp);
         }
      }catch(SQLException ex){
         throw new SQLException(ex);
      }
      return pre;
   }
        
        //=======RECUPERA TODOS LOS REFISTROS DE ALIMENTACION EN UN PACIENTE=======//   
        public List<Alimentacion> recuperarAlimentacion(Paciente p) throws SQLException{
      List<Alimentacion> al = new ArrayList<>();
      String sql= "SELECT * FROM ALIMENTACION WHERE idPaciente="+p.getId()+"";
      try{
         PreparedStatement consulta = Conexion.obtener().prepareStatement(sql);
         ResultSet resultado = consulta.executeQuery();
         while(resultado.next()){
             Alimentacion temp= new Alimentacion (resultado.getInt("idPaciente"),resultado.getString("Fecha"),resultado.getDouble("CantidadCarbohidratos"),resultado.getDouble("CantidadLiquidos"));
            temp.setIdAlimentacion(resultado.getInt("idAlimentacion"));
             al.add(temp);
         }
      }catch(SQLException ex){
         throw new SQLException(ex);
      }
      return al;
   }
        
          //=======RECUPERA TODOS LOS REFISTROS DE ACTIVIDAD FISICA EN UN PACIENTE=======//   
        public List<ActividadFisica> recuperarActividadFisica(Paciente p) throws SQLException{
      List<ActividadFisica> af = new ArrayList<>();
      String sql= "SELECT * FROM ACTIVIDADFISICA WHERE idPaciente="+p.getId()+"";
      try{
         PreparedStatement consulta = Conexion.obtener().prepareStatement(sql);
         ResultSet resultado = consulta.executeQuery();
         while(resultado.next()){
             ActividadFisica temp= new ActividadFisica (resultado.getInt("idPaciente"),resultado.getString("Fecha"),resultado.getDouble("HorasActividad"),resultado.getString("TipoActividad"));
            temp.setIdActividad(resultado.getInt("idActividadFisica"));
             af.add(temp);
         }
      }catch(SQLException ex){
         throw new SQLException(ex);
      }
      return af;
   }
        
  public List<Medicamentos> recuperarMedicamentos(Paciente p) throws SQLException{
      List<Medicamentos> me = new ArrayList<>();
      String sql= "SELECT * FROM MEDICAMENTOS WHERE idPaciente="+p.getId()+"";
      try{
         PreparedStatement consulta = Conexion.obtener().prepareStatement(sql);
         ResultSet resultado = consulta.executeQuery();
         while(resultado.next()){
             Medicamentos temp= new Medicamentos (resultado.getInt("idPaciente"),resultado.getString("Dosis"),resultado.getString("NombreMedicamento"),resultado.getString("Fecha"));
            temp.setIdMedicamento(resultado.getInt("idMedicamentos"));
             me.add(temp);
         }
      }catch(SQLException ex){
         throw new SQLException(ex);
      }   
      return me;
   }
}
