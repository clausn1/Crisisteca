package Ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import BasesDeDatos.BDEmergencias;
import Entidades.Ciudadano;
import Entidades.Emergencias;
import Entidades.Institucion;

public class EmergenciasVentana extends JFrame {

	static Logger log;

	public EmergenciasVentana(Ciudadano ciudadano) throws SQLException {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Emergencias de interés");
		this.setBounds(300, 5, 1000, 700);
		this.setSize(700, 700);
		this.setResizable(false);

		JFrame fFiltros;

		// panel de los botones de busqueda
		JPanel pnlBotones = new JPanel();
		// frame de los filtros de busqueda
		fFiltros = new JFrame("Filtros de busqueda");
		fFiltros.setSize(new Dimension(500, 600));
		fFiltros.setVisible(false);
		fFiltros.setDefaultCloseOperation(HIDE_ON_CLOSE);
		JPanel mainPanel = new JPanel();
		JPanel filtrosPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(filtrosPanel, BorderLayout.CENTER);
		JButton bAplicar = new JButton("Aplicar los filtros seleccionados");
		mainPanel.add(bAplicar, BorderLayout.SOUTH);

		filtrosPanel.setLayout(new GridLayout(3, 0));

		JPanel filtroCPPanel = new JPanel();
		filtroCPPanel.setLayout(new GridLayout(6, 2));
		JPanel filtroTEPanel = new JPanel();
		filtroTEPanel.setLayout(new GridLayout(0, 3));
		JPanel filtroFYHPanel = new JPanel();
		filtroFYHPanel.setLayout(new GridLayout(3, 3));

		ArrayList<JCheckBox> arrayCP = new ArrayList<>();
		for (int i = 1; i < 13; i++) {
			JCheckBox cb = new JCheckBox();
			if (i < 10)
				cb.setLabel("4800" + i);
			else
				cb.setLabel("480" + i);
			cb.setSelected(true);
			arrayCP.add(cb);

		}
		for (JCheckBox cb : arrayCP)
			filtroCPPanel.add(cb);

		JCheckBox cbCoche = new JCheckBox("Coche");
		cbCoche.setSelected(true);
		JCheckBox cbRobo = new JCheckBox("Robo");
		cbRobo.setSelected(true);
		JCheckBox cbViolencia = new JCheckBox("Violencia");
		cbViolencia.setSelected(true);
		filtroTEPanel.add(cbCoche);
		filtroTEPanel.add(cbRobo);
		filtroTEPanel.add(cbViolencia);

		JComboBox<Integer> cbDesdeAño = new JComboBox<Integer>();
		cbDesdeAño.addItem(2020);
		cbDesdeAño.addItem(2021);
		cbDesdeAño.addItem(2022);
		cbDesdeAño.addItem(2023);

		JComboBox<Integer> cbHastaAño = new JComboBox<Integer>();
		cbHastaAño.addItem(2024);
		cbHastaAño.addItem(2023);
		cbHastaAño.addItem(2022);
		cbHastaAño.addItem(2021);
		cbHastaAño.addItem(2020);

		JComboBox<Integer> cbDesdeMes = new JComboBox<Integer>();
		JComboBox<Integer> cbHastaMes = new JComboBox<Integer>();
		for (int i = 1; i < 13; i++) {
			cbDesdeMes.addItem(i);
			cbHastaMes.addItem(i);
		}
		JComboBox<Integer> cbDesdeDia = new JComboBox<Integer>();
		JComboBox<Integer> cbHastaDia = new JComboBox<Integer>();
		for (int i = 1; i < 32; i++) {
			cbDesdeDia.addItem(i);
			cbHastaDia.addItem(i);
		}
		JTextField tfAño = new JTextField("Hasta el año:");
		tfAño.setEditable(false);
		JTextField tfMes = new JTextField("Hasta el mes:");
		tfMes.setEditable(false);
		JTextField tfDia = new JTextField("Hasta el dia:");
		tfDia.setEditable(false);
		filtroFYHPanel.add(cbDesdeAño);
		filtroFYHPanel.add(cbDesdeMes);
		filtroFYHPanel.add(cbDesdeDia);
		filtroFYHPanel.add(tfAño);
		filtroFYHPanel.add(tfMes);
		filtroFYHPanel.add(tfDia);
		filtroFYHPanel.add(cbHastaAño);
		filtroFYHPanel.add(cbHastaMes);
		filtroFYHPanel.add(cbHastaDia);

		filtrosPanel.add(filtroCPPanel);
		filtrosPanel.add(filtroTEPanel);
		filtrosPanel.add(filtroFYHPanel);

		fFiltros.getContentPane().add(mainPanel);

		// panel donde se van a mostrar los datos
		DefaultTableModel tInformacion = new DefaultTableModel();
		tInformacion.addColumn("Codigo Postal");
		tInformacion.addColumn("Tipo de accidente");
		tInformacion.addColumn("Fecha y hora");

		// Metemos los valores de la base de datos en la tabla
		Statement st = BDEmergencias.initBD();
		ResultSet rs = st
				.executeQuery("SELECT CodigoPostal, TipoEmergencia, Fecha FROM Emergencias WHERE CodigoPostal = "
						+ ciudadano.getaCodigoPostal() + " ORDER BY Fecha DESC; ");

		while (rs.next()) {
			Object[] fila = new Object[3];

			for (int i = 0; i < 3; i++)
				fila[i] = rs.getObject(i + 1);

			tInformacion.addRow(fila);
		}

		JTable tabla = new JTable(tInformacion);
		TableRowSorter<DefaultTableModel> ordenaLaTabla = new TableRowSorter<DefaultTableModel>(tInformacion);
		tabla.setRowSorter(ordenaLaTabla);

		log = Logger.getLogger("programLogger");



		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				new ReportarEmergenciasOEmergencias(ciudadano).setVisible(true);
				setVisible(false);
			}
		});

		// panel principal
		JPanel pnlMain = new JPanel();
		pnlMain.setLayout(new BorderLayout());
		pnlMain.add(pnlBotones, BorderLayout.NORTH);
		pnlMain.add(new JScrollPane(tabla, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER), BorderLayout.CENTER);

		getContentPane().add(pnlMain);
		setVisible(true);
	}
}