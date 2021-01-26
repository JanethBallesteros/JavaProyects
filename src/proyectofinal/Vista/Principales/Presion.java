/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.Vista.Principales;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import proyectofinal.Controlador.MetodosAgregacion;
import static proyectofinal.Controlador.Validaciones.isNumerico;
import proyectofinal.Modelo.HoraSistema;
import proyectofinal.Modelo.Paciente;
import proyectofinal.Vista.MuestreoDatos.VentanaPresion;

/**
 *
 * @author KarimePamela
 */
public class Presion extends JFrame implements  ActionListener {
    
    Ejercicio objeto;
         
      private ImageIcon Usuario, fondo, cuadro, llave;
    private JFrame FramePrinci;
    private Container contenedor;
    private JButton JBaRegist, JBverVentana;
     private JRadioButton Rcuerda, Rbiseps, Rpesas,RPesaTorz;
     private JButton jbRegLog, JBmenu;
     private JPanel PanelTodo, PanelDatos, PanelBoto;   
    private TextField  TXTfecha, TXTpresionSist, TXTpresionDiast;
    private JLabel  LBLFecha, LBLPresionSis,LBLPresionDiasto, LBLcuadro, LBLfondo, LBLTitulo1,LBLTitulo2;
    private ButtonGroup grupo;
    
    HoraSistema hora= new HoraSistema();
    Paciente paciente;
    MetodosAgregacion ma= new MetodosAgregacion();
    proyectofinal.Modelo.Presion presion;
    
    public Presion(Paciente p){
        super("PRESION");
      paciente=p;
         Color letras = new Color(31, 97, 141);
        
        Color fondo1 = new Color(250,250,250);
        Color fondo2 = new Color(34,153,84);
        Color fondo3 = new Color(102,187,106);
        Color fondo4 = new Color(247,220,111);
        Color fondo5 = new Color(46,125,50);
        Color fondo6 = new Color(26,82,118);
      //   Color fondo6 = new Color(121,85,72);
         
        Usuario = new ImageIcon("src/ImagenesProy/user.png");
        llave = new ImageIcon("src/ImagenesProy/access.png");
        fondo = new ImageIcon("src/ImagenesProy/Presion Arterial.png");
        cuadro = new ImageIcon("src/ImagenesProy/presionVer.png");
     

//========================== BOTONES ==============
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
        
       JBaRegist= new JButton("Registrar Datos");
       JBaRegist.setBackground(fondo3);
       JBaRegist.setBorderPainted(true);
       JBaRegist.setFont(new Font("Arial", Font.PLAIN, 15));
       JBaRegist.setForeground(fondo1);
       JBaRegist.setBounds(50, 480, 180, 30);
       JBaRegist.addActionListener(this);

       JBverVentana = new JButton("Registros");
       JBverVentana.setBackground(fondo3);
       JBverVentana.setBorderPainted(true);
       JBverVentana.setFont(new Font("Arial", Font.PLAIN, 15));
       JBverVentana.setForeground(fondo1);
       JBverVentana.setBounds(280, 480, 100, 30);
       JBverVentana.addActionListener(this);

       // ======================= TXT'S================

       TXTfecha= new TextField(hora.TiempoActual());
       TXTfecha.setBounds(250, 280,150,25);
       TXTfecha.setBackground(fondo4);
       TXTfecha.setForeground(fondo5);
       TXTfecha.setFont(new Font("Bodoni MT Poster Compressed", Font.PLAIN, 15));
          

       TXTpresionSist= new TextField();
       TXTpresionSist.setBounds(250, 320, 130,25);
       TXTpresionSist.setBackground(fondo4);
       TXTpresionSist.setForeground(fondo5);
       TXTpresionSist.setFont(new Font("Bodoni MT Poster Compressed", Font.PLAIN, 15));

       
       TXTpresionDiast = new TextField();
       TXTpresionDiast.setBounds(250, 360, 130,25);
       TXTpresionDiast.setBackground(fondo4);
       TXTpresionDiast.setForeground(fondo5);
       TXTpresionDiast.setFont(new Font("Bodoni MT Poster Compressed", Font.PLAIN, 15));
       
      // ========================== LABEL'S ==============
 
       LBLTitulo1 = new JLabel("PRESION");
       LBLTitulo1.setBounds(60,100, 150,30);
       LBLTitulo1.setForeground(fondo2);
       LBLTitulo1.setFont(new Font("Arial Unicode MS", Font.BOLD, 25));
       
       LBLTitulo2    = new JLabel("MANTEN EL CONTROL DE TU PRESION");
       LBLTitulo2.setBounds(60,125, 300,30);
       LBLTitulo2.setForeground(fondo2);
       LBLTitulo2.setFont(new Font("Arial Unicode MS", Font.PLAIN, 15));
       
       LBLFecha= new JLabel("Fecha");
       LBLFecha.setBounds(60,280, 150,30);
       LBLFecha.setForeground(fondo6);
       LBLFecha.setFont(new Font("Arial Unicode MS", Font.BOLD, 15));
       
       LBLPresionSis= new JLabel("Presion Sistolica");
       LBLPresionSis.setBounds(60,320, 150,30);
       LBLPresionSis.setForeground(fondo6);
       LBLPresionSis.setFont(new Font("Arial Unicode MS", Font.BOLD, 15));
       
       LBLPresionDiasto= new JLabel("Presion Diastolica");
       LBLPresionDiasto.setBounds(60,360, 150,30);
       LBLPresionDiasto.setForeground(fondo6);
       LBLPresionDiasto.setFont(new Font("Arial Unicode MS", Font.BOLD, 15));

       
       LBLfondo= new JLabel(fondo);
       LBLfondo.setBounds(-50,-20, 150,30);
       LBLfondo.setFont(new Font("Arial Unicode MS", Font.BOLD, 15));
      
       LBLcuadro= new JLabel(cuadro);
       LBLcuadro.setBounds(-100,-50, 700,700);
      
       LBLcuadro.setFont(new Font("Arial Unicode MS", Font.PLAIN, 15));
      
       PanelDatos = new JPanel(null);
       PanelDatos.setOpaque(false);
       
       PanelDatos.setBounds(100,30, 500,650);
       PanelDatos.setPreferredSize(new Dimension(1200,100));

       PanelTodo = new JPanel(null);
       PanelTodo.setBounds(50,30, 500,650);
       PanelTodo.add(TXTfecha);
       PanelTodo.add(TXTpresionSist);
       PanelTodo.add(TXTpresionDiast);
       PanelTodo.add(LBLFecha);
       PanelTodo.add(LBLPresionSis);
       PanelTodo.add(LBLPresionDiasto);

       
       PanelTodo.add(JBaRegist);
       PanelTodo.add(JBverVentana);
       PanelTodo.add(LBLTitulo1);
       PanelTodo.add(LBLTitulo2);
       PanelTodo.add(LBLcuadro);

       
       FramePrinci = new JFrame();
       FramePrinci.pack();
       FramePrinci.add(jbRegLog);
       FramePrinci.add(JBmenu);
       FramePrinci.add(PanelTodo);
       
       FramePrinci.add(LBLfondo);
      
       FramePrinci.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       FramePrinci.setSize(1400,730);
       FramePrinci.setVisible(true);

    }  

    public void Limpiar(){
    TXTpresionDiast.setText("");
    TXTpresionSist.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == JBverVentana){
            VentanaPresion ObVentana = new VentanaPresion(paciente);
             //ObjEjerc.dispose();
            
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
                  if(isNumerico(TXTpresionSist.getText()) && isNumerico(TXTpresionDiast.getText() )){
            int ps= Integer.parseInt(TXTpresionSist.getText());
            int pd= Integer.parseInt(TXTpresionDiast.getText());
            proyectofinal.Modelo.Presion pre= new proyectofinal.Modelo.Presion(paciente.getId(),hora.TiempoActual(),ps,pd);
            pre.setIdUsuario(paciente.getId());
            ma.AgregarDBPresion(pre);
                  }
            Limpiar();  
        }
    }
    
}
