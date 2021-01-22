package vistas;

import model.Jugador;
import model.Personaje;

public class ImprimirJugador {

	public void mostrarAcciones() {
		System.out.println("¿Qué quieres hacer?");
		System.out.println("[1] - Jugar una carta.");
		System.out.println("[2] - Ver mi personaje.");
		System.out.println("[3] - Ver mis cartas.");
		System.out.println("[4] - Descartar.");
		System.out.println("[0] - Pasar turno.");
	}
	public void mostrarCartasNombre(Jugador j) {
		System.out.println("Las cartas que tienes actualmente son:");
		for (int i = 0; i < j.getCartas().length; i++) {
			System.out.println("[" + (i+1) + "] - " + j.getCartas()[i].getNombre());
		}
	}
	
	public void mostrarCartas(Jugador j) {
		System.out.println("Las cartas que tienes actualmente son:");
		for (int i = 0; i < j.getCartas().length; i++) {
			System.out.println("[" + (i+1) + "] - " + j.getCartas()[i].getNombre());
			System.out.println("Descripción: " + j.getCartas()[i].getDescripcion() + "\n");
		}
	}
	
	public void mostrarPersonaje(Personaje p) {
		System.out.println("Tu personaje es: " + p.getNombre());
		System.out.println("Descripción: " + p.getDescripcion());
	}
}
