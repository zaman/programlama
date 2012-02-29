/**
 * Ejemplo de uso de la clase Bycicle
 * 
 */

class BicycleDemo {
     public static void main(String[] args) {

          // Create two different Bicycle objects
          Bicycle bike1 = new Bicycle(50,10,2);
          Bicycle bike2 = new Bicycle();
          Bicycle bike3 = new Bicycle();

          // Invoke methods on those objects

          bike1.printStates();

          bike2.setCadence(50);
          bike2.speedUp(10);
          bike2.setGear(2);
          bike2.setCadence(40);
          bike2.speedUp(10);
          bike2.setGear(3);
          bike2.printStates();
          
          bike3.printStates();
     }
}

