package login.game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import login.Con_Game;
import login.Main;
import login.loginservice.LoginImpl;

public class GameImpl implements Game{
	BufferedWriter bw;
//	static int cal = 10000;
	BufferedReader br;
	@Override
	public void cal(Parent root) {
		try {
			TextField money3 = (TextField) root.lookup("#money3");
			money3.setText(""+(Integer.valueOf(money3.getText())-Con_Game.cal));
			TextField summoney = (TextField) root.lookup("#summoney");
			summoney.setText(""+(Integer.valueOf(summoney.getText())+Con_Game.cal));
//			System.out.println("aa");
			bw = new BufferedWriter(new OutputStreamWriter(Main.socket_money.getOutputStream()));
			bw.write(summoney.getText()+"/"+LoginImpl.name+"/"+money3.getText()+"/콜\n");
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void die(Parent root) {
		Button bdie = (Button)root.lookup("#bdie");
		Button bgo = (Button)root.lookup("#bdie");
		Button bcal = (Button)root.lookup("#bdie");
		TextField money3 = (TextField) root.lookup("#money3");
		TextField summoney = (TextField) root.lookup("#summoney");
		bdie.setDisable(true);
		bcal.setDisable(true);
		bgo.setDisable(true);
		try {
			bw = new BufferedWriter(new OutputStreamWriter(Main.socket_money.getOutputStream()));
			bw.write(summoney.getText()+"/"+LoginImpl.name+"/"+money3.getText()+"/다이\n");
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void go(Parent root) {
		
		Con_Game.cal = Con_Game.cal*2;
		TextField money3 = (TextField) root.lookup("#money3");
		money3.setText(""+(Integer.valueOf(money3.getText())-Con_Game.cal));
		TextField summoney = (TextField) root.lookup("#summoney");
		summoney.setText(""+(Integer.valueOf(summoney.getText())+Con_Game.cal));
		try {
			bw = new BufferedWriter(new OutputStreamWriter(Main.socket_money.getOutputStream()));
			bw.write(summoney.getText()+"/"+LoginImpl.name+"/"+money3.getText()+"/질러\n");
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void start(Parent root) {
		try {
			BufferedWriter bww = new BufferedWriter(new OutputStreamWriter(Main.socket_hwtoopae.getOutputStream()));
			bww.write("게임시작"+"\n");
			bww.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
