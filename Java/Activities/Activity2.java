package activities;

public class Activity2 {
	public static void main(String[] args) {
		int[] array1 = {10,77, 10, 54, -11, 10,10 };
		System.out.println(method1(array1));
		
	}

	public static boolean method1(int[] array1) {
		int arrayLength = array1.length; 
		System.out.println(array1.length);
		int sum =0 ;
		for(int i = 0; i<arrayLength;i++) {
			if(array1[i] == 10) {
				sum +=array1[i];
			}
			if(sum > 30) {
				break;
			}
		}
		return sum == 30;
	}

}
