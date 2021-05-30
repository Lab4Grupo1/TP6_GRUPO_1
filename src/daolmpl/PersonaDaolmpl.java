package daolmpl;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.PersonaDao;
import entidad.Persona;

public class PersonaDaolmpl implements PersonaDao {

	private static final String insert = "Insert into personas(Dni, Nombre, Apellido) values (?,?,?) ";
	private static final String delete = "Delete from personas where Dni = ?";
	private static final String modify = "Update personas set Dni = ?, Nombre = ?, Apellido = ? where Dni = ?";
	private static final String readAll = "Select Dni, Nombre, Apellido from personas";
	private static final String validateDni = "Select * from personas where Dni = ?";
	
	@Override
	public int insert(Persona persona) {
		int Exito = -1;
		
		if(validateDni(persona.getDni()) == false) {		
		PreparedStatement statement;
		Connection conn = Conexion.getConexion().getSQLConexion();
		try {
			statement = conn.prepareStatement(insert);
			statement.setString(1, persona.getDni());
			statement.setString(2, persona.getNombre());
			statement.setString(3, persona.getApellido());
			if(statement.executeUpdate() > 0) {
				conn.commit();
				Exito = 1;
			}else {
				Exito = 2;
			}
		} catch (Exception e) {
			e.printStackTrace();
			Exito = -1;
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				Exito = -1;
			}
		}
		
		return Exito;
		}else {
			Exito = 3;
			return Exito;
		}
		
	}
	
	private boolean validateDni(String dni) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		try {
			statement = conexion.prepareStatement(validateDni);
			statement.setString(1, dni);
			ResultSet resultSet;
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
		
	
	@Override
	public boolean delete(Persona persona) {
		// TODO Auto-generated method stub
		PreparedStatement statement;
		Connection conn = Conexion.getConexion().getSQLConexion();
		boolean Exito = false;
		try {
			statement = conn.prepareStatement(delete);
			statement.setString(1, persona.getDni());
			if(statement.executeUpdate() > 0) {
				conn.commit();
				Exito = true;
			}else {
				Exito = false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Exito = false;
			try {
				conn.rollback();
				Exito = false;
			} catch (SQLException e1) {
				e1.printStackTrace();
				Exito = false;
			}
		}
		return Exito;
	}
	
	@Override
	public List<Persona> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<Persona> personas = new ArrayList<Persona>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readAll);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				personas.add(getPersona(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return personas;
	}
	
	private Persona getPersona(ResultSet resultSet) throws SQLException
	{
		String dni = resultSet.getString("Dni");
		String nombre = resultSet.getString("Nombre");
		String apellido = resultSet.getString("Apellido");
		return new Persona(dni, nombre, apellido);
	}

	@Override
	public boolean modify(Persona persona, Persona personaModif) {
		// TODO Auto-generated method stub
		PreparedStatement statement;
		Connection conn = Conexion.getConexion().getSQLConexion();
		boolean Exito = false;
		try {
			statement = conn.prepareStatement(modify);
			statement.setString(1, personaModif.getDni());
			statement.setString(2, personaModif.getNombre());
			statement.setString(3, personaModif.getApellido());
			statement.setString(4, persona.getDni());
			if(statement.executeUpdate() > 0) {
				conn.commit();
				Exito = true;
			} else {
				Exito = false;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Exito = false;
			try {
				conn.rollback();
				Exito = false;
			} catch (SQLException e1) {
				e1.printStackTrace();
				Exito = false;
			}
	}
		return Exito;
	}
}
