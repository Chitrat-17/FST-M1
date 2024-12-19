package activities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Plane {
	private List<String> passengers;
	private int maxPassengers;
	private Date lastTimeTookOf;
	private Date lastTimeLanded;
	
	Plane(int maxPassengers){
		this.maxPassengers = maxPassengers;
        this.passengers = new ArrayList<>();
	}
	
	
	
	public void onboard(String passName){
		passengers.add(passName);
		
	}
	public Date takeOff() {
		lastTimeTookOf = new Date();
		return lastTimeTookOf;
		
	}
	public void land() {
		lastTimeLanded = takeOff();
		passengers.clear();
	}

	public Date getLastTimeLanded() {
		return lastTimeLanded;
	}
	
	public List<String> getPassesngers() {
		return passengers;
	}
}
