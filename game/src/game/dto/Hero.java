package game.dto;

import java.util.ArrayList;

public class Hero {
	private int hp = 100; // 체력
	private int gold = 0; // 골드
	private ArrayList weapon = new ArrayList(); // 무기
	
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
	
	public ArrayList getWeapon() {
		return weapon;
	}
	
	public void setWeapon(ArrayList weapon) {
		this.weapon = weapon;
	}

}