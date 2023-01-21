package Ventanas;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Entidades.Ciudadano;
import Ventanas.EmergenciasVentana;


public class EmergenciasVentana extends JFrame{
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {


            @Override
            public void run() {
//                new EmergenciasVentana();
            }           
		});
	}
	
//	private JScrollBar scBar;
	private JButton btn;
	
	
	public EmergenciasVentana(Ciudadano ciudadano) {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Emergencias actuales y de interés");
		this.setBounds(100, 100, 1000, 700);
		this.setSize(600,500);
		this.setResizable(false);
		this.getContentPane().setLayout(new FlowLayout());
		this.setLocationRelativeTo(null);
		
		//Paneles
		JPanel pnlMain = new JPanel();
		JPanel pnlArriba = new JPanel();
		JPanel pnlDerecha = new JPanel();
		JPanel pnlAbajo = new JPanel();
		
		pnlMain.setLayout(new BorderLayout());
		pnlArriba.setLayout(new BoxLayout(pnlArriba, BoxLayout.Y_AXIS));
		pnlDerecha.setLayout(new BoxLayout(pnlDerecha, BoxLayout.Y_AXIS));
		pnlAbajo.setLayout(new BoxLayout(pnlAbajo, BoxLayout.X_AXIS));
		
		//Panel arriba
		JLabel lblTitulo = new JLabel("Ultimas Emergencias y emergencias de interes");
		lblTitulo.setFont(new Font("Arial", Font.PLAIN, 20));
		JScrollBar scBar = new JScrollBar();
		
		pnlArriba.add(lblTitulo);
		pnlArriba.add(scBar);
		
		//Panel main
		pnlMain.add(pnlArriba, BorderLayout.WEST);
		getContentPane().add(pnlMain);
		
		setVisible(true);
		
		addWindowListener(new java.awt.event.WindowAdapter() {
	        public void windowClosing(java.awt.event.WindowEvent e) {
					new ReportarEmergenciasOEmergencias(ciudadano).setVisible(true);
	            setVisible(false);
	        }
	    });
			
	}
}
