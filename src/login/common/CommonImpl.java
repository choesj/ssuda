package login.common;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import login.Con_Game;
import login.Con_Join;
import login.Con_UnJoin;

public class CommonImpl implements Common{

	@Override
	public void cancel(Parent root) {
		Stage s = (Stage) root.getScene().getWindow();
		s.close();
	}
	@Override
	public void open(String msg) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(msg));
		Parent root = loader.load();
		if(msg.equals("../../Join.fxml")) {
			Con_Join unjoin = loader.getController();
			unjoin.setRoot(root);
		}
		if(msg.equals("../../Game.fxml")) {
			Con_Game unjoin = loader.getController();
			unjoin.setRoot(root);
		}
		if(msg.equals("../../UnJoin.fxml")) {
			Con_UnJoin unjoin = loader.getController();
			unjoin.setRoot(root);
		}	
		
		
		Stage s = new Stage();
		s.setScene(new Scene(root));
		s.show();
	}
	@Override
	public void alert(String msg) {
		Alert al = new Alert(AlertType.INFORMATION);
		al.setContentText(msg);
		al.show();		
	}

}
