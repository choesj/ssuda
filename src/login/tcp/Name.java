package login.tcp;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.SQLException;
import java.util.HashMap;

class Name implements Runnable{

	@Override
	public void run() {
		try {
			while(true) {
//				System.out.println(GameServer.users);
				if(GameServer.usercount!=GameServer.users) {
					System.out.println("유저수 : "+GameServer.usercount);
					String user="";
					HashMap<String, Integer> list = GameServer.db.bringUser();
					for(String x:list.keySet()) {
						for(int i=0;i<GameServer.namearr.size();i++) {
							if(GameServer.namearr.get(i).equals(x)) {
								if(i==0) {
									user+=("방장/"+x+"/"+list.get(x)+"/");
								}else {
									user+=("일반/"+x+"/"+list.get(x)+"/");
								}
							}
						}
					}
					for(int i=0;i<GameServer.iparr.length;i++) {
						if(GameServer.iparr[i]!=null) {
							BufferedWriter bww = new BufferedWriter(new OutputStreamWriter(GameServer.iparr[i].getOutputStream()));
							System.out.println("뿌리기");
							if(GameServer.usercount==1) {
								bww.write(GameServer.usercount+"/"+user+"\n");
								bww.flush();
							}else {
								bww.write(GameServer.usercount+"/"+user+"\n");
								bww.flush();
							}
							
						}
					}
					GameServer.users=GameServer.usercount;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}