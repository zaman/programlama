/**
 * Prácticas de Metodología de la Programación.
 * Jeroquest - Un ejemplo de Programación orientada a objetos.
 * Clase Heroe - clase abstracta que representa a los héroes del juego
 * @author Jorge Puente Peinador y Ramiro Varela Arias
 *
 */



public abstract class Heroe extends Personaje {
	private String jugador; // nombre del jugador que maneja el héroe
	private Arma arma; // arma que equipa el héroe

	/**
	 * Crea un Heroe a partir de su nombre y sus atributos iniciales
	 * inicialmente su posición es nula (fuera del tablero)
	 * @param nombre nombre del personaje
	 * @param mueve casillas que mueve por turno
	 * @param ataque dados que tira por ataque sin arma
	 * @param defensa dados que tira para defenderse
	 * @param cuerpo vida inicial
	 * @param player el nombre del jugador que maneja este héroe
	 * @param arma el arma inicial
	 */
	
	public Heroe(String nombre, int mueve, int ataque, int defensa, int cuerpo, String player, Arma arma) {
		super(nombre, mueve, ataque, defensa, cuerpo);
		this.jugador = player;
		this.setArma(arma);
	}



	public Arma getArma() {
		return arma;
	}

	/**
	 * Fija el arma actual del héroe
	 * @param arma arma a fijar (posiblemente null si queremos quitarle la actual)
	 */
	public void setArma(Arma arma) {
		// fijamos el arma actual
		this.arma = arma;
		// fijamos su ataque actual
		if(arma != null){
			this.ataque = arma.getAtaque();
		} else
			// si es null, indica que atacará con su ataque inicial
			this.ataque = this.ataqueInicial;
	}
	
	/** 
	 * El héroe se defiende de un ataque
	 * (Implementación de método abstracto heredado)
	 * @param impactos el total de impactos que tiene que intentar bloquear y sino sufrir
	 */
	public void defender(int impactos)
	{
		// se tratan de bloquear los impactos con la defensa
		for(int totalDadosDefensa = defensa; (impactos > 0) && (totalDadosDefensa > 0);
		totalDadosDefensa--)
			if (Dado.tira() > 4) // se necesita un 5 o 6 para detener un impacto
				impactos --;
		
		// si hay algun impacto se resta de la vida
		if(impactos > 0)
		{
			// la vida de un personaje no puede ser menor que cero
			cuerpo = Math.max(0, cuerpo - impactos);
			System.out.printf(this.getNombre() + " no puede bloquear %d impactos%s", impactos,
					(estaVivo() ? "\n" : " y se muere\n"));
		}
		else
		{
			System.out.printf("El héroe %s bloquea totalmente el ataque\n", this.getNombre());
		}
	}

	/**
	 * Obtiene el nombre del jugador que maneja este héroe
	 * @return el nombre del jugador
	 */
	public String getPlayerName() {
		return jugador;
	}

	/**
	 * Establece el nombre del jugador que maneja este héroe
	 * @param playerName nombre del jugador
	 */
	public void setPlayerName(String playerName) {
		this.jugador = playerName;
	}

	/**
	 * Comprueba que el personaje pasado como argumento sea enemigo del actual
	 * Enemigo será todo aquel que sea un monstruo
	 *  (Método reescrito)
	 * @param p personaje a comprobar afiliación
	 * @return cierto si es enemigo del personaje actual
	 */
	@Override
	public boolean esEnemigo(Personaje p)
	{
		return (p instanceof Monstruo);
	}
	
	
	/** 
	 * Genera la versión String imprimible del objeto, añade a la
	 * descripción de Personaje el arma que equipa
	 *  (Método reescrito)
	 * @return La versión como String imprimible del personaje 
	 */
	@Override
	public String toString()
	{
		String s = super.toString();
		if(arma != null)
			s += " Equipado con " + arma.toString();

		return s;
	}
}
