package com.example.mastermind;

import java.util.Random;

public class MasterMind {

	public static final int TAMANO_POR_DEFECTO = 4;
	private static Random alea = new Random();
	
	protected String combinacionSecreta;

	public MasterMind() {
		this(TAMANO_POR_DEFECTO);
	}

	public MasterMind(int tam) {
		if ((tam < 1) || (tam > 10)) {
			throw new MasterMindException("Tamaño no válido");
		}
		generaCombinacionSecreta(tam);
	}

	public MasterMind(String secreto) {
		validaCombinacion(secreto);
		combinacionSecreta = secreto;
	}

	private void generaCombinacionSecreta(int tam) {
		// genera una combinaci�n secreta de tama�o tam
		// no debe tener n�meros repetidos
		combinacionSecreta = "";
		while (combinacionSecreta.length() < tam) {
			int n = alea.nextInt(10);
			// si no esta en la combinaci�n secreta se a�ade
			if (combinacionSecreta.indexOf(""+n) < 0) {
				combinacionSecreta += n;
			}
		}

	}

	public int longitud() {
		return combinacionSecreta.length();
	}

	private boolean validaCombinacion(String cifrasStr) {
		if (cifrasStr.length() != longitud()) {
			return false;
		}
		String patron = "[0-9]";
		for (int i = 1; i < longitud(); i++) {
			patron += "[0-9&&[^" + cifrasStr.substring(0,i) + "]]";
		}
		return cifrasStr.matches(patron);
	}

	public Movimiento intento(String cifrasStr) {
		if (!validaCombinacion(cifrasStr)) {
			throw new MasterMindException("Cadena de cifras no v�lida");
		}
		// Ahora calculamos los aciertos colocados y descolocados
		int colocados = 0;
		int descolocados = 0;
		for (int i = 0; i < longitud(); i++) {
			if (combinacionSecreta.charAt(i) == cifrasStr.charAt(i)) {
				colocados++;
			} else if (combinacionSecreta.indexOf(cifrasStr.charAt(i)) >= 0) {
				descolocados++;
			}
		}
		return new Movimiento(cifrasStr, colocados, descolocados);
	}

	public String secreto() {
		return combinacionSecreta;
	}
}