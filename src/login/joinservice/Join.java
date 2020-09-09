package login.joinservice;

import java.sql.SQLException;

import javafx.scene.Parent;

public interface Join {
	public void join(Parent root, String id) throws SQLException;
	public void cancel(Parent root);
}
