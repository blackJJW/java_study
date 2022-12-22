package tableView;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class RootController implements Initializable {
	@FXML private ListView<String> listView;  // ListView<아이템타입>
	@FXML private TableView<Phone> tableView; // TableView<모델클래스>
	@FXML private ImageView imageView;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		listView.setItems(FXCollections.observableArrayList(
			"G-S1", "G-S2", "G-S3", "G-S4", "G-S5", "G-S6", "G-S7"
		));
		
		// selectedIndex 속성 감시
		listView.getSelectionModel().selectedIndexProperty().addListener(
			new ChangeListener<Number>() {
				@Override
				public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
					tableView.getSelectionModel().select(newValue.intValue());
					                            // 변경된 인덱스의 행 선택
					tableView.scrollTo(newValue.intValue());
					// 변경괸 인덱스 위치로 스크롤 시킴
				}
			}
		);
		
		ObservableList phoneList = FXCollections.observableArrayList(
			// 총 7개의 행 데이터
			new Phone("G-S1", "phone01.png"),
			new Phone("G-S2", "phone02.png"),
			new Phone("G-S3", "phone03.png"),
			new Phone("G-S4", "phone04.png"),
			new Phone("G-S5", "phone05.png"),
			new Phone("G-S6", "phone06.png"),
			new Phone("G-S7", "phone07.png")
		);
		
		TableColumn tcSmartPhone = tableView.getColumns().get(0);
		tcSmartPhone.setCellValueFactory(new PropertyValueFactory("smartPhone"));
		tcSmartPhone.setStyle("-fx-alignment: CENTER;");
		
		TableColumn tcImage = tableView.getColumns().get(1);
		tcImage.setCellValueFactory(new PropertyValueFactory("image"));
		tcImage.setStyle("-fx-alignment: CENTER;");
		
		tableView.setItems(phoneList);
		
		// selectedItem 속성 감시
		tableView.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<Phone>() {
				@Override
				public void changed(ObservableValue<? extends Phone> observable,
					Phone oldValue, Phone newValue) {
					if(newValue != null) {
						imageView.setImage(new Image(
							getClass().getResource("images/" + newValue.getImage()).toString())
						);
					}
				}
			}
		);
	}
	
	public void handleBtnOkAction(ActionEvent e) {
		String item = listView.getSelectionModel().getSelectedItem();
		                                       // 선택된 항목(행)의 데이터 얻기
		
		System.out.println("ListView 스마트폰 :" + item);
		
		Phone phone = tableView.getSelectionModel().getSelectedItem();
		                                       // 선택된 항목(행)의 데이터 얻기
		
		System.out.println("TableView 스마트폰 : " + phone.getSmartPhone());
		System.out.println("TableView 이미지 : " + phone.getImage());
	}
	
	public void handleBtnCancelAction(ActionEvent e) {
		Platform.exit();
	}
}
