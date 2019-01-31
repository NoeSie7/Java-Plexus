package es.plexus.cedei.vuelos.vuelos;

import java.util.Date;

public class Vuelos {
	
	private String num_vuelo;
	private String origen;
	private String destino;
	private Date hsalida = new Date();
	private Date hllegada = new Date();
	private final long HORA = 3600 * 1000L;
	
	public Vuelos() {
		this.num_vuelo = "";
		this.origen = "";
		this.destino = "";
		this.hsalida = null;
		this.hllegada = null;
	}
	


	public Vuelos(String numero, String origen, String destino, Date horasalida , Date horallegada) {
		this.num_vuelo = numero;
		this.origen = origen;
	
		this.destino = destino;
		
		this.hsalida = horasalida;
		this.hllegada = horallegada;
	}
	
	
	public boolean evaluarLimite(Date date1, Date date2) {
//	    boolean correcto = false;
//	    
//	    if(date1.getTime() - date2.getTime() <= HORA) {
//	    correcto = true;
//	    }
	    return (date1.getTime() - date2.getTime()) <= this.HORA?true:false;
	    
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

	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}

	
	public Date getHsalida() {
		return hsalida;
	}

	public void setHsalida(Date hsalida) {
		this.hsalida = hsalida;
	}

	public Date getHllegada() {
		return hllegada;
	}

	public void setHllegada(Date hllegada) {
		this.hllegada = hllegada;
	}
	
	public void mostrar() {

		System.out.println("*******************************");
		System.out.println("Numero de vuelo:" + getNum_vuelo());
		System.out.println("Origen:" + getOrigen());
		System.out.println("Hora de Salida tipo fecha:" + getHsalida());
		System.out.println("Destino:" + getDestino());
		System.out.println("Hora de LLegada tipo fecha:" + getHllegada());
		System.out.println("*******************************");
		System.out.println("\n");
	}
}
