/* 
 * Clase Bicycle, implementa el interface Driveable
 *
 **/

class Bicycle implements Driveable {

       int cadence = 0;
       int speed = 0;
       int gear = 1;
       int direction = 0; // 0 - 359

       public void setCadence(int newValue) {
            cadence = newValue;
       }
       
       public int getCadence() {
           return cadence;
       }

       public void setGear(int newValue) {
            gear = newValue;
       }
       
       public int getGear() {
           return gear;
       }
       
       public void setSpeed(int newValue) {
           speed = newValue;
       }
      
       public int getSpeed() {
           return speed;
       }
       
       public void setDirection(int newValue) {
           direction = newValue;
       }
      
       public int getDirection() {
           return direction;
       }
       
       // implementacion de la interface Driveable

       public void speedUp(int increment) {
            speed = speed + increment;   
       }

       public void slowDown(int decrement) {
            speed = speed - decrement;
       }
       
       public void turnLeft(int amount) {
    	   direction = (direction + amount) % 360;
       }
       
       public void turnRight(int amount) {
    	   direction = (360 + direction - amount) % 360;
       }

       void printStates() {
    	    System.out.println(" -- Bicycle -- ");
            System.out.println("cadence:"+cadence+" speed:"+speed+" gear:"+gear+" direction:"+direction);
       }
}
