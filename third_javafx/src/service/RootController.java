package service;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class RootController implements Initializable {
	@FXML private ProgressBar progressBar;
	@FXML private Label lblWorkDone;
	@FXML private Label lblResult;
	@FXML private Button btnStart;
	@FXML private Button btnStop;
	
	private TimeService timeService;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnStart.setOnAction( event -> handleBtnStart(event) );
		btnStop.setOnAction( event -> handleBtnStop(event) );
		
		timeService = new TimeService();
		timeService.start();
	}
	
	public void handleBtnStart(ActionEvent e) {
		timeService.restart();
		lblResult.setText("");
	}
	
	public void handleBtnStop(ActionEvent e) {
		timeService.cancel();
	}
	
	class TimeService extends Service<Integer>{
		@Override
		protected Task<Integer> createTask(){
			Task<Integer> task = new Task<Integer>() {
				@Override
				protected Integer call() throws Exception {
					int result = 0;
					for(int i = 0; i <= 100; i++) {
						if(isCancelled()) { break; }
						result += i;
						updateProgress(i, 100);
						updateMessage(String.valueOf(i));
						try { Thread.sleep(100); } catch(InterruptedException e) {
							if(isCancelled()) { break; }
						}
					}
					return result;
				}
			};
			progressBar.progressProperty().bind(task.progressProperty());
			lblWorkDone.textProperty().bind(task.messageProperty());;
			return task;
		}
		
		// 성공적으로 작업이 완료되었을 때 호출
		@Override
		protected void succeeded() {
			lblResult.setText(String.valueOf(getValue()));
		}
		
		// 작업이 취소되었을 때 호출
		@Override
		protected void cancelled() {
			lblResult.setText("취소됨");
		}
		
		// 작업 처리 도중 예외가 발생할 경우 호출
		@Override
		protected void failed() {
			lblResult.setText("실패");
		}
	}

}
