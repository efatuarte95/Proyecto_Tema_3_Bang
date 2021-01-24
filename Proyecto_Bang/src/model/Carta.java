package model;

public class Carta {

	// ATRIBUTOS
	private int idx_Carta;
	private String nombre;
	private int idx_Tipo_Carta;
	private int estado;
	private String descripcion;
	private int idx_Jugador;
	
	// CONSTRUCTOR
	public Carta() {};
	
	public Carta(int idx_Carta, String nombre, int idx_Tipo_Carta, int estado, String descripcion) {
		this.idx_Carta = idx_Carta;
		this.nombre = nombre;
		this.idx_Tipo_Carta = idx_Tipo_Carta;
		this.estado = estado;
		this.descripcion = descripcion;
		this.idx_Jugador = -1;
	}

	// GETTERS & SETTERS
	public int getidx_Carta() {
		return idx_Carta;
	}

	public void setidx_Carta(int idx_Carta) {
		this.idx_Carta = idx_Carta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getidx_Tipo_Carta() {
		return idx_Tipo_Carta;
	}

	public void setidx_Tipo_Carta(int idx_Tipo_Carta) {
		this.idx_Tipo_Carta = idx_Tipo_Carta;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getidx_Jugador() {
		return idx_Jugador;
	}

	public void setidx_Jugador(int idx_Jugador) {
		this.idx_Jugador = idx_Jugador;
	}

	// MÉTODOS
	@Override
	public String toString() {
		return "Carta [idx_Carta=" + idx_Carta + ", nombre=" + nombre + ", idx_Tipo_Carta=" + idx_Tipo_Carta + ", estado="
				+ estado + ", descripcion=" + descripcion + ", idx_Jugador=" + idx_Jugador + "]";
	}	
	
	/* public void ejecutarAccion (Partida p) {
	 * switch (idx_tipo_carta) {
		 * case 0: //Salon
		 * 	for(i = 0; i<p.maxJugadores; i++){
		 * 	p.getJugadores()[i].recuperarVida();
		 * }
		 * case 1: // Cerveza
		 * p.getJugadores()[this.idx_Jugador].recuperarVida();
		case 2: // Almacén: Todos los jugadores roban 1 carta
					for(i = 0; i<maxJugadores; i++) {
						Carta c = new Carta();
						c = bdc.getCartas()[cj.robarCartas();
						if(p.getJugadores()[i].asignarCarta(c)) {
							c.setidx_Jugador(i);
							c.setEstado(enMano);
							p.setidx_Ultima_Carta(p.getidx_Ultima_Carta()++);
							cc.agregarCarta(c, p.getidx_Ultima_Carta());
						}
						else {
							sysout(p.getJugadores()[i].getNombre() + "ha alcanzado el limite de cartas");
						}
					}
		case 3: // Diligencia: Jugador roba 2 cartas
					for (i = 0; i<2; i++) {
						Carta c = new Carta();
						c = bdc.getCartas()[cj.robarCartas();
						if(p.getJugadores()[this.idx_Jugador].asignarCarta(c)) {
							c.setidx_Jugador(this.idx_Jugador);
							c.setEstado(enMano);
							p.setidx_Ultima_Carta(p.getidx_Ultima_Carta()++);
							cc.agregarCarta(c, p.getidx_Ultima_Carta());
						}
						else {
							sysout("Has alcanzado el limite de cartas");
						}
					}
		case 4: // Wells Fargo: Jugador roba 3 cartas
					}
					for (i = 0; i<3; i++) {
						Carta c = new Carta();
						c = bdc.getCartas()[cj.robarCartas();
						if(p.getJugadores()[this.idx_Jugador].asignarCarta(c)) {
							c.setidx_Jugador(this.idx_Jugador);
							c.setEstado(enMano);
							p.setidx_Ultima_Carta(p.getidx_Ultima_Carta()++);
							cc.agregarCarta(c, p.getidx_Ultima_Carta());
						}
						else {
							sysout("Has alcanzado el limite de cartas");
						}
		case 5: // Ametralladora Gatling: Dispara un BANG a todos los jugadores.
		case 6: // ¡Indios!: Utiliza un BANG o pierde 1 de vida.
		case 7: // Duelo: El que empieza el duelo tira BANG todas las veces que quiera mientras el otro jugador se pueda defender
				// El que antes deje de poder atacar/defender pierde 1 de vida.

	 * }
	 *  
	 * }
	* 
	*/
}
