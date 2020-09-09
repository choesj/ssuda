package login;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import login.game.GameImpl;

public class Con_Game implements Initializable{
	@FXML TextField user3,user1,user2,user4,user5,money1,money2,money3,money4,money5,summoney;
	@FXML TextField pa3,pa1,pa2,pa4,pa5;
	@FXML Button bstart, bdie, bcal, bgo;
	@FXML ImageView pae1,pae2,pae3,pae4,pae5,pae6,pae7,pae8,pae9,pae10;
	Parent root;
	public static int cal = 10000;
	GameImpl gi;
	public static ArrayList<String> wining = new ArrayList<String>();
	public void setRoot(Parent root) {
		this.root=root;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		summoney.setText("0");
		gi = new GameImpl();
		bdie.setDisable(true);
		bcal.setDisable(true);
		bgo.setDisable(true);
		bstart.setDisable(true);
		TextField[] users = {user3,user1,user2,user4,user5};
		TextField[] moneys = {money3,money1,money2,money4,money5};
		TextField[] pas = {pa3,pa1,pa2,pa4,pa5};
		ImageView[] image = {pae9,pae10,pae1,pae2,pae5,pae6,pae7,pae8,pae3,pae4};
		
		try {
			BufferedReader br_main = new BufferedReader(new InputStreamReader(Main.socket_main.getInputStream()));
			Thread usert = new Thread(new Users(users,moneys,bstart,pas,br_main));
			usert.start();
			
			BufferedReader br_hwtoopae = new BufferedReader(new InputStreamReader(Main.socket_hwtoopae.getInputStream()));
			BufferedWriter bw_money = new BufferedWriter(new OutputStreamWriter(Main.socket_money.getOutputStream()));
			Thread start = new Thread(new start(users,moneys,br_hwtoopae,bw_money,bstart,summoney,image));
			start.start();
			
			BufferedReader br_money = new BufferedReader(new InputStreamReader(Main.socket_money.getInputStream()));
			Thread gameing = new Thread(new gameing(users,moneys,summoney,bstart,br_money,image,bdie, bcal, bgo));
			gameing.start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		bstart.textProperty().addListener((a,b,c) ->{
			if(bstart.getText().equals("게임준비")) {
				bdie.setDisable(true);
				bcal.setDisable(true);
				bgo.setDisable(true);
				if(pas[0].getText().equals("방장")) {
					bstart.setDisable(false);
				}
			}
			if(bstart.getText().equals("게임중")) {
				bstart.setDisable(true);
			}
		});
		
	}
	public void die() {
		gi.die(root);
	}
	public void cal() {
		gi.cal(root);
	}
	public void go() {
		gi.go(root);
	}
	public void start() {
		gi.start(root);
	}
	
	
}
