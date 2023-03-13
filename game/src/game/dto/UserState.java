package game.dto;

public class UserState {

	private String userName = "잭";
	private int hp = 100; // 체력
	private static int gold = 100; // 골드
	private static String weapon = "나뭇가지"; // 무기
	private static int strike = 5; // 공격력
	//---------------------------------------------- ★ 잭의 정보

	private static int treeHeight = 5; // 길이
	private double growthrate = 1.0; // 성장 비율
	//---------------------------------------------- ★ 콩나무의 정보
	
	public UserState() {
	}
	//---------------------------------------------- ★ UserState 클래스의 기본 생성자
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public int getTreeHeight() {
		return treeHeight;
	}

	public void setTreeHeight(int treeHeight) {
		this.treeHeight = treeHeight;
	}

	public double getGrowthrate() {
		return growthrate;
	}

	public void setGrowthrate(double growthrate) {
		this.growthrate = growthrate;
	}
	//---------------------------------------------- ★ getter/setter 메서드
	@Override
	public String toString() {
		return "UserState [hp=" + hp + ", gold=" + gold + ", weapon=" + weapon + ", strike=" + strike + ", treeHeight="
				+ treeHeight + ", " + "growthrate=" + growthrate + "]";
	}
	//---------------------------------------------- ★ toString 오버라이딩
}
