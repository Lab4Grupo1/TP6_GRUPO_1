package Main;

import javax.swing.JFrame;

import Presentacion.Controlador.Controlador;
import Presentacion.Vistas.VentanaPrincipal;
import negocioImpl.PersonaNegocioImpl;

public class Principal extends JFrame {
	
	public static void main(String[] args) {
		VentanaPrincipal principal = new VentanaPrincipal();
		PersonaNegocioImpl negocio = new PersonaNegocioImpl();
		Controlador controlador = new Controlador(principal, negocio);
		controlador.inicializar();
	}

}
