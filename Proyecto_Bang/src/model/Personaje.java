package model;

public class Personaje {
	
	// ATRIBUTOS
	private String nombre;
	private int vida;
	private int alcance;
	private String descripcion;
	
	// CONSTRUCTOR
	public Personaje(String nombre, int vida, int alcance, String descripcion) {
		this.nombre = nombre;
		this.vida = vida;
		this.alcance = alcance;
		this.descripcion = descripcion;
	}
	
	// GETTERS & SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
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

	// MÉTODOS
	@Override
	public String toString() {
		return "Personaje [nombre=" + nombre + ", vida=" + vida + ", alcance=" + alcance + ", descripcion=" + descripcion + "]";
	}

	public int perderVida() {
		vida--;
		return vida;
	}	
}

