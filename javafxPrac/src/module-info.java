module javafxPrac {
	requires javafx.controls;
	requires javafx.fxml;
	
	opens application to javafx.graphics, javafx.fxml;
	opens hboxvbox to javafx.graphics, javafx.fxml;
	opens borderPane to javafx.graphics, javafx.fxml;
	opens stackPane to javafx.graphics, javafx.fxml;
	opens eventHandler to javafx.graphics, javafx.fxml;
	opens fxmlController to javafx.graphics, javafx.fxml;
}
