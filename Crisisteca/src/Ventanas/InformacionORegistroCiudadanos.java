package Ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Entidades.Institucion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

public class InformacionORegistroCiudadanos extends JFrame{

//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//
//            @Override
//            public void run() {
//                new InformacionORegistroCiudadanos();
//            }
//		});
//		
//		
//	}
	
	public InformacionORegistroCiudadanos(Institucion institucion) {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Escoger que hacer");
		this.setBounds(550, 250, 1000, 700);
        this.setSize(360,100);
		this.setResizable(false);

		
        JButton bInformacionInteres = new JButton("Información de interés");
        JButton bRegistroDeCiudadanos = new JButton("Registro de ciudadanos");

        JPanel pnlMain = new JPanel();
        JPanel pnlBotones = new JPanel();
        
        pnlBotones.add(bInformacionInteres);
        pnlBotones.add(bRegistroDeCiudadanos);
        pnlMain.add(pnlBotones);
        getContentPane().add(pnlMain);

        setVisible(true);


        ActionListener albInformacionInteres = new ActionListener() {
	

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					new InformacionDeInteres(institucion).setVisible(true);
					setVisible(false);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		};
		bInformacionInteres.addActionListener(albInformacionInteres);
	

			
		ActionListener albRegistroDeCiudadanos = new ActionListener() {
			

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new RegistroDeCiudadanos(institucion).setVisible(true);
					setVisible(false);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		};
		bRegistroDeCiudadanos.addActionListener(albRegistroDeCiudadanos);

	 


	
	
	
	
	
	}	

	
}
