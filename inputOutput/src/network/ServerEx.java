package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerEx {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			// ServerSocket 생성
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("localhost", 5001));
			
			while(true) {
				System.out.println("[ 연결 기다림 ]");
				
				// 클라이언트 연결 수락
				Socket socket = serverSocket.accept();
				
				InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
				System.out.println("[ 연결 수락함 ]" + isa.getHostName());
				
				byte[] bytes = null;
				String message = null;
				
				// 2.-------------------------------------------------------
				InputStream is = socket.getInputStream();
				bytes = new byte[100];
				int readByteCount = is.read(bytes);
				message = new String(bytes, 0, readByteCount, "UTF-8");
				System.out.println(" [데이터 받기 성공]" + message);
				//--------------------------------------------------
				
				// 3.-----------------------------------------------
				OutputStream os = socket.getOutputStream();
				message = "Hello Client";
				bytes = message.getBytes("UTF-8");
				os.write(bytes);
				os.flush();
				System.out.println(" [ 데이터 보내기 성공 ] ");
				
				is.close();
				os.close();
				socket.close();
			}
		} catch(Exception e) {}
		
		// ServerSocket이 닫혀있지 않을 경우
		if(!serverSocket.isClosed()) {
			try {
				// ServerSocket 닫기
				serverSocket.close();
			} catch (IOException e1) {}
		}
	}
}
