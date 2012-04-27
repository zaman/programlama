/**
 * Prácticas de Metodología de la Programación.
 * Jeroquest - Un ejemplo de Programación orientada a objetos.
 * Clase Enano - clase que representa al héroe de tipo enano
 * @author Jorge Puente Peinador y Ramiro Varela Arias
 *
 */

import javax.swing.Icon;
import javax.swing.ImageIcon;



public class Enano extends Heroe {
	// valores iniciales de los atributos
	protected static final int MOVIMIENTO = 6;
	protected static final int ATAQUE = 1;
	protected static final int DEFENSA = 2;
	protected static final int CUERPO = 7;

	/**
	 * Crea un enano a partir de su nombre y el de su jugador
	 * @param nombre nombre del bárbaro
	 * @param jugador el nombre del jugador que lo controla
	 */
	public Enano(String nombre, String jugador)
	{
		super(nombre, MOVIMIENTO, ATAQUE, DEFENSA, CUERPO, jugador, new Arma("Hacha de mano", 2));
	
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
		return 'E';
	}

/************************************************
 * Implementación de la interfaz PersonajeGrafico
 * **********************************************/

	// Icono de un enano
	protected static Icon icono = new ImageIcon( ClassLoader.getSystemResource("enano.gif" ));
	
	public Icon getImagenPersonaje()
	{
		return  icono;
	}


}
