package login.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Random;

class Hwtoopae implements Runnable {
	ServerSocket serversocket;
	int i;
	Random random;

	public Hwtoopae(ServerSocket serversocket, int i) {
		this.serversocket = serversocket;
		this.i = i;
	}

	@Override
	public void run() {
		try {
			Socket socket = serversocket.accept();
			Random random = new Random();
			GameServer.hwtoopaeip[i] = socket;
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			try {
				while (true) {
					String msg = br.readLine();
					if (msg.equals("게임시작")) {
						if (GameServer.h.size() > 0) {
							GameServer.h.removeAll(GameServer.h);
							GameServer.ing.removeAll(GameServer.ing);
						}
						GameServer.calcount = 0;
						GameServer.z = 0;
						GameServer.summoney = GameServer.usercount * 10000;
						GameServer.numberReset();
						int a = 0;

						for (int i = 0; i < 5; i++) {
							if (GameServer.hwtoopaeip[i] != null) {
								BufferedWriter bw = new BufferedWriter(
										new OutputStreamWriter(GameServer.hwtoopaeip[i].getOutputStream()));
								String s = "";
								for (int x = 0; x < 2; x++) {
									int num = GameServer.number.get(random.nextInt(GameServer.number.size()));
									s += (GameServer.list.get(num).getNum() + "/" + GameServer.list.get(num).getGty()
											+ "/");
									GameServer.number.remove(GameServer.number.indexOf(num));
								}
								String[] uh = new String[2];
								uh[0] = GameServer.namearr.get(a);
								uh[1] = s;
								GameServer.h.add(uh);
								GameServer.ing.add(uh[0]);

								bw.write("게임중/" + GameServer.namearr.get(a) + "/" + s + "\n");
								bw.flush();
								a++;
							}
						}

					}
				}
			} catch (SocketException e) {
				GameServer.hwtoopaeip[i] = null;
			}
		} catch (IOException e) {
			e.printStackTrace();
			GameServer.hwtoopaeip[i] = null;
		}

	}
}