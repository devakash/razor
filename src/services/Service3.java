package services;

import java.util.Random;

public class Service3 {

	public boolean sendEmail(String to, String messageBody) {
		Random r = new Random();
		int nextInt = r.nextInt(100);
		nextInt = nextInt + 1;

		return nextInt > 30 ? true : false;
	}

}
