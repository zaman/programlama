// Demo de la clase jeroquest



/**
 * Programa principal de prueba del juego Jeroquest
 * @author Jorge Puente Peinador
 * @version 1.3
 *
 */
public class Jeroquest_Test {

	public static void main(String[] args) {

		Jeroquest jq = new Jeroquest();
		// vamos a jugar una partida de 3 Bárbaros contra 4 Momias en 20 turnos
		// en un tablero de 7 por 10
		jq.nuevaPartida(3,4,7,10,20);
		jq.aJugar();	
	}

}
