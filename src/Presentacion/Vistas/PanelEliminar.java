package Presentacion.Vistas;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

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
		
		JLabel lblNombre = new JLabel("eliminar");
		lblNombre.setBounds(92, 62, 70, 40);
		panel.add(lblNombre);
	}

}
