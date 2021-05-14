package es.unican.is2.practica5;

import java.util.List;

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
