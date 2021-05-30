package negocio;

import java.util.List;

import javax.swing.DefaultListModel;

import entidad.Persona;

public interface PersonaNegocio {

	public boolean insert(Persona persona);
	public boolean modify(String Dni, Persona persona);
	public boolean delete(Persona persona_a_eliminar);
	public List<Persona> readAll();
	public DefaultListModel<Persona> readAllDFL();
}