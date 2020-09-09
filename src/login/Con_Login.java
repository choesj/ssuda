package login;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import login.loginservice.LoginImpl;

public class Con_Login implements Initializable{

	
	Parent root;
	LoginImpl li;
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		li = new LoginImpl();
	}
	public void unjoin() throws IOException {
		li.unjoin();
	}
	public void join() throws IOException {
		li.join();
	}
	public void login() throws SQLException, IOException {
		li.login(root);
	}
	

}
