package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion 
{
	public static Conexion instancia;
	private Connection connection;
	
	private Conexion(String user, String password)
	{
		try
		{			
			String db = "bdPersonas";
			String host = "localhost";
			int port = 3306;		

			String url = String.format("jdbc:mysql://%s:%d/%s?useSSL=false", host, port, db);

			this.connection = DriverManager.getConnection(url, user, password);
			this.connection.setAutoCommit(false);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public static Conexion getConexion()   
	{								
		if(instancia == null)
		{
			instancia = new Conexion("root","root");
		}
		return instancia;
	}

	public Connection getSQLConexion() 
	{
		return this.connection;
	}
	
	public void cerrarConexion()
	{
		try 
		{
			this.connection.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		instancia = null;
	}
}
