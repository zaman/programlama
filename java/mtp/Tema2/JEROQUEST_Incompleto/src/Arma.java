/**
 * Prácticas de Metodología de la Programación.
 * Jeroquest - Un ejemplo de Programación orientada a objetos.
 * Clase Arma - clase que representa las armas de los héroes
 * @author Jorge Puente Peinador y Ramiro Varela Arias
 *
 */

public class Arma {

	private String nombre; // nombre del arma
	private int ataque; // dados de ataque del arma
	
	/**
	 * Constructor de Arma a partir de sus componentes
	 * @param Nombre el nombre del arma
	 * @param Ataque dados de daño del arma
	 */
	Arma(String Nombre, int Ataque)
	{
		nombre = Nombre;
		ataque = Ataque;
	}
	
	/**
	 * Observador de nombre
	 * @return el nombre del arma
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Observador de ataque
	 * @return dados de ataque del arma
	 */
	public int getAtaque() {
		return ataque;
	}

	/** 
	 * Genera la versión String imprimible del objeto
	 *  (Método reescrito)
	 * @return La versión como String imprimible del arma 
	 */
	@Override
	public String toString()
	{
		return nombre + " (" + ataque + " dados)"; 
	}
}
