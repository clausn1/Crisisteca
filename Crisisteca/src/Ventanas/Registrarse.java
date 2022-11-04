package Ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Label;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class Registrarse extends JFrame{

	private static JFrame frame;

	public static void main(String[] args) {

		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 1000, 700);
		frame.getContentPane().setLayout(new FlowLayout());
		frame.setLocationRelativeTo(null);

		/// Panel de la Izquierda
		JPanel pnlIzquierda = new JPanel();
		pnlIzquierda.setLayout(new BoxLayout(pnlIzquierda, BoxLayout.Y_AXIS));

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

		/// Panel de la Derecha
		JPanel pnlDerecha = new JPanel();

//		Label lvbl

		
		///Panel central
		JPanel pnlCentro = new JPanel();

		/// Panel principal
		JPanel pnlMain = new JPanel();
		pnlMain.setLayout(new BoxLayout(pnlMain, BoxLayout.Y_AXIS));
		pnlDerecha.setLayout(new BoxLayout(pnlDerecha, BoxLayout.Y_AXIS));
		pnlMain.add(pnlIzquierda, BorderLayout.WEST);
		pnlMain.add(pnlDerecha, BorderLayout.EAST);
		pnlMain.add(pnlCentro, BorderLayout.CENTER);

		frame.add(pnlMain);

		frame.setVisible(true);

	}

}
