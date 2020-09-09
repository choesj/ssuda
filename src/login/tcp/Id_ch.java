package login.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.sql.SQLException;
import java.util.HashMap;

class Id_ch implements Runnable{
	
	String user="";
	ServerSocket serversocket;
	int i;
	public Id_ch(ServerSocket serversocket, int i) {
		this.serversocket=serversocket;
		this.i=i;
	}	
	@Override
	public void run() {
		try {
			Socket socket = serversocket.accept();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			try {
				while(true) {
					String msg = br.readLine();
					user="";
					String[] cut = msg.split("/");
//					System.out.println(msg);	//ID목록 이 들어왔는지 확인
					if(cut[0].equals("ID목록")) {
						try {
							HashMap<String, Integer> list = GameServer.db.bringUser();
							for(String x:list.keySet()) {
								user+=(x+"/");	//user1/user2/user3/...
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						bw.write(user+"\n");
						bw.flush();
					}else if(cut[0].equals("회원가입")){
						GameServer.db.insertUser(cut[1]);
					}else if(cut[0].equals("회원탈퇴")) {
						GameServer.db.deleteUser(cut[1]);
					}
				}
			} catch (SocketException e) {
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}