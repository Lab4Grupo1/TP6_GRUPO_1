package Presentacion.Controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.event.ListSelectionEvent;

import entidad.Persona;
import negocio.PersonaNegocio;
import Presentacion.Vistas.*;

public class Controlador implements ActionListener {

	private VentanaPrincipal vp;
	private PanelAgregarPersona pap;
	private PanelEliminarPersona pep;
	private PanelListarPersonas plp;
	private PanelModificarPersona pmp;
	private PersonaNegocio pNeg;
	private String DniAnterior;
	private Persona p;

	public Controlador(VentanaPrincipal vp, PersonaNegocio pNeg) {
		this.vp = vp;
		this.pNeg = pNeg;

		// Instancia de los paneles:
		this.pap = new PanelAgregarPersona();
		this.pep = new PanelEliminarPersona();
		this.plp = new PanelListarPersonas();
		this.pmp = new PanelModificarPersona();

		// Eventos del menu del frame de VentanaPrincipal (del jmenu)

		this.vp.getMntmAgregar().addActionListener(a -> EventoClickMenu_AbrirPanel_AgregarPersona(a));
		this.vp.getMntmEliminar().addActionListener(a -> EventoClickMenu_AbrirPanel_EliminarPersona(a));
		this.vp.getMntmModificar().addActionListener(a -> EventoClickMenu_AbrirPanel_ModificarPersona(a));
		this.vp.getMntmListar().addActionListener(a -> EventoClickMenu_AbrirPanel_ListarPersonas(a));

		// Evento del panel modificar personas en txt dni
		// Este evento no permite al usuario modificar el dni.
		this.pmp.getTxtDni().setEnabled(false);
		this.pmp.getTxtDni().setDisabledTextColor(Color.BLACK);


		// Evento del panel agregar personas
		this.pap.getBtnAceptar().addActionListener(a -> EventoClickBtn_PanelAgregarPersonas(a));
		this.pap.getTxtDni().addKeyListener((new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (((caracter < '0') || (caracter > '9'))) {
					e.consume();
				}
			}
		}));
		this.pap.getTxtApellido().addKeyListener((new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				int code = e.getKeyCode();
				char c = e.getKeyChar();
				if (!Character.isLetter(c) && code != KeyEvent.VK_SPACE && code != KeyEvent.VK_BACK_SPACE) {
					e.consume(); // ignore event
				}
			}
		}));
		this.pap.getTxtNombre().addKeyListener((new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				int code = e.getKeyCode();
				char c = e.getKeyChar();
				if (!Character.isLetter(c) && code != KeyEvent.VK_SPACE && code != KeyEvent.VK_BACK_SPACE) {
					e.consume(); // ignore event
				}
			}
		}));

		// Eventos del panel Eliminar Personas
		this.pep.getBtnEliminar().addActionListener(a -> EventoClickBtnEliminar_PanelEliminarPersonas(a));

		// Eventos del panel Modificar Personas
		this.pmp.getList().addListSelectionListener(a -> EventoClickEnJList_PanelModificar(a));
		this.pmp.getBtnAceptar().addActionListener(a -> EventoClickBtnAceptar_PanelModificarPersona(a));

		this.pmp.getTxtApellido().addKeyListener((new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				int code = e.getKeyCode();
				char c = e.getKeyChar();
				if (!Character.isLetter(c) && code != KeyEvent.VK_SPACE && code != KeyEvent.VK_BACK_SPACE) {
					e.consume(); // ignore event
				}
			}
		}));
		this.pmp.getTxtNombre().addKeyListener((new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				int code = e.getKeyCode();
				char c = e.getKeyChar();
				if (!Character.isLetter(c) && code != KeyEvent.VK_SPACE && code != KeyEvent.VK_BACK_SPACE) {
					e.consume(); // ignore event
				}
			}
		}));

	}

	private void EventoClickBtnAceptar_PanelModificarPersona(ActionEvent a) {
		if (this.pmp.getTxtDni().getText().isEmpty()) {
			this.pmp.mostrarMensaje("Por favor completar el DNI");
		} else if (this.pmp.getTxtNombre().getText().isEmpty()) {
			this.pmp.mostrarMensaje("Por favor completar el Nombre");
		} else if (this.pmp.getTxtApellido().getText().isEmpty()) {
			this.pmp.mostrarMensaje("Por favor completar el Apellido");
		} else {
			p = new Persona(this.pmp.getTxtDni().getText(), this.pmp.getTxtNombre().getText(),
					this.pmp.getTxtApellido().getText());
			Boolean exito = pNeg.modify(DniAnterior, p);
			if (exito == true) {
				this.pmp.mostrarMensaje("Registro modificado con éxito!");
				this.RefreshTableModify();
			} else {
				this.pmp.mostrarMensaje("Hubo un error, intente más tarde...");
			}
		}
		pmp.getTxtApellido().setText("");
		pmp.getTxtDni().setText("");
		pmp.getTxtNombre().setText("");
	}

	private void EventoClickEnJList_PanelModificar(ListSelectionEvent a) {
		if (this.pmp.getList().getSelectedIndex() != -1) {
			p = (Persona) this.pmp.getList().getSelectedValue();
			this.pmp.getTxtDni().setText(p.getDni());
			this.pmp.getTxtApellido().setText(p.getApellido());
			this.pmp.getTxtNombre().setText(p.getNombre());
			this.DniAnterior = pmp.getTxtDni().getText();
		}
	}

	private void EventoClickBtn_PanelAgregarPersonas(ActionEvent a) {

		if (pap.getTxtApellido().getText().isEmpty()) {
			pap.mostrarMensaje("Por favor, completar el Apellido.");
		} else if (pap.getTxtDni().getText().isEmpty()) {
			pap.mostrarMensaje("Por favor, completar el Dni.");
		} else if (pap.getTxtNombre().getText().isEmpty()) {
			pap.mostrarMensaje("Por favor, completar el Nombre.");
		} else {
			String Nombre = pap.getTxtNombre().getText();
			String Apellido = pap.getTxtApellido().getText();
			String Dni = pap.getTxtDni().getText();

			p = new Persona(Dni, Nombre, Apellido);
			int inserto = pNeg.insert(p);
			if (inserto == 1) {
				pap.mostrarMensaje("Persona ingresada con éxito!");

				pap.getTxtApellido().setText("");
				pap.getTxtDni().setText("");
				pap.getTxtDni().setBackground(Color.WHITE);
				pap.getTxtDni().setForeground(Color.BLACK);
				pap.getTxtNombre().setText("");
			} else if (inserto == 3) {
				pap.mostrarMensaje("El dni existe, ingrese otro.");
				pap.getTxtDni().setBackground(Color.RED);
				pap.getTxtDni().setForeground(Color.WHITE);
			} else if (inserto == -1 || inserto == 2) {
				pap.mostrarMensaje("Hubo un error de conexión, contacte con el administrador");
			}

		}

	}

	private void EventoClickMenu_AbrirPanel_ListarPersonas(ActionEvent a) {
		// TODO Auto-generated method stub
		vp.getContentPane().removeAll();
		plp = new PanelListarPersonas();
		vp.getContentPane().add(plp);
		vp.getContentPane().repaint();
		vp.getContentPane().revalidate();
		this.GenerateTable();
	}

	private void EventoClickMenu_AbrirPanel_ModificarPersona(ActionEvent a) {
		// TODO Auto-generated method stub
		vp.getContentPane().removeAll();
		vp.getContentPane().add(pmp);
		vp.getContentPane().repaint();
		vp.getContentPane().revalidate();
		this.RefreshTableModify();

	}

	private void EventoClickMenu_AbrirPanel_EliminarPersona(ActionEvent a) {
		// TODO Auto-generated method stub
		vp.getContentPane().removeAll();
		vp.getContentPane().add(pep);
		vp.getContentPane().repaint();
		vp.getContentPane().revalidate();
		this.RefreshTable();

	}

	private void EventoClickMenu_AbrirPanel_AgregarPersona(ActionEvent a) {
		// TODO Auto-generated method stub
		vp.getContentPane().removeAll();
		vp.getContentPane().add(pap);
		vp.getContentPane().repaint();
		vp.getContentPane().revalidate();

	}

	private void RefreshTable() {

		this.pep.setDefaultListModel(pNeg.readAllDFL());
	}

	private void RefreshTableModify() {
		this.pmp.setDefaultListModel(pNeg.readAllDFL());
	}

	private void GenerateTable() {
		this.plp.setDefaultListModel(pNeg.readAll());
	}

	private void EventoClickBtnEliminar_PanelEliminarPersonas(ActionEvent a) {

		p = new Persona();
		p = (Persona) this.pep.getList().getSelectedValue();
		if (p != null) {
			Boolean exito = pNeg.delete(p);
			if (exito == true) {
				this.pep.mostrarMensaje("Persona eliminada con éxito!");
				this.RefreshTable();
			} else
				this.pep.mostrarMensaje("Hubo un error, intente más tarde...");
		} else
			this.pep.mostrarMensaje("Seleccione la persona a eliminar");

	}

	public void inicializar() {
		this.vp.setVisible(true);
		;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
