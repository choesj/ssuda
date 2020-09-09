package login.common;

import java.io.IOException;

import javafx.scene.Parent;

public interface Common {
	public void cancel(Parent root);	//창 닫기
	public void open(String msg) throws IOException;		//창 넘어가기
	public void alert(String msg);	//경고창
}
