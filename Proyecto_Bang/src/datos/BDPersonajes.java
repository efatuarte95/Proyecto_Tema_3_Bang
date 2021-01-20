package datos;

import model.Personaje;

public class BDPersonajes {
	
	private Personaje p1 = new Personaje ("Bart Cassidy", 4 , 1, null, "Cada vez que pierde un punto de vida, roba inmediatamente una carta del mazo.");
	private Personaje p2 = new Personaje ("Calamity Janet", 4, 1, null, "Puede usar las cartas ¡BANG! como cartas ；allaste! y las cartas Fallaste! como cartas ¡BANG!. Si Calamity Janet usa una carta Fallaste! como carta ¡BANG!, no puede jugar ningún otro ¡BANG! en el turno (a menos que tenga en juego una Volcanic).");
	private Personaje p3 = new Personaje ("Paul Regret", 3, 1, null, "Se considera que siempre tiene en juego un Mustang. Todos los demás jugadores deben sumar 1 a la distancia a la que lo ven. Si Paul Regret tiene además un Mustang en juego, los efectos de los dos se suman y la distancia a la que los demás ven a Paul Regret se incrementa en 2.");
	private Personaje p4 = new Personaje ("Rose Doolan", 4, 1, null, "Se considera que siempre tiene en juego una Mira Telescópica. Rose ve a todos los demás jugadores a una distancia reducida en 1. Si Rose tiene además una Mira Telescópica en juego, los efectos de las dos se suman y reducen la distancia a la que Rose ve a los demás en 2.");
	private Personaje p5 = new Personaje ("Sid Ketchum", 4, 1, null, "En cualquier momento, puede descartar dos cartas (¡BANG! o FALLASTE) y recuperar 1 punto de vida. Puede hacer esto todas las veces que quiera seguidas, siempre que tenga cartas que descartar. Debes tener en cuenta que no se pueden tener más puntos de vida por encima de los iniciales.");
	private Personaje p6 = new Personaje ("Slab", 4, 1, null, "Los jugadores que intenten anular un ¡BANG! que haya sido jugado por Slab, tienen que jugar dos Fallaste!.");
	private Personaje p7 = new Personaje ("Suzy Lafayette", 4, 1, null, "En el momento en que se quede sin cartas, roba una carta del mazo. ");
	private Personaje p8 = new Personaje ("Willy el Niño", 4, 1, null, "Puede jugar tantas cartas ¡BANG! como quiera en su turno.");
	
	private Personaje personajes[] = {p1, p2, p3, p4, p5, p6, p7, p8};
	
	public Personaje[] getPersonajes() {
		return personajes;
	}
	public void setPersonajes(Personaje[] personajes) {
		this.personajes = personajes;
	}
	
	public Personaje getP1() {
		return p1;
	}
	public void setP1(Personaje p1) {
		this.p1 = p1;
	}
	public Personaje getP2() {
		return p2;
	}
	public void setP2(Personaje p2) {
		this.p2 = p2;
	}
	public Personaje getP3() {
		return p3;
	}
	public void setP3(Personaje p3) {
		this.p3 = p3;
	}
	public Personaje getP4() {
		return p4;
	}
	public void setP4(Personaje p4) {
		this.p4 = p4;
	}
	public Personaje getP5() {
		return p5;
	}
	public void setP5(Personaje p5) {
		this.p5 = p5;
	}
	public Personaje getP6() {
		return p6;
	}
	public void setP6(Personaje p6) {
		this.p6 = p6;
	}
	public Personaje getP7() {
		return p7;
	}
	public void setP7(Personaje p7) {
		this.p7 = p7;
	}
	public Personaje getP8() {
		return p8;
	}
	public void setP8(Personaje p8) {
		this.p8 = p8;
	}
	

}