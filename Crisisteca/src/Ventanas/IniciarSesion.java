package Ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class IniciarSesion extends JFrame{

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new IniciarSesion();
            }
            
		});

	}
	
	
	
	
	private JTextField tfNombre;
	private JTextField tfApellidos;
	
	
	public IniciarSesion() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Registrarse como Ciudadano");
		this.setBounds(100, 100, 1000, 700);
		this.setSize(600,400);
		this.setResizable(false);
		this.getContentPane().setLayout(new FlowLayout());
		this.setLocationRelativeTo(null);
		
		///Paneles
		JPanel pnlMain = new JPanel();
		JPanel pnlIzquierda = new JPanel();
		JPanel pnlDerecha = new JPanel();
		JPanel pnlAbajo = new JPanel();
	
		pnlMain.setLayout(new BorderLayout());
		pnlIzquierda.setLayout(new BoxLayout(pnlIzquierda, BoxLayout.Y_AXIS));
		pnlDerecha.setLayout(new BoxLayout(pnlDerecha, BoxLayout.Y_AXIS));
		
		JLabel lblNombreYApellidos = new JLabel("Nombre y Apellidos: ");
		lblNombreYApellidos.setFont(new Font("Arial", Font.PLAIN, 30));
		JLabel lblConotranyesa = new JLabel("Contraseña: ");
		lblConotranyesa.setFont(new Font("Arial", Font.PLAIN, 30));

		pnlIzquierda.add(lblNombreYApellidos);
		pnlIzquierda.add(lblConotranyesa);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		this.setVisible(true);

		
	}
	
	
	
}
