package negocio;
import java.util.List;

import entidad.Persona;

public interface PersonaNegocio {
	public boolean insert(Persona persona);
	public boolean delete(Persona persona);
	public boolean modify(Persona persona, Persona personaModif);
	public List<Persona> readAll();
	
}
