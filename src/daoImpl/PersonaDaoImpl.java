package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;

import dao.PersonaDao;
import entidad.Persona;


public class PersonaDaoImpl implements PersonaDao
{
	private static final String insert = "INSERT INTO personas(dni, nombre, apellido) VALUES(?, ?, ?)";
	private static final String delete = "DELETE FROM personas WHERE dni = ?";
	private static final String readall = "SELECT * FROM personas";
	private static final String update = "UPDATE personas SET dni = ?, nombre = ?, apellido = ? where Dni = ?";
	private static final String validateDni = "Select * from personas where Dni = ?";
		
	public int insert(Persona persona)
	{
		if(validateDni(persona.getDni()) == false) {
			
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setString(1, persona.getDni());
			statement.setString(2, persona.getNombre());
			statement.setString(3, persona.getApellido());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				return 1;
			}
			else {
				return 2;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return -1;
		}
		
		}else {
			return 3;
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
			while(resultSet.next())
			{
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;

	}
	
	public boolean delete(Persona persona_a_eliminar)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			statement.setString(1, persona_a_eliminar.getDni());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isdeleteExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return isdeleteExitoso;
	}
	
	@Override
	public boolean modify(String Dni, Persona p) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(update);
			statement.setString(1, p.getDni());
			statement.setString(2, p.getNombre());
			statement.setString(3, p.getApellido());
			statement.setString(4, Dni);
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isInsertExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return isInsertExitoso;
	}
	
	public List<Persona> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<Persona> personas = new ArrayList<Persona>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
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
	
	public DefaultListModel<Persona> readAllDFL()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		DefaultListModel<Persona> personas = new DefaultListModel<Persona>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				personas.addElement(getPersona(resultSet));
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

	
}
