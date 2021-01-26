package model;

import utilidades.Leer;

public class Carta {

	// ATRIBUTOS
	private int idx_Carta;
	private String nombre;
	private int tipo_Carta;
	private int estado;
	private int alcance;
	private String descripcion;
	private int idx_Jugador;
	
	// CONSTRUCTOR
	public Carta() {};
	
	public Carta(int idx_Carta, String nombre, int tipo_Carta, int estado, int alcance, String descripcion,
			int idx_Jugador) {
		this.idx_Carta = idx_Carta;
		this.nombre = nombre;
		this.tipo_Carta = tipo_Carta;
		this.estado = estado;
		this.alcance = alcance;
		this.descripcion = descripcion;
		this.idx_Jugador = idx_Jugador;
	}


	// GETTERS & SETTERS
	public int getIdx_Carta() {
		return idx_Carta;
	}

	public void setIdx_Carta(int idx_Carta) {
		this.idx_Carta = idx_Carta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTipo_Carta() {
		return tipo_Carta;
	}

	public void setTipo_Carta(int tipo_Carta) {
		this.tipo_Carta = tipo_Carta;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getAlcance() {
		return alcance;
	}

	public void setAlcance(int alcance) {
		this.alcance = alcance;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public int getIdx_Jugador() {
		return idx_Jugador;
	}

	public void setIdx_Jugador(int idx_Jugador) {
		this.idx_Jugador = idx_Jugador;
	}

	// MÉTODOS
	@Override
	public String toString() {
		return "Carta [idx_Carta=" + idx_Carta + ", nombre=" + nombre + ", tipo_Carta=" + tipo_Carta + ", estado="
				+ estado + ", alcance=" + alcance + ", descripcion=" + descripcion + ", idx_Jugador=" + idx_Jugador
				+ "]";
	}		
	
	public void ejecutarAccion (Partida p) {
		int opcion, bart = 0, slab = 5;
		boolean seguirDuelo = true;
	 	switch (idx_Carta) {
	 		case 0: // Salon
 				System.out.println("¡Qué generoso! Todos tus compañeros recuperan una vida!");
	 			for(int i = 0; i<p.getMaximoJugadores(); i++){
	 				p.getJugadores()[i].recuperarVida();
	 			}
	 			break;
	 		case 1: // Cerveza
	 			System.out.println("Te has tomado una cervecita bien fría. ¡A tu salud!");
	 			p.getJugadores()[this.idx_Jugador].recuperarVida();
	 			break;
	 		case 2: // Almacén: Todos los jugadores roban 1 carta
 				System.out.println("¡Qué generoso! Todos tus compañeros roban una carta!");
				for(int i = 0; i<p.getMaximoJugadores(); i++) {
					if (p.getJugadores()[i].estarVivo())
						p.getJugadores()[i].robarCartas(p, i, 1);
				}
				break;
			case 3: // Diligencia: Jugador roba 2 cartas
 					System.out.println("Robas 2 cartas!");
					p.getJugadores()[this.idx_Jugador].robarCartas(p, this.idx_Jugador, 2);
					break;
			case 4: // Wells Fargo: Jugador roba 3 cartas
					System.out.println("¡ORO! Robas 3 cartas!");
					p.getJugadores()[this.idx_Jugador].robarCartas(p, this.idx_Jugador, 3);
					break;
			case 5: // Ametralladora Gatling: Dispara un BANG a todos los jugadores.
				System.out.println("BANG BANG BANG BANG BANG!! Ametralladora Gatling en acción!\n");
				for(int i = 0; i<p.getMaximoJugadores(); i++) {
					if(i != this.idx_Jugador) {
						// Se comprueba si pierde vida y es Bart, entonces se roba una carta
						if(!p.getJugadores()[i].perderFallaste())
							if(p.getJugadores()[i].getIdx_Personaje() == bart)
								p.getJugadores()[i].robarCartas(p, i, 1);
					}
				}
				break;
			case 6: // ¡Indios!: Utiliza un BANG o pierde 1 de vida.
				System.out.println("*Se oyen alaridos a lo lejos...* Son los INDIOS!\n");
				for(int i = 0; i<p.getMaximoJugadores(); i++) {
					if(i != this.idx_Jugador) {
						// Se comprueba si pierde vida y es Bart, entonces se roba una carta
						if(!p.getJugadores()[i].perderBang())
							if(p.getJugadores()[i].getIdx_Personaje() == bart)
								p.getJugadores()[i].robarCartas(p, i, 1);
					}
				}
				break;
			case 7: // Duelo: El que empieza el duelo tira BANG todas las veces que quiera mientras el otro jugador se pueda defender
					// El que antes deje de poder atacar/defender pierde 1 de vida.
				System.out.println("¿A qué jugador quieres retar?");
				for(int i = 0; i<p.getMaximoJugadores(); i++) {
					if(i != this.idx_Jugador && p.getJugadores()[i].estarVivo())
						System.out.println("[" + (i+1) + "] - " + p.getJugadores()[i].getNombre());
				}
				opcion = Leer.datoInt();
				System.out.println("¡Que comience el duelo!\n");
				if (opcion > p.getMaximoJugadores() || !p.getJugadores()[opcion - 1].estarVivo())
				 	System.out.println("Jugador incorrecto");
				else {
					while (seguirDuelo) {
						seguirDuelo = p.getJugadores()[this.idx_Jugador].perderBang();
						if(seguirDuelo)
							seguirDuelo = p.getJugadores()[opcion - 1].perderFallaste();
						// Si el que usa la carta de duelo se queda sin BANG, pierde vida y es Bart
						else if (p.getJugadores()[this.idx_Jugador].getIdx_Personaje() == bart)
							p.getJugadores()[this.idx_Jugador].robarCartas(p, this.idx_Jugador, 1);
						
						// Si el jugador retado se queda sin Fallaste, pierde vida y es Bart
						if (p.getJugadores()[opcion - 1].getIdx_Personaje() == bart)
							p.getJugadores()[opcion - 1].robarCartas(p, opcion - 1, 1);
					}
				}
				break;
				// BANG y Fallaste en el case de que sea Calamity
			case 16: case 17: case 18: case 19: case 20: case 21: case 22: case 23: case 24: case 25: case 26: case 27:
				System.out.println("¿A qué jugador quieres disparar?");
				for(int i = 0; i<p.getMaximoJugadores(); i++) {
					if(i != this.idx_Jugador && p.getJugadores()[i].estarVivo())
						System.out.println("[" + (i+1) + "] - " + p.getJugadores()[i].getNombre());
				}
				opcion = Leer.datoInt();
				System.out.println("¡BANG!\n");
				while (opcion > p.getMaximoJugadores() || !p.getJugadores()[opcion - 1].estarVivo()) {
				 	System.out.println("Jugador incorrecto. Elige un nuevo objetivo");
				 	for(int i = 0; i<p.getMaximoJugadores(); i++) {
						if(i != this.idx_Jugador && p.getJugadores()[i].estarVivo())
							System.out.println("[" + (i+1) + "] - " + p.getJugadores()[i].getNombre());
					}
					opcion = Leer.datoInt();
				}
				while(p.getJugadores()[this.idx_Jugador].calcularDistanciaJugador(p, p.getJugadores()[opcion - 1]) > p.getJugadores()[this.idx_Jugador].calcularMiAlcance()){
					System.out.println("No puedes disparar a ese jugador, está demasiado lejos. Elija un nuevo objetivo:");
					System.out.println("¿A qué jugador quieres disparar?");
					for(int i = 0; i<p.getMaximoJugadores(); i++) {
						if(i != this.idx_Jugador && p.getJugadores()[i].estarVivo())
							System.out.println("[" + (i+1) + "] - " + p.getJugadores()[i].getNombre());
					}	
					opcion = Leer.datoInt();						
				}
					
				// Se comprueba si el objetivo pierde vida
				if(!p.getJugadores()[opcion - 1].perderFallaste()) {
					// si el personaje es bart, roba una carta
					if(p.getJugadores()[opcion - 1].getIdx_Personaje() == bart)
						p.getJugadores()[opcion - 1].robarCartas(p, opcion - 1, 1);
				}
				
				// Ahora se comprueba si el personaje es Slab para que el objetivo use otro Fallaste si sigue vivo y no ha perdido vida
				else if(p.getJugadores()[this.idx_Jugador].getIdx_Personaje() == slab) {
					if(!p.getJugadores()[opcion - 1].perderFallaste()) {
						if(p.getJugadores()[opcion - 1].getIdx_Personaje() == bart)
							p.getJugadores()[opcion - 1].robarCartas(p, opcion - 1, 1);
					}
				}				
				break;
			default:
				System.out.println("No se puede jugar esta carta.");
	 	}
	  
	}
}
