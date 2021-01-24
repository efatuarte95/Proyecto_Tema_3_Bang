package model;

import java.util.Arrays;

import crud.CrudCarta;
import crud.CrudJugador;

public class Jugador {

	CrudJugador cj = new CrudJugador();
	CrudCarta cc = new CrudCarta();
	
	// ATRIBUTOS
	private String nombre;
	private int vidaActual;
	private int maxVidas;
	private int idx_Rol;
	private int idx_Personaje;
	private Carta cartas[];
	private boolean volcanicActiva;
	
	// CONSTRUCTOR
	public Jugador() {};
	
	public Jugador(String nombre, int vidaActual, int maxVidas, int idx_Rol, int idx_Personaje,
			Carta[] cartas, boolean volcanicActiva) {
		this.nombre = nombre;
		this.vidaActual = vidaActual;
		this.maxVidas = maxVidas;
		this.idx_Rol = idx_Rol;
		this.idx_Personaje = idx_Personaje;
		this.cartas = cartas;
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

	public int getMaxVidas() {
		return maxVidas;
	}

	public void setMaxVidas(int maxVidas) {
		this.maxVidas = maxVidas;
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
		return cartas;
	}

	public void setCartas(Carta[] cartas) {
		this.cartas = cartas;
	}

	public boolean isVolcanicActiva() {
		return volcanicActiva;
	}

	public void setVolcanicActiva(boolean volcanicActiva) {
		this.volcanicActiva = volcanicActiva;
	}

	// MÉTODOS
	
	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", vidaActual=" + vidaActual + ", idx_Rol=" + idx_Rol + ", idx_Personaje="
				+ idx_Personaje + ", Cartas=" + Arrays.toString(cartas) + ", volcanicActiva=" + volcanicActiva + "]";
	}
	
	public int contarBang(Jugador jugadores[]) {
		int contadorBang = 0;
		for (int i = 0; i < jugadores.length; i++) {
			for (int j = 0; j < jugadores[i].getCartas().length; j++) {
				if (jugadores[i].getCartas()[j].getidx_Tipo_Carta() == 0)
					contadorBang++;
			}
		}
		return contadorBang;
	}

	public int contarFallaste(Jugador jugadores[]) {
		int contadorFallaste = 0;
		for (int i = 0; i < jugadores.length; i++) {
			for (int j = 0; j < jugadores[i].getCartas().length; j++) {
				if (jugadores[i].getCartas()[j].getidx_Tipo_Carta() == 1)
					contadorFallaste++;
			}
		}
		return contadorFallaste;
	}
	
	public boolean asignarCarta(Carta c) {
		int enMazo = 0;
		boolean asignada = false;
		for (int i = 0; i < this.cartas.length; i++) {
			//System.out.println(cartas[i]);
			if (this.cartas[i] == null || this.cartas[i].getEstado() == enMazo) {
				this.cartas[i] = c;
				asignada = true;
				i=this.cartas.length; // Si se asigna la carta, salimos del for
			}
		}
		return asignada;
	}
	
	public void descartar(int idCarta, boolean enJuego) {
		/* 
		 * Éste método sirve para descartar una carta si tenemos más cartas en mano
		 * que nuestra vida actual.
		 */
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
	
	public void recuperarVida () {
		if (vidaActual < maxVidas)
			vidaActual++;
	}
	
	public void perderVida () {
		if (vidaActual > 0) 
			vidaActual--;
	}
	
	public void robarCartas(Jugador j, Partida p, int idx_Jugador, int num_Cartas_Robadas) {
		int idx_Ultima_Carta = p.getidx_Ultima_Carta();
		for (int i = 0; i<num_Cartas_Robadas; i++) {
			Carta c = cc.crearCarta();
			if(asignarCarta(c)) {
				c.setidx_Jugador(idx_Jugador);
				idx_Ultima_Carta++;
				p.setidx_Ultima_Carta(idx_Ultima_Carta);
				cc.agregarCarta(c, idx_Ultima_Carta);
			}
			else {
				System.out.println(j.getNombre() + " ha alcanzado el límite de cartas.");
			}
		}
	}
}
