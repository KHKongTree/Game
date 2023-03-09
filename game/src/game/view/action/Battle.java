package game.view.action;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import game.dto.UserState;
import game.dto.Woodcutter;
import game.image.GameUI;
import game.service.BattleService;

public class Battle {

	BattleService battle = new BattleService();

	Scanner sc = new Scanner(System.in);
	Random random = new Random();
	// 외부 툴

	UserState me = new UserState();
	Woodcutter enemy = new Woodcutter();
	// 나와 적

	public void menu() {
		int input = -1;
		do {
			try {
				battle.stateHP();
				GameUI.battle();
				input = sc.nextInt();

				System.out.println();

				switch (input) {
				case 1:
					battle.attack();
					battle.stateHP();
					break;
				case 2:
					battle.healing();
					battle.stateHP();
					break;
				case 3:
					battle.run();
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
		BattleService.result();
		GameUI.battleResult();
				
		BattleService.str1 = "";
		BattleService.str2 = "";
		input = -1;
		do {
			try {
				sc.nextInt();
				switch (input) {
				case 1:
					break;
				case 2:
					break;
				case 0:
					break;
				default: break;
				}
			} catch (InputMismatchException e) {
				System.out.println("[잘못된 형식의 입력입니다.]");
				sc.nextLine(); // 입력 버퍼에 잘못 입력된 내용 제거
				input = -1; // 반복문이 종료 되는 것을 방지
			}
			System.out.println();
		} while (input != -1);
	}
		
	

}