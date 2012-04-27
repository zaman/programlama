/**
 * Pr�cticas de Metodolog�a de la Programaci�n.
 * Jeroquest - Un ejemplo de Programaci�n orientada a objetos.
 * Clase Momia - clase que representa al monstruo de tipo momia
 * @author Jorge Puente Peinador y Ramiro Varela Arias
 *
 */

import javax.swing.Icon;
import javax.swing.ImageIcon;



public class Zombi extends Monstruo {

	// valores iniciales de los atributos
	protected static final int MOVIMIENTO = 4;
	protected static final int ATAQUE = 3;
	protected static final int DEFENSA = 3;
	protected static final int CUERPO = 3;

	public Zombi(String nombre)
	{
		super(nombre, MOVIMIENTO, ATAQUE, DEFENSA, CUERPO); 
	}
	public void defender(int impactos) {
		for(int totalDadosDefensa = defensa; (impactos > 0) && (totalDadosDefensa > 0); totalDadosDefensa--)
			if (Dado.tira() == 6) // se necesita un 6 para detener un impacto
				impactos --;
	}
	public char toChar()
	{
		return 'Z';
	}
	


		// Icono de un enano
		protected static Icon icono = new ImageIcon( ClassLoader.getSystemResource("zombi.gif" ));
		
		public Icon getImagenPersonaje()
		{
			return  icono;
		}

}
