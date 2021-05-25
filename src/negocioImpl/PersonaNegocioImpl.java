package negocioImpl;

import java.util.List;

import entidad.Persona;
import negocio.PersonaNegocio;

public class PersonaNegocioImpl implements PersonaNegocio {

	@Override
	public boolean insert(Persona persona) {
		return this.insert(persona);
	}

	@Override
	public boolean delete(Persona persona) {
		// TODO Auto-generated method stub
		return this.delete(persona);
	}

	@Override
	public boolean modify(Persona persona, Persona personaModif) {
		// TODO Auto-generated method stub
		return this.modify(persona, personaModif);
	}

	@Override
	public List<Persona> readAll() {
		// TODO Auto-generated method stub
		return this.readAll();
	}

}
