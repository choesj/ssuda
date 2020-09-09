package login.unjoin;

import java.sql.SQLException;

import javafx.scene.Parent;

public interface UnJoin {
	public void ok(Parent root) throws SQLException;
	public void cancel(Parent root);
}
