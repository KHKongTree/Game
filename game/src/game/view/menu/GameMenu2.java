package game.view.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import game.dto.Item;
import game.dto.UserState;
import game.image.GameUI;
import game.service.Service;
import game.view.action.Battle;
import game.view.action.Display;
import game.view.action.Store;
import game.view.action.TreeCare;

public class GameMenu2 {

	Service service = new Service();
	Scanner sc = new Scanner(System.in);
	UserState meAndTree = service.getMeAndTree();
	Item item = service.getItem();
	TreeCare care = service.getCare();
	Battle battle = new Battle();
	Store store = new Store();
	Display info = new Display();
	GameUI ui = service.getUi();
	
	
	public void menu() {
		
		ui.newStartUi();
		
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
					break;
				case 2:
					battle.menu();
					break;
				case 3:
					store.menu();
					break;
				case 4:
					info.display();
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
			
			if(meAndTree.getTreeHeight() == 1000) {
				System.out.println("야호! 당신의 콩나무는 완전완전 커졌습니다.");
				System.out.println("야호! 당신의 콩나무는 완전완전 커졌습니다.");
				System.out.println("야호! 당신의 콩나무는 완전완전 커졌습니다.");
				System.out.println("야호! 당신의 콩나무는 완전완전 커졌습니다.");
				System.out.println("야호! 당신의 콩나무는 완전완전 커졌습니다.");
				System.out.println("야호! 당신의 콩나무는 완전완전 커졌습니다.");
				System.out.println("야호! 당신의 콩나무는 완전완전 커졌습니다.");
				break;
			}
			
		} while (input != 0);
		
	}

}
