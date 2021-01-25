package vistas;

import model.Partida;

public class ImprimirPartida {

	public void mostrarInstrucciones() {
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
				+ "¿Pero quiénes son los despiadados Forajidos que quieren coserle a tiros?\n"
				+ "¡Para averiguarlo, tendrás que desenfundar (las cartas, claro)!\n"
				+ "Solo ante el peligro bajo el ardiente sol de mediodía, sucesos inesperados obligan a buscar refugio en una ciudad fantasma.\r\n"
				+ "En Dodge City, pistoleros compiten empleando nuevos trucos y técnicas desconocidas.\n"
				+ "Cuando la cosa se pone dura, los más duros ponen toda la carne en el asador y se lo juegan todo Por un puñado de cartas.\n"
				+ "¡Y si eso no fuera suficiente, pistoleros aún más extraños salen de sus escondites!\n"
				+ "Ahora el Sheriff ha decidido zanjar las cosas de una vez por todas, a su manera...\n"
				+ "Ha escrito un nombre en una sola bala. Ese nombre es... BANG!");
		System.out.println("BANG! es un juego de duelos entre un grupo de Forajidos y su objetivo principal, el Sheriff, al más puro estilo de los Spaghetti Westerns.\n"
				+ "Los Alguaciles, de incógnito, ayudan al Sheriff, pero entre todos ellos hay un Renegado que persigue sus propios fines.\n"
				+ "En BANG! cada jugador interpreta alguno de estos Roles y representa a un Personaje inspirado en algún famoso del Salvaje Oeste.\n\n");
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
		System.out.println("Estamos en la ronda nº " + p.getNumRonda());
		System.out.println("Es el turno de " + p.getJugadores()[p.getTurnoJugador()].getNombre());
	}
	
	public void mostrarMenuPartida() {
		System.out.println("¿Qué desea hacer?");
		System.out.println("[1] - Iniciar nueva partida");
		System.out.println("[0] - Salir.");
	}
	
	public void mostrarMenuAgregarJugador() {
		System.out.println("¿Qué desea hacer?");
		System.out.println("[1] - Añadir nuevo jugador");
		System.out.println("[0] - Salir.");
	}
	
	public void mostrarComenzarPartida() {
		System.out.println("¿Qué desea hacer?");
		System.out.println("[1] - Comenzar Partida");
		System.out.println("[0] - Volver al menú de creación de jugadores.");
	}

}

