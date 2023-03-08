package game.view;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import game.dto.Hero;
import game.dto.Tree;
import game.dto.Woodcutter;
import game.dto.Item;

import game.service.GameService;

public class GameView {

	Scanner sc = new Scanner(System.in);
	Random random = new Random();
	private GameService service = new GameService();

	private Hero signUpUser;

	public static Hero loginUser = null;
	Woodcutter enemy = new Woodcutter();
	public static Tree tree = new Tree();
	public static Item item;
	int day = 0;

	private void beatWoodCutter() {
		

		System.out.println("[나무꾼을 이겨라!]");
		while(signUpUser.getHp() >= 0 && enemy.getHp() >= 0) {
			
			int input = -1;
			do {
				System.out.printf("%4s : "," 잭");
				
				for(int i = 0; i < signUpUser.getHp()/10 ; i ++) {
					System.out.print("♣");
				}
				for(int i = 0; i < 10 - (signUpUser.getHp()/10) ; i ++) {
					System.out.print("♧");
				}
				
				System.out.printf("(%d/100)", signUpUser.getHp());
				
				
				System.out.println();
				
				System.out.printf("%4s : ", "나무꾼");
				
				for(int i = 0; i < enemy.getHp()/10 ; i ++) {
					System.out.print("♣");
				}
				for(int i = 0; i < 10 - (enemy.getHp()/10) ; i ++) {
					System.out.print("♧");
				}
				
				System.out.printf("(%d/100)", enemy.getHp());
				
				System.out.println();
				try {
					System.out.println("1. 공격");
					System.out.println("2. 회복");
					System.out.println("3. 도망치기");

					System.out.print("행동 선택 : ");
					input = sc.nextInt();

					System.out.println();
						
					//gameservice service로 인스턴스 만듦
					
					switch (input) {
					case 1:
						attack();
						break;
					case 2:
						healing();
						break;
					case 3:
						run();
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
			} while (signUpUser.getHp() >= 0 && enemy.getHp() >= 0);
			

		}
		
		if(signUpUser.getHp() >= 0) {
			System.out.println("[나무꾼이 쓰러졌습니다. 100골드를 획득했습니다.]");
			signUpUser.setGold(signUpUser.getGold() + 100);
			System.out.printf("총 골드 : %d", signUpUser.getGold() );
			signUpUser.setHp(100);
			enemy.setHp(100);
			
		}else if (signUpUser.getHp() == -1000) {
			System.out.println("[나무꾼에게 도망쳤습니다. 나무꾼이 콩나무를 베어갑니다.]");
			tree.setTreeHeight(tree.getTreeHeight() - tree.getTreeHeight()/10);
			System.out.printf("현재 콩나무 길이 : %.1f , 베어간 길이: %.2fm", tree.getTreeHeight(), tree.getTreeHeight()/10);
			signUpUser.setHp(100);
			enemy.setHp(100);
		
		}else { 
			System.out.println("[나무꾼에게 졌습니다. 나무꾼이 콩나무를 베어갑니다.]");
			tree.setTreeHeight(tree.getTreeHeight() - tree.getTreeHeight()/5);
			System.out.printf("현재 콩나무 길이 : %.1f , 베어간 길이: %.2fm", tree.getTreeHeight(), tree.getTreeHeight()/5);
			signUpUser.setHp(100);
			enemy.setHp(100);
		}
		
		day++;
	}

	/// 전투 액션 3개
	
	private void attack() {
		int damage = (random.nextInt(signUpUser.getStrike()) + 2);
		int damaged = (random.nextInt(enemy.getStrike()) + 1);
		
		signUpUser.setHp(signUpUser.getHp()- damaged);
		enemy.setHp(enemy.getHp() - damage);
		
		
		System.out.printf("잭이 %s로 %d의 데미지를 주었습니다\n", signUpUser.getWeapon() , damage);
		System.out.printf("나무꾼의 공격으로 %d의 데미지를 입었습니다", damaged);
		
	}


	private void healing() {
		
		int healing = random.nextInt(signUpUser.getStrike() / 2) + 1;
		int damaged = random.nextInt(enemy.getStrike()) + 1;
		
		signUpUser.setHp(signUpUser.getHp() + healing);
		signUpUser.setHp(signUpUser.getHp() - damaged);
		
		System.out.printf("잭은 방어를 하여 %d를 회복하였습니다.\n", healing);
		System.out.printf("나무꾼의 공격으로 %d의 데미지를 입었습니다.", damaged);
		
	}

	
	private void run() {
		
		signUpUser.setHp(-1000);
		

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
	
    private void display() {
    	System.out.println("정보 확인");

    	
    	System.out.println("HP : " + loginUser.getHp());
    	System.out.println("골드 : " + loginUser.getGold());
    	System.out.println("무기 : " + loginUser.getWeapon());
    	System.out.println("나무 길이 : "+ tree.getTreeHeight());

    }

}
