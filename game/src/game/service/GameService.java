package game.service;

import java.util.Set;

import javax.management.monitor.MonitorSettingException;

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

	public boolean isLoginCheck() {
		return false;
		
	}


	public double Tree(Double treeHeight) {
	
		GameView.tree.setTreeHeight(treeHeight+5.0);
		
		return  GameView.tree.getTreeHeight();
	}
	
	public void branchCut() {
		
	}
	
	public void useItem() {
		
	}
}
