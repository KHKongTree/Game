package game.view.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import game.view.action.TreeCare;
import game.view.action.Battle;
import game.view.action.Store;

public class GameMenu2 {

	Scanner sc = new Scanner(System.in);

//	TreeCare care = new TreeCare();
	Battle battle = new Battle();
//	Store store = new Store();

	public void menu() {
		int input = -1;
		do {
			try {
				System.out.println("======♣Kong Tree♣======");
				System.out.println("1. 나무 돌보기");
				System.out.println("2. 나무꾼을 이겨라");
				System.out.println("3. 상점");

				System.out.println("0. 콩나무 포기하기");

				System.out.print("메뉴 선택 : ");
				input = sc.nextInt();

				System.out.println();

				switch (input) {
				case 1:
//					care.Menu();
					break;
				case 2:
					battle.menu();
					break;
				case 3:
//					store.menu();
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
