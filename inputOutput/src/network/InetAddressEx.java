package network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressEx {

	public static void main(String[] args) {
		try {
			InetAddress local = InetAddress.getLocalHost();
			System.out.println("my pc IP addr : " + local.getHostAddress());
			
			InetAddress[] iaArr = InetAddress.getAllByName("www.naver.com");
			for(InetAddress remote : iaArr) {
				System.out.println("www.naver.com IP addr : " + remote.getHostAddress());
			}
		} catch(UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
