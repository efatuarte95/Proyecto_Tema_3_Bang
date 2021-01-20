package controller;

import model.Partida;

public class PasarTurno {

	public void pasarTurno (Partida p) {
		/* Éste método se usa para pasar al siguiente jugador, y si es el último, volver al jugador 0
		 * aumentando el número de ronda */
		int turnoJugador, numRonda;
		turnoJugador = p.getTurnoJugador();
		numRonda = p.getNumRonda();
		turnoJugador ++;
		if (turnoJugador > p.getJugadores().length-1) {
			turnoJugador = 0;
			p.setTurnoJugador(turnoJugador);
			numRonda ++;
			p.setNumRonda(numRonda);
		}
		p.setTurnoJugador(turnoJugador);
	}

}
