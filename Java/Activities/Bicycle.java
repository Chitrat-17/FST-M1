package activities;

public class Bicycle implements BicycleParts, BicycleOperations{
	public int gears;
    public int speed;
    
	Bicycle(int gears, int speed){
		this.gears = gears;
		this.speed = speed;
	}
	public void applyBrake(int decrement) {
		speed = speed - decrement;
	}
	
	public void speedUp(int increment) {
		speed = speed + increment;
	}
	
	public String bicycleDesc() {
	    return("No of gears are "+ gears + "\nSpeed of bicycle is " + speed);
	}
}
