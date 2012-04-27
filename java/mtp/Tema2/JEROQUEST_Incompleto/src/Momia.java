/**
 * Prácticas de Metodología de la Programación.
 * Jeroquest - Un ejemplo de Programación orientada a objetos.
 * Clase Momia - clase que representa al monstruo de tipo momia
 * @author Jorge Puente Peinador y Ramiro Varela Arias
 *
 */

import javax.swing.Icon;
import javax.swing.ImageIcon;



public class Momia extends Monstruo {

	// valores iniciales de los atributos
	protected static final int MOVIMIENTO = 4;
	protected static final int ATAQUE = 3;
	protected static final int DEFENSA = 4;
	protected static final int CUERPO = 2;

	/**
	 * Crea una momia a partir de su nombre
	 * @param nombre nombre de la momia
	 */
	public Momia(String nombre)
	{
		super(nombre, MOVIMIENTO, ATAQUE, DEFENSA, CUERPO); 
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
		return 'M';
	}
	
	/************************************************
	 * Implementación de la interfaz PersonajeGrafico
	 * **********************************************/

		// Icono de un enano
		protected static Icon icono = new ImageIcon( ClassLoader.getSystemResource("momia.gif" ));
		
		public Icon getImagenPersonaje()
		{
			return  icono;
		}

}
