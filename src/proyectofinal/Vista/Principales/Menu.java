/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.Vista.Principales;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import javafx.animation.Animation;
import proyectofinal.Modelo.Paciente;
/**
 *
 * @author KarimePamela
 */
public class Menu extends JFrame implements ActionListener  {

    private JFrame frame;
    private Container contenedor;
    //private JButton JBCalend, JBGlucosa, JBMedica, JBEjerci,
    //        JBCarboh, JBAgua, JBPeso, JBBp;
   // private JButton prueb,JBPaciente, JBGlucosa, JBMedica, JBEjerci,
      //      JBCarboh, JBPresion, JBPeso, JBBp;
    private JRadioButton prueb,JBPaciente, JBGlucosa, JBMedica, JBEjerci,
     JBCarboh, JBPresion, JBPeso, JBBp, JBConfi;
    private ButtonGroup grupoBot;
    
    private JButton jbRegLog;
    
    private JPanel PanelMed, PanelSup, PanelInf, Panel1, Panel2,Panel3;
    private JLabel LBLMenu, LBLfondo, LBLTit,LBLmenuAm, LBLTituloLe,
            LBLEjercicio,LBLpresion,LBLalimn, LBLpaciente, LBLgluco;
    Paciente paciente;
     
          
    ImageIcon Men = new ImageIcon("src/ImagenesProy/Menu4.png");
    ImageIcon fondo= new ImageIcon("src/ImagenesProy/fondoMenu.png");
    ImageIcon titulo = new ImageIcon("src/ImagenesProy/TituloL.png");
    ImageIcon cuadMen = new ImageIcon("src/ImagenesProy/amarillo menu.png");
    ImageIcon medicamen = new ImageIcon("src/ImagenesProy/medicacion.png");
    ImageIcon ejercic = new ImageIcon("src/ImagenesProy/i5.png");
    ImageIcon carboh = new ImageIcon("src/ImagenesProy/i6.png");
    ImageIcon agua = new ImageIcon("src/ImagenesProy/water.png");
    ImageIcon peso = new ImageIcon("src/ImagenesProy/weight.png");
    ImageIcon bp = new ImageIcon("src/ImagenesProy/BP.png");

    
    public Menu(Paciente pa){
        super("Menu");
        
        Image icono = Toolkit.getDefaultToolkit().getImage("src/ImagenesProy/icono3.png");
        setIconImage(icono);
        
        paciente=pa;
                Color fondo1 = new Color(250,250,250);
                Color fondo2 = new Color(196, 67, 65);
                Color letras = new Color(31, 97, 141);
                Color fondo3 = new Color(102,187,106);
    
        ImageIcon salir = new ImageIcon("src/ImagenesProy/salir1.png");
        jbRegLog = new JButton("SALIR");
        jbRegLog.addActionListener(this);
        jbRegLog.setBackground(letras);
        jbRegLog.setIcon(salir);
        jbRegLog.setOpaque(false);
        jbRegLog.setBorderPainted(false);
        jbRegLog.setFont(new Font("Century Gothic", Font.PLAIN, 15));
                
    JBConfi = new JRadioButton();
    JBConfi.setIcon(new ImageIcon("src/ImagenesProy/conf.png"));
    JBConfi.setSelectedIcon(new ImageIcon("src/ImagenesProy/EnglishTime1.png"));
    JBConfi.setOpaque(false);
    JBConfi.setBounds(1020, 390,200, 200);
    JBConfi.addActionListener(this);
    
                
    JBPaciente = new JRadioButton();
    JBPaciente.setIcon(new ImageIcon("src/ImagenesProy/i1.png"));
    JBPaciente.setSelectedIcon(new ImageIcon("src/ImagenesProy/EnglishTime1.png"));
    JBPaciente.setOpaque(false);
    JBPaciente.setBounds(840, 390,200, 200);
    
    JBPaciente.addActionListener(this);
    
    
    JBCarboh = new JRadioButton();
    JBCarboh.setIcon(new ImageIcon("src/ImagenesProy/i6.png"));
    JBCarboh.setSelectedIcon(new ImageIcon("src/ImagenesProy/EnglishTime1.png"));
    JBCarboh.setOpaque(false);
    JBCarboh.setBounds(150, 410, 200, 330);
  //  JBCarboh.setPreferredSize(new Dimension(100,100));
    JBCarboh.addActionListener(this);
    
    
    JBEjerci = new JRadioButton();
    //prueb .setBorderPainted(false);
    JBEjerci.setIcon(new ImageIcon("src/ImagenesProy/i5.png"));
    JBEjerci .setSelectedIcon(new ImageIcon("src/ImagenesProy/EnglishTime1.png"));
    JBEjerci .setOpaque(false);
    JBEjerci.setBounds(330, 390, 200, 200);
    JBEjerci.addActionListener(this);
   // prueb .addMouseListener(this);
    
    JBGlucosa = new JRadioButton();
    JBGlucosa.setIcon(new ImageIcon("src/ImagenesProy/i3.png"));
    JBGlucosa.setSelectedIcon(new ImageIcon("src/ImagenesProy/EnglishTime1.png"));
    JBGlucosa.setOpaque(false);
    JBGlucosa.setBounds(500, 390, 200, 200);
    JBGlucosa.addActionListener(this);
    
    
    JBPresion = new JRadioButton();
    JBPresion.setIcon(new ImageIcon("src/ImagenesProy/i4.png"));
    JBPresion.setSelectedIcon(new ImageIcon("src/ImagenesProy/EnglishTime1.png"));
    JBPresion.setOpaque(false);
    JBPresion.setBounds(680,390, 200,200);
    
    JBPresion.addActionListener(this);
    
    /*
    
    JBMedica = new JRadioButton();
    JBMedica.setIcon(new ImageIcon("src/ImagenesProy/pilldoras.png"));
    JBMedica.setSelectedIcon(new ImageIcon("src/ImagenesProy/EnglishTime1.png"));
    JBMedica.setOpaque(false);
    JBMedica.setBounds(700, 360, 300, 300);
    JBMedica.setPreferredSize(new Dimension(100,100));
    JBMedica.addMouseListener(this);
    
    
    JBBp = new JRadioButton();
    JBBp.setIcon(new ImageIcon("src/ImagenesProy/i4.png"));
    JBBp.setSelectedIcon(new ImageIcon("src/ImagenesProy/EnglishTime1.png"));
    JBBp.setOpaque(false);
    JBBp.setPreferredSize(new Dimension(100,100));
    JBBp.addMouseListener(this);
    JBBp.setBounds(220, 195, 300, 300);
   
                
                */
                
                grupoBot = new ButtonGroup();
                grupoBot.add(JBCarboh);
                grupoBot.add(JBEjerci);
                grupoBot.add(JBGlucosa);
                grupoBot.add(JBPaciente);
                grupoBot.add(JBPresion);
                
                
    LBLEjercicio = new JLabel("Ejercicio");
    LBLEjercicio.setFont(new Font("Perpetua Titling MT", Font.BOLD, 20));
    LBLEjercicio.setForeground(letras);
    LBLEjercicio.setBounds(380,580,150,50);
    
    LBLalimn = new JLabel("Alimentacion");
    LBLalimn.setFont(new Font("Perpetua Titling MT", Font.BOLD, 20));
    LBLalimn.setForeground(letras);
    LBLalimn.setBounds(165,580,250,50);
      
    LBLgluco = new JLabel("Glucosa");
    LBLgluco.setFont(new Font("Perpetua Titling MT", Font.BOLD, 20));
    LBLgluco.setForeground(letras);
    LBLgluco.setBounds(550,580,150,50);            
                
    LBLpaciente = new JLabel(" usuario ");
    LBLpaciente.setFont(new Font("Perpetua Titling MT", Font.BOLD, 20));
    LBLpaciente.setForeground(letras);
    LBLpaciente.setBounds(855,580,350,50);        
    
    LBLpresion = new JLabel("Presion");
    LBLpresion.setFont(new Font("Perpetua Titling MT", Font.BOLD, 20));
    LBLpresion.setForeground(letras);
    LBLpresion.setBounds(720,580,300,50);        
    
    LBLfondo = new JLabel(fondo);
    LBLfondo.setOpaque(false);
    
    LBLMenu = new JLabel(Men);
    LBLMenu.setBounds(0,0,1400,734);
    
    
    LBLmenuAm = new JLabel(cuadMen);
    LBLmenuAm.setBounds(0,0,100,50);
    
        
   
    
    LBLTit= new JLabel(titulo);
    LBLTit.setBounds(20,0,500,50);
    
    LBLTituloLe = new JLabel("MENU");
    LBLTituloLe.setFont(new Font("Maiandra GD", Font.PLAIN, 20));
    LBLTituloLe.setForeground(Color.WHITE);
    LBLTituloLe.setBounds(0,40,100,50);
    
    Panel1 = new JPanel(null);
    Panel1.setBackground(fondo2);
    Panel1.add(LBLTituloLe);
    Panel1.add(LBLmenuAm);
    
    Panel2 = new JPanel(null);
    Panel2.setBackground(fondo2);
    Panel2.setLayout(new GridLayout(2,2,10,10));
    Panel2.add(LBLTituloLe);
    
    
    Panel3 = new JPanel(null);
    Panel3.setBackground(fondo2);
    Panel3.add(Panel2);
 
    
    
    
    PanelSup = new JPanel(null);
    PanelSup.setBackground(fondo2);
    PanelSup.add(LBLTituloLe);
    PanelSup.add(LBLmenuAm);
   // PanelSup.add(LBLTit);
    PanelSup.setPreferredSize(new Dimension(500, 45));
    
    PanelMed = new JPanel(null);
    PanelMed.add(JBGlucosa);
    PanelMed.add(JBCarboh);
    PanelMed.add(JBEjerci);
    PanelMed.add(JBGlucosa);
    PanelMed.add(JBPresion);
    PanelMed.add(JBPaciente);
    PanelMed.add(JBConfi);
    PanelMed.add(LBLEjercicio);
    PanelMed.add(LBLgluco);
    PanelMed.add(LBLalimn);
    PanelMed.add(LBLpaciente);
    PanelMed.add(LBLpresion);
    PanelMed.add(jbRegLog);
    PanelMed.add(LBLMenu);
    
    
   // PanelMed.setBackground(fondo1);
    
    PanelInf = new JPanel(null);
    PanelInf.setPreferredSize(new Dimension(500, 20));
    

    
    frame = new JFrame();
    frame.pack();
    //frame.add(jbRegLog);
    //frame.add(PanelSup, BorderLayout.NORTH);
    frame.add(PanelMed, BorderLayout.CENTER);
    frame.add(PanelMed, BorderLayout.CENTER);
    
   // frame.add(PanelMed);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(1400,735);
    frame.setVisible(true);
        
    }
    
    public static void main(String[] args) {
       // Menu obMenu = new Menu();
    }

    Menu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
      if(JBPaciente.isSelected()){
         Configuracion run= new Configuracion(paciente);
          frame.setVisible(false);         
      }
      if (JBCarboh.isSelected()){
         
          Alimentacion obj = new Alimentacion(paciente);
                   frame.setVisible(false);
      }
      if ( JBGlucosa.isSelected()){
         
          Glucosa obg = new Glucosa(paciente);
                   frame.setVisible(false);
      }
      if (JBEjerci.isSelected()){
          
          Ejercicio obE = new Ejercicio(paciente);
           frame.setVisible(false);
      }
      if(JBPresion.isSelected()){
          
          Presion obP = new Presion(paciente);
           frame.setVisible(false);
      }
     if(e.getSource()==jbRegLog){
          Login obLog = new Login();
          frame.setVisible(false);
      }
      if(e.getSource()==JBConfi){
         
          Configuracion FmConf = new  Configuracion(paciente);
           frame.setVisible(false);
      }
    }

   
}
