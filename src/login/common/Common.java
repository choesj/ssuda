package login.common;

import java.io.IOException;

import javafx.scene.Parent;

public interface Common {
	public void cancel(Parent root);	//â �ݱ�
	public void open(String msg) throws IOException;		//â �Ѿ��
	public void alert(String msg);	//���â
}
