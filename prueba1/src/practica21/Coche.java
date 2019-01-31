package practica21;

public class Coche extends Vehiculo { 
	
	private boolean airbags;
	
	
	public Coche(){
		super();
		this.airbags = false;
	}

	public Coche(String mat, int puertas, int ruedas, String modelo, boolean air) {
		super(mat, puertas,ruedas,modelo);
		this.airbags = air;
	}
	public boolean isAirbags() {
		return airbags;
	}

	public void setAirbags(boolean airbags) {
		this.airbags = airbags;
	} 
	
	
}
