package login.tcp;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import login.dao.HwtooPae;
import login.game.GameCalculate;

class Out implements Runnable {
	String msg;

	public Out(String msg) {
		this.msg = msg;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			if (GameServer.moneyip[i] != null) {
				String[] cut = msg.split("/");
				try {
					BufferedWriter bw = new BufferedWriter(
							new OutputStreamWriter(GameServer.moneyip[i].getOutputStream()));
					if(cut[3].equals("종료")) {
						String u = "";
						for (int x = 0; x < GameServer.h.size(); x++) {
							String[] ht = GameServer.h.get(x)[1].split("/");
//							System.out.println(GameServer.h.get(x)[0] + " : " + ht[0] + ht[1] + ht[2] + ht[3]);
							HwtooPae hwtoo1 = new HwtooPae();
							hwtoo1.setNum(Integer.valueOf(ht[0]));
							hwtoo1.setGty(ht[1]);
							HwtooPae hwtoo2 = new HwtooPae();
							hwtoo2.setNum(Integer.valueOf(ht[2]));
							hwtoo2.setGty(ht[3]);
							u += GameServer.h.get(x)[0] + "/" + GameServer.h.get(x)[1];
						}
						bw.write(cut[0] + "/" + cut[1] + "/" + cut[2] + "/게임준비/" + GameServer.ing.get(GameServer.z)+  "/"+u+"/\n");
						bw.flush();
					}
					else if (GameServer.calcount == GameServer.ing.size() || GameServer.ing.size() == 1) {
						String u = "";
						for (int x = 0; x < GameServer.h.size(); x++) {
							String[] ht = GameServer.h.get(x)[1].split("/");
//							System.out.println(GameServer.h.get(x)[0] + " : " + ht[0] + ht[1] + ht[2] + ht[3]);
							HwtooPae hwtoo1 = new HwtooPae();
							hwtoo1.setNum(Integer.valueOf(ht[0]));
							hwtoo1.setGty(ht[1]);
							HwtooPae hwtoo2 = new HwtooPae();
							hwtoo2.setNum(Integer.valueOf(ht[2]));
							hwtoo2.setGty(ht[3]);
							u += GameServer.h.get(x)[0] + "/" + GameServer.h.get(x)[1];
						}
						System.out.println(u);
						bw.write(cut[0] + "/" + cut[1] + "/" + cut[2] + "/게임종료/" + GameServer.ing.get(GameServer.z)+ "/"+u+"/\n");
						bw.flush();
					} else {
//						System.out.println(GameServer.z);
						bw.write(cut[0] + "/" + cut[1] + "/" + cut[2] + "/게임중/" + GameServer.ing.get(GameServer.z)+ "/\n");
						bw.flush();
					}
				} catch (IOException | NumberFormatException e) {
					e.printStackTrace();
				}
			}
		}
	}


}