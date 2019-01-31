package prueba1;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class numero {
	
	 public static void main(String[] args)    {
		    Integer numero1 = 0;
			Integer numero2 = 0;
			Integer suma = 0;
			Integer resta = 0;
			Integer multiplicacion = 0;
			Integer resto = 0;
			Integer cociente = 0;
			Integer auxmayor = 0;
			Integer radio = 0;
			String valor;
			
			
		 
		//Escritura 
		Scanner reader = new Scanner(System.in);
		Scanner reader1 = new Scanner(System.in);
		Scanner reader2 = new Scanner(System.in);
		
		
		//Pedimos datos
		System.out.println("Introduzca el primer operando");
		numero1 = reader.nextInt();
		System.out.println("Introduzca el primer operando");
		numero2 = reader1.nextInt();
		
		
		//Mostramos operandos introducidos 
		System.out.println("Op1:"+numero1+" Op2:"+ numero2+" ");
		
		//Operaciones
		suma = numero1 + numero2;
		resta = numero1 - numero2;
		multiplicacion = numero1 * numero2;
		cociente = numero1 / numero2;
		resto = numero1 % numero2;
		
		//Resultados
		
		System.out.println("La suma es: "+ suma +" ");
		System.out.println("La resta es: "+ resta +" ");
		System.out.println("La multiplicacion es: "+ multiplicacion +" ");
		System.out.println("La division, su cociente es: "+ resto +" ");
		System.out.println("La division, su resto es: "+ cociente +" ");
		auxmayor = mayor(numero1, numero2);
		System.out.println("El mayor de los dos numeros es: "+ auxmayor +" ");
		
		//Pedimos datos para el area dl circulo
				System.out.println("Introduzca el radio para calcular el area de un circulo");
				radio = reader.nextInt();
		System.out.println("El Área del circulo es: " + Math.PI * Math.pow(radio,2));
		
		valor = JOptionPane.showInputDialog("Introduce un valor para calcular el Igic"); 
		 int number = Integer.parseInt(valor);
		 System.out.println("Su producto con Igic es: "+ number * 0.07 );
		
	 }
	 
	 public static Integer mayor(Integer uno, Integer dos) {
		 Integer aux=0;
		 
		 if( uno > dos) {
			 aux = uno;
		 }else {
			 aux = dos;
		 }
		 return aux;
	 }
		 
	 
}

