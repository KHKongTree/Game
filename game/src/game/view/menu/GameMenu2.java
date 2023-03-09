package game.view.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import game.view.action.TreeCare;
import game.dto.UserState;
import game.image.GameUI;
import game.view.action.Battle;
import game.view.action.Display;
import game.view.action.Store;

public class GameMenu2 {

	Scanner sc = new Scanner(System.in);
	UserState me = new UserState();
	TreeCare care = new TreeCare();
	Battle battle = new Battle();
	Store store = new Store();
	Display info = new Display();
	GameUI ui = new GameUI();
	
	public void menu() {
		
		GameUI.newStartUi();
		sc.nextLine();
		GameUI.clearConsoleE();
		int input = -1;
		do {
			try {
				GameUI.gameMenu2();
				
				input = sc.nextInt();
				GameUI.clearConsoleE();
				
				System.out.println();

				switch (input) {
				case 1:
					care.Menu();
					GameUI.clearConsoleE();
					break;
				case 2:
					battle.menu();
					GameUI.clearConsoleE();
					break;
				case 3:
					store.menu();
					GameUI.clearConsoleE();
					break;
				case 4:
					info.display();
					GameUI.clearConsoleE();
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

}
