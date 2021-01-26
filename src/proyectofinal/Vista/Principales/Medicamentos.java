/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.Vista.Principales;

import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.*;
import java.awt.event.*;
import proyectofinal.Controlador.MetodosAgregacion;
import static proyectofinal.Controlador.Validaciones.isNumerico;
import proyectofinal.Modelo.HoraSistema;
import proyectofinal.Modelo.Paciente;

/**
 *
 * @author KarimePamela
 */
public class Medicamentos extends JFrame implements ActionListener, MouseListener {

        private ImageIcon ImaBotPizza, Mosaico, Logo;
    private JFrame FramePrinci;
    private Container contenedor;
    private JButton JBaRegist, JBveneficios;
    private JRadioButton Agregar, RverReg, RinfoMed, Rrecord;
    private JPanel PanelSup, PanelMedio,PanelMedioDos, SubPane1, subPanel2, subPanel3;
    private TextField TXTipoMed,TXTdescr, TXTHoraTAg, TXTcantidad;
    private JLabel LBLtipo, LBLHoraT, LBLDesc, LBLcantidad, LBLagre,
            LBLverR, LBLinfoMed, LBLrecordat, LBLmosaico,LBLogo;
    private ButtonGroup grupo;
      private JButton jbRegLog;
       private JButton JBmenu;
    HoraSistema hora= new HoraSistema();
    Paciente paciente;
    MetodosAgregacion ma= new MetodosAgregacion();
    proyectofinal.Modelo.Medicamentos med;
    
    
    public Medicamentos(){
        super("Medicamentos");
        Color letras = new Color(31, 97, 141);
        Color fondo1 = new Color(191,201,202);
        Color fondo2 = new Color(212,230,241);
        Color fondo3 = new Color(127,179,213);
        Color fondo4 = new Color(36,113,163);
        Color fondo5 = new Color(248,249,249);
        Color fondo6 = new Color(26,82,118);
        ImaBotPizza = new ImageIcon("src/Pizza/error-sadPizza.png");
        Mosaico = new ImageIcon("src/ImagenesProy/Blue.jpg");
        Logo = new ImageIcon("src/ImagenesProy/healthLog.png");
         
        ImageIcon menu = new ImageIcon("src/ImagenesProy/menuPrin.png");
        JBmenu = new JButton("MENU");
        JBmenu.setIcon(menu);
        JBmenu.setBounds(100, 600, 190, 80);
        JBmenu.addActionListener(this);
        JBmenu.setBackground(fondo3);
        JBmenu.setForeground(fondo2);
        JBmenu.setOpaque(false);
        JBmenu.setBorderPainted(false);
        JBmenu.setFont(new Font("Century Gothic", Font.BOLD, 15));

        ImageIcon salir = new ImageIcon("src/ImagenesProy/salir1.png");
        jbRegLog = new JButton("SALIR");
        jbRegLog.setBounds(250, 600, 190,80);
        jbRegLog.addActionListener(this);
        jbRegLog.setBackground(letras);
        jbRegLog.setIcon(salir);
        jbRegLog.setOpaque(false);
        jbRegLog.setBorderPainted(false);
        jbRegLog.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        
       JBveneficios= new JButton("Veneficios AGUA");
       
       
       //======================= radio botones==============
       
       //JBaRegist = new JButton("");
       Agregar = new JRadioButton("");
       Agregar.setIcon(new ImageIcon("src/ImagenesProy/6-512.png"));
       Agregar.setSelectedIcon(new ImageIcon("src/ImagenesProy/EnglishTime1.png"));
       Agregar.setOpaque(false);
       Agregar.setBounds(90, 50, 200,200);
       Agregar.setPreferredSize(new Dimension(100,100));
       Agregar.addMouseListener(this);
    
       
       RverReg = new JRadioButton("");
       RverReg.setIcon(new ImageIcon("src/ImagenesProy/Registro.png"));
       RverReg.setSelectedIcon(new ImageIcon("src/ImagenesProy/EnglishTime1.png"));
       RverReg.setOpaque(false);
       RverReg.setBounds(350, 50, 200,200);
       RverReg.setPreferredSize(new Dimension(100,100));
       RverReg.addMouseListener(this);
       
       
       RinfoMed = new JRadioButton("");
       RinfoMed.setIcon(new ImageIcon("src/ImagenesProy/pastilla.png"));
       RinfoMed.setSelectedIcon(new ImageIcon("src/ImagenesProy/EnglishTime1.png"));
       RinfoMed.setOpaque(false);
       RinfoMed.setBounds(90, 300, 200,200);
       RinfoMed.setPreferredSize(new Dimension(100,100));
       RinfoMed.addMouseListener(this);
       
       Rrecord = new JRadioButton("");
       Rrecord.setIcon(new ImageIcon("src/ImagenesProy/Hora.png"));
       Rrecord.setSelectedIcon(new ImageIcon("src/ImagenesProy/EnglishTime1.png"));
       Rrecord.setOpaque(false);
       Rrecord.setBounds(350, 300, 200,200);
       Rrecord.setPreferredSize(new Dimension(100,100));
       Rrecord.addMouseListener(this);
       grupo = new ButtonGroup();
        grupo.add(Agregar);
        grupo.add(RverReg);
        grupo.add(RinfoMed);
        grupo.add(Rrecord);
       // ======================= TXT'S/===============
       TXTipoMed = new TextField();
       TXTipoMed.setBounds(180, 150,130, 25);
       TXTipoMed.setBackground(fondo4);
       TXTipoMed.setForeground(fondo5);
       TXTipoMed.setFont(new Font("Bodoni MT Poster Compressed", Font.PLAIN, 15));
       
       TXTHoraTAg= new TextField();
       TXTHoraTAg.setBounds(180, 240, 130,25);
       TXTHoraTAg.setBackground(fondo4);
       TXTHoraTAg.setForeground(fondo5);
       TXTHoraTAg.setFont(new Font("Bodoni MT Poster Compressed", Font.PLAIN, 15));
       
       TXTcantidad = new TextField();
       TXTcantidad.setBounds(180, 330,130, 25);
       TXTcantidad.setBackground(fondo4);
       TXTcantidad.setForeground(fondo5);
       TXTcantidad.setFont(new Font("Bodoni MT Poster Compressed", Font.PLAIN, 15));
       // ============================== LBL'S ========================
       
     
       LBLogo = new JLabel(Logo);
       LBLogo.setBounds(60,-80, 500,300);
       LBLogo.setForeground(fondo5);
       LBLogo.setFont(new Font("Arial Unicode MS", Font.PLAIN, 15));
       
       LBLagre = new JLabel("Agregar Registro");
       LBLagre.setBounds(110,250, 150,30);
       LBLagre.setForeground(fondo5);
       LBLagre.setFont(new Font("Arial Unicode MS", Font.PLAIN, 15));
       
       LBLverR = new JLabel("Ver Registro");
       LBLverR.setBounds(370,250, 150,30);
       LBLverR.setForeground(fondo5);
       LBLverR.setFont(new Font("Arial Unicode MS", Font.PLAIN, 15));
       
       LBLrecordat = new JLabel("Recordatorio");
       LBLrecordat.setBounds(370,480, 150,30);
       LBLrecordat.setForeground(fondo5);
       LBLrecordat.setFont(new Font("Arial Unicode MS", Font.PLAIN, 15));
       
       LBLinfoMed = new JLabel("Informacion Medica");
       LBLinfoMed.setBounds(110,480, 150,30);
       LBLinfoMed.setForeground(fondo5);
       LBLinfoMed.setFont(new Font("Arial Unicode MS", Font.PLAIN, 15));
       

       
       
       LBLtipo = new JLabel("Medicamento");
       LBLtipo.setBounds(20,150, 150,30);
       LBLtipo.setForeground(fondo5);
       LBLtipo.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
       
       LBLHoraT= new JLabel("Fecha ");
       LBLHoraT.setBounds(20,240, 150,30);
       LBLHoraT.setForeground(fondo5);
       LBLHoraT.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
       
       LBLcantidad= new JLabel("Dosis");
       LBLcantidad.setBounds(20,330, 150,30);
       LBLcantidad.setForeground(fondo5);
       LBLcantidad.setFont(new Font("Arial Unicode MS", Font.PLAIN, 16));
       
       LBLDesc = new JLabel("Descripcion");
       LBLDesc.setBounds(10,120, 150,30);
       LBLDesc.setForeground(fondo5);
       LBLDesc.setFont(new Font("Arial Unicode MS", Font.PLAIN, 15));
         
       LBLmosaico = new JLabel(Mosaico);
       LBLmosaico.setBounds(0,0, 600,700);
       LBLmosaico.setForeground(fondo5);
       LBLmosaico.setFont(new Font("Arial Unicode MS", Font.PLAIN, 15));
       // ====================== PANELES ==============
       
       PanelSup = new JPanel(null);
       PanelSup.add(LBLogo);
       PanelSup.setBackground(fondo1);
       PanelSup.setPreferredSize(new Dimension(1200,140));
       
       
       SubPane1 = new JPanel(null);
      // SubPane1.add(LBLtipsA);
       //SubPane1.setBounds(200, 200, 500,780);
       
        subPanel2 = new JPanel(null);
        subPanel2.setBorder(BorderFactory.createTitledBorder(""));
        subPanel2.setPreferredSize(new Dimension(250,200));
        subPanel2.setBounds(35, 20,250,200);
        subPanel2.add(LBLHoraT);
        subPanel2.add(LBLcantidad);
        subPanel2.add(LBLtipo);
        
        subPanel2.add(TXTHoraTAg);
        subPanel2.add(TXTcantidad); 
        subPanel2.add(TXTipoMed);
        subPanel2.add(LBLmosaico);
        subPanel2.setBackground(fondo3);
        
        subPanel3 = new JPanel(null);
        
        subPanel3.setBorder(BorderFactory.createTitledBorder(""));
        subPanel3.add(Agregar);
        subPanel3.add(RverReg);
        subPanel3.add(RinfoMed);
        subPanel3.add(Rrecord);
        subPanel3.add(LBLagre);
        subPanel3.add(LBLinfoMed);
        subPanel3.add(LBLrecordat);
        subPanel3.add(LBLverR);
        subPanel3.setBounds(35, 20,500,500);
        subPanel3.setBackground(fondo6);
         
       
        
       PanelMedio = new JPanel();
       PanelMedio.setLayout(new GridLayout(1,2, 60,10));
       PanelMedio.setBackground(fondo2);
       PanelMedio.add(subPanel2);
       PanelMedio.add(subPanel3);
       PanelMedio.setBounds(35,20,650,250);
       PanelMedio.setBorder(BorderFactory.createTitledBorder("TIPS'"));
       //PanelMedio.setLayout(new GridLayout(2,1));
      // PanelMedio.add(SubPane1);
       
       FramePrinci = new JFrame();
       FramePrinci.pack();
       FramePrinci.add(PanelSup, BorderLayout.NORTH);
       FramePrinci.add(PanelMedio, BorderLayout.CENTER);
       
       FramePrinci.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       FramePrinci.setSize(1400,730);
       FramePrinci.setVisible(true);
        
       
       
    }
    public static void main(String[] args) {
        Medicamentos obMed = new Medicamentos();
                
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      /*
        
      if (e.getSource() == JBverVentana){
            VentanaEjerci ObVentana = new VentanaEjerci();
             //ObjEjerc.dispose();
            
        }
        if (e.getSource() ==JBaRegist){
            obj.PanelDatos();
        }
              */
      if (e.getSource() == jbRegLog) {
            Login obLog = new Login();
            FramePrinci.hide();
        }
        if (e.getSource() == JBmenu) {
            Menu obMen = new Menu(paciente);
            FramePrinci.hide();

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
      if(Agregar.isSelected()){
          if(isNumerico(TXTcantidad.getText()) ){
      proyectofinal.Modelo.Medicamentos med= new proyectofinal.Modelo.Medicamentos(paciente.getId(), TXTcantidad.getText(), TXTipoMed.getText(), hora.TiempoActual());
      ma.AgregarMedicamento(med);
          }
      }
    }

    @Override
    public void mousePressed(MouseEvent e) {
      
    }

    @Override
    public void mouseReleased(MouseEvent e) {
      
    }

    @Override
    public void mouseEntered(MouseEvent e) {
      
    }

    @Override
    public void mouseExited(MouseEvent e) {
      
    }
    
}
