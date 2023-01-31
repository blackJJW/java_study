package application;

import java.nio.channels.ServerSocketChannel;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;

import javafx.application.Application;

public class ServerEx extends Application {
	ExecutorService executorService;
	ServerSocketChannel serverSocketChannel;
	List<Client> connections = new Vector<Client>();
	
	void startServer() {}
	void stopServer() {}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
