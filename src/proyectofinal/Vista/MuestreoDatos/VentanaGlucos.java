/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.Vista.MuestreoDatos;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import proyectofinal.Controlador.MetodosEliminacion;
import proyectofinal.Controlador.MetodosSeleccion;
import proyectofinal.Modelo.Paciente;
import proyectofinal.Vista.Principales.Grafica;
import proyectofinal.Vista.Principales.Login;
import proyectofinal.Vista.Principales.Menu;

/**
 *
 * @author KarimePamela
 */
public class VentanaGlucos extends JFrame implements ActionListener, MouseListener {

    
    private JButton JBmenu,jbRegLog;
    private Container contenedor;
    private JTabbedPane JTPane;
    private JPanel  panelGramP,panelWordT, PanSalir;
    private Icon Imagen1, icono2,icono3;
    private JLabel LBLimagPortada, LBLpanel1, LBLfondo2, LBLfondo3;
    public int erro, ran;
    private JButton Regresar,JBregistrar, salir, JBGuardarDat, EliminarDato;
    private JLabel lb1,lb2,lb3,lb4;
    
     private JButton btnEliminar;
    private Paciente paciente;
    ImageIcon portada = new ImageIcon("src/ImagenesProy/DatosEjerFo.png");
    ImageIcon marco = new ImageIcon("src/ImagenesProy/fondoTrans.png");
    ImageIcon marco1 = new ImageIcon("src/ImagenesProy/blood2.png");
    ImageIcon Final = new ImageIcon("src/ImagenesProy/heart.png");
     ImageIcon icono1 = new ImageIcon("src/ImagenesProy/icono1.png");
    //======para la tabla interna=======//
    private DefaultTableModel dtm;
    private JTable table;
    private JScrollPane scrollPane;
     
    ///=======PARA LOS DIAGRAMAS===================//
     ImageIcon ifondoGrafica,iBien,iNormal,iMalo;
     JLabel lbfondo,lbbien,lbnormal,lbmalo;
     JButton BntVer;
    
    
    public VentanaGlucos(Paciente p) {
        super("Glucosa");
        Color fondo3 = new Color(237, 187, 153);
        Color fondo2 = new Color(247, 220, 111);
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
Color letras = new Color(31, 97, 141);

        ImageIcon salir = new ImageIcon("src/ImagenesProy/salir1.png");
        jbRegLog = new JButton("SALIR");
        jbRegLog.setBounds(1100, 600, 190,80);
        jbRegLog.addActionListener(this);
        jbRegLog.setBackground(letras);
        jbRegLog.setIcon(salir);
        jbRegLog.setOpaque(false);
        jbRegLog.setBorderPainted(false);
        jbRegLog.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        
         paciente=p;
        CrearTabla();
        icono2 = new ImageIcon("src/ImagenesProy/icono2.png");
        icono3 = new ImageIcon("src/ImagenesProy/icono3.png");
        
        Image icono = Toolkit.getDefaultToolkit().getImage("src/jtabbedpane/FLORecita.png");
        setIconImage(icono);

        Color fondo1 = new Color(250, 215,160);
      
        Color fondo4 = new Color(33, 47, 60);
        Color LetraTXT = new Color(253,254,254);

        // ============================= LABELS ==========================  
        
        lb1=new JLabel("label");
        lb1.setFont(new Font("Century Gothic", Font.BOLD, 15));
        lb1.setBounds(100, 100, 200, 30);
        lb2=new JLabel("label");
        lb2.setFont(new Font("Century Gothic", Font.BOLD, 15));
         lb2.setBounds(400, 100, 200, 30);
        lb3=new JLabel("label");
        lb3.setFont(new Font("Century Gothic", Font.BOLD, 15));
         lb3.setBounds(700, 100, 200, 30);
        lb4=new JLabel("label");
        lb4.setFont(new Font("Century Gothic", Font.BOLD, 15));
         lb4.setBounds(1000, 100, 200, 30);
        
        LBLimagPortada = new JLabel(portada);
        LBLimagPortada.setBounds(0, 0, 1400, 734);
        
        LBLfondo2 = new JLabel(marco1);
        LBLfondo2.setBounds(0, 0, 1400, 734);
        
        LBLfondo3 = new JLabel(Final);
        LBLfondo3.setBounds(0, 0, 1400, 734);
        
        LBLpanel1 = new JLabel(marco);
        LBLpanel1.setBounds(0, 0, 500, 340);

 
        //======================= BOTONES= =================================
  
        EliminarDato = new JButton("Eliminar Registro");         
         EliminarDato.setFont(new Font("Century Gothic", Font.BOLD, 15));
         EliminarDato.setBounds(1200, 500, 150, 30);
        EliminarDato.addActionListener(this);
        /*
        salir = new JButton("Salir");
        salir.setBounds(150, 480, 150, 30);
        salir.addActionListener(this);
        salir.setBackground(fondo1);
        salir.setFont(new Font("Century Gothic", Font.BOLD, 15));
*/
        JBregistrar = new JButton("Registrar Datos");
        JBregistrar.setBounds(200, 240,100,50);
        JBregistrar.addActionListener(this);

        JBGuardarDat = new JButton("Guardar Datos");
        JBGuardarDat.setBounds(150, 440,210,30);
        JBGuardarDat.addActionListener(this);
        JBGuardarDat.setBackground(fondo1);
        JBGuardarDat.setFont(new Font("Century Gothic", Font.BOLD, 15));

        //============================ PANELES ==================================
        panelWordT = new JPanel();
        panelWordT.add(jbRegLog);
       panelWordT.add(JBmenu);
        panelWordT.setLayout(new GridLayout(1, 2));
        panelWordT.setBackground(fondo2);
        panelWordT.add(LBLfondo2);
        Grafica g= new Grafica(paciente);
        g.GraficaGlucosa();
 
        panelGramP = new JPanel();
        panelGramP.setLayout(null);
        panelGramP.setBackground(fondo2);
        panelGramP.add(EliminarDato);
        panelGramP.add(lb1);
        panelGramP.add(lb2);
        panelGramP.add(lb3);
        panelGramP.add(lb4);
          panelGramP.add(jbRegLog);
       panelGramP.add(JBmenu);
        panelGramP.add(scrollPane);
        panelGramP.add(LBLfondo3);

        PanSalir = new JPanel(null);
        PanSalir.setBackground(fondo2);

        contenedor = this.getContentPane();

        JTPane = new JTabbedPane();
        JTPane.setBackground(fondo2);
        JTPane.addTab("REPORTES", icono2,panelGramP);
        JTPane.addTab("DIAGRAMAS",icono3 ,g.GraficaGlucosa());

        contenedor.add(JTPane);
        this.setSize(1400, 734);
        this.setVisible(true);

    }
    
    public void ComponentesDiagrama(){
    ifondoGrafica=new ImageIcon("src/imagenes/grafica.jpg");
    iBien=new ImageIcon("src/imagenes/glub.png");
    iNormal=new ImageIcon("src/imagenes/glun.png");
    iMalo=new ImageIcon("src/imagenes/glum.jpg");
    
    lbfondo= new JLabel(ifondoGrafica);
    lbbien= new JLabel(iBien);
    lbnormal= new JLabel(iNormal);
    lbmalo= new JLabel(iMalo);
    
    BntVer= new JButton("Ver Registros");
    
    
    
    }
    
     public void CrearTabla(){
    
    //array de String's con los títulos de las columnas
        String[] columnNames = {"No.Registro","Fecha","Nivel de Glucosa","Estatus"};
        dtm= new DefaultTableModel(null, columnNames);
        llenartabla();
        //se crea la Tabla con el modelo DefaultTableModel
         table = new JTable(dtm);
           //table.setBounds(400, 700, 600, 200);
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(200, 400, 1000, 150);
    }
    public void llenartabla(){
     try{
         MetodosSeleccion ms= new MetodosSeleccion();
         java.util.List<proyectofinal.Modelo.Glucosa> glu;
         glu= ms.recuperarGlucosa(paciente);
            dtm.setRowCount(0);
            for(int i = 0; i <glu.size(); i++){
                dtm.addRow(new Object[]{
                    glu.get(i).getIdGlucosa(),
                    glu.get(i).getFecha(),
                    glu.get(i).getNivelGlucosa(),
                    glu.get(i).getEstatus()
         
                });
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(this, "Error, no se han podido recuperar los registros");
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==EliminarDato){
           int rowselected= table.getSelectedRow();//localiza el registro eliminado
           int  value= dtm.getValueAt(rowselected,0).hashCode();//trae devuelta el identificador para eliminar
            System.out.println(""+value);
            MetodosEliminacion me= new MetodosEliminacion();
            me.Eliminarregistro("Glucosa", value,"GLUCOSA");
            dtm.removeRow(rowselected);
        }
           if (e.getSource() == jbRegLog) {
            Login obLog = new Login();
    JTPane.hide();
        }
         if (e.getSource()== JBmenu){
          Menu obMen = new Menu(paciente);
        JTPane.hide();
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
