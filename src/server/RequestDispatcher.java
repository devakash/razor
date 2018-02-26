package server;

import services.CommonServers;

public class RequestDispatcher {

	int count = 0;
	boolean isSent = false;

	public String sendEmail(String to, String messageBody, int n,int probability[]) {

		for (int i = 0; i < n; i++) {
			++count;
			isSent = new CommonServers().sendEmail(to, messageBody,probability[i]);
			if (isSent) {
				return returnMessage(isSent, count, "Server" + (i+1));
			}

		}
		return returnMessage(isSent, count, "not sent");
	}

	public String returnMessage(boolean isSent, int count, String name) {
		return "{\"mail sent\":\"" + isSent + "\",\"count\":" + count + ",\"server\"" + name + "}";
	}
}
