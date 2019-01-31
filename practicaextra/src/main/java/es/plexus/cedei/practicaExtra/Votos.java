package es.plexus.cedei.practicaExtra;

public class Votos {
	
	String nombre;
	String nominacion;
	Integer cont;


	public Votos(){
		this.nombre = "";
		this.nominacion = "";
		this.cont = 0;
		
	}

	public Votos(String nombre, String nom, Integer num) {
		this.nombre = nombre;
		this.nominacion = nom;
		this.cont = num;
		
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNominacion() {
		return nominacion;
	}

	public void setNominacion(String nominacion) {
		this.nominacion = nominacion;
	}
	
	public Integer contar(String nom) {
		
		if(nom.equals(nombre)) {
			this.cont++;
		}else {
			
		}
		return this.cont;
	}
	
	public void mostrar_nominaciones() {
		System.out.println("Nominados");
		System.out.println("*******************************");
		System.out.println("Nombre: " + getNombre());
		System.out.println("Nominacion: " + getNominacion());
		System.out.println("Numero: " + getCont());
		System.out.println("*******************************");
	}

	public Integer getCont() {
		return cont;
	}

	public void setCont() {
		this.cont++;
	}


}
