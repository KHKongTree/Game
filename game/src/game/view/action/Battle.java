package game.view.action;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import game.dto.UserState;
import game.dto.Woodcutter;
import game.service.Service;

public class Battle {
	Service service = new Service();  // Service 클래스 내 객체를 받아오기 위함
	Scanner sc = new Scanner(System.in);
	Random random = new Random();
	// 외부 툴
	
	UserState me = service.getMeAndTree();
	Woodcutter enemy = new Woodcutter();
	// 나와 적
	
	
	public void menu() {
		System.out.println("[나무꾼을 이겨라!]");
		while(me.getHp() >= 0 && enemy.getHp() >= 0) {
			
			int input = -1;
			do {
				
				// 잭의 체력바
				{
					
				System.out.printf("%4s : "," 잭");
				
				for(int i = 0; i < me.getHp()/10 ; i ++) { // i == 채워진 클로버의 개수  
					System.out.print("♣");
				}
				for(int i = 0; i < 10 - (me.getHp()/10) ; i ++) { // i == (10(클로버 개수의 최대치) -채워진 클로버)의 개수 
					System.out.print("♧");
				}
				
				System.out.printf("(%d/100)", me.getHp());
				}
				
				
				System.out.println();
				
				
				// 나무꾼 체력바
				{
					
				System.out.printf("%4s : ", "나무꾼");
				
				for(int i = 0; i < enemy.getHp()/10 ; i ++) {
					System.out.print("♣");
				}
				for(int i = 0; i < 10 - (enemy.getHp()/10) ; i ++) {
					System.out.print("♧");
				}
				
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
			// 사용자의 체력과 적의 체력이 true일떄 switch(게임)문이 반복된다. 사용자 또는 적의 체력이 0이되면, while문 종료.
		}
		
		// 게임이 끝났을 때 
		
		if(me.getHp() >= 0) { // 내가 이겼을 때
			System.out.println("[나무꾼이 쓰러졌습니다. 100골드를 획득했습니다.]");
			me.setGold(me.getGold() + 100);
			System.out.printf("총 골드 : %d", me.getGold() );
			me.setHp(100); // 게임이 종료가 되었을 때 사용자 또는 적의 hp가 0으로 세팅이 되어 있기때문에 100으로 hp를 재설정 해준다.
			enemy.setHp(100); // hp를 재설정 하지 않았을 경우에는 게임이 재실행 될 때 0값으로 시작되고, 결과값이 출력된다.
			
		}else if (me.getHp() == -1000) {// 내가 도망쳤을 때
			System.out.println("[나무꾼에게 도망쳤습니다. 나무꾼이 콩나무를 베어갑니다.]");
			me.setTreeHeight(me.getTreeHeight() - me.getTreeHeight()/10);
			System.out.printf("현재 콩나무 길이 : %dm , 베어간 길이: %dm", me.getTreeHeight(), me.getTreeHeight()/10);
			me.setHp(100);
			enemy.setHp(100);
		
		}else { // 내가 졌을 때
			System.out.println("[나무꾼에게 졌습니다. 나무꾼이 콩나무를 베어갑니다.]");
			me.setTreeHeight(me.getTreeHeight() - me.getTreeHeight()/5);
			System.out.printf("현재 콩나무 길이 : %dm , 베어간 길이: %dm", me.getTreeHeight(),me.getTreeHeight()/5);
			me.setHp(100);
			enemy.setHp(100);
		}
		
	}

	/// 전투 액션 3개
	
	private void attack() {
		int damage = (random.nextInt(me.getStrike()) + 2); // 공격할때의 최솟값을 2로 설정하고, 랜덤값(2~7)으로 공격한다. 랜덤값이 0이면 damage가 없기 때문에
		int damaged = (random.nextInt(enemy.getStrike()) + 1);// 공격받을때의 최솟값을 1로 설정, 랜덤값 (1~6)으로 데미지 수치
		
		
		me.setHp(me.getHp()- damaged);
		enemy.setHp(enemy.getHp() - damage);
		
		
		System.out.printf("잭이 %s로 %d의 데미지를 주었습니다\n", me.getWeapon() , damage);
		System.out.printf("나무꾼의 공격으로 %d의 데미지를 입었습니다", damaged);
		
	}
	
	private void healing() {
		
		int healing = random.nextInt(me.getStrike() / 2) + 1; 
		int damaged = random.nextInt(enemy.getStrike()) + 1;
		
		if(me.getHp() + healing > 100) {
			me.setHp(100);
		}else {
			me.setHp(me.getHp() + healing);
		}
		
		
		me.setHp(me.getHp() - damaged);
		
		System.out.printf("잭은 방어를 하여 %d를 회복하였습니다.\n", healing);
		System.out.printf("나무꾼의 공격으로 %d의 데미지를 입었습니다.", damaged);
		
	}

	
	private void run() {
		
		me.setHp(-1000);
		

	}
	
}
