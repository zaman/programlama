/**
 * Prácticas de Metodología de la Programación.
 * Clase VectorDinamicoXYLocation - Clase que permite representar vectores dinámicos de XYLocation 
 * @author Jorge Puente Peinador y Ramiro Varela Arias
 *
 */
public class VectorDinamicoXYLocation extends VectorDinamicoObjects{

	public VectorDinamicoXYLocation(){
		
	}
	
	public VectorDinamicoXYLocation(VectorDinamicoXYLocation vDE){
		super(vDE);
	}
	
	public VectorDinamicoXYLocation(int size){
		super(size);
	}
	
	public VectorDinamicoXYLocation(Integer [] v){
		super((Object[])v);
	}
	
	@Override	
	public XYLocation get(int i){
		return (XYLocation)super.get(i);
	}
	
	
	// Otros metodos
	@Override
	public XYLocation [] vectorNormal(){ // devuelve un XYLocation [] con los enteros de vDE
		XYLocation [] temp = new XYLocation[this.length()];
		for (int i = 0; i<temp.length; i++)
			temp[i] = this.get(i);
		return temp;
	}


}




