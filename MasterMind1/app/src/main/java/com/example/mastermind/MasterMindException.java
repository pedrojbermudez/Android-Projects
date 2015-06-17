package com.example.mastermind;
/**
 * Clase que gestionar� las excepciones generadas por el Mastermind.
 */
public class MasterMindException extends RuntimeException {

	public MasterMindException() {
	}

	public MasterMindException(String mensaje) {
		super(mensaje);
	}
}
