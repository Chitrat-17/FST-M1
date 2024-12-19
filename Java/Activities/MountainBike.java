package activities;

public class MountainBike extends Bicycle{
	public int seatHeight;
	MountainBike(int gears, int speed, int seatHeight){
		super(gears, speed);
		this.seatHeight =seatHeight; 
	}
	public void setHeight(int newValue) {
	    seatHeight = newValue;
	}

	public String bicycleDesc() {
		return (super.bicycleDesc()+"Height of the seat is :"+seatHeight);
	}
	
	
}
