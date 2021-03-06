package Presentacion.Vistas;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entidad.Persona;

public class PanelModificarPersona extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JTextField txtDni;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JButton btnAceptar;
	private JList<Persona> list;
	private static Persona pAnterior;
	
	public Persona getpAnterior() {
		return pAnterior;
	}

	public void setpAnterior(Persona pAnterior) {
		PanelModificarPersona.pAnterior = pAnterior;
	}

	public JList<Persona> getList() {
		return list;
	}

	public void setList(JList<Persona> list) {
		this.list = list;
	}

	public PanelModificarPersona() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 450, 300);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Seleccione el usuario que desea modificar");
		lblUsuario.setBounds(104, 6, 290, 14);
		panel.add(lblUsuario);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(85, 189, 51, 14);
		panel.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(184, 189, 64, 14);
		panel.add(lblApellido);
		
		JLabel lblDni = new JLabel("Dni");
		lblDni.setBounds(296, 189, 23, 14);
		panel.add(lblDni);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(58, 209, 94, 20);
		txtNombre.setColumns(10);
		panel.add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(157, 209, 91, 20);
		txtApellido.setColumns(10);
		panel.add(txtApellido);
		
		txtDni = new JTextField();
		txtDni.setBounds(253, 209, 102, 20);
		panel.add(txtDni);
		txtDni.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(159, 246, 102, 23);
		panel.add(btnAceptar);
		
		list = new JList<Persona>();
		list.setBounds(31, 31, 363, 136);
		panel.add(list);
		
		pAnterior = new Persona();

	}
	
	public void setDefaultListModel(DefaultListModel<Persona> listModelRecibido)
	{
		list.setModel(listModelRecibido);	
	}
	
	public void mostrarMensaje(String mensaje)
	{
		JOptionPane.showMessageDialog(null, mensaje,"Mensaje",1);
	}
	
	public JTextField getTxtDni() {
		return txtDni;
	}

	public void setTxtDni(JTextField txtDni) {
		this.txtDni = txtDni;
	}

	public JTextField getTxtApellido() {
		return txtApellido;
	}

	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public void setBtnAceptar(JButton btnAceptar) {
		this.btnAceptar = btnAceptar;
	}
}
