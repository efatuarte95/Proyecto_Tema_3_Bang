package model;

public class Carta {

	// ATRIBUTOS
	private int idTipoCarta;
	private int idJugador;
	private int estado;
	private int idCarta;
	private String nombre;
	
	// CONSTRUCTOR
	public Carta(int idTipoCarta, int idJugador, int estado) {
		this.idTipoCarta = idTipoCarta;
		this.idJugador = idJugador;
		this.estado = estado;
	}
	
	public Carta(int idCarta, String nombre, int idTipoCarta) {
		this.idCarta = idCarta;
		this.nombre = nombre;
		this.idTipoCarta = idTipoCarta;
	}

	// GETTERS & SETTERS
	public int getIdTipoCarta() {
		return idTipoCarta;
	}

	public void setIdTipoCarta(int idTipoCarta) {
		this.idTipoCarta = idTipoCarta;
	}

	public int getIdJugador() {
		return idJugador;
	}

	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	// MÉTODOS
	@Override
	public String toString() {
		return "Carta [idTipoCarta=" + idTipoCarta + ", idJugador=" + idJugador + ", estado=" + estado + "]";
	}
}
