package Presentacion.Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JMenuItem;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.border.EmptyBorder;

public class VentanaPrincipal extends JFrame {

	private JMenu mnPersonas;
	private JMenuBar menuBar;
	private JMenuItem menuAgregar;
	private JMenuItem menuEliminar;
	private JMenuItem menuModificar;
	private JMenuItem menuListar;

	
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 370);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		
		mnPersonas = new JMenu("Personas");
		menuBar.add(mnPersonas);
		
		menuAgregar = new JMenuItem("Agregar");
		mnPersonas.add(menuAgregar);
		
		menuEliminar = new JMenuItem("Eliminar");
		mnPersonas.add(menuEliminar);
		
		menuModificar = new JMenuItem("Modificar");
		mnPersonas.add(menuModificar);
		
		menuListar = new JMenuItem("Listar");
		mnPersonas.add(menuListar);

	}
	

	public JMenu getMnPersonas() {
		return mnPersonas;
	}


	public void setMnPersonas(JMenu mnPersonas) {
		this.mnPersonas = mnPersonas;
	}


	public JMenuItem getMntmAgregar() {
		return menuAgregar;
	}


	public void setMntmAgregar(JMenuItem mntmAgregar) {
		this.menuAgregar = mntmAgregar;
	}


	public JMenuItem getMntmEliminar() {
		return menuEliminar;
	}


	public void setMntmEliminar(JMenuItem mntmEliminar) {
		this.menuEliminar = mntmEliminar;
	}


	public JMenuItem getMntmModificar() {
		return menuModificar;
	}


	public void setMntmModificar(JMenuItem mntmModificar) {
		this.menuModificar = mntmModificar;
	}


	public JMenuItem getMntmListar() {
		return menuListar;
	}


	public void setMntmListar(JMenuItem mntmListar) {
		this.menuListar = mntmListar;
	}


}
