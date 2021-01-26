/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.Vista.MuestreoDatos;

import proyectofinal.Vista.Principales.Ejercicio;
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
import proyectofinal.Controlador.MetodosAgregacion;
import proyectofinal.Controlador.MetodosEliminacion;
import proyectofinal.Controlador.MetodosSeleccion;
import static proyectofinal.Controlador.Validaciones.isNumerico;
import proyectofinal.Modelo.ActividadFisica;
import proyectofinal.Modelo.HoraSistema;
import proyectofinal.Modelo.Paciente;
import proyectofinal.Vista.Principales.Grafica;
import proyectofinal.Vista.Principales.Login;
import proyectofinal.Vista.Principales.Menu;

/**
 *
 * @author KarimePamela
 */
public class VentanaEjerci extends JFrame implements ActionListener, MouseListener {

      private JButton JBmenu,jbRegLog;
    private Container contenedor;
    private JTabbedPane JTPane;
    private JPanel panelPortada, panelGramP, panelWordT;
    private Icon icono2,icono3;
    private JTextField  TXTHorasActivi, TXTtipoActi;
       private JTextField TXTpresion, TXTidActividad, TXTidUsuario;
    private JLabel LBLidActi, LBLIdUsuario, LBLfecha, LBLHorasActiv, LBLtipoActiv,LBLimagPortada, LBLpres,
            LBLpanel1, LBLfondo2, LBLfondo3;
    public int erro, ran; public String Tipo;
    Paciente paciente;
    private JButton Regresar,JBregistrar, salir, JBGuardarDat,EliminarDato;
    private JLabel lb1,lb2,lb3,lb4;
     private JButton btnEliminar;
//======para la tabla interna=======//
    private DefaultTableModel dtm;
    private JTable table;
    private JScrollPane scrollPane;
    private Grafica g;
    
    ImageIcon portada = new ImageIcon("src/ImagenesProy/DatosEjerFo.png");
    ImageIcon marco = new ImageIcon("src/ImagenesProy/fondoTrans.png");
    ImageIcon marco1 = new ImageIcon("src/ImagenesProy/fondo2.png");
    ImageIcon Final = new ImageIcon("src/ImagenesProy/fondo3.png");
     ImageIcon icono1 = new ImageIcon("src/ImagenesProy/icono1.png");
 
     HoraSistema hora= new HoraSistema();
     
     Color letras = new Color(31, 97, 141);
    public VentanaEjerci(String t,Paciente p) {
        super("Ejercicios");
         this.Tipo=t;
         
         paciente=p;
         CrearTabla();
        icono2 = new ImageIcon("src/ImagenesProy/icono2.png");
        icono3 = new ImageIcon("src/ImagenesProy/icono3.png");
        
        Image icono = Toolkit.getDefaultToolkit().getImage("src/jtabbedpane/FLORecita.png");
        setIconImage(icono);

        Color fondo1 = new Color(250, 215,160);
        Color fondo2 = new Color(247, 220, 111);
        Color fondo3 = new Color(237, 187, 153);
        Color fondo4 = new Color(33, 47, 60);
        Color LetraTXT = new Color(253,254,254);
        
  // ============================= TEXT FIELDS ==========================   

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
        jbRegLog.setBounds(1100, 600, 190, 80);
        jbRegLog.addActionListener(this);
        jbRegLog.setBackground(letras);
        jbRegLog.setIcon(salir);
        jbRegLog.setOpaque(false);
        jbRegLog.setBorderPainted(false);
        jbRegLog.setFont(new Font("Century Gothic", Font.PLAIN, 15));
  
        TXTHorasActivi = new JTextField(10);
        TXTHorasActivi.setBounds(250,130,200,30);
        TXTHorasActivi.setBackground(fondo3);
        TXTHorasActivi.setForeground(LetraTXT);
        
        
        TXTidActividad = new JTextField("ID aCY");
        TXTidActividad.setBounds(250,180,100,30);
        TXTidActividad.setBackground(fondo3);
        TXTidActividad.setForeground(LetraTXT);
        
        TXTidUsuario = new JTextField("id us");
        TXTidUsuario.setBounds(250,230,100,30);
        TXTidUsuario.setBackground(fondo3);
        TXTidUsuario.setForeground(LetraTXT);
        
        TXTtipoActi = new JTextField(this.Tipo+"    ");
        TXTtipoActi.setBounds(250,200,100,30);
        TXTtipoActi.setBackground(fondo3);
        TXTtipoActi.setForeground(LetraTXT);
        
        TXTpresion = new JTextField("Pres");
        TXTpresion.setBounds(250,330,100,30);
        TXTpresion.setBackground(fondo3);
        TXTpresion.setForeground(LetraTXT);
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

        
        LBLHorasActiv = new JLabel("Horas de entrenamiento");
        LBLHorasActiv.setBounds(30,130, 200, 30);
        LBLHorasActiv.setFont(new Font("Century Gothic", Font.BOLD, 15));
        LBLHorasActiv.setForeground(fondo4);
        
        
       
        LBLfecha = new JLabel("Fecha: "+hora.TiempoActual());
        LBLfecha.setBounds(30,80, 500, 30);
        LBLfecha.setFont(new Font("Century Gothic", Font.BOLD, 15));
        LBLfecha.setForeground(fondo4);
        
        
        LBLidActi = new JLabel("Id Actividad");
        LBLidActi.setBounds(30,180, 200,30);
        LBLidActi.setFont(new Font("Century Gothic", Font.BOLD, 15));
        LBLidActi.setForeground(fondo4);
        
        LBLIdUsuario = new JLabel("IdUsuario");
        LBLIdUsuario.setBounds(30,230, 100, 30);
        LBLIdUsuario.setFont(new Font("Centus(30,230, 500, 30)ry Gothic", Font.BOLD, 15));
        LBLIdUsuario.setForeground(fondo4);
        
        LBLtipoActiv = new JLabel("Tipo de Actividad Fisica");
        LBLtipoActiv.setBounds(30,200, 200, 30);
        LBLtipoActiv.setFont(new Font("Century Gothic", Font.BOLD, 15));
        LBLtipoActiv.setForeground(fondo4);
        
        LBLpres = new JLabel("Presion");
        LBLpres.setBounds(30,330,100,30);
        LBLpres.setFont(new Font("Century Gothic", Font.BOLD, 15));
        LBLpres.setForeground(fondo4);

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
        panelWordT.setLayout(null);
        panelWordT.setBackground(fondo2);
        panelWordT.add(LBLfondo2);
        g= new Grafica(paciente);
        g.GraficaEjercicio();
        
        
        panelPortada = new JPanel(null);
        panelPortada.setOpaque(false);
        panelPortada.add(JBmenu);
        panelPortada.add(jbRegLog);
        panelPortada.add(TXTHorasActivi);
        panelPortada.add(TXTtipoActi);
        
       // panelPortada.add(salir);
        panelPortada.add(JBGuardarDat);
        panelPortada.add(LBLHorasActiv);
        panelPortada.add(LBLfecha);
        panelPortada.add(LBLtipoActiv);
        panelPortada.add(LBLimagPortada);

        panelGramP = new JPanel();
        panelGramP.setLayout(null);
        
        panelGramP.setBackground(fondo2);
        panelGramP.add(EliminarDato);
        panelGramP.add(lb1);
        panelGramP.add(lb2);
        panelGramP.add(lb3);
        panelGramP.add(lb4);
        panelGramP.add(scrollPane);
        panelGramP.add(LBLfondo3);

        contenedor = this.getContentPane();
       
        JTPane = new JTabbedPane();
        
        JTPane.addTab("REGISTRO", icono1,panelPortada);
        JTPane.setBackground(fondo2);
        JTPane.addTab("REPORTES", icono2,panelGramP);
        JTPane.addTab("DIAGRAMAS",icono3 ,g.GraficaEjercicio());

        
        contenedor.add(JTPane);
        this.setSize(1400, 734);
        this.setVisible(true);

    }

    public void CrearTabla(){
    //array de String's con los títulos de las columnas
        String[] columnNames = {"No.Registro","Fecha","Horas Realizadas","Tipo Actividad","Estatus",};
        dtm= new DefaultTableModel(null, columnNames);
        llenartabla();
        //se crea la Tabla con el modelo DefaultTableModel
         table = new JTable(dtm);
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(200, 400, 1000, 150);
    }
    
    public void llenartabla(){
     try{
         MetodosSeleccion ms= new MetodosSeleccion();
         java.util.List<proyectofinal.Modelo.ActividadFisica> actf;
         actf= ms.recuperarActividadFisica(paciente);
            dtm.setRowCount(0);
            for(int i = 0; i <actf.size(); i++){
                dtm.addRow(new Object[]{
                    actf.get(i).getIdActividad(),
                    actf.get(i).getFecha(),
                    actf.get(i).getHorasActividad(),
                    actf.get(i).getTipoActividad(),
                    actf.get(i).getEstatus(),
                        actf.get(i).getEstatus(),
                        
                });
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(this, "Error, no se han podido recuperar los registros");
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==JBGuardarDat){
            if(isNumerico(TXTHorasActivi.getText()) ){
                double horasac= Double.parseDouble(TXTHorasActivi.getText());
                ActividadFisica acti= new ActividadFisica(paciente.getId(),hora.TiempoActual(),horasac, TXTtipoActi.getText());
            MetodosAgregacion ma= new MetodosAgregacion();
            ma.AgregarActividadFisica(acti);
            }
        TXTHorasActivi.setText("");
        llenartabla();
        g.GraficaEjercicio();
        
        }
            
        if (e.getSource() == salir){
            System.exit(0);
            setVisible(false);
            Ejercicio obj2 = new Ejercicio(paciente);
        }
        
        if(e.getSource()==EliminarDato){
           int rowselected= table.getSelectedRow();//localiza el registro eliminado
           int  value= dtm.getValueAt(rowselected,0).hashCode();//trae devuelta el identificador para eliminar
            System.out.println(""+value);
            MetodosEliminacion me= new MetodosEliminacion();
            me.Eliminarregistro("ActividadFisica", value,"ACTIVIDADFISICA");
            dtm.removeRow(rowselected);
        }
        if (e.getSource() == jbRegLog) {
            Login obLog = new Login();
            //JTPane.hide();
             this.setVisible(false);
        }
        if (e.getSource() == JBmenu) {
            Menu obMen = new Menu(paciente);
           // JTPane.hide();
           this.setVisible(false);
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
