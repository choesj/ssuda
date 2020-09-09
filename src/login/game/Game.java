package login.game;

import javafx.scene.Parent;

public interface Game {
	public void die(Parent root);
	public void cal(Parent root);
	public void go(Parent root);
	public void start(Parent root);
}
