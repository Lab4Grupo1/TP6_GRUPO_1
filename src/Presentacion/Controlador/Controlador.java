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
	private Persona persona;
	private String mensaje = null;
	
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
		
		this.pnlIngresoPersonas.getBtnAceptar().addActionListener(a ->EventoClick_PnlAgregarPersona_BtnAceptar(a));
	}
	
	private void EventoClick_PnlAgregarPersona_BtnAceptar(ActionEvent a) {
		String Nombre = this.pnlIngresoPersonas.getTxtNombre().getText();
		String Apellido = this.pnlIngresoPersonas.getTxtApellido().getText();
		String Dni = this.pnlIngresoPersonas.getTxtDni().getText();
		
		persona = new Persona(Dni,Nombre,Apellido);
		
		Boolean exito = pNeg.insert(persona);
		if(exito) {
			mensaje = "Persona ingresada con éxito!";
			this.pnlIngresoPersonas.getTxtApellido().setText("");
			this.pnlIngresoPersonas.getTxtNombre().setText("");
			this.pnlIngresoPersonas.getTxtDni().setText("");
			this.pnlIngresoPersonas.mostrarMensaje(mensaje);
		}else {
			mensaje = "Hubo un error, contacte con el administrador";
			this.pnlIngresoPersonas.mostrarMensaje(mensaje);
		}
	}

	public void inicializar() {
		this.ventanaPrincipal.setVisible(true);;
	}
	
	public void inicializarTabla() {
		this.personasEnTabla = (ArrayList<Persona>) pNeg.readAll();
		this.pnListarPersonas.llenarTabla(personasEnTabla);
	}

	private void EventoClickMenu_AbrirPanel_ListarPersonas(ActionEvent a) {
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnListarPersonas);
		inicializarTabla();
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
		ventanaPrincipal.getContentPane().add(pnlIngresoPersonas);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}
}
