module javafxPrac {
	requires javafx.controls;
	requires javafx.fxml;
	
	opens application to javafx.graphics, javafx.fxml;
	opens hboxvbox to javafx.graphics, javafx.fxml;
}
