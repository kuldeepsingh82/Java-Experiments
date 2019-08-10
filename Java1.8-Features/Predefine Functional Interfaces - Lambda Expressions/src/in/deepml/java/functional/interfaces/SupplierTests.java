package in.deepml.java.functional.interfaces;

import java.util.Date;
import java.util.Random;
import java.util.function.Supplier;

public class SupplierTests {

	public static void main(String[] args) {

		// Supplier is a functional Interface with 'get' abstract method
		// It DOES NOT accept any object as input and return some object

		// Current datetime generator
		Supplier<Date> getCurrentDate = () -> new Date();
		System.out.println(String.format("Current system date is {%s}", getCurrentDate.get()));

		// OTP generator
		Supplier<String> otpGenerator = () -> {
			double otpNumber = Math.random() * 1000000.00;
			String otpString = ""+otpNumber;
			return otpString.substring(0, otpString.indexOf("."));
		};
		System.out.println(String.format("Generate OTP is {%s}", otpGenerator.get()));

		// Password generator
		Supplier<String> passwordGenerator = () -> {
			String salChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*";
			StringBuilder salt = new StringBuilder();
			Random rnd = new Random();
			while (salt.length() < 18) { // length of the random string.
				int index = (int) (rnd.nextFloat() * salChars.length());
				salt.append(salChars.charAt(index));
			}
			String saltStr = salt.toString();
			return saltStr;
		};
		System.out.println(String.format("Generate Password is {%s}", passwordGenerator.get()));

	}
}
