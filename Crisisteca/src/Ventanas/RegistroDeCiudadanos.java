package Ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import BasesDeDatos.BDCiudadano;
import BasesDeDatos.BDEmergencias;
import Entidades.Institucion;

public class RegistroDeCiudadanos extends JFrame {

	public RegistroDeCiudadanos(Institucion institucion) throws SQLException {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Ciudadanos registrados en el servicio");
		this.setBounds(300, 5, 1000, 700);
		this.setSize(700, 700);
		this.setResizable(true);
		
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
				new InformacionORegistroCiudadanos(institucion).setVisible(true);
                setVisible(false);
            }
        });

		// panel donde se van a mostrar los datos
		DefaultTableModel tInformacion = new DefaultTableModel();
		tInformacion.addColumn("DNI");
		tInformacion.addColumn("Nombre");
		tInformacion.addColumn("Apellidos");
		tInformacion.addColumn("Dirección");
		tInformacion.addColumn("Codigo Postal");
		tInformacion.addColumn("Teléfono");

		// Metemos los valores de la base de datos en la tabla
		Statement st = BDCiudadano.initBD();
		ResultSet rs = st.executeQuery(
				"SELECT DNI, Nombre, Apellidos, Direccion, CodigoPostal, Telefono Fecha FROM Ciudadano ORDER BY DNI DESC");

		while (rs.next()) {
			Object[] fila = new Object[6];

			for (int i = 0; i < 6; i++)
				fila[i] = rs.getObject(i + 1);

			tInformacion.addRow(fila);
		}

		JTable tabla = new JTable(tInformacion);
		TableRowSorter<DefaultTableModel> ordenaLaTabla = new TableRowSorter<DefaultTableModel>(tInformacion);
		tabla.setRowSorter(ordenaLaTabla);
		
		
		JPanel pnlMain = new JPanel();
		pnlMain.add(tabla);
		getContentPane().add(pnlMain);
		setVisible(true);

	}

}
