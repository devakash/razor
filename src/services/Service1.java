package services;

import java.util.Random;

public class Service1 {

	public boolean sendEmail(String to, String messageBody) {

		Random r = new Random();
		int nextInt = r.nextInt(100);
		nextInt = nextInt + 1;

		return nextInt > 90 ? true : false;

	}

}
