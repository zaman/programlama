/**
 * Prácticas de Metodología de la Programación.
 * Clase VectorDinamicoPersonajes - Clase que permite representar vectores dinámicos de Personajes 
 * @author Jorge Puente Peinador y Ramiro Varela Arias
 *
 */

public class VectorDinamicoPersonajes extends VectorDinamicoObjects{

	public VectorDinamicoPersonajes(){
		
	}
	
	public VectorDinamicoPersonajes(VectorDinamicoPersonajes vDE){
		super(vDE);
	}
	
	public VectorDinamicoPersonajes(int size){
		super(size);
	}
	
	public VectorDinamicoPersonajes(Personaje [] v){
		super((Object[])v);
	}
	
	@Override	
	public Personaje get(int i){
		return (Personaje)super.get(i);
	}
	
	
	// Otros metodos
	@Override
	public Personaje [] vectorNormal(){ // devuelve un Personaje [] con los enteros de vDE
		Personaje [] temp = new Personaje[this.length()];
		for (int i = 0; i<temp.length; i++)
			temp[i] = this.get(i);
		return temp;
	}


}




