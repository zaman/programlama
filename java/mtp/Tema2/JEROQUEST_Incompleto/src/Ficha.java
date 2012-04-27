/**
 * Prácticas de Metodología de la Programación.
 * Jeroquest - Un ejemplo de Programación orientada a objetos.
 * Interface Ficha - interfaz que modela el comportamiento de una ficha en el tablero
 * @author Jorge Puente Peinador y Ramiro Varela Arias
 *
 */

public interface Ficha {

	/**
	 * Obtén la posición en el tablero 
	 * @return laposición en el tablero del personaje
	 */
	XYLocation getPosicion();
	
	/**
	 * Fija la posición del personaje en el tablero
	 * @param pos nueva posición del personaje en el tablero
	 */
	void setPosicion(XYLocation pos);
	
	/**
	 * Devuelve un caracter que representa a la ficha 
	 * @return la version char de la ficha actual
	 */
	char toChar();

}


