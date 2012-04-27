/**
 * Prácticas de Metodología de la Programación.
 * Jeroquest - Un ejemplo de Programación orientada a objetos.
 * Interface PersonajeGrafico - Interfaz que modela la representación gráfica de un tipo de personaje
 *                              Más concretamente, el icono que le representa en el tablero
 * @author Jorge Puente Peinador y Ramiro Varela Arias
 *
 */

import javax.swing.Icon;

public interface PersonajeGrafico {
	/**
	 * Devuelve la imagen de icono asociada a la clase del personaje 
	 * @return el icono asociado a la clase del personaje
	 */
	public Icon getImagenPersonaje();
}
