package principal;

import controller.PasarTurno;
import crud.CrudPartida;
import datos.BDCartas;
import datos.BDPartida;
import datos.BDPersonajes;
import model.Jugador;
import model.Partida;
import utilidades.Leer;
import vistas.ImprimirJugador;
import vistas.ImprimirPartida;

public class Principal {

/*
 * Ale: Bases de datos de Personajes, cartas y partida. Vistas de menú (Imprimir Jugador). Imprimir instrucciones.
 * Fran: Métodos de asignar roles a jugador, Vistas, Métodos de contar Bang/Fallaste y Perder Bang/Fallaste (Clase jugador). Imprimir datos partida
 * Ernesto: Métodos para asignar las cartas y el personaje al jugador. Métodos de acciones de cartas. Clase principal. Cruds de jugador, partida y cartas.
 * Entre los 3: Metodo de fin de partida y acciones de personajes
 */
	
	
	public static void main(String[] args) {
		
		// Objetos de Datos
		BDPartida bdp = new BDPartida();
		BDPersonajes bdpj = new BDPersonajes();
		BDCartas bdc = new BDCartas();
		
		// Objetos de Cruds
		CrudPartida cp = new CrudPartida();
				
		// Objetos de Vistas
		ImprimirPartida ip = new ImprimirPartida();
		ImprimirJugador ij = new ImprimirJugador();
		
		// Objetos Controller
		PasarTurno pt = new PasarTurno ();
		
		// Variables
		Jugador jugadores[];
		int enMazo = 0, enJuego = 2, tipo_bang = 0, tipo_accion = 2, tipo_arma = 3, volcanic = 13, num_Bang_Lanzados, 
				opPartida, opJugador, opComenzar, opAccion, opJugar, opDescartar, maxJugadores = 5, jug_Creados = 0,
				willy = 7, suzy = 6, contadorDescartes, sid = 4, calamity = 1, tipo_fallaste = 1;
		String nombre;

		// Menú para empezar partida
		do {
			Partida p = new Partida(null, bdp.getRol(), bdpj.getPersonajes(), bdc.getCartas(), maxJugadores); // Creo la partida
			ip.mostrarMenuPartida();
			opPartida = Leer.datoInt();
			// Si selecciona 1 entramos en la partida, si selecciona 0 salimos
			switch (opPartida) {
				case 1:
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
								System.out.println("Bienvenido al Lejano Oeste " + nombre + ". ¿Qué aventuras te deparará el futuro?\n");
								jugadores[jug_Creados] = new Jugador();
								cp.agregarJugador(p, nombre, jugadores[jug_Creados], jug_Creados);
								
								// Si el personaje es Willy el niño, activamos el atributo isVolcanic
								if(jugadores[jug_Creados].getIdx_Personaje() == willy)
									jugadores[jug_Creados].setVolcanicActiva(true);
								
								jugadores[jug_Creados].robarCartas(p, jug_Creados, jugadores[jug_Creados].getMaxVidas());
								jug_Creados++;
							}
							// Cuando estén todos los jugadores creados, podremos comenzar la partida.
							ip.mostrarComenzarPartida();
							opComenzar = Leer.datoInt();
							
							switch (opComenzar) {
								case 1:
									ip.mostrarInstrucciones(bdp);		
									do {
										for (int i = 0; i < jugadores.length; i++) {
											if(jugadores[i].estarVivo()) {
												ip.imprimirEstadoPartida(p);
												// Se resetean el numero de bang jugados 
												num_Bang_Lanzados = 0;
												contadorDescartes = 0;
												
												// Al inicio del turno se le dan dos cartas al jugador
												jugadores[i].robarCartas(p, jugadores[i].getIdx_jugador_propio(), 2);
												do {
													ij.mostrarAcciones();
													opAccion = Leer.datoInt();
													switch (opAccion) {
													case 1:
														ij.mostrarInformacionJugador(jugadores[i], bdp, bdpj);
														System.out.println("Rol: " + bdp.getRol()[jugadores[i].getIdx_Rol()]);
														System.out.println("Objetivo: " + bdp.getDescripcion()[jugadores[i].getIdx_Rol()]);
														break;
													case 2:
														ij.mostrarInformacionJugador(jugadores[i], bdp, bdpj);
														ij.mostrarPersonaje(bdpj.getPersonajes()[jugadores[i].getIdx_Personaje()]);
														break;
													case 3:
														ij.mostrarInformacionJugador(jugadores[i], bdp, bdpj);
														for (int j = 0; j < jugadores.length; j++) {
															System.out.println(p.getJugadores()[j].getNombre() + ": " + p.getJugadores()[j].getVidaActual() + " vidas.");
														}
														break;
													case 4:
														ij.mostrarInformacionJugador(jugadores[i], bdp, bdpj);
														ij.mostrarCartas(jugadores[i]);
														break;
													case 5:
														ij.mostrarInformacionJugador(jugadores[i], bdp, bdpj);
														System.out.println("¿Qué carta deseas jugar?");
														ij.mostrarCartasNombre(jugadores[i]);
														opJugar = Leer.datoInt();
														// Si la carta es de tipo BANG o es de tipo FALLASTE teniendo a Calamity
														if(jugadores[i].getCartas()[opJugar - 1].getTipo_Carta() == tipo_bang ||
																(jugadores[i].getCartas()[opJugar - 1].getTipo_Carta() == tipo_fallaste && 
																jugadores[i].getIdx_Personaje() == calamity)) {
															if(num_Bang_Lanzados > 0 && !jugadores[i].isVolcanicActiva())
																if(jugadores[i].getCartas()[opJugar - 1].getTipo_Carta() == tipo_fallaste)
																	System.out.println("No puedes usar más Fallastes como BANG en esta ronda.");
																else
																	System.out.println("No puedes usar más BANG en esta ronda.");
															else {
																num_Bang_Lanzados++;
																jugadores[i].getCartas()[opJugar - 1].setEstado(enMazo);
																jugadores[i].getCartas()[opJugar - 1].ejecutarAccion(p);
																p.terminarPartida();
															}
														}
														else if(jugadores[i].getCartas()[opJugar - 1].getTipo_Carta() == tipo_accion) {
															jugadores[i].getCartas()[opJugar - 1].setEstado(enMazo);
															jugadores[i].getCartas()[opJugar - 1].ejecutarAccion(p);
															p.terminarPartida();
														}
														else if(jugadores[i].getCartas()[opJugar - 1].getTipo_Carta() == tipo_arma) {
															// Recorremos el array de cartas para comprobar si tenemos otro arma en juego y
															// pasarla al mazo.
															for (int j = 0; j < jugadores[i].getCartas().length; j++) {
																if(jugadores[i].getCartas()[j] != null && jugadores[i].getCartas()[j].getEstado() == enJuego) {
																	jugadores[i].getCartas()[j].setEstado(enMazo);
																	jugadores[i].setVolcanicActiva(false);
																	j = jugadores[i].getCartas().length;
																}
															}
															
															jugadores[i].getCartas()[opJugar - 1].setEstado(enJuego);
															// Activamos el atributo isVolcanic si tiene Volcanic en juego o es Willy el niño (p7)
															if(jugadores[i].getCartas()[opJugar - 1].getIdx_Carta()==volcanic || jugadores[i].getIdx_Personaje() == willy)
																jugadores[i].setVolcanicActiva(true);
														}
														else 
															System.out.println("No puedes jugar una carta tipo Fallaste.");
														
														if(jugadores[i].contarCartasMano() == 0)
															if(jugadores[i].getIdx_Personaje() == suzy) {
																jugadores[i].robarCartas(p, i, 1);
																pt.pasarTurno(p);
															}
															else
																pt.pasarTurno(p);
														break;
													case 6:
														ij.mostrarInformacionJugador(jugadores[i], bdp, bdpj);
														System.out.println("¿De qué carta deseas deshacerte?");
														ij.mostrarCartasNombre(jugadores[i]);
														opDescartar = Leer.datoInt();
														p.getJugadores()[i].getCartas()[opDescartar - 1].setEstado(enMazo);
														System.out.println("Te has descartado de " + p.getJugadores()[i].getCartas()[opDescartar - 1].getNombre() + "\n");
														contadorDescartes++;
														if(contadorDescartes >= 2 && p.getJugadores()[i].getIdx_Personaje() == sid) {
															p.getJugadores()[i].recuperarVida();
															System.out.println("Todo sacrificio tiene su recompensa. Recuperas 1 vida!");
															contadorDescartes = 0;
														}
														break;
													case 0:
														pt.pasarTurno(p);
														while(jugadores[i].contarCartasMano() > jugadores[i].getVidaActual()) {
															System.out.println("Tienes más cartas de las permitidas.");
															System.out.println("Debes deshacerte de " + (jugadores[i].contarCartasMano() - jugadores[i].getVidaActual()) + " carta(s).");													
															System.out.println("¿De qué carta deseas deshacerte?");
															ij.mostrarCartasNombre(jugadores[i]);
															opDescartar = Leer.datoInt();
															p.getJugadores()[i].getCartas()[opDescartar - 1].setEstado(enMazo);
															System.out.println("Te has descartado de " + p.getJugadores()[i].getCartas()[opDescartar - 1].getNombre());
														}
														break;
													default:
														System.out.println("Opción incorrecta.");
													}
												} while (opAccion != 0);
											}
											else
												pt.pasarTurno(p);
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
