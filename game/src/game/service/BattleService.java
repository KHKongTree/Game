package game.service;

import java.util.Random;
import java.util.Scanner;

import game.dto.UserState;
import game.dto.Woodcutter;

public class BattleService {

	Scanner sc = new Scanner(System.in);
	static Random random = new Random();
	// 외부 툴

	static UserState me = new UserState();
	static Woodcutter enemy = new Woodcutter();
	// 나와 적
	
	public static String myHP = "♣♣♣♣♣♣♣♣♣♣";
	public static String enemyHP = "♣♣♣♣♣♣♣♣♣♣";
	
	public static String str1 = "";
	public static String str2 = "";
	
	public static String getMyHP() {
		return myHP;
	}

	public static void setMyHP(String myHP) {
		BattleService.myHP = myHP;
	}

	public static String getEnemyHP() {
		return enemyHP;
	}

	public static void setEnemyHP(String enemyHP) {
		BattleService.enemyHP = enemyHP;
	}
	
	public static void stateHP() {
		myHP = "";
		enemyHP = "";
		for (int i = 0; i < UserState.getHp() / 10; i++) {
			myHP += "♣";
		}
		for (int i = 0; i < 10 - (UserState.getHp() / 10); i++) {
			myHP += "♧";
		}
		
		if(UserState.getHp() < 10) {
			myHP = "♥♧♧♧♧♧♧♧♧♧";
		}

		for (int i = 0; i < Woodcutter.getHp() / 10; i++) {
			enemyHP += "♣";
		}
		for (int i = 0; i < 10 - (Woodcutter.getHp() / 10); i++) {
			enemyHP += "♧";
		}
		if(Woodcutter.getHp() < 10) {
			enemyHP = "♥♧♧♧♧♧♧♧♧♧";
		}
		
	}
	
	public static void attack() {
		int damage = (random.nextInt(UserState.getStrike()) + 2);
		int damaged = (random.nextInt(Woodcutter.getStrike()) + 1);

		UserState.setHp(UserState.getHp() - damaged);
		Woodcutter.setHp(Woodcutter.getHp() - damage);

		str1 = String.format("잭이 %s로 %d의 데미지를 주었습니다", UserState.getWeapon(), damage);
		str2 = String.format("나무꾼의 공격으로 %d의 데미지를 입었습니다", damaged);

	}

	public static void healing() {

		int healing = random.nextInt(UserState.getStrike() / 2) + 1;
		int damaged = random.nextInt(Woodcutter.getStrike()) + 1;

		UserState.setHp(UserState.getHp() + healing);
		UserState.setHp(UserState.getHp() - damaged);

		str1 = String.format("잭은 방어를 하여 %d를 회복하였습니다.", healing);
		str2 = String.format("나무꾼의 공격으로 %d의 데미지를 입었습니다.", damaged);

	}

	public static void run() {

		UserState.setHp(-1000);

	}

	public static void result() {

		if (UserState.getHp() >= 0) {
			str1 = String.format("[나무꾼이 쓰러졌습니다. 100골드를 획득했습니다.]");
			UserState.setGold(UserState.getGold() + 100);
			str2 = String.format("총 골드 : %d", UserState.getGold());
			UserState.setHp(100);
			Woodcutter.setHp(100);
			myHP = "♣♣♣♣♣♣♣♣♣♣";
			enemyHP = "♣♣♣♣♣♣♣♣♣♣";

		} else if (UserState.getHp() == -1000) {
			str1 = String.format("[나무꾼에게 도망쳤습니다. 나무꾼이 콩나무를 베어갑니다.]");
			UserState.setTreeHeight(UserState.getTreeHeight() - UserState.getTreeHeight() / 10);
			str2 = String.format("현재 콩나무 길이 : %.1f , 베어간 길이: %.2fm", UserState.getTreeHeight(), UserState.getTreeHeight() / 10);
			UserState.setHp(100);
			Woodcutter.setHp(100);
			myHP = "♣♣♣♣♣♣♣♣♣♣";
			enemyHP = "♣♣♣♣♣♣♣♣♣♣";

		} else {
			str1 = String.format("[나무꾼에게 졌습니다. 나무꾼이 콩나무를 베어갑니다.]");
			UserState.setTreeHeight(UserState.getTreeHeight() - UserState.getTreeHeight() / 5);
			str2 = String.format("현재 콩나무 길이 : %.1f , 베어간 길이: %.2fm", UserState.getTreeHeight(), UserState.getTreeHeight() / 5);
			UserState.setHp(100);
			Woodcutter.setHp(100);
			myHP = "♣♣♣♣♣♣♣♣♣♣";
			enemyHP = "♣♣♣♣♣♣♣♣♣♣";
		}

	}
	
	

}
