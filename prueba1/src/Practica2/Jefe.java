package Practica2;

import java.util.ArrayList;

public class Jefe extends Persona {
	
	private Double salario;
	private ArrayList<Empleado> Listaempleadosjefe = new ArrayList<Empleado>();

	public Jefe(){
		super.dni = "";
		 super.nombreapel = "";
		 super.edad = 0;
		 this.salario = 0.0;
		 this.Listaempleadosjefe = null;
	}
	
	public Jefe(String dni, String nombre, Integer edad, Double salario, Empleado e){
		 super.dni = dni;
		 super.nombreapel=nombre;
		 super.edad=edad;
		 this.salario= salario;
		 this.Listaempleadosjefe.add(e);
		 
	 }
	 
	 public void set_salario(Double salario) {
		 this.salario = salario;
	 }
	 
	 public  Double get_salario() {
		 return this.salario;
	 }
	 
	 
	 public void set_empleados(Empleado p1) {
		 Listaempleadosjefe.add(p1);
	 }
	 
	 public ArrayList<Empleado> get_empleado() {
		return  this.Listaempleadosjefe;
	 }
	 
	 public void mostrar_empleados_jefe() {
		 for(int i=0; i < Listaempleadosjefe.size();++i) {
				System.out.println("Persona:" + i);
				System.out.println("DNI:" + Listaempleadosjefe.get(i).get_dni());
				System.out.println("Nombre y apellidos:" + Listaempleadosjefe.get(i).get_nombreapel());
				System.out.println("Edad:" + Listaempleadosjefe.get(i).get_edad());
				System.out.println("Puesto:" + Listaempleadosjefe.get(i).get_puesto());
				System.out.println("Departamento:" + Listaempleadosjefe.get(i).get_departamento());
				System.out.println("\n");
			}
	 }
}
