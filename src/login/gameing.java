package login;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import login.dao.HwtooPae;
import login.game.GameCalculate;
import login.game.Pae;
import login.loginservice.LoginImpl;
import login.tcp.GameServer;

class gameing implements Runnable {
	TextField[] users;
	TextField[] moneys;
	TextField summoney;
	Button bstart,bdie,bcal,bgo;
	BufferedReader br;
	ImageView[] image;
	public gameing(TextField[] users, TextField[] moneys, TextField summoney ,Button bstart, BufferedReader br, ImageView[] image,Button bdie,Button bcal,Button bgo) {
		this.users=users;
		this.moneys=moneys;
		this.summoney=summoney;
		this.bstart=bstart;
		this.br=br;
		this.image=image;
		this.bdie=bdie;
		this.bcal=bcal;
		this.bgo=bgo;
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				String msg = br.readLine();
				System.out.println(msg);
				String[] cut = msg.split("/");
				for(int i=0;i<5;i++) {
					if (users[i].getText().equals(cut[1])) {
						summoney.setText(cut[0]);
						users[i].setText(cut[1]);
						moneys[i].setText(cut[2]);
					}
				}
//				cut[0] + "/" + cut[1] + "/" + cut[2] + "게임종료/" + GameServer.ing.get(GameServer.z)+ "/"+u+"/\n"
				if(cut[3].equals("게임준비")) {
					Platform.runLater(new Runnable() {
						public void run() {
							bstart.setText("게임준비");
						}
					});
					image[0].setImage(new Image(getClass().getResourceAsStream("/login/game/png/0.png")));
                    image[1].setImage(new Image(getClass().getResourceAsStream("/login/game/png/0.png")));
                    image[2].setImage(new Image(getClass().getResourceAsStream("/login/game/png/0.png")));
                    image[3].setImage(new Image(getClass().getResourceAsStream("/login/game/png/0.png")));
                    image[4].setImage(new Image(getClass().getResourceAsStream("/login/game/png/0.png")));
                    image[5].setImage(new Image(getClass().getResourceAsStream("/login/game/png/0.png")));
                    image[6].setImage(new Image(getClass().getResourceAsStream("/login/game/png/0.png")));
                    image[7].setImage(new Image(getClass().getResourceAsStream("/login/game/png/0.png")));
                    image[8].setImage(new Image(getClass().getResourceAsStream("/login/game/png/0.png")));
                    image[9].setImage(new Image(getClass().getResourceAsStream("/login/game/png/0.png")));
					Pae p = new Pae();
					
					for(int i=5;i<cut.length;i++) {
						System.out.println("aaa");
						for(int x=0;x<5;x++) {
							if(users[x].getText().equals(cut[i])) {
								System.out.println("bbb");
								if(x+1==1) {
									HwtooPae hwtoo1 = new HwtooPae();
				                    hwtoo1.setNum(Integer.valueOf(cut[i+1]));
				                    hwtoo1.setGty(cut[i+2]);
				                	HwtooPae hwtoo2 = new HwtooPae();
				                    hwtoo2.setNum(Integer.valueOf(cut[i+3]));
				                    hwtoo2.setGty(cut[i+4]);
					                image[0].setImage(new Image(getClass().getResourceAsStream(p.image(hwtoo1))));
					                image[1].setImage(new Image(getClass().getResourceAsStream(p.image(hwtoo2))));
								}
								else if (x+1 == 2) {
									HwtooPae hwtoo1 = new HwtooPae();
				                    hwtoo1.setNum(Integer.valueOf(cut[i+1]));
				                    hwtoo1.setGty(cut[i+2]);
				                	HwtooPae hwtoo2 = new HwtooPae();
				                    hwtoo2.setNum(Integer.valueOf(cut[i+3]));
				                    hwtoo2.setGty(cut[i+4]);
					                image[2].setImage(new Image(getClass().getResourceAsStream(p.image(hwtoo1))));
					                image[3].setImage(new Image(getClass().getResourceAsStream(p.image(hwtoo2))));
								}
								else if (x+1 == 3) {
									HwtooPae hwtoo1 = new HwtooPae();
				                    hwtoo1.setNum(Integer.valueOf(cut[i+1]));
				                    hwtoo1.setGty(cut[i+2]);
				                	HwtooPae hwtoo2 = new HwtooPae();
				                    hwtoo2.setNum(Integer.valueOf(cut[i+3]));
				                    hwtoo2.setGty(cut[i+4]);
					                image[4].setImage(new Image(getClass().getResourceAsStream(p.image(hwtoo1))));
					                image[5].setImage(new Image(getClass().getResourceAsStream(p.image(hwtoo2))));
								}
								else if (x+1 == 4) {
									HwtooPae hwtoo1 = new HwtooPae();
				                    hwtoo1.setNum(Integer.valueOf(cut[i+1]));
				                    hwtoo1.setGty(cut[i+2]);
				                	HwtooPae hwtoo2 = new HwtooPae();
				                    hwtoo2.setNum(Integer.valueOf(cut[i+3]));
				                    hwtoo2.setGty(cut[i+4]);
					                image[6].setImage(new Image(getClass().getResourceAsStream(p.image(hwtoo1))));
					                image[7].setImage(new Image(getClass().getResourceAsStream(p.image(hwtoo2))));
								}
								else if (x+1 == 5) {
									HwtooPae hwtoo1 = new HwtooPae();
				                    hwtoo1.setNum(Integer.valueOf(cut[i+1]));
				                    hwtoo1.setGty(cut[i+2]);
				                	HwtooPae hwtoo2 = new HwtooPae();
				                    hwtoo2.setNum(Integer.valueOf(cut[i+3]));
				                    hwtoo2.setGty(cut[i+4]);
					                image[8].setImage(new Image(getClass().getResourceAsStream(p.image(hwtoo1))));
					                image[9].setImage(new Image(getClass().getResourceAsStream(p.image(hwtoo2))));
								}
								
							}
						}
						i+=4;
					}
//					"0/" + cut[1] + "/" + cut[2]+"/"+z + "/" + r + "/" + u + "\n"
//					for(int i=0;i<5;i++) {
//						if(users[i].getText().equals(cut[4])) {
//							summoney.setText(cut[0]);
//							users[i].setText(cut[1]);
//							moneys[i].setText(cut[2]);
//							break;
//						}
//					}
				}else if(cut[3].equals("게임종료")) {
					ArrayList<String> n = new ArrayList<String>();
					ArrayList<Integer> s = new ArrayList<Integer>();
					for(int i=5;i<cut.length;i++) {
						GameCalculate gc = new GameCalculate();
						HwtooPae hwtoo1 = new HwtooPae();
	                    hwtoo1.setNum(Integer.valueOf(cut[i+1]));
	                    hwtoo1.setGty(cut[i+2]);
	                	HwtooPae hwtoo2 = new HwtooPae();
	                    hwtoo2.setNum(Integer.valueOf(cut[i+3]));
	                    hwtoo2.setGty(cut[i+4]);
						s.add(gc.cal(hwtoo1, hwtoo2));
						n.add(cut[i]);
						i+=4;
					}
					String r = win(n,s);
					System.out.println(r);
					
					try {
						for(int i=0;i<5;i++) {
							if(users[i].getText().equals(r)) {
								moneys[i].setText(Integer.valueOf(summoney.getText())+Integer.valueOf(moneys[i].getText())+"");
								BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(Main.socket_money.getOutputStream()));
								bw.write("0/"+r+"/"+moneys[i].getText()+"/종료\n");
								bw.flush();
							}
						}
						
					} catch (IOException e) {
						e.printStackTrace();
					}
				}else {
					
					bdie.setDisable(true);
					bcal.setDisable(true);
					bgo.setDisable(true);
					
//					cut[0] + "/" + cut[1] + "/" + cut[2] + "게임종료/" + GameServer.ing.get(GameServer.z)+ "/\n"
//					for(int i=0;i<5;i++) {
//						if (users[i].getText().equals(cut[1])) {
//							summoney.setText(cut[0]);
//							users[i].setText(cut[1]);
//							moneys[i].setText(cut[2]);
//						}
//					}
					System.out.println(cut[4]+" : "+users[0].getText());
					if (cut[4].equals(users[0].getText())) {
						bdie.setDisable(false);
						bcal.setDisable(false);
						bgo.setDisable(false);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String win(ArrayList<String> n,ArrayList<Integer> s) {
		int win[] = new int[s.size()]; // 각 패들의 점수 저장할 배열
		String winn[] = new String[s.size()];
		
		for (int i = 0; i < win.length; i++) { // 각각의 점수 cal메서드 호출로 계산 후 배열에 대입
			win[i] = s.get(i);
			winn[i] = n.get(i);
		}

		for (int i = 0; i < win.length; i++) { // 땡잡이 점수 판별
			if (win[i] == 27) { // 땡잡이가 있는 경우
				for (int j = 0; j < win.length; j++) {
					if (win[j] < 18 || win[j] > 26) { // 땡이 없는 경우 점수 1점
						win[i] = 1;
					} else {
						break;
					}
				}
			}
		}
		// 점수 배열 복사
		int winCopy[] = new int[s.size()];
		String winnCopy[] = new String[n.size()];
		for (int i = 0; i < win.length; i++) { // 각각의 점수 cal메서드 호출로 계산 후 배열에 대입
			winCopy[i] = win[i];
			winnCopy[i] = winn[i];
		}
//		// 각 점수 출력
//		for (int i = 0; i < winCopy.length; i++) {
//			System.out.println(GameServer.ing.get(i) + "번 점수 : " + winCopy[i]);
//		}
		int alt = 0; // 크기비교 후 삼항대입할 변수
		String altn="";
		for (int i = 1; i < win.length; i++) { // 삼항대입으로 가장큰 값을
			if (winCopy[i] > winCopy[0]) { // win[0] 으로 옮긴다
				alt = winCopy[i];
				winCopy[i] = winCopy[0];
				winCopy[0] = alt;
				altn = winnCopy[i];
				winnCopy[i] = winnCopy[0];
				winnCopy[0] = altn;
			}
		}
		for (int i = 1; i < winCopy.length; i++) {
			if (winCopy[0] == winCopy[i]) { // 가장 큰값 win[0]과 같은 값이 배열에 있다면
				Con_Game.wining.add(winnCopy[0]);
			}
			if (Con_Game.wining.size() > 0)
				return "재경기";
		}

//		System.out.println("==========");
//		System.out.println("1등 user" + GameServer.ing.get(first) + "의 점수 : " + winCopy[0]);
		System.out.println("승자 : "+winnCopy[0]);
		return winnCopy[0];

	}
}