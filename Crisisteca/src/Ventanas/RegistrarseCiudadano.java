package Ventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.PublicKey;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import BasesDeDatos.BDCiudadano;
import BasesDeDatos.BDInstitucion;
import Entidades.Ciudadano;
import Entidades.Institucion;
import Principal.FuncionesEspeciales;

public class RegistrarseCiudadano extends JFrame {
	static Logger log;



	private JTextField tfNombre;
	private JTextField tfApellidos;
	private JTextField tfDNI;
	private JTextField tfDireccion;
	private JTextField tfCodigoPostal;
	private JTextField tfEmail;
	private JTextField tfTelefono;
	private JFrame tyc;

	public RegistrarseCiudadano() {
		log = Logger.getLogger("programLogger");

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Registrarse como Ciudadano");
		this.setBounds(100, 100, 1000, 700);
		this.setSize(600, 400);
		this.setResizable(false);
		this.getContentPane().setLayout(new FlowLayout());
		this.setLocationRelativeTo(null);

		/// Paneles
		JPanel pnlMain = new JPanel();
		JPanel pnlIzquierda = new JPanel();
		JPanel pnlDerecha = new JPanel();
		JPanel pnlAbajo = new JPanel();


		pnlMain.setLayout(new BorderLayout());
		pnlIzquierda.setLayout(new BoxLayout(pnlIzquierda, BoxLayout.Y_AXIS));
		pnlDerecha.setLayout(new BoxLayout(pnlDerecha, BoxLayout.Y_AXIS));

		/// Panel de la Izquierda

		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 30));
		JLabel lblApellidos = new JLabel("Apellidos: ");
		lblApellidos.setFont(new Font("Arial", Font.PLAIN, 30));
		JLabel lblDNI = new JLabel("DNI: ");
		lblDNI.setFont(new Font("Arial", Font.PLAIN, 30));
		JLabel lblDireccion = new JLabel("Dirección: ");
		lblDireccion.setFont(new Font("Arial", Font.PLAIN, 30));
		JLabel lblCodigoPostal = new JLabel("Código Postal: ");
		lblCodigoPostal.setFont(new Font("Arial", Font.PLAIN, 30));
		JLabel lblEmail = new JLabel("E-mail: ");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 30));
		JLabel lblTelefono = new JLabel("Teléfono: ");
		lblTelefono.setFont(new Font("Arial", Font.PLAIN, 30));

		pnlIzquierda.add(lblNombre);
		pnlIzquierda.add(lblApellidos);
		pnlIzquierda.add(lblDNI);
		pnlIzquierda.add(lblDireccion);
		pnlIzquierda.add(lblCodigoPostal);
		pnlIzquierda.add(lblEmail);
		pnlIzquierda.add(lblTelefono);

		/// Panel de la Derecha
		tfNombre = new JTextField(20);
		tfApellidos = new JTextField(20);
		tfDNI = new JTextField(20);
		tfDireccion = new JTextField(20);
		tfCodigoPostal = new JTextField(20);
		tfEmail = new JTextField(20);
		tfTelefono = new JTextField(20);



		tfCodigoPostal.addKeyListener(new KeyAdapter() { // https://www.tutorialspoint.com/how-can-we-make-jtextfield-accept-only-numbers-in-java
			public void keyPressed(KeyEvent p) {
				if (p.getKeyChar() >= '0' && p.getKeyChar() <= '9' || p.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
					tfCodigoPostal.setEditable(true);

				} else {
					tfCodigoPostal.setEditable(false);
					JOptionPane.showMessageDialog(null, "Recuerde no incluir letras");

				}
			}

			public void keyTyped(KeyEvent t) {
				if (tfCodigoPostal.getText().length() >= 5)
					t.consume();
			}

		});

		tfTelefono.addKeyListener(new KeyAdapter() { // https://www.tutorialspoint.com/how-can-we-make-jtextfield-accept-only-numbers-in-java
			public void keyPressed(KeyEvent p) {
				if (p.getKeyChar() >= '0' && p.getKeyChar() <= '9' || p.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
					tfTelefono.setEditable(true);
				} else {
					tfTelefono.setEditable(false);
					JOptionPane.showMessageDialog(null, "Recuerde no incluir letras");

				}
			}

			public void keyTyped(KeyEvent t) {
				if (tfTelefono.getText().length() >= 9)
					t.consume();
			}

		});

		tfNombre.setFont(new Font("Arial", Font.PLAIN, 20));
		tfApellidos.setFont(new Font("Arial", Font.PLAIN, 20));
		tfDNI.setFont(new Font("Arial", Font.PLAIN, 20));
		tfDireccion.setFont(new Font("Arial", Font.PLAIN, 20));
		tfCodigoPostal.setFont(new Font("Arial", Font.PLAIN, 20));
		tfEmail.setFont(new Font("Arial", Font.PLAIN, 20));
		tfTelefono.setFont(new Font("Arial", Font.PLAIN, 20));

		pnlDerecha.add(tfNombre);
		pnlDerecha.add(tfApellidos);
		pnlDerecha.add(tfDNI);
		pnlDerecha.add(tfDireccion);
		pnlDerecha.add(tfCodigoPostal);
		pnlDerecha.add(tfEmail);
		pnlDerecha.add(tfTelefono);

		/// Panel de condiciones de uso
		JCheckBox cboxCondicionesUso = new JCheckBox("Acepto los términos de uso");
		cboxCondicionesUso.setFont(new Font("Arial", Font.PLAIN, 20));
		pnlAbajo.add(cboxCondicionesUso);

		JButton bRegistrar = new JButton("Registrar");
		bRegistrar.setEnabled(false);
		pnlAbajo.add(bRegistrar);
		// añadir color al pasar por encima y listener a los terminos y condiciones

		cboxCondicionesUso.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				if (tyc == null || !tyc.isDisplayable()) {
					tyc = new JFrame("Leer");
					tyc.setSize(new Dimension(500, 300));
					tyc.setVisible(true);
					tyc.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					// el texto de terminos y condiciones

					JTextArea terminos = new JTextArea();
					terminos.setLineWrap(true);
					terminos.setWrapStyleWord(true);
					terminos.setEditable(false);
					terminos.setText("USO INDEBIDO\n" + "\n"
							+ "Usted acepta hacer uso adecuado de la aplicacion, siendo honesto con sus reportes\n"
							+ "\n CONSECUENCIAS LEGALES\n" + "\n"
							+ "Si usted hace un uso indebido de la aplicacion, acepta el hecho de que se puedan tomar acciones legales en su contra.");
					tyc.add(terminos);
				}
			}

			public void mouseEntered(MouseEvent e) {
				cboxCondicionesUso.setForeground(Color.blue);
			}

			public void mouseExited(MouseEvent e) {
				cboxCondicionesUso.setForeground(Color.black);
			}

		});

		cboxCondicionesUso.addItemListener((ItemListener) new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					bRegistrar.setEnabled(true);
					log.log(Level.FINE, "Las condiciones de uso han sido aceptadas. ");
				} else

					bRegistrar.setEnabled(false);
			}

		});

		// hasta aqui para editar los terminos y condiciones de uso

		/// Panel principal
		pnlMain.add(pnlIzquierda, BorderLayout.WEST);
		pnlMain.add(pnlDerecha, BorderLayout.EAST);
		pnlMain.add(pnlAbajo, BorderLayout.SOUTH);
		getContentPane().add(pnlMain);

		this.setVisible(true);

		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				new CiudadanoOInstitucion().setVisible(true);
				setVisible(false);
			}
		});

		ActionListener albRegistrar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Ciudadano ciudadanonuevo = new Ciudadano(tfNombre.getText(), tfApellidos.getText(), tfDNI.getText(),
						tfDireccion.getText(), Integer.parseInt(tfCodigoPostal.getText()),
						Integer.parseInt(tfTelefono.getText()), FuncionesEspeciales
								.crearContraseña("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789", ""));
				if (FuncionesEspeciales.DuplicadoUsuario(tfDNI.getText())) {
					JOptionPane.showMessageDialog(null, "Ese número de DNI ya ha sido usado");
				}

				else if (FuncionesEspeciales.DuplicadoTelefono(Integer.parseInt(tfTelefono.getText()))) {
					JOptionPane.showMessageDialog(null, "Ese número de teléfono ya ha sido usado");
				}

				else {
					BDCiudadano.InsertarCiudadano(ciudadanonuevo);
					JOptionPane
							.showMessageDialog(null,
									"El nombre de usuario es " + ciudadanonuevo.getaTelefono() + "\nY la contraseña es "
											+ ciudadanonuevo.getaContrasenya(),
									"Apunta", JOptionPane.INFORMATION_MESSAGE);
					new IniciarSesion().setVisible(true);
					setVisible(false);
					log.log(Level.INFO, "Se ha registrado como ciudadano. ");


				}

			}

		};

		bRegistrar.addActionListener(albRegistrar);

	}

}
