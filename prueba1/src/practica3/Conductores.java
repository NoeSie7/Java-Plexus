package practica3;

public class Conductores {
	
	private String dni;
	private String nombre_conductor;
	private String apellido;
	private Integer edad;
	
		public Conductores() {
			this.dni = "";
			this.nombre_conductor = "";
			this.apellido = "";
			this.edad = 0;
		}
		
		public Conductores(String dni, String nombre, String apellido, Integer edad) {
			this.dni = "";
			this.nombre_conductor = "";
			this.apellido = "";
			this.edad = 0;
		}
	
		public String getDni() {
			return dni;
		}
		public void setDni(String dni) {
			this.dni = dni;
		}
		public String getNombre() {
			return nombre_conductor;
		}
		public void setNombre(String nombre) {
			this.nombre_conductor = nombre;
		}
		public String getApellido() {
			return apellido;
		}
		public void setApellido(String apellido) {
			this.apellido = apellido;
		}
		public Integer getEdad() {
			return edad;
		}
		public void setEdad(Integer edad) {
			this.edad = edad;
		}
		
		public void mostrar() {
			System.out.println(getDni());
			System.out.println(getNombre());
			System.out.println(getApellido());
			System.out.println(getEdad());
		}
	
	
}
