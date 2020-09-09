package login.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.sql.SQLException;

class Money implements Runnable{
	ServerSocket serversocket;
	int i;
	public Money(ServerSocket serversocket,int i) {
		this.serversocket=serversocket;
		this.i=i;
	}
	
	@Override
	public void run() {
		try {
			Socket socket = serversocket.accept();
			GameServer.moneyip[i]=socket;
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			try {
				while(true) {
					String msg = br.readLine();
					String[] cut = msg.split("/");
//					System.out.println(msg);	//넘어온 msg확인
					System.out.println("Money`s cut[1] : "+cut[1]+"value cut[2] : "+Integer.valueOf(cut[2]));
					GameServer.db.updateUser(cut[1], Integer.valueOf(cut[2]));
					if(cut[3].equals("콜")) {
						GameServer.calcount++;
						GameServer.z++;
						if(GameServer.ing.size()<=GameServer.z) {
							GameServer.z=0;
						}
					}else if(cut[3].equals("다이")) {
						for(int i=0;i<GameServer.h.size();i++) {
							if(GameServer.h.get(i)[0].equals(cut[1])) {
								GameServer.h.remove(i);
								GameServer.ing.remove(i);
							}
						}
						GameServer.z++;
						if(GameServer.ing.size()<=GameServer.z) {
							GameServer.z=0;
						}
						
					}else if(cut[3].equals("질러")) {
						GameServer.calcount = 1;	//레이스가 눌리면 count 1로 초기화
						GameServer.z++;
						if(GameServer.ing.size()<=GameServer.z) {
							GameServer.z=0;
						}
					}else {
						GameServer.z++;
						System.out.println("머니1 : "+GameServer.z);
						if(GameServer.ing.size()<=GameServer.z) {
							GameServer.z=0;
							System.out.println("머니2 : "+GameServer.z);
						}
					}
					System.out.println("머니3 : "+GameServer.z);
					Thread t = new Thread(new Out(msg));
					t.start();
				}
			} catch (SocketException e) {
				GameServer.moneyip[i]=null;
			} catch (NumberFormatException e) {
				e.printStackTrace();
				GameServer.moneyip[i]=null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
			GameServer.moneyip[i]=null;
		}
		
	}
}