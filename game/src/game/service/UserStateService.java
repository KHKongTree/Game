package game.service;


public class UserStateService {
	public boolean buyWeapon(String weapon, int price, int exStrike) {

		if (GameView.loginUser.getGold() >= price) {
			GameView.loginUser.setWeapon(weapon);
			GameView.loginUser.setGold(GameView.loginUser.getGold() - price);

			GameView.loginUser.setStrike(exStrike);
			return true;
		} else {
			return false;
		}

	}

	public boolean buyItem(int price) {

		if (GameView.loginUser.getGold() >= price) {
			GameView.loginUser.setGold(GameView.loginUser.getGold() - price);
			return true;
		} else {
			return false;
		}

	}
}
