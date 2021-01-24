package model;

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
	
	/* public void ejecutarAccion (Partida p) {
	 * int enMazo = 0, opcion;
	 * boolean seguirDuelo = true;
	 * this.setEstado(enMazo);
	 * switch (idx_tipo_carta) {
		 * case 0: //Salon
		 * 	for(i = 0; i<p.maxJugadores; i++){
		 * 	p.getJugadores()[i].recuperarVida();
		 * }
		 * case 1: // Cerveza
		 * p.getJugadores()[this.idx_Jugador].recuperarVida();
		case 2: // Almacén: Todos los jugadores roban 1 carta
					for(i = 0; i<maxJugadores; i++) {
						if (p.getJugadores()[i].estarVivo())
							p.getJugadores()[i].robarCartas(p, i, 1)
					}
		case 3: // Diligencia: Jugador roba 2 cartas
					p.getJugadores()[this.idx_Jugador].robarCartas(p, this.idx_Jugador, 2)
		case 4: // Wells Fargo: Jugador roba 3 cartas
					p.getJugadores()[this.idx_Jugador].robarCartas(p, this.idx_Jugador, 3)
		case 5: // Ametralladora Gatling: Dispara un BANG a todos los jugadores.
				for(i = 0; i<maxJugadores; i++) {
					if(i != this.idx_Jugador) {
						p.getJugadores()[i].perderFallaste();
					}
				}
		case 6: // ¡Indios!: Utiliza un BANG o pierde 1 de vida.
				for(i = 0; i<p.maxJugadores; i++) {
					if(i != this.idx_Jugador) {
						p.getJugadores()[i].perderBang();
					}
				}
		case 7: // Duelo: El que empieza el duelo tira BANG todas las veces que quiera mientras el otro jugador se pueda defender
				// El que antes deje de poder atacar/defender pierde 1 de vida.
					syso "¿A qué jugador quieres retar?"
					for(i = 0; i<maxJugadores; i++) {
						if(i != this.idx_Jugador && p.getJugadores()[i].estarVivo())
							syso("[" + (i+1) + "] - " + p.getJugadores()[i].getNombre());
					}
					opcion = Leer.datoInt();
					if (opcion > p.maxJugadores || !p.getJugadores()[opcion].estarVivo())
					 	syso("Jugador incorrecto);
					else {
						while (seguirDuelo) {
							seguirDuelo = p.getJugadores()[this.idx_Jugador].perderBang();
							if(seguirDuelo)
								seguirDuelo = p.getJugadores()[opcion].perderFallaste();
						}
					}
		case 16: BANG
		syso "¿A qué jugador quieres disparar?"
					for(i = 0; i<maxJugadores; i++) {
						if(i != this.idx_Jugador && p.getJugadores()[i].estarVivo())
							syso("[" + (i+1) + "] - " + p.getJugadores()[i].getNombre());
					}
					opcion = Leer.datoInt();
					if (opcion > p.maxJugadores || !p.getJugadores()[opcion - 1].estarVivo())
					 	syso("Jugador incorrecto);
					else {
						while(p.getJugadores[this.idx_Jugador].calcularDistanciaJugador(p, p.getJugadores()[opcion - 1]) > p.getJugadores[this.idx_Jugador].calcularMiAlcance){
							syso("No puedes disparar a ese jugador, está demasiado lejos. Elija un nuevo objetivo:");
							opcion = Leer.datoInt();
						}
						p.getJugadores()[opcion - 1].perderFallaste();
					}
	 * }
	 *  
	 * }
	* 
	*/
}
