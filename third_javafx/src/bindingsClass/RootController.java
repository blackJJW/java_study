package bindingsClass;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

public class RootController implements Initializable {
	@FXML private AnchorPane root;
	@FXML private Circle circle;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		circle.centerXProperty().bind(Bindings.divide(root.widthProperty(), 2));
		circle.centerYProperty().bind(Bindings.divide(root.heightProperty(), 2));
		/* circle.centerYProperty() : Circle의 중심 centerY 속성 객체
		 * Bindings.divide() : 속성 연산
		 * root.heightProperty() : 루트 컨테이너의 height 속성 객체
		 * 2 : 나누는 값
		 */
	}
}
