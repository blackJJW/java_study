module second_javafx {
	requires javafx.controls;
	
	opens application to javafx.graphics, javafx.fxml;
}
