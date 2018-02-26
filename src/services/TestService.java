package services;

public class TestService {

	int count = 0;
	boolean isSent = false;

	public String sendEmail(String to, String messageBody) {

		++count;
		
		isSent = new CommonServers().sendEmail(to, messageBody, 100);

		return returnMessage(isSent, count, 0);
	}

	public String returnMessage(boolean isSent, int count, int name) {
		return "{\"mail sent\":\"" + isSent + "\",\"count\":" + count + ",\"server\":\"" + name + "}";
	}

}
