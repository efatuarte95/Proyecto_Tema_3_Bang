package crud;

import model.Carta;
import model.Partida;

import java.util.Random;

import datos.BDCartas;
import datos.BDPartida;
import datos.BDPersonajes;

public class CrudJugador {

	BDPartida bdp = new BDPartida();
	BDPersonajes bdpj = new BDPersonajes();
	BDCartas bdc = new BDCartas();
	Partida p = new Partida();

	private Carta cartas[];

	public CrudJugador() {
		int veinticinco=25;
		cartas = new Carta [veinticinco];
	}
	
	public CrudJugador(Carta [] cartas) {
		this.cartas=cartas;
	}
	
	public void añadirCarta(Carta c, int posicion) {
		cartas[posicion]=c;
	}
	
	
	public int asignarRol(int idx_jugador) {
		int desde = 0, hasta = bdp.getRol().length-1, aleatorio=0;
		boolean generado = true;
		Random r;
		while (generado) {
			r = new Random(System.nanoTime());
			aleatorio = r.nextInt(hasta-desde+1)+desde;
			generado = false;
			for (int i = 0; i < idx_jugador; i++) {
				if (p.getJugadores()[i].getIdx_Rol() == aleatorio) 
					generado = true;
			}
		}
		return aleatorio;
	}
	
	public int asignarPersonaje(int idx_jugador) {
		int desde = 0, hasta = bdpj.getPersonajes().length, aleatorio=0;
		boolean generado = true;
		Random r;
		while (generado) {
			r = new Random(System.nanoTime());
			aleatorio = r.nextInt(hasta-desde+1)+desde;
			generado = false;
			for (int i = 0; i < idx_jugador; i++) {
				if (p.getJugadores()[i].getIdx_Personaje() == aleatorio) 
					generado = true;
			}
		}
		return aleatorio;
	}
	
	public int asignarCartas() {
		int desde = 0, hasta = bdc.getCartas().length-1, aleatorio=0;
		Random r;
		r = new Random(System.nanoTime());
		aleatorio = r.nextInt(hasta-desde+1)+desde;
		return aleatorio;
	}

}
