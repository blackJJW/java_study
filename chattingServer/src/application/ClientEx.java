package application;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

// JavaFX 메인 클래스로 만들기 위해 Application을 상속
public class ClientEx extends Application {
	// 클라이언트 통신을 위해 Socket 필드를 선언 
	Socket socket;
	
	// startClient() 메소드는 [start] 버튼을 클릭하면 호출
	void startClient() {
		/* 작업 스레드를 생성
		 * 작업 스레드가 필요한 이유는 밑에 있는 connect()와 receive()에서
		 * 블로킹이 일어나기 때문
		 * JavaFX Application Thread는 이 메소드들을 호출하지 않는 것이 좋다.
		 */
		Thread thread = new Thread() { // 스레드 생성
			// run() 메소드를 재정의
			@Override
			public void run() {
				try {
					// socket 생성 및 연결 요청
					socket = new Socket(); // 통신용 Socket을 생성
					// localhost 5001 포트로 연결 요청
					socket.connect(new InetSocketAddress("localhost", 5001));
					// 작업 스레드는 UI를 변경하지 못하므로 Platform.runLater()가 사용
					Platform.runLater(() -> {
						// "[ 연결 완료 ]"를 출력하도록 displayText()를 호출
						displayText("[ 연결 완료 : " + socket.getRemoteSocketAddress()
									+ " ]");
						// [start] 버튼의 [stop]으로 변경
						btnConn.setText("stop");
						btnSend.setDisable(false); // send 버튼 활성화
					});
				} catch(Exception e) {
					/* 예외가 발생하면 "[ 서버 통신 암됨 ]"을 출력하도록
					 * displayText()를 호출
					 */
					Platform.runLater(() -> displayText("[ 서버 통신 안됨 ]"));
					
					// Socket이 닫혀있지 않으면 stopClient() 메소드를 호출
					if(!socket.isClosed()) { stopClient(); }
					return; // return을 실행해서 작업을 종료
				}
				// 에외가 발생하지 안흐염 receive() 메소드를 호출
				receive(); // 서버에서 보낸 데이터 받기
			}
		};
		// 작업 스레드를 시작
		thread.start(); // 스레드 시작
	}
	
	// stopClient() 메소드는 [stop] 버튼을 클릭하면 호출
	void stopClient() {
		try {
			// UI를 변경하기 위해 Platform.runLater()가 사용
			Platform.runLater(() -> {
				// "[ 연결 끊음 ]"을 출력하도록 displayText()를 호출
				displayText("[ 연결 끊음 ]");
				// [stop] 버튼의 글자를 [ start ]로 변경
				btnConn.setText("start");
				// [send] 버튼을 비활성화
				btnSend.setDisable(true);
			});
			
			// 연결 끊기
			// socket 필드가 null이 아니고, 현재 닫혀 있지 않을 경우
			if(socket != null && !socket.isClosed()) {
				// Socket을 닫는다.
				socket.close();
			}
		} catch(IOException e) {}
	}
	
	// receive() 메소드는 서버에서 보낸 데이터를 받는다.
	void receive() {
		// 반복적으로 읽기 위해 무한 루프를 작성
		while(true) {
			try {
				// 받은 데이터를 저장한 길이가 100인 바이트 배열 생성
				byte[] byteArr = new byte[100];
				// Socket으로부터 InputStream을 얻는다.
				InputStream inputStream = socket.getInputStream();
				
				// 서버가 비정상적으로 종료했을 경우 IOException 발생
				// 데이터 받기
				/* InputStream의 read() 메소드를 호출
				 * 서버가 데이터를 보내기 전까지 블로킹되며,
				 * 데이터를 받으면 byteArr엦 저장하고 받은 바이트 개수는 
				 * readByteCount에 저장
				 */
				int readByteCount = inputStream.read(byteArr);
				
				/* 서버가 정상적으로 Socket의 close()를 호출했을 경우
				 * 위의 read() 메소드는 -1을 리턴
				 * 이 경우 IOException을 강제로 발생시킨다.
				 */
				if(readByteCount == -1) { throw new IOException(); }
				
				// 문자열로 변환
				/* 정상적으로 데이터를 받았을 경우,
				 * String(byteArr, 0, readByteCount, "UTF-8")을 이용해서
				 * UTF-8로 디코딩한 문자열을 받는다.
				 */
				String data = new String(byteArr, 0, readByteCount, "UTF-8");
				
				// "[ 받기 완료 ] + 받은 문자열"을 출력하도록 displayText()를 호출
				Platform.runLater(() -> displayText("[ 받기 완료 ] " + data));
			} catch(Exception e) {
				/* 서버가 비정상적으로 연결을 끊게 되면 IOException이 발생하고, 
				 * 서버 측 Socket이 close9)를 호출해서 정상적으로 연결을 끊게 되면 
				 * IOException이 발생
				 * 예외가 발생하면 "[ 서버 통신 안됨 ]"울 출력하도록 displayText()를 호출
				 */
				Platform.runLater(() -> displayText("[ 서버 통신 안됨 ]"));
				stopClient(); // stopClient()를 호출
				break; // break를 실행해서 무한 루프를 빠져나온다.
			}
		}
	}
	
	// send() 메소드는 [send] 버튼을 클릭하면 호출
	// 서버로 데이터를 보낸다.
	void send(String data) {
		// 데이터를 서버로 보내는 새로운 작업 스레드를 생성
		Thread thread = new Thread() { // 스레드 생성
			// run()을 재정의
			@Override
			public void run() {
				try {
					// 보낼 문자열로부터 UTF-8로 인코딩한 바이트 배열을 얻는다.
					byte[] byteArr = data.getBytes("UTF-8");
					
					// 서버로 데이터 보내기
					// Socket에서 출력 스트림을 얻는다.
					OutputStream outputStream = socket.getOutputStream();
					// 바이트 배열을 매개값으로 write() 메소드를 호출
					outputStream.write(byteArr);
					// 출력 스트림의 내부 버퍼를 완전히 비우도록 flush()를 호출
					outputStream.flush();
					
					// "[ 보내기 완료 ]"를 출력하도록 displayText()를 호출
					Platform.runLater(() -> displayText("[ 보내기 완료 ]"));
				} catch(Exception e) {
					/* 예외가 발생하면 "[ 서버 통신 안됨 ]"을 출력하도록
					 * displayText()를 호출
					 */
					Platform.runLater(() -> displayText("[ 서버 통신 안됨 ]"));
					// stopClient를 호출
					stopClient();
				}
			}
		};
		// 작업 스레드를 시작
		thread.start(); // 스레드 생성
	}
	
	/////////////////////////////////
	TextArea txtDisplay;
	TextField txtInput;
	Button btnConn, btnSend;
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		BorderPane root = new BorderPane();
		root.setPrefSize(500, 300);
		
		txtDisplay = new TextArea();
		txtDisplay.setEditable(false);
		BorderPane.setMargin(txtDisplay, new Insets(0, 0, 2, 0));
		root.setCenter(txtDisplay);
		
		BorderPane bottom = new BorderPane();
		txtInput = new TextField();
		txtInput.setPrefSize(60, 30);
		BorderPane.setMargin(txtInput, new Insets(0, 1, 1, 1));
		
		btnConn = new Button("start");
		btnConn.setPrefSize(60, 30);
		
		// start와 stop 버튼을 클릭했을 때 이벤트 처리 코드
		btnConn.setOnAction(e -> {
			if(btnConn.getText().equals("start")) {
				startClient();
			} else if(btnConn.getText().equals("stop")) {
				stopClient();
			}
		});
		
		btnSend = new Button("send");
		btnSend.setPrefSize(60, 30);
		btnSend.setDisable(true);
		
		// send 버튼을 클릭했을 때 이벤트 처리 코드
		btnSend.setOnAction(e -> send(txtInput.getText()));
		
		bottom.setCenter(txtInput);
		bottom.setLeft(btnConn);
		bottom.setRight(btnSend);
		
		root.setBottom(bottom);
		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("app.css").toString());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Client");
		
		// 윈도우 우측 상단 닫기 버튼을 클릭했을 때 이벤트 처리 코드
		primaryStage.setOnCloseRequest(event -> stopClient());
		primaryStage.show();
	}
	
	// TextArea에 문자열을 추가하는 메소드
	void displayText(String text) {
		txtDisplay.appendText(text + "\n");
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
