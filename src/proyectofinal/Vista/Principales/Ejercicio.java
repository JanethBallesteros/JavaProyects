/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.Vista.Principales;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import proyectofinal.Modelo.Paciente;
import proyectofinal.Vista.MuestreoDatos.VentanaEjerci;

/**
 *
 * @author KarimePamela
 */
public class Ejercicio extends JFrame implements  ActionListener {

    Ejercicio objeto;
    private ImageIcon Usuario, fondo, cuadro, llave;
    private JFrame FramePrinci;
    private Container contenedor;
    private JButton JBaRegist, JBpassword, JBverVentana;
        private JButton  JBmenu;
    private JRadioButton Rcuerda, Rbiseps, Rpesas, RPesaTorz;
    private JPanel PanelTodo, PanelDatos, PanelBoto;
    private TextField TXTHoras, TXTestatura, TXTcalorias, TXT;
    private JButton jbRegLog;

    private JLabel LBLEjCuer, LBLbrazo, LBLtorzo, LBLfondo,
            LBLcuadro, LBLpezas, LBLHealthapp;
    private ButtonGroup grupo;

    private Paciente paciente;

    public Ejercicio(Paciente p) {
        super("Ejercicio");
        this.paciente = p;
        Color fondo1 = new Color(191, 201, 202);
        Color fondo2 = new Color(212, 230, 241);
        Color fondo3 = new Color(46, 134, 193);
        Color fondo4 = new Color(36, 113, 163);
        Color fondo5 = new Color(248, 249, 249);
        Color fondo6 = new Color(26, 82, 118);
        Color letras = new Color(31, 97, 141);
        
        
        Usuario = new ImageIcon("src/ImagenesProy/user.png");
        llave = new ImageIcon("src/ImagenesProy/access.png");
        fondo = new ImageIcon("src/ImagenesProy/Excersice.png");
        cuadro = new ImageIcon("src/ImagenesProy/Green2.png");
      //========================JRADIOBOTON =============
       JBmenu= new JButton("MENU");
       JBmenu.setBounds(90, 587,100,30);
       JBmenu.addActionListener(this);
       JBmenu.setBackground(fondo3);
       JBmenu.setForeground(fondo2);
       JBmenu.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        
        jbRegLog = new JButton("SALIR");
        jbRegLog.setBounds(1100, 587, 100, 30);
        jbRegLog.addActionListener(this);
        jbRegLog.setBackground(letras);
        jbRegLog.setForeground(fondo1);
        jbRegLog.setFont(new Font("Century Gothic", Font.PLAIN, 15));

        Rcuerda = new JRadioButton("");
        Rcuerda.setIcon(new ImageIcon("src/ImagenesProy/cuerda.png"));
        Rcuerda.setSelectedIcon(new ImageIcon("src/ImagenesProy/EnglishTime1.png"));
        Rcuerda.setOpaque(false);
        Rcuerda.setBounds(20, 50, 110, 110);
        Rcuerda.addActionListener(this);

        Rbiseps = new JRadioButton("");
        Rbiseps.setIcon(new ImageIcon("src/ImagenesProy/biseps.png"));
        Rbiseps.setSelectedIcon(new ImageIcon("src/ImagenesProy/EnglishTime1.png"));
        Rbiseps.setOpaque(false);
        Rbiseps.setBounds(20, 180, 110, 110);
        Rbiseps.addActionListener(this);

        RPesaTorz = new JRadioButton("");
        RPesaTorz.setIcon(new ImageIcon("src/ImagenesProy/pesasTorzo.png"));
        RPesaTorz.setSelectedIcon(new ImageIcon("src/ImagenesProy/EnglishTime1.png"));
        RPesaTorz.setOpaque(false);
        RPesaTorz.setBounds(20, 330, 110, 110);
        RPesaTorz.addActionListener(this);

        Rpesas = new JRadioButton("");
        Rpesas.setIcon(new ImageIcon("src/ImagenesProy/pesas.png"));
        Rpesas.setSelectedIcon(new ImageIcon("src/ImagenesProy/EnglishTime1.png"));
        Rpesas.setOpaque(false);
        Rpesas.setBounds(20, 480, 110, 110);
        Rpesas.addActionListener(this);

        grupo = new ButtonGroup();
        grupo.add(Rbiseps);
        grupo.add(RPesaTorz);
        grupo.add(Rpesas);
        grupo.add(Rcuerda);

//========================== BOTONES ==============
        JBaRegist = new JButton("Registrar Datos");
        JBaRegist.setBackground(fondo3);
        JBaRegist.setBorderPainted(true);
        JBaRegist.setFont(new Font("Arial", Font.BOLD, 15));
        JBaRegist.setForeground(fondo5);
        JBaRegist.setBounds(60, 620, 180, 30);
        JBaRegist.addActionListener(this);

        JBverVentana = new JButton("Registros");
        JBverVentana.setBackground(fondo3);
        JBverVentana.setBorderPainted(true);
        JBverVentana.setFont(new Font("Arial", Font.BOLD, 15));
        JBverVentana.setForeground(fondo5);
        JBverVentana.setBounds(290, 620, 150, 30);
        JBverVentana.addActionListener(this);

        //======================= radio botones==============
        //JBaRegist = new JButton("");
        // ======================= TXT'S================
        //======================= LBL'S ==========
        LBLHealthapp = new JLabel("Health App");
        LBLHealthapp.setBounds(480, 290, 50, 100);
        LBLHealthapp.setForeground(fondo5);
        LBLHealthapp.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 20));

        LBLEjCuer = new JLabel("Saltar la cuerda");
        LBLEjCuer.setBounds(150, 50, 300, 100);
        LBLEjCuer.setForeground(fondo6);
        LBLEjCuer.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 20));

        LBLbrazo = new JLabel("Reafirmar los brazos");
        LBLbrazo.setBounds(150, 90, 300, 300);
        LBLbrazo.setForeground(fondo6);
        LBLbrazo.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 20));

        LBLtorzo = new JLabel("Ejercitar el pecho");
        LBLtorzo.setBounds(150, 380, 350, 30);
        LBLtorzo.setForeground(fondo6);
        LBLtorzo.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 20));

        LBLpezas = new JLabel("Ejercicios con pesas");
        LBLpezas.setBounds(150, 520, 350, 30);
        LBLpezas.setForeground(fondo6);
        LBLpezas.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 20));

        LBLfondo = new JLabel(fondo);
        LBLfondo.setBounds(0, 0, 150, 30);
        LBLfondo.setFont(new Font("Arial Unicode MS", Font.PLAIN, 15));

        LBLcuadro = new JLabel(cuadro);
        LBLcuadro.setBounds(-50, -60, 700, 700);

        LBLcuadro.setFont(new Font("Arial Unicode MS", Font.PLAIN, 15));

        PanelDatos = new JPanel(null);
        PanelDatos.setOpaque(false);
        PanelDatos.add(LBLEjCuer);
        PanelDatos.add(LBLbrazo);
        PanelDatos.add(LBLtorzo);
        PanelDatos.add(LBLpezas);

        PanelDatos.add(LBLcuadro);
        PanelDatos.setBounds(690, 30, 500, 450);
        PanelDatos.setPreferredSize(new Dimension(1200, 100));

        PanelBoto = new JPanel(null);
        PanelBoto.add(Rbiseps);
        PanelBoto.add(Rcuerda);
        PanelBoto.add(RPesaTorz);
        PanelBoto.add(Rpesas);
        PanelBoto.add(JBaRegist);
        PanelBoto.add(JBverVentana);
        PanelBoto.add(LBLEjCuer);
        PanelBoto.add(LBLbrazo);
        PanelBoto.add(LBLpezas);
        PanelBoto.add(LBLtorzo);
        PanelBoto.add(LBLcuadro);
        PanelBoto.setBackground(fondo6);
        PanelBoto.setBounds(0, 0, 500, 700);
        PanelBoto.setPreferredSize(new Dimension(500, 200));

        PanelTodo = new JPanel(null);

        PanelTodo.add(PanelBoto);
        PanelTodo.setBounds(690, 30, 500, 700);


        FramePrinci = new JFrame();
        FramePrinci.pack();
        FramePrinci.add(jbRegLog);
        
        FramePrinci.add(JBmenu);
        FramePrinci.add(PanelTodo);
        FramePrinci.add(LBLfondo);
        FramePrinci.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FramePrinci.setSize(1400, 730);
        FramePrinci.setVisible(true);

    }

  


    @Override
    public void actionPerformed(ActionEvent e) {
        String tipo = "";
        if (Rbiseps.isSelected()) {
            tipo = "Biceps";
        } else if (RPesaTorz.isSelected()) {
            tipo = "Pesas Torzo";
        } else if (Rpesas.isSelected()) {
            tipo = "Pesas";
        } else if (Rcuerda.isSelected()) {
            tipo = "Cuerda";
        }
        if (e.getSource() == JBverVentana) {
          
            VentanaEjerci ObVentan = new VentanaEjerci(tipo,paciente);
        }
        if (e.getSource() == JBaRegist) {
            
            VentanaEjerci ObVentana = new VentanaEjerci(tipo,paciente);
        FramePrinci.setVisible(false);
        }
        if (e.getSource() == jbRegLog) {
           
            Login obLog = new Login();
            FramePrinci.setVisible(false);
        }
         if (e.getSource()== JBmenu){
            
          Menu obMen = new Menu(paciente);
          FramePrinci.setVisible(false);
        }
    }

}
