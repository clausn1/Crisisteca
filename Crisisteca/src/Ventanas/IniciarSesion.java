package Ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.print.attribute.standard.PrinterStateReason;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Principal.FuncionesEspeciales;

public class IniciarSesion extends JFrame{

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
            	
                new IniciarSesion();
            }
            
		});

	}
	
	
	
			static Logger log;
	private JTextField tfUsuario;
	private JTextField tfContrasenya;
	
	
	public IniciarSesion() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Iniciar sesión");
		this.setBounds(1000, 600, 1000, 700);
		this.setSize(600,200);
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

		JLabel lblUsuario = new JLabel("Usuario: ");
		lblUsuario.setFont(new Font("Arial", Font.PLAIN, 30));
		JLabel lblContrasenya = new JLabel("Contraseña: ");
		lblContrasenya.setFont(new Font("Arial", Font.PLAIN, 30));
		
		tfUsuario = new JTextField(15);
		tfUsuario.setFont(new Font("Arial", Font.PLAIN, 20));
		tfContrasenya= new JTextField(15);
		tfContrasenya.setFont(new Font("Arial", Font.PLAIN, 20));

		pnlIzquierda.add(lblUsuario);
		pnlIzquierda.add(lblContrasenya);
		pnlDerecha.add(tfUsuario);
		pnlDerecha.add(tfContrasenya);
		
        JButton bIniciarsesion = new JButton("Iniciar sesión");
        pnlAbajo.add(bIniciarsesion);
		bIniciarsesion.setPreferredSize(new Dimension(400,50));
		bIniciarsesion.setFont(new Font("Arial", Font.PLAIN, 30));

		pnlMain.add(pnlIzquierda, BorderLayout.WEST);
		pnlMain.add(pnlDerecha, BorderLayout.EAST);
		pnlMain.add(pnlAbajo, BorderLayout.SOUTH);

		getContentPane().add(pnlMain);
		
		this.setVisible(true);

		ActionListener albIniciarsesion = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String Usuario = tfUsuario.getText() ;
				String Contrasenya = tfContrasenya.getText();
				log= Logger.getLogger("programLogger");
				if (FuncionesEspeciales.ExisteUsuario(Usuario,Contrasenya)==0) {
					log.log(Level.INFO, "El usuario"+Usuario+" ha iniciado sesion como Ciudadano:"+ (new Date()));
					System.out.println("Se ha iniciado sesión como Ciudadano");
					try {
						new ReportarEmergenciasOEmergencias(FuncionesEspeciales.devolverCiudadano(Integer.parseInt(Usuario))).setVisible(true);
						setVisible(false);
					} catch (NumberFormatException e1) {
						log.log(Level.SEVERE, "Error en abrir la ventana de usuario de ciudadano");
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						log.log(Level.SEVERE, "Error en abrir la ventana de usuario de ciudadano");
						e1.printStackTrace();
					} catch (SQLException e1) {
						log.log(Level.SEVERE, "Error en abrir la ventana de usuario de ciudadano");
						e1.printStackTrace();
					}

											
				}
				else if (FuncionesEspeciales.ExisteUsuario(Usuario,Contrasenya)==1) {
					log.log(Level.INFO, "El usuario"+Usuario+" ha iniciado sesion como Institucion:"+ (new Date()));
					System.out.println("Se ha iniciado sesión como Institucion");
					try {
						new InformacionORegistroCiudadanos(FuncionesEspeciales.devolverInstitucion(Usuario)).setVisible(true);
						setVisible(false);
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						log.log(Level.SEVERE, "Error en abrir la ventana de usuario de Institucion");
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						log.log(Level.SEVERE, "Error en abrir la ventana de usuario de Institucion");
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						log.log(Level.SEVERE, "Error en abrir la ventana de usuario de Institucion");
						e1.printStackTrace();
					}
				}
				else {
					log.log(null, Contrasenya);
					log.log(Level.INFO, "Se ha intentado iniciar sesion con una contraseña que no existe");
					System.out.println("No existe ese usuario con esa contraseña");
				}
				
			}
		};  
    
		bIniciarsesion.addActionListener(albIniciarsesion);
		
		
		
		
		
		
	}
	
	

}