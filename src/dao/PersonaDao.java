package dao;

import java.util.List;

import entidad.Persona;

public interface PersonaDao {
	public int insert (Persona persona);
	public boolean delete (Persona persona);
	public boolean modify (Persona persona, Persona personaModif);
	public List<Persona> readAll();
}
