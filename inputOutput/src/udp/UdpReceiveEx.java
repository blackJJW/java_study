package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpReceiveEx extends Thread {

	public static void main(String[] args) throws Exception {
		// 5001번 포트에서 수신하는 DatagramSocket 생성
		DatagramSocket datagramSocket = new DatagramSocket(5001);
		
		Thread thread = new Thread() {
			@Override
			public void run() {
				System.out.println("[ 수신 시작 ]");
				try {
					while(true) {
						// DatagramPacket 수신
						DatagramPacket packet 
							= new DatagramPacket(new byte[100], 100);
						datagramSocket.receive(packet);
						
						String data 
							= new String(packet.getData(), 0, 
									packet.getLength(), "UTF-8");
						System.out.println("[ 받은 내용 : "
								+ packet.getSocketAddress() + " ] "
								+ data);
					}
				} catch(Exception e) {
					System.out.println("[ 수신 종료 ]");
				}
			}
		};
		thread.start();
		
		Thread.sleep(10000);
		datagramSocket.close();
	}
}
