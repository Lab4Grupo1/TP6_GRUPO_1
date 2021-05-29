package Presentacion.Vistas;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entidad.Persona;
import negocio.PersonaNegocio;
import negocioImpl.PersonaNegocioImpl;

public class PanelListar extends JPanel {
	private JTable tabPersona;
	private DefaultListModel<Persona> dlModel;

	/**
	 * Create the panel.
	 */
	public PanelListar() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 450, 250);
		add(panel);
		panel.setLayout(null);
		tabPersona = new JTable();
		tabPersona.setBounds(20, 25, 403, 179);
		panel.add(tabPersona);
		
		DefaultTableModel modelo = new DefaultTableModel();
					
		tabPersona.setModel(new DefaultTableModel(
				new Object[][] {
					
				},new String[] {
						"Nombre","Apellido","Dni"
				}
						
				));
		
		int numCols = tabPersona.getModel().getColumnCount();
		
		PersonaNegocioImpl negocio = new PersonaNegocioImpl();
		List<Persona> listaPersona = negocio.readAll();
		for (Persona persona : listaPersona) {
			
		Object [] fila = new Object[numCols]; 
		 
		 fila[0] = persona.getNombre();
		 fila[1] = persona.getApellido();
		 fila[2] = persona.getDni();
		}
		
	}
	
	

}
