/**
 * Prácticas de Metodología de la Programación.
 * Jeroquest - Un ejemplo de Programación orientada a objetos.
 * Clase Barbaro - clase que representa a los héroes de tipo bárbaro
 * @author Jorge Puente Peinador y Ramiro Varela Arias
 *
 */

import javax.swing.Icon;
import javax.swing.ImageIcon;



public class Barbaro extends Heroe {
	// valores iniciales de los atributos
	protected static final int MOVIMIENTO = 7;
	protected static final int ATAQUE = 1;
	protected static final int DEFENSA = 2;
	protected static final int CUERPO = 8;

	/**
	 * Crea un bárbaro a partir de su nombre y el de su jugador
	 * @param nombre el nombre del bárbaro
	 * @param jugador el nombre del jugador que lo controla
	 */
	public Barbaro(String nombre, String jugador)
	{
		super(nombre, MOVIMIENTO, ATAQUE, DEFENSA, CUERPO, jugador, new Arma("Espada Ancha", 3));
	}

	/************************************************
	 * Implementación de la interfaz Ficha
	 * **********************************************/
	
	/**
	 * Genera la version texto de la vista del personaje en el tablero
	 * (implementando operación abstracta)
	 * @return la version en cadena del objeto orientada a la vista del tablero
	 */
	public char toChar()
	{
		return 'B';
	}

	/************************************************
	 * Implementación de la interfaz PersonajeGrafico
	 * **********************************************/

		// Icono de un bárbaro
		protected static Icon icono = new ImageIcon( ClassLoader.getSystemResource("barbaro.gif" ));
		
		public Icon getImagenPersonaje()
		{
			return  icono;
		}


}
