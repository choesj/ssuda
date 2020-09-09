package login.loginservice;

import java.io.IOException;
import java.sql.SQLException;

import javafx.scene.Parent;

public interface Login {
	public void login(Parent root) throws SQLException, IOException;
	public void join() throws IOException;
	public void unjoin() throws IOException;
}
