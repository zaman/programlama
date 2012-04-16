/**
 * Prácticas de Metodología de la Programación.
 * Jeroquest - Un ejemplo de Programación orientada a objetos.
 * Programa principal 
 * @author Jorge Puente Peinador y Ramiro Varela Arias
 * @version 1
 *
 */

public class JeroquestTest {

	public static void main(String[] args) {
		
		Momia ramses = new Momia("Ramses");
		Barbaro conan = new Barbaro("Conan");
		
		System.out.println(ramses);
		System.out.println(conan);
		
		// conan ataca a ramses
		int impactos = conan.atacar();
		ramses.defender(impactos);
		
		// si ramses esta vivo ataca a conan
		if (ramses.estaVivo())
			conan.defender(ramses.atacar());
			
		System.out.println(ramses);
		System.out.println(conan);
	}

}
