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

class Server implements Runnable{
	String name;
	ServerSocket serversocket;
	int i;
	String user="";
	public Server(ServerSocket serversocket,int i) {
		this.serversocket=serversocket;
		this.i=i;
	}
	
	@Override
	public void run() {
		try {
			Socket socket = serversocket.accept();
			GameServer.iparr[i]=socket;
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
//			try {
//				HashMap<String, Integer> list = GameServer.db.bringUser();
//				for(String x:list.keySet()) {
//					user+=(x+"/"+list.get(x)+"/");
//				}
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//			bw.write(user+"\n");
//			bw.flush();
			
			try {
				while(true) {
					name = br.readLine();
					if(name.equals("로그인")) {
						try {
							HashMap<String, Integer> list = GameServer.db.bringUser();
							for(String x:list.keySet()) {
								user+=(x+"/"+list.get(x)+"/");
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						bw.write(user+"\n");
						bw.flush();
					}else{
						GameServer.namearr.add(name);
						System.out.println(name+"님 입장하셨습니다.");
						GameServer.usercount++;
						Thread t = new Thread(new Name());
						t.start();
					}
				}
			} catch (SocketException e) {
				GameServer.usercount--;
				System.out.println(name+"님 나가셨습니다."+GameServer.usercount);
				GameServer.iparr[i]=null;
				GameServer.namearr.remove(GameServer.namearr.indexOf(name));
				GameServer.arr[i]=null;
			} 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}