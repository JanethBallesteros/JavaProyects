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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import proyectofinal.Controlador.MetodosAgregacion;
import static proyectofinal.Controlador.Validaciones.isNumerico;
import proyectofinal.Modelo.HoraSistema;
import proyectofinal.Modelo.Paciente;
import proyectofinal.Vista.MuestreoDatos.VentanaGlucos;
/** proyectofinal.Modelo.
 *
 * @author KarimePamela
 */
public class Glucosa extends JFrame implements ActionListener {
    
    Ejercicio objeto;
      private ImageIcon Usuario, fondo, cuadro, llave;
    private JFrame FramePrinci;
    private Container contenedor;
    private JButton JBaRegist, JBverVentana;
    private JButton jbRegLog;
    private JPanel PanelTodo, PanelDatos;
    private JButton JBmenu;
    private TextField TXTnivelGluc;    
    private JLabel  LBLfecha, LBLnivelGluc,LBLcuadro, LBLfondo,LBLTitulo1,LBLTitulo2;
 
    
    HoraSistema hora= new HoraSistema();
    Paciente paciente;
    MetodosAgregacion ma= new MetodosAgregacion();
    proyectofinal.Modelo.Glucosa glucosa;
    
    public Glucosa(Paciente p){
        super("Ejercicio");
        paciente=p;
       Color letras = new Color(31, 97, 141);
        Color fondo1 = new Color(191,201,202);
        Color fondo2 = new Color(34,153,84);
        Color fondo3 = new Color(72,201,176);
        Color fondo4 = new Color(34,153,84);
        Color fondo5 = new Color(248,249,249);
        Color fondo6 = new Color(26,82,118);
        
        Usuario = new ImageIcon("src/ImagenesProy/user.png");
        llave = new ImageIcon("src/ImagenesProy/access.png");
        fondo = new ImageIcon("src/ImagenesProy/Diabetes.png");
        cuadro = new ImageIcon("src/ImagenesProy/fondoGluco.png");
      
//========================== BOTONES ==============
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
        
       
        
       JBaRegist= new JButton("Registrar Datos");
       JBaRegist.setBackground(fondo3);
       JBaRegist.setBorderPainted(true);
       JBaRegist.setFont(new Font("Arial", Font.PLAIN, 15));
       JBaRegist.setForeground(fondo5);
       JBaRegist.setBounds(50, 480, 180, 30);
       JBaRegist.addActionListener(this);
       
       
       JBverVentana = new JButton("Registros");
       JBverVentana.setBackground(fondo3);
       JBverVentana.setBorderPainted(true);
       JBverVentana.setFont(new Font("Arial", Font.PLAIN, 15));
       JBverVentana.setForeground(fondo5);
       JBverVentana.setBounds(280, 480, 100, 30);
       JBverVentana.addActionListener(this);

       // ======================= TXT'S================

       TXTnivelGluc= new TextField();
       TXTnivelGluc.setBounds(250, 320, 150,25);
       TXTnivelGluc.setBackground(fondo4);
       TXTnivelGluc.setForeground(fondo5);
       TXTnivelGluc.setFont(new Font("Bodoni MT Poster Compressed", Font.PLAIN, 15));

      // ========================== LABEL'S ==============
   
       LBLTitulo1 = new JLabel("GLUCOSA");
       LBLTitulo1.setBounds(60,100, 150,30);
       LBLTitulo1.setForeground(fondo2);
       LBLTitulo1.setFont(new Font("Arial Unicode MS", Font.BOLD, 25));
       
       LBLTitulo2    = new JLabel("MANTEN EL CONTROL DE TU GLUCOSA");
       LBLTitulo2.setBounds(60,125, 300,30);
       LBLTitulo2.setForeground(fondo2);
       LBLTitulo2.setFont(new Font("Arial Unicode MS", Font.PLAIN, 15));
       
       
       LBLfecha= new JLabel("Fecha:" + hora.TiempoActual());
       LBLfecha.setBounds(60,280, 500,30);
       LBLfecha.setForeground(fondo6);
       LBLfecha.setFont(new Font("Arial Unicode MS", Font.PLAIN, 15));
       
       LBLnivelGluc= new JLabel("Nivel de Glucosa");
       LBLnivelGluc.setBounds(60,320, 150,30);
       LBLnivelGluc.setForeground(fondo6);
       LBLnivelGluc.setFont(new Font("Arial Unicode MS", Font.PLAIN, 15));
       
    
       
       LBLfondo= new JLabel(fondo);
       LBLfondo.setBounds(-50,-20, 150,30);
       LBLfondo.setFont(new Font("Arial Unicode MS", Font.PLAIN, 15));
      
       LBLcuadro= new JLabel(cuadro);
       LBLcuadro.setBounds(-50,0, 700,700);
      
       LBLcuadro.setFont(new Font("Arial Unicode MS", Font.PLAIN, 15));
      
       PanelDatos = new JPanel(null);
       PanelDatos.setOpaque(false);
       
       PanelDatos.setBounds(100,30, 500,650);
       PanelDatos.setPreferredSize(new Dimension(1200,100));
       
       PanelTodo = new JPanel(null);
       PanelTodo.setBounds(800,30, 500,650);
       PanelTodo.add(TXTnivelGluc);
       PanelTodo.add(LBLfecha);
       PanelTodo.add(LBLnivelGluc);

       PanelTodo.add(JBaRegist);
       PanelTodo.add(JBverVentana);
       PanelTodo.add(LBLTitulo1);
       PanelTodo.add(LBLTitulo2);
       PanelTodo.add(LBLcuadro);
       
       FramePrinci = new JFrame();
       FramePrinci.pack();
       FramePrinci.add(JBmenu);
       FramePrinci.add(jbRegLog);
       FramePrinci.add(PanelTodo);
       FramePrinci.add(LBLfondo);
       FramePrinci.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       FramePrinci.setSize(1400,730);
       FramePrinci.setVisible(true);
  
    }  

    public void Limpiar(){
    TXTnivelGluc.setText("");
    }
   

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==JBaRegist){
            if(isNumerico(TXTnivelGluc.getText()) ){
           double nivel= Double.parseDouble(TXTnivelGluc.getText());
            proyectofinal.Modelo.Glucosa glu= new proyectofinal.Modelo.Glucosa(paciente.getId(),hora.TiempoActual(),nivel);
            ma.AgregarDBGlucosa(glu);
            
            }
            Limpiar();
       }
        if (e.getSource() == JBverVentana){
           // VentanaGlucos ObVentana = new VentanaGlucos(paciente);
            
            VentanaGlucos ObVentana = new VentanaGlucos(paciente); //ObjEjerc.dispose();  
        
        }
         if (e.getSource() == jbRegLog) {
              
            Login obLog = new Login();
            FramePrinci.setVisible(false);
        }
          if (e.getSource()== JBmenu){
               
          Menu obMen = new Menu(paciente);
          FramePrinci.setVisible(false);
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
