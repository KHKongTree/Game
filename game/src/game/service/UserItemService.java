package game.service;

import game.dto.UserState;

public class UserItemService {
	
	UserState me = new UserState();
	public static String str = "";
	
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
	
	public static void successBuyWeapon(String item, int price, int exStrike) {

		if (UserItemService.buyWeapon(item, price, exStrike)) {
			str = String.format("%s를 획득했습니다.\n", item);
		} else {
			str = String.format("소지한 골드가 부족합니다.\n");
		}
	}

	public int successBuyItem(String item, int price) {

		if (UserItemService.buyItem(price)) {
			str = String.format("%s를 획득했습니다.\n", item);
			return 1;
		} else {
			str = String.format("소지한 골드가 부족합니다.\n");
			return 0;
		}
	}
	
}
