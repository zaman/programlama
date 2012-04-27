/**
 * Prácticas de Metodología de la Programación.
 * Jeroquest - Un ejemplo de Programación orientada a objetos.
 * Clase Casilla - clase que representa a cada una de las celdas del tablero
 * @author Jorge Puente Peinador y Ramiro Varela Arias
 *
 */

public class Casilla {
	protected Ficha ficha;  // personaje que está en la casilla

	/**
	 * Construye una casilla vacía (sin personaje)
	 */
	public Casilla()
	{
		ficha = null;
	}

	/**
	 * Obtén la ficha de la casilla
	 * @return la ficha de la casilla, o null si no hay
	 */
	public Ficha getFicha()
	{
		return ficha;
	}
	
	/**
	 * Fija un personaje en la casilla
	 * @param ficha la ficha que se coloca en esa casilla
	 */
	public void setFicha(Ficha ficha)
	{
		this.ficha = ficha;
	}

	/**
	 * Comprueba que si la casilla no tiene personaje 
	 * @return cierto si no tiene personaje
	 */
	public boolean vacia()
	{
		return ficha == null;
	}
	
	/** 
	 * Genera la versión String imprimible del objeto
	 *  (Método reescrito)
	 * @return La versión como String imprimible de la casilla 
	 */
	@Override
	public String toString()
	{
		if (ficha == null) return "-";
		else return String.format("%c",ficha.toChar());
	}
}
