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
	
	@Override
	public boolean insert(Persona persona) {
		// TODO Auto-generated method stub
		PreparedStatement statement;
		Connection conn = Conexion.getConexion().getSQLConexion();
		Boolean Exito = false;
		try {
			statement = conn.prepareStatement(insert);
			statement.setInt(0, persona.getDni());
			statement.setString(1, persona.getNombre());
			statement.setString(2, persona.getApellido());
			if(statement.executeUpdate() > 0) {
				conn.commit();
				Exito = true;
			}else {
				Exito = false;
			}
		} catch (Exception e) {
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
	public boolean delete(Persona persona) {
		// TODO Auto-generated method stub
		PreparedStatement statement;
		Connection conn = Conexion.getConexion().getSQLConexion();
		boolean Exito = false;
		try {
			statement = conn.prepareStatement(delete);
			statement.setInt(0, persona.getDni());
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
		int dni = resultSet.getInt("Dni");
		String nombre = resultSet.getString("Nombre");
		String tel = resultSet.getString("Telefono");
		return new Persona(dni, nombre, tel);
	}

	@Override
	public boolean modify(Persona persona, Persona personaModif) {
		// TODO Auto-generated method stub
		PreparedStatement statement;
		Connection conn = Conexion.getConexion().getSQLConexion();
		boolean Exito = false;
		try {
			statement = conn.prepareStatement(modify);
			statement.setInt(0, personaModif.getDni());
			statement.setString(1, personaModif.getNombre());
			statement.setString(2, personaModif.getApellido());
			statement.setInt(3, persona.getDni());
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
