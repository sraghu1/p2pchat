package p2pchat;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class test {
public static void main(String args[])
{
	try {
		System.out.println(InetAddress.getByName("localhost"));
		ServerSocket ss=new ServerSocket(8085, 0, InetAddress.getByName("localhost"));
		Socket s=new Socket(InetAddress.getByName("localhost"),8085);
		byte b=0;
		s.getOutputStream().write(b);
		System.out.println(s.getInputStream().read());
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
