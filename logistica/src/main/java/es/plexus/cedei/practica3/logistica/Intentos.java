package es.plexus.cedei.practica3.logistica;

public class Intentos extends Envios{
	private Integer num_envios;
	private String fecha;
	private String hora_entrega;
	private Boolean ausente;
	
	public Intentos() {
		super();
		this.num_envios = 0;
		this.fecha = "";
		this.hora_entrega = "";
		this.ausente = false;
		
	}
	
	public Intentos(String dni, String nombre_conductor, String apellidos, Integer edad, String origen, String destino, String nombre, String direccion, Double peso, Boolean DUA, Integer num_envios, String fecha, String hora, Boolean ausente) {
		super(dni, nombre_conductor, apellidos, edad, origen, destino, nombre,direccion,peso, DUA);
		this.num_envios = num_envios;
		this.fecha = fecha;
		this.hora_entrega = hora;
		this.ausente = ausente;
		
	}
	
	
	public Integer getNum_envios() {
		return num_envios;
	}
	public void setNum_envios(Integer num_envios) {
		this.num_envios = num_envios;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora_entrega() {
		return hora_entrega;
	}
	public void setHora_entrega(String hora_entrega) {
		this.hora_entrega = hora_entrega;
	}
	public Boolean getAusente() {
		return ausente;
	}
	public void setAusente(Boolean ausente) {
		this.ausente = ausente;
	}
	
	
	
}
