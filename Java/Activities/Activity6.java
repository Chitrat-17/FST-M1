package activities;

public class Activity6 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Plane plane = new Plane(10);
		plane.onboard("Mary");
		plane.onboard("Joseph");
		plane.takeOff();
		System.out.println(plane.getPassesngers());
		Thread.sleep(5000);
		plane.land();
		plane.getLastTimeLanded();

	}

}
