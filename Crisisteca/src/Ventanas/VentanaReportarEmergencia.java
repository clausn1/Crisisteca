package Ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class VentanaReportarEmergencia extends JFrame{
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new VentanaReportarEmergencia();
			}
		});
	}
	
	private JTextField tflugar;
	private JScrollBar sbTipoEmergencia;
	private JFrame tyc;
	private JTextField tfInfo;
	
	public VentanaReportarEmergencia() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Registrarse como Ciudadano");
		this.setBounds(100, 100, 1000, 700);
		this.setSize(600,400);
		this.setResizable(false);
		this.getContentPane().setLayout(new FlowLayout());
		this.setLocationRelativeTo(null);
		
		//Paneles 
		JPanel pnlCentro = new JPanel();
		JPanel pnlIzquierda = new JPanel();
		JPanel pnlDerecha = new JPanel();
		
		pnlCentro.setLayout(new BorderLayout());
		pnlIzquierda.setLayout(new BoxLayout(pnlIzquierda, BoxLayout.Y_AXIS));
		pnlDerecha.setLayout(new BoxLayout(pnlDerecha, BoxLayout.Y_AXIS));
		
		//Panel izquierda
		
		JLabel lblLugar = new JLabel("Lugar: ");
		lblLugar.setFont(new Font("Arial", Font.PLAIN, 30));
		JLabel lblTipoEmergencia = new JLabel("Seleccione el tipo de emergencia: ");
		JLabel lblReportar = new JLabel("¿Desea reportar la emergencia a las autoridades y al resto de usuarios?");
		JLabel lblInfo = new JLabel("¿Desea añadir algun tipo de información? ");
		
		pnlIzquierda.add(lblLugar);
		pnlIzquierda.add(lblTipoEmergencia);
		pnlIzquierda.add(lblReportar);
		pnlIzquierda.add(lblInfo);
		
		//Panel derecha
		
		tflugar = new JTextField(20);
		sbTipoEmergencia = new JScrollBar();
		tfInfo = new JTextField();
		
		
		tflugar.setFont(new Font("Arial", Font.PLAIN, 20));
		tfInfo.setFont(new Font("Arial", Font.PLAIN, 20));
		
		pnlDerecha.add(tflugar);
		pnlDerecha.add(tfInfo);
		
		
		//Panel Principal
		pnlCentro.add(pnlIzquierda, BorderLayout.WEST);
		pnlCentro.add(pnlDerecha, BorderLayout.EAST);
		getContentPane().add(pnlCentro);
		
		this.setVisible(true);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
