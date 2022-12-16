module third_javafx {
	requires javafx.controls;
	requires javafx.fxml;
	
	opens application to javafx.graphics, javafx.fxml;
	opens layoutEx to javafx.graphics, javafx.fxml;
	opens flowPane to javafx.graphics, javafx.fxml;
	opens tilePane to javafx.graphics, javafx.fxml;
	opens gridPane to javafx.graphics, javafx.fxml;
	opens listener to javafx.graphics, javafx.fxml;
}
