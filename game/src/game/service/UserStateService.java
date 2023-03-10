package game.service;

public class UserStateService extends Service{  // Service 를 상속받아 객체 사용 가능 ex) meAndTree, item 등
	
	public boolean buyWeapon(String weapon, int price, int exStrike) {  // 상점(Store)에서 쓸 메서드

		if (meAndTree.getGold() >= price) {
			meAndTree.setWeapon(weapon);
			meAndTree.setGold(meAndTree.getGold() - price);
			meAndTree.setStrike(exStrike);
			return true;
		} else {
			return false;
		}

	}

	public boolean buyItem(int price) {   // 상점(Store)에서 쓸 메서드

		if (meAndTree.getGold() >= price) {
			meAndTree.setGold(meAndTree.getGold() - price);
			return true;
		} else {
			return false;
		}

	}
}
