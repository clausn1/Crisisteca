package Ventanas;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class InformacionDeInteres extends JFrame{
	
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new InformacionDeInteres();
            }
		});
		
		
	}
	
	public InformacionDeInteres() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Busque la información como desee");
		this.setBounds(300, 5, 1000, 700);
        this.setSize(700,700);
		this.setResizable(false);
		
		
		
		JButton bOrdenar = new JButton("Ordenar busqueda");
		JButton bFiltrar = new JButton("Filtrar busqueda");
		JButton bLimpiar = new JButton("Limpiar busqueda");
		
	
		
		// panel de los botones de busqueda
		JPanel pnlBotones = new JPanel();
		pnlBotones.add(bOrdenar);
		pnlBotones.add(bFiltrar);
		
		
		
		//panel donde se van a mostrar los datos
		DefaultTableModel tInformacion = new DefaultTableModel();
		tInformacion.addColumn("Codigo Postal");
		tInformacion.addColumn("Tipo de accidente");
		tInformacion.addColumn("Fecha y hora");
	
		JTable tabla = new JTable(tInformacion);
		
	
		//panel principal
		JPanel pnlMain = new JPanel();
		pnlMain.setLayout(new BorderLayout());
		pnlMain.add(pnlBotones, BorderLayout.NORTH);
		pnlMain.add(bLimpiar, BorderLayout.SOUTH);
		pnlMain.add(new JScrollPane(tabla), BorderLayout.CENTER);

		
		
		getContentPane().add(pnlMain);
		setVisible(true);
	}
	
	
	
	
	
	

}
