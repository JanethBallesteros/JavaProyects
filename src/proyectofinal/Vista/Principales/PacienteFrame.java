/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.Vista.Principales;

import proyectofinal.Modelo.Conexion;
import proyectofinal.Modelo.Paciente;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyectofinal.Controlador.MetodosAgregacion;
import proyectofinal.Controlador.MetodosSeleccion;

/**
 *
 * @author KarimePamela
 */
public class PacienteFrame extends JFrame implements ActionListener {

   
    private JPanel llenado;
    private JLabel lbnombre, lbapellido, lbnombreusuario, lbcontrasena1, lbcontrasena2, lbedad, lbsexo, lbaltura, lbpeso;
    private JLabel lbkg, lbanos, lbmetros, LBLfondo;
    private JTextField txtnombre, txtnombreusuario, txtapellido, txtedad, txtaltura, txtpeso;
    private JTextField contrasena1, contrasena2;
    private JComboBox sexo;
    private JButton guardar, cancelar;

    Ejercicio objeto;
    private ImageIcon  fondo;
    private JFrame FramePrinci;
    private JPanel  PanelBoto;
 
    public Statement stmt;
    ResultSet rs;
    Paciente pa;


    public JPanel Llenado() {

        String sexos[] = {"Masculino", "Femenino"};
        sexo = new JComboBox(sexos);

        Color fondo1 = new Color(191, 201, 202);
        Color fondo2 = new Color(212, 230, 241);
        Color fondo3 = new Color(127, 179, 213);
        Color fondo4 = new Color(36, 113, 163);
        Color fondo5 = new Color(248, 249, 249);
        Color fondo6 = new Color(26, 82, 118);
        Color fondo7 = new Color(0, 0, 0);

       
        fondo = new ImageIcon("src/ImagenesProy/healthapp.png");

        LBLfondo = new JLabel(fondo);
        LBLfondo.setBounds(0, 0, 150, 30);

        lbnombre = new JLabel("Nombre:");
        lbnombre.setForeground(fondo5);
        lbnombre.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));

        lbapellido = new JLabel("Apellido:");
        lbapellido.setForeground(fondo5);
        lbapellido.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));

        lbcontrasena1 = new JLabel("Contrasena:");
        lbcontrasena1.setForeground(fondo5);
        lbcontrasena1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));

        lbcontrasena2 = new JLabel("Contrasena:");
        lbcontrasena2.setForeground(fondo5);
        lbcontrasena2.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));

        lbedad = new JLabel("Edad:");
        lbedad.setForeground(fondo5);
        lbedad.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));

        lbsexo = new JLabel("Sexo:");
        lbsexo.setForeground(fondo5);
        lbsexo.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));

        lbnombreusuario = new JLabel("Nombre Usuario");
        lbnombreusuario.setForeground(fondo5);
        lbnombreusuario.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));

        lbaltura = new JLabel("Altura:");
        lbaltura.setForeground(fondo5);
        lbaltura.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));

        lbpeso = new JLabel("Peso:");
        lbpeso.setForeground(fondo5);
        lbpeso.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));

        lbkg = new JLabel("kilogramos");
        lbkg.setForeground(fondo5);
        lbkg.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));

        lbanos = new JLabel("años");
        lbanos.setForeground(fondo5);
        lbanos.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));

        lbmetros = new JLabel("metros");
        lbmetros.setForeground(fondo5);
        lbmetros.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));

        txtnombre = new JTextField(20);
        txtnombre.setBackground(fondo2);
        txtnombre.setForeground(fondo7);
        txtnombre.setFont(new Font("Bodoni MT Poster Compressed", Font.PLAIN, 20));

        txtapellido = new JTextField(20);
        txtapellido.setBackground(fondo2);
        txtapellido.setForeground(fondo7);
        txtapellido.setFont(new Font("Bodoni MT Poster Compressed", Font.PLAIN, 20));

        txtnombreusuario = new JTextField(20);
        txtnombreusuario.setBackground(fondo2);
        txtnombreusuario.setForeground(fondo7);
        txtnombreusuario.setFont(new Font("Bodoni MT Poster Compressed", Font.PLAIN, 20));

        txtedad = new JTextField(20);
        txtedad.setBackground(fondo2);
        txtedad.setForeground(fondo7);
        txtedad.setFont(new Font("Bodoni MT Poster Compressed", Font.PLAIN, 20));

        txtaltura = new JTextField(20);
        txtaltura.setBackground(fondo2);
        txtaltura.setForeground(fondo7);
        txtaltura.setFont(new Font("Bodoni MT Poster Compressed", Font.PLAIN, 20));

        txtpeso = new JTextField(20);
        txtpeso.setBackground(fondo2);
        txtpeso.setForeground(fondo7);
        txtpeso.setFont(new Font("Bodoni MT Poster Compressed", Font.PLAIN, 20));

        contrasena1 = new JTextField(20);
        contrasena1.setBackground(fondo2);
       contrasena1.setForeground(fondo7);
       contrasena1.setFont(new Font("Bodoni MT Poster Compressed", Font.PLAIN, 20));
        
        contrasena2 = new JTextField(20);
        contrasena2.setBackground(fondo2);
       contrasena2.setForeground(fondo7);
       contrasena2.setFont(new Font("Bodoni MT Poster Compressed", Font.PLAIN, 20));
        
        guardar = new JButton("Guardar");
        guardar.addActionListener(this);
        guardar.setBackground(fondo6);
        guardar.setFont(new Font("Bodoni MT Poster Compressed", Font.PLAIN, 20));
        guardar.setForeground(fondo1);
        
        cancelar = new JButton("Cancelar");
        cancelar.addActionListener(this);
        cancelar.setBackground(fondo6);
        cancelar.setFont(new Font("Bodoni MT Poster Compressed", Font.PLAIN, 20));
        cancelar.setForeground(fondo1);
        
        lbnombre.setBounds(30, 120, 150, 25);
        lbapellido.setBounds(30, 150, 150, 25);
        lbnombreusuario.setBounds(30, 180, 150, 25);
        lbcontrasena1.setBounds(30, 210, 150, 25);
        lbcontrasena2.setBounds(30, 240, 150, 25);
        lbsexo.setBounds(30, 270, 150, 25);
        lbedad.setBounds(30, 300, 150, 25);
        lbaltura.setBounds(30, 330, 150, 25);
        lbpeso.setBounds(30, 360, 150, 25);

        txtnombre.setBounds(190, 120, 150, 25);
        txtapellido.setBounds(190, 150, 150, 25);
        txtnombreusuario.setBounds(190, 180, 150, 25);
        contrasena1.setBounds(190, 210, 150, 25);
        contrasena2.setBounds(190, 240, 150, 25);
        sexo.setBounds(190, 270, 150, 25);
        txtedad.setBounds(190, 300, 150, 25);
        txtaltura.setBounds(190, 330, 150, 25);
        txtpeso.setBounds(190, 360, 150, 25);

        //BOTONES
        guardar.setBounds(50, 450, 150, 25);
        cancelar.setBounds(50, 500, 150, 25);
        //========================================== PANELES ======================3
        PanelBoto = new JPanel(null);
        PanelBoto.setBackground(fondo6);
        PanelBoto.setBounds(50, 30, 500, 650);

        llenado = new JPanel(null);
        llenado.setForeground(fondo1);
        llenado.setFont(new Font("Bodoni MT Poster Compressed", Font.PLAIN, 15));
        llenado.setBorder(BorderFactory.createTitledBorder("Datos de el Paciente"));
        llenado.setBounds(50, 30, 500, 650);
        llenado.setBackground(fondo6);
        llenado.add(lbnombre);

        llenado.add(txtnombre);
        llenado.add(lbapellido);
        llenado.add(txtapellido);
        llenado.add(lbcontrasena1);
        llenado.add(contrasena1);
        llenado.add(lbcontrasena2);
        llenado.add(contrasena2);
        llenado.add(lbedad);
        llenado.add(txtedad);
        llenado.add(lbsexo);
        llenado.add(sexo);
        llenado.add(lbaltura);
        llenado.add(txtaltura);
        llenado.add(lbpeso);
        llenado.add(txtpeso);
        llenado.add(lbnombreusuario);
        llenado.add(txtnombreusuario);
        llenado.add(guardar);
        llenado.add(cancelar);

        return llenado;

    }

    public boolean ValidarPaciente() {
        if (confirmarContra() && NombresRepetido()) {
            return true;
        } else {
            Limpiar();
            return false;
        }
    }

    public void LimpiarR() {
        txtnombre.setText("");
        txtnombreusuario.setText("");
        txtapellido.setText("");
        txtedad.setText("");
        txtaltura.setText("");
        txtpeso.setText("");
        contrasena1.setText("");
        contrasena2.setText("");
    }
     public void Limpiar() {
        txtnombreusuario.setText("");
        contrasena1.setText("");
        contrasena2.setText("");
    }

    

    public boolean confirmarContra() {
        String c1 = contrasena1.getText();
        String c2 = contrasena2.getText();
        boolean resultado = true;
        if (c1.equals(c2)) {
            resultado = true;
        } else {
            resultado = false;
            JOptionPane.showMessageDialog(this, "Las contraseñas no coiciden");
            
        }
        return resultado;
    }

    public boolean NombresRepetido(){
        boolean res;
    MetodosSeleccion m= new MetodosSeleccion();
    res=m.NombresRepetido(txtnombreusuario.getText());
    return res;
    }
    
    public PacienteFrame() {

        FramePrinci = new JFrame();
        FramePrinci.pack();

        FramePrinci.add(Llenado());
        FramePrinci.add(LBLfondo);
        FramePrinci.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FramePrinci.setSize(1400, 730);
        FramePrinci.setVisible(true);
    }

   
    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource()==guardar){
       if(ValidarPaciente()){
           String nombre=txtnombre.getText();
           String ap=txtapellido.getText();
           String u= txtnombreusuario.getText();
           String con= contrasena1.getText();
           String se= sexo.getSelectedItem().toString();
        int edad=Integer.parseInt(txtedad.getText());
        double al=Double.parseDouble(txtaltura.getText());
        double pes=Double.parseDouble(txtpeso.getText());
        
        
        pa= new Paciente(nombre,ap,u,con,se,edad,al,pes);
            System.out.println(pa);
            MetodosAgregacion ma= new MetodosAgregacion();
            ma.AgregarDB(pa);
            LimpiarR();
             Login run= new Login();
             FramePrinci.setVisible(false); 
       }else {
           System.out.println("ocurrio una excepcion con atributos");
       }
     }
        if (e.getSource() == cancelar) {
            Login run= new Login();
            FramePrinci.setVisible(false); 
        }
    }

}
