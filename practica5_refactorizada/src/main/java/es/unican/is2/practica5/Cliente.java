package es.unican.is2.practica5;

import java.util.LinkedList;
import java.util.List;

/*
 * METRICAS:
 * 
 * WMC: 3 (notas en el codigo)
 * CBO: -AFF (Número de clases que dependen de la clase analizada):0
 * 		-EFF (Número de clases de los que la clase depende):2
 * DIT (En una jerarquía de clases, longitud máxima desde una subclase hasta la clase raíz): 0
 * NOC (Número de subclases inmediatas de una clase dada): 0
 * CCog: 6 (notas en el codigo)
 */

public class Cliente {
	
	public String nombre;
	public Direccion direccion;
	public String telefono;
	public String dni;
    private List<Cuenta> Cuentas = new LinkedList<Cuenta>();

 	public Cliente(String nombre, Direccion direccion, String telefono, String dni) {  
 		this.nombre = nombre;
 		this.direccion=direccion;
 		this.telefono = telefono;
		this.dni = dni;
	}
	
	public void cambiaDireccion(Direccion nuevaDireccion) {
		this.direccion=nuevaDireccion;
	}
	
	public double getSaldoTotal() { //CC=3 CCog= 6
		double total = 0.0;
		for (Cuenta cuenta: Cuentas) {  //CC=1
			if (cuenta instanceof CuentaAhorro) { //CC=2
				total += ((CuentaAhorro) cuenta).getSaldo();
			} else if (cuenta instanceof CuentaValores)  { //CC=2
				for (Valor valor: ((CuentaValores) cuenta).getValores()) { //CC=3
					total += valor.getCotizacionActual()*valor.getNumValores();
				}
			}
		}
		return total;
	}
	
	public void anhadeCuenta(Cuenta cuenta) {
		Cuentas.add(cuenta);
	}
	
}