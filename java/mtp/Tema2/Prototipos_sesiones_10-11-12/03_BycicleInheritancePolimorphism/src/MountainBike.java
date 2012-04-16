/**
 * Clase MountainBike, hereda de Bycicle
 * y sobreescribe el metodo printState
 * 
 */

public class MountainBike extends Bicycle{
	
  private String suspension;

  public MountainBike(int startCadence, int startSpeed, int startGear, String suspensionType){
    super(startCadence, startSpeed, startGear);
    this.setSuspension(suspensionType);
  }

  public String getSuspension(){
    return this.suspension;
  }

  public void setSuspension(String suspensionType){
    this.suspension = suspensionType;
  }

  public void printStates(){
	System.out.println(" -- MountainBike -- ");  
    super.printStates();
    System.out.println("The MountainBike has a " + getSuspension()
            + " suspension.");
  }
} 





