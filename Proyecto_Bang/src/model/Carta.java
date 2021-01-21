package model;

public class Carta {

	// ATRIBUTOS
	private int idCarta;
	private String nombre;
	private int idTipoCarta;
	private int estado;
	private String descripcion;
	private int idJugador;
	
	// CONSTRUCTOR
	public Carta(int idCarta, String nombre, int idTipoCarta, int estado, String descripcion) {
		this.idCarta = idCarta;
		this.nombre = nombre;
		this.idTipoCarta = idTipoCarta;
		this.estado = estado;
		this.descripcion = descripcion;
	}

	// GETTERS & SETTERS
	public int getIdCarta() {
		return idCarta;
	}

	public void setIdCarta(int idCarta) {
		this.idCarta = idCarta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getIdTipoCarta() {
		return idTipoCarta;
	}

	public void setIdTipoCarta(int idTipoCarta) {
		this.idTipoCarta = idTipoCarta;
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

	public int getIdJugador() {
		return idJugador;
	}

	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
	}

	// MÉTODOS
	@Override
	public String toString() {
		return "Carta [idCarta=" + idCarta + ", nombre=" + nombre + ", idTipoCarta=" + idTipoCarta + ", estado="
				+ estado + ", descripcion=" + descripcion + ", idJugador=" + idJugador + "]";
	}	
	
}
