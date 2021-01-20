package datos;

import model.Carta;

public class BDCartas {

	// Tipo 0 = Bang; Tipo 1 = Fallaste; Tipo 2 = Acción; Tipo 3 = Arma
	private int idCartas[][] = {{0, 2}, {1, 2}, {2, 2}, {3, 2}, {4, 2}, {5, 2}, {6, 2}, {7, 2},
								{8, 3}, {9, 3}, {10, 3}, {11, 3}, {12, 3}, {13, 3}, {14, 3}, {15, 3}, 
								{16, 0}, {17, 1}};
	
	private String nombre_cartas[] = {"Salón", "Cerveza", "Almacén", "Diligencia", "Wells Fargo", 
			"Ametralladora Gatling", "¡Indios!", "Duelo", "Colt 45", "Revolver Carabine", "Schofield", 
			"Winchester", "Remington", "Volcanic", "Mira Telescópica", "Mustang", "¡BANG!", "Fallaste"};
}
