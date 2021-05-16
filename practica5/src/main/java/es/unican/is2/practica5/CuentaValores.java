package es.unican.is2.practica5;

import java.util.List;

/*
 * METRICAS:
 * 
 * WMC: 0 (notas en el codigo)
 * CBO: -AFF (Número de clases que dependen de la clase analizada):0
 * 		-EFF (Número de clases de los que la clase depende):1
 * DIT (En una jerarquía de clases, longitud máxima desde una subclase hasta la clase raíz): 1
 * NOC (Número de subclases inmediatas de una clase dada): 0
 * CCog: 0 (notas en el codigo)
 */

public class CuentaValores extends Cuenta {

	private List<Valor> valores;
	
	public CuentaValores(String numCuenta, List<Valor> valores) {
		super(numCuenta);
		this.valores = valores;
	}
	
	public List<Valor> getValores() {
		return valores;
	}
	
	public void anhadeValor(Valor v) {
		valores.add(v);
	}
	
	
}
