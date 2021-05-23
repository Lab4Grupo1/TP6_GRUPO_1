package Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Presentacion.Vistas.PanelAgregar;
import Presentacion.Vistas.PanelEliminar;
import Presentacion.Vistas.PanelListar;
import Presentacion.Vistas.PanelModificar;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {
	
	private JPanel contentPane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame= new Principal();
					frame.setVisible(true);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	/**
	 * Create the frame.
	 */
	
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 300, 500, 400);
		
		JMenuBar menuBar= new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu MenuPersonas= new JMenu("Personas");
		menuBar.add(MenuPersonas);
		
		//Agregar
		JMenuItem mntmAgregar = new JMenuItem("Agregar");
		mntmAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				PanelAgregar panel= new PanelAgregar();
				
				contentPane.add(panel);
				contentPane.repaint();
				contentPane.revalidate();				
			}
		});
		MenuPersonas.add(mntmAgregar);
		
		//Modificar
		JMenuItem mnModificar = new JMenuItem("Modificar");
		mnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				PanelModificar panel = new PanelModificar();
				contentPane.add(panel);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		MenuPersonas.add(mnModificar);
		
		//Eliminar
		JMenuItem mnEliminar = new JMenuItem("Eliminar");
		mnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				PanelEliminar panel = new PanelEliminar();
				contentPane.add(panel);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		MenuPersonas.add(mnEliminar);
		
		//Listar
		JMenuItem mnListar = new JMenuItem("Listar");
		mnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				PanelListar panel = new PanelListar();
				contentPane.add(panel);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		MenuPersonas.add(mnListar);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	

}
