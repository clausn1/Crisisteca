package Ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CiudadanoOInstitucion extends JFrame{

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new CiudadanoOInstitucion();
            }
		});
	}
	
	public CiudadanoOInstitucion() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Escoger tipo de usuario");
        this.setBounds(100, 100, 1000, 700);
		this.setSize(400,100);
		
        JButton bCiudadano = new JButton("Ciudadano");
        JButton bInstitucion = new JButton("Institución");

        JPanel pnlMain = new JPanel();
        JPanel pnlBotones = new JPanel();
        
        pnlBotones.add(bCiudadano);
        pnlBotones.add(bInstitucion);
        pnlMain.add(pnlBotones);
        getContentPane().add(pnlMain);
		
        setVisible(true);
		
        ActionListener albCiudadano = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new RegistrarseCiudadano().setVisible(true);
				
			}
		};
		
		bCiudadano.addActionListener(albCiudadano);
		
		 ActionListener albInstitucion = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new RegistrarseInstitucion().setVisible(true);
					
				}
			};
			
			bInstitucion.addActionListener(albInstitucion);
		
	}
	
	
	
	
	
	
	
	
	
	

}
