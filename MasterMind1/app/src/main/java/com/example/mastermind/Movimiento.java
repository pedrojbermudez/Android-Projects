package com.example.mastermind;

/**
 * Clase que gestionar� un intento de resoluci�n del juego Mastermind.
 * 
 */
public class Movimiento {
	private String cifras;
	private int colocadas;
	private int descolocadas;

	public Movimiento(String c, int col, int desc) {
		cifras = c;
		colocadas = col;
		descolocadas = desc;
	}

	public int colocadas() {
		return colocadas;
	}

	public int descolocadas() {
		return descolocadas;
	}

	public String cifras() {
		return cifras;
	}

	public boolean equals(Object obj) {
		boolean res = obj instanceof Movimiento;
		Movimiento mov = res ? (Movimiento)obj : null;
		return res && this.cifras.equals(mov.cifras());
	}

	public int hashCode() {
		return cifras.hashCode();
	}

	public String toString() {
		return "[" + this.cifras() + ", " + colocadas + ", "
				+ descolocadas + "]";
	}

}
