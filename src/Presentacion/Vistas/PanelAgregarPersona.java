package Presentacion.Vistas;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class PanelAgregarPersona extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JLabel lblApellido;
	private JLabel lblDni;
	private JButton btnAceptar;
	
	public PanelAgregarPersona() {
		super();
		Initialize();
		
	}
	
	public void Initialize() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(112, 46, 47, 14);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(191, 43, 86, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(112, 89, 47, 14);
		panel.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(191, 86, 86, 20);
		panel.add(txtApellido);
		txtApellido.setColumns(10);
		
		lblDni = new JLabel("Dni");
		lblDni.setBounds(112, 131, 47, 14);
		panel.add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setBounds(191, 128, 86, 20);
		panel.add(txtDni);
		txtDni.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(191, 184, 71, 23);
		panel.add(btnAceptar);
	}
	
	
	

	public void mostrarMensaje(String mensaje)
	{
		JOptionPane.showMessageDialog(null, mensaje);
	}



	public JTextField getTxtNombre() {
		return txtNombre;
	}



	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}



	public JTextField getTxtApellido() {
		return txtApellido;
	}



	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}



	public JTextField getTxtDni() {
		return txtDni;
	}



	public void setTxtDni(JTextField txtDni) {
		this.txtDni = txtDni;
	}



	public JButton getBtnAceptar() {
		return btnAceptar;
	}



	public void setBtnAceptar(JButton btnAceptar) {
		this.btnAceptar = btnAceptar;
	}	 
}
