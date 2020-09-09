package login.game;

import login.dao.HwtooPae;

public class GameCalculate {
	public int score;

	public int cal(HwtooPae a, HwtooPae b) {
		int x = a.getNum();
		int y = b.getNum();
		// 광땡
		if ((x == 3 && y == 8) || x == 8 && y == 3) { // 38광땡
			if (a.getGty().equals("광") && b.getGty().equals("광")) {
				score = 31;
				return score;
			} else { // 광땡이 아니면 1끗
				score = 2;
				return score;
			}
		}
		if ((x == 1 && y == 8) || x == 8 && y == 1) { // 18광땡
			if (a.getGty().equals("광") && b.getGty().equals("광")) {
				score = 30;
			} else {// 9끗(갑오)
				score = 10;
				return score;
			}
		}
		if ((x == 3 && y == 1) || x == 1 && y == 3) { // 13광땡
			if (a.getGty().equals("광") && b.getGty().equals("광")) {
				score = 29;
			} else { // 4끗
				score = 5;
				return score;
			}
		}
		if (x == 10 && y == 10) { // 장땡
			score = 28;
			return score;
		}
		if ((x == 3 && y == 7) || (x == 7 && y == 3)) { // 땡잡이
			score = 27;
			return score;
		}
		if (x == 9 && y == 9) { // 9땡
			score = 26;
			return score;
		}
		if (x == 8 && y == 8) { // 8땡
			score = 25;
			return score;
		}
		if (x == 7 && y == 7) { // 7땡
			score = 24;
			return score;
		}
		if (x == 6 && y == 6) { // 6땡
			score = 23;
			return score;
		}
		if (x == 5 && y == 5) { // 5땡
			score = 22;
			return score;
		}
		if (x == 4 && y == 4) { // 4땡
			score = 21;
			return score;
		}
		if (x == 3 && y == 3) { // 3땡
			score = 20;
			return score;
		}
		if (x == 2 && y == 2) { // 2땡
			score = 19;
			return score;
		}
		if (x == 1 && y == 1) { // 1땡
			score = 18;
			return score;
		}
		if ((x == 4 && y == 9) || (x == 9 && y == 4)) { // 49 재경기(땡 밑으로만)
			score = 17;
			return score;
		}
		if ((x == 1 && y == 2) || (x == 2 && y == 1)) { // 알리
			score = 16;
			return score;
		}
		if ((x == 1 && y == 4) || (x == 4 && y == 1)) { // 독사
			score = 15;
			return score;
		}
		if ((x == 1 && y == 9) || (x == 9 && y == 1)) { // 구삥
			score = 14;
			return score;
		}
		if ((x == 1 && y == 10) || (x == 10 && y == 1)) { // 장삥
			score = 13;
			return score;
		}
		if ((x == 4 && y == 10) || (x == 10 && y == 4)) { // 장사
			score = 12;
			return score;
		}
		if ((x == 4 && y == 6) || (x == 6 && y == 4)) { // 세륙
			score = 11;
			return score;
		}
		if ((x == 2 && y == 7) || (x == 7 && y == 2) || (x == 3 && y == 6) || (x == 6 && y == 3) || (x == 4 && y == 5)
				|| (x == 5 && y == 4) || (x == 10 && y == 9) || (x == 9 && y == 10) || (x == 8 && y == 1)
				|| (x == 1 && y == 8)) {// 9끗
			score = 10;
			return score;
		}
		if ((x == 1 && y == 7) || (x == 7 && y == 1) || (x == 2 && y == 6) || (x == 6 && y == 2) || (x == 3 && y == 5)
				|| (x == 5 && y == 3) || (x == 10 && y == 8) || (x == 8 && y == 10)) {// 8끗
			score = 9;
			return score;
		}
		if ((x == 1 && y == 6) || (x == 6 && y == 1) || (x == 2 && y == 5) || (x == 5 && y == 2) || (x == 3 && y == 4)
				|| (x == 4 && y == 3) || (x == 10 && y == 7) || (x == 7 && y == 10) || (x == 9 && y == 8)
				|| (x == 8 && y == 9)) {// 7끗
			score = 8;
			return score;
		}
		if ((x == 1 && y == 5) || (x == 5 && y == 1) || (x == 2 && y == 4) || (x == 4 && y == 2) || (x == 10 && y == 6)
				|| (x == 6 && y == 10) || (x == 9 && y == 7) || (x == 7 && y == 9)) {// 6끗
			score = 7;
			return score;
		}
		if ((x == 2 && y == 3) || (x == 3 && y == 2) || (x == 10 && y == 5) || (x == 5 && y == 10) || (x == 9 && y == 6)
				|| (x == 6 && y == 9) || (x == 8 && y == 7) || (x == 7 && y == 8)) {// 5끗
			score = 6;
			return score;
		}
		if ((x == 10 && y == 4) || (x == 4 && y == 10) || (x == 9 && y == 5) || (x == 5 && y == 9) || (x == 8 && y == 6)
				|| (x == 6 && y == 8) || (x == 1 && y == 3) || (x == 3 && y == 1)) {// 4끗
			score = 5;
			return score;
		}
		if ((x == 10 && y == 3) || (x == 3 && y == 10) || (x == 8 && y == 5) || (x == 5 && y == 8) || (x == 7 && y == 6)
				|| (x == 6 && y == 7)) {// 3끗
			score = 4;
			return score;
		}
		if ((x == 10 && y == 2) || (x == 2 && y == 10) || (x == 9 && y == 3) || (x == 3 && y == 9) || (x == 8 && y == 4)
				|| (x == 4 && y == 8) || (x == 7 && y == 5) || (x == 5 && y == 7)) {// 2끗
			score = 3;
			return score;
		}
		if ((x == 9 && y == 2) || (x == 2 && y == 9) || (x == 8 && y == 3) || (x == 3 && y == 8) || (x == 7 && y == 4)
				|| (x == 4 && y == 7) || (x == 6 && y == 5) || (x == 5 && y == 6)) {// 1끗
			score = 2;
			return score;
		}
		if ((x == 2 && y == 8) || (x == 8 && y == 2)) {// 망통
			score = 1;
			return score;
		}
		return score;
	}
}
