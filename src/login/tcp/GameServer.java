package login.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import login.dao.Database;
import login.dao.HwtooPae;

public class GameServer {
	static Thread[] arr = new Thread[5];
	static Socket[] iparr = new Socket[5];
	static ArrayList<String> namearr = new ArrayList<String>();
	static Database db = new Database();
	static int usercount;
	static int users;
	static ArrayList<String> ing = new ArrayList<String>();
	static ArrayList<String[]> h=new ArrayList<String[]>();
	static int ingcount;
	
	static int z;
	
	
	static Thread[] moneyarr = new Thread[5];
	static Socket[] moneyip = new Socket[5];
	static int summoney;
	static int calcount = 0;
	
	static Thread[] hwtoopaearr = new Thread[5];
	static Socket[] hwtoopaeip = new Socket[5];
	
	static Thread[] id_charr = new Thread[5];
	
	
	static HashMap<Integer, HwtooPae> list;
	static ArrayList<Integer> number = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException {
		numberReset();
		try {
			list = db.bringPae();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			ServerSocket server = new ServerSocket(12345);
			ServerSocket money = new ServerSocket(10000);
			ServerSocket hwtoopae = new ServerSocket(13000);
			ServerSocket id_ch = new ServerSocket(20000);
			
			
			for(int i=0;i<5;i++) {
				if(arr[i]==null) {
					arr[i] = new Thread(new Server(server,i));
					moneyarr[i] = new Thread(new Money(money,i));
					hwtoopaearr[i] = new Thread(new Hwtoopae(hwtoopae,i));
					id_charr[i] = new Thread(new Id_ch(id_ch,i));
					id_charr[i].start();
					hwtoopaearr[i].start();
					moneyarr[i].start();
					arr[i].start();
					
				}
				if(i==4)
					i=-1;
			}
		} catch (IOException e) {
			System.out.println("연결끊김");
			e.printStackTrace();
		}
	}
	public static void numberReset() {
		number.removeAll(number);
		for(int i=0;i<20;i++) {
			number.add(i+1);
		}
	}
}

