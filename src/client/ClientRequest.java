package client;

import java.util.*;

import server.RequestDispatcher;

public class ClientRequest {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		String toEmails = scn.next();
		String messageBody = scn.next();
		for (int i = 0; i < 10; i++) {
			RequestDispatcher rd = new RequestDispatcher();
			int arr[] = { 0, 50, 75, 0 };
			String sendEmail = rd.sendEmail(toEmails, messageBody, 4, arr);
			System.out.println(sendEmail);

		}
		scn.close();
	}

}
