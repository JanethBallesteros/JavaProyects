/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.Vista.Informativas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author KarimePamela
 */
public class Brazos  extends JFrame implements MouseListener, ItemListener, ActionListener {
    private JFrame FramePrinci;
    private JButton  JBmenu;
    private ImageIcon Usuario, fondo, cuadro, llave;
    private JLabel LBLfondo;
            
    
        public Brazos(){
                  Color fondo1 = new Color(191,201,202);
        Color fondo2 = new Color(212,230,241);
        Color fondo3 = new Color(46,134,193);
        Color fondo4 = new Color(36,113,163);
        Color fondo5 = new Color(248,249,249);
        Color fondo6 = new Color(26,82,118);
   
       Usuario = new ImageIcon("src/ImagenesProy/user.png");
        llave = new ImageIcon("src/ImagenesProy/access.png");
        fondo = new ImageIcon("src/ImagenesProy/Ejer1.png");
        cuadro = new ImageIcon("src/ImagenesProy/Green2.png");    
        
        
       LBLfondo= new JLabel(fondo);
       LBLfondo.setBounds(0,0, 150,30);
       LBLfondo.setFont(new Font("Arial Unicode MS", Font.PLAIN, 15));
              
       JBmenu= new JButton("MENU");
       JBmenu.setBounds(90, 587,100,30);
       JBmenu.addActionListener(this);
       JBmenu.setBackground(fondo3);
       JBmenu.setForeground(fondo2);
       JBmenu.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        
            
        FramePrinci = new JFrame();
       FramePrinci.pack();
       FramePrinci.add(JBmenu);
       FramePrinci.add(LBLfondo);
       FramePrinci.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       FramePrinci.setSize(1400,730);
       FramePrinci.setVisible(true);
        }

        public static void main(String[] args) {
       Brazos objC = new Brazos();
                
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

    @Override
    public void itemStateChanged(ItemEvent e) {
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
    }

    
}
