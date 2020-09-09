package login;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.SocketException;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import login.loginservice.LoginImpl;

class Users implements Runnable{
	TextField[] users;
	TextField[] moneys;
	Button bstart;
	TextField[] pas;
	BufferedReader br;
	public Users(TextField[] users,TextField[] moneys,Button bstart,TextField[] pas,BufferedReader br) {
		this.users = users;
		this.moneys = moneys;
		this.bstart = bstart;
		this.pas=pas;
		this.br=br;
	}
	
	@Override
	public void run() {
		
		try {
			try {
				while(true) {
					String msg = br.readLine();
					System.out.println(msg);
					String[] cut = msg.split("/");
					for(int i=0;i<5;i++) {
						users[i].setText("user");
						moneys[i].setText("돈 : ");
					}
					
					for(int i=1;i<cut.length;i++) {
						if(cut[i+1].equals(LoginImpl.name)) {
							if(cut[i].equals("방장")) {
								if(Integer.valueOf(cut[0])>=2){
									bstart.setDisable(false);
									
								}
								pas[0].setText("방장");
							}else {
								pas[0].setText("일반");
							}
							users[0].setText(cut[i+1]);
							moneys[0].setText(cut[i+2]);
						}else {
							for(int x=1;x<5;x++) {
								if(users[x].getText().equals("user")) {
									if(cut[i].equals("방장")) {
										pas[x].setText("방장");
									}else {
										pas[x].setText("일반");
									}
									users[x].setText(cut[i+1]);
									moneys[x].setText(cut[i+2]);
									break;
								}
							
							}
						}
						i+=2;
					}
					
				}
			} catch (SocketException e) {
				System.out.println("서버 끊김");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
