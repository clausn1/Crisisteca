package Ventanas;


import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


import BasesDeDatos.BDEmergencias;
import Entidades.Ciudadano;
import Entidades.Emergencias;


public class VentanaReportarEmergencia extends JFrame{
	
	static Logger log;
//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				new VentanaReportarEmergencia(ciudadano);
//			}
//		});
//	}
	
	private JComboBox<String> comboxTipoEmergencia;
	private JComboBox<Integer> comboxCodigoPostal;
	private JComboBox<String> comboxCalle;
	private JCheckBox cboxAvisar ;
	private JTextArea taDetalles;
	
	public VentanaReportarEmergencia(Ciudadano ciudadano) {
		log = Logger.getLogger("programLogger");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Reportar Emergencia");
		this.setBounds(100, 100, 1000, 700);
		this.setSize(1200,400);
		this.setResizable(false);
		this.getContentPane().setLayout(new FlowLayout());
		this.setLocationRelativeTo(null);
	
		
		//intento de crear un gridlayout para una interfaz mas presentable
		
		
		
		
		
		
		
		
		
		//Paneles 
		JPanel pnlCentro = new JPanel();
		JPanel pnlIzquierda = new JPanel();
		JPanel pnlDerecha = new JPanel();
		JPanel pnlAbajo = new JPanel();
		JPanel pnlArriba = new JPanel();
		JPanel pnlReportar = new JPanel();
		
		
		pnlCentro.setLayout(new BorderLayout());
		pnlIzquierda.setLayout(new BoxLayout(pnlIzquierda, BoxLayout.Y_AXIS));
		pnlDerecha.setLayout(new BoxLayout(pnlDerecha, BoxLayout.Y_AXIS));
		pnlAbajo.setLayout(new BorderLayout());
		pnlArriba.setLayout(new GridLayout(0,4));
		
		//panel arriba
		JLabel lblLugar = new JLabel("Lugar: ");
		lblLugar.setFont(new Font("Arial", Font.PLAIN, 30));
		
		comboxCodigoPostal = new JComboBox<>();
		comboxCodigoPostal.addItem(48001);
		comboxCodigoPostal.addItem(48002);
		comboxCodigoPostal.addItem(48003);
		comboxCodigoPostal.addItem(48004);
		comboxCodigoPostal.addItem(48005);
		comboxCodigoPostal.addItem(48006);
		comboxCodigoPostal.addItem(48007);
		comboxCodigoPostal.addItem(48008);
		comboxCodigoPostal.addItem(48009);
		comboxCodigoPostal.addItem(48010);
		comboxCodigoPostal.addItem(48011);
		comboxCodigoPostal.addItem(48012);
		
		
		JTextField numero=  new JTextField();
		
		numero.hide();
		numero.addKeyListener(new java.awt.event.KeyAdapter() {
		    public void keyTyped(java.awt.event.KeyEvent evt) {
		        if(numero.getText().length()>=50&&!(evt.getKeyChar()==KeyEvent.VK_DELETE||evt.getKeyChar()==KeyEvent.VK_BACK_SPACE)) {
		            getToolkit().beep();
		            evt.consume();
		         }
		     }
		});
	
		
		comboxCalle = new JComboBox<>();
		comboxCalle.hide();
		comboxCalle.setEnabled(false);
		
		comboxCodigoPostal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			comboxCalle.show();
			numero.show();
			comboxCalle.removeAllItems();
				Integer itemSeleecionado = (Integer)comboxCodigoPostal.getSelectedItem();
				for(int i=1;i<13;i++) {
					if (i<10) {
				if(48000+i==itemSeleecionado) {
					 try (BufferedReader br = new BufferedReader (new FileReader ("res/calles/CPBilbao/4800"+i+".txt"))) {
						for (String line = br.readLine(); line != null; line = br.readLine()) {
							 comboxCalle.addItem(line);
						 }
					} catch (Exception e1) {
						log.log(Level.WARNING, "No se ha podido acceder al archivo con el codigo postal indicado.");
					}
					comboxCalle.setEnabled(true);
				}
					}else {
						if(48000+i==itemSeleecionado) {
							 try (BufferedReader br = new BufferedReader (new FileReader ("res/calles/CPBilbao/480"+i+".txt"))) {
								for (String line = br.readLine(); line != null; line = br.readLine()) {
									 comboxCalle.addItem(line);
								 }
								} catch (Exception e1) {
									log.log(Level.WARNING, "No se ha podido acceder al archivo con el codigo postal indicado.");
								}
							comboxCalle.setEnabled(true);
						}	
					}
				

				}
			}
		});
		




		
		
		
		pnlArriba.add(lblLugar);
		pnlArriba.add(comboxCodigoPostal);
		pnlArriba.add(comboxCalle);
		pnlArriba.add(numero);
		
		
		//Panel izquierda
		


		JLabel lblTipoEmergencia = new JLabel("Seleccione el tipo de emergencia: ");
		lblTipoEmergencia.setFont(new Font("Arial", Font.PLAIN, 30));
		JLabel lblReportar = new JLabel("¿Desea reportar la emergencia a las autoridades y al resto de usuarios?");
		lblReportar.setFont(new Font("Arial", Font.PLAIN, 30));
		lblTipoEmergencia.setAlignmentY(BOTTOM_ALIGNMENT);
		lblReportar.setAlignmentX(CENTER_ALIGNMENT);
		
		
		
		pnlIzquierda.add(lblTipoEmergencia);
		pnlIzquierda.add(lblReportar);
		pnlIzquierda.add(Box.createVerticalGlue());
		
		//Panel derecha
		
		comboxTipoEmergencia = new JComboBox<>();
		comboxTipoEmergencia.addItem("Coche");
		comboxTipoEmergencia.addItem("Robo");
		comboxTipoEmergencia.addItem("Violencia");
		comboxTipoEmergencia.setAlignmentY(BOTTOM_ALIGNMENT);
		comboxTipoEmergencia.setAlignmentX(CENTER_ALIGNMENT);


		cboxAvisar = new JCheckBox();
		cboxAvisar.setAlignmentY(CENTER_ALIGNMENT);


		
		
		
		
		pnlDerecha.add(comboxTipoEmergencia);
		pnlDerecha.add(Box.createVerticalGlue());
		pnlDerecha.add(Box.createVerticalGlue());
		pnlDerecha.add(cboxAvisar);
		pnlDerecha.add(Box.createVerticalGlue());
		
		
	
		//panel de abajo
		JLabel lblDetalles= new JLabel("¿Desea añadir algun tipo de información sobre el accidente? ");
		lblDetalles.setFont(new Font("Arial", Font.PLAIN, 30));				
		taDetalles = new JTextArea();
		taDetalles.setLineWrap(true);
		taDetalles.setWrapStyleWord(true);
		taDetalles.addKeyListener(new java.awt.event.KeyAdapter() {
		    public void keyTyped(java.awt.event.KeyEvent evt) {
		        if(taDetalles.getText().length()>=500&&!(evt.getKeyChar()==KeyEvent.VK_DELETE||evt.getKeyChar()==KeyEvent.VK_BACK_SPACE)) {
		            getToolkit().beep();
		            evt.consume();
		         }
		     }
		});
		taDetalles.setFont(new Font("Arial", Font.PLAIN, 20));
		
		
		
		JButton bReportar= new JButton("Reportar emergencia");
		
		ActionListener albReportar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 long millis = System.currentTimeMillis();
				Calendar calendar = Calendar.getInstance();
				  calendar.setTimeInMillis(millis);
				 String fechaYHora=new String(calendar.get(Calendar.YEAR)+"-"+calendar.get(Calendar.MONTH)+1+"-"+calendar.get(Calendar.DAY_OF_MONTH)  +" " +calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE)+":"+calendar.get(calendar.SECOND));
				 Emergencias emergenciaNueva= new Emergencias(Integer.parseInt(comboxCodigoPostal.getSelectedItem().toString()),comboxCalle.getSelectedItem().toString()+"-"+numero.getSelectedText(), comboxTipoEmergencia.getSelectedItem().toString(),ciudadano.getaTelefono(), cboxAvisar.isSelected(), taDetalles.getText(),fechaYHora );
				 BDEmergencias.InsertarEmergencia(emergenciaNueva);
				 JOptionPane.showMessageDialog(null, "La emergencia ha sido reportada ");
				 log.log(Level.INFO,"Se ha reportado una emergencia:" + (new Date()));
			}
			
			
		};
		bReportar.addActionListener(albReportar);
		
		
		
		pnlAbajo.add(lblDetalles, BorderLayout.NORTH);
		


		pnlAbajo.add(taDetalles, BorderLayout.CENTER);
		pnlAbajo.add(Box.createVerticalGlue(), BorderLayout.SOUTH);
		pnlAbajo.add(Box.createVerticalGlue(), BorderLayout.SOUTH);
		pnlAbajo.add(bReportar, BorderLayout.SOUTH);
		
		//Panel Principal
		pnlCentro.add(pnlReportar, BorderLayout.SOUTH);
		pnlCentro.add(pnlIzquierda, BorderLayout.WEST);
		pnlCentro.add(pnlDerecha, BorderLayout.CENTER);
		pnlCentro.add(pnlAbajo,BorderLayout.SOUTH);
		pnlCentro.add(pnlArriba, BorderLayout.NORTH);
		getContentPane().add(pnlCentro);
		
		this.setVisible(true);
		
		addWindowListener(new java.awt.event.WindowAdapter() {
	        public void windowClosing(java.awt.event.WindowEvent e) {
					new ReportarEmergenciasOEmergencias(ciudadano).setVisible(true);
	            setVisible(false);
	        }
	    });
		
	
		
	}


}



