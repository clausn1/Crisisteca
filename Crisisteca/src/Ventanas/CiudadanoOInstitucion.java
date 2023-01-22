package Ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;

public class CiudadanoOInstitucion extends JFrame {
	static Logger log;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new CiudadanoOInstitucion();
			}
		});
	}

	public CiudadanoOInstitucion() {
		log = Logger.getLogger("programLogger");

		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setTitle("Escoger tipo de usuario");
		this.setBounds(625, 350, 1000, 700);
		this.setSize(300, 100);
		this.setResizable(false);

		JButton bCiudadano = new JButton("Ciudadano");
		JButton bInstitucion = new JButton("Institución");

		JPanel pnlMain = new JPanel();
		JPanel pnlBotones = new JPanel();

		pnlBotones.add(bCiudadano);
		pnlBotones.add(bInstitucion);
		pnlMain.add(pnlBotones);
		getContentPane().add(pnlMain);

		setVisible(true);

		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				new VentanaInicio().setVisible(true);
				setVisible(false);
			}
		});

		/*
		 * El Action Listener sirve para ver que boton se elegige, dependiendo cual se
		 * eliga se abrira una u otra ventana param: evento e (click en un boton)
		 * return: si se selecciona el boton Ciudadano, se habrira la ventana
		 * RegistrarseCiudadano si se selecciona el boton Institucion, se habrira la
		 * ventana RegistrarseInstitucion
		 */
		ActionListener albCiudadano = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new RegistrarseCiudadano().setVisible(true);
				setVisible(false);
				log.log(Level.FINE, "Se ha elegido registrarse como ciudadano");

			}
		};

		bCiudadano.addActionListener(albCiudadano);

		ActionListener albInstitucion = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new RegistrarseInstitucion().setVisible(true);
				setVisible(false);
				log.log(Level.FINE, "Se ha elegido registrarse como institucion");
			}
		};

		bInstitucion.addActionListener(albInstitucion);

	}
}