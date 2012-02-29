/**
 * Prácticas de Metodología de la Programación.
 * Jeroquest - Un ejemplo de Programación orientada a objetos.
 * Clase Momia 
 * @author Jorge Puente Peinador y Ramiro Varela Arias
 * @version 1
 * 
 */

public class Momia extends Personaje {

	// valores iniciales de los atributos
	protected static final int MOVIMIENTO = 4;
	protected static final int ATAQUE = 3;
	protected static final int DEFENSA = 4;
	protected static final int CUERPO = 2;

	/**
	 * Crea una momia a partir de su nombre
	 * @param suNombre nombre de la momia
	 */
	public Momia(String suNombre)
	{
		super(suNombre);
		// fijamos los atributos con los valores iniciales
		mueve = MOVIMIENTO;
		ataque = ATAQUE;
		defensa = DEFENSA;
		cuerpo = CUERPO;
	}
	
	/** 
	 * La momia se defiende de un ataque
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
			System.out.printf("La momia " + this.getNombre() + " no puede bloquear %d impactos %s", impactos, 
					(estaVivo() ? "\n" : " y se muere\n"));
		}
		else
		{
			System.out.printf("La momia bloquea totalmente el ataque\n");
		}
	}
	
	/** 
	 * Genera la versión String imprimible del objeto
	 *  (Método reescrito)
	 * @return La versión como String imprimible de la momia
	 */
	public String toString()
	{
		return String.format("La Momia: %s", super.toString());
	}
}
