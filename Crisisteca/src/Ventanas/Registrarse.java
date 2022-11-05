package Ventanas;

import java.awt.*;
import javax.swing.*;

public class Registrarse extends JFrame{

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Registrarse();
            }
            
		});

	}
	
	private JTextField tfNombre;
	private JTextField tfApellidos;
	private JTextField tfDNI;
	private JTextField tfDireccion;
	private JTextField tfCodigoPostal;
	private JTextField tfEmail;
	private JTextField tfTelefono;

	public Registrarse() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 1000, 700);
		this.setSize(400,400);
//		this.setSize( 600, 300 );
		getContentPane().setLayout(new FlowLayout(2));
		this.setLocationRelativeTo(null);
		this.setTitle("Registrarse");

		/// Panel de la Izquierda
		JPanel pnlMain = new JPanel();
		JPanel pnlIzquierda = new JPanel();
		JPanel pnlDerecha = new JPanel();
	
		
		pnlMain.setLayout(new BorderLayout());
		pnlIzquierda.setLayout(new BoxLayout(pnlIzquierda, BoxLayout.Y_AXIS));
		pnlDerecha.setLayout(new BoxLayout(pnlDerecha, BoxLayout.Y_AXIS));
		pnlIzquierda.setLayout(new GridLayout(7,7));
//		pnlIzquierda.setSize(41, 41);;

		JLabel lblNombre = new JLabel("Nombre: ");
		JLabel lblApellidos = new JLabel("Apellidos: ");
		JLabel lblDNI = new JLabel("DNI: ");
		JLabel lblDireccion = new JLabel("Dirección: ");
		JLabel lblCodigoPostal = new JLabel("Código Postal: ");
		JLabel lblEmail = new JLabel("E-mail: ");
		JLabel lblTelefono = new JLabel("Teléfono: ");
		JLabel lblCondicionesUso = new JLabel();
		
		pnlIzquierda.add(lblNombre);
		
		pnlIzquierda.add(lblApellidos);
		pnlIzquierda.add(lblDNI);
		pnlIzquierda.add(lblDireccion);
		pnlIzquierda.add(lblCodigoPostal);
		pnlIzquierda.add(lblEmail);
		pnlIzquierda.add(lblTelefono);
		pnlIzquierda.add(lblCondicionesUso);

		/// Panel de la Derecha
		tfNombre = new JTextField( "", 20);
		tfApellidos= new JTextField("",20);
		tfDNI = new JTextField( "", 20);
		tfDireccion= new JTextField("",20);
		tfCodigoPostal= new JTextField("",20);
		tfEmail = new JTextField( "", 20);
		tfTelefono= new JTextField("",20);
		
		pnlDerecha.add(tfNombre);
		pnlDerecha.add(tfApellidos);
		pnlDerecha.add(tfDNI);
		pnlDerecha.add(tfDireccion);
		pnlDerecha.add(tfCodigoPostal);
		pnlDerecha.add(tfEmail);
		pnlDerecha.add(tfTelefono);

		
		///Panel central

		/// Panel principal
//		pnlMain.setLayout(new BoxLayout(pnlMain, BoxLayout.X_AXIS));
//		pnlDerecha.setLayout(new BoxLayout(pnlDerecha, BoxLayout.Y_AXIS));
//		pnlMain.add(pnlIzquierda, BorderLayout.WEST);
//		pnlMain.add(pnlDerecha, BorderLayout.EAST);
//		pnlMain.add(pnlCentro, BorderLayout.CENTER);
		
		pnlMain.add(pnlIzquierda, BorderLayout.WEST);
		pnlMain.add(pnlDerecha, BorderLayout.EAST);
//
		add(pnlMain, BorderLayout.NORTH);


		setVisible(true);
		
		
		
	}
	
	
	

}
