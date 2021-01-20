package controller;

import java.util.Random;

public class Aleatorios {

	public int generarAleatorio (int desde, int hasta) {
		int aleatorio;
		Random r;
		r = new Random (System.nanoTime());
		aleatorio = r.nextInt(hasta-desde+1)+desde;
		return aleatorio;
	}
}
