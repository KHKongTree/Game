package game.service;

import game.dto.Hero;
import game.dto.Item;
import game.view.GameView;

public class GameService {
	public static Hero signUp(String userId, String userPw, String userPwConfirm) {

		Hero user = null;
		
		if (userPw.equals(userPwConfirm)) {

			user = new Hero(userId, userPw);
		}

		return user;

	}

	public void login(String userId, String userPw, Hero signUpUser) {

		boolean idCheck = userId.equals(signUpUser.getUserId());

		boolean pwCheck = userPw.equals(signUpUser.getUserPw());

		if (idCheck && pwCheck) {

			GameView.loginUser = signUpUser;
		}
	}

	public boolean isLoginCheck() {
		
		return false;
	}

	public boolean buyWeapon(String weapon, int price, int exStrike) {
		
		if (GameView.loginUser.getGold() >= price) {
			GameView.loginUser.setWeapon(weapon);
			GameView.loginUser.setGold(GameView.loginUser.getGold()-price);
			
			GameView.loginUser.setStrike(exStrike);
			return true;
		} else {
			return false;
		}
		
	}
	
	public boolean buyItem(int price) {
		
		if (GameView.loginUser.getGold() >= price) {
			GameView.loginUser.setGold(GameView.loginUser.getGold()-price);
			return true;
		} else {
			return false;
		}
		
	}

}
