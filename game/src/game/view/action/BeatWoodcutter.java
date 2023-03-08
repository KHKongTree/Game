package game.view.action;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import game.dto.Hero;
import game.dto.Tree;
import game.dto.Woodcutter;

public class BeatWoodcutter {
	Scanner sc = new Scanner(System.in);
	Random random = new Random();
	Hero me = new Hero();
	Woodcutter enemy = new Woodcutter();
	Tree tree = new Tree();
	public void beatWoodCutter() {
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
	
}
