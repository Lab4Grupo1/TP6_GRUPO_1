package Presentacion.Vistas;
 
import java.awt.Color;
import java.util.List;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;

import entidad.Persona;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent; 

public class PanelModificar extends JPanel {
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField tntApellido;
	 
	private String[] nombreColumnas = {"Nombre", "Apellido","Dni"};
	static DefaultTableModel modelPersonas;
	static DefaultListModel<Persona> modelListPersonas;
	  
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
		
		JScrollPane spPersonas = new JScrollPane();
		spPersonas.setBounds(10, 36, 380, 169);
		panel.add(spPersonas); 
		
		JList<Persona> listaPersona = new JList<Persona>();	

		PanelModificar.modelListPersonas = new DefaultListModel<Persona>();
		listaPersona.setModel(modelListPersonas);
		System.out.println("1");
		System.out.println(modelListPersonas);

		spPersonas.setViewportView(listaPersona); 
		
	} 

	public void llenarTabla(List<Persona> personasEnTabla) {
		
		
		for (Persona p : personasEnTabla)
		{
			PanelModificar.getModelListPersonas().addElement(p);
			System.out.println(modelListPersonas);
			
		}		
	}

	public static DefaultListModel<Persona> getModelListPersonas() {
		return modelListPersonas;
	}

}
