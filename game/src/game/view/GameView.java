package game.view;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import game.dto.Hero;
import game.dto.Tree;
import game.dto.Woodcutter;
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
				System.out.printf("%4s : ","잭");
				
				for(int i = 0; i < me.getHp()/10 ; i ++) {
					System.out.print("♣");
				}
				for(int i = 0; i < 10 - (me.getHp()/10) ; i ++) {
					System.out.print("♧");
				}
				
				
				System.out.println();
				
				System.out.printf("%4s : ", "나무꾼");
				
				for(int i = 0; i < enemy.getHp()/10 ; i ++) {
					System.out.print("♣");
				}
				for(int i = 0; i < 10 - (enemy.getHp()/10) ; i ++) {
					System.out.print("♧");
				}
				
				
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
		}else if (me.getHp() == -1000) {
			System.out.println("[나무꾼에게 도망쳤습니다. 나무꾼이 콩나무를 베어갑니다.]");
			tree.setTreeHeight(tree.getTreeHeight() - 50);
			System.out.printf("현재 콩나무 길이 : %d , 베어간 길이: -50m", tree.getTreeHeight());
			me.setHp(100);
		}else { 
			System.out.println("[나무꾼에게 졌습니다. 나무꾼이 콩나무를 베어갑니다.]");
			tree.setTreeHeight(tree.getTreeHeight() - 80);
			System.out.printf("현재 콩나무 길이 : %d , 베어간 길이: -80m", tree.getTreeHeight());
			me.setHp(100);
		}
		
	}

	/// 전투 액션 3개
	
	private void attack() {
		int damage = (random.nextInt(me.getStriking()) + 1);
		int damaged = (random.nextInt(enemy.getStriking()) + 1);
		
		me.setHp(me.getHp()- damaged);
		enemy.setHp(enemy.getHp() - damage);
		
		
		System.out.printf("잭이 나뭇가지로 %d의 데미지를 주었습니다\n", damage);
		System.out.printf("나무꾼의 공격으로 %d의 데미지를 입었습니다", damaged);
		
	}

	private void healing() {
		
		int healing = random.nextInt(me.getStriking() / 2) + 1;
		int damaged = random.nextInt(enemy.getStriking()) + 1;
		
		me.setHp(me.getHp() + healing);
		me.setHp(me.getHp() - damaged);
		
		System.out.printf("잭은 방어를 하여 %d를 회복하였습니다.\n", healing);
		System.out.printf("나무꾼의 공격으로 %d의 데미지를 입었습니다.", damaged);
		
	}
	
	private void run() {
		
		me.setHp(-1000);
		
	}
	///

	
	
	private void signUp() {
		System.out.println("--- 회원 가입 ---");

		System.out.print("ID : ");
		String userId = sc.next();

		System.out.print("Pw : ");
		String userPw = sc.next();

		System.out.print("Pw 확인 : ");
		String userPwConfirm = sc.next();

		signUpUser = GameService.signUp(userId, userPw, userPwConfirm);

		if (signUpUser != null) {

			System.out.println("회원 가입 완료");
		} else {
			System.out.println("비밀번호가 일치하지 않습니다");
		}

	}

	private void login() {

		System.out.println("--- 로그인 ---");

		if (signUpUser == null) {
			System.out.println("회원 가입 후 진행해주세요.");
			return;
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

		} else {
			System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
		}

	}

}
