package model;

import java.util.Arrays;
import java.util.Random;

import datos.BDPartida;

public class Jugador {

	// ATRIBUTOS
	private String nombre;
	private int vidaActual;
	private int idx_Rol;
	private int idx_Personaje;
	private Carta Cartas[];
	private boolean volcanicActiva;
	
	// CONSTRUCTOR
	public Jugador() {};



	public Jugador(String nombre, int vidaActual, int idx_Rol, int idx_Personaje, Carta[] cartas,
			boolean volcanicActiva) {
		this.nombre = nombre;
		this.vidaActual = vidaActual;
		this.idx_Rol = idx_Rol;
		this.idx_Personaje = idx_Personaje;
		Cartas = cartas;
		this.volcanicActiva = volcanicActiva;
	}



	// GETTERS & SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getVidaActual() {
		return vidaActual;
	}

	public void setVidaActual(int vidaActual) {
		this.vidaActual = vidaActual;
	}

	

	public int getIdx_Rol() {
		return idx_Rol;
	}



	public void setIdx_Rol(int idx_Rol) {
		this.idx_Rol = idx_Rol;
	}



	public int getIdx_Personaje() {
		return idx_Personaje;
	}



	public void setIdx_Personaje(int idx_Personaje) {
		this.idx_Personaje = idx_Personaje;
	}



	public Carta[] getCartas() {
		return Cartas;
	}

	public void setCartas(Carta[] cartas) {
		Cartas = cartas;
	}

	public boolean isVolcanicActiva() {
		return volcanicActiva;
	}

	public void setVolcanicActiva(boolean volcanicActiva) {
		this.volcanicActiva = volcanicActiva;
	}

	// MÉTODOS
	public int contarBang() {
		int contadorBang = 0;
		// Aquí meteremos la comprobación del tipo de carta (Tipo = 0)
		return contadorBang;
	}
	
	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", vidaActual=" + vidaActual + ", idx_Rol=" + idx_Rol + ", idx_Personaje="
				+ idx_Personaje + ", Cartas=" + Arrays.toString(Cartas) + ", volcanicActiva=" + volcanicActiva + "]";
	}

	public int contarFallaste() {
		int contadorFallaste = 0;
		// Aquí meteremos la comprobación del tipo de carta (Tipo = 1)
		return contadorFallaste;
	}
	
	public void asignarCarta() {
		/* En éste método recorremos el array de cartas del jugador buscando la primera que tenga
		 * el estado = 3 (en mazo), asignándole a la nueva carta dicha posición y modificando su 
		 * estado a 2 (en mano)*/
	}
	
	public void robarCarta(int numRobos) {
		for (int i=0; i<numRobos; i++) {
			asignarCarta();
		}
	}
	
	public void descartar(int idCarta, boolean enJuego) {
		/* Éste método sirve para descartar una carta si tenemos más cartas en mano
		 * que nuestra vida actual. */
	}
	
	public void jugarCarta(int idCarta) {
		/* Éste método llama a descartar(idCarta, true) si la carta es un Arma (Tipo = 3) o 
		 * a descartar(idCarta, false) si es un BANG (Tipo = 0), un Fallaste (Tipo = 1) o
		 * una carta de acción (Tipo = 2)*/
	}
	
	public int calcularDistanciaJugador(int idJugador) {
		int distancia = 1;
		return distancia;
	}
	
	public boolean estarAlAlcance(int idJugador) {
		int alcance = 1;
		/* Aquí recorremos el array de cartas buscando si tiene un arma en juego
		 * y si la tiene, el alcance se actualiza con el del arma */
		if (calcularDistanciaJugador(idJugador)<=alcance)
			return true;
		return false;
	}
}
