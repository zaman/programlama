/**
 * Clase RoadBike, hereda de Bycicle
 * y sobreescribe el metodo printState
 * 
 */

public class RoadBike extends Bicycle{
	
  private int tireWidth; // In millimeters (mm)

  public RoadBike(int startCadence, int startSpeed, int startGear, int newTireWidth){
    super(startCadence, startSpeed, startGear);
    this.setTireWidth(newTireWidth);
  }

  public int getTireWidth(){
    return this.tireWidth;
  }

  public void setTireWidth(int newTireWidth){
    this.tireWidth = newTireWidth;
  }

  public void printStates(){
	System.out.println(" -- RoadBike -- ");  
    super.printStates();
    System.out.println("The RoadBike has " + getTireWidth()
            + " MM tires.");
  }

}

