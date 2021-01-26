/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import proyectofinal.Modelo.Conexion;
import proyectofinal.Modelo.Paciente;

/**
 *
 * @author osito
 */
public class MetodosCambios {
    
    ///para la base de datos
    public Statement stmt;
      ResultSet rs;


    public MetodosCambios() {
    }
    
    //metodo para modicar los datos del paciente
    public void ModificarPaciente(Paciente pa) throws SQLException{
        String sql="";
        Connection cn=Conexion.obtener();
        String nom,NU,con;
        int id,edad;
        double peso,altura;
        
        nom=pa.getNombre();
        NU=pa.getNombreusuario();
        con=pa.getContrasena();
        id=pa.getId();
        edad=pa.getEdad();
        peso=pa.getPeso();
        altura=pa.getAltura();
        sql = "UPDATE PACIENTE " +"SET Nombre = ?," +"Edad = ?," +
                "Estatura = ?," +"Peso= ?" +" WHERE idPaciente = "+id;
        String mensaje = "Los datos se han Modoficado de Manera Satisfactoria...";
        try{
            System.out.println(pa);
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setString(1, nom);
        pst.setInt(2, edad);
        pst.setDouble(3, altura);
        pst.setDouble(4, peso);
          int n = pst.executeUpdate();//valida si se guardaron los datos; si pst>0 entonces se guardaron  
          if(n > 0)
            {
            JOptionPane.showMessageDialog(null, mensaje);
            }
        }catch(SQLException ex){
                 System.err.println("Ocurrio excepcion"+ex);
             }
    
    }
  
    
}
