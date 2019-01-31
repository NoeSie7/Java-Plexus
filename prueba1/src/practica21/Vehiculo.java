package practica21;

public class Vehiculo { 
		private String matricula;
		private int noPuertas; 
		private int noRuedas; 
		private String modelo; 
	
	public Vehiculo(){
		this.matricula = "";
		this.noPuertas = 0;
		this.noRuedas = 0;
		this.modelo = "";
	}
	
	public Vehiculo(String matric, int puertas, int ruedas, String modelo) {
		this.matricula = matric;
		this.noPuertas = puertas;
		this.noRuedas = ruedas;
		this.modelo = modelo;
	}
	
	public void setNoPuertas(int np) {
		noPuertas = np; 
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getNoRuedas() {
		return noRuedas;
	}

	public void setNoRuedas(int noRuedas) {
		this.noRuedas = noRuedas;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getNoPuertas() {
		return noPuertas;
	} 
}
