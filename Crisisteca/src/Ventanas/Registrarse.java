package Ventanas;
import java.awt.*;
import javax.swing.*;

public class Registrarse {
	
	private static JFrame frame;
	public static void main(String[] args) {
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100,100,1000,700);
		frame.getContentPane().setLayout(new FlowLayout());
		frame.setLocationRelativeTo(null);
		
		
		JPanel pnlIzquierda = new JPanel();
		
		JTextPane paneNombre = new JTextPane();
		JTextPane paneApellidos = new JTextPane();
		JTextPane paneDNI = new JTextPane();
		JTextPane paneDireccion = new JTextPane();
		JTextPane paneCodigoPostal = new JTextPane();
		JTextPane paneEmail = new JTextPane();
		JTextPane paneTelefono = new JTextPane();
		
		pnlIzquierda.add(paneNombre);
		pnlIzquierda.add(paneApellidos);
		pnlIzquierda.add(paneDNI);
		pnlIzquierda.add(paneDireccion);
		pnlIzquierda.add(paneCodigoPostal);
		pnlIzquierda.add(paneEmail);
		pnlIzquierda.add(paneTelefono);
		
		frame.add(pnlIzquierda);
		frame.setVisible(true);

		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	

}
