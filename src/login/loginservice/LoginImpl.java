package login.loginservice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.SQLException;

import javafx.scene.Parent;
import javafx.scene.control.TextField;
import login.Main;
import login.common.CommonImpl;

public class LoginImpl implements Login{
	public static String name;
	CommonImpl ci;
	public LoginImpl() {
		ci = new CommonImpl();
	}
	@Override
	public void login(Parent root) throws SQLException, IOException {
		TextField fxid = (TextField) root.lookup("#fxid");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(Main.socket_main.getOutputStream()));
		bw.write("로그인\n");
		bw.flush();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(Main.socket_main.getInputStream()));
		String[] cut = br.readLine().split("/");
		int x=0;
		for(int i=0;i<cut.length;i++) {
			if(cut[i].equals(fxid.getText())) {
				x=1;
				break;
			}
			i++;
		}
		
		if(x==1) {
			name=fxid.getText();
			bw.write(name+"\n");
			bw.flush();
			ci.open("../../Game.fxml");
		}
		else {
			ci.alert("로그인 실패.");
		}
	}

	@Override
	public void join() throws IOException {
		ci.open("../../Join.fxml");
	}

	@Override
	public void unjoin() throws IOException {
		ci.open("../../UnJoin.fxml");
		
	}

}
