package game.view;

import java.util.Scanner;

import game.dto.Hero;
import game.dto.Item;
import game.service.GameService;

public class GameView {
	
	Scanner sc = new Scanner(System.in);
	
	private GameService service = new GameService();
	
	private Hero signUpUser;
	
	public static Hero loginUser = null;
	
	public static Item item;
	
    public void Menu() {
    	
       int input = 0;
       System.out.println("[♣Kong Tree♣]\n잭에겐 어머니의 유품인 씨앗 하나가 있었고,\n심자마자 잭의 키를 넘길 만큼 커져버렸다.\n소문을 들은 마을 사람들은 이 나무를 탐내게 되는데....\n");
       
       do {
    	   System.out.println("1. 회원가입");
    	   System.out.println("2. 로그인");
    	   System.out.println("0. 프로그램 종료");
    	   
    	   System.out.print("메뉴 선택 : ");
    	   input = sc.nextInt();
    	   
    	   System.out.println();
    	   
    	   switch(input) {
    	   case 1 : this.signUp(); break;
    	   case 2 : if(this.login()) { 
    	   				menu2();
    	   			}
    	   			break;
    	   case 0 : System.out.println("프로그램을 종료합니다."); break;
    	   default : System.out.println("잘못 입력 하셨습니다.");
    	   
    	   
    	   }
    	   System.out.println();
        } while (input != 0);

	}
    
    private void menu2() {
    	store();
    	
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
    	item = new Item();
    	
    	if(signUpUser != null) {
    		
    		System.out.println("회원 가입 완료");
    	} else {
    		System.out.println("비밀번호가 일치하지 않습니다");
    	}
    	
    }
    
	private boolean login() {
		
		System.out.println("--- 로그인 ---");
		
		if(signUpUser == null) {
			System.out.println("회원 가입 후 진행해주세요.");
			return false;
		}
		
		System.out.print("ID : ");
		String userId = sc.next();
		
		System.out.print("Pw : ");
		String userPw = sc.next();
		
		
		GameService gameService = new GameService();
		gameService.login(userId, userPw, signUpUser);
		
		
		if(GameView.loginUser !=null) {
			System.out.println("환영합니다.");
			return true;
			
		} else {
			System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
			return false;
		}
		
	}
	
	private void store() {
		
		System.out.println("[아이템 상점]");
		
		int input = 0;
		do {
			System.out.println();
			System.out.println("내가 가지고 있는 골드 : " + signUpUser.getGold());
			
			System.out.println("1. 동도끼 (100G)");
			System.out.println("2. 은도끼 (200G)");
			System.out.println("3. 금도끼 (300G)");
			System.out.println("4. 비료 (50G)");
			System.out.println("5. 물약 (100G)");
			System.out.println("6. 해충제 (80G)");
			System.out.println("7. 가위 (20G)");
			System.out.println("0. 상점 나가기");
			
			System.out.print("메뉴 선택 : ");
			input = sc.nextInt();
			
			switch (input) {
			case 1: 
				successBuyWeapon(item.getBronzeExe(), item.getBronzeExePrice(), item.getBronzeExeStriking());
				break;
			case 2:
				successBuyWeapon(item.getSilverExe(), item.getSilverExePrice(), item.getSilverExeStriking());
				break;
			case 3:
				successBuyWeapon(item.getGoldExe(), item.getGoldExePrice(), item.getGoldExeStrinking());
				break;
				
			case 4:
				item.setFertiliserCount(item.getFertiliserCount()+successBuyItem(item.getFertiliser(), item.getFertiliserPrice()));
				break;
			case 5:
				item.setPotionCount(item.getPotionCount()+successBuyItem(item.getPotion(), item.getPotionPrice()));
				break;
			case 6:
				item.setBugKillerCount(item.getBugKillerCount()+successBuyItem(item.getBugKiller(), item.getPotionPrice()));
				break;
			case 7:
				item.setScissorCount(item.getScissorCount()+successBuyItem(item.getScissor(), item.getScissorPrice()));
				break;
			case 0: break;
			}
			
		} while (input != 0);
		
	}
	
	private void successBuyWeapon(String item, int price, int exStrike) {
		
		if(service.buyWeapon(item, price, exStrike)) System.out.printf("%s를 획득했습니다.\n", item);
		else System.out.println("소지한 골드가 부족합니다.\n");
		
	}
	
	private int successBuyItem(String item, int price) {
		
		if(service.buyItem(price)) {
			System.out.printf("%s를 획득했습니다.\n", item);
			return 1;
		}
		else {
			System.out.println("소지한 골드가 부족합니다.\n");
			return 0;
		}
		
	}
	
}
