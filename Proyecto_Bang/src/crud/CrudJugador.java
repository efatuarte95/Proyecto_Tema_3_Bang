package crud;

import model.Carta;
import model.Jugador;
import model.Personaje;
import model.Partida;

import java.util.Random;

import datos.BDPartida;
import datos.BDPersonajes;

public class CrudJugador {

	BDPartida bdp = new BDPartida ();
	BDPersonajes bdpj = new BDPersonajes ();
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
		boolean error = true;
		Random r;
		while (error) {
			r = new Random(System.nanoTime());
			aleatorio = r.nextInt(hasta-desde+1)+desde;
			error = false;
			for (int i = 0; i < idx_jugador; i++) {
				if (p.getJugadores()[i].getIdx_Rol() == aleatorio) 
					error = true;
			}
		}
		return aleatorio;
	}
	
	public int asignarPersonaje(int idx_jugador) {
		int desde = 0, hasta = bdpj.getPersonajes().length, aleatorio=0;
		boolean error = true;
		Random r;
		while (error) {
			r = new Random(System.nanoTime());
			aleatorio = r.nextInt(hasta-desde+1)+desde;
			error = false;
			for (int i = 0; i < idx_jugador; i++) {
				if (p.getJugadores()[i].getIdx_Personaje() == aleatorio) 
					error = true;
			}
		}
		return aleatorio;
	}

}
