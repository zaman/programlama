/**
 * Prácticas de Metodología de la Programación.
 * Jeroquest - Un ejemplo de Programación orientada a objetos.
 * Clase Dado 
 * @author Jorge Puente Peinador y Ramiro Varela Arias
 * @version 1
 * 
 */

import java.util.Random; // generador de números aleatorios

	public class Dado {
		
		private static Random generador = new Random(); // generador de numeros aleatorios
		
		/**
		 * tira un dado de 6 caras: 1D6
		 * @return el resultado de la tirada de 1D6
		 */
		public static int tira()
		{
			return tira(6); // por defecto un dado de 6 caras
		}
		
		/**
		 * Tira un dado de N caras
		 * @param caras el número N de caras: 1DN
		 * @return el resultado de la tirada de 1DN
		 */
		public static int tira(int caras) // Necesita: el numero de caras
		{
			return generador.nextInt(caras) + 1;
		}
		
		/**
		 * Funcion de test que comprueba empiricamente que todas las caras son equiprobables
		 */
		public static void pruebaDado()
		{
			final int INTENTOS = 1000000;
			double totales[]={0,0,0,0,0,0};
			for(int x = 0; x < INTENTOS; x++)
				totales[tira()-1]++;
			for(int x = 0; x < 6; x++)
				System.out.printf("%d: %f\n", x, totales[x]/INTENTOS);
		}
	}
