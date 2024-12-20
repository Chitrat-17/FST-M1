package activities;

public class CustomExceptionActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		CustomExceptionActivity.exceptionTest("Will print to console");
		CustomExceptionActivity.exceptionTest(null);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}
		static public void exceptionTest(String message) throws CustomException{
			if(message == null) {
				throw new CustomException("string value is null");
			}
			else {
				System.out.println(message);
			}
			
		}

}
