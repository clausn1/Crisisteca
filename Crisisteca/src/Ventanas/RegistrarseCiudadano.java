package Ventanas;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class RegistrarseCiudadano extends JFrame{

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new RegistrarseCiudadano();
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

	public RegistrarseCiudadano() {
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
//		JPanel pnlAbajoIzquierda = new JPanel();
//		JPanel pnlAbajoDerecha = new JPanel();

		
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
		tfApellidos= new JTextField(20);
		tfDNI = new JTextField(20);
		tfDireccion= new JTextField(20);
		tfCodigoPostal= new JTextField(20);
		tfEmail = new JTextField(20);
		tfTelefono= new JTextField(20);
		
		///Es otra manera de hacerlo, desactivando el textfield
//		tfCodigoPostal.addKeyListener(new KeyAdapter() { //https://www.tutorialspoint.com/how-can-we-make-jtextfield-accept-only-numbers-in-java
//		public void keyPressed(KeyEvent p) {
//            if (p.getKeyChar() >= '0' && p.getKeyChar() <= '9' || p.getKeyChar()==KeyEvent.VK_BACK_SPACE) {
//            	tfCodigoPostal.setEditable(true);
//            } else {
//            	tfCodigoPostal.setEditable(false);
//            }
//         }
//		public void keyTyped(KeyEvent t) {
//	        if (tfCodigoPostal.getText().length() >= 5 )
//	            t.consume(); 
//		}
//      	
//	});
		
		tfCodigoPostal.addKeyListener(new KeyAdapter() { //https://www.tutorialspoint.com/how-can-we-make-jtextfield-accept-only-numbers-in-java
		public void keyPressed(KeyEvent p) {
            if (p.getKeyChar() >= '0' && p.getKeyChar() <= '9' || p.getKeyChar()==KeyEvent.VK_BACK_SPACE) {
            	tfCodigoPostal.setEditable(true);

            } else {
            	tfCodigoPostal.setEditable(false);
                JOptionPane.showMessageDialog(null, "Recuerde no incluir letras");
           	
            }
         }
		
		public void keyTyped(KeyEvent t) {
	        if (tfCodigoPostal.getText().length() >= 5 )
	            t.consume(); 
		}
      	
	});
		

		tfTelefono.addKeyListener(new KeyAdapter() { //https://www.tutorialspoint.com/how-can-we-make-jtextfield-accept-only-numbers-in-java
		public void keyPressed(KeyEvent p) {
            if (p.getKeyChar() >= '0' && p.getKeyChar() <= '9' || p.getKeyChar()==KeyEvent.VK_BACK_SPACE) {
            	tfTelefono.setEditable(true);
            } else {
            	tfTelefono.setEditable(false);
                JOptionPane.showMessageDialog(null, "Recuerde no incluir letras");

            }
         }
		public void keyTyped(KeyEvent t) {
	        if (tfTelefono.getText().length() >= 9 )
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

		
		///Panel de condiciones de uso
        JCheckBox cboxCondicionesUso = new JCheckBox("Acepto los términos de uso");
        cboxCondicionesUso.setFont(new Font("Arial", Font.PLAIN, 20));
        pnlAbajo.add(cboxCondicionesUso);
        
        JButton bRegistrar = new JButton("Registrar");
        pnlAbajo.add(bRegistrar);

        
        
		/// Panel principal
		pnlMain.add(pnlIzquierda, BorderLayout.WEST);
		pnlMain.add(pnlDerecha, BorderLayout.EAST);
		pnlMain.add(pnlAbajo, BorderLayout.SOUTH);
		getContentPane().add(pnlMain);


		setVisible(true);
		
		
		
		
		
	}
	

}
