package application;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Application;
import javafx.application.Platform;

public class ServerEx extends Application {
	ExecutorService executorService;
	ServerSocket serverSocket;
	List<Client> connections = new Vector<Client>();
	
	void startServer() { 
		executorService = Executors.newFixedThreadPool(
			Runtime.getRuntime().availableProcessors()
		);
		
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("localhost", 5001));
		} catch(Exception e) {
			if(!serverSocket.isClosed()) { stopServer(); }
			return;
		}
		
		Runnable runnable = new Runnable() { // 수락 작업 생성
			@Override
			public void run() {
				Platform.runLater(() -> {
					displayText("[ 서버 시작 ]");
					btnStartStop.setText("stop");
				});
				while(true) {
					try {
						Socket socket = serverSocket.accept(); // 연결 수락
						String message = "[ 연결 수락 : " 
										+ socket.getRemoteSocketAddress() 
										+ ": " + Thread.currnetThread().getName() + " ]";
						Platform.runLater(() -> displayText(message));
						
						// Client 객체 저장
						Client client = new Client(socket);
						connections.add(client);

						Platform.runLater(() -> displayText("[ 연결 개수 : "
														+ connections.size() + "]"));
					} catch (Exception e) {
						if(!serverSocket.isClosed()) { stopServer(); }
						break;
					}
				}
			}
		};
		executorService.submit(runnable); // 스레드풀에서 처리
	} // startServer() 메소드 끝 
	
	void stopServer() {
		// 서버 종료 코드
	}
	
	class Client {
		// 데이터 통신 코드
	}
	
	//////////////////////////////////
	// UI 생성 코드
}
