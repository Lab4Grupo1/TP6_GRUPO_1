package negocioImpl;

import java.util.List;

import javax.swing.DefaultListModel;

import daoImpl.PersonaDaoImpl;
import entidad.Persona;
import negocio.PersonaNegocio;

public class PersonaNegocioImpl implements PersonaNegocio{

	PersonaDaoImpl pdao = new PersonaDaoImpl();
	private boolean estado;
	
	@Override
	public int insert(Persona persona) {	
		
		return pdao.insert(persona);
	}

	
	
	@Override
	public boolean modify(String Dni,Persona persona) {
		return pdao.modify(Dni, persona);
	}



	@Override
	public boolean delete(Persona persona_a_eliminar) {
		try {
			if(persona_a_eliminar.getDni() != null )//Tambi�n se puede preguntar si existe ese ID 
			{
				estado=pdao.delete(persona_a_eliminar);
				return estado;
			}
			else
			{
				return false;
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}

	@Override
	public List<Persona> readAll() {
		return pdao.readAll();
	}


	@Override
	public DefaultListModel<Persona> readAllDFL() {
		return pdao.readAllDFL();
	}
	
	

}