package com.example.mastermind;
import java.util.*;

public class MasterMindMemoria extends MasterMind {
	private Movimiento[] movimientos;
	private int primeraPosicionLibre;
	private static final int TAMARRAYMOV = 10;

	public MasterMindMemoria() {
		movimientos = new Movimiento[TAMARRAYMOV];
		primeraPosicionLibre = 0;
	}

	public MasterMindMemoria(int tam) throws MasterMindException {
		super(tam);
		movimientos = new Movimiento[TAMARRAYMOV];
		primeraPosicionLibre = 0;
	}

	public Movimiento intento(String cifraStr) {
		Movimiento m = super.intento(cifraStr);
		
		// Buscamos si contiene ya a este movimiento.
		int i = 0;
		while (i< primeraPosicionLibre && !movimientos[i].equals(m)) {
			i++;
		}
		if (i < primeraPosicionLibre) {
			throw new MasterMindException("Intento ya realizado");
		}
		// Hacemos hueco si no hay
		if (primeraPosicionLibre == movimientos.length) {
			movimientos = Arrays.copyOf(movimientos, movimientos.length*2);
		}
		movimientos[primeraPosicionLibre] = m;
		primeraPosicionLibre++;
		return m;
	}

	public Movimiento[] movimientos() {
		Movimiento [] movs = Arrays.copyOf(movimientos, primeraPosicionLibre);
		return movs;
	}
}
