/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.Vista.Principales;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import proyectofinal.Controlador.MetodosSeleccion;
import proyectofinal.Modelo.Paciente;

/**
 *
 * @author osito
 */
public class Grafica extends JFrame implements ActionListener{
    
    private JFrame frame;
    private JFrame FPrincipal;
   private JPanel PanelG;
    private JButton verGrafica;
    
         MetodosSeleccion ms= new MetodosSeleccion();
        Paciente paciente;
    public Grafica(Paciente p) {
      paciente=p;
    }
    public static void main(String[] args) {
        Paciente p= new Paciente();
        p.setId(1);
        Grafica run= new Grafica(p);
        
    }
    
    public JPanel GraficaAlimentacion(){
        java.util.List<proyectofinal.Modelo.Alimentacion> ali;

         DefaultCategoryDataset dataset = new DefaultCategoryDataset();
         try{  
             ali= ms.recuperarAlimentacion(paciente);
            for(int i = 0; i <ali.size(); i++){
                dataset.addValue(ali.get(i).getCantidadLiquidos()*1000, "Agua", ali.get(i).getFecha());
                dataset.addValue(ali.get(i).getCantidadCarbohidratos(), "Calorias", ali.get(i).getFecha());  
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(this, "Error, no se han podido recuperar los registros");
        }
       
     JFreeChart chart = ChartFactory.createBarChart(
                "Grafica de Consumo de Calorias",
                "Fecha",
                "Calorias",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                true
              );
            ChartPanel chartPanel = new ChartPanel(chart, false);    
          JPanel PanelGr=new JPanel();
            PanelGr.add(chartPanel);
                   
        return PanelGr;
    }
    
    public JPanel GraficaGlucosa(){
        java.util.List<proyectofinal.Modelo.Glucosa> glu;

         DefaultCategoryDataset dataset = new DefaultCategoryDataset();
         try{  
             glu= ms.recuperarGlucosa(paciente);
            for(int i = 0; i <glu.size(); i++){
                dataset.addValue(glu.get(i).getNivelGlucosa(), glu.get(i).getEstatus(), glu.get(i).getFecha());
              }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(this, "Error, no se han podido recuperar los registros");
        }
       
     JFreeChart chart = ChartFactory.createBarChart(
                "Grafica de Nivel de Glucosa",
                "Fecha",
                "Nivel de Glucosa",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                true
              );
            ChartPanel chartPanel = new ChartPanel(chart, false);    
          JPanel PanelGr=new JPanel();
            PanelGr.add(chartPanel);
                   
        return PanelGr;
    }
    
    public JPanel GraficaEjercicio(){
        java.util.List<proyectofinal.Modelo.ActividadFisica> glu;

         DefaultCategoryDataset dataset = new DefaultCategoryDataset();
         try{  
             glu= ms.recuperarActividadFisica(paciente);
            for(int i = 0; i <glu.size(); i++){
                dataset.addValue(glu.get(i).getHorasActividad(), glu.get(i).getEstatus(), glu.get(i).getFecha());
              }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(this, "Error, no se han podido recuperar los registros");
        }
       
     JFreeChart chart = ChartFactory.createBarChart(
                "Grafica de Actividad Fisica",
                "Fecha",
                "Horas de actividad",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                true
              );
            ChartPanel chartPanel = new ChartPanel(chart, false);    
          JPanel PanelGr=new JPanel();
            PanelGr.add(chartPanel);
                   
        return PanelGr;
    }
      
    public JPanel GraficaPresion(){
        java.util.List<proyectofinal.Modelo.Presion> glu;

         DefaultCategoryDataset dataset = new DefaultCategoryDataset();
         try{  
             glu= ms.recuperarPresion(paciente);
            for(int i = 0; i <glu.size(); i++){
                dataset.addValue(glu.get(i).getPresionSistolica(), "Presion Sistolica", glu.get(i).getFecha());
                dataset.addValue(glu.get(i).getPresionDiastolica(), "Presion Diastolica", glu.get(i).getFecha());
              
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(this, "Error, no se han podido recuperar los registros");
        }
       
     JFreeChart chart = ChartFactory.createBarChart(
                "Grafica de Presion Registrada",
                "Fecha",
                "Presion Arterial",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                true
              );
            ChartPanel chartPanel = new ChartPanel(chart, false);    
          JPanel PanelGr=new JPanel();
            PanelGr.add(chartPanel);
                   
        return PanelGr;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    
    }
    
}
