package Ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
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
	
	private JTextField tfLugar;
	private JComboBox<String> comboxTipoEmergencia;
	private JCheckBox cboxAvisar ;
	private JTextArea taDetalles;
	
	public VentanaReportarEmergencia() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Reportar Emergencia");
		this.setBounds(1000, 600, 1000, 700);
		this.setSize(1500,500);
		this.setResizable(false);
		this.getContentPane().setLayout(new FlowLayout());
		this.setLocationRelativeTo(null);
	
		
		
		//Paneles 
		JPanel pnlCentro = new JPanel();
		JPanel pnlIzquierda = new JPanel();
		JPanel pnlDerecha = new JPanel();
		JPanel pnlAbajo = new JPanel();
		
		pnlCentro.setLayout(new BorderLayout());
		pnlIzquierda.setLayout(new BoxLayout(pnlIzquierda, BoxLayout.Y_AXIS));
		pnlDerecha.setLayout(new BoxLayout(pnlDerecha, BoxLayout.Y_AXIS));
		pnlAbajo.setLayout(new BoxLayout(pnlAbajo, BoxLayout.X_AXIS));
		//Panel izquierda
		
		JLabel lblLugar = new JLabel("Lugar: ");
		lblLugar.setFont(new Font("Arial", Font.PLAIN, 30));
		JLabel lblTipoEmergencia = new JLabel("Seleccione el tipo de emergencia: ");
		lblTipoEmergencia.setFont(new Font("Arial", Font.PLAIN, 30));
		JLabel lblReportar = new JLabel("¿Desea reportar la emergencia a las autoridades y al resto de usuarios?");
		lblReportar.setFont(new Font("Arial", Font.PLAIN, 30));
		JLabel lblDetalles= new JLabel("¿Desea añadir algun tipo de información? ");
		lblDetalles.setFont(new Font("Arial", Font.PLAIN, 30));
		
		pnlIzquierda.add(lblLugar);
		pnlIzquierda.add(lblTipoEmergencia);
		pnlIzquierda.add(lblReportar);
		
		
		//Panel derecha
		
		tfLugar = new JTextField(20);
		comboxTipoEmergencia = new JComboBox<>();
		comboxTipoEmergencia.addItem("Coche");
		comboxTipoEmergencia.addItem("Robo");
		comboxTipoEmergencia.addItem("Violencia");
		taDetalles = new JTextArea();
		taDetalles.setLineWrap(true);
		taDetalles.setWrapStyleWord(true);

		cboxAvisar = new JCheckBox();
		
		tfLugar.setFont(new Font("Arial", Font.PLAIN, 20));
		taDetalles.setFont(new Font("Arial", Font.PLAIN, 20));
		
		
		
		pnlDerecha.add(tfLugar);
		pnlDerecha.add(comboxTipoEmergencia);
		pnlDerecha.add(cboxAvisar);
		
		
		pnlAbajo.add(lblDetalles);
		pnlAbajo.add(taDetalles);
		
		
		//Panel Principal
		pnlCentro.add(pnlIzquierda, BorderLayout.WEST);
		pnlCentro.add(pnlDerecha, BorderLayout.EAST);
		pnlCentro.add(pnlAbajo,BorderLayout.SOUTH);
		getContentPane().add(pnlCentro);
		
		this.setVisible(true);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
