package Presentacion.Vistas;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entidad.Persona;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class PanelListarPersonas extends JPanel {
	private DefaultTableModel modelo;
	private JTable table;
	private String[] nombreColumnas = {"Nombre y apellido","Telefono"};



	/**
	 * Create the panel.
	 */
	public PanelListarPersonas() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 450, 300);
		add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(60, 41, 335, 217);
		panel.add(scrollPane);
		
		modelo = new DefaultTableModel();
		table = new JTable(modelo);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Apellido", "Dni"
			}
		));
		scrollPane.setViewportView(table);

	}
	
	public void setDefaultListModel(List<Persona> listModelRecibido)
	{
		this.getModelo().setRowCount(0); //Para vaciar la tabla
		this.getModelo().setColumnCount(0);
		this.getModelo().setColumnIdentifiers(this.getNombreColumnas());
		
		int numCols = table.getModel().getColumnCount();
		
		for (Persona item : listModelRecibido) {
			
		Object [] fila = new Object[numCols]; 
        
		 fila[0] = item.getNombre();
		 fila[1] = item.getApellido();
		 fila[2] = item.getDni();
		 
		 ((DefaultTableModel) table.getModel()).addRow(fila);
		}



	}
	
	public DefaultTableModel getModelo() {
		return modelo;
	}

	public void setModelo(DefaultTableModel modelo) {
		this.modelo = modelo;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
	
	public void mostrarMensaje(String mensaje)
	{
		JOptionPane.showMessageDialog(null, mensaje);
	}

	public String[] getNombreColumnas() {
		return nombreColumnas;
	}


}
