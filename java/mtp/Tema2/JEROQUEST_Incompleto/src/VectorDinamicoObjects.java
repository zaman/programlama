/**
 * Prácticas de Metodología de la Programación.
 * Clase VectorDinamicoObjects - Clase que permite representar vectores dinámicos de objetos (Object). 
 *                               Incluye operaciones como insert, remove, set, get, ...
 * @author Jorge Puente Peinador y Ramiro Varela Arias
 *
 */

public class VectorDinamicoObjects {
	// representación de los datos
	private Object [] datos;
	
	// Constructores
	public VectorDinamicoObjects(){
		datos = new Object[0];
	}
	
	public VectorDinamicoObjects(VectorDinamicoObjects vDE){
		datos = new Object[vDE.length()];
		for (int i=0; i<datos.length; i++)
			datos[i] = vDE.get(i);
	}
	
	public VectorDinamicoObjects(int size){
		datos = new Object [size];
		for (int i = 0; i<datos.length; i++)
			datos[i] = null;
	}
	
	public VectorDinamicoObjects(Object [] v){
		datos = new Object [v.length];
		for (int i = 0; i<datos.length; i++)
			datos[i] = v[i];
	}
	
	// Observadores
	public int length() {
		return datos.length;
	}
	
	public boolean isNull(){
		return datos.length == 0;
	}
	
	public Object get(int i){
		return datos[i];
	}
	
	public void muestra(){
		System.out.println("\nVectorDinamicoEnteros");
		System.out.printf("Longitud: %d", datos.length);
		System.out.print("\nDatos: ");
		for(int i = 0; i<datos.length; i++)
			System.out.printf(" %s", datos[i]);
		System.out.println();
	}
	
	//Modificadores
	public void set(int i, Object x){
		datos[i] = x;
	}
	
	public void add(Object x) { // añade al final
		Object [] temp = new Object[datos.length + 1];
		for (int i = 0; i<datos.length; i++)
			temp[i] = datos[i];
		temp[temp.length-1] = x;
		datos = temp;
	}
	
	public void insert(int i, Object x){ // inserta en i y desplaza los sgtes. a la dcha
		Object [] temp = new Object[datos.length + 1];
		for (int j = 0; j<i; j++)
			temp[j] = datos[j];
		temp[i] = x;
		for (int j = i+1; j<temp.length; j++)
			temp[j] = datos[j-1];
		datos = temp;
	}
	
	public void remove(int i) { // elimina el int de la posicion i y desplaza los sgtes. a la izda.
		Object [] temp = new Object[datos.length - 1];
		for (int j = 0; j<i; j++)
			temp[j] = datos[j];
		for (int j = i; j<temp.length; j++)
			temp[j] = datos[j+1];
		datos = temp;
	}
	
	// Otros metodos
	public Object [] vectorNormal(){ // devuelve un Object [] con los enteros de vDE
		Object [] temp = new Object[this.length()];
		for (int i = 0; i<temp.length; i++)
			temp[i] = this.get(i);
		return temp;
	}


}


