package activities;

public class Activity4 {
	public static void main(String[] args) {
		int[] array1 = {10, 3, 6, 4, 8, 2, 12, 11};
		int[] sortedArray; 
		for (int i = 0; i<array1.length; i++) {
			for (int j=i+1; j<array1.length; j++) {
//				System.out.println(array1[i] +" " +array1[j]);
				if(array1[i] > array1[j]) {
					int temp = array1[i];
					array1[i] = array1[j];
					array1[j] = temp;
//					System.out.println("swapped");
				}
			}
			
		}
		for (int a : array1) {
			System.out.println("Sorted Array : "+ a);
		}
		
	}

}
