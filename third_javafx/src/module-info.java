module third_javafx {
	requires javafx.controls;
	requires javafx.fxml;
	
	opens application to javafx.graphics, javafx.fxml;
	opens layoutEx to javafx.graphics, javafx.fxml;
}