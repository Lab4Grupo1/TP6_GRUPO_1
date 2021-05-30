package Presentacion.Controlador;

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
			
			//Instancia de los paneles:
			this.pap = new PanelAgregarPersona();
			this.pep = new PanelEliminarPersona();
			this.plp = new PanelListarPersonas();
			this.pmp = new PanelModificarPersona();
			
			//Eventos del menu del frame de VentanaPrincipal (del jmenu)
			
			this.vp.getMntmAgregar().addActionListener(a->EventoClickMenu_AbrirPanel_AgregarPersona(a));
			this.vp.getMntmEliminar().addActionListener(a->EventoClickMenu_AbrirPanel_EliminarPersona(a));
			this.vp.getMntmModificar().addActionListener(a->EventoClickMenu_AbrirPanel_ModificarPersona(a));
			this.vp.getMntmListar().addActionListener(a->EventoClickMenu_AbrirPanel_ListarPersonas(a));
			
			//Evento del panel agregar personas
			this.pap.getBtnAceptar().addActionListener(a->EventoClickBtn_PanelAgregarPersonas(a));
			this.pap.getTxtDni().addKeyListener((new KeyAdapter() {
	            public void keyTyped(KeyEvent e) {
	                char caracter = e.getKeyChar();
	                if (((caracter < '0') || (caracter > '9')))
	                {
	                    e.consume();
	                }
	            }
	        }));
			this.pap.getTxtApellido().addKeyListener((new KeyAdapter() {
	            public void keyTyped(KeyEvent e) {
	                char caracter = e.getKeyChar();
	                if (((caracter < 'a') || (caracter > 'z')))
	                {
	                    e.consume();
	                }
	            }
	        }));
			this.pap.getTxtNombre().addKeyListener((new KeyAdapter() {
	            public void keyTyped(KeyEvent e) {
	                char caracter = e.getKeyChar();
	                if (((caracter < 'a') || (caracter > 'z')))
	                {
	                    e.consume();
	                }
	            }
	        }));
			
			//Eventos del panel Eliminar Personas
			this.pep.getBtnEliminar().addActionListener(a->EventoClickBtnEliminar_PanelEliminarPersonas(a));
			
			//Eventos del panel Modificar Personas
			this.pmp.getList().addListSelectionListener(a->EventoClickEnJList_PanelModificar(a));
			this.pmp.getBtnAceptar().addActionListener(a->EventoClickBtnAceptar_PanelModificarPersona(a));
			this.pmp.getTxtDni().addKeyListener((new KeyAdapter() {
	            public void keyTyped(KeyEvent e) {
	                char caracter = e.getKeyChar();
	                if (((caracter < '0') || (caracter > '9')))
	                {
	                    e.consume();
	                }
	            }
	        }));
			this.pmp.getTxtApellido().addKeyListener((new KeyAdapter() {
	            public void keyTyped(KeyEvent e) {
	                char caracter = e.getKeyChar();
	                if (((caracter < 'a') || (caracter > 'z')))
	                {
	                    e.consume();
	                }
	            }
	        }));
			this.pmp.getTxtNombre().addKeyListener((new KeyAdapter() {
	            public void keyTyped(KeyEvent e) {
	                char caracter = e.getKeyChar();
	                if (((caracter < 'a') || (caracter > 'z')))
	                {
	                    e.consume();
	                }
	            }
	        }));
			
			
		}
		

		private void EventoClickBtnAceptar_PanelModificarPersona(ActionEvent a) {
			if(this.pmp.getTxtDni().getText().isEmpty()) { 
				this.pmp.mostrarMensaje("Por favor completar el DNI");
			}else if (this.pmp.getTxtNombre().getText().isEmpty()){
				this.pmp.mostrarMensaje("Por favor completar el Nombre");
			}else if (this.pmp.getTxtApellido().getText().isEmpty()){
				this.pmp.mostrarMensaje("Por favor completar el Apellido");
			}else {
				p = new Persona(this.pmp.getTxtDni().getText(),this.pmp.getTxtNombre().getText(),this.pmp.getTxtApellido().getText());
				Boolean exito = pNeg.modify(DniAnterior,p);
				if(exito == true) {
					this.pmp.mostrarMensaje("Registro modificado con éxito!");
					this.RefreshTableModify();
				}else {
					this.pmp.mostrarMensaje("Hubo un error, intente más tarde...");
				}
			}
			
			
		}


		private void EventoClickEnJList_PanelModificar(ListSelectionEvent a) {
			if(this.pmp.getList().getSelectedIndex()!=-1) {
				p = (Persona)this.pmp.getList().getSelectedValue();
				this.pmp.getTxtDni().setText(p.getDni());
				this.pmp.getTxtApellido().setText(p.getApellido());
				this.pmp.getTxtNombre().setText(p.getNombre());
				this.DniAnterior = pmp.getTxtDni().getText();
			}
		}


		private void EventoClickBtn_PanelAgregarPersonas(ActionEvent a) {
			
			if(pap.getTxtApellido().getText().isEmpty()) {
				pap.mostrarMensaje("Por favor, completar el Apellido.");
			} else if( pap.getTxtDni().getText().isEmpty()) {
				pap.mostrarMensaje("Por favor, completar el Dni.");

			} else if( pap.getTxtNombre().getText().isEmpty()) {
				pap.mostrarMensaje("Por favor, completar el Nombre.");
			}else {
				String Nombre = pap.getTxtNombre().getText();
				String Apellido = pap.getTxtApellido().getText();
				String Dni = pap.getTxtDni().getText();
				
				p = new Persona(Dni,Nombre,Apellido);
				boolean inserto = pNeg.insert(p);
				if(inserto == true) {
					pap.mostrarMensaje("Persona ingresada con éxito!");
					
					pap.getTxtApellido().setText("");
					pap.getTxtDni().setText("");
					pap.getTxtNombre().setText("");
				}else {
					pap.mostrarMensaje("Hubo un error, intente más tarde.");
				}
				
			}
				
				
		}

		private void EventoClickMenu_AbrirPanel_ListarPersonas(ActionEvent a) {
			// TODO Auto-generated method stub
			vp.getContentPane().removeAll();
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
			p = (Persona)this.pep.getList().getSelectedValue();
			Boolean exito = pNeg.delete(p);
			if(exito == true) {
				this.pep.mostrarMensaje("Persona eliminada con éxito!");
				this.RefreshTable();
			}else {
				this.pep.mostrarMensaje("Hubo un error, intente más tarde...");
			}
		}

		
		public void inicializar()
		{
			this.vp.setVisible(true);;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
}
