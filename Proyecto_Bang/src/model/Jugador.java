package model;

import java.util.Arrays;

import crud.CrudCarta;
import crud.CrudJugador;
import datos.BDPartida;
import datos.BDPersonajes;

public class Jugador {

	CrudJugador cj = new CrudJugador();
	CrudCarta cc = new CrudCarta();
	BDPersonajes bdpj = new BDPersonajes();
	BDPartida bdp = new BDPartida();
	
	// ATRIBUTOS
	private int idx_jugador_propio;
	private String nombre;
	private int vidaActual;
	private int maxVidas;
	private int idx_Rol;
	private int idx_Personaje;
	private Carta cartas[];
	private boolean volcanicActiva;
	
	// CONSTRUCTOR
	public Jugador() {};
	
	public Jugador(int idx_jugador_propio, String nombre, int vidaActual, int maxVidas, int idx_Rol, int idx_Personaje,
			Carta[] cartas, boolean volcanicActiva) {
		this.idx_jugador_propio = idx_jugador_propio;
		this.nombre = nombre;
		this.vidaActual = vidaActual;
		this.maxVidas = maxVidas;
		this.idx_Rol = idx_Rol;
		this.idx_Personaje = idx_Personaje;
		this.cartas = cartas;
		this.volcanicActiva = volcanicActiva;
	}

	// GETTERS & SETTERS
	public int getIdx_jugador_propio() {
		return idx_jugador_propio;
	}

	public void setIdx_jugador_propio(int idx_jugador_propio) {
		this.idx_jugador_propio = idx_jugador_propio;
	}

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
		return "Jugador [idx_jugador_propio=" + idx_jugador_propio + ", nombre=" + nombre + ", vidaActual=" + vidaActual
				+ ", maxVidas=" + maxVidas + ", idx_Rol=" + idx_Rol + ", idx_Personaje=" + idx_Personaje + ", cartas="
				+ Arrays.toString(cartas) + ", volcanicActiva=" + volcanicActiva + "]";
	}
	
	public int contarBang(Jugador jugadores[]) {
		int contadorBang = 0, enMano = 1;
		for (int i = 0; i < jugadores.length; i++) {
			for (int j = 0; j < jugadores[i].getCartas().length; j++) {
				if (jugadores[i].getCartas()[j].getEstado() == enMano && jugadores[i].getCartas()[j].getTipo_Carta() == 0)
					contadorBang++;
			}
		}
		return contadorBang;
	}

	public int contarFallaste(Jugador jugadores[]) {
		int contadorFallaste = 0, enMano = 1;
		for (int i = 0; i < jugadores.length; i++) {
			for (int j = 0; j < jugadores[i].getCartas().length; j++) {
				if (jugadores[i].getCartas()[j].getEstado() == enMano && jugadores[i].getCartas()[j].getTipo_Carta() == 1)
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
	
	public int calcularMiAlcance() {
		int enJuego = 2;
		int alcance = bdpj.getPersonajes()[idx_Personaje].getAlcance();
		for (int i = 0; i < this.cartas.length; i++) {
			if (cartas[i] != null && cartas[i].getEstado()==enJuego) {
				alcance = cartas[i].getAlcance();
				i = cartas.length;
			}
		}
		return alcance;
	}
	
	public int calcularDistanciaJugador(Partida p, Jugador j) {
		int distancia = 0, enJuego = 2, miraTelescopica = 14, mustang = 15, num_Jugadores_Comprobar, indiceJugador, paul = 2;
		
		if (idx_jugador_propio < j.getIdx_jugador_propio())
			num_Jugadores_Comprobar = j.getIdx_jugador_propio() - idx_jugador_propio;
		else 
			num_Jugadores_Comprobar = (j.getIdx_jugador_propio() - idx_jugador_propio) + p.getMaximoJugadores();
		indiceJugador = idx_jugador_propio;
		for (int i = 1; i <= num_Jugadores_Comprobar; i++) {
			indiceJugador++;
			if(indiceJugador == p.getMaximoJugadores()) 
				indiceJugador = 0;
			if (p.getJugadores()[indiceJugador].estarVivo())
				distancia++;
		}
		// Comprobar si yo tengo mira telescopica
		for (int i = 0; i < this.cartas.length; i++) {
			if(this.cartas[i] != null && this.cartas[i].getEstado()==enJuego && this.cartas[i].getIdx_Carta()==miraTelescopica) {
				distancia--;
				i = this.cartas.length;
			}
		}
		
		// Comprobar si el otro jugador tiene carta Mustang
		for (int i = 0; i < j.getCartas().length; i++) {
			if(j.getCartas()[i] != null && j.getCartas()[i].getEstado()==enJuego && j.getCartas()[i].getIdx_Carta()==mustang) {
				distancia++;
				i = j.getCartas().length;
			}
		}
		// Comprueba si es personaje Paul Regret
		if(j.getIdx_Personaje() == paul)
			distancia++;
		
		return distancia;
	}
	
	public void recuperarVida () {
		if (vidaActual > 0) // Solo recuperan vida si está vivo
			if(vidaActual < maxVidas)
				vidaActual++;
			else 
				System.out.println(getNombre() + " ya tiene el máximo de vida. No se puede recuperar más vidas.");
	}
	
	public void perderVida () {
		if (vidaActual > 0) 
			vidaActual--;
	}
	
	public void robarCartas(Partida p, int idx_Jugador, int num_Cartas_Robadas) {
		int idx_Ultima_Carta = p.getidx_Ultima_Carta();
		for (int i = 0; i<num_Cartas_Robadas; i++) {
			Carta c = cc.crearCarta();
			if(asignarCarta(c)) {
				c.setIdx_Jugador(idx_Jugador);
				idx_Ultima_Carta++;
				p.setidx_Ultima_Carta(idx_Ultima_Carta);
				cc.agregarCarta(c, idx_Ultima_Carta);
			}
			else {
				System.out.println(this.getNombre() + " ha alcanzado el límite de cartas.");
			}
		}
	}
	
	public boolean perderBang() {
		boolean tieneBang = false;
		int enMano = 1, enMazo = 0, tipo_bang = 0, tipo_fallaste = 1, calamity = 1;
		// Se tiene en cuenta si el personaje es Calamity para hacer que BANG y Fallaste sean iguales
		for (int i = 0; i < this.cartas.length; i++) {
			if (cartas[i] != null && cartas[i].getEstado()==enMano && (cartas[i].getTipo_Carta() == tipo_bang || (cartas[i].getTipo_Carta() == tipo_fallaste && getIdx_Personaje() == calamity))) {
				cartas[i].setEstado(enMazo);
				tieneBang = true;
				// Si la carta usada es un fallaste lo avisamos.
				if(cartas[i].getTipo_Carta() == tipo_fallaste)
					System.out.println(getNombre() + "ha utilizado un Fallaste como BANG.");
				else
					System.out.println(getNombre() + " ha perdido un BANG.");
				i = this.cartas.length; // Salimos del for
			}
		}
		if (!tieneBang) {
			this.perderVida();
			if (this.vidaActual > 0)
				System.out.println(getNombre() + " ha perdido una vida.");
			else
				System.out.println(getNombre() + " ha muerto. Su rol era " + bdp.getRol()[getIdx_jugador_propio()]);
		}
		return tieneBang;
	}
	
	public boolean perderFallaste() {
		boolean tieneFallaste = false;
		int enMano = 1, enMazo = 0, tipo_bang = 0, tipo_fallaste = 1, calamity = 1;
		// Se tiene en cuenta si el personaje es Calamity para hacer que BANG y Fallaste sean iguales
		for (int i = 0; i < this.cartas.length; i++) {
			if (cartas[i] != null && cartas[i].getEstado()==enMano && (cartas[i].getTipo_Carta() == tipo_fallaste || (cartas[i].getTipo_Carta() == tipo_bang && getIdx_Personaje() == calamity))) {
				cartas[i].setEstado(enMazo);
				tieneFallaste = true;
				// Si la carta usada es un BANG lo avisamos.
				if(cartas[i].getTipo_Carta() == tipo_bang)
					System.out.println(getNombre() + "ha utilizado un BANG como Fallaste.");
				else
					System.out.println(getNombre() + " ha perdido un Fallaste.");
				i = this.cartas.length; // Salimos del for
			}
		}
		if (!tieneFallaste) {
			this.perderVida();
			if (this.vidaActual > 0)
				System.out.println(getNombre() + " ha perdido una vida.");
			else
				System.out.println(getNombre() + " ha muerto. Su rol era " + bdp.getRol()[getIdx_jugador_propio()]);
		}
		return tieneFallaste;
	}
	
	public boolean estarVivo() {
		if (this.vidaActual>0)
			return true;
		else 
			return false;
	}
	
	public int contarCartasMano() {
		int cartasMano = 0, enMano = 1;
		for (int i = 0; i < cartas.length; i++) {
			if (getCartas()[i] != null && getCartas()[i].getEstado() == enMano)
				cartasMano++;
		}
		return cartasMano;
	}
}
