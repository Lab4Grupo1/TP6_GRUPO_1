package Presentacion.Vistas;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.JButton;

public class PanelEliminar extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelEliminar() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 450, 250);
		add(panel);
		panel.setLayout(null);
		
		JList listPersona = new JList();
		listPersona.setBounds(83, 11, 284, 185);
		panel.add(listPersona);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(181, 216, 89, 23);
		panel.add(btnEliminar);
	}
}
