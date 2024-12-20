package activities;

import java.util.HashSet;

public class Activity10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashSet<String> hs = new HashSet<String>();
		hs.add("apple");
		hs.add("lemon");
		hs.add("papaya");
		hs.add("mango");
		hs.add("amla");
		hs.add("pineapple");
		
		System.out.println("Size of hashset is :"+hs.size());
		hs.remove("amla");
		hs.remove("banana");
		System.out.println("check if pineapple is present?"+hs.contains("pineapple"));
		System.out.println(hs);
	}

}
