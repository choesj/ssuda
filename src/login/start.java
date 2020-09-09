package login;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.SocketException;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import login.dao.HwtooPae;
import login.game.Pae;
import login.loginservice.LoginImpl;

class start implements Runnable{
	TextField[] users;
	TextField[] moneys;
	BufferedReader br;
	BufferedWriter bw;
	Button bstart;
	TextField summoney;
	ImageView[] image;
	public start(TextField[] users,TextField[] moneys,BufferedReader br,BufferedWriter bw,Button bstart,TextField summoney, ImageView[] image) {
		this.users=users;
		this.moneys=moneys;
		this.br=br;
		this.bw=bw;
		this.bstart=bstart;
		this.summoney=summoney;
		this.image=image;
	}
	
	@Override
	public void run() {
		try {
			try {
				while(true) {
					String msg = br.readLine();
					System.out.println(msg);
					String[] cut = msg.split("/");
					
					int z=0;
					for(int i=0;i<5;i++) {
						if(!users[i].getText().equals("user"))
							z++;
					}
					if(cut[0].equals("게임중")) {
						bstart.setDisable(true);
						Platform.runLater(new Runnable() {
							public void run() {
								bstart.setText("게임중");
							}
						});
						for(int i=0;i<5;i++) {
							if(users[i].getText().equals(cut[1])) {
								HwtooPae hwtoo1 = new HwtooPae();
			                    hwtoo1.setNum(Integer.valueOf(cut[2]));
			                    hwtoo1.setGty(cut[3]);
			                    HwtooPae hwtoo2 = new HwtooPae();
			                    hwtoo2.setNum(Integer.valueOf(cut[4]));
			                    hwtoo2.setGty(cut[5]);
			                    Pae p = new Pae();
			                    image[0].setImage(new Image(getClass().getResourceAsStream(p.image(hwtoo1))));
			                    image[1].setImage(new Image(getClass().getResourceAsStream(p.image(hwtoo2))));
			                    image[2].setImage(new Image(getClass().getResourceAsStream("/login/game/png/0.png")));
			                    image[3].setImage(new Image(getClass().getResourceAsStream("/login/game/png/0.png")));
			                    image[4].setImage(new Image(getClass().getResourceAsStream("/login/game/png/0.png")));
			                    image[5].setImage(new Image(getClass().getResourceAsStream("/login/game/png/0.png")));
			                    image[6].setImage(new Image(getClass().getResourceAsStream("/login/game/png/0.png")));
			                    image[7].setImage(new Image(getClass().getResourceAsStream("/login/game/png/0.png")));
			                    image[8].setImage(new Image(getClass().getResourceAsStream("/login/game/png/0.png")));
			                    image[9].setImage(new Image(getClass().getResourceAsStream("/login/game/png/0.png")));
			                    
								moneys[i].setText(""+(Integer.valueOf(moneys[i].getText())-10000));
								summoney.setText(""+(z*10000));
//								System.out.println(LoginImpl.name+"/"+moneys[i].getText()+"/시작");
								bw.write(summoney.getText()+"/"+LoginImpl.name+"/"+moneys[i].getText()+"/시작\n");
								bw.flush();
							}
						}
					}
				}
			} catch (SocketException e) {
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}