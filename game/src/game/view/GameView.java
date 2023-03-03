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

	Hero me = new Hero();
	Woodcutter enemy = new Woodcutter();
	Tree tree = new Tree();
	public static Item item;
	int day = 0;
	
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

	private void menu2() {
		int input = -1;
		day++;
		
		do {
			try {
				System.out.println("======♣Kong Tree♣======");
				System.out.println("1. 나무 돌보기");
				System.out.println("2. 나무꾼을 이겨라");
				System.out.println("3. 상점");
				System.out.println("4. 내 정보");
				System.out.println("5. 콩나무 포기하기");

				System.out.print("메뉴 선택 : ");
				input = sc.nextInt();

				System.out.println();

				switch (input) {
				case 1:
					break;
				case 2:
					beatWoodCutter();
					break;
				case 3:
					store();
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

	private void beatWoodCutter() {
		

		System.out.println("[나무꾼을 이겨라!]");
		while(me.getHp() >= 0 && enemy.getHp() >= 0) {
			
			int input = -1;
			do {
				System.out.printf("%4s : "," 잭");
				
				for(int i = 0; i < me.getHp()/10 ; i ++) {
					System.out.print("♣");
				}
				for(int i = 0; i < 10 - (me.getHp()/10) ; i ++) {
					System.out.print("♧");
				}
				
				System.out.printf("(%d/100)", me.getHp());
				
				
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
			} while (me.getHp() >= 0 && enemy.getHp() >= 0);
			

		}
		
		if(me.getHp() >= 0) {
			System.out.println("[나무꾼이 쓰러졌습니다. 100골드를 획득했습니다.]");
			me.setGold(me.getGold() + 100);
			System.out.printf("총 골드 : %d", me.getGold() );
			me.setHp(100);
			enemy.setHp(100);
			
		}else if (me.getHp() == -1000) {
			System.out.println("[나무꾼에게 도망쳤습니다. 나무꾼이 콩나무를 베어갑니다.]");
			tree.setTreeHeight(tree.getTreeHeight() - tree.getTreeHeight()/10);
			System.out.printf("현재 콩나무 길이 : %.1f , 베어간 길이: %.2fm", tree.getTreeHeight(), tree.getTreeHeight()/10);
			me.setHp(100);
			enemy.setHp(100);
		
		}else { 
			System.out.println("[나무꾼에게 졌습니다. 나무꾼이 콩나무를 베어갑니다.]");
			tree.setTreeHeight(tree.getTreeHeight() - tree.getTreeHeight()/5);
			System.out.printf("현재 콩나무 길이 : %.1f , 베어간 길이: %.2fm", tree.getTreeHeight(), tree.getTreeHeight()/5);
			me.setHp(100);
			enemy.setHp(100);
		}
		
		day++;
	}

	/// 전투 액션 3개
	
	private void attack() {
		int damage = (random.nextInt(me.getStrike()) + 2);
		int damaged = (random.nextInt(enemy.getStrike()) + 1);
		
		me.setHp(me.getHp()- damaged);
		enemy.setHp(enemy.getHp() - damage);
		
		
		System.out.printf("잭이 %s로 %d의 데미지를 주었습니다\n", me.getWeapon() , damage);
		System.out.printf("나무꾼의 공격으로 %d의 데미지를 입었습니다", damaged);
		
	}


	private void healing() {
		
		int healing = random.nextInt(me.getStrike() / 2) + 1;
		int damaged = random.nextInt(enemy.getStrike()) + 1;
		
		me.setHp(me.getHp() + healing);
		me.setHp(me.getHp() - damaged);
		
		System.out.printf("잭은 방어를 하여 %d를 회복하였습니다.\n", healing);
		System.out.printf("나무꾼의 공격으로 %d의 데미지를 입었습니다.", damaged);
		
	}

	
	private void run() {
		
		me.setHp(-1000);
		

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
