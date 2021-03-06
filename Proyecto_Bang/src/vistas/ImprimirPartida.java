package vistas;

import datos.BDPartida;
import model.Partida;

public class ImprimirPartida {

	public void mostrarInstrucciones(BDPartida bdp) {
		System.out.println("\r\n"
				+ "                                                               \r\n"
				+ "\t\t88888888ba         db         888b      88    ,ad8888ba,   88  \r\n"
				+ "\t\t88      \"8b       d88b        8888b     88   d8\"'    `\"8b  88  \r\n"
				+ "\t\t88      ,8P      d8'`8b       88 `8b    88  d8'            88  \r\n"
				+ "\t\t88aaaaaa8P'     d8'  `8b      88  `8b   88  88             88  \r\n"
				+ "\t\t88\"\"\"\"\"\"8b,    d8YaaaaY8b     88   `8b  88  88      88888  88  \r\n"
				+ "\t\t88      `8b   d8\"\"\"\"\"\"\"\"8b    88    `8b 88  Y8,        88  \"\"  \r\n"
				+ "\t\t88      a8P  d8'        `8b   88     `8888   Y8a.    .a88  aa  \r\n"
				+ "\t\t88888888P\"  d8'          `8b  88      `888    `\"Y88888P\"   88  \r\n"
				+ "\t\t                                                               \r\n"
				+ "\t\t                                                               \r\n");
		System.out.println("Desde el principio de los tiempos, los Forajidos cazan al Sheriff y el Sheriff caza a los Forajidos.\n"
				+ "El Renegado planea en secreto, dispuesto a ponerse de uno u otro lado.\n"
				+ "�Pero qui�nes son los despiadados Forajidos que quieren coserle a tiros?\n"
				+ "�Para averiguarlo, tendr�s que desenfundar (las cartas, claro)!\n"
				+ "Solo ante el peligro bajo el ardiente sol de mediod�a, sucesos inesperados obligan a buscar refugio en una ciudad fantasma.\r\n"
				+ "En Dodge City, pistoleros compiten empleando nuevos trucos y t�cnicas desconocidas.\n"
				+ "Cuando la cosa se pone dura, los m�s duros ponen toda la carne en el asador y se lo juegan todo Por un pu�ado de cartas.\n"
				+ "�Y si eso no fuera suficiente, pistoleros a�n m�s extra�os salen de sus escondites!\n"
				+ "Ahora el Sheriff ha decidido zanjar las cosas de una vez por todas, a su manera...\n"
				+ "Ha escrito un nombre en una sola bala. Ese nombre es... BANG!");
		System.out.println("\nBANG! es un juego de duelos entre un grupo de Forajidos y su objetivo principal, el Sheriff, al m�s puro estilo de los Spaghetti Westerns.\n"
				+ "Los Alguaciles, de inc�gnito, ayudan al Sheriff, pero entre todos ellos hay un Renegado que persigue sus propios fines.\n"
				+ "En BANG! cada jugador interpreta alguno de estos Roles y representa a un Personaje inspirado en alg�n famoso del Salvaje Oeste.");
		System.out.println("\nAl principio de la partida se os asiganr� aleatoriamente un rol y un personaje a cada uno, cuya informaci�n podr�is consultar siempre que quer�is \n"
				+ "desde la opci�n correspondiente dentro de vuestro men�.");
		System.out.println("\nY por supuesto, no pens�is que vais a luchar solos. Al principio de la partida se os dar� tantas cartas como vidas tenga vuestro personaje.\n"
				+ "Estas cartas podr�n ser cartas de acci�n (Consumibles), Armas o bien cartas para atacar (BANG) o cartas de defensa (Fallaste).\n"
				+ "Adem�s, al comienzo de cada turno, tendr�is la posibilidad de aumentar vuestra mochila con dos cartas extras! Ahora bien, usadlas sabiamente, ya que solo\n"
				+ "podr�is usar un arma a la vez... ");
		System.out.println("\nROLES DE LA PARTIDA:");
		for (int i = 0; i < bdp.getRol().length; i++) {
			System.out.println("[" + (i+1) + "] - " + bdp.getRol()[i] + ": " + bdp.getDescripcion()[i]);
		}
		System.out.println("\nDicho esto... QUE COMIENCE EL JUEGO!\n");
	}
	
	public void imprimirRol(String [] rol) {
		for (int i = 0; i < rol.length; i++) {
			System.out.println(rol[i]);
		}
	}
	
	public void imprimirDescripcionRol(String [] descripcion) {
		for (int i = 0; i < descripcion.length; i++) {
			System.out.println(descripcion[i]);
		}
	}
	
	public void imprimirEstadoPartida(Partida p) {
		System.out.println("Estamos en la ronda n� " + p.getNumRonda());
		System.out.println("Es el turno de " + p.getJugadores()[p.getTurnoJugador()].getNombre());
	}
	
	public void mostrarMenuPartida() {
		System.out.println("�Qu� desea hacer?");
		System.out.println("[1] - Iniciar nueva partida");
		System.out.println("[0] - Salir.");
	}
	
	public void mostrarMenuAgregarJugador() {
		System.out.println("�Qu� desea hacer?");
		System.out.println("[1] - A�adir nuevo jugador");
		System.out.println("[0] - Salir.");
	}
	
	public void mostrarComenzarPartida() {
		System.out.println("�Qu� desea hacer?");
		System.out.println("[1] - Comenzar Partida");
		System.out.println("[0] - Volver al men� de creaci�n de jugadores.");
	}

}

