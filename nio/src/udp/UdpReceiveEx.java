package udp;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.StandardProtocolFamily;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.Charset;

public class UdpReceiveEx extends Thread{

	public static void main(String[] args) throws Exception{
		DatagramChannel datagramChannel
			= DatagramChannel.open(StandardProtocolFamily.INET);
		datagramChannel.bind(new InetSocketAddress(5001));
		
		// 스레드 생성
		Thread thread = new Thread() {
			@Override
			public void run() {
				System.out.println("[ 수신 시작 ]");
				try {
					while(true) {
						ByteBuffer byteBuffer = ByteBuffer.allocate(100);
						// 데이터 받기
						SocketAddress socketAddress = datagramChannel.receive(byteBuffer);
						byteBuffer.flip();
						
						Charset charset = Charset.forName("UTF-8");
						String data = charset.decode(byteBuffer).toString();
						System.out.println("[ 받은 내용 : " + socketAddress.toString() + " ] " + data);
					}
				} catch (Exception e) {
					System.out.println("[ 수신 종료 ]");
				}
			}
		};
		thread.start();
		
		Thread.sleep(10000);
		datagramChannel.close();
	}
}
