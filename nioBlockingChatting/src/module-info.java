module nioBlockingChatting {
	requires javafx.controls;
	
	opens application to javafx.graphics, javafx.fxml;
	opens nonBlocking to javafx.graphics, javafx.fxml;
}
