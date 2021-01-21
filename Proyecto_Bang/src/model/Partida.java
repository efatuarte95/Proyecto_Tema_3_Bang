package model;

import java.util.Arrays;

import datos.BDPartida;

public class Partida {

	// ATRIBUTOS
	private int ganador;
	private Jugador jugadores[];
	private String rol[];
	private Personaje personaje[];
	private Carta cartas[];
	private int idUltimaCarta;
	private int maxBang;
	private int maxFallaste;
	private int numRonda;
	private int turnoJugador;
	private boolean finPartida;
	
	// CONSTRUCTOR
	public Partida() {};
	
	public Partida(String rol[]) {};
	
	public Partida(int ganador, Jugador[] jugadores, String[] rol, Personaje[] personaje, Carta[] cartas,
			int idUltimaCarta, int maxBang, int maxFallaste, int numRonda, int turnoJugador, boolean finPartida) {
		this.ganador = ganador;
		this.jugadores = jugadores;
		this.rol = rol;
		this.personaje = personaje;
		this.cartas = cartas;
		this.idUltimaCarta = idUltimaCarta;
		this.maxBang = maxBang;
		this.maxFallaste = maxFallaste;
		this.numRonda = numRonda;
		this.turnoJugador = turnoJugador;
		this.finPartida = finPartida;
	}

	// GETTERS & SETTERS 
	public int getGanador() {
		return ganador;
	}

	public void setGanador(int ganador) {
		this.ganador = ganador;
	}

	public Jugador[] getJugadores() {
		return jugadores;
	}

	public void setJugadores(Jugador[] jugadores) {
		this.jugadores = jugadores;
	}

	public String[] getRol() {
		return rol;
	}

	public void setRol(String[] rol) {
		this.rol = rol;
	}

	public Personaje[] getPersonaje() {
		return personaje;
	}

	public void setPersonaje(Personaje[] personaje) {
		this.personaje = personaje;
	}

	public Carta[] getCartas() {
		return cartas;
	}

	public void setCartas(Carta[] cartas) {
		this.cartas = cartas;
	}

	public int getIdUltimaCarta() {
		return idUltimaCarta;
	}

	public void setIdUltimaCarta(int idUltimaCarta) {
		this.idUltimaCarta = idUltimaCarta;
	}

	public int getMaxBang() {
		return maxBang;
	}

	public void setMaxBang(int maxBang) {
		this.maxBang = maxBang;
	}

	public int getMaxFallaste() {
		return maxFallaste;
	}

	public void setMaxFallaste(int maxFallaste) {
		this.maxFallaste = maxFallaste;
	}

	public int getNumRonda() {
		return numRonda;
	}

	public void setNumRonda(int numRonda) {
		this.numRonda = numRonda;
	}

	public int getTurnoJugador() {
		return turnoJugador;
	}

	public void setTurnoJugador(int turnoJugador) {
		this.turnoJugador = turnoJugador;
	}

	public boolean isFinPartida() {
		return finPartida;
	}

	public void setFinPartida(boolean finPartida) {
		this.finPartida = finPartida;
	}

	@Override
	public String toString() {
		return "Partida [ganador=" + ganador + ", jugadores=" + Arrays.toString(jugadores) + ", rol="
				+ Arrays.toString(rol) + ", personaje=" + Arrays.toString(personaje) + ", cartas="
				+ Arrays.toString(cartas) + ", idUltimaCarta=" + idUltimaCarta + ", maxBang=" + maxBang
				+ ", maxFallaste=" + maxFallaste + ", numRonda=" + numRonda + ", turnoJugador=" + turnoJugador
				+ ", finPartida=" + finPartida + "]";
	}
	
}
