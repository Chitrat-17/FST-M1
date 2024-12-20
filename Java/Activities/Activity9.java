package activities;

import java.util.ArrayList;

public class Activity9 {
	public static void main(String[] args) {
		ArrayList<String> myList = new ArrayList<String>();
		myList.add("Mary");
		myList.add("Tom");
		myList.add("harry");
		myList.add("Mike");
		myList.add("Jack");
		
		for (String name : myList) {
			System.out.println(name);
		}
		System.out.println("3rd element is : "+myList.get(2));
		
		if(myList.contains("Mike")) {
			System.out.println("name exists");
		}
		
		System.out.println("Number of names :"+myList.size());
		myList.remove("Jack");
		System.out.println("Number of names :"+myList.size());
	}
	


}
