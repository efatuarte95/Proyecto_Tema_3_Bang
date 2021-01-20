package datos;

import model.Partida;

public class BDPartida {

	private String rol[] = {"Sheriff", "Alguacil", "Forajido1", "Forajido2", "Renegado"};

	Partida p = new Partida (rol);
	// GETTERS & SETTERS
	public String[] getRol() {
		return rol;
	}

	public void setRol(String[] rol) {
		this.rol = rol;
	}
	
}
