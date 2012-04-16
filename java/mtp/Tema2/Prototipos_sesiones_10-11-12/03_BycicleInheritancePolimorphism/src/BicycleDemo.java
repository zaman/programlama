/**
 * Ejemplo simple de uso de polimorfinsmo y de downcasting
 * 
 */

class BicycleDemo {
	public static void main(String[] args){
	    Bicycle bike01, bike02, bike03;
	    
	    bike01 = new Bicycle(20, 10, 1);
		bike02 = new MountainBike(20, 10, 5, "Dual");
		bike03 = new RoadBike(40, 20, 8, 23);
        
		// JVM call the appropriate method for the referenced object
		// and not the method for the variable type
		//bike01.printStates();
		//bike02.printStates();
		//bike03.printStates();
		
		Bicycle [] vectBikes = {bike01, bike02, bike03};
		
		for (int i = 0; i < vectBikes.length; i++){
			System.out.format("%nBycicle [%d]:%n",i);
			vectBikes[i].printStates();
		}
		
		// Para llamar a los metodos especificos de cada clase
		// hay que hacer un downcast
		
		//MountainBike m2 = (MountainBike) bike02;
		//m2.setSuspension("Mono");
		((MountainBike)bike02).setSuspension("Mono");
		
		for (int i = 0; i < vectBikes.length; i++){
			System.out.format("%nBycicle [%d]:%n",i);
			vectBikes[i].printStates();
		}
	}
}



