package nonBlocking;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ServerEx extends Application {
	// 넌블로킹의 핵심 객체인 Selector 필드를 선언
	Selector selector;
	// 클라이언트 연결을 수락하는 ServerSocketChannel필드를 선언
	ServerSocketChannel  serverSocketChannel;

	/* 연결된 클라이언트를 저장하는 List<Client> 타입의 
	 * connections 필드를 선언
	 * 스레드에 안전한 Vector로 초기화
	 */
	List<Client> connections = new Vector<Client>();

	void startServer() {
		try {
			selector = Selector.open(); // Selector 생성
			serverSocketChannel = ServerSocketChannel.open();

			// 넌블로킹으로 설정
			serverSocketChannel.configureBlocking(false);
			// 5001번 포트에 바인딩
			serverSocketChannel.bind(new InetSocketAddress(5001));
			
			// Selector에 작업 유형을 등록
			serverSocketChannel.register(selector, 
									SelectionKey.OP_ACCEPT);
		} catch (Exception e) {
			if(serverSocketChannel.isOpen()) { stopServer(); }
			// return을 실행해서 startServer() 실행을 중단
			return;
		}
		
		Thread thread = new Thread() { // 스레드 생성
			@Override
			public void run() {
				while(true) {
					try {
						// 작업 처리 준비가 된 채널이 있을 때까지 대기
						int keyCount = selector.select();
						if(keyCount == 0) { continue; }
						// 작업 처리 준비가 된 키를 얻고 Set 컬렉션으로 리턴
						Set<SelectionKey> selectedKeys
							= selector.selectedKeys();
						Iterator<SelectionKey> iterator 
							= selectedKeys.iterator();
						while (iterator.hasNext()) {
							SelectionKey selectionKey = iterator.next();
							if (selectionKey.isAcceptable()) {
							// 연결 수락 작업일 경우
								accept(selectionKey);
							} else if (selectionKey.isReadable()) {
							// 읽기 작업일 경우
								Client client = (Client) selectionKey.attachment();
								client.receive(selectionKey); 
							} else if (selectionKey.isWritable()) {
							// 쓰기 작업일 경우
								Client client = (Client) selectionKey.attachment();
								client.send(selectionKey);
							}
							// 선택된 키셋에서 처리 완료된 SelectionKey를 제거
							iterator.remove();
						}
					} catch (Exception e) {
						if(serverSocketChannel.isOpen()) { stopServer(); }
						break;
					}
				}
			}
		};
		thread.start(); // 스레드 시작

		Platform.runLater(() -> {
			displayText("[ 서버 시작 ]");
			btnStartStop.setText("stop");
		});
	}
	void stopServer() {
		try {
			Iterator<Client> iterator = connections.iterator();
			while(iterator.hasNext()) {
				Client client = iterator.next();
				// 연결된 SocketChannel 닫기
				client.socketChannel.close();
				iterator.remove();
			}
			if(serverSocketChannel != null 
					&& serverSocketChannel.isOpen()) {
				// ServerSocketChannel 닫기
				serverSocketChannel.close();
			}
			if(selector != null && selector.isOpen()) {
				selector.close(); // Selector 닫기
			}
			Platform.runLater(() -> {
				displayText("[ 서버 멈춤 ]");
				btnStartStop.setText("start");
			});
		} catch (Exception e) {}
	}

	// 작업 스레드가 연결 수락 작업을 처리하기 위해 호출하는 메소드
	void accept(SelectionKey selectionKey) {
		try {
			// ServerSocketChannel 얻기
			ServerSocketChannel serverSocketChannel
				= (ServerSocketChannel) selectionKey.channel();
			SocketChannel socketChannel 
				= serverSocketChannel.accept(); // 연결 수락
			String message = "[ 연결 수락 : " 
				+ socketChannel.getRemoteAddress() + " : " 
				+ Thread.currentThread().getName() + " ] ";
			Platform.runLater(() -> displayText(message));

			// Client 객체 생성 및 저장
			Client client = new Client(socketChannel);
			connections.add(client);

			Platform.runLater(() -> displayText("[ 연결 개수 : " 
				+ connections.size() + " ]"));
		} catch(Exception e) {
			if(serverSocketChannel.isOpen()) { stopServer(); }
		}
	}

	class Client {
		SocketChannel socketChannel;
		String sendData; // 클라이언트로 보낼 데이터를 저장하는 필드

		Client(SocketChannel socketChannel)  {
			this.socketChannel = socketChannel;

			/* 넌블로킹으로 설정하고 
			 * 읽기 작업 유형으로 Selector에 등록
			 */
			socketChannel.configureBlocking(false);
			SelectionKey selectionKey 
				= socketChannel.register(selector, 
									SelectionKey.OP_READ);
			// SelectionKey에 자기 자신을 첨부 객체로 저장
			selectionKey.attach(this);
		}
		void receive(SelectionKey selectionKey) {
			try {
				ByteBuffer byteBuffer = ByteBuffer.allocate(100);

				// 상대방이 비정상 종료를 했을 경우 자동 IOException 발생
				// 데이터 받기
				int byteCount = socketChannel.read(byteBuffer);

				// 상대방이 SocketChannel의 close() 메소드를 호출할 경우
				if(byteCount == -1) {
					throw new IOException();
				}

				String message = "[ 요청 처리 : " 
					+ socketChannel.getRemoteAddress() + " : " 
					+ Thread.currentThread().getName() + " ]";
				Platform.runLater(() -> displayText(message));
			
				// 문자열 변환
				byteBuffer.flip();
				Charset charset = Charset.forName("UTF-8");
				String data = charset.decode(byteBuffer).toString();

				// 모든 클라이언트에게 문자열을 전송하는 코드
				for(Client client : connections) {
					client.sendData = data;
					SelectionKey key 
						= client.socketChannel.keyFor(selector);
					key.interestOps(SelectionKey.OP_WRITE); // 작업 유형 변경
				}
				/* 변경된 작업 유형을 감지하도록 하기 위해 Selector의
				 * select() 블로킹을 해제하고 다시 실행하도록 한다.
				 */
				selector.wakeup();
			} catch(Exception e) {
				try {
					connections.remove(this);
					String message = "[ 클라이언트 통신 안됨 : " 
						+ socketChannel.getRemoteAddress() + " : "
						+ Thread.currentThread().getName() + " ]";
					Platform.runLater(() -> displayText(message));
					socketChannel.close();
				} catch (IOException e2) {}
			}
		}
		void send(SelectionKey selectionKey) {
			try {
				Charset charset = Charset.forName("UTF-8");
				ByteBuffer byteBuffer = charset.encode(sendData);
				socketChannel.write(byteBuffer); // 데이터 보내기
				// 작업 유형 변경
				selectionKey.interestOps(SelectionKey.OP_READ);
				/* 변경된 작업 유형을 감지하도록 
				 * Selector의 select() 블로킹 해제
				 */
				selector.wakeup();
			} catch(Exception e) {
				try {
					String message = "[ 클라이언트 통신 안됨 : "
						+ socketChannel.getRemoteAddress() + " : "
						+ Thread.currentThread().getName() + " ]";
					Platform.runLater(() -> displayText(message));
					connections.remove(this);
					socketChannel.close();
				} catch (IOException e2) {}
			}
		}
	}

	/////////////////////
	// UI 생성 코드
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
		
		// start 버튼과 stop 버튼을 클릭했을 때 이벤트 처리
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
		
		// 윈도우 우측 상단 닫기 버튼을 클릭했을 때 이벤트 처리
		primaryStage.setOnCloseRequest(event -> stopServer());
		primaryStage.show();
	}
	
	// 작업 스레드의 작업 처리 내용을 출력할 때 호출되는 메소드
	void displayText(String text) {
		txtDisplay.appendText(text + "\n");
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
