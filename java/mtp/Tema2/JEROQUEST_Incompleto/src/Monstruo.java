/**
 * Prácticas de Metodología de la Programación.
 * Jeroquest - Un ejemplo de Programación orientada a objetos.
 * Clase Monstruo - clase abstracta que representa a los monstruos del juego
 * @author Jorge Puente Peinador y Ramiro Varela Arias
 *
 */



public abstract class Monstruo extends Personaje {
	
	/**
	 * Crea un monstruo a partir de su nombre y sus atributos iniciales
	 * inicialmente su posición es nula (fuera del tablero)
	 * @param nombre nombre del personaje
	 * @param mueve casillas que mueve por turno
	 * @param ataque dados que tira por ataque sin arma
	 * @param defensa dados que tira para defenderse
	 * @param cuerpo vida inicial
	 */
	public Monstruo(String nombre, int mueve, int ataque, int defensa, int cuerpo) 
	{
		super(nombre, mueve, ataque, defensa, cuerpo);
	}

	/** 
	 * El monstruo defiende de un ataque
	 * (Implementación de método abstracto heredado)
	 * @param impactos el total de impactos que tiene que intentar bloquear y sino sufrir
	 */
	public void defender(int impactos)
	{
		// se tratan de bloquear los impactos con la defensa
		for(int totalDadosDefensa = defensa; (impactos > 0) && (totalDadosDefensa > 0); totalDadosDefensa--)
			if (Dado.tira() == 6) // se necesita un 6 para detener un impacto
				impactos --;
		
		// si hay algun impacto se resta de la vida
		if(impactos > 0)
		{
			// la vida de un personaje no puede ser menor que cero
			cuerpo = Math.max(0, cuerpo - impactos);
			System.out.printf("El monstruo " + this.getNombre() + " no puede bloquear %d impactos %s", impactos, 
					(estaVivo() ? "\n" : " y se muere\n"));
		}
		else
		{
			System.out.printf("El monstruo %s bloquea totalmente el ataque\n",this.getNombre());
		}
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
		return (p instanceof Heroe);
	}
}
