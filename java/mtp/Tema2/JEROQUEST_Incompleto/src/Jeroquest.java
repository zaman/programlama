/**
 * Pr�cticas de Metodolog�a de la Programaci�n.
 * Clase Jeroquest - Representa al juego de Jeroquest, y permite jugar partidas de este juego. 
 * 				     Para ello dispone de un m�todo para crear una nueva partida y jugarla  
 * @author Jorge Puente Peinador y Ramiro Varela Arias
 *
 */

// La clase Jeroquest incluye una Partida y el metodo aJugar
// que implementa la logica del juego


public class Jeroquest {
	
	private Partida partidaActual; // partida actual

	/**
	 * Simula una partida de Jeroquest
	 */
	public void aJugar()
	{
		// GUI - Creamos la ventana para la partida actual 
		VentanaJeroquest monitor = new VentanaJeroquest(partidaActual);
		
		
		// Comienza la partida
		System.out.println("INICIO DE LA PARTIDA");
		
		// CONSOLA - imprime el estado inicial de la partida
		System.out.println(partidaActual);
		
		// GUI - actualizamos la partida en la ventana
		monitor.muestraPartida();
		MiTeclado.pulsaIntro();
				
		// resuelve la partida en rondas sucesivas 
		while (noFinalPartida())
		{
			// resolvemos la ronda actual
			resuelveRonda();
			
			// CONSOLA - imprime el estado actual de la partida
			System.out.println(partidaActual);
			
			// GUI - actualizamos la partida en la ventana
			monitor.muestraPartida();
			MiTeclado.pulsaIntro();
			
			// avanzamos ronda
			siguienteRonda();
		}
		
		// CONSOLA - muestra el final de la partida
		System.out.println("FIN DE LA PARTIDA");
		System.out.println("Ganan: " + masCuerpo());
		MiTeclado.pulsaIntro();
		
		// GUI - Cerramos la ventana
		monitor.finaliza();
	}

	/**
	 * crea una nueva partida a partir de sus componentes
	 * @param numHeroes cuantos h�roes
	 * @param numMonstruos cuantos monstruos
	 * @param filas alto del tablero
	 * @param columnas ancho del tablero
	 */
	public void nuevaPartida(int numHeroes, int numMonstruos, int filas, int columnas, int totalRondas)
	{ // Listo para la ronda 1
		partidaActual = new Partida(numHeroes, numMonstruos, filas, columnas, totalRondas);

		// distribuimos los personajes por el tablero al azar
		distribuyePersonajes();
	}
	
	/**
	 * Avanza una ronda m�s 
	 */
	private void siguienteRonda()
	{
		partidaActual.setRondaActual(partidaActual.getRondaActual()+1);
	}
	
	/**
	 * Comprobamos si se no se alcanz� el final de la partida
	 * @return cierto si ya se super� el total de rondas de la partida o no quedan personajes vivos en ambos bandos, falso en otro caso 
	 */
	private boolean noFinalPartida()
	{
		return ((partidaActual.getRondaActual() <= partidaActual.getTotalRondas()) && quedanContrincantes());
	}

	/**
	 * Ejecuta una ronda de la partida: cada personaje "vivo" resuelve su turno
	 * La ronda finaliza inmediatamente si en alg�n momento no quedan personjes con vida en ambos bandos  
	 */
	private void resuelveRonda()
	{
		System.out.println("Ronda: " + partidaActual.getRondaActual());
		
		for(int x = 0; (x < partidaActual.getPersonajes().length) && quedanContrincantes(); x++){
			Personaje p = partidaActual.getPersonajes()[x];
			if (p.estaVivo())
				if (p.getClass().getName()=="Zombi") {
					p.degradacion();
					if (p.estaVivo()) {
						p.resuelveTurno(partidaActual);
					}
				}
				p.resuelveTurno(partidaActual);
		}
	}
	
	/**
	 * Distribuye los personajes por el tablero al azar en posiciones v�lidas: (vac�as y dentro del tablero)  
	 */
	private void distribuyePersonajes()
	{
		int filas = partidaActual.getTablero().getFilas();
		int columnas = partidaActual.getTablero().getColumnas();
		
		for (Personaje p: partidaActual.getPersonajes())
		{
			// busca una posici�n al azar dentro del tablero
			int fil = Dado.tira(filas)-1;
			int col = Dado.tira(columnas)-1;
			// mientras la posicion no sea v�lida...
			while (!partidaActual.getTablero().muevePersonaje(p, new XYLocation(fil,col)) )
			{
				// se busca una nueva posici�n al azar
				fil = Dado.tira(filas)-1;
				col = Dado.tira(columnas)-1;
			}
		}	
	}

	/**
	 * Calcula que bando en total tiene m�s puntos de vida 
	 * @return el nombre del bando que tiene m�s puntos de vida
	 */
	private String masCuerpo()
	{ // Devuelve el nombre de la clase con mas puntos de cuerpo en la situacion actual de la partida
		int cHeroes = 0;
		int cMonstruos = 0;
	
		for (Personaje p: partidaActual.getPersonajes())
		{
			if (p instanceof Heroe) cHeroes += p.getCuerpo();
			else if (p instanceof Monstruo) cMonstruos += p.getCuerpo();
			//System.out.println(p.getClass());
		}
		if (cMonstruos > cHeroes) return "Monstruos";
		else 
			if (cHeroes > cMonstruos)
				return "H�roes";
			else 
				return "Empate";
	}

	/**
	 * Comprueba que haya personajes de ambos bandos con vida
	 * @return cierto si al menos hay un personaje vivo de cada bando
	 */
	
	public boolean quedanContrincantes()
	{ // Devuelve cierto si al menos los dos bandos tienen algun personaje vivo
		int y=0;
		int x=0;
		while ((x < partidaActual.getPersonajes().length) 
				&& (!partidaActual.getPersonajes()[x].estaVivo())) x++;
		
		if (x < partidaActual.getPersonajes().length) y = x; // El primer personaje vivo est� en y
		
		while ((x < partidaActual.getPersonajes().length)  // mientras no se llegue al final, y ...
				  && !(partidaActual.getPersonajes()[x].estaVivo() // ... no encontremos un personaje vivo que sea enemigo de y
				  && partidaActual.getPersonajes()[x].esEnemigo(partidaActual.getPersonajes()[y]))) 
			x++; // seguimos buscando
		
		if (x < partidaActual.getPersonajes().length) // El primer enemigo vivo del personaje de y est� en x
		return true; // Hay personajes vivos en los dos bandos
		else return false; // Todos los de alg�n bando est�n muertos
	}

	/**
	 * Devuelve un array con las casillas v�lidas a las que se puede mover directamente un personaje desde su posici�n actual:(N, S, E y O)
	 * (se define como est�tico ya que responde a las normas del juego en todo momento)
	 * @param partidaActual partida que contiene el tablero y los personajes
	 * @param pj personaje a analizar
	 * @return el vector de posiciones (posiblemente vac�o) a las que se puede mover
	 */
	public static VectorDinamicoXYLocation posicionesValidas(Partida partidaActual, Personaje pj)
	{
		VectorDinamicoXYLocation posiciones = new VectorDinamicoXYLocation();
		
		XYLocation posicion; 
		
		posicion = pj.getPosicion().sur();
		if(partidaActual.getTablero().casillaLibre(posicion))
			posiciones.add(posicion);
		
		posicion = pj.getPosicion().oeste();
		if(partidaActual.getTablero().casillaLibre(posicion))
			posiciones.add(posicion);
		
		return posiciones;
	}
	
	/**
	 * Devuelve un array con los objetivos v�lidos para el personaje actual
	 * (se define como est�tico ya que responde a las normas del juego en todo momento)
	 * @param partidaActual la partida en juego
	 * @param pj el personaje que actua
	 * @return los objetivos validos para el personaje en su posici�n actual
	 */
	public static VectorDinamicoPersonajes ObjetivosValidos(Partida partidaActual, Personaje pj)
	{
		// busca objetivos
		VectorDinamicoPersonajes objetivosValidos = new VectorDinamicoPersonajes();
		
		// Hay que recorrer los personajes de la partida y a�adir los objetivos validos, es decir:
		// 1.- Que est�n vivos
		// 2.- Que sean enemigos
		// 3.- Que est�n a tiro (ver manual del Jeroquest2.0)

		return objetivosValidos;
	}
	
	/** 
	 * Comprueba si las posiciones de dos personajes son adyacentes
	 * (se define como est�tico ya que responde a las normas del juego en todo momento) 
	 * @param pos1 posici�n del primer personaje
	 * @param pos2 posici�n del segundo personaje
	 * @return cierto si las casilla son adyacentes, falso en otro caso 
	 */
	public static boolean estanATiro(XYLocation pos1, XYLocation pos2)
	{
		// pos2 al Norte o Sur de pos1
		if ((pos1.x == pos2.x - 1) && (pos1.y == pos2.y)) 
			return true;

		// pos2 al Sur de pos1
		if ((pos1.x == pos2.x + 1) && (pos1.y == pos2.y))
			return true;
		
		// pos2 al Este de pos1
		if ((pos1.y == pos2.y - 1) && (pos1.x == pos2.x)) 
			return true;

		// pos2 al Oeste de pos1
		if ((pos1.y == pos2.y + 1) && (pos1.x == pos2.x)) 
			return true;

		return false;
	}
	
	/**
	 * Comprueba si el personaje est� bloqueado, es decir, si no puede moverse a ninguna posici�n: N, S, E, O
	 * (se define como est�tico ya que responde a las normas del juego en todo momento) 
	 * @param partidaActual la partida en juego
	 * @param p personaje a comprobar
	 * @return cierto si no puede moverse en ninguna direcci�n
	 */
	public static boolean bloqueado(Partida partidaActual, Personaje p){
		Tablero tab = partidaActual.getTablero();
		return !(tab.casillaLibre(p.getPosicion().norte()) ||
				tab.casillaLibre(p.getPosicion().sur()) ||
				tab.casillaLibre(p.getPosicion().este()) ||
				tab.casillaLibre(p.getPosicion().oeste()));
	}
	
	
	/**
	 * Genera una direccion de movimiento al azar 
	 * @return una direccion: North, South, East o West
	 */
	public static Direction direccionAlAzar() {
		int dir = Dado.tira(4);
		switch (dir) {
		case 1:
			return Direction.North;
		case 2:
			return Direction.South;
		case 3:
			return Direction.East;
		case 4:
		default:
			return Direction.West;
		}
	}

}
