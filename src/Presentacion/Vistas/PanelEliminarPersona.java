package Presentacion.Vistas;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import entidad.Persona;
import negocio.PersonaNegocio;

public class PanelEliminarPersona extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private DefaultListModel<Persona> listModel;
	private String[] nombreColumnas = {"Nombre y apellido","Dni"};
	private JButton btnEliminar;
	private PersonaNegocio pNeg;
	private JList<Persona> list_1;

	/**
	 * Create the panel.
	 */
	public PanelEliminarPersona() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 450, 300);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblEliminarUsuarios = new JLabel("Eliminar usuarios");
		lblEliminarUsuarios.setBounds(138, 31, 151, 14);
		panel.add(lblEliminarUsuarios);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(181, 215, 88, 23);
		panel.add(btnEliminar);
		
		list_1 = new JList<Persona>();
		list_1.setBounds(30, 75, 391, 129);
		panel.add(list_1);

	}
	


	public void setDefaultListModel(DefaultListModel<Persona> listModelRecibido)
	{
		list_1.setModel(listModelRecibido);	
	}
	
	public void mostrarMensaje(String mensaje)
	{
		JOptionPane.showMessageDialog(null, mensaje,"Mensaje",1);
	}

	public DefaultListModel<Persona> getModelPersonas() {
		return listModel;
	}

	public void setModelPersonas(DefaultListModel<Persona> modelPersonas) {
		this.listModel = modelPersonas;
	}

	public String[] getNombreColumnas() {
		return nombreColumnas;
	}

	public void setNombreColumnas(String[] nombreColumnas) {
		this.nombreColumnas = nombreColumnas;
	}

	public JList<Persona> getList() {
		return list_1;
	}

	public void setList(JList<Persona> list) {
		this.list_1 = list;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}



	public PersonaNegocio getpNeg() {
		return pNeg;
	}



	public void setpNeg(PersonaNegocio pNeg) {
		this.pNeg = pNeg;
	}
}
