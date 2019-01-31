package es.plexus.cedei.practica3.logistica;

public class Envios extends Conductores{
	
	private String origen;
	private String destino;
	private String nombre_destinatario;
	private String direccion;
	private Double peso;
	private Boolean dua;
	
	
	public Envios() {
		super();
		this.origen = "";
		this.destino = "";	
		this.nombre_destinatario = "";
		this.direccion = "";
		this.peso = 0.0;
		this.dua = false;
	}
	
	public Envios(String dni, String nombre_conductor, String apellidos, Integer edad, String origen, String destino, String nombre, String direccion, Double peso, Boolean DUA) {
		super(dni,nombre_conductor,apellidos, edad);
		this.origen = origen;
		this.destino = destino;	
		this.nombre_destinatario = nombre;
		this.direccion = direccion;
		this.peso = peso;
		this.dua = DUA;
	}
	
	
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getNombreDestinatario() {
		return nombre_destinatario;
	}
	public void setNombreDestinatario(String nombre) {
		this.nombre_destinatario = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public Boolean getDUA() {
		return dua;
	}
	public void setDUA(Boolean dUA) {
		dua = dUA;
	}
	
	
	
	
}
