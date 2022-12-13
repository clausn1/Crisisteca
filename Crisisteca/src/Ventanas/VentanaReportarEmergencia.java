package Ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class VentanaReportarEmergencia extends JFrame{
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new VentanaReportarEmergencia();
			}
		});
	}
	
	private JComboBox<String> comboxTipoEmergencia;
	private JComboBox<Integer> comboxCodigoPostal;
	private JComboBox<String> comboxCalle;
	private JCheckBox cboxAvisar ;
	private JTextArea taDetalles;
	
	public VentanaReportarEmergencia() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Reportar Emergencia");
		this.setBounds(1000, 600, 1000, 700);
		this.setSize(1500,500);
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
		
		pnlCentro.setLayout(new BorderLayout());
		pnlIzquierda.setLayout(new BoxLayout(pnlIzquierda, BoxLayout.Y_AXIS));
		pnlDerecha.setLayout(new BoxLayout(pnlDerecha, BoxLayout.Y_AXIS));
		pnlAbajo.setLayout(new BoxLayout(pnlAbajo, BoxLayout.X_AXIS));
		pnlArriba.setLayout(new GridLayout(0,3));
		
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
		
		
		
		
		comboxCalle = new JComboBox<>();
		comboxCalle.hide();
		comboxCalle.setEnabled(false);
		comboxCodigoPostal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			comboxCalle.show();	
			comboxCalle.removeAllItems();
				Integer itemSeleecionado = (Integer)comboxCodigoPostal.getSelectedItem();
				if(48001==itemSeleecionado) {
					 try (BufferedReader br = new BufferedReader (new FileReader ("res/calles/CPBilbao/48001.txt"))) {
						for (String line = br.readLine(); line != null; line = br.readLine()) {
							 comboxCalle.addItem(line);
						 }
					} catch (FileNotFoundException e1) {
						System.out.println("no hay calles en este codigo postal");
					} catch (IOException e1) {
						System.out.println("El archivo no se puede leer");
					}
					comboxCalle.setEnabled(true);

				}else if(48002==itemSeleecionado){
					 try (BufferedReader br = new BufferedReader (new FileReader ("res/calles/CPBilbao/48002.txt"))) {
						for (String line = br.readLine(); line != null; line = br.readLine()) {
							 comboxCalle.addItem(line);
						 }
					} catch (FileNotFoundException e1) {
						System.out.println("no hay calles en este codigo postal");
					} catch (IOException e1) {
						System.out.println("El archivo no se puede leer");
					}
					comboxCalle.setEnabled(true);

				}else if(48003==itemSeleecionado){
					 try (BufferedReader br = new BufferedReader (new FileReader ("res/calles/CPBilbao/48003.txt"))) {
						for (String line = br.readLine(); line != null; line = br.readLine()) {
							 comboxCalle.addItem(line);
						 }
					} catch (FileNotFoundException e1) {
						System.out.println("no hay calles en este codigo postal");
					} catch (IOException e1) {
						System.out.println("El archivo no se puede leer");
					}
					comboxCalle.setEnabled(true);

				}else if(48004==itemSeleecionado){
					 try (BufferedReader br = new BufferedReader (new FileReader ("res/calles/CPBilbao/48004.txt"))) {
						for (String line = br.readLine(); line != null; line = br.readLine()) {
							 comboxCalle.addItem(line);
						 }
					} catch (FileNotFoundException e1) {
						System.out.println("no hay calles en este codigo postal");
					} catch (IOException e1) {
						System.out.println("El archivo no se puede leer");
					}
					comboxCalle.setEnabled(true);

				}else if(48005==itemSeleecionado){
					 try (BufferedReader br = new BufferedReader (new FileReader ("res/calles/CPBilbao/48005.txt"))) {
						for (String line = br.readLine(); line != null; line = br.readLine()) {
							 comboxCalle.addItem(line);
						 }
					} catch (FileNotFoundException e1) {
						System.out.println("no hay calles en este codigo postal");
					} catch (IOException e1) {
						System.out.println("El archivo no se puede leer");
					}
					comboxCalle.setEnabled(true);

				}else if(48006==itemSeleecionado){
					 try (BufferedReader br = new BufferedReader (new FileReader ("res/calles/CPBilbao/48006.txt"))) {
						for (String line = br.readLine(); line != null; line = br.readLine()) {
							 comboxCalle.addItem(line);
						 }
					} catch (FileNotFoundException e1) {
						System.out.println("no hay calles en este codigo postal");
					} catch (IOException e1) {
						System.out.println("El archivo no se puede leer");
					}
					comboxCalle.setEnabled(true);

				}else if(48007==itemSeleecionado){
					 try (BufferedReader br = new BufferedReader (new FileReader ("res/calles/CPBilbao/48007.txt"))) {
						for (String line = br.readLine(); line != null; line = br.readLine()) {
							 comboxCalle.addItem(line);
						 }
					} catch (FileNotFoundException e1) {
						System.out.println("no hay calles en este codigo postal");
					} catch (IOException e1) {
						System.out.println("El archivo no se puede leer");
					}
					comboxCalle.setEnabled(true);

				}else if(48008==itemSeleecionado){
					 try (BufferedReader br = new BufferedReader (new FileReader ("res/calles/CPBilbao/48008.txt"))) {
						for (String line = br.readLine(); line != null; line = br.readLine()) {
							 comboxCalle.addItem(line);
						 }
					} catch (FileNotFoundException e1) {
						System.out.println("no hay calles en este codigo postal");
					} catch (IOException e1) {
						System.out.println("El archivo no se puede leer");
					}
					comboxCalle.setEnabled(true);

				}else if(48009==itemSeleecionado){
					 try (BufferedReader br = new BufferedReader (new FileReader ("res/calles/CPBilbao/48009.txt"))) {
						for (String line = br.readLine(); line != null; line = br.readLine()) {
							 comboxCalle.addItem(line);
						 }
					} catch (FileNotFoundException e1) {
						System.out.println("no hay calles en este codigo postal");
					} catch (IOException e1) {
						System.out.println("El archivo no se puede leer");
					}
					comboxCalle.setEnabled(true);

				}else if(48010==itemSeleecionado){
					 try (BufferedReader br = new BufferedReader (new FileReader ("res/calles/CPBilbao/48010.txt"))) {
						for (String line = br.readLine(); line != null; line = br.readLine()) {
							 comboxCalle.addItem(line);
						 }
					} catch (FileNotFoundException e1) {
						System.out.println("no hay calles en este codigo postal");
					} catch (IOException e1) {
						System.out.println("El archivo no se puede leer");
					}
					comboxCalle.setEnabled(true);

				}else if(48011==itemSeleecionado){
					 try (BufferedReader br = new BufferedReader (new FileReader ("res/calles/CPBilbao/48011.txt"))) {
						for (String line = br.readLine(); line != null; line = br.readLine()) {
							 comboxCalle.addItem(line);
						 }
					} catch (FileNotFoundException e1) {
						System.out.println("no hay calles en este codigo postal");
					} catch (IOException e1) {
						System.out.println("El archivo no se puede leer");
					}
					comboxCalle.setEnabled(true);

				}else if(48012==itemSeleecionado){
					 try (BufferedReader br = new BufferedReader (new FileReader ("res/calles/CPBilbao/48012.txt"))) {
						for (String line = br.readLine(); line != null; line = br.readLine()) {
							 comboxCalle.addItem(line);
						 }
					} catch (FileNotFoundException e1) {
						System.out.println("no hay calles en este codigo postal");
					} catch (IOException e1) {
						System.out.println("El archivo no se puede leer");
					}
					comboxCalle.setEnabled(true);

				}
				
			}
		});
		
		pnlArriba.add(lblLugar);
		pnlArriba.add(comboxCodigoPostal);
		pnlArriba.add(comboxCalle);
		
		
		
		//Panel izquierda
		

		JLabel lblTipoEmergencia = new JLabel("Seleccione el tipo de emergencia: ");
		lblTipoEmergencia.setFont(new Font("Arial", Font.PLAIN, 30));
		JLabel lblReportar = new JLabel("¿Desea reportar la emergencia a las autoridades y al resto de usuarios?");
		lblReportar.setFont(new Font("Arial", Font.PLAIN, 30));
		JLabel lblDetalles= new JLabel("¿Desea añadir algun tipo de información? ");
		lblDetalles.setFont(new Font("Arial", Font.PLAIN, 30));
		
		
		
		pnlIzquierda.add(lblTipoEmergencia);
		pnlIzquierda.add(lblReportar);
		
		
		//Panel derecha
		
		comboxTipoEmergencia = new JComboBox<>();
		comboxTipoEmergencia.addItem("Coche");
		comboxTipoEmergencia.addItem("Robo");
		comboxTipoEmergencia.addItem("Violencia");
		taDetalles = new JTextArea();
		taDetalles.setLineWrap(true);
		taDetalles.setWrapStyleWord(true);

		cboxAvisar = new JCheckBox();
		

		taDetalles.setFont(new Font("Arial", Font.PLAIN, 20));
		
		
		
		pnlDerecha.add(comboxTipoEmergencia);
		pnlDerecha.add(cboxAvisar);
		
		
		pnlAbajo.add(lblDetalles);
		pnlAbajo.add(taDetalles);
		
		
		//Panel Principal
		pnlCentro.add(pnlIzquierda, BorderLayout.WEST);
		pnlCentro.add(pnlDerecha, BorderLayout.EAST);
		pnlCentro.add(pnlAbajo,BorderLayout.SOUTH);
		pnlCentro.add(pnlArriba, BorderLayout.NORTH);
		getContentPane().add(pnlCentro);
		
		this.setVisible(true);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
