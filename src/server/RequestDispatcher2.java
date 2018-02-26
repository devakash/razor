package server;

import services.Service1;
import services.Service2;
import services.Service3;

public class RequestDispatcher2 {
	
	int count=0;
	boolean isSent=false;
	public String sendEmail(String to, String messageBody) {
		
		++count;
		isSent=new Service1().sendEmail(to,messageBody);
		
		if(isSent)
		{
			return returnMessage(isSent, count,"server1");
		}
		else
		{
			++count;
			isSent=new Service2().sendEmail(to,messageBody);
			if(isSent)
			{
				return returnMessage(isSent, count,"server2");
			}
			else
			{
				++count;
				isSent=new Service3().sendEmail(to,messageBody);
				if(isSent)
				{
					return returnMessage(isSent, count,"server3");
				}
			}
		}
		return returnMessage(isSent, count,"not sent, so no server");
		
	}

	public String returnMessage(boolean isSent,  int count, String name)
	{
		return "{\"mail sent\":\""+isSent+"\",\"count\":"+count+",\"server\""+name+"}";
	}
}
