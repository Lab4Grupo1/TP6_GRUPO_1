package Main;

import javax.swing.JFrame;

import Presentacion.Controlador.Controlador;
import Presentacion.Vistas.VentanaPrincipal;
import negocio.PersonaNegocio;

public class Principal extends JFrame {

	public static void main(String[] args) {
		VentanaPrincipal principal = new VentanaPrincipal();
		PersonaNegocio negocio = null;
		Controlador controlador = new Controlador(principal, negocio);

	}

}
