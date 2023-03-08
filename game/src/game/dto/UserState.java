package game.dto;

import java.io.Serializable;

public class UserState implements Serializable{
	
	private String userName;
	private int hp = 100; // 체력
	private int gold = 1000; // 골드
	private String weapon = "나뭇가지"; // 무기
	private int strike = 5; // 공격력
	//잭의 정보
	
	private double treeHeight = 5.0; // 길이
	private double growthrate = 1.0; // 성장 비율
	//콩나무의 정보
	
	//잭과 콩나무의 초기값
	
	public UserState() {
	}

	public String getWeapon() {
		return weapon;
	}

	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getStrike() {
		return strike;
	}

	public void setStrike(int strike) {
		this.strike = strike;
	}

	public double getTreeHeight() {
		return treeHeight;
	}

	public void setTreeHeight(double treeHeight) {
		this.treeHeight = treeHeight;
	}

	public double getGrowthrate() {
		return growthrate;
	}

	public void setGrowthrate(double growthrate) {
		this.growthrate = growthrate;
	}

	@Override
	public String toString() {
		return "UserState [hp=" + hp + ", gold=" + gold 
				+ ", weapon=" + weapon + ", strike=" + strike 
				+ ", treeHeight=" + treeHeight + ", "
				+ "growthrate=" + growthrate + "]";
	}
	
	

}
