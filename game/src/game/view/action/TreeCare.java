package game.view.action;

import java.util.Random;
import java.util.Scanner;

import game.dto.UserState;
import game.image.GameUI;
import game.service.TreeActionService;

public class TreeCare {

	Scanner sc = new Scanner(System.in);
	Random random = new Random();

	public static UserState me = new UserState();
	public static UserState tree = new UserState();
	public static TreeActionService action = new TreeActionService();

	public static TreeCareItem useItem = new TreeCareItem();
	
	public void Menu() {
		int input = 0;

		do {
			GameUI.treeCare();
			
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
				break;
			default: break;
			}
			System.out.println();
		} while (input != 0);

	}

}
