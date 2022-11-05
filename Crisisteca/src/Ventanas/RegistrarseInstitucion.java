package Ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class RegistrarseInstitucion extends JFrame{
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new RegistrarseInstitucion();
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

	public RegistrarseInstitucion() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 1000, 700);
		this.setSize(400,400);
//		this.setSize( 600, 300 );
		getContentPane().setLayout(new FlowLayout());
		this.setLocationRelativeTo(null);
		this.setTitle("Registrarse Institucion");

		/// Panel de la Izquierda
		JPanel pnlMain = new JPanel();
		JPanel pnlIzquierda = new JPanel();
		JPanel pnlDerecha = new JPanel();
	
		//espacios en blanco
		//EmptyBorder espacio = new EmptyBorder(5,20,5,20);
		
		pnlMain.setLayout(new BorderLayout());
//		pnlIzquierda.setLayout(new BoxLayout(pnlIzquierda, BoxLayout.Y_AXIS));
//		pnlDerecha.setLayout(new BoxLayout(pnlDerecha, BoxLayout.Y_AXIS));
		pnlIzquierda.setLayout(new GridLayout(10,1));
//		pnlIzquierda.setSize(41, 41);;
		pnlDerecha.setLayout(new BoxLayout(pnlDerecha, BoxLayout.Y_AXIS));

		JLabel lblNombre = new JLabel("Nombre: ");
		JLabel lblEmail = new JLabel("E-mail: ");
		JLabel lblTelefono = new JLabel("Teléfono: ");
		
		pnlIzquierda.add(lblNombre);
		pnlIzquierda.add(lblEmail);
		pnlIzquierda.add(lblTelefono);

		/// Panel de la Derecha
		tfNombre = new JTextField( "", 20);
		tfEmail = new JTextField( "", 20);
		tfTelefono= new JTextField("",20);
		
		pnlDerecha.add(tfNombre);
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


