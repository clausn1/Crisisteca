package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import BasesDeDatos.BDCiudadano;
import BasesDeDatos.BDInstitucion;
import Entidades.Ciudadano;
import Entidades.Institucion;
import Principal.FuncionesEspeciales;

public class RegistrarseInstitucion extends JFrame {

	static Logger log;


	private JTextField tfNombre;
	private JTextField tfEmail;
	private JTextField tfTelefono;
	private JFrame tyc;

	public RegistrarseInstitucion() {
		log = Logger.getLogger("programLogger");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Registrarse como Institución");
		this.setBounds(100, 100, 1000, 700);
		this.setSize(600, 250);
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
		pnlAbajo.setLayout(new BoxLayout(pnlAbajo, BoxLayout.X_AXIS));

		/// Panel de la Izquierda

		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 30));
		JLabel lblEmail = new JLabel("E-mail: ");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 30));
		JLabel lblTelefono = new JLabel("Teléfono: ");
		lblTelefono.setFont(new Font("Arial", Font.PLAIN, 30));

		pnlIzquierda.add(lblNombre);
		pnlIzquierda.add(lblEmail);
		pnlIzquierda.add(lblTelefono);

		/// Panel de la Derecha

		tfNombre = new JTextField(20);
		tfEmail = new JTextField(20);
		tfTelefono = new JTextField(20);

		tfTelefono.addKeyListener(new KeyAdapter() {
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
		tfEmail.setFont(new Font("Arial", Font.PLAIN, 20));
		tfTelefono.setFont(new Font("Arial", Font.PLAIN, 20));

		pnlDerecha.add(tfNombre);
		pnlDerecha.add(tfEmail);
		pnlDerecha.add(tfTelefono);

		/// Panel abajo
		JCheckBox cboxCondicionesUso = new JCheckBox("Acepto los términos de uso");
		cboxCondicionesUso.setFont(new Font("Arial", Font.PLAIN, 20));
		pnlAbajo.add(cboxCondicionesUso, BorderLayout.EAST);

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
					terminos.setText("USO NO AUTORIZADO\n" + "\n"
							+ "En caso de que aplique (para venta de informacion extraida de los datos recogidos por nuestro programa) usted no puede colocar uno de nuestros productos, modificado o sin modificar, en un CD, sitio web o ningún otro medio y ofrecerlos para la redistribución o la reventa de ningún tipo.\n"
							+ "\nPROPIEDAD\n" + "\n"
							+ "Usted no puede declarar propiedad intelectual o exclusiva a ninguno de nuestros productos, modificado o sin modificar. Todos los productos son propiedad  de los proveedores del contenido. En caso de que no se especifique lo contrario, nuestro producto esta diseñado para uso unico entre el usuario y el programa mismo. Por lo que la venta o distribucion de cualquier tipo de información extraída de nuestro programa, podra repercutir en acciones legales en su contra.");
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

		// hasta aqui para editar los terminos y condiciones de uso

		JButton bRegistrar = new JButton("Registrar");
		bRegistrar.setEnabled(false);
		pnlAbajo.add(bRegistrar, BorderLayout.SOUTH);

		/// Panel principal
		pnlMain.add(pnlIzquierda, BorderLayout.WEST);
		pnlMain.add(pnlDerecha, BorderLayout.EAST);
		pnlMain.add(pnlAbajo, BorderLayout.SOUTH);
		getContentPane().add(pnlMain);

		setVisible(true);
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

		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				new CiudadanoOInstitucion().setVisible(true);
				setVisible(false);
			}
		});

		ActionListener albRegistrar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Institucion institucionnueva = new Institucion(FuncionesEspeciales.crearCodigo(tfNombre.getText(), ""),
						tfNombre.getText(), tfEmail.getText(), Integer.parseInt(tfTelefono.getText()),
						FuncionesEspeciales
								.crearContraseña("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789", ""));
				BDInstitucion.InsertarInstitucion(institucionnueva);
				JOptionPane.showMessageDialog(null, "El código es " + institucionnueva.getaCodigo()
						+ "\n Y la contraseña es " + institucionnueva.getaContrasenya());
				new IniciarSesion().setVisible(true);
				setVisible(false);
				log.log(Level.INFO, "Se ha registrado como institucion.");
			}
		};

		bRegistrar.addActionListener(albRegistrar);

	}

}
