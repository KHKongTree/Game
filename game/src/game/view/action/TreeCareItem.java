package game.view.action;

import java.util.Random;
import java.util.Scanner;

import game.dto.UserState;
import game.image.GameUI;
import game.service.TreeActionService;

public class TreeCareItem {

	Scanner sc = new Scanner(System.in);
	Random random = new Random();

	public static UserState me = new UserState();
	public static UserState tree = new UserState();
	public static TreeActionService action = new TreeActionService();

	
	public void menu() {
		int input = 0;

		do {
			
			GameUI.treeCareItem();
			TreeActionService.str1 = "";
			TreeActionService.str2 = "";
			TreeActionService.str3 = "";
			input = sc.nextInt();

			System.out.println();

			switch (input) {
			case 1:
				action.fertiliser();
				break;
			case 2:
				action.potion();
				break;
			case 3:
				action.bugKiller();
				break;
			case 0:
				System.out.println("아이템 메뉴를 나갑니다.");
				break;
			default:
				System.out.println("잘못 입력 하셨습니다.");
			}
			System.out.println();
		} while (input != 0);

	}
}
