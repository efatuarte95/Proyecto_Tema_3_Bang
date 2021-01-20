package crud;

import datos.BDPersonajes;
import model.Jugador;

public class CrudPartida {
	CrudJugador cj = new CrudJugador();
	BDPersonajes bdpj = new BDPersonajes();
	
	
	private Jugador jugadores[];
	
	public CrudPartida() {
		int cinco=5;
		jugadores = new Jugador [cinco];
	}
	
	public CrudPartida(Jugador [] jugadores) {
		this.jugadores=jugadores;
	}
	
	public void agregarJugador(String nombre, Jugador j, int idx_jugador) {
		jugadores[idx_jugador]=j;
		jugadores[idx_jugador].setNombre(nombre);
		jugadores[idx_jugador].setIdx_Rol(idx_jugador);
		jugadores[idx_jugador].setIdx_Personaje(idx_jugador);
		jugadores[idx_jugador].setVidaActual(bdpj.getPersonajes()[jugadores[idx_jugador].getIdx_Personaje()].getVida());
	}
}
