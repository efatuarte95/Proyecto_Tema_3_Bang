package crud;

import model.Carta;

public class CrudCarta {

	private Carta mazo [];
	
	public CrudCarta() {
		int dosMil=2000;
		mazo = new Carta [dosMil];
	}

	public CrudCarta(Carta [] mazo) {
		this.mazo=mazo;
	}
}
