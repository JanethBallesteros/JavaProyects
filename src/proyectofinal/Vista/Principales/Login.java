/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.Vista.Principales;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;

import proyectofinal.Modelo.Paciente;
import proyectofinal.Controlador.MetodosSeleccion;
/**
 *
 * @author KarimePamela
 */
public class Login extends JFrame implements ActionListener{

        private ImageIcon Usuario, fondo, cuadro, llave;
    private JFrame FramePrinci;
    private Container contenedor;
    private JButton JBaRegist, JBpassword;
     private JPanel PanelSup;
    private TextField TXTregist;
    private JPasswordField TXTpass;
     private JButton JBmenu;
    private JLabel LBLUsua, LBLregit, LBLpass, LBLfondo, LBLcuadro, LBLoginHere, LBLHealthapp;
    private Paciente PacienteLogeado;
    public Login(){
        super("Login");
      
        Color fondo1 = new Color(191,201,202);
        Color fondo2 = new Color(212,230,241);
        Color fondo3 = new Color(127,179,213);
        Color fondo4 = new Color(36,113,163);
        Color fondo5 = new Color(248,249,249);
        Color fondo6 = new Color(26,82,118);
        
        Usuario = new ImageIcon("src/ImagenesProy/user.png");
        llave = new ImageIcon("src/ImagenesProy/access.png");
        fondo = new ImageIcon("src/ImagenesProy/FondoDef23.png");
        cuadro = new ImageIcon("src/ImagenesProy/fondoBien.png");
         
        
       JBaRegist= new JButton("Login");
       JBaRegist.setBackground(fondo6);
       JBaRegist.setBorderPainted(true);
       JBaRegist.setFont(new Font("Arial", Font.PLAIN, 15));
       JBaRegist.setForeground(fondo5);
       JBaRegist.setBounds(695, 615, 100, 30);
       JBaRegist.addActionListener(this);
       
       JBpassword= new JButton("Registrarme");
       JBpassword.setBackground(fondo6);
       JBpassword.setBorderPainted(true);
       JBpassword.setFont(new Font("Arial", Font.PLAIN, 15));
       JBpassword.setForeground(fondo5);
       JBpassword.addActionListener(this);
       JBpassword.setBounds(480, 615, 120, 30);

       // ======================= TXT'S================
       TXTregist = new TextField();
       TXTregist.setBounds(600, 450,130, 25);
       TXTregist.setBackground(fondo4);
       TXTregist.setForeground(fondo5);
       TXTregist.setFont(new Font("Bodoni MT Poster Compressed", Font.PLAIN, 15));
       
       TXTpass= new JPasswordField ();
       TXTpass.setBounds(600, 535, 130,25);
       TXTpass.setBackground(fondo4);
       TXTpass.setForeground(fondo5);
       TXTpass.setFont(new Font("Bodoni MT Poster Compressed", Font.PLAIN, 15));
       
       //======================= LBL'S ==========
       LBLHealthapp = new JLabel("Health App");
       LBLHealthapp.setBounds(480,290, 500,100);
       LBLHealthapp.setForeground(fondo5);
       LBLHealthapp.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 20));        
  
       LBLoginHere = new JLabel("Login Here");
       LBLoginHere.setBounds(480,250, 500,100);
       LBLoginHere.setForeground(fondo5);
       LBLoginHere.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 45));        
               
       LBLUsua = new JLabel(Usuario);
       LBLUsua.setBounds(380,315, 300,300);
       LBLUsua.setForeground(fondo5);
       LBLUsua.setFont(new Font("Arial Unicode MS", Font.PLAIN, 15));
 
       LBLpass= new JLabel(llave);
       LBLpass.setBounds(365,395, 300,300);
       LBLpass.setForeground(fondo5);
       LBLpass.setFont(new Font("Arial Unicode MS", Font.PLAIN, 15));
       
       LBLregit = new JLabel("Ver Registro");
       LBLregit.setBounds(365,250, 150,30);
       LBLregit.setForeground(fondo5);
       LBLregit.setFont(new Font("Arial Unicode MS", Font.PLAIN, 15));

       LBLfondo= new JLabel(fondo);
       LBLfondo.setBounds(0,0, 150,30);
       LBLfondo.setFont(new Font("Arial Unicode MS", Font.PLAIN, 15));
      
       LBLcuadro= new JLabel(cuadro);
       LBLcuadro.setBounds(-50,-60, 700,700);
       LBLcuadro.setFont(new Font("Arial Unicode MS", Font.PLAIN, 15));
      
       PanelSup = new JPanel(null);
       PanelSup.add(LBLcuadro);
       PanelSup.setBounds(390,120, 450,470);
       PanelSup.setPreferredSize(new Dimension(1200,100));
        
       FramePrinci = new JFrame();
       FramePrinci.pack();
       FramePrinci.add(TXTregist);
       FramePrinci.add(TXTpass);
       FramePrinci.add(LBLUsua);
       FramePrinci.add(LBLpass);
       FramePrinci.add(LBLHealthapp);
       FramePrinci.add(LBLoginHere);
       FramePrinci.add(JBaRegist);
       FramePrinci.add(JBpassword);
       FramePrinci.add(LBLfondo);
       
       FramePrinci.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       FramePrinci.setSize(1400,730);
       FramePrinci.setVisible(true);  
       
    }
    public static void main(String[] args) {
        Login log = new Login();
                
    }
    public void Limpiar(){
    TXTregist.setText("");
    TXTpass.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==JBaRegist){
            MetodosSeleccion m=new MetodosSeleccion();
            PacienteLogeado=m.CrearPaciente(TXTregist.getText(), TXTpass.getText());
           
            if (PacienteLogeado.getId()>0){
        
                System.out.println(PacienteLogeado);
                
                Menu men = new Menu(PacienteLogeado);
                FramePrinci.setVisible(false); 
            }else{
                System.out.println("Datos erroneos vuelve a escribir");
                JOptionPane.showMessageDialog(this, "Datos erroneos vuelve a escribr");
                Limpiar();          
            }
        }
        
        if(ae.getSource()==JBpassword){
           proyectofinal.Vista.Principales.PacienteFrame run= new proyectofinal.Vista.Principales.PacienteFrame();
            FramePrinci.setVisible(false); 
        }
    }   
}
