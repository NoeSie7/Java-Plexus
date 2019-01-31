package practica22;

public class Vuelos {
	
	private String num_vuelo;
	private String origen;
	private String h_salida;
	private String destino;
	private String h_llegada;
	
	public Vuelos() {
		this.num_vuelo = "";
		this.origen = "";
		this.h_salida = "";
		this.destino = "";
		this.h_llegada = "";
	}
	
	public Vuelos(String numero, String origen, String hsalida, String destino, String hllegada) {
		this.num_vuelo = numero;
		this.origen = origen;
		this.h_salida = hsalida;
		this.destino = destino;
		this.h_llegada = hllegada;
	}
	
	public String getNum_vuelo() {
		return num_vuelo;
	}
	public void setNum_vuelo(String num_vuelo) {
		this.num_vuelo = num_vuelo;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getH_salida() {
		return h_salida;
	}
	public void setH_salida(String h_salida) {
		this.h_salida = h_salida;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getH_llegada() {
		return h_llegada;
	}
	public void setH_llegada(String h_llegada) {
		this.h_llegada = h_llegada;
	}
	
	
}
