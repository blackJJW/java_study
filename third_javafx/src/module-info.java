module third_javafx {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.media;
	
	opens application to javafx.graphics, javafx.fxml;
	opens layoutEx to javafx.graphics, javafx.fxml;
	opens flowPane to javafx.graphics, javafx.fxml;
	opens tilePane to javafx.graphics, javafx.fxml;
	opens gridPane to javafx.graphics, javafx.fxml;
	opens listener to javafx.graphics, javafx.fxml;
	opens binding to javafx.graphics, javafx.fxml;
	opens bindingsClass to javafx.graphics, javafx.fxml;
	opens buttonControl to javafx.graphics, javafx.fxml;
	opens inputControl to javafx.graphics, javafx.fxml;
	opens tableView to javafx.graphics, javafx.fxml;
	opens mediaView to javafx.graphics, javafx.fxml, javafx.media;
	opens chartControl to javafx.graphics, javafx.fxml;
	opens menuBarToolBar to javafx.graphics, javafx.fxml;
	opens dialog to javafx.graphics, javafx.fxml;
	opens javaFXCSS to javafx.graphics, javafx.fxml;
	opens javaFxExternalCSS to javafx.graphics, javafx.fxml;
	opens css_2 to javafx.graphics, javafx.fxml;
	opens border to javafx.graphics, javafx.fxml;
	opens background to javafx.graphics, javafx.fxml;
	opens font to javafx.graphics, javafx.fxml;
	opens shadow to javafx.graphics, javafx.fxml;
	opens skin to javafx.graphics, javafx.fxml;
	opens runLater to javafx.graphics, javafx.fxml;
	opens task to javafx.graphics, javafx.fxml;
	opens task_2 to javafx.graphics, javafx.fxml;
	opens service to javafx.graphics, javafx.fxml;
	opens sceneMove to javafx.graphics, javafx.fxml;
	
	exports tableView;
}
