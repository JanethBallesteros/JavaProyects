/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.Vista.Principales;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import proyectofinal.Modelo.HoraSistema;
import proyectofinal.Modelo.Paciente;

/**
 *
 * @author KarimePamela
 */
public class TablaGeneral extends JFrame implements ActionListener, MouseListener {

    private ImageIcon FondoFrame, IconTIPS, DatosComid;
    private JFrame FramePrinci;
    private Container contenedor;
    private JButton JBaRegist, JBveneficios;
    private JRadioButton Agregar;
    private JPanel PanelSup, PanelMedio, SubPane1, SubPanel2;
    private TextField TXTlitAg, TXTCarb, TXT;
    private JLabel LBLitrosA, LBLCarb, LBLTitulo, LBLtipsCOMI, LBLFondo,
            LBLtips;
    private JMenuBar BarraMenu;
    private JMenu Menu,configuracion, Registros;
    private JMenuItem MImenu, MIAliment, MIejer, MIgluc, MIconfi, MImedi, MIpres, MIpacien;
    Paciente paciente;
    private JButton JBmenu;
    private JButton jbRegLog;
    HoraSistema hora = new HoraSistema();

    public TablaGeneral() {
        super("ConsumoAgua");
        Color fondo1 = new Color(131, 68, 0);
        Color fondo2 = new Color(250, 215, 160);
        Color letras = new Color(31, 97, 141);
        Color fondo3 = new Color(102, 187, 106);
       //paciente=p;

        Image icono = Toolkit.getDefaultToolkit().getImage("src/ImagenesProy/icono3.png");
        setIconImage(icono);
        
        JBmenu = new JButton("MENU");
        //JBmenu.setBounds(900, 587,100,30);
        JBmenu.addActionListener(this);
        JBmenu.setBackground(fondo3);
        JBmenu.setForeground(fondo2);
        JBmenu.setFont(new Font("Century Gothic", Font.PLAIN, 15));

        //============ ITEMS DE MENU ===========
        BarraMenu = new JMenuBar();
       
        
        Registros= new JMenu("Registros");
        Menu = new JMenu("Menu ");
        configuracion = new JMenu("Configuracion y cambios");
        

        jbRegLog = new JButton("SALIR");
        jbRegLog.setBounds(1100, 587, 100, 30);
        jbRegLog.addActionListener(this);
        jbRegLog.setBackground(letras);
        jbRegLog.setForeground(fondo1);
        jbRegLog.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        
        MIAliment= new JMenuItem("Alimentacion");
        MIAliment.addActionListener(this);

        MIconfi= new JMenuItem("Configuracion");
        MIconfi.addActionListener(this);
        
        MIejer= new JMenuItem("Ejercicios");
        MIejer.addActionListener(this);
        
        
        MIgluc= new JMenuItem("Glucosa");
        MIgluc.addActionListener(this);
        
        MImedi= new JMenuItem("Medicamentos");
        MImedi.addActionListener(this);

        
        MImenu= new JMenuItem("Menu");
        MImenu.addActionListener(this);
        
        
        MIpacien= new JMenuItem("Paciente");
        MIpacien.addActionListener(this);
        
        
        MIpres= new JMenuItem("Presion");
        MIpres.addActionListener(this);
        
        Menu.add(MImenu);
        Registros.add(MIAliment);
        Registros.add(MIejer);
        Registros.add(MIgluc);
        Registros.add(MImedi);
        Registros.add(MIpacien);
        Registros.add(MIpres);
        configuracion.add(MIconfi);

        BarraMenu.add(Menu);
        BarraMenu.add(Registros);
        BarraMenu.add(configuracion);
        BarraMenu.setBounds(0, 0, 1400, 20);
        setJMenuBar(BarraMenu);

        //=========================== Imagenes===============
        FondoFrame = new ImageIcon("src/ImagenesProy/FondoTabla.png");
        IconTIPS = new ImageIcon("src/ImagenesProy/tipsPequ.png");
        DatosComid = new ImageIcon("src/ImagenesProy/Tips2.png");

        JBaRegist = new JButton("Registrar Datos");
        JBaRegist.setOpaque(false);
        JBaRegist.setBounds(800, 450, 200, 30);
        JBaRegist.addActionListener(this);

        JBveneficios = new JButton("Ver Registros");
        JBveneficios.setBounds(1100, 450, 200, 30);
        JBveneficios.setOpaque(false);
        JBveneficios.addActionListener(this);
        //JBaRegist = new JButton("");
        Agregar = new JRadioButton("");

        TXTlitAg = new TextField();
        TXTlitAg.setBounds(1050, 200, 200, 20);
        TXTCarb = new TextField();
        TXTCarb.setBounds(1050, 300, 200, 20);
        LBLitrosA = new JLabel("Litros de agua consumida");
        LBLitrosA.setBounds(850, 200, 200, 20);
        LBLCarb = new JLabel("Carbohidratos consumidos");
        LBLCarb.setBounds(850, 300, 200, 20);
        LBLTitulo = new JLabel();
        LBLtipsCOMI = new JLabel(DatosComid);
        LBLtipsCOMI.setBounds(-60, 40, 780, 500);

        LBLFondo = new JLabel(FondoFrame);
        //LBLFondo.setOpaque(false);
        LBLFondo.setBounds(0, 0, 1200, 734);
        LBLtips = new JLabel(IconTIPS);
        LBLtips.setBounds(470, 20, 167, 174);

        // ====================== PANELES ==============
        PanelSup = new JPanel();
        PanelSup.add(BarraMenu);
        PanelSup.add(LBLTitulo);

        PanelSup.setPreferredSize(new Dimension(1200, 100));
        PanelSup.setBackground(fondo2);

        SubPane1 = new JPanel(null);
        SubPane1.add(LBLtipsCOMI);
        SubPane1.add(LBLtips);
        SubPane1.add(LBLtipsCOMI);
        SubPane1.setBackground(fondo2);
        SubPane1.setPreferredSize(new Dimension(495, 500));

        PanelMedio = new JPanel(null);
        PanelMedio.setLayout(new GridLayout(1, 2));
        PanelMedio.add(SubPane1);
        PanelMedio.setBounds(35, 120, 650, 550);
        PanelMedio.setBorder(BorderFactory.createTitledBorder("TIPS'"));

        FramePrinci = new JFrame();
        FramePrinci.pack();
        FramePrinci.add(BarraMenu);
       // FramePrinci.add(PanelSup, BorderLayout.NORTH);
        //FramePrinci.add(PanelMedio, BorderLayout.CENTER);

       //  FramePrinci.add(JBaRegist);
        // FramePrinci.add(JBveneficios);
        FramePrinci.add(JBmenu);
        FramePrinci.add(LBLFondo);
        //FramePrinci.setUndecorated(true);
        FramePrinci.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FramePrinci.setSize(1400, 730);
        FramePrinci.setVisible(true);

    }

    public static void main(String[] args) {
        TablaGeneral obTabla = new TablaGeneral();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      if  (e.getSource()== MIAliment){
        Alimentacion FmAl = new Alimentacion(paciente);
    }
      if(e.getSource() == MIejer){
       Ejercicio FmEjerc = new Ejercicio(paciente);
      }
      if (e.getSource() == MIgluc){
          Glucosa FmGlu = new Glucosa(paciente);
      }
      if (e.getSource() == MImedi){
          Medicamentos FmMed = new  Medicamentos();
          
      }
      if (e.getSource() == MIpacien){
          Paciente FmPac = new Paciente();
      }
      if (e.getSource() == MIpres){
          Presion FmPres = new Presion(paciente);
      }
      if (e.getSource()== MImenu){
          Menu FmMen = new Menu(paciente);
      }
      if(e.getSource()== MIconfi){
          Configuracion FmConf = new Configuracion(paciente);
      }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

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
