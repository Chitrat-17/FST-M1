package activities;

public class Activity3 {
	public static void main(String[] args) {
		double seconds = 1000000000;
		
		double EarthSeconds = 31557600;
		double MercurySeconds = 0.2408467;
		double VenusSeconds = 0.61519726;
		double MarsSeconds = 1.8808158;
		double JupiterSeconds = 11.862615;
		double SaturnSeconds = 29.447498;
		double UranusSeconds = 84.016846;
		double NeptuneSeconds = 164.79132;
	
		System.out.println("They are "+seconds/EarthSeconds +"Earth-years old");
		System.out.println("They are "+seconds/EarthSeconds/MercurySeconds +"Mercury-years old");
		System.out.println("They are "+seconds/EarthSeconds/VenusSeconds +"Venus-years old");
		System.out.println("They are "+seconds/EarthSeconds/MarsSeconds +"Mars-years old");
		System.out.println("They are "+seconds/EarthSeconds/JupiterSeconds +"Jupiter-years old");
		System.out.println("They are "+seconds/EarthSeconds/SaturnSeconds +"Saturn-years old");
		System.out.println("They are "+seconds/EarthSeconds/UranusSeconds +"Uranus-years old");
		System.out.println("They are "+seconds/EarthSeconds/NeptuneSeconds +"Neptune-years old");
		
		
		
	}

}
