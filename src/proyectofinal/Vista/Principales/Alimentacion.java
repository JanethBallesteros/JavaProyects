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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import proyectofinal.Controlador.MetodosAgregacion;
import static proyectofinal.Controlador.Validaciones.isNumerico;
import proyectofinal.Modelo.HoraSistema;
import proyectofinal.Modelo.Paciente;
import proyectofinal.Vista.MuestreoDatos.VentanaCarboh;

/**
 *
 * @author KarimePamela
 */

// sacar el menu barr y asignarlo a el solo
public class Alimentacion extends JFrame implements ActionListener {

    private ImageIcon FondoFrame, IconTIPS, DatosComid;
    private JFrame FramePrinci;
    private Container contenedor;
    private JButton JBaRegist, JBveneficios;
    private JRadioButton Agregar;
    private JPanel PanelSup, PanelMedio, SubPane1, SubPanel2;
    private TextField TXTlitAg, TXTCarb, TXT;
    private JLabel LBLitrosA, LBLCarb, LBLTitulo, LBLtipsCOMI, LBLFondo,
            LBLtips;
    private JMenuBar BarraMenu, menusito;
    private JMenu InfoCarbohidraConsumidos, prueba; 
    private JMenuItem Consumo, DatosCarbConsumid;
    Paciente paciente;
     private JButton JBmenu;
    private JButton jbRegLog;
    HoraSistema hora= new HoraSistema();
    
    public Alimentacion(Paciente p) {
        super("ConsumoAgua");
     
        Color fondo1 = new Color(131, 68, 0);
        Color fondo2 = new Color(250, 215, 160);
        Color letras = new Color(31, 97, 141);
        Color fondo3 = new Color(102,187,106);
         paciente=p;
         
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

        
       JBmenu= new JButton("MENU");
       JBmenu.setBounds(900, 587,100,30);
       JBmenu.addActionListener(this);
       JBmenu.setBackground(fondo3);
       JBmenu.setForeground(fondo2);
       JBmenu.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        
        
        //============ ITEMS DE MENU ===========
        BarraMenu = new JMenuBar();
        menusito = new JMenuBar();
        prueba = new JMenu("prueba");
        InfoCarbohidraConsumidos = new JMenu("Informacion Carbohidratos ");
        
        Consumo = new JMenuItem("Consumo");
        Consumo.addActionListener(this);
        
        jbRegLog = new JButton("SALIR");
        jbRegLog.setBounds(1100, 587, 100, 30);
        jbRegLog.addActionListener(this);
        jbRegLog.setBackground(letras);
        jbRegLog.setForeground(fondo1);
        jbRegLog.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        
        DatosCarbConsumid = new JMenuItem("Que comiste hoy?");
        DatosCarbConsumid.addActionListener(this);
        
        InfoCarbohidraConsumidos.add(Consumo);
        InfoCarbohidraConsumidos.add(DatosCarbConsumid);
        InfoCarbohidraConsumidos.setBounds(0, 0, 500,20);
    
        BarraMenu.add(InfoCarbohidraConsumidos);
        //BarraMenu.setBounds(0, 0, 500,20);
        setJMenuBar(BarraMenu);

        //=========================== Imagenes===============
        FondoFrame = new ImageIcon("src/ImagenesProy/FrutasF.png");
        IconTIPS =new ImageIcon("src/ImagenesProy/tipsPequ.png");
        DatosComid = new ImageIcon("src/ImagenesProy/Tips2.png");
        
        JBaRegist = new JButton("Registrar Datos");
        JBaRegist.setOpaque(false);
        JBaRegist.setBounds(800, 450, 200,30);
        JBaRegist.addActionListener(this);
        
        JBveneficios = new JButton("Ver Registros");
        JBveneficios.setBounds(1100, 450, 200,30);
        JBveneficios.setOpaque(false);
        JBveneficios.addActionListener(this);
        Agregar = new JRadioButton("");

        TXTlitAg = new TextField();
        TXTlitAg.setBounds(1050, 200, 200,20);
        TXTCarb = new TextField();
        TXTCarb.setBounds(1050, 300, 200,20);
        LBLitrosA = new JLabel("Litros de agua consumida");
        LBLitrosA.setBounds(850, 200, 200,20);
        LBLCarb = new JLabel("Carbohidratos consumidos");
        LBLCarb.setBounds(850, 300, 200,20);
        LBLTitulo = new JLabel();
        LBLtipsCOMI = new JLabel(DatosComid);
        LBLtipsCOMI.setBounds(-60, 40, 780, 500);
        
        LBLFondo = new JLabel(FondoFrame);
        LBLFondo.setBounds(0, 0, 1200, 734);
        LBLtips = new JLabel(IconTIPS);
        LBLtips.setBounds(470,20, 167,174 );
        
       // ====================== PANELES ==============
        PanelSup = new JPanel();
        PanelSup.add(BarraMenu);
        PanelSup.add(LBLTitulo);
        
        PanelSup.setPreferredSize(new Dimension(1200,100));
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
        PanelMedio.setBounds(35, 120,650,550);
        PanelMedio.setBorder(BorderFactory.createTitledBorder("TIPS'"));
 
  
        FramePrinci = new JFrame();
        FramePrinci.pack();
        FramePrinci.add(BarraMenu);
        //FramePrinci.add(PanelSup, BorderLayout.NORTH);
        FramePrinci.add(PanelMedio, BorderLayout.CENTER);
        FramePrinci.add(LBLitrosA);
        FramePrinci.add(LBLCarb);
        FramePrinci.add(TXTlitAg);
        FramePrinci.add(TXTCarb);
        FramePrinci.add(JBaRegist);
        FramePrinci.add(JBveneficios);
        FramePrinci.add(jbRegLog);
        FramePrinci.add(JBmenu);
        FramePrinci.add(LBLFondo);
        
        FramePrinci.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FramePrinci.setSize(1400, 730);
        FramePrinci.setVisible(true);

    }
    
    public void Limpiar(){
        TXTlitAg.setText("");
        TXTCarb.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if (e.getSource()== JBveneficios){
                
                VentanaCarboh ObVentana = new VentanaCarboh(paciente);
            }
            if (e.getSource() == jbRegLog) {
                
            Login obLog = new Login();
            FramePrinci.setVisible(false);
             }
            if (e.getSource()== JBmenu){
                
                Menu obMen = new Menu(paciente);
                FramePrinci.setVisible(false);
            }
            if(e.getSource()==JBaRegist){
                if(isNumerico(TXTlitAg.getText()) && isNumerico(TXTCarb.getText())){
                double agua= Double.parseDouble(TXTlitAg.getText());
                double carb= Double.parseDouble(TXTCarb.getText());
                    proyectofinal.Modelo.Alimentacion ali= new  proyectofinal.Modelo.Alimentacion(paciente.getId(),hora.TiempoActual(),carb,agua);
                    MetodosAgregacion ma= new MetodosAgregacion();
                    ma.AgregarDBAlimentacion(ali);
                    Limpiar();
                }else{
                 Limpiar();
                }
            }
             if (e.getSource() == jbRegLog) {
            Login obLog = new Login();
            FramePrinci.setVisible(false);
        }
        if (e.getSource() == JBmenu) {
            Menu obMen = new Menu(paciente);
            FramePrinci.setVisible(false);

        }
    }

    

}
