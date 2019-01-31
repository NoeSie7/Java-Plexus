package practica3;

import java.awt.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import practica21.Coche;
import practica21.CocheDeportivo;
import practica22.Vuelos;

public class Main {
	
	static Integer opc = 0;
	static String[] x;
	private static ArrayList<Conductores> listaconductores = new ArrayList<Conductores>();
	private static ArrayList<Envios> listaenvios = new ArrayList<Envios>();
	private static ArrayList<Intentos> listaintento = new ArrayList<Intentos>();
	
	public static void main(String[] args)    {
			while (opc<9) {
						
					 	Scanner reader = new Scanner(System.in);
					 	System.out.println("1) Gestionar conductores");
					 	System.out.println("2) Gestionar envios");
					 	System.out.println("3) Gestionar intentos");
					 	System.out.println("4) Mostrar conductores");
					 	System.out.println("5) Leer de fichero");
					 	System.out.println("6) Listar envios por dia");
					 	System.out.println("7) Listar envios por DUA");
					 	System.out.println("8) Listar envios del dia que no han sido entregados");
					 	
					 
						opc = reader.nextInt();
										
						switch (opc) {
						
						case 1:
							System.out.println("Gestionar conductor");
								gestionar_conductor();
							break;
						case 2:
							System.out.println("Gestionar Envio");
								gestionar_envio();
							break;
						case 3:
							System.out.println("Intentos");
								anadir_intento();
							break;
						case 4:
							System.out.println("Mostrar conductores");
							mostrar_conductores();
							break;
						case 5:
							System.out.println("Leer de fichero");
							leer_fichero();
							break;
						case 6:
							System.out.println("Listar envios por fecha");
							listar_envios();
							break;
						case 7:
							System.out.println("Listar envios por DUA");
							listar_DUA();
							break;
						case 8:
							System.out.println("Listar envios del dia que no han sido entregados");
							listar_sinentrega();
							break;
						
							
						default: System.out.println("Ha salido del programa");
							break;
						}
					 }
	}
	
	
	

	public static void listar_DUA() {
		Boolean dua;
		
		
		 
		 Scanner reader = new Scanner(System.in);
		
		 Conductores nuevo;
		 
			//Pedimos datos
			System.out.println("Mostrar envios con DUA, (TRUE OR FALSE)");
			dua = reader.nextBoolean();
			
			
			
			for(int i = 0 ; i < listaenvios.size(); ++i) {
				
				if(dua.equals(listaenvios.get(i).getDUA())) {
					
					//for(int k = 0; k < listaenvios.size(); ++k) {
						
						System.out.println("Envio:" + i);
						System.out.println("*******************************");
						System.out.println("DNI repartidor: "+ listaenvios.get(i).getDni());
						System.out.println("Nombre Conductor:" + listaenvios.get(i).getNombre());
						System.out.println("Apellidos: " + listaenvios.get(i).getApellido());
						System.out.println("Edad: "+listaenvios.get(i).getEdad());
						System.out.println("Origen del paquete:" + listaenvios.get(i).getOrigen());
						System.out.println("Destino del paquete:" + listaenvios.get(i).getDestino());
						System.out.println("Nombre destinatario: "+ listaenvios.get(i).getNombreDestinatario());
						System.out.println("Direccion: " + listaenvios.get(i).getDireccion());
						System.out.println("Peso del paquete: " + listaenvios.get(i).getPeso());
						System.out.println("Dua: " + listaenvios.get(i).getDUA());
						System.out.println("*******************************");
					//}
					
				}
				
			}
	}
	
	
	public static void leer_fichero() {
		String fichero = "";	
		try {
		      FileReader fr = new FileReader("C:\\Users\\Usuario\\eclipse-workspace\\prueba1\\data3\\pedidos.txt");
		      BufferedReader br = new BufferedReader(fr);
		 
		      String linea;

		      while((linea = br.readLine()) != null) {
		    	  Conductores c = new Conductores();
		    	  Envios e = new Envios();
		    	  Intentos i = new Intentos();
		    	  
		    	  
		    	  x = linea.split(";"); //guardamos en el array
		    	  
		    	  ////////////////CONDUCTORES//////////////////////////
		    	  c.setDni(x[0]);
		    	  c.setNombre(x[1]);
		    	  c.setApellido(x[2]);
		    	  c.setEdad(Integer.parseInt(x[3]));
		    	  
		    	  ////////////////////ENVIOS///////////////////////////////
		    	  
		    	  e.setDni(x[0]);
		    	  e.setNombre(x[1]);
		    	  e.setApellido(x[2]);
		    	  e.setEdad(Integer.parseInt(x[3]));
		    	  e.setOrigen(x[4]);
		    	  e.setDestino(x[5]);
		    	  e.setNombreDestinatario(x[6]);
		    	  e.setDireccion(x[7]);
		    	  e.setPeso(Double.parseDouble(x[8]));
		    	  e.setDUA(Boolean.parseBoolean(x[9]));
		    	  
		    	  ////////////////////INTENTOS///////////////////////////////
		    	  
		    	  
		    	  i.setDni(x[0]);
		    	  i.setNombre(x[1]);
		    	  i.setApellido(x[2]);
		    	  i.setEdad(Integer.parseInt(x[3]));
		    	  i.setOrigen(x[4]);
		    	  i.setDestino(x[5]);
		    	  i.setNombreDestinatario(x[6]);
		    	  i.setDireccion(x[7]);
		    	  i.setPeso(Double.parseDouble(x[8]));
		    	  i.setDUA(Boolean.parseBoolean(x[9]));
		    	  i.setNum_envios(Integer.parseInt(x[10]));
		    	  i.setFecha(x[11]);
		    	  i.setHora_entrega(x[12]);
		    	  i.setAusente(Boolean.parseBoolean(x[13]));
		    	  
		    	  
		    	  //añadimos lista
		    	  listaconductores.add(c);
		    	  listaenvios.add(e);
		    	  listaintento.add(i);
		    	  
		    	  
		    	  
		        System.out.println(linea);
		      }
		   		      
		      fr.close();
		    }
		    catch(Exception e) {
		      System.out.println("Excepcion leyendo fichero "+ fichero + ": " + e);
		    }
	}
	
	
	
	public static void listar_envios() {
		String fecha;
	
		
		 
		 Scanner reader = new Scanner(System.in);
		
		 Conductores nuevo;
		 
			//Pedimos datos
			System.out.println("Introduzca el dia a buscar en envios");
			fecha = reader.nextLine();
			
			
			
			for(int i = 0 ; i < listaintento.size(); ++i) {
				
				if(fecha.equals(listaintento.get(i).getFecha())) {
					
					//for(int k = 0; k < listaenvios.size(); ++k) {
						
						System.out.println("Envio:" + i);
						System.out.println("*******************************");
						System.out.println("DNI repartidor: "+ listaenvios.get(i).getDni());
						System.out.println("Nombre Conductor:" + listaenvios.get(i).getNombre());
						System.out.println("Apellidos: " + listaenvios.get(i).getApellido());
						System.out.println("Edad: "+listaenvios.get(i).getEdad());
						System.out.println("Origen del paquete:" + listaenvios.get(i).getOrigen());
						System.out.println("Destino del paquete:" + listaenvios.get(i).getDestino());
						System.out.println("Nombre destinatario: "+ listaenvios.get(i).getNombreDestinatario());
						System.out.println("Direccion: " + listaenvios.get(i).getDireccion());
						System.out.println("Peso del paquete: " + listaenvios.get(i).getPeso());
						System.out.println("Dua: " + listaenvios.get(i).getDUA());
						System.out.println("*******************************");
					//}
					
				}
				
			}
		 
	}
	
	
	public static void listar_sinentrega() {
		String fecha;
		Boolean ausente = true;
	
		
		 
		 Scanner reader = new Scanner(System.in);
		
		 Conductores nuevo;
		 
			//Pedimos datos
			System.out.println("Introduzca el dia a buscar en envios");
			fecha = reader.nextLine();
			
			
			
			for(int i = 0 ; i < listaintento.size(); ++i) {
				
				if(fecha.equals(listaintento.get(i).getFecha())&&(ausente.equals(listaintento.get(i).getAusente()))) {
					
					//for(int k = 0; k < listaenvios.size(); ++k) {
						
						System.out.println("Envio:" + i);
						System.out.println("*******************************");
						System.out.println("DNI repartidor: "+ listaenvios.get(i).getDni());
						System.out.println("Nombre Conductor:" + listaenvios.get(i).getNombre());
						System.out.println("Apellidos: " + listaenvios.get(i).getApellido());
						System.out.println("Edad: "+listaenvios.get(i).getEdad());
						System.out.println("Origen del paquete:" + listaenvios.get(i).getOrigen());
						System.out.println("Destino del paquete:" + listaenvios.get(i).getDestino());
						System.out.println("Nombre destinatario: "+ listaenvios.get(i).getNombreDestinatario());
						System.out.println("Direccion: " + listaenvios.get(i).getDireccion());
						System.out.println("Peso del paquete: " + listaenvios.get(i).getPeso());
						System.out.println("Dua: " + listaenvios.get(i).getDUA());
						System.out.println("*******************************");
					//}
					
				}
				
			}
		 
	}
	
	public static void anadir_intento() {
		String dni;
		String nombre = "";
		String apellido = "";
		Integer edad = 0;
		String origen = "";
		String destino = ""; 
		String nombre_destinatario;
		String direccion = "";
		Double peso;
		Boolean dua = null;
		Integer num_int;
		String fecha;
		String hora;
		Boolean ausente;
		
		 
		 Scanner reader = new Scanner(System.in);
		
		 Intentos nuevo;
		 
			//Pedimos datos
			System.out.println("Introduzca DNI del conductor que va a gestionar el envio");
			dni = reader.nextLine();
			System.out.println("Introduzca el nombre del destinatario");
			nombre_destinatario= reader.nextLine();
			System.out.println("Introduzca el peso del paquete");
			peso= reader.nextDouble();
			System.out.println("Introduzca el numero de intento");
			num_int= reader.nextInt();
			System.out.println("Introduzca la fecha");
			fecha= reader.nextLine();
			System.out.println("Introduzca la hora");
			hora= reader.nextLine();
			System.out.println("Introduzca si estaba ausente o no (True or False)");
			ausente= reader.nextBoolean();
			

			
			for(int i=0; i < listaconductores.size();++i) {
				if(dni.equals(listaconductores.get(i).getDni())) {
						nombre=listaconductores.get(i).getNombre();
						apellido=listaconductores.get(i).getApellido();
						edad=listaconductores.get(i).getEdad();
					}
			}
			
			for(int i=0; i < listaenvios.size();++i) {
				if((nombre_destinatario.equals(listaenvios.get(i).getNombreDestinatario()) && (peso.equals(listaenvios.get(i).getPeso())))) {
						origen = listaenvios.get(i).getOrigen();
						destino = listaenvios.get(i).getDestino();
						direccion = listaenvios.get(i).getDireccion();
						dua = listaenvios.get(i).getDUA();
					}
			}
			
			nuevo = new Intentos(dni, nombre, apellido, edad,origen, destino, nombre_destinatario, direccion, peso, dua, num_int,fecha, hora, ausente);
			listaintento.add(nuevo);
		
	}
	
	
	public static void gestionar_envio() {
		Scanner reader = new Scanner(System.in);
	 	System.out.println("1) Añadir envio");
	 	System.out.println("2) Eliminar envio");
	 	
		opc = reader.nextInt();
						
		switch (opc) {
		
		case 1:
			System.out.println("Crear envio");
				crear_envio();
			break;
		case 2:
			System.out.println("Eliminar envio");
				eliminar_envio();
			break;
		
		default: System.out.println("Opción no válida");
			break;
		}
	}
	
	
	public static void crear_envio() {
		String dni;
		String nombre = "";
		String apellido = "";
		Integer edad = 0;
		String origen;
		String destino; 
		String nombre_destinatario;
		String direccion;
		Double peso;
		Boolean dua;
		
		 
		 Scanner reader = new Scanner(System.in);
		
		 Envios nuevo;
		 
			//Pedimos datos
			System.out.println("Introduzca DNI del conductor que va a gestionar el envio");
			dni = reader.nextLine();
			System.out.println("Introduzca el origen del paquete");
			origen = reader.nextLine();
			System.out.println("Introduzca el destino del paquete");
			destino = reader.nextLine();
			System.out.println("Introduzca el nombre del destinatario");
			nombre_destinatario= reader.nextLine();
			System.out.println("Introduzca la direccion del destinatario");
			direccion= reader.nextLine();
			System.out.println("Introduzca el peso del paquete");
			peso= reader.nextDouble();
			System.out.println("Introduzca si tiene DUA o no(True or false)");
			dua= reader.nextBoolean();
			
			for(int i=0; i < listaconductores.size();++i) {
				if(dni.equals(listaconductores.get(i).getDni())) {
						nombre=listaconductores.get(i).getNombre();
						apellido=listaconductores.get(i).getApellido();
						edad=listaconductores.get(i).getEdad();
					}
			}
		
			nuevo = new Envios(dni, nombre, apellido, edad,origen, destino, nombre_destinatario, direccion, peso, dua);
			listaenvios.add(nuevo);
			
	}
	
	public static void eliminar_envio() {
		String nombre_destinatario;
		Double peso;
		
		 Scanner reader = new Scanner(System.in);
		
		 
			//Pedimos datos
			System.out.println("Introduzca el nombre del destinatario del paquete a eliminar");
			nombre_destinatario = reader.nextLine();
		
			System.out.println("Introduzca el peso del paquete");
			peso = reader.nextDouble();
			
			for(int i=0; i < listaenvios.size();++i) {
				if(nombre_destinatario.equals(listaenvios.get(i).getDni())&&( peso.equals(listaenvios.get(i).getPeso()))) {
						listaenvios.remove(i);
					}
			}
	}
	
	
	public static void gestionar_conductor() {
		Scanner reader = new Scanner(System.in);
	 	System.out.println("1) Añadir conductor");
	 	System.out.println("2) Eliminar conductor");
	 	
		opc = reader.nextInt();
						
		switch (opc) {
		
		case 1:
			//System.out.println("Crear conductor");
				crear_conductor();
			break;
		case 2:
			//System.out.println("Eliminar conductor");
				eliminar_conductor();
			break;
		
		default: System.out.println("Opción no válida");
			break;
		}
	}
	
	
	public static void eliminar_conductor() {
		
		 String dni;
		 Scanner reader = new Scanner(System.in);
		
		 
			//Pedimos datos
			System.out.println("Introduzca el DNI del conductor a eliminar");
			dni = reader.nextLine();
		
			for(int i=0; i < listaconductores.size();++i) {
				if(dni.equals(listaconductores.get(i).getDni())) {
						listaconductores.remove(i);
					}
			}
	}
	
	public static void crear_conductor() {
		
		String dni;
		String nombre;
		String apellido; 
		Integer edad;
		
		 
		 Scanner reader = new Scanner(System.in);
		
		 Conductores nuevo;
		 
			//Pedimos datos
			System.out.println("Introduzca DNI del conductor");
			dni = reader.nextLine();
			System.out.println("Introduzca el nombre del conductor");
			nombre = reader.nextLine();
			System.out.println("Introduzca el apellido del conductor");
			apellido = reader.nextLine();
			System.out.println("Introduzca la edad del conductor");
			edad = reader.nextInt();
		
			nuevo = new Conductores(dni, nombre, apellido, edad);
			listaconductores.add(nuevo);
		 
	}
	
	public static void mostrar_conductores() {
		for(int i = 0 ; i < listaconductores.size(); ++i) {
			
			System.out.println("Conductor:" + i);
			System.out.println("*******************************");
			System.out.println("DNI: " + listaconductores.get(i).getDni());
			System.out.println("Nombre: " + listaconductores.get(i).getNombre());
			System.out.println("Apellido: " + listaconductores.get(i).getApellido());
			System.out.println("Edad: " + listaconductores.get(i).getEdad());
			System.out.println("*******************************");
		}
		System.out.println("Total de conductores: " +  listaconductores.size());
	}
}
