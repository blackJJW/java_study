package application;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
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
		try {
			// 모든 Socket 닫기
			// connections 컬렉션으로부터 반복자를 얻음
			Iterator<Client> iterator = connections.iterator();
			
			// while문으로 반복자를 반복
			while(iterator.hasNext()) {
				// 반복자로부터 Client를 하나씩 얻는다.
				Client client = iterator.next();
				// Client가 가지고 있는 Socket을 닫는다.
				client.socket.close();
				// connections 컬렉션에서 Client를 제거
				iterator.remove();
			}
			
			// ServerSocket 닫기
			// ServerSocket이 null이 아니고, 닫혀있지 않으면
			if(serverSocket != null && !serverSocket.isClosed()) {
				// ServerSocket 닫음
				serverSocket.close();
			}
			
			// ExecutorService 종료
			// ExecutorService가 null이 아니고, 종료 상태가 아니면
			if(executorService != null && !executorService.isShutdown()) {
				// ExecutorService 종료
				executorService.shutdown();
			}
			// 작업 스레드는 UI를 변경하지 못하므로 Platfrom.runLater()가 사용됨
			Platform.runLater(() -> {
				// "[ 서버 멈춤 ]"을 출력하도록 displayText()를 호출
				displayText("[ 서버 멈춤 ]");
				// [stop] 버튼의 글자를 [start]로 변경
				btnStartStop.setText("start");
			});
		} catch (Exception e) {}
	}
	
	class Client {
		// 데이터 통신 코드
	}
	
	//////////////////////////////////
	// UI 생성 코드
}
