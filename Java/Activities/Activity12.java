package activities;

public class Activity12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Addable add = (a, b) -> (a + b);
        System.out.println(add.add(10, 20));
 
    
        Addable add2 = (int a, int b) -> {
            return (a + b);
        };
        System.out.println(add2.add(100, 200));
	}

}
