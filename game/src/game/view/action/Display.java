package game.view.action;

import java.util.InputMismatchException;
import java.util.Scanner;

import game.dto.UserState;
import game.image.GameUI;

public class Display {
	Scanner sc = new Scanner(System.in);
	UserState me = new UserState();

	public void display() {
		GameUI.clearConsoleE();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@===========================================@");
		System.out.println(" 정보 확인");
		System.out.println("HP : " + UserState.getHp());
		System.out.println("골드 : " + UserState.getGold());
		System.out.println("무기 : " + UserState.getWeapon());
		System.out.println("나무 길이 : " + UserState.getTreeHeight() + "/100");
		System.out.println("@===========================================@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@==============");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@=계속하려면      ");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@= 아무키나 입력하기");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@==============");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@= 입력후 Enter  ");
		System.out.print("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@=   >>");

		
		int input1 = -1;
		do {
			try {
				sc.nextInt();
				switch (input1) {
				case 1:
					break;
				case 2:
					break;
				case 0:
					break;
				default:
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("[잘못된 형식의 입력입니다.]");
				sc.nextLine(); // 입력 버퍼에 잘못 입력된 내용 제거
				input1 = -1; // 반복문이 종료 되는 것을 방지
			}
			System.out.println();
		} while (input1 != -1);

	}

}
