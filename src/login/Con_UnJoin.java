package login;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import login.unjoin.UnJoinImpl;

public class Con_UnJoin implements Initializable {
	Parent root;
	UnJoinImpl uj;
	public void setRoot(Parent root) {
		this.root = root;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		uj = new UnJoinImpl();
	}
	public void ok() throws SQLException{
		uj.ok(root);
	}
	public void cancel() {
		uj.cancel(root);
	}
}
