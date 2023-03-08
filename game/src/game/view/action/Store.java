package game.view.action;

import java.util.Scanner;

import game.dto.Item;
import game.dto.UserState;
import game.service.UserStateService;

public class Store {

	public void menu() {

		Scanner sc = new Scanner(System.in);
		UserState me = new UserState();
		Item item = new Item();

		System.out.println("[아이템 상점]");

		int input = 0;
		do {
			System.out.println();
			System.out.println("내가 가지고 있는 골드 : " + UserState.getGold());

			System.out.println("1. 동도끼 (100G)");
			System.out.println("2. 은도끼 (200G)");
			System.out.println("3. 금도끼 (300G)");
			System.out.println("4. 비료 (50G)");
			System.out.println("5. 물약 (100G)");
			System.out.println("6. 해충제 (80G)");
			System.out.println("7. 가위 (20G)");
			System.out.println("0. 상점 나가기");

			System.out.print("메뉴 선택 : ");
			input = sc.nextInt();

			switch (input) {
			case 1:
				successBuyWeapon(item.getBronzeExe(), item.getBronzeExePrice(), item.getBronzeExeStriking());
				break;
			case 2:
				successBuyWeapon(item.getSilverExe(), item.getSilverExePrice(), item.getSilverExeStriking());
				break;
			case 3:
				successBuyWeapon(item.getGoldExe(), item.getGoldExePrice(), item.getGoldExeStrinking());
				break;
			case 4:
				Item.setFertiliserCount(
						Item.getFertiliserCount() + successBuyItem(item.getFertiliser(), item.getFertiliserPrice()));
				break;
			case 5:
				Item.setPotionCount(Item.getPotionCount() + successBuyItem(item.getPotion(), item.getPotionPrice()));
				break;
			case 6:
				Item.setBugKillerCount(
						Item.getBugKillerCount() + successBuyItem(item.getBugKiller(), item.getPotionPrice()));
				break;
			case 7:
				Item.setScissorCount(
						Item.getScissorCount() + successBuyItem(item.getScissor(), item.getScissorPrice()));
				break;
			case 0:
				break;
			}

		} while (input != 0);

	}

	private void successBuyWeapon(String item, int price, int exStrike) {

		if (UserStateService.buyWeapon(item, price, exStrike)) {
			System.out.printf("%s를 획득했습니다.\n", item);
		} else {
			System.out.println("소지한 골드가 부족합니다.\n");
		}
	}

	private int successBuyItem(String item, int price) {

		if (UserStateService.buyItem(price)) {
			System.out.printf("%s를 획득했습니다.\n", item);
			return 1;
		} else {
			System.out.println("소지한 골드가 부족합니다.\n");
			return 0;
		}
	}

}
