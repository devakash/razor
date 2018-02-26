package unittest;

import org.testng.Assert;
import org.testng.annotations.Test;

import server.RequestDispatcher;

public class RequestDispatcherTest {

	@Test
	public void testWithZeroServer() {
		RequestDispatcher t = new RequestDispatcher();
		int arr[] = {};
		String sendEmail = t.sendEmail("", "", 0, arr);
		Assert.assertTrue(sendEmail.contains("false"));

	}

	@Test
	public void testWithZeroProbability() {
		RequestDispatcher t = new RequestDispatcher();
		int arr[] = { 0 };
		String sendEmail = t.sendEmail("", "", 1, arr);
		Assert.assertTrue(!sendEmail.contains("true"));

	}

	@Test
	public void testWithFirstSuccescProbabilityFirstServer() {
		RequestDispatcher t = new RequestDispatcher();
		int arr[] = { 100, 99, 99, 99 };
		String sendEmail = t.sendEmail("", "", 4, arr);
		Assert.assertTrue(sendEmail.contains("Server1"));

	}

	@Test
	public void testWithNegativePrioirty() {
		RequestDispatcher t = new RequestDispatcher();
		int arr[] = { -100, -95, -90, -99 };
		String sendEmail = t.sendEmail("", "", 4, arr);
		Assert.assertTrue(sendEmail.contains("false"));

	}

	@Test
	public void testWithAllPositiveButOneZero() {
		RequestDispatcher t = new RequestDispatcher();
		int arr[] = { 80, 65, 0, 99 };
		String sendEmail = t.sendEmail("", "", 4, arr);
		Assert.assertTrue(!sendEmail.contains("Server3"));

	}

	@Test
	public void testWithAllPositivebutSecondHighest() {

		for (int i = 0; i < 10; i++) {
			RequestDispatcher t = new RequestDispatcher();
			int arr[] = { 90, 100, 55, 45 };
			String sendEmail = t.sendEmail("", "", 4, arr);
			if (sendEmail.contains("Server3") || sendEmail.contains("Server4")) {
				Assert.fail();
			}
		}

	}

	@Test
	public void testWithAllPositive() {
		int out[] = new int[4];
		for (int i = 0; i < 10; i++) {
			RequestDispatcher t = new RequestDispatcher();
			int arr[] = { 90, 15, 10, 1 };
			String sendEmail = t.sendEmail("", "", 4, arr);
			if (sendEmail.contains("Server1")) {
				out[0] = out[0] + 1;
			} else if (sendEmail.contains("Server2")) {
				out[1] = out[1] + 1;
			} else if (sendEmail.contains("Server3")) {
				out[2] = out[2] + 1;
			} else if (sendEmail.contains("Server4")) {
				out[3] = out[3] + 1;
			}
		}

		int first = out[0];
		for (int k : out) {
			if (k > first) {
				Assert.fail();
			}
		}

	}

	@Test
	public void testWithAscendingO() {

		for (int i = 0; i < 10; i++) {
			RequestDispatcher t = new RequestDispatcher();
			int arr[] = { 25, 50, 75, 100 };
			String sendEmail = t.sendEmail("", "", 4, arr);
			if (sendEmail.contains("false") || sendEmail.contains("false")) {
				Assert.fail();
			}
		}

	}

}
