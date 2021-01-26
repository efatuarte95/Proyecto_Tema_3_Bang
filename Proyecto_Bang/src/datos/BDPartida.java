package datos;

import model.Partida;

public class BDPartida {

	private String rol[] = {"Sheriff", "Alguacil", "Forajido", "Forajido", "Renegado"};
	private String descripcion[] = {"El Sheriff tiene como objetivo eliminar a todos los forajidos y al renegado para ganar la partida.", 
			"El alguacil debe proteger siempre al Sheriff aunque sea a costa de su vida que éste cumpla su objetivo.", 
			"Los forajidos ganan si muere el Sheriff, aunque un buen forajido no tiene escrúpulos en eliminar a otro forajido.",
			"Los forajidos ganan si muere el Sheriff, aunque un buen forajido no tiene escrúpulos en eliminar a otro forajido.",
			"El renegado solo gana si es el último hombre en pie, es decir, el resto de jugadores tienen que haber sido previamente eliminados. \nSin duda representa un poco el equilibrio de la partida, pero siempre vela por sus propios intereses."};

	Partida p = new Partida (rol);
	// GETTERS & SETTERS
	public String[] getRol() {
		return rol;
	}

	public void setRol(String[] rol) {
		this.rol = rol;
	}

	public String[] getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String[] descripcion) {
		this.descripcion = descripcion;
	}
	
}
