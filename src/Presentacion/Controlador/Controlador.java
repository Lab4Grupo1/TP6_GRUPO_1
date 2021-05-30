package Presentacion.Controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
		this.pnlIngresoPersonas.getTxtDni().addKeyListener((new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (((caracter < '0') || (caracter > '9')))
                {
                    e.consume();
                }
            }
        }));
		this.pnlIngresoPersonas.getTxtApellido().addKeyListener((new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                int code = e.getKeyCode();
                if (!Character.isLetter(caracter) && code!=KeyEvent.VK_BACK_SPACE)
                {
                    e.consume();
                }

                
            }
        }));
		this.pnlIngresoPersonas.getTxtNombre().addKeyListener((new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                int code = e.getKeyCode();
                if (!Character.isLetter(caracter) && code!=KeyEvent.VK_BACK_SPACE)
                {
                    e.consume();
                }

            }
        }));
		
	}
	
	private void EventoClick_PnlAgregarPersona_BtnAceptar(ActionEvent a) {
		if(pnlIngresoPersonas.getTxtApellido().getText().isEmpty()) {
			pnlIngresoPersonas.mostrarMensaje("Por favor, completar el Apellido.");
		} else if( pnlIngresoPersonas.getTxtDni().getText().isEmpty()) {
			pnlIngresoPersonas.mostrarMensaje("Por favor, completar el Dni.");

		} else if( pnlIngresoPersonas.getTxtNombre().getText().isEmpty()) {
			pnlIngresoPersonas.mostrarMensaje("Por favor, completar el Nombre.");
		}else {
		String Nombre = this.pnlIngresoPersonas.getTxtNombre().getText();
		String Apellido = this.pnlIngresoPersonas.getTxtApellido().getText();
		String Dni = this.pnlIngresoPersonas.getTxtDni().getText();
		
		persona = new Persona(Dni,Nombre,Apellido);
		
		int exito = pNeg.insert(persona);
		if(exito == 1) {
			mensaje = "Persona ingresada con éxito!";
			this.pnlIngresoPersonas.getTxtApellido().setText("");
			this.pnlIngresoPersonas.getTxtNombre().setText("");
			this.pnlIngresoPersonas.getTxtDni().setText("");
			this.pnlIngresoPersonas.getTxtDni().setBackground(Color.WHITE);
			this.pnlIngresoPersonas.mostrarMensaje(mensaje);
		}else if(exito == 3) {
			mensaje = "El dni ya existe! por favor indique otro";
			this.pnlIngresoPersonas.getTxtDni().setBackground(Color.RED);
			this.pnlIngresoPersonas.mostrarMensaje(mensaje);
		}else if(exito == -1 || exito == 2) {
			mensaje = "Hubo un error, por favor, comunicarse con el Admin!";
			this.pnlIngresoPersonas.mostrarMensaje(mensaje);
		}
		}
	}

	public void inicializar() {
		this.ventanaPrincipal.setVisible(true);;
	}
	
	public void inicializarTabla() {
		this.personasEnTabla = (ArrayList<Persona>) pNeg.readAll();
		this.pnListarPersonas.llenarTabla(personasEnTabla);
		this.pnModificarPersonas.llenarTabla(personasEnTabla);
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
		inicializarTabla();
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
