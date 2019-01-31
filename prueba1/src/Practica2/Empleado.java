package Practica2;

public class Empleado extends Persona {
	
	private String puesto;
	private String departamento;
	
	Empleado(){
		super.dni = " ";
		super.nombreapel = "";
		super.edad = 0;
		this.puesto = "";
		this.departamento = "";
		
	}
	
	Empleado( String dni, String nombre, Integer edad, String puesto, String departamento){
		super.dni = dni;
		super.nombreapel = nombre;
		super.edad = edad;
		this.puesto = puesto;
		this.departamento = departamento;
		
	}
	
	public  void set_puesto(String puesto) {
		this.puesto = puesto;
	}
	
	public String get_puesto() {
		return this.puesto;
	}
	
	public void set_departamento(String departamento) {
		this.departamento = departamento;
	}
	
	public String get_departamento() {
		return this.departamento;
	}
}
