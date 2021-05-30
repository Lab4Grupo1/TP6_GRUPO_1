package Presentacion.Vistas;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entidad.Persona;
import negocio.PersonaNegocio;
import negocioImpl.PersonaNegocioImpl;

public class PanelListar extends JPanel {
	private JTable tabPersona;
	private String[] nombreColumnas = {"Nombre", "Apellido","Dni"};
	private DefaultTableModel modelPersonas;

	/**
	 * Create the panel.
	 */
	public PanelListar() {
		this.setLayout(null);
		this.setBounds(10, 11, 450, 250);
		
		JPanel panel = new JPanel();
		panel.setBounds(10,11,400,200);
		this.add(panel);
		panel.setLayout(null);
		
		JScrollPane spPersonas = new JScrollPane();
		spPersonas.setBounds(10, 11, 380, 120);
		panel.add(spPersonas);
		
		modelPersonas = new DefaultTableModel(null,nombreColumnas);
		tabPersona = new JTable(modelPersonas);
		
		tabPersona.getColumnModel().getColumn(0).setPreferredWidth(103);
		tabPersona.getColumnModel().getColumn(0).setResizable(false);
		tabPersona.getColumnModel().getColumn(1).setPreferredWidth(100);
		tabPersona.getColumnModel().getColumn(1).setResizable(false);
		
		spPersonas.setViewportView(tabPersona);
		
		tabPersona.setBounds(20, 25, 403, 179);		
		
//		int numCols = tabPersona.getModel().getColumnCount();
//		
//		PersonaNegocioImpl negocio = new PersonaNegocioImpl();
//		List<Persona> listaPersona = negocio.readAll();
//		for (Persona persona : listaPersona) {
//			
//		Object [] fila = new Object[numCols]; 
//		 
//		 fila[0] = persona.getNombre();
//		 fila[1] = persona.getApellido();
//		 fila[2] = persona.getDni();
//		}
		
	}
	
	public JTable getTabPersona() {
		return tabPersona;
	}

	public void setTabPersona(JTable tabPersona) {
		this.tabPersona = tabPersona;
	}

	public DefaultTableModel getModelPersonas() {
		return modelPersonas;
	}

	public String[] getNombreColumnas() {
		return nombreColumnas;
	}

	public void setNombreColumnas(String[] nombreColumnas) {
		this.nombreColumnas = nombreColumnas;
	}

	public void setModelPersonas(DefaultTableModel modelPersonas) {
		this.modelPersonas = modelPersonas;
	}

	public void llenarTabla(List<Persona> personasEnTabla) {
		this.getModelPersonas().setRowCount(0); //Para vaciar la tabla
		this.getModelPersonas().setColumnCount(0);
		this.getModelPersonas().setColumnIdentifiers(this.getNombreColumnas());

		for (Persona p : personasEnTabla)
		{
			String nombre = p.getNombre();
			String apellido = p.getApellido();
			String dni = p.getDni();
			Object[] fila = {nombre, apellido, dni};
			this.getModelPersonas().addRow(fila);
		}
		
	}
}
