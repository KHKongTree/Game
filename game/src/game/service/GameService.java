package game.service;

import game.dto.Hero;
import game.view.GameView;

public class GameService {
	public static Hero signUp(String userId, String userPw, String userPwConfirm,
	           String userName) {

Hero user = null;

if(userPw.equals(userPwConfirm) ) {
	
	user = new Hero(userId, userPw, userName);
}


return user;


}

public void login(String userId, String userPw, Hero signUpUser) {

boolean idCheck = userId.equals( signUpUser.getUserId());

boolean pwCheck = userPw.equals( signUpUser.getUserPw());

if(idCheck && pwCheck) {

GameView.loginUser = signUpUser;		
}
}

public boolean userUpdate(String userName, String userPw) {

if( !GameView.loginUser.getUserPw().equals(userPw) ) {

return false;
} 

GameView.loginUser.setUserName(userName);

return true;
}
}
