package game.dto;

import java.io.Serializable;

public class UserState implements Serializable {

	private static String userName = "잭";
	private static int hp = 100; // 체력
	private static int gold = 1000; // 골드
	private static String weapon = "나뭇가지"; // 무기
	private static int strike = 5; // 공격력
	// 잭의 정보

	private static double treeHeight = 5.0; // 길이
	private static double growthrate = 1.0; // 성장 비율
	// 콩나무의 정보
	

	public UserState() {
	}
	
	public static String getUserName() {
		return userName;
	}

	public static void setUserName(String userName) {
		UserState.userName = userName;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		UserState.hp = hp;
	}

	public static int getGold() {
		return gold;
	}

	public static void setGold(int gold) {
		UserState.gold = gold;
	}

	public static String getWeapon() {
		return weapon;
	}

	public static void setWeapon(String weapon) {
		UserState.weapon = weapon;
	}

	public static int getStrike() {
		return strike;
	}

	public static void setStrike(int strike) {
		UserState.strike = strike;
	}

	public static double getTreeHeight() {
		return treeHeight;
	}

	public static void setTreeHeight(double treeHeight) {
		UserState.treeHeight = treeHeight;
	}

	public static double getGrowthrate() {
		return growthrate;
	}

	public static void setGrowthrate(double growthrate) {
		UserState.growthrate = growthrate;
	}

	@Override
	public String toString() {
		return "UserState [hp=" + hp + ", gold=" + gold + ", weapon=" + weapon + ", strike=" + strike + ", treeHeight="
				+ treeHeight + ", " + "growthrate=" + growthrate + "]";
	}

}
