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
	
}
