package game.dto;

public class Woodcutter {

	private static int hp = 100; // 체력
	private static int Strike = 5;

	
	public int getHp() {
		return hp;
	}

	public static void setHp(int hp) {
		Woodcutter.hp = hp;
	}
	public int getStrike() {
		return Strike;
	}
	public void setStrike(int striking) {
		Strike = striking;
	}
	
}

