/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.Vista.MuestreoDatos;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import proyectofinal.Controlador.MetodosAgregacion;
import proyectofinal.Controlador.MetodosEliminacion;
import proyectofinal.Controlador.MetodosSeleccion;
import proyectofinal.Modelo.ActividadFisica;
import proyectofinal.Modelo.Glucosa;
import proyectofinal.Modelo.HoraSistema;
import proyectofinal.Modelo.Paciente;

public class JTableAlumnos extends JFrame implements ActionListener,MouseListener,ItemListener {
    
    private JPanel ptitulo,pformulario,ptabap, pderecha;
    private JLabel lnombre,lc1,lc2,lc3,lturno;
    private JTextField tnombre,tc1,tc2,tc3,tturno;
    private JRadioButton rmatutino,rvespertino;
    private ButtonGroup turnos;
     private JLabel Imalogo,lconteo,lvacio,lvacio2,lvacio3;
     private JButton bagregar,beliminar;
    private DefaultTableModel dtm;
    final JTable table;
    private JComboBox cturnos;
    private JLabel lb1,lb2,lb3;
    
    ///========objetpos importadois======
    Paciente p;
    HoraSistema h= new HoraSistema();
    //conexion
    public Statement stmt;
      ResultSet rs;
    
   
    public void CreandoFormulario(){
        pderecha= new JPanel();
        lb1=new JLabel("prueba");
        lb2=new JLabel("Prueba");
        lb3=new JLabel("prueba");
        pderecha.add(lb1);
        pderecha.add(lb2);
        pderecha.add(lb3);
        
        
    ptitulo=new JPanel();
    Imalogo= new JLabel(new ImageIcon("src/images/logo.jpg"));
    ptitulo.add(Imalogo);
    lconteo=new JLabel("Alumnos Inscritos: ");
    lvacio=new JLabel("");
    lvacio2=new JLabel("");
    lvacio3=new JLabel("");
    
    lnombre= new JLabel("Nombre");
    lc1= new JLabel("Calificacion 1");
    lc2= new JLabel("Calificacion 2");
    lc3= new JLabel("Calificacion 3");
    lturno= new JLabel("Turno");
    tturno= new JTextField(10);
    tnombre= new JTextField(10);
    tc1= new JTextField(2);
     tc2= new JTextField(2);
    tc3= new JTextField(2);
    turnos=  new ButtonGroup();
    rvespertino= new JRadioButton("Vespertino");
    rmatutino=new JRadioButton("Matutino");
    turnos.add(rmatutino);
    turnos.add(rvespertino);
    bagregar= new JButton("Agregar");
    bagregar.addMouseListener(this);
    bagregar.addActionListener(this);
    beliminar=new JButton("Eliminar");
    beliminar.addMouseListener(this);
    beliminar.addActionListener(this);
    
     cturnos=new JComboBox();
        cturnos.setBounds(10,10,80,20);
        add(cturnos);
        cturnos.addItem("Matutino");
        cturnos.addItem("Vespertino");
        cturnos.addItemListener(this);

    }
    
    
   
    
    public JTableAlumnos(Paciente pa) throws ClassNotFoundException {
    super("Prueba");
    p=pa;
    CreandoFormulario();
    
    pformulario=new JPanel();
    pformulario.setLayout(new GridLayout(8,2,10,10));
    pformulario.setBackground(Color.WHITE);
    pformulario.setBorder(BorderFactory.createTitledBorder("Formulario"));
    pformulario.add(lnombre);
    pformulario.add(tnombre);
    pformulario.add(lc1);
    pformulario.add(tc1);
    pformulario.add(lc2);
    pformulario.add(tc2);
    pformulario.add(lc3);
    pformulario.add(tc3);
    pformulario.add(lturno);
    //pformulario.add(tturno);
    pformulario.add(cturnos);
    pformulario.add(lvacio);
    pformulario.add(lvacio2);
    pformulario.add(lvacio3);
    pformulario.add(bagregar);
    pformulario.add(beliminar);
    pformulario.add(lconteo);
    
    
  
            
    //array bidimencional de objetos con los datos de la tabla
    Object[][] data = { 
        };

        //array de String's con los títulos de las columnas
        String[] columnNames = {"Nombre",
        "Calificacion1",
        "Calificacion2",
        "Calificacion3",
        "Turno"};
        
        //creamos el Modelo de la tabla con los datos anteriores
         dtm= new DefaultTableModel(data, columnNames);
         llenartabla();
        //se crea la Tabla con el modelo DefaultTableModel
         table = new JTable(dtm);
 
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
            
        //Creamos un JscrollPane y le agregamos la JTable
        JScrollPane scrollPane = new JScrollPane(table);
        //Agregamos el JScrollPane al contenedor
        getContentPane().add(ptitulo, BorderLayout.NORTH);
        getContentPane().add(pformulario, BorderLayout.CENTER);
        getContentPane().add(pderecha, BorderLayout.EAST);
        getContentPane().add(scrollPane, BorderLayout.SOUTH);
         //manejamos la salida
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
            System.exit(0);
            }
        });
    }
    public void llenartabla(){
     try{
         MetodosSeleccion ms= new MetodosSeleccion();
         java.util.List<Glucosa> tareas;
         tareas= ms.recuperarGlucosa(p);
            dtm.setRowCount(0);
            for(int i = 0; i <tareas.size(); i++){
                dtm.addRow(new Object[]{
                    tareas.get(i).getIdUsuario(),
                    tareas.get(i).getFecha(),
                        tareas.get(i).getEstatus(),
                        tareas.get(i).getNivelGlucosa(),
                        tareas.get(i).getIdGlucosa()
                });
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(this, "Error, no se han podido recuperar los registros");
        }
    }
 
  public static void main(String[] args) throws SQLException, ClassNotFoundException {
      Paciente p= new Paciente("Janeth","Ballesteros","Janny","hola","Femenino",20,1.7,75);
      p.setId(1);
        JTableAlumnos frame = new JTableAlumnos(p);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
      }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==bagregar){
       int id=p.getId();
        String Fecha= h.TiempoActual();
        String datocadena= tnombre.getText();
        double d1=Double.parseDouble(tc1.getText());
        double d2=Double.parseDouble(tc2.getText());
        //Glucosa g= new Glucosa(id,Fecha,d1);
        ActividadFisica af= new ActividadFisica(id,Fecha,d1,datocadena);
        MetodosAgregacion ma= new MetodosAgregacion();
        ma.AgregarActividadFisica(af);
            System.out.println("se agrego");
        }
        if(ae.getSource()==beliminar){
           int rowselected= table.getSelectedRow();//localiza el registro eliminado
           int  value= dtm.getValueAt(rowselected,4).hashCode();//trae devuelta el identificador para eliminar
            System.out.println(""+value);
            MetodosEliminacion me= new MetodosEliminacion();
            me.Eliminarregistro("Glucosa", value,"GLUCOSA");
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
   }
 }

    
   
   
    

