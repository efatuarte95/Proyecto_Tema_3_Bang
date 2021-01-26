package model;

import java.util.Arrays;

public class Partida {

	// ATRIBUTOS
	private Jugador jugadores[];
	private String rol[];
	private Personaje personaje[];
	private Carta cartas[];
	private int idx_Ultima_Carta;
	private int maxBang;
	private int maxFallaste;
	private int numRonda;
	private int turnoJugador;
	private boolean finPartida;
	private int maximoJugadores;
	
	// CONSTRUCTOR
	public Partida() {};
	
	public Partida(String rol[]) {};
	
	public Partida(Jugador[] jugadores, String[] rol, Personaje[] personaje, Carta[] cartas, int maximoJugadores) {
		this.jugadores = jugadores;
		this.rol = rol;
		this.personaje = personaje;
		this.cartas = cartas;
		this.idx_Ultima_Carta = -1;
		this.maxBang = 50;
		this.maxFallaste = 50;
		this.numRonda = 1;
		this.turnoJugador = 0;
		this.finPartida = false;
		this.maximoJugadores = maximoJugadores;
	}

	// GETTERS & SETTERS 
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

	public int getidx_Ultima_Carta() {
		return idx_Ultima_Carta;
	}

	public void setidx_Ultima_Carta(int idx_Ultima_Carta) {
		this.idx_Ultima_Carta = idx_Ultima_Carta;
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

	public int getMaximoJugadores() {
		return maximoJugadores;
	}

	@Override
	public String toString() {
		return "Partida [jugadores=" + Arrays.toString(jugadores) + ", rol="
				+ Arrays.toString(rol) + ", personaje=" + Arrays.toString(personaje) + ", cartas="
				+ Arrays.toString(cartas) + ", idx_Ultima_Carta=" + idx_Ultima_Carta + ", maxBang=" + maxBang
				+ ", maxFallaste=" + maxFallaste + ", numRonda=" + numRonda + ", turnoJugador=" + turnoJugador
				+ ", finPartida=" + finPartida + ", maximoJugadores=" + maximoJugadores + "]";
	}
	
	public void terminarPartida() {
		
		for (int i = 0; i < maximoJugadores; i++) {
			if(
				// Si Sherif vivo y forajidos y renegado muertos, gana Sheriff y Alguacil 
				(getJugadores()[i].getIdx_Rol()==0 && getJugadores()[i].estarVivo()) && 
				((getJugadores()[i].getIdx_Rol()==2 && !getJugadores()[i].estarVivo()) &&
				(getJugadores()[i].getIdx_Rol()==3 && !getJugadores()[i].estarVivo()) &&
				(getJugadores()[i].getIdx_Rol()==4 && !getJugadores()[i].estarVivo())) ||
				// Si alguacil gana, Sheriff gana también
				(getJugadores()[i].getIdx_Rol()==0 && !getJugadores()[i].estarVivo() && 
				(getJugadores()[i].getIdx_Rol()==1 && getJugadores()[i].estarVivo())) &&
				((getJugadores()[i].getIdx_Rol()==2 && !getJugadores()[i].estarVivo()) &&
				(getJugadores()[i].getIdx_Rol()==3 && !getJugadores()[i].estarVivo()) &&
				(getJugadores()[i].getIdx_Rol()==4 && !getJugadores()[i].estarVivo()))) 
			{
					finPartida = true;
					System.out.println("Ha ganado el Sheriff y su Alguacil!!");
			}
				
				// Si eres forajido vivo y Sheriff y renegado muertos, ganan forajidos
			else if(
				(getJugadores()[i].getIdx_Rol()==2 && getJugadores()[i].estarVivo() ||
				getJugadores()[i].getIdx_Rol()==3 && getJugadores()[i].estarVivo()) &&
				((getJugadores()[i].getIdx_Rol()==0 && !getJugadores()[i].estarVivo()) &&
				(getJugadores()[i].getIdx_Rol()==1 && !getJugadores()[i].estarVivo()) &&
				(getJugadores()[i].getIdx_Rol()==4 && !getJugadores()[i].estarVivo())))
			{
					finPartida = true;
					System.out.println("Han ganado los forajidos!!");
			}
				
				// Si eres renegado vivo y todos muertos, gana renegado
			else if(
				getJugadores()[i].getIdx_Rol()==4 && getJugadores()[i].estarVivo() &&
				((getJugadores()[i].getIdx_Rol()==0 && !getJugadores()[i].estarVivo()) &&
				(getJugadores()[i].getIdx_Rol()==1 && !getJugadores()[i].estarVivo()) &&
				(getJugadores()[i].getIdx_Rol()==2 && !getJugadores()[i].estarVivo()) &&
				(getJugadores()[i].getIdx_Rol()==2 && !getJugadores()[i].estarVivo())))
			{
					finPartida = true;
					System.out.println("Ha ganado el renegado!!");
			}
		}
		
	}
	
	
}
