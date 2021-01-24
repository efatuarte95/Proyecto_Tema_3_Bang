package crud;

import datos.BDPersonajes;
import model.Carta;
import model.Jugador;
import model.Partida;

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
	
	public void agregarJugador(Partida p, String nombre, Jugador j, int idx_jugador) {
		int maxCartasJugador = 25;
		jugadores[idx_jugador]=j;
		jugadores[idx_jugador].setIdx_jugador_propio(idx_jugador);
		jugadores[idx_jugador].setNombre(nombre);
		jugadores[idx_jugador].setIdx_Rol(cj.asignarRol(p, idx_jugador));
		jugadores[idx_jugador].setIdx_Personaje(cj.asignarPersonaje(p, idx_jugador));
		jugadores[idx_jugador].setVidaActual(bdpj.getPersonajes()[jugadores[idx_jugador].getIdx_Personaje()].getVida());
		jugadores[idx_jugador].setMaxVidas(bdpj.getPersonajes()[jugadores[idx_jugador].getIdx_Personaje()].getVida());
		jugadores[idx_jugador].setCartas(new Carta[maxCartasJugador]);
	}
}
