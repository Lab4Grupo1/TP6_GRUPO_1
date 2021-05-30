package main;

import negocio.PersonaNegocio;
import negocioImpl.PersonaNegocioImpl;
import Presentacion.Vistas.*;
import Presentacion.Controlador.*;

public class Principal {

	public static void main(String[] args) {
			
		try {
			VentanaPrincipal vista = new VentanaPrincipal();
			PersonaNegocio negocio = new PersonaNegocioImpl();
			Controlador controlador = new Controlador(vista, negocio);
			controlador.inicializar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
