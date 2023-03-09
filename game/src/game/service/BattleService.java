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
		for (int i = 0; i < me.getHp() / 10; i++) {
			myHP += "♣";
		}
		for (int i = 0; i < 10 - (me.getHp() / 10); i++) {
			myHP += "♧";
		}
		
		if(me.getHp() < 10) {
			myHP = "♥♧♧♧♧♧♧♧♧♧";
		}

		for (int i = 0; i < enemy.getHp() / 10; i++) {
			enemyHP += "♣";
		}
		for (int i = 0; i < 10 - (enemy.getHp() / 10); i++) {
			enemyHP += "♧";
		}
		if(enemy.getHp() < 10) {
			enemyHP = "♥♧♧♧♧♧♧♧♧♧";
		}
		
	}
	
	public static void attack() {
		int damage = (random.nextInt(me.getStrike()) + 2);
		int damaged = (random.nextInt(enemy.getStrike()) + 1);

		me.setHp(me.getHp() - damaged);
		enemy.setHp(enemy.getHp() - damage);

		str1 = String.format("잭이 %s로 %d의 데미지를 주었습니다", me.getWeapon(), damage);
		str2 = String.format("나무꾼의 공격으로 %d의 데미지를 입었습니다", damaged);

	}

	public static void healing() {

		int healing = random.nextInt(me.getStrike() / 2) + 1;
		int damaged = random.nextInt(enemy.getStrike()) + 1;

		me.setHp(me.getHp() + healing);
		me.setHp(me.getHp() - damaged);

		str1 = String.format("잭은 방어를 하여 %d를 회복하였습니다.", healing);
		str2 = String.format("나무꾼의 공격으로 %d의 데미지를 입었습니다.", damaged);

	}

	public static void run() {

		me.setHp(-1000);

	}

	public static void result() {

		if (me.getHp() >= 0) {
			str1 = String.format("[나무꾼이 쓰러졌습니다. 100골드를 획득했습니다.]");
			me.setGold(me.getGold() + 100);
			str2 = String.format("총 골드 : %d", me.getGold());
			UserState.setHp(100);
			Woodcutter.setHp(100);
			myHP = "♣♣♣♣♣♣♣♣♣♣";
			enemyHP = "♣♣♣♣♣♣♣♣♣♣";

		} else if (me.getHp() == -1000) {
			str1 = String.format("[나무꾼에게 도망쳤습니다. 나무꾼이 콩나무를 베어갑니다.]");
			me.setTreeHeight(me.getTreeHeight() - me.getTreeHeight() / 10);
			str2 = String.format("현재 콩나무 길이 : %.1f , 베어간 길이: %.2fm", me.getTreeHeight(), me.getTreeHeight() / 10);
			UserState.setHp(100);
			Woodcutter.setHp(100);
			myHP = "♣♣♣♣♣♣♣♣♣♣";
			enemyHP = "♣♣♣♣♣♣♣♣♣♣";

		} else {
			str1 = String.format("[나무꾼에게 졌습니다. 나무꾼이 콩나무를 베어갑니다.]");
			me.setTreeHeight(me.getTreeHeight() - me.getTreeHeight() / 5);
			str2 = String.format("현재 콩나무 길이 : %.1f , 베어간 길이: %.2fm", me.getTreeHeight(), me.getTreeHeight() / 5);
			UserState.setHp(100);
			Woodcutter.setHp(100);
			myHP = "♣♣♣♣♣♣♣♣♣♣";
			enemyHP = "♣♣♣♣♣♣♣♣♣♣";
		}

	}
	
	

}
