package in.deepml.java.functional.interfaces;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class LambdaTest4Callable {

	public static void main(String[] args) {

		// UseCase: Run a thread with Runnable to print a statement 10 times

		/*** Without Lambda Expression : Start ***/
		// 1. Create a Runnable class (OR Anonymous Inner class) implementing Runnable
		// interface
		FutureTask[] futureOutput = new FutureTask[2];
		Callable<String> ca = new Callable() {
			@Override
			public Object call() throws Exception {
				return "Callable interface implementation without Lambda";
			}

		};
		futureOutput[0] = new FutureTask(ca);
		Thread newThread = new Thread(futureOutput[0]);
		newThread.start();

		/*** Without Lambda Expression : End ***/

		/*** With Lambda Expression : Start ***/
		Callable<String> caLambda = () -> "Callable interface implementation with Lambda";
		;
		futureOutput[1] = new FutureTask(caLambda);
		Thread lambdaThread = new Thread(futureOutput[1]);
		lambdaThread.start();

		/*** With Lambda Expression : End ***/

		// Printout the result
		for (int i = 0; i < 2; i++) {
			// As it implements Future, we can call get()
			try {
				System.out.println(futureOutput[i].get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	}
}
