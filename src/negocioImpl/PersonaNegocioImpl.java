package negocioImpl;

import java.util.List;

import dao.PersonaDao;
import daolmpl.PersonaDaolmpl;
import entidad.Persona;
import negocio.PersonaNegocio;

public class PersonaNegocioImpl implements PersonaNegocio {

	PersonaDao pdao = new PersonaDaolmpl();
	
	@Override
	public int insert(Persona persona) {
		
		return pdao.insert(persona);
	}

	@Override
	public boolean delete(Persona persona) {
		// TODO Auto-generated method stub
		return pdao.delete(persona);
	}

	@Override
	public boolean modify(Persona persona, Persona personaModif) {
		// TODO Auto-generated method stub
		return pdao.modify(persona, personaModif);
	}

	@Override
	public List<Persona> readAll() {
		// TODO Auto-generated method stub
		return pdao.readAll();
	}

}
