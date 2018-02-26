package services;

import java.util.Random;

public class CommonServers {

	public boolean sendEmail(String to, String messageBody, int probability) {
		Random r = new Random();
		int nextInt = r.nextInt(100);
		nextInt = nextInt + 1;
		probability = 100 - probability;
		return nextInt > probability ? true : false;
	}

}
