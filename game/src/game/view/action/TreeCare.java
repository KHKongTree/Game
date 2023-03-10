package game.view.action;

import java.util.Random;
import java.util.Scanner;

import game.service.TreeActionService;

public class TreeCare {

	Scanner sc = new Scanner(System.in);
	Random random = new Random();

	public static TreeActionService action = new TreeActionService();

	public static TreeCareItem useItem = new TreeCareItem();
	
	public void Menu() {
		int input = 0;

		do {
			System.out.println("[돌보기 메뉴]");
			System.out.println("1. 물주기");
			System.out.println("2. 가지치기");
			System.out.println("3. 아이템 사용하기");
			System.out.println("0. 나가기");

			System.out.println();

			System.out.print("돌보기 메뉴를 선택해주세요. : ");
			input = sc.nextInt();

			System.out.println();

			switch (input) {
			case 1:
				action.water();
				break;
			case 2:
				action.branchCut();
				break;
			case 3:
				useItem.menu();
				break;
			case 0:
				System.out.println("나무 돌보기를 나갑니다.");
				break;
			default:
				System.out.println("잘못 입력 하셨습니다.");
			}
			System.out.println();
		} while (input != 0);

	}

}
