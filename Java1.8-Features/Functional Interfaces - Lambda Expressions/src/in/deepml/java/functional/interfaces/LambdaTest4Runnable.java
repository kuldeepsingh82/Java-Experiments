package in.deepml.java.functional.interfaces;

public class LambdaTest4Runnable {

	public static void main(String[] args) {

		// UseCase: Run a thread with Runnable to print a statement 10 times

		/*** Without Lambda Expression : Start ***/
		// 1. Create a Runnable class (OR Anonymous Inner class) implementing Runnable interface
		Runnable ra = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("Runnable interface implementation with Inner Class");	
				}
			}
		};
		Thread newThread =  new Thread(ra);
		newThread.start();
		
		/*** Without Lambda Expression : End ***/

		/*** With Lambda Expression : Start ***/
		Runnable raLambda = () -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("Runnable interface implementation with Lambda");	
			}
		};
		
		Thread lambdaThread =  new Thread(raLambda);
		lambdaThread.start();

		/*** With Lambda Expression : End ***/
	}
}
