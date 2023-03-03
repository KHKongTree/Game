package game.service;

import game.dto.Hero;
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


}
