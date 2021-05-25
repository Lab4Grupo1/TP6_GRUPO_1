package Presentacion.Vistas;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JTextField;

public class PanelModificar extends JPanel {
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField tntApellido;

	/**
	 * Create the panel.
	 */
	public PanelModificar() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 450, 250);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblElijaLaPersona = new JLabel("Elija la persona que quiere modificar");
		lblElijaLaPersona.setBounds(61, 11, 242, 14);
		panel.add(lblElijaLaPersona);
		
		JList list = new JList();
		list.setBounds(10, 36, 414, 153);
		panel.add(list);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(334, 216, 89, 23);
		panel.add(btnModificar);
		
		txtDni = new JTextField();
		txtDni.setBounds(10, 217, 106, 20);
		panel.add(txtDni);
		txtDni.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(126, 217, 94, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		tntApellido = new JTextField();
		tntApellido.setBounds(230, 217, 94, 20);
		panel.add(tntApellido);
		tntApellido.setColumns(10);
	}
}
