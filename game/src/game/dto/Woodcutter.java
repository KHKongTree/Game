package game.dto;

public class Woodcutter {

	private static int hp = 100; // 체력
	private static int Strike = 5;

	
	public static int getHp() {
		return hp;
	}

	public static void setHp(int hp) {
		Woodcutter.hp = hp;
	}
	public static int getStrike() {
		return Strike;
	}
	public static void setStrike(int striking) {
		Strike = striking;
	}
	
}

