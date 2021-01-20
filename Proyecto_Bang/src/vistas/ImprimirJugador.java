package vistas;

import model.Personaje;

public class ImprimirJugador {

	public void mostrarAcciones() {
		System.out.println("[1] - Jugar una carta.");
		System.out.println("[2] - Ver mi personaje.");
		System.out.println("[3] - Ver mis cartas.");
		System.out.println("[4] - Descartar.");
		System.out.println("[0] - Pasar turno.");
	}
	
	public void mostrarCartas() {}
	
	public void mostrarPersonaje(Personaje p) {
		System.out.println("Tu personaje es : " + p.getNombre());
		System.out.println("Descripción: " + p.getDescripcion());
	}
}
