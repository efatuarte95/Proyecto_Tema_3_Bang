package principal;

import controller.PasarTurno;
import crud.CrudJugador;
import crud.CrudPartida;
import datos.BDCartas;
import datos.BDPartida;
import datos.BDPersonajes;
import model.Carta;
import model.Jugador;
import model.Partida;
import utilidades.Leer;
import vistas.ImprimirJugador;
import vistas.ImprimirPartida;

public class Principal {

	public static void main(String[] args) {
		
		// Objetos de Datos
		BDPartida bdp = new BDPartida();
		BDPersonajes bdpj = new BDPersonajes();
		BDCartas bdc = new BDCartas();
		
		// Objetos de Cruds
		CrudJugador cj = new CrudJugador();
		CrudPartida cp = new CrudPartida();
				
		// Objetos de Vistas
		ImprimirPartida im = new ImprimirPartida();
		ImprimirJugador ip = new ImprimirJugador();
		
		// Objetos Controller
		PasarTurno pt = new PasarTurno ();
		
		Jugador jugadores[];
		Carta cartas[];
		int maxJugadores = 5, jug_Creados = 0;
		int op, opCarta;
		String nombre;
		Partida p = new Partida(0, null, bdp.getRol(), bdpj.getPersonajes(), bdc.getCartas(), 0, 0, 0, 0, 0, false);
		jugadores = new Jugador [maxJugadores];
		
		im.mostrarInstrucciones();
		System.out.println("\nA continuación, introduce el nombre de los intrépidos jugadores que viajarán al lejano Oeste:\n");

		for (int i = 0; i < maxJugadores; i++) {
			System.out.println("Nombre del jugador " + (i+1) + ":");
			nombre = Leer.dato();
			jugadores[i] = new Jugador();
			cp.agregarJugador(nombre, jugadores[i], i);
			for (int j = 0; j < p.getPersonaje()[jugadores[i].getIdx_Personaje()].getVida(); j++) {
				cartas = new Carta[p.getPersonaje()[jugadores[i].getIdx_Personaje()].getVida()];
				cartas[j] = bdc.getCartas()[cj.asignarCartas()];
				jugadores[i].setCartas(cartas);
				cartas[j].setIdJugador(i);
			}
		}
		p.setJugadores(jugadores);
		
		System.out.println(p);

		do {
			for (int i = 0; i < jugadores.length; i++) {	
				do {
					ip.mostrarAcciones();
					op = Leer.datoInt();
					
					switch (op) {
					case 1:
						System.out.println("¿Qué carta deseas jugar?");
						for (int j = 0; j < jugadores[i].getCartas().length; j++) {
							System.out.println("[" + (i+1) + "] - " + jugadores[i].getCartas()[j].getNombre());
							opCarta = Leer.datoInt();
						}
						break;
					case 2:
						ip.mostrarPersonaje(bdpj.getPersonajes()[jugadores[i].getIdx_Personaje()]);
						break;
					case 3:
						System.out.println("Las cartas que tienes actualmente son:");
						for (int j = 0; j < jugadores[i].getCartas().length; j++) {
							System.out.println("[" + (i+1) + "] - " + jugadores[i].getCartas()[j].getNombre());
							System.out.println("Descripción: " + "[" + (i+1) + "] - " + jugadores[i].getCartas()[j].getDescripcion() + "\n");
						}
						break;
					case 4:
						System.out.println("¿De qué carta deseas deshacerte?");
						for (int j = 0; j < jugadores[i].getCartas().length; j++) {
							System.out.println("[" + (i+1) + "] - " + jugadores[i].getCartas()[j].getNombre());
							opCarta = Leer.datoInt();
						}
						break;
					case 0:
						pt.pasarTurno(p);
						im.imprimirEstadoPartida(p);
						break;
					default:	
					}
				} while (op != 0);
			}
						
		} while (p.isFinPartida() == false);
		
	}

}
