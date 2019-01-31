package practica21;

public final class CocheDeportivo extends Vehiculo { 
		
		private String capacidadMotor;
		private int maxVelocidad;

		public CocheDeportivo(){
			super();
			this.capacidadMotor = "";
			this.maxVelocidad = 0;
		}
		
		
		public CocheDeportivo(String mat, int puertas, int ruedas, String modelo, String motor, int velocidadmax) {
			super(mat, puertas, ruedas, modelo);
			this.capacidadMotor = motor;
			this.maxVelocidad = velocidadmax;
		}
		
		public void setCapacidadMotor(String cm) {
			capacidadMotor = cm; 
		
		}

		public int getMaxVelocidad() {
			return maxVelocidad;
		}

		public void setMaxVelocidad(int maxVelocidad) {
			this.maxVelocidad = maxVelocidad;
		}

		public String getCapacidadMotor() {
			return capacidadMotor;
		}
}
