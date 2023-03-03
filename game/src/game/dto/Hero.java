package game.dto;

import java.util.ArrayList;

public class Hero {
	private int hp = 100; // 체력
	private int gold = 1000; // 골드
	private String userId;  // 아이디
	private String userPw;  // 비밀번호
	private String userPwConfirm;  // 비밀번호 확인
	private String weapon = "나뭇가지"; // 무기
	private int strike = 5; // 공격력

	
	public Hero() {}

	
	
	public Hero(String userId, String userPw) {
		this.userId = userId;
		this.userPw = userPw;
	}



	public Hero(int hp, int gold, String userId, String userPw, String userPwConfirm, String weapon) {
		super();
		this.hp = hp;
		this.gold = gold;
		this.userId = userId;
		this.userPw = userPw;
		this.userPwConfirm = userPwConfirm;
		this.setWeapon(weapon);
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserPwConfirm() {
		return userPwConfirm;
	}
	
	public String getWeapon() {
		return weapon;
	}


	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}

	public void setUserPwConfirm(String userPwConfirm) {
		this.userPwConfirm = userPwConfirm;
	}

	public String getWeapon() {
		return weapon;
	}

	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}

	public int getStrike() {
		return strike;
	}

	public void setStrike(int strike) {
		this.strike = strike;
	}
  
	public String toString() {
		return String.format("%s / %s ", userId, userPw);
		

}
	
	}

