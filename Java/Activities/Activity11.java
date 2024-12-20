package activities;

import java.util.HashMap;

public class Activity11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<Integer, String> colours = new HashMap<Integer, String>();
		colours.put(1, "Black");
		colours.put(2, "Blue");
		colours.put(3, "White");
		colours.put(4, "purple");
		colours.put(5, "Lavendar");
		
		colours.remove("Lavendar");
		System.out.println("check if colour green exists?"+colours.containsValue("green"));
		System.out.println("size of map is : "+colours.size());
	}

}
