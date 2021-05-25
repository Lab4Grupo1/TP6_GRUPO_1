package Presentacion.Controlador;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import Presentacion.Vistas.PanelAgregar;
import Presentacion.Vistas.PanelEliminar;
import Presentacion.Vistas.PanelListar;
import Presentacion.Vistas.PanelModificar;
import Presentacion.Vistas.VentanaPrincipal;
import entidad.Persona;
import negocio.PersonaNegocio;

public class Controlador {
	private VentanaPrincipal ventanaPrincipal;
	private PanelAgregar pnlIngresoPersonas;
	private PanelEliminar pnlEliminarPersonas;
	private PanelModificar pnModificarPersonas;
	private PanelListar pnListarPersonas;
	private PersonaNegocio pNeg;
	private ArrayList<Persona> personasEnTabla;
	
	public Controlador(VentanaPrincipal vista, PersonaNegocio negocio) {
		this.ventanaPrincipal = vista;
		this.pNeg = negocio;
		
		this.pnlIngresoPersonas = new PanelAgregar();
		this.pnlEliminarPersonas = new PanelEliminar();
		this.pnModificarPersonas = new PanelModificar();
		this.pnListarPersonas = new PanelListar();
		
		this.ventanaPrincipal.getMntmAgregar().addActionListener(a->EventoClickMenu_AbrirPanel_AgregarPersona(a));
		this.ventanaPrincipal.getMntmBorrar().addActionListener(a->EventoClickMenu_AbrirPanel_BorrarPersonas(a));
		this.ventanaPrincipal.getMntmModificar().addActionListener(a->EventoClickMenu_AbrirPanel_ModificarPersonas(a));
		this.ventanaPrincipal.getMntmListar().addActionListener(a->EventoClickMenu_AbrirPanel_ListarPersonas(a));
	}

	private void EventoClickMenu_AbrirPanel_ListarPersonas(ActionEvent a) {
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlIngresoPersonas);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}

	private void EventoClickMenu_AbrirPanel_ModificarPersonas(ActionEvent a) {
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnModificarPersonas);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}

	private void EventoClickMenu_AbrirPanel_BorrarPersonas(ActionEvent a) {
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlEliminarPersonas);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}

	private void EventoClickMenu_AbrirPanel_AgregarPersona(ActionEvent a) {
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnListarPersonas);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}
}
