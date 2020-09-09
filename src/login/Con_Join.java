package login;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import login.joinservice.JoinImpl;

public class Con_Join implements Initializable{

	Parent root;
	JoinImpl ji;
	@FXML TextField fxid;
	public void setRoot(Parent root) {
		this.root = root;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ji = new JoinImpl();
	}
	public void join() throws SQLException {
		ji.join(root,fxid.getText());
	}
	public void cancel() {
		ji.cancel(root);
	}

}
