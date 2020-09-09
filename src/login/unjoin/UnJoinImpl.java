package login.unjoin;

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

public class UnJoinImpl implements UnJoin{
	
	CommonImpl ci;
	public UnJoinImpl() {
		ci = new CommonImpl();
	}
	@Override
	public void ok(Parent root) throws SQLException {
		TextField fxid = (TextField) root.lookup("#fxid");
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(Main.socket_idch.getOutputStream()));
			BufferedReader br = new BufferedReader(new InputStreamReader(Main.socket_idch.getInputStream()));
			bw.write("ID목록/\n");
			bw.flush();
			String[] cut = br.readLine().split("/");	//넘어온 user1/...을 /기준으로 쪼갬
			int x = 0;
			for (int i = 0; i < cut.length; i++) {	//user명 수 만큼 반복
				if (cut[i].equals(fxid.getText())) {	//입력받은 id 가 같은게 있으면 중지
					x = 1;
					break;
				}
			}
			if (x == 1) {	
				bw.write("회원탈퇴/"+fxid.getText() + "\n");
				bw.flush();
				ci.alert("회원탈퇴 완료");
			} else {
				ci.alert("아이디가 없습니다.");
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
