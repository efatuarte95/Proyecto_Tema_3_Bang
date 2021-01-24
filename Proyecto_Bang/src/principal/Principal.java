package principal;

import controller.PasarTurno;
import crud.CrudCarta;
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
		CrudCarta cc = new CrudCarta();
				
		// Objetos de Vistas
		ImprimirPartida ip = new ImprimirPartida();
		ImprimirJugador ij = new ImprimirJugador();
		
		// Objetos Controller
		PasarTurno pt = new PasarTurno ();
		
		// Variables
		Jugador jugadores[];
		int enMazo = 0, enMano = 1, enJuego = 2, tipo_bang = 0, tipo_accion = 2, tipo_arma = 3, opPartida, opJugador, opComenzar, opAccion, opJugar, opDescartar, maxJugadores = 5, jug_Creados = 0;
		String nombre;
		
		// Menú para empezar partida
		do {
			ip.mostrarMenuPartida();
			opPartida = Leer.datoInt();
			// Si selecciona 1 entramos en la partida, si selecciona 0 salimos
			switch (opPartida) {
				case 1:
					Partida p = new Partida(0, null, bdp.getRol(), bdpj.getPersonajes(), bdc.getCartas(), maxJugadores); // Creo la partida
					jugadores = new Jugador [maxJugadores]; // Creo el array de jugadores
					p.setJugadores(jugadores); // Seteo el array de jugadores a la partida

					ip.mostrarMenuAgregarJugador();
					opJugador = Leer.datoInt();
					// Pediremos a los jugadores que vayan introduciendo sus nombres hasta que estén los 5 creados.
					switch (opJugador) {
						case 1:
							System.out.println("\nA continuación, introduce el nombre de los intrépidos jugadores que viajarán al Lejano Oeste:\n");

							while(jug_Creados < maxJugadores) {
								System.out.println("Nombre del jugador " + (jug_Creados+1) + ":");
								nombre = Leer.dato();
								jugadores[jug_Creados] = new Jugador();
								cp.agregarJugador(p, nombre, jugadores[jug_Creados], jug_Creados);
								System.out.println(p);
								/*
								System.out.println("Personaje Asignado: " + p.getPersonaje()[jugadores[i].getIdx_Personaje()].getNombre());
								System.out.println("Vida del personaje: " + p.getPersonaje()[jugadores[i].getIdx_Personaje()].getVida());
								System.out.println("ID del jugador....: " + i);
								*/
								jugadores[jug_Creados].robarCartas(p, jug_Creados, jugadores[jug_Creados].getMaxVidas());
								jug_Creados++;
							}
							// Cuando estén todos los jugadores creados, podremos comenzar la partida.
							ip.mostrarComenzarPartida();
							opComenzar = Leer.datoInt();
							
							switch (opComenzar) {
								case 1:
									ip.mostrarInstrucciones();		
									ip.imprimirEstadoPartida(p);
									do {
										for (int i = 0; i < jugadores.length; i++) {	
											do {
												ij.mostrarAcciones();
												opAccion = Leer.datoInt();
												
												switch (opAccion) {
												case 1:
													System.out.println("¿Qué carta deseas jugar?");
													ij.mostrarCartasNombre(jugadores[i]);
													opJugar = Leer.datoInt();
													if(jugadores[i].getCartas()[opJugar - 1].getTipo_Carta() == tipo_bang || jugadores[i].getCartas()[opJugar - 1].getTipo_Carta() == tipo_accion)
														jugadores[i].getCartas()[opJugar - 1].ejecutarAccion(p);
													else if(jugadores[i].getCartas()[opJugar - 1].getTipo_Carta() == tipo_arma) {
														// Recorremos el array de cartas para comprobar si tenemos otro arma en juego y
														// pasarla al mazo.
														for (int j = 0; j < jugadores[i].getCartas().length; j++) {
															if(jugadores[i].getCartas()[j].getEstado() == enJuego) {
																jugadores[i].getCartas()[j].setEstado(enMazo);	
																j = jugadores[i].getCartas().length;
															}
														}
														jugadores[i].getCartas()[opJugar - 1].setEstado(enJuego);
													}
													else 
														System.out.println("No puedes jugar una carta tipo Fallaste.");
													break;
												case 2:
													ij.mostrarPersonaje(bdpj.getPersonajes()[jugadores[i].getIdx_Personaje()]);
													break;
												case 3:
													ij.mostrarCartas(jugadores[i]);
													break;
												case 4:
													System.out.println("¿De qué carta deseas deshacerte?");
													ij.mostrarCartasNombre(jugadores[i]);
													opDescartar = Leer.datoInt();
													break;
												case 0:
													pt.pasarTurno(p);
													ip.imprimirEstadoPartida(p);
													break;
												default:	
												}
											} while (opAccion != 0);
										}
													
									} while (p.isFinPartida() == false);
									break;
								case 0:
									System.out.println("Volviendo a menú de jugador...");
								default:
									System.out.println("Opción Incorrecta.");
									break;
							}
							break;
						case 0:
							System.out.println("Volviendo a menú de partida...");
						default:
							System.out.println("Opción Incorrecta.");
						break;
					}
					break;
				case 0:
					System.out.println("Espero que hayas disfrutado del Salvaje Oeste!\nHasta la próxima!");
				default:
					System.out.println("Opción Incorrecta.");
				break;
			}
		}while (opPartida !=0);
		
		
		
		
	}

}
