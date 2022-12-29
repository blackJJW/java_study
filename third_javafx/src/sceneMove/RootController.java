package sceneMove;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class RootController implements Initializable {
	@FXML private Button btnLogin;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnLogin.setOnAction( e -> handleBtnLogin(e) );
	}
	
	public void handleBtnLogin(ActionEvent event) {
		try {
			// 로그인 화면으로 이동
			Parent login = FXMLLoader.load(getClass().getResource("Login.fxml"));
			StackPane root = (StackPane) btnLogin.getScene().getRoot();
			root.getChildren().add(login);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
