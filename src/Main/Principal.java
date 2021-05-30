package Main;

import negocio.PersonaNegocio;
import negocioImpl.PersonaNegocioImpl;

public class Principal {

	public static void main(String[] args) {
			
		try {
			Presentacion.Vistas.VentanaPrincipal vista = new Presentacion.Vistas.VentanaPrincipal();
			PersonaNegocio negocio = new PersonaNegocioImpl();
			Presentacion.Controlador.Controlador controlador = new Presentacion.Controlador.Controlador(vista, negocio);
			controlador.inicializar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
