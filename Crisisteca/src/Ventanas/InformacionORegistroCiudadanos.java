package Ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JButton;

public class InformacionORegistroCiudadanos extends JFrame{

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new InformacionORegistroCiudadanos();
            }
		});
		
		
	}
	
	public InformacionORegistroCiudadanos() {
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


        
        
//        ActionListener albReportarEmergencia = new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				new VentanaReportarEmergencia().setVisible(true);
//				setVisible(false);
//				
//			}
//		};
//	

			


	 


	
	
	
	
	
	}	

	
}
