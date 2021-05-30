package dao;

import java.util.List;

import entidad.Persona;


public interface PersonaDao 
{
	public int insert(Persona persona);
	public boolean delete(Persona persona_a_eliminar);
	public boolean modify(String Dni, Persona p);
	public List<Persona> readAll();
}