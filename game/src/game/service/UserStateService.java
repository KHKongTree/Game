package game.service;

import game.dto.UserState;

public class UserStateService {
	
	UserState me = new UserState();
	
	public static boolean buyWeapon(String weapon, int price, int exStrike) {

		if (UserState.getGold() >= price) {
			UserState.setWeapon(weapon);
			UserState.setGold(UserState.getGold() - price);
			UserState.setStrike(exStrike);
			return true;
		} else {
			return false;
		}

	}

	public static boolean buyItem(int price) {

		if (UserState.getGold() >= price) {
			UserState.setGold(UserState.getGold() - price);
			return true;
		} else {
			return false;
		}

	}
}
