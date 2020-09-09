package login.joinservice;

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

public class JoinImpl implements Join{
	CommonImpl ci;
	public JoinImpl() {
		ci = new CommonImpl();
	}
	@Override
	public void join(Parent root,String id) throws SQLException {
		TextField fxid = (TextField) root.lookup("#fxid");
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(Main.socket_idch.getOutputStream()));
			BufferedReader br = new BufferedReader(new InputStreamReader(Main.socket_idch.getInputStream()));
			bw.write("ID목록/\n");
			bw.flush();
			String[] cut = br.readLine().split("/");
			int x = 0;
			for (int i = 0; i < cut.length; i++) {
				if (cut[i].equals(fxid.getText())) {
					x = 1;
					break;
				}
			}
			if (x == 1) {
				ci.alert("아이디가 있습니다.");
				fxid.clear();
				fxid.requestFocus();
			} else {
				bw.write("회원가입/"+fxid.getText() + "\n");
				bw.flush();
				ci.alert("회원가입 완료");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}

	@Override
	public void cancel(Parent root) {
		ci.cancel(root);
	}

}
