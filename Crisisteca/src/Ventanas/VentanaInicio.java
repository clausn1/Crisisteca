package Ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class VentanaInicio extends JFrame {
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new VentanaInicio();
			}
		});
	}
	
	public VentanaInicio() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		this.getContentPane().setLayout(new BorderLayout());
		this.setBounds(100, 100, 1000, 700);                    
		this.setSize(400,150);  
		getContentPane().setLayout(new FlowLayout());  
		this.setLocationRelativeTo(null);              
		this.setTitle("Crisisteca");  
		this.setResizable(false);
		
		//Panel texto inicio prueba
		JPanel pnl_text = new JPanel();
		JPanel pnl_main = new JPanel();
		JPanel pnl_botones = new JPanel();
		JPanel pnl_izquierda = new JPanel();
		JPanel pnl_derecha = new JPanel();
		
		JLabel lblTexto = new JLabel("Bienvenido a Crisisteca");
		Font bold = new Font ("BoldFont", Font.BOLD,25);
		lblTexto.setFont(bold);
		JButton btnRegistrarse = new JButton("Registrarse");
		JButton btnInicSesion = new JButton("Iniciar Sesión");
		
		
		pnl_text.add(lblTexto);
		pnl_izquierda.add(btnInicSesion);
		pnl_derecha.add(btnRegistrarse);
		pnl_botones.add(pnl_derecha,BorderLayout.WEST); 
		pnl_botones.add(pnl_izquierda,BorderLayout.EAST);
		pnl_main.add(pnl_botones);
		
		add(pnl_text, BorderLayout.NORTH);
		add(pnl_main, BorderLayout.SOUTH);
		
		setVisible(true);
		
		
		
		 ActionListener albRegistrarse = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new CiudadanoOInstitucion().setVisible(true);
					setVisible(false);
					
				}
			};
			
			
			
		btnRegistrarse.addActionListener(albRegistrarse);
			
			 ActionListener albIniciarSesion = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new IniciarSesion().setVisible(true);
				setVisible(false);
				
			}
		};
		
		btnInicSesion.addActionListener(albIniciarSesion);
		
		
	}


		
		
		
	
		
	
	
	
}

