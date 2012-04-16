

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class CirculosTest {

	/**
	 * @param args
	 */
	private static Ventana v = null;
	
	public static void main(String[] args) {

		final int TOTAL = 20;
		CirculoConCentro[] circulos = new CirculoConCentro[TOTAL];
		
		// Crea y muestra la ventana de la aplicación
		iniciaVentana();
		
		// Crea los circulos
		for(int x = 0; x < TOTAL; x++)
			circulos[x] = new CirculoConCentro(Dado.tira(250)+1,Dado.tira(250)+1,Dado.tira(50)+1);
		 	//circulos[x] = new CirculoConCentro((x/5)*100,(x % 5)*60,40);//Dado.tira(v.getWidth()-100), Dado.tira(v.getHeight()-100), Dado.tira(50));
		    //circulos[x] = new CirculoConCentro((5)*60,(5)*60,40);
		

		// mostramos los circulos
		   muestraCirculos(circulos);
		
		for(Circulo c: circulos)
			System.out.println(c);
		System.out.println("FIN");
		
	}
	 
	private static void iniciaVentana()
	{
		 v = new Ventana(); 
	}
	 
	private static void muestraCirculos(CirculoConCentro[] circulos)
	{
		 	// Los muestra por consola
		 	for(Circulo c: circulos)
				System.out.println(c);
		 	// Los muestra graficamente en la ventana
			v.muestraCirculos(circulos);
			// Espera la pulsacion de Enter
			pulsaEnter();
	}
	 
	public static void pulsaEnter() {
		    
		    BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		    System.out.println("Pulsa Enter para continuar");
		    try {
		      teclado.readLine();
		    }
		    catch (IOException ex1) {
		    }
	}

}
