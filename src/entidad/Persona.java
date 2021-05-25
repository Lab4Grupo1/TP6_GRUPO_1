package entidad;

public class Persona {
	//**Propiedades**//
	private String Dni;
	private String Nombre;
	private String Apellido;
	
	public Persona() {
		
	}
	
	public Persona(String dni, String nom, String ape) {
		Dni = dni;
		Nombre = nom;
		Apellido = ape;
	}
	
	//****Metodos***//
	
	//Get y Set
	public String getDni() {
		return Dni;
	}
	public void setDni(String dni) {
		this.Dni = dni;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		this.Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		this.Apellido = apellido;
	}
	@Override
	public String toString() {
		return "Dni: " + Dni + ", Nombre: " + Nombre + ", Apellido=" + Apellido;
	}
	
	

}
