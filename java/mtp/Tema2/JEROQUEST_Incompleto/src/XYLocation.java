/**
 * Prácticas de Metodología de la Programación.
 * Jeroquest - Un ejemplo de Programación orientada a objetos.
 * Clase XYLocation - clase que representa posiciones 2D en el tablero
 * @author Jorge Puente Peinador y Ramiro Varela Arias
 *
 */

public class XYLocation {

	int x, y; // coordenadas 2D

	/**
	 * Crea una localizacion a partir de sus coordenadas
	 * @param x la fila
	 * @param y la columna
	 */
	public XYLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Obtén la coordenada x
	 * @return la coordenada x
	 */
	public int getX() {
		return x;
	}

	/** 
	 * Obtén la coordenada y
	 * @return la coordenada y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Fija la coordenada x
	 * @param x la nueva coordenada x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Fija la coordenada y
	 * @param y la nueva coordenada y
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Obtén la posición inmediatamente al norte de la actual
	 * @return la posición al norte de la actual
	 */
	public XYLocation norte(){
		return new XYLocation(this.x - 1 , this.y);
	}

	/**
	 * Obtén la posición inmediatamente al sur de la actual
	 * @return la posición al sur de la actual
	 */	
	public XYLocation sur(){
		return new XYLocation(this.x + 1, this.y);
	}

	/**
	 * Obtén la posición inmediatamente al este de la actual
	 * @return la posición al este de la actual
	 */
	public XYLocation este(){
		return new XYLocation(this.x, this.y + 1 );
	}

	/**
	 * Obtén la posición inmediatamente al oeste de la actual
	 * @return la posición al oeste de la actual
	 */
	public XYLocation oeste(){
		return new XYLocation(this.x, this.y - 1);
	}

	/**
	 * Operacion de comparacion de igualdad de dos objetos XYLocation
	 * @param o objeto con el que compararse
	 * @return cierto si es un objeto XYLocation con iguales coordenadas
	 */
	@Override
	public boolean equals(Object o) {
		if (null == o || !(o instanceof XYLocation)) {
			return super.equals(o);
		}
		XYLocation anotherLoc = (XYLocation) o;
		return ((anotherLoc.getX() == x) && (anotherLoc.getY() == y));
	}
	
	/** 
	 * Genera la versión String imprimible del objeto
	 *  (Método reescrito)
	 * @return La versión como String imprimible del XYLocation
	 */
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}

}