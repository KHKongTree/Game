package game.view.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import game.image.GameUI;

public class GameMenu1 {

	Scanner sc = new Scanner(System.in);
	GameUI ui = new GameUI();
	GameMenu2 start = new GameMenu2();
	
	public void menu() {
		int input = -1;
		do {
			try {
				GameUI.clearConsoleE();
				GameUI.gameMenu1();
				
				input = sc.nextInt();
				
				System.out.println();
				
				switch (input) {
				case 1:
					GameUI.clearConsoleE();
					start.menu();
					GameUI.clearConsoleE();
					break;
				case 2:
					break;
				case 0:
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
