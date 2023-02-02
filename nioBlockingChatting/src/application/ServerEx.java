package application;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Application;
import javafx.application.Platform;

public class ServerEx extends Application {
	ExecutorService executorService;
	ServerSocketChannel serverSocketChannel;
	List<Client> connections = new Vector<Client>();
	
	void startServer() {
		executorService = Executors.newFixedThreadPool(
			Runtime.getRuntime().availableProcessors()
		);
		try {
			serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.configureBlocking(true);
			serverSocketChannel.bind(new InetSocketAddress(5001));
		} catch(Exception e) {
			/* 5001번 포트를 이미 다른 포트 프로그램에서 사용하고 있다면
		   * java.net.BindException이 발생
		   * 이 경우에는 ServerSocketChannel이 열려 있는지 확인
		   * stopServer() 메소드를 실행
		   * return을 실행해서 startServer() 메소드를 종료
		   */
			if(serverSocketChannel.isOpen()) { stopServer(); }
			return;
		}
		
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				Platform.runLater(() -> {
					displayText("[ 서버 시작 ]");
					btnStartStop.setText("stop");
				});
				while(true) {
					try {
						// 연결 수락
						SocketChannel socketChannel 
								= serverSocketChannel.accept();
						String message = "[ 연결 수락 : " 
								+ socketChannel.getRemoteAddress() 
								+ " : " + Thread.currentThread().getName() 
								+ " ]";
						Platform.runLater(() -> displayText(message));

						// Client 객체 저장
						Client client = new Client(socketChannel);
						connections.add(client);

						Platform.runLater(() -> displayText("[ 연결 개수 : " 
								+ connections.size() + " ]"));
					} catch (Exception e) {
						if(serverSocketChannel.isOpen()) { stopServer(); }
						break;
					}
				}
			}
		};
		executorService.submit(runnable); // 스레드풀에서 처리
	}
	void stopServer() {
		try {
			// 모든 SocketChannel 닫기
	    // connections 컬렉션으로부터 반복자를 얻어냄
			Iterator<Client> iterator = connections.iterator();

	    /* while문으로 반복자를 반복하면서 Client를 하나씩 얻는다.
	     * Client가 가지고 있는 SocketChannel을 닫고
	     * connections 컬렉션에서 Client를 제거
	     */
			while(iterator.hasNext()) {
				Client client = iterator.next();
				client.socketChannel.close();
				iterator.remove();
			}
			// ServerSocketChannel 닫기
	    /* ServerSocketChannel이 null이 아니고,
	     * 열려 있으면 ServerSocketChannel을 닫는다.
	     */
			if(serverSocketChannel != null 
	         && serverSocketChannel.isOpen()) {
				serverSocketChannel.close();
			}
			// ExecutorService 종료
	    /* ExecutorService가 null이 아니고,
	     * 종료 상태가 아니면 ExecutorService를 종료
	     */
			if(executorService != null 
	         && !executorService.isShutdown()) {
				executorService.shutdown();
			}
	    /* 작업 스레드는 UI를 변경하지 못하므로 
	     * Platform.runLater()가 사용
	     * "[ 서버 멈춤 ]"을 출력하도록 displayText()를 호출
	     * [stop] 버튼의 글자를 [start]로 변경
	     */
			Platform.runLater(() -> {
				displayText("[ 서버 멈춤 ]");
				btnStartStop.setText("start");
			});
		} catch (Exception e) {}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// Client를 ServerEx의 내부 클래스로 선언
	class Client {
	  // 통신용 SocketChannel을 필드로 선언
		SocketChannel socketChannel;

	  /* Client 생성자를 선언
	   * 매개값으로 SocketChannel 필드를 초기화
	   * receive()를 호출
	   */
		Client(SocketChannel socketChannel) {
			this.socketChannel = socketChannel;
			receive();
		}

	  // 클라이언트의 데이터를 받기 위해 receive() 메소드를 선언
		void receive() { 
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					while(true) {
						try {
							ByteBuffer byteBuffer = ByteBuffer.allocate(100);

							// 클라이언트가 비정상 종료를 했을 경우 IOException 발생
							// 데이터 받기
							int readByteCount = socketChannel.read(byteBuffer);

							// 클라이언트가 정상적으로 SocketChannel의 close()를 호출했을 경우
							if(readByteCount == -1) {
								throw new IOException();
							}

							String message = "[ 요청 처리 : " 
								+ socketChannel.getRemoteAddress() + " : " 
								+ Thread.currentThread().getName() + " ]";
							Platform.runLater(() -> displayText(message));

							// 문자열로 변환
							byteBuffer.flip();
							Charset charset = Charset.forName("UTF-8");
							String data = charset.decode(byteBuffer).toString();

							// 모든 클라이언트에게 보냄
							for(Client client : connections) {
								client.send(data);
							}
						} catch(Exception e) {
							try {
								connections.remove(Client.this);
								String message = "[ 클라이언트 통신 안됨 : " 
										+ socketChannel.getRemoteAddress() + " : " 
										+ Thread.currentThread().getName() + " ]";
								Platform.runLater(() -> displayText(message));
								socketChannel.close();
							} catch (IOException e2) {}
							break;
						}
					}
				}
			};
		  // 스레드풀에서 처리
		  executorService.submit(runnable);
		}
	  // 데이터를 클라이언트로 보내기 위해 send() 메소드를 선언
		void send(String data) {
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					try {
						// 클라이언트로 보내기
						Charset charset = Charset.forName("UTF-8");
		                ByteBuffer byteBuffer = charset.encode(data);
		                socketChannel.write(byteBuffer);
					} catch(Exception e) {
						try {
							String message = "[ 클라이언트 통신 안됨 : "
		              + socketChannel.getRemoteAddress() + " : "
		              + Thread.currentThread().getName() + " ]";
		          Platform.runLater(() -> displayText(message));
		          connections.remove(Client.this);
		          socketChannel.close();
						} catch (IOException e2) {}
					}
				}
			};
		  // 스레드풀에서 처리
		  executorService.submit(runnable);
		}
	}

}
