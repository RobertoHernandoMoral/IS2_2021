package es.unican.is2.practica5;

import java.util.List;

/*
 * METRICAS:
 * 
 * WMC: 0 (notas en el codigo)
 * CBO: -AFF (N�mero de clases que dependen de la clase analizada):0
 * 		-EFF (N�mero de clases de los que la clase depende):1
 * DIT (En una jerarqu�a de clases, longitud m�xima desde una subclase hasta la clase ra�z): 1
 * NOC (N�mero de subclases inmediatas de una clase dada): 0
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
