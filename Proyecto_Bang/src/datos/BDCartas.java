package datos;

import java.util.Arrays;

import model.Carta;

public class BDCartas {

	// int idCarta, String nombre, int idTipoCarta, int estado, int alcance, String descripcion, int idJugador
	// Tipo 0 = Bang; Tipo 1 = Fallaste; Tipo 2 = Acción; Tipo 3 = Arma
	// Estado 0 = "En mazo", Estado 1 = "En mano", Estado 2 = "En juego"
	
	private Carta c0 = new Carta (0, "Salón", 2, 0, 0, "Recupera 1 de vida a todos los jugadores.", -1);
	private Carta c1 = new Carta (1, "Cerveza", 2, 0, 0, "Recupera 1 de vida.", -1);
	private Carta c2 = new Carta (2, "Almacén", 2, 0, 0, "Todos los jugadores roban 1 carta.", -1);
	private Carta c3 = new Carta (3, "Diligencia", 2, 0, 0, "Roba 2 cartas.", -1);
	private Carta c4 = new Carta (4, "Wells Fargo", 2, 0, 0, "Roba 3 cartas.", -1);
	private Carta c5 = new Carta (5, "Ametralladora Gatling", 2, 0, 0, "Dispara un BANG a todos los jugadores.", -1);
	private Carta c6 = new Carta (6, "¡Indios!", 2, 0, 0, "Utiliza un BANG o pierde 1 de vida.", -1);
	private Carta c7 = new Carta (7, "Duelo", 2, 0, 0, "Utilízalo para iniciar un duelo con alguien, por cada BANG que saques él tendrá que sacar un FALLASTE, el que pierda pierde 1 de vida.", -1);
	private Carta c8 = new Carta (8, "Colt 45", 3, 0, 1, "Tu alcance cambia a 1.", -1);
	private Carta c9 = new Carta (9, "Revolver Carabine", 3, 0, 4, "Tu alcance cambia a 4.", -1); 
	private Carta c10 = new Carta (10, "Schofield", 3, 0, 2, "Tu alcance cambia a 2.", -1);
	private Carta c11 = new Carta (11, "Winchester", 3, 0, 5, "Tu alcance cambia a 5.", -1);
	private Carta c12 = new Carta (12, "Remington", 3, 0, 3, "Tu alcance cambia a 3.", -1);
	private Carta c13 = new Carta (13, "Volcanic", 3, 0, 1, "Tu alcance cambia a 1, puedes tirar todos los BANG que quieras.", -1);
	private Carta c14 = new Carta (14, "Mira Telescópica", 3, 0, 1, "Modifica la distancia respecto al resto de jugadores en 1.", -1);
	private Carta c15 = new Carta (15, "Mustang", 3, 0, 1, "Aumenta la distancia a la que te ven el resto de jugadores en 1.", -1);
	private Carta c16 = new Carta (16, "¡BANG!", 0, 0, 0, "Dispara a un enemigo.", -1);
	private Carta c17 = new Carta (17, "¡BANG!", 0, 0, 0, "Dispara a un enemigo.", -1);
	private Carta c18 = new Carta (18, "¡BANG!", 0, 0, 0, "Dispara a un enemigo.", -1);
	private Carta c19 = new Carta (19, "¡BANG!", 0, 0, 0, "Dispara a un enemigo.", -1);
	private Carta c20 = new Carta (20, "¡BANG!", 0, 0, 0, "Dispara a un enemigo.", -1);
	private Carta c21 = new Carta (21, "¡BANG!", 0, 0, 0, "Dispara a un enemigo.", -1);
	private Carta c22 = new Carta (22, "Fallaste", 1, 0, 0, "Esquiva el disparo de un enemigo.", -1);
	private Carta c23 = new Carta (23, "Fallaste", 1, 0, 0, "Esquiva el disparo de un enemigo.", -1);
	private Carta c24 = new Carta (24, "Fallaste", 1, 0, 0, "Esquiva el disparo de un enemigo.", -1);
	private Carta c25 = new Carta (25, "Fallaste", 1, 0, 0, "Esquiva el disparo de un enemigo.", -1);
	private Carta c26 = new Carta (26, "Fallaste", 1, 0, 0, "Esquiva el disparo de un enemigo.", -1);
	private Carta c27 = new Carta (27, "Fallaste", 1, 0, 0, "Esquiva el disparo de un enemigo.", -1);

	
	private Carta cartas[] = {c0, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21, c22, c23, c24, c25, c26, c27};

	public Carta getC0() {
		return c0;
	}

	public void setC0(Carta c0) {
		this.c0 = c0;
	}

	public Carta getC1() {
		return c1;
	}

	public void setC1(Carta c1) {
		this.c1 = c1;
	}

	public Carta getC2() {
		return c2;
	}

	public void setC2(Carta c2) {
		this.c2 = c2;
	}

	public Carta getC3() {
		return c3;
	}

	public void setC3(Carta c3) {
		this.c3 = c3;
	}

	public Carta getC4() {
		return c4;
	}

	public void setC4(Carta c4) {
		this.c4 = c4;
	}

	public Carta getC5() {
		return c5;
	}

	public void setC5(Carta c5) {
		this.c5 = c5;
	}

	public Carta getC6() {
		return c6;
	}

	public void setC6(Carta c6) {
		this.c6 = c6;
	}

	public Carta getC7() {
		return c7;
	}

	public void setC7(Carta c7) {
		this.c7 = c7;
	}

	public Carta getC8() {
		return c8;
	}

	public void setC8(Carta c8) {
		this.c8 = c8;
	}

	public Carta getC9() {
		return c9;
	}

	public void setC9(Carta c9) {
		this.c9 = c9;
	}

	public Carta getC10() {
		return c10;
	}

	public void setC10(Carta c10) {
		this.c10 = c10;
	}

	public Carta getC11() {
		return c11;
	}

	public void setC11(Carta c11) {
		this.c11 = c11;
	}

	public Carta getC12() {
		return c12;
	}

	public void setC12(Carta c12) {
		this.c12 = c12;
	}

	public Carta getC13() {
		return c13;
	}

	public void setC13(Carta c13) {
		this.c13 = c13;
	}

	public Carta getC14() {
		return c14;
	}

	public void setC14(Carta c14) {
		this.c14 = c14;
	}

	public Carta getC15() {
		return c15;
	}

	public void setC15(Carta c15) {
		this.c15 = c15;
	}

	public Carta getC16() {
		return c16;
	}

	public void setC16(Carta c16) {
		this.c16 = c16;
	}

	public Carta getC17() {
		return c17;
	}

	public void setC17(Carta c17) {
		this.c17 = c17;
	}

	public Carta[] getCartas() {
		return cartas;
	}

	public void setCartas(Carta[] cartas) {
		this.cartas = cartas;
	}

	@Override
	public String toString() {
		return "BDCartas [c0=" + c0 + ", c1=" + c1 + ", c2=" + c2 + ", c3=" + c3 + ", c4=" + c4 + ", c5=" + c5 + ", c6="
				+ c6 + ", c7=" + c7 + ", c8=" + c8 + ", c9=" + c9 + ", c10=" + c10 + ", c11=" + c11 + ", c12=" + c12
				+ ", c13=" + c13 + ", c14=" + c14 + ", c15=" + c15 + ", c16=" + c16 + ", c17=" + c17 + ", cartas="
				+ Arrays.toString(cartas) + "]";
	}
	
	
}
