package game.view.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import game.dto.Item;
import game.dto.Tree;
import game.service.GameService;
import game.view.GameView;

public class GameMenu1 {
	
	Scanner sc = new Scanner(System.in);
	
	public void Menu() {

		int input = -1;
		System.out.println(
				"[♣Kong Tree♣]\n잭에겐 어머니의 유품인 씨앗 하나가 있었고,\n심자마자 잭의 키를 넘길 만큼 커져버렸다.\n소문을 들은 마을 사람들은 이 나무를 탐내게 되는데....\n");

		do {
			try {
				System.out.println("1. 회원가입");
				System.out.println("2. 로그인");
				System.out.println("0. 프로그램 종료");

				System.out.print("메뉴 선택 : ");
				input = sc.nextInt();

				System.out.println();

				switch (input) {
				case 1:
					this.signUp();
					break;
				case 2:
					this.login();
					break;
				case 0:
					System.out.println("프로그램을 종료합니다.");
					break;
				default:
					System.out.println("잘못 입력 하셨습니다.");

				}
			} catch (InputMismatchException e) {
				System.out.println("[잘못된 형식의 입력입니다.]");
				sc.nextLine(); // 입력 버퍼에 잘못 입력된 내용 제거
				input = -1; // 반복문이 종료 되는 것을 방지
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
    	

    	signUpUser = GameService.signUp(userId, userPw, userPwConfirm);

    	tree = new Tree();
    	item = new Item();
    	
    	
    	if(signUpUser != null) {
    		
    		System.out.println("회원 가입 완료");
    	} else {
    		System.out.println("비밀번호가 일치하지 않습니다");
    	}
    	
    }
    
	private boolean login() {
		
		System.out.println("--- 로그인 ---");

		if (signUpUser == null) {
			System.out.println("회원 가입 후 진행해주세요.");
			return false;
		}

		System.out.print("ID : ");
		String userId = sc.next();

		System.out.print("Pw : ");
		String userPw = sc.next();


		GameService gameService = new GameService();
		gameService.login(userId, userPw, signUpUser);


		if (GameView.loginUser != null) {
			System.out.printf("환영합니다. %s님", userId);
			menu2();
			return true;

		} else {
			System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
			return false;
		}
		
	}
	
}
