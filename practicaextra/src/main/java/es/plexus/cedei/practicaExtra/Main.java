package es.plexus.cedei.practicaExtra;


import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;




public class Main  {
	
	static String[] x;
	private static ArrayList<Votos> listavotos = new ArrayList<Votos>();
	private static ArrayList<Votos> listavotoscontados = new ArrayList<Votos>();
	private static ArrayList<Votos> listavotoscontadosunicos = new ArrayList<Votos>();
	static ArrayList<Votos> listaCopiada;
	static HashMap<String, Votos> hmap1 = new HashMap<String, Votos>();
	static HashMap<String, Integer> hmap = new HashMap<String, Integer>();
	private static ArrayList<String> listanombres = new ArrayList<String>();
	static HashSet hs = new HashSet<Votos>();
	
	static List<Votos> aux;

	static int[] numeros;
	static Integer cont = 0;
	static int start = 0;
	


	
	
    public static void main( String[] args )
    {
    		leer_fichero();   		
    		contar_votos();
    		mostrar_votos();
    		mostrar_graficos();
    		ordenar_votos();
    		
    }

    
    public static void ordenar_votos() {
    	List<Votos> personasConmasvotos = new ArrayList<>(hmap1.values());

        Collections.sort(personasConmasvotos , new Comparator<Votos>() {

            public int compare(Votos o1, Votos o2) {
                return  o2.getCont() - o1.getCont() ;
            }
        });
        Ventana V = new Ventana(); 
        JPanel j = new JPanel();
        JLabel vacio = new JLabel();
        for (int i = 0 ; i < 3;++i) {
        	JLabel label1 = new JLabel();
            System.out.println(personasConmasvotos.get(i).getNombre() + "\t" + personasConmasvotos.get(i).getCont());
            label1.setText("Candidato: " +  personasConmasvotos.get(i).getNombre()+ " con Nº Votos: "+ personasConmasvotos.get(i).getCont()+"</br>");
            vacio.setText(" ");
            V.setTitle("Candidatos con mas votos");
            V.getContentPane().add(label1);
            V.add(label1);
            V.add(vacio);
        }
        
        V.setLayout(new FlowLayout()); 
       
//        
	    V.setVisible(true);
//        
        
         //return personasConmasvotos;
    }
    
    public static void mostrar_graficos() {
    	
    	
    	DefaultPieDataset dataset = new DefaultPieDataset();
    	
    	Set set2 = hmap.entrySet();
		 Iterator iterator2 = set2.iterator();
	      while(iterator2.hasNext()) {
	          Map.Entry mentry2 = (Map.Entry)iterator2.next();
	          dataset.setValue((String)mentry2.getKey(), (Integer)mentry2.getValue());
	          System.out.print("Nombre: "+mentry2.getKey() + " Y su numero de votos es: " + mentry2.getValue()+"\n");
	          
	       }
    	
    	
    	
    	JFreeChart chart = ChartFactory.createPieChart("Grafico de nominaciones", dataset, true, true, true);
		
		ChartFrame cf = new ChartFrame("Graficos estadistico", chart);
		
		cf.pack();
		cf.setLocationRelativeTo(null);
		cf.setVisible(true);
    }
    
   public static void mostrar_votos() {
	   Set set2 = hmap.entrySet();
		 Iterator iterator2 = set2.iterator();
	      while(iterator2.hasNext()) {
	          Map.Entry mentry2 = (Map.Entry)iterator2.next();
	          //System.out.print("Nombre: "+mentry2.getKey() + " Y su numero de votos es: " + mentry2.getValue()+"\n");
	          
	       }
   }
   
    
    public static void contar_votos() {
    	    	
    	
    	for(int i=0; i < listavotos.size();++i) {
    		
    		for(int j=0; j< listavotos.size();++j) {
    			
    			if(listavotos.get(i).getNombre().equals(listavotos.get(j).getNombre())) {
    				listavotos.get(i).setCont();
    			
    			}
    		}
    		Votos v = new Votos(listavotos.get(i).getNombre(),listavotos.get(i).getNominacion(),listavotos.get(i).getCont());
    		
    		System.out.println("El participante: "+ listavotos.get(i).getNombre()+" tiene: "+ listavotos.get(i).getCont() + " votos");
    		hmap.put(listavotos.get(i).getNombre(), listavotos.get(i).getCont());
    		hmap1.put(listavotos.get(i).getNombre(), v);
    		cont=0;
    	}
    	 
    }
    
    
   
    
    public static void leer_fichero() {
		
    	String fichero = "";	
		try {
		      FileReader fr = new FileReader("C:\\Users\\Usuario\\eclipse-workspace\\practicaextra\\fichero\\nominaciones.txt");
		      BufferedReader br = new BufferedReader(fr);
		 
		      String linea;

		      while((linea = br.readLine()) != null) {
		    	   Votos v = new Votos();
		    	  
		    	  
		    	  x = linea.split(";"); //guardamos en el array
		    	 System.out.println(x[0]);
		    	 System.out.println(x[1]);
		    	 v.setNombre(x[0]);
		    	 v.setNominacion(x[1]);
		    	 listavotos.add(v);
		    	 listanombres.add(x[0]);
		    	 	
		      }
		   		      
		      fr.close();
		    }
		    catch(Exception e) {
		      System.out.println("Excepcion leyendo fichero "+ fichero + ": " + e);
		    }
    }
    
    
    
    
    
	public static void mostrar_nominados() {
		
		for(int i = 0 ; i < listavotos.size(); ++i) {
			listavotos.get(i).mostrar_nominaciones();
		}
		System.out.println("Total de votos en el listado: " +  listavotos.size());
	}

    
//  public static void contar_votos() {
//  	
//  	numeros = new int[listavotos.size()];
//  	
//  	for(int i = 0 ; i < listavotos.size(); ++i) {
//			//System.out.println(listavotos.get(i).getNominacion());
//			String sSubCadena = listavotos.get(i).getNominacion().substring(10,11);
//			int aux = Integer.parseInt(sSubCadena);
//			numeros[i] = aux;
//			//System.out.println(sSubCadena);
//			
//		}
//  
//  	int i, j;
//  	int indice;
//  	
//  	i = numeros.length - 1;
//  	
//  	while(i > 0 ) {
//  		indice = 0;
//  		for(j=0; j< i ;++j) {
//  			if(numeros[j+1]  <  numeros[j]) {
//  				int aux = numeros[j];
//  				numeros[j]= numeros[j+1];
//  				indice = j;
//  			}
//  			i = indice;
//  		}
//  	}
//  	
//  }
	
	
	
	
	
	
//public void showGraphic(List<Nominacion> listaNominaciones, List<Nominacion> listaResultados) {
//		
//		listaResultados.clear();
//		
//		List<String> listaNombres = new ArrayList<String>(new HashSet<>(listaNominaciones.stream().map(Nominacion::getNombre).collect(Collectors.toList())));
//		
//		for(String ln : listaNombres) {
//			
//			for(Nominacion nl : listaNominaciones) {
//				
//				if(ln.equalsIgnoreCase(nl.getNombre())) {
//					
//					resultado = resultado + nl.getNominacion();
//					
//				}
//				
//			}
//			
//			Nominacion n = new Nominacion(ln, resultado);
//			
//			listaResultados.add(n);
//			
//			resultado = 0;
//			
//		}
//		
//		for(Nominacion lr : listaResultados) {
//			
//			dataset.setValue(lr.getNombre(), lr.getNominacion());
//			
//		}
//		
//		JFreeChart chart = ChartFactory.createPieChart("Lista de nominaciones", dataset, true, true, true);
//		
//		ChartFrame cf = new ChartFrame("Graficos estadistico", chart);
//		
//		cf.pack();
//		cf.setLocationRelativeTo(null);
//		cf.setVisible(true);
//		
//	}
}

