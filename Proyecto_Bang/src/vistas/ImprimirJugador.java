package vistas;

import datos.BDPartida;
import datos.BDPersonajes;
import model.Jugador;
import model.Personaje;

public class ImprimirJugador {

	public void mostrarAcciones() {
		System.out.println("\n¿Qué quieres hacer?");
		System.out.println("[1] - Objetivo de la partida.");
		System.out.println("[2] - Ver mi personaje.");
		System.out.println("[3] - Consultar vidas.");
		System.out.println("[4] - Ver mis cartas.");
		System.out.println("[5] - Jugar una carta.");
		System.out.println("[6] - Descartar.");
		System.out.println("[0] - Pasar turno.");
	}
	
	public void mostrarInformacionJugador(Jugador j, BDPartida bdp, BDPersonajes bdpj) {
		String arma = "Ninguna";
		int enJuego = 2;
		for (int i = 0; i < j.getCartas().length; i++) {
			if(j.getCartas()[i] != null && j.getCartas()[i].getEstado() == enJuego)
				arma = j.getCartas()[i].getNombre();
		}
		System.out.println("|----------------------------------------------------------------------------------------------------------------------------------|");
		System.out.println("| Nombre: " + j.getNombre() + "\tRol: " + bdp.getRol()[j.getIdx_Rol()] + "\tPersonaje: " + bdpj.getPersonajes()[j.getIdx_Personaje()].getNombre() +  "\t\tVidas: " + j.getVidaActual() + "\tArma en Juego: " + arma + "\t   Alcance: " + j.calcularMiAlcance() + "\t |");
		System.out.println("|----------------------------------------------------------------------------------------------------------------------------------|");
		System.out.println("\n");
	}
	
	public void mostrarCartasNombre(Jugador j) {
		int enMano = 1, accion = 2, arma = 3;
		System.out.println("Las cartas que tienes actualmente son:");
		for (int i = 0; i < j.getCartas().length; i++) {
			if(j.getCartas()[i] != null && j.getCartas()[i].getEstado() == enMano) {
				if(j.getCartas()[i].getTipo_Carta() == accion)
					System.out.println("[" + (i+1) + "] - Acción: " + j.getCartas()[i].getNombre() + ": " + j.getCartas()[i].getDescripcion());
				else if(j.getCartas()[i].getTipo_Carta() == arma)
					System.out.println("[" + (i+1) + "] - Arma..: " + j.getCartas()[i].getNombre() + ": " + j.getCartas()[i].getDescripcion());
				else
					System.out.println("[" + (i+1) + "] - " + j.getCartas()[i].getNombre() + ": " + j.getCartas()[i].getDescripcion());
			}
		}
	}
	
	public void mostrarCartas(Jugador j) {
		int enMazo = 0, enJuego = 2, accion = 2, arma = 3;
		System.out.println("Las cartas que tienes actualmente son:");
		for (int i = 0; i < j.getCartas().length; i++) {
			if(j.getCartas()[i] != null && j.getCartas()[i].getEstado() != enMazo) {
				if(j.getCartas()[i].getTipo_Carta() == accion)
					System.out.println("- Acción: " + j.getCartas()[i].getNombre() + ": " + j.getCartas()[i].getDescripcion());
				else if(j.getCartas()[i].getTipo_Carta() == arma)
					if (j.getCartas()[i].getEstado() == enJuego)
						System.out.println("-(*)Arma: " + j.getCartas()[i].getNombre() + ": " + j.getCartas()[i].getDescripcion());
					else
						System.out.println("- Arma..: " + j.getCartas()[i].getNombre() + ": " + j.getCartas()[i].getDescripcion());
				else
					System.out.println("- " + j.getCartas()[i].getNombre() + ": " + j.getCartas()[i].getDescripcion());
			}
		}
	}
	
	public void mostrarPersonaje(Personaje p) {
		System.out.println("Tu personaje es: " + p.getNombre());
		System.out.println("Descripción: " + p.getDescripcion());
	}
}
