/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.Vista.Principales;

import proyectofinal.Modelo.Conexion;
import java.awt.*;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import proyectofinal.Controlador.MetodosCambios;
import proyectofinal.Controlador.MetodosEliminacion;
import proyectofinal.Controlador.MetodosSeleccion;
import proyectofinal.Modelo.Paciente;


/**
 *
 * @author osito
 */
public class Configuracion extends JFrame implements MouseListener, ActionListener {
    private int Id_Usuario;
    private JLabel lbnombre,lbusuario,lbcontrasena,lbedad,lbaltura,lbpeso;
    private JLabel lbnombre2,lbusuario2,lbcontrasena2,lbedad2,lbaltura2,lbpeso2;
    private JButton JBmenu,jbRegLog;
    Container cont;
    JScrollPane scroll;
    JPanel pcont;
    
    
    private JButton guardar,cancelar,cerrarsesion;
    private JComboBox opcionesavanzadas;
    
    ///pacientera la base de datos
    public Statement stmt;
      ResultSet rs;
    
     Paciente paciente;
      MetodosEliminacion me= new MetodosEliminacion();
      
       Color letras = new Color(31, 97, 141);
        Color fondo2 = new Color(34,153,84);
        Color fondo3 = new Color(102,187,106);
      
    public Configuracion(Paciente p) {
        
         ImageIcon menu = new ImageIcon("src/ImagenesProy/menuPrin.png");
        JBmenu = new JButton("MENU");
        JBmenu.setIcon(menu);
        JBmenu.setBounds(900, 600, 190, 80);
        JBmenu.addActionListener(this);
        JBmenu.setBackground(fondo3);
        JBmenu.setForeground(fondo2);
        JBmenu.setOpaque(false);
        JBmenu.setBorderPainted(false);
        JBmenu.setFont(new Font("Century Gothic", Font.BOLD, 15));

        ImageIcon salir = new ImageIcon("src/ImagenesProy/salir1.png");
        jbRegLog = new JButton("SALIR");
        jbRegLog.setBounds(1100, 600, 190,80);
        jbRegLog.addActionListener(this);
        jbRegLog.setBackground(letras);
        jbRegLog.setIcon(salir);
        jbRegLog.setOpaque(false);
        jbRegLog.setBorderPainted(false);
        jbRegLog.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        cont= this.getContentPane();
        paciente=p;
        pcont= new JPanel();
        pcont.setSize(250,250);
        pcont.setLayout(new GridLayout(20,2,5,5));
        
        lbnombre= new JLabel("Nombre ");
        lbnombre2= new JLabel(p.getNombre());
        lbnombre2.addMouseListener(this);
        lbusuario= new JLabel("Nombre Usuario ");
        lbusuario2= new JLabel(p.getNombreusuario());
        lbusuario2.addMouseListener(this);
        lbcontrasena= new JLabel("Contraseña ");
        lbcontrasena2= new JLabel(p.getContrasena());
        lbcontrasena2.addMouseListener(this);
        lbedad= new JLabel("Edad ");
        lbedad2= new JLabel(""+p.getEdad());
        lbedad2.addMouseListener(this);
        lbaltura= new JLabel("Altura  ");
        lbaltura2= new JLabel(""+p.getAltura());
        lbaltura2.addMouseListener(this);
        lbpeso= new JLabel("Peso ");
        lbpeso2= new JLabel(""+p.getPeso());
        lbpeso2.addMouseListener(this);
        
        opcionesavanzadas=new JComboBox<String>();
        opcionesavanzadas.setModel(new DefaultComboBoxModel<>(new String[]{"Opciones Avanzadas","Eliminar Mis Datos","Eliminar Mi Cuenta"}));
        opcionesavanzadas.addActionListener(this);
        
        guardar= new JButton("Guardar");
        guardar.addActionListener(this);
        cancelar= new JButton("cancelar");
        cancelar.addActionListener(this);
        cerrarsesion= new JButton("Cerrar sesion");
        cerrarsesion.addActionListener(this);
        
        
        pcont.add(lbnombre);
        pcont.add(lbnombre2);
        pcont.add(lbusuario);
        pcont.add(lbusuario2);
        pcont.add(lbcontrasena);
        pcont.add(lbcontrasena2);
        pcont.add(lbedad);
        pcont.add(lbedad2);
        pcont.add(lbaltura);
        pcont.add(lbaltura2);
        pcont.add(lbpeso);
        pcont.add(lbpeso2);
        
        pcont.add(cancelar);
        pcont.add(guardar);
        pcont.add(cerrarsesion);
        pcont.add(opcionesavanzadas);
        
        
        
        scroll= new JScrollPane(pcont);
        scroll.setSize(250,500);
        cont.add(scroll);
        
        
        this.setVisible(true);
        this.pack();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550, 500);
    }
    
    public boolean NombresRepetido(String NombreUsuario){
        boolean res;
    MetodosSeleccion m= new MetodosSeleccion();
    res=m.NombresRepetido(NombreUsuario);
    return res;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
         if (me.getClickCount() == 2) {
             if(me.getSource()==lbnombre2){
                 System.out.println("Estas a punto de modificar");
                 JOptionPane.showMessageDialog(this, "Estas a punto de modificar");
                 String respuesta = JOptionPane.showInputDialog(null, "Escriba tu nuevo nombre", "Cambio de Nombre", JOptionPane.PLAIN_MESSAGE);
                 lbnombre2.setText(respuesta);
                 paciente.setNombre(respuesta);
                 
             }
             if(me.getSource()==lbusuario2){
                 System.out.println("estas a punto de modificar");
                 JOptionPane.showMessageDialog(this, "Estas a punto de modificar");
                 String respuesta = JOptionPane.showInputDialog(null, "Escriba su nuevo Nombre de Usuario", "Cambio de Nombre de Usuario", JOptionPane.PLAIN_MESSAGE);
                if( NombresRepetido(respuesta)){
                 lbusuario2.setText(respuesta);
                 paciente.setNombreusuario(respuesta);
                }else{
                    System.out.println("Nombre de Usuario Repoetido");
                    JOptionPane.showMessageDialog(this, "Nombre de Usuario repetido");
                }
             }
             if(me.getSource()==lbcontrasena2){
                 System.out.println("estas a punto de modificar");
                 JOptionPane.showMessageDialog(this, "Estas a punto de modificar");
                 String respuesta = JOptionPane.showInputDialog(null, "Escriba su nueva Contraseña", "Cambio de Contraseña", JOptionPane.PLAIN_MESSAGE);
                 lbcontrasena2.setText(respuesta);
                 paciente.setContrasena(respuesta);
             }
             if(me.getSource()==lbedad2){
                 System.out.println("estas a punto de modificar");
                 JOptionPane.showMessageDialog(this, "Estas a punto de modificar");
                 String respuesta = JOptionPane.showInputDialog(null, "Escriba su Edad", "Cambio Edad", JOptionPane.PLAIN_MESSAGE);
                 lbedad2.setText(respuesta);
                 int v=Integer.parseInt(respuesta);
                 paciente.setEdad(v);
             }
             if(me.getSource()==lbaltura2){
                 System.out.println("estas a punto de modificar");
                 JOptionPane.showMessageDialog(this, "Estas a punto de modificar");
                 String respuesta = JOptionPane.showInputDialog(null, "Escriba su Altura", "Cambio Altura", JOptionPane.PLAIN_MESSAGE);
                 lbaltura2.setText(respuesta);
                 double v=Double.parseDouble(respuesta);
                 paciente.setAltura(v);
             }
             if(me.getSource()==lbpeso2){
                 System.out.println("estas a punto de modificar");
                 JOptionPane.showMessageDialog(this, "Estas a punto de modificar");
                 String respuesta = JOptionPane.showInputDialog(null, "Escriba su Peso", "Cambio Peso", JOptionPane.PLAIN_MESSAGE);
                 lbpeso2.setText(respuesta);
                 double v=Double.parseDouble(respuesta);
                 paciente.setPeso(v);
             }

        }
    }
    

    @Override
    public void mousePressed(MouseEvent me) {
   }

    @Override
    public void mouseReleased(MouseEvent me) {
     }

    @Override
    public void mouseEntered(MouseEvent me) {
     }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==opcionesavanzadas) {
            if(opcionesavanzadas.getSelectedItem().equals("Eliminar Mis Datos")){
                JOptionPane.showMessageDialog(this, "Vas a eliminar todos tus datos");
                System.out.println("vbas a eliminar tus datos");
               
                me.EliminarDatos(paciente);
                
            }
            else if(opcionesavanzadas.getSelectedItem().equals("Eliminar Mi Cuenta")){
                JOptionPane.showConfirmDialog(this, "Vas a eliminar tu cuenta");
                System.out.println("vas a eliminar tu cuenta");
                me.EliminarCuenta(paciente);
                Login run=new Login();
                this.setVisible(false);
            }
        }
        if(ae.getSource()==guardar){
            MetodosCambios mc= new MetodosCambios();
            System.out.println(paciente);
            try {
                mc.ModificarPaciente(paciente);
            } catch (SQLException ex) {
                Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
            }
             }
        if(ae.getSource()==cerrarsesion){
            Login run= new Login();
            this.setVisible(false);
             }
        if(ae.getSource()==cancelar){
        Menu run= new Menu(paciente);
        this.setVisible(false);
        }
        
    
    }
    
}
