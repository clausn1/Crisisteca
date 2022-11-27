package Ventanas;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.WindowAdapter;
	import java.awt.event.WindowEvent;
	import java.awt.event.WindowListener;

	import javax.swing.*;

public class ReportarEmergenciasOEmergencias extends JFrame{

		public static void main(String[] args) {
			SwingUtilities.invokeLater(new Runnable() {

	            @Override
	            public void run() {
	                new ReportarEmergenciasOEmergencias();
	            }
			});
			
			
		}
		
		public ReportarEmergenciasOEmergencias() {
			this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			this.setTitle("Escoger que hacer");
			this.setBounds(550, 250, 1000, 700);
	        this.setSize(300,100);
			this.setResizable(false);

			
	        JButton bReportarEmergencia = new JButton("Reportar Emergencia");
	        JButton bEmergencias = new JButton("Emergencias");

	        JPanel pnlMain = new JPanel();
	        JPanel pnlBotones = new JPanel();
	        
	        pnlBotones.add(bReportarEmergencia);
	        pnlBotones.add(bEmergencias);
	        pnlMain.add(pnlBotones);
	        getContentPane().add(pnlMain);

	        setVisible(true);

	        addWindowListener(new java.awt.event.WindowAdapter() {
	                public void windowClosing(java.awt.event.WindowEvent e) {
	    				new VentanaInicio().setVisible(true);
	                    setVisible(false);
	                }
	            });
	        
	        
	        ActionListener albReportarEmergencia = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new VentanaReportarEmergencia().setVisible(true);
					setVisible(false);
					
				}
			};
		
			bReportarEmergencia.addActionListener(albReportarEmergencia);
			//crear ventana emergencias para poder usar esta parte del codigo
//			
//			ActionListener albEmergencias = new ActionListener() {
//					
//					@Override
//					public void actionPerformed(ActionEvent e) {
//						new Emergencias().setVisible(true);
//						setVisible(false);
//					}
//				};
//				
//			bEmergencias.addActionListener(albEmergencias);
				


		 


		
		
		
		
		
		}	

	}
