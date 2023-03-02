package game.view;

import java.util.Scanner;

import game.dto.Hero;
import game.service.GameService;

public class GameView {
	
	Scanner sc = new Scanner(System.in);
	
	private GameService service = new GameService();
	
	private Hero signUpUser;
	
	public static Hero loginUser = null;
	
    public void Menu() {
    	
       int input = 0;
       
       do {
    	   System.out.println("1. 회원가입");
    	   System.out.println("2. 로그인");
    	   
    	   System.out.print("메뉴 선택 : ");
    	   input = sc.nextInt();
    	   
    	   System.out.println();
    	   
    	   switch(input) {
    	   case 1 : this.signUp(); break;
    	   case 2 : this.login(); break;
    	   default : System.out.println("잘못 입력 하셨습니다.");
    	   
    	   
    	   }
    	   System.out.println();
        } while (input != 0);
    }
    
    private void signUp() {
    	System.out.println("--- 회원 가입 ---");
    	
    	System.out.print("ID : ");
    	String userId = sc.next();
    	
    	System.out.print("Pw : ");
    	String userPw = sc.next();
    	
    	System.out.print("Pw 확인 : ");
    	String userPwConfirm = sc.next();
    	
    	System.out.print("나무 이름 : ");
    	String userName = sc.next();
    	
    	signUpUser = GameService.signUp(userId, userPw, userPwConfirm, userName);
    	
    	if(signUpUser != null) {
    		
    		System.out.println("회원 가입 완료");
    	} else {
    		System.out.println("비밀번호가 일치하지 않습니다");
    	}
    	
    }
    
	private void login() {
		
		System.out.println("--- 로그인 ---");
		
		if(signUpUser == null) {
			System.out.println("회원 가입 후 진행해주세요.");
			return;
		}
		
		System.out.print("ID : ");
		String userId = sc.next();
		
		System.out.print("Pw : ");
		String userPw = sc.next();
		
		
		GameService gameService = new GameService();
		gameService.login(userId, userPw, signUpUser);
		
		
		if(GameView.loginUser !=null) {
			System.out.println(GameView.loginUser.getUserName() + "님 환영합니다. ");
			
		} else {
			System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
		}
		
	}
	
    
    
    
    
}
