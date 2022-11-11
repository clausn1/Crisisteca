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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Escoger tipo de usuario");
        setBounds(550, 250, 1000, 700);
		setSize(400,100);
        setResizable(false);

		
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
				setVisible(false);
				
			}
		};
		
		bCiudadano.addActionListener(albCiudadano);
		
		 ActionListener albInstitucion = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new RegistrarseInstitucion().setVisible(true);
					setVisible(false);
				}
			};
			
			bInstitucion.addActionListener(albInstitucion);
		
	}
	
	
	
	
	
	
	
	
	
	

}
