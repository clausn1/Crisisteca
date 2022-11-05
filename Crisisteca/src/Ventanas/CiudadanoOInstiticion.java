package Ventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CiudadanoOInstiticion extends JFrame{

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new CiudadanoOInstiticion();
            }
            
		});

	}
	
	public CiudadanoOInstiticion() {
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Selección de tipo de Usuario");
		this.setBounds(100, 100, 1000, 700);
		this.setSize(400,100);
		
		JPanel pnlMain = new JPanel();
		JPanel pnlBotones= new JPanel();
		JLabel lblCiudadanoOInstitución = new JLabel("Selecciona el tipo de cuenta que quieres crear");
		JButton bCiudadano = new JButton("Ciudadano");
		JButton bInstitucion = new JButton("Institución");
		
		bCiudadano.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				 CiudadanoOInstiticion().dispose();
				new Registrarse().setVisible(true);

				
			}
					
			
		});
		
		

		pnlBotones.add(bCiudadano);
		pnlBotones.add(bInstitucion);		
		pnlMain.add(lblCiudadanoOInstitución, BorderLayout.NORTH);
		pnlMain.add(pnlBotones, BorderLayout.SOUTH);
		getContentPane().add(pnlMain);
		
		setVisible(true);

		
	}
	
	

	
	
	
	
	
	
	
	
	

}
