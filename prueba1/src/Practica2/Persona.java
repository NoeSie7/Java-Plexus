package Practica2;

public class Persona {
	protected  String dni;
	protected  String nombreapel;
	protected  Integer edad;
	
	Persona(){
		this.dni = " ";
		this.nombreapel = " ";
		this.edad = 0;
	}
	
	Persona( String dni, String nombre, Integer edad){
		this.dni = dni;
		this.nombreapel = nombre;
		this.edad = edad;
	}

	public String get_dni() {
		return this.dni;
	}
	public void set_dni(String aux) {
		this.dni = aux;
	}
	
	public String get_nombreapel() {
		return this.nombreapel;
	}
	public void set_nombreapel(String aux) {
		this.nombreapel = aux;
	}
	
	public Integer get_edad() {
		return this.edad;
	}
	public void set_edad(Integer aux) {
		this.edad = aux;
	}
	
	public void mostrar_persona() {
		System.out.println("dni: " + this.dni);
		System.out.println("nombre y apellido: " + this.nombreapel);
		System.out.println("edad: " + this.edad);
		
	}
}
