/**
 * Prácticas de Metodología de la Programación.
 * Jeroquest - Un ejemplo de Programación orientada a objetos.
 * Clase Personaje - clase abstracta que representa a cualquier personaje del juego
 * @author Jorge Puente Peinador y Ramiro Varela Arias
 *
 */

import javax.swing.Icon;
import javax.swing.ImageIcon;

public abstract class Personaje implements Ficha, PersonajeGrafico{
	// atributos actuales del personaje
	protected int mueve; // unidades de movimiento por turno
	protected int ataque; // total dados de ataque
	protected int defensa; // total dados de defensa
	protected int cuerpo; // puntos  de vida

	// atributos iniciales del personaje
	protected int mueveInicial; // unidades de movimiento por turno
	protected int ataqueInicial; // total dados de ataque
	protected int defensaInicial; // total dados de defensa
	protected int cuerpoInicial; // puntos  de vida

	protected String nombre; // nombre del personaje



	/**
	 * Crea un personaje a partir de su nombre y sus atributos iniciales
	 * inicialmente su posición es nula (fuera del tablero)
	 * @param nombre nombre del personaje
	 * @param mueve casillas que mueve por turno
	 * @param ataque dados que tira por ataque sin arma
	 * @param defensa dados que tira para defenderse
	 * @param cuerpo vida inicial
	 */
	public Personaje(String nombre, int mueve, int ataque, int defensa, int cuerpo) {
		
		this.nombre = nombre;

		// fijamos los atributos iniciales
		this.mueveInicial = mueve;
		this.ataqueInicial = ataque;
		this.defensaInicial = defensa;
		this.cuerpoInicial = cuerpo;

		// fijamos los atributos actuales
		this.mueve = mueve;
		this.ataque = ataque;
		this.defensa = defensa;
		this.cuerpo = cuerpo;

		// posicion nula (fuera del tablero)
		this.posicion = null;
	}

	/**
	 * Obtén las unidades de movimiento por turno
	 * (observador)
	 * @return unidades de movimiento del personaje
	 */
	public int getMueve() {
		return mueve;
	}

	/**
	 * Obtén los dados de ataque
	 * @return dados de ataque del personaje
	 */
	public int getAtaque() {
		return ataque;
	}

	/**
	 * Obtén los dados de defensa
	 * @return dados de defensa del personaje
	 */
	public int getDefensa() {
		return defensa;
	}

	/** 
	 * Obtén los puntos de vida 
	 * @return puntos de vida del personaje
	 */
	public int getCuerpo() {
		return cuerpo;
	}

	/** 
	 * observador de mueveInicial
	 * @return the mueveInicial
	 */
	public int getMueveInicial() {
		return mueveInicial;
	}

	/** 
	 * observador de ataqueInicial
	 * @return the ataqueInicial
	 */
	public int getAtaqueInicial() {
		return ataqueInicial;
	}

	/** 
	 * observador de defensaInicial
	 * @return the defensaInicial
	 */
	public int getDefensaInicial() {
		return defensaInicial;
	}

	/** 
	 * observador de cuerpoInicial
	 * @return the cuerpoInicial
	 */
	public int getCuerpoInicial() {
		return cuerpoInicial;
	}

	/**
	 * Obtén el nombre 
	 * @return el nombre del personaje 
	 */
	public String getNombre() {
		return nombre;
	}

	


	/**
	 * Comprueba si al personaje le queda algún punto de vida
	 * @return cierto si está vivo, falso en otro caso
	 */
	public boolean estaVivo() {
		return cuerpo > 0;
	}

	/** 
	 * Calcula un ataque del personaje calculando el número de impactos,
	 * para ello tira tantos dados como su propiedad ataque indique
	 * @return el número de impactos del personaje
	 */
	public int atacar() {
		int impactos = 0;
		for (int x = 0; x < ataque; x++)
			if (Dado.tira() > 3)
				impactos++;
		return impactos;
	}

	/**
	 * Simula un ataque a otro personaje, realiza el ataque y la defensa. Si acaba con el objetivo lo saca del tablero
	 * @param p personaje al que se ataca
	 * @param partidaActual partida actual
	 */
	public void combatir(Personaje p, Partida partidaActual) { // ataca a p y p se defiende
		p.defender(this.atacar());
		if (!p.estaVivo()) {
			partidaActual.getTablero().quitaPersonaje(p);
		}
	}

	/** 
	 * El personaje se defiende de un ataque
	 * (método abstracto)
	 * @param impactos el total de impactos que tiene que intentar detener o sufrir
	 */
	public abstract void defender(int impactos);
	
	/**
	 * Comprueba que el personaje pasado como argumento sea enemigo del actual
	 * Enemigo será todo aquel que no sea de la misma clase
	 * @param p personaje a comprobar afiliación
	 * @return cierto si es enemigo del personaje actual
	 */
	public boolean esEnemigo(Personaje p)
	{
		return this.getClass() != p.getClass();
	}

	/**
	 * IA: Inteligencia Artificial de los personajes
	 * Se realizan las acciones correspondientes a su turno: ataque y movimiento
	 * @param partidaActual partida en la que tiene que actuar el personaje
	 */
	public void resuelveTurno(Partida partidaActual) {
		// Atacar a un enemigo al azar
		VectorDinamicoPersonajes objetivos = Jeroquest.ObjetivosValidos(partidaActual, this);
		
		if(objetivos.length() > 0){
			Personaje objetivo = objetivos.get(Dado.tira(objetivos.length()) - 1);
			System.out.println(this.getNombre() + this.getPosicion()
					+ " ataca a " + objetivo.getNombre() + objetivo.getPosicion());
			this.combatir(objetivo, partidaActual);
		}

		// Nos movemos al azar por el tablero
		System.out.print(this.getNombre() + this.getPosicion() + " se mueve a ");
		VectorDinamicoXYLocation posicionesValidas = Jeroquest.posicionesValidas(partidaActual, this);
		int mov = this.getMueve();
		while((posicionesValidas.length()> 0) && (mov > 0)){
			// si puede se mueve en una dirección escogida al azar
			XYLocation nuevaPosicion = posicionesValidas.get(Dado.tira(posicionesValidas.length()) - 1);
			partidaActual.getTablero().muevePersonaje(this, nuevaPosicion);
			mov--;
			System.out.print(this.getPosicion());
			posicionesValidas = Jeroquest.posicionesValidas(partidaActual, this);
		}
	
		if(Jeroquest.bloqueado(partidaActual, this)) System.out.print("<<<BLOQUEADO");
		System.out.println();
		
		
		// Posibles mejoras (entre otras):
		// 				- Moverse hacia el enemigo más cercano/ con menos vida /...
		//					A.- Primero en Xs y luego en Ys
		//					B.- Primero en la coordenada que tenga mayor diferencia con la posición del objetivo
		//				- IA: comprobar si hay una ruta libre hasta el objetivo 
		//				- ¿Qué hacer si tenemos el camino bloqueado por otros personajes aliados?
		// 				- Detenerse si tenemos un enemigo a tiro
		// y si esta libre y dentro del tablero se mueve a esa posicion

	}

	/** 
	 * Genera la versión String imprimible del objeto
	 *  (Método reescrito)
	 * @return La versión como String imprimible del personaje 
	 */
	@Override
	public String toString() {
		return String
				.format("%s (mueve:%d ataque:%d defensa:%d cuerpo:%d/%d)",
						getNombre(), getMueve(), getAtaque(), getDefensa(),
						getCuerpo(),getCuerpoInicial());
	}

	
	/************************************************
	 * Implementación de la interfaz PersonajeGrafico
	 * **********************************************/

		// Icono de un personaje abstracto
		protected static Icon icono = new ImageIcon( ClassLoader.getSystemResource("desconocido.png" ));

		/**
		 * Devuelve el icono asociado a un personaje abstracto
		 * @return el icono asociado a la clase Personaje
		 */
		public Icon getImagenPersonaje()
		{
			return  icono;
		}

		/************************************************
		 * Implementación de la interfaz Ficha
		 * **********************************************/
		// por composicion
		protected XYLocation posicion;  // posicion ocupada en el tablero

		/**
		 * Obtén la posición en el tablero 
		 * @return laposición en el tablero del personaje
		 */
		public XYLocation getPosicion() {
			return posicion;
		}

		/**
		 * Fija la posición del personaje en el tablero
		 * @param pos nueva posición del personaje en el tablero
		 */
		public void setPosicion(XYLocation pos) {
			posicion = pos;
		}
		
		/**
		 * Genera la version texto de la vista del personaje en el tablero
		 * @return caracter del Personaje orientada a la vista del tablero
		 */
		public char toChar()
		{
			// si la sublcase no define otra cosa, los personajes aparecerán
			// como '?'s
			return '?';
		}


}
