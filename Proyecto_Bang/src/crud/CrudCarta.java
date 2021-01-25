package crud;

import java.util.Random;

import datos.BDCartas;
import model.Carta;

public class CrudCarta {
	BDCartas bdc = new BDCartas();

	private Carta mazo [];
	
	public CrudCarta() {
		int dosMil=2000;
		mazo = new Carta [dosMil];
	}

	public CrudCarta(Carta [] mazo) {
		this.mazo=mazo;
	}
	
	public void agregarCarta(Carta c, int idx_ultima_carta) {
		mazo[idx_ultima_carta]=c;
	}
	
	public Carta crearCarta() {
		int enMano = 1;
		Carta c = new Carta();
		int desde = 0, hasta = bdc.getCartas().length-1, aleatorio=0;
		Random r;
		r = new Random(System.nanoTime());
		aleatorio = r.nextInt(hasta-desde+1)+desde;
		//c = bdc.getCartas()[aleatorio];
		c.setNombre(bdc.getCartas()[aleatorio].getNombre());
		c.setDescripcion(bdc.getCartas()[aleatorio].getDescripcion());
		c.setAlcance(bdc.getCartas()[aleatorio].getAlcance());
		c.setIdx_Carta(bdc.getCartas()[aleatorio].getIdx_Carta());
		c.setTipo_Carta(bdc.getCartas()[aleatorio].getTipo_Carta());
		c.setEstado(enMano);
		return c;
	}
}
