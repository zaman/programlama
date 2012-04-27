/**
 * Prácticas de Metodología de la Programación.
 * Jeroquest - Un ejemplo de Programación orientada a objetos.
 * Clase Tablero - clase que representa el tablero del juego
 * @author Jorge Puente Peinador y Ramiro Varela Arias
 *
 */

public class Tablero {
	protected Casilla [][] casillas;  // matriz de casillas
	protected int filas = 0; // número de filas
	protected int columnas = 0; // número de columnas

	/** 
	 * Crea un tablero con de acuerdo con unas dimensiones especificadas
	 * (constructor)
	 * @param filas el número de filas del tablero
	 * @param columnas el número de columnas del tablero
	 */
	Tablero(int filas, int columnas){
		this.filas = filas;
		this.columnas = columnas;
		casillas = new Casilla [filas][columnas]; 
		for (int i = 0; i< filas; i++)
			for(int j=0; j<columnas; j++)
				casillas[i][j] = new Casilla();
	}
	
	/** 
	 * Obtén el número de filas del tablero
	 * (observador)
	 * @return el número de filas
	 */
	public int getFilas()
	{
		return filas;
	}
	
	/** 
	 * Obtén el número de columnas del tablero
	 * (observador)
	 * @return el número de columnas
	 */
	public int getColumnas()
	{
		return columnas;
	}

	/** 
	 * Obtén la casilla de una posición del tablero
	 * (observador)
	 * @param pos posicion del tablero
	 * @return la casilla de dicha posición
	 */
	protected Casilla getCasilla(XYLocation pos){
		return casillas[pos.x][pos.y];
	}

	/** 
	 * Saca a un personaje del tablero
	 * (modificador)
	 * @param p personaje a sacar del tablero
	 */
	public void quitaPersonaje(Personaje p)
	{
		// si el personaje está en el tablero 
		if(p.getPosicion() != null){
			// se saca de él
			getCasilla(p.getPosicion()).setFicha(null);
			p.setPosicion(null);
		}
	}

	/** 
	 * Situa un personaje en una casilla adyacente a la actual
	 *  (Método sobrecargado)
	 *  @param p el personaje a colocar
	 *  @param dir direccion del momiviento: North, South, East o West
	 *  @return cierto si se pudo colocar, falso si no estaba en el tablero, si la casilla ya estaba ocupada o si se sale del tablero 
	 */
	public boolean muevePersonaje(Personaje p, Direction dir)
	{
		XYLocation pos1 = p.getPosicion();
		if (pos1 == null) // si no estaba en el tablero no se puede mover
			return false; 
		
		XYLocation pos2 = null;
		// calculamos la casilla en esa direccion
		switch(dir){
		case North:
			pos2 = pos1.norte();
			break;
		case South:
			pos2 = pos1.sur();
			break;
		case East:
			pos2 = pos1.este();
			break;
		case West:
			pos2 = pos1.oeste();
			break;
		}
		// movemos el personaje comprobando si la casilla en esa direccion es valida
		return muevePersonaje(p, pos2); // se trata de mover a dicha casilla
	}
	
	/**
	 * Comprueba si la casilla es válida
	 * @param pos posición a verificar
	 * @return cierto si la casilla es válida
	 */
	private boolean casillaValida(XYLocation pos){
		// si la casilla no es valida
		if ((pos.x < 0) || (pos.x >= filas)) return false;
		if ((pos.y < 0) || (pos.y >= columnas)) return false;
		// en otro caso es valida
		return true;
	}
	/**
	 * Comprueba si la casilla es válida y está vacía
	 * @param pos posición a verificar
	 * @return cierto si la casilla está vacía
	 */
	public boolean casillaLibre(XYLocation pos){
		return casillaValida(pos) && getCasilla(pos).vacia();
	}
	
	/** 
	 * Situa un personaje en una casilla vacía
	 *  (Método sobrecargado)
	 *	@param p el personaje a colocar
	 *	@param pos la posición de la casilla 
	 *	@return cierto si se pudo colocar, falso si la casilla ya estaba ocupada o no era válida 
	 */
	public boolean muevePersonaje(Personaje p,XYLocation pos){
		if (casillaLibre(pos)){
			// quitamos al personaje de la casilla actual
			quitaPersonaje(p);
			// se fija el personaje a la nueva casilla
			p.setPosicion(pos);
			getCasilla(pos).setFicha(p);
			
			return true; // se movió a la casilla
		} else 
			return false; // no se pudo mover
	}

	/** 
	 * Genera la versión String imprimible del objeto
	 *  (Método reescrito)
	 * @return La versión como String imprimible del tablero 
	 */
	@Override
	public String toString()
	{
		String s ="";
		for (int i=0; i<filas; i++){
			for (int j=0; j<columnas; j++) 
				s += casillas[i][j];
			s += "\n"; ;
		}
		return s;
	}

}
