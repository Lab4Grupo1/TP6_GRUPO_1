package Presentacion.Controlador;

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
	}
}
