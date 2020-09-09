package login.game;

import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import login.common.CommonImpl;
import login.dao.Database;
import login.dao.HwtooPae;
import login.game.GameCalculate;

public class Pae implements Initializable {
	Parent root;
	GameCalculate gc;
	@FXML ImageView pae1;
	@FXML ImageView pae2;
	@FXML ImageView pae3;
	@FXML ImageView pae4;
	@FXML ImageView pae5;
	@FXML ImageView pae6;
	@FXML ImageView pae7;
	@FXML ImageView pae8;
	@FXML ImageView pae9;
	@FXML ImageView pae10;
	@FXML Button bdie;
	@FXML Button bcal;
	@FXML Button bgo;
	Pae p;
	static HwtooPae[][] test;
	HashMap<Integer, HwtooPae> list = null;
	Database db;

	public void setPae(Parent root) {
		this.root = root;
	}

	public void die() {
//		pae9.setImage(new Image(getClass().getResourceAsStream("/login/game/png/0.png")));
//		pae10.setImage(new Image(getClass().getResourceAsStream("/login/game/png/0.png")));
		bdie.setDisable(true);
		bcal.setDisable(true);
		bgo.setDisable(true);
	}

	public void cal() {
		if (test != null) {
			pae1.setImage(new Image(getClass().getResourceAsStream(p.image(test[0][0]))));
			pae2.setImage(new Image(getClass().getResourceAsStream(p.image(test[0][1]))));
			pae3.setImage(new Image(getClass().getResourceAsStream(p.image(test[1][0]))));
			pae4.setImage(new Image(getClass().getResourceAsStream(p.image(test[1][1]))));
			pae5.setImage(new Image(getClass().getResourceAsStream(p.image(test[2][0]))));
			pae6.setImage(new Image(getClass().getResourceAsStream(p.image(test[2][1]))));
			pae7.setImage(new Image(getClass().getResourceAsStream(p.image(test[3][0]))));
			pae8.setImage(new Image(getClass().getResourceAsStream(p.image(test[3][1]))));
			pae9.setImage(new Image(getClass().getResourceAsStream(p.image(test[4][0]))));
			pae10.setImage(new Image(getClass().getResourceAsStream(p.image(test[4][1]))));
		} else {
			CommonImpl ci = new CommonImpl();
			ci.alert("게임준비를 누르세요");
		}
	}

	public void go() {
		
	}

	public void start() {
		bdie.setDisable(false);
		bcal.setDisable(false);
		bgo.setDisable(false);
		test = arr();
		pae1.setImage(new Image(getClass().getResourceAsStream("/login/game/png/0.png")));
		pae2.setImage(new Image(getClass().getResourceAsStream("/login/game/png/0.png")));
		pae3.setImage(new Image(getClass().getResourceAsStream("/login/game/png/0.png")));
		pae4.setImage(new Image(getClass().getResourceAsStream("/login/game/png/0.png")));
		pae5.setImage(new Image(getClass().getResourceAsStream("/login/game/png/0.png")));
		pae6.setImage(new Image(getClass().getResourceAsStream("/login/game/png/0.png")));
		pae7.setImage(new Image(getClass().getResourceAsStream("/login/game/png/0.png")));
		pae8.setImage(new Image(getClass().getResourceAsStream("/login/game/png/0.png")));
		pae9.setImage(new Image(getClass().getResourceAsStream(p.image(test[4][0]))));
		pae10.setImage(new Image(getClass().getResourceAsStream(p.image(test[4][1]))));
		win(test);
	}

	public HwtooPae[][] arr() {
		try {
			list = db.bringPae();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		int x = 0; // 랜덤값 변수
		test = new HwtooPae[5][2];
		for (int i = 0; i < test.length; i++) { // 랜덤으로 패 나누어주기
			for (int j = 0; j < 2; j++) {
				x = ((int) (Math.random() * 20)) + 1;
				if (list.get(x) != null) { // 준 패는 저장한 map에서 삭제
					test[i][j] = list.get(x);
					list.remove(x);
				} else { // 이미 뽑혀나간 값은 다시 뽑아야 하므로
					j -= 1; // j값을 하나 줄여서 다시 for문을 돌린다
					continue;
				}
			}
		}
//		for (int i = 0; i < test.length; i++) {	//나눠준 패 목록 출력
//			System.out.print("나눠준 패 " + (i + 1) + ": ");
//			for (int j = 0; j < 2; j++) {
//				System.out.print(test[i][j].toString() + "\t");
//			}
//			System.out.println();
//		}
		return test;
	}
	
	public void win(HwtooPae[][] test) {
		int win[] = new int[5]; // 각 패들의 점수 저장할 배열
		int alt = 0; // 크기비교 후 삼항대입할 변수
		for (int i = 0; i < win.length; i++) { // 각각의 점수 cal메서드 호출로 계산 후 배열에 대입
			win[i] = gc.cal(test[i][0], test[i][1]);
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
		int winCopy[] = new int[5];
		for (int i = 0; i < win.length; i++) { // 각각의 점수 cal메서드 호출로 계산 후 배열에 대입
			winCopy[i] = win[i];
		}
		// 각 점수 출력
		for (int i = 0; i < win.length; i++) {
			System.out.println((i + 1) + "번 점수 : " + win[i]);
		}

		for (int i = 1; i < win.length; i++) { // 삼항대입으로 가장큰 값을
			if (win[i] > win[0]) { // win[0] 으로 옮긴다
				alt = win[i];
				win[i] = win[0];
				win[0] = alt;
			}
		}
		int c = 0; // 가장 큰값 중복 여부 판단 변수
		for (int i = 0; i < win.length - 1; i++) {
			if (win[0] == win[i + 1]) { // 가장 큰값 win[0]과 같은 값이 배열에 있다면
				c += 1; // c +1을 해줌
				break;
			}
		}
		int first = 0; // 1등 user
		for (int i = 0; i < win.length; i++) {
			if (win[0] == winCopy[i]) {
				first = i + 1;
			}
		}

		if (c > 0) { // c가 0보다 크다면 가장 큰 값 중복, 재경기
			System.out.println("==========");
			System.out.println("재경기!!!");
		} else { // c가 0이라면 가장 큰 값 중복X 승자
			if(win[0]==17) {
				System.out.println("==========");
				System.out.println("재경기!!!");
			} else {
				System.out.println("==========");
				System.out.println("1등 user" + first + "의 점수 : " + win[0]);
			}
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		p = new Pae();
		gc = new GameCalculate();
		db = new Database();
	}

	public String image(HwtooPae p) {
		String msg = null;
		if (p.getNum() == 1 && p.getGty().equals("광")) {
			msg = "/login/game/png/1_1.png";
		}
		if (p.getNum() == 1 && p.getGty().equals("띠")) {
			msg = "/login/game/png/1_2.png";
		}
		if (p.getNum() == 2 && p.getGty().equals("열")) {
			msg = "/login/game/png/2_1.png";
		}
		if (p.getNum() == 2 && p.getGty().equals("띠")) {
			msg = "/login/game/png/2_2.png";
		}
		if (p.getNum() == 3 && p.getGty().equals("광")) {
			msg = "/login/game/png/3_1.png";
		}
		if (p.getNum() == 3 && p.getGty().equals("띠")) {
			msg = "/login/game/png/3_2.png";
		}
		if (p.getNum() == 4 && p.getGty().equals("열")) {
			msg = "/login/game/png/4_1.png";
		}
		if (p.getNum() == 4 && p.getGty().equals("띠")) {
			msg = "/login/game/png/4_2.png";
		}
		if (p.getNum() == 5 && p.getGty().equals("열")) {
			msg = "/login/game/png/5_1.png";
		}
		if (p.getNum() == 5 && p.getGty().equals("띠")) {
			msg = "/login/game/png/5_2.png";
		}
		if (p.getNum() == 6 && p.getGty().equals("열")) {
			msg = "/login/game/png/6_1.png";
		}
		if (p.getNum() == 6 && p.getGty().equals("띠")) {
			msg = "/login/game/png/6_2.png";
		}
		if (p.getNum() == 7 && p.getGty().equals("열")) {
			msg = "/login/game/png/7_1.png";
		}
		if (p.getNum() == 7 && p.getGty().equals("띠")) {
			msg = "/login/game/png/7_2.png";
		}
		if (p.getNum() == 8 && p.getGty().equals("광")) {
			msg = "/login/game/png/8_1.png";
		}
		if (p.getNum() == 8 && p.getGty().equals("열")) {
			msg = "/login/game/png/8_2.png";
		}
		if (p.getNum() == 9 && p.getGty().equals("열")) {
			msg = "/login/game/png/9_1.png";
		}
		if (p.getNum() == 9 && p.getGty().equals("띠")) {
			msg = "/login/game/png/9_2.png";
		}
		if (p.getNum() == 10 && p.getGty().equals("열")) {
			msg = "/login/game/png/10_1.png";
		}
		if (p.getNum() == 10 && p.getGty().equals("띠")) {
			msg = "/login/game/png/10_2.png";
		}
		return msg;
	}

}
