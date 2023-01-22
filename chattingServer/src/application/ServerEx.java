package application;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

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
										+ ": " + Thread.currentThread().getName() + " ]";
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
	
	// Client를 ServerEx의 내부 클래스로 선언
	class Client {
		// Socket 필드를 선언
		Socket socket;
		
		// Client 생성자를 선언
		Client(Socket socket){
			// 매개값으로 받은 Socket을 필드값으로 저장
			this.socket = socket;
			// receive() 메소드를 호출
			receive();
		}
		
		// 데이터를 받기 위해 receive() 메소드를 선언
		void receive() {
			// 받기 작업 생성
			// 클라이언트로부터 데이터를 받는 작업을 Runnable로 정의
			Runnable runnable = new Runnable() {
				// run() 메소드를 재정의
				@Override
				public void run() {
					try {
						while(true) { // 작업을 무한히 반복
							// 받은 데이터를 저장할 byte[] 배열인 byteArr를 생성
							byte[] byteArr = new byte[100];
							// Socket으로부터 InputStream을 얻는다.
							InputStream inputStream = socket.getInputStream();
							
							// 클라이언트가 비정상 종료를 했을 경우 IOException 발생
							// 데이터 받기
							/* InputStream의 read() 메소드를 호출
							 * 클라이언트가 데이터를 보내기 전까지 블로킹된다.
							 * 데이터를 받으면 byteArr에 저장한 후 
							 * 받은 바이트 개수를 readByteCount에 저장
							 */
							int readByteCount = inputStream.read(byteArr);
							
							/* 클라이언트가 정상적으로 Socket의 close()를 호출했을 경우
							 * 위의 read() 메소드는 -1을 리턴
							 * 이 경우 IOException을 강제로 발생시킨다.
							 */
							if(readByteCount == -1) { throw new IOException(); }
							
							/* 정상적으로 데이터를 받았을 경우
							 * "[ 요청 처리 : 클라이언트 IP : 작업스레드이름]"으로 구성된 문자열 생성
							 */
							String message = "[ 요청 처리 : " + socket.getRemoteSocketAddress()
											+ " : " + Thread.currentThread().getName() + " ]";
							
							// 문자열을 출력하도록 displayText()를 호출
							Platform.runLater(() -> displayText(message));
							
							// 문자열로 변환
							/* String(byteArr, 0, readByteCount, "UTF-8")을 이용해서
							 * UTF-8로 디코딩한 문자열을 얻는다.
							 */
							String data = new String(byteArr, 0, readByteCount, "UTF-8");
							
							// 모든 클라이언트에게 보냄
							/* 문자열을 모든 클라이언트에게 보내기 위해 connections에 저장된
							 * Client를 하나씩 얻어 send() 메소드를 호출
							 */
							for(Client client : connections) {
								client.send(data);
							}
						}
					} catch(Exception e) {
						try {
							/* 예외가 발생하면 connections 컬렉션에서 Client 객체를 제거
							 * 예외가 발생할 때는 모두 클라이언트와 통신이 되지 않을 때이다.
							 */
							connections.remove(Client.this);
							
							/* "[ 클라이언트 통신 안됨 : 클라이언트IP : 작업스레드이름 ]"으로
							 * 구성된 문자열을 생성
							 */
							String message = "[ 클라이언트 통신 안됨 : " 
											+  socket.getRemoteSocketAddress() 
											+ ": " + Thread.currentThread().getName() 
											+ " ]";
							// 문자열을 출력하도록 displayText()를 호출
							Platform.runLater(() -> displayText(message));
							// Socket을 닫는다.
							socket.close();
						} catch(IOException e2) {}
					}
				}
			};
			// 스레드풀에서 처리
			// 스레드풀에서 작업을 처리하기 위해 submit()을 호출
			executorService.submit(runnable);
		}
		
		// 데이터를 보내기 위해 send() 메소들르 선언
		void send(String data) {
			// 보내기 작업 생성
			// 데이터를 클라이언트로 보내는 작업을 Runnable로 생성
			Runnable runnable = new Runnable() {
				// run()을 재정의
				@Override
				public void run() {
					try {
						// 클라이언트로 데이터 보내기
						// 보낼 문자열로부터 UTF-8로 인코딩한 바이트 배열을 얻는다.
						byte[] byteArr = data.getBytes("UTF-8");
						// Socket에서 출력스트림을 얻는다.
						OutputStream outputStream = socket.getOutputStream();
						// 바이트 배열을 매개값으로 해서 write() 메소드를 호출
						outputStream.write(byteArr);
						// 출력 스트림의 내부 버퍼를 완전히 비우도록 flush()를 호출
						outputStream.flush();
					} catch(Exception e) {
						try {
							/* 예외가 발생하면 "[ 클라이언트 통신 안됨 : 클라이언트IP : 작업스레드이름 ]"으로
							 * 구성된 문자열을 생성
							 */
							String message = "[ 클라이언트 통신 안됨 : " 
									+ socket.getRemoteSocketAddress() + " : "
									+ Thread.currentThread().getName() + " ]";
							// 문자열을 출력하도록 displayText()를 호출
							Platform.runLater(() -> displayText(message));
							
							// connections 컬렉션에서 예외가 발생한 Client를 제거
							connections.remove(Client.this);
							
							// socket을 닫는다.
							socket.close();
						} catch(Exception e2) {}
					}
				}
			};
			// 스레드풀에서 처리
			// 스레드풀에서 작업을 처리하기 위해 submit()을 호출
			executorService.submit(runnable);
		}
	}
	
	//////////////////////////////////
	TextArea txtDisplay;
	Button btnStartStop;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		root.setPrefSize(500, 300);
		
		txtDisplay = new TextArea();
		txtDisplay.setEditable(false);
		BorderPane.setMargin(txtDisplay, new Insets(0, 0, 2, 0));
		root.setCenter(txtDisplay);
		
		btnStartStop = new Button("start");
		btnStartStop.setPrefHeight(30);
		btnStartStop.setMaxWidth(Double.MAX_VALUE);
		
		/* start와 stop 버튼을 클랙했을 때
		 * 이벤트 처리 코드
		 */
		btnStartStop.setOnAction(e -> {
			if(btnStartStop.getText().equals("start")) {
				startServer();
			} else if(btnStartStop.getText().equals("stop")) {
				stopServer();
			}
		});
		root.setBottom(btnStartStop);
		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("app.css").toString());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Server");
		
		/* 윈도우 우측 상단 닫기 버튼을 
		 * 클릭했을 때 이벤트 처리 코드
		 */
		primaryStage.setOnCloseRequest(event -> stopServer());
		primaryStage.show();
	}
	
	/* 작업 스레드의 작업 처리 내용을 출력할 때 호출하는 메소드
	 */
	void displayText(String text) {
		txtDisplay.appendText(text + "\n");
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
