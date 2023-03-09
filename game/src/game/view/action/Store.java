package game.view.action;

import java.util.Scanner;

import game.dto.Item;
import game.image.GameUI;
import game.service.StorerItemService;

public class Store {
	
	Scanner sc = new Scanner(System.in);
	
	public void menu() {
		GameUI.clearConsoleE();
		
		Item item = new Item();

		StorerItemService userItem = new StorerItemService();
		int input = 0;
		do {
			GameUI.clearConsoleE();
			
			GameUI.store();
			input = sc.nextInt();

			switch (input) {
			case 1:
				StorerItemService.successBuyWeapon(item.getBronzeExe(), item.getBronzeExePrice(),
						item.getBronzeExeStriking());
				break;
			case 2:
				StorerItemService.successBuyWeapon(item.getSilverExe(), item.getSilverExePrice(),
						item.getSilverExeStriking());
				break;
			case 3:
				StorerItemService.successBuyWeapon(item.getGoldExe(), item.getGoldExePrice(), item.getGoldExeStrinking());
				break;
			case 4:
				Item.setFertiliserCount(Item.getFertiliserCount()
						+ userItem.successBuyItem(item.getFertiliser(), item.getFertiliserPrice()));
				break;
			case 5:
				Item.setPotionCount(
						Item.getPotionCount() + userItem.successBuyItem(item.getPotion(), item.getPotionPrice()));
				break;
			case 6:
				Item.setBugKillerCount(
						Item.getBugKillerCount() + userItem.successBuyItem(item.getBugKiller(), item.getPotionPrice()));
				break;
			case 7:
				Item.setScissorCount(
						Item.getScissorCount() + userItem.successBuyItem(item.getScissor(), item.getScissorPrice()));
				break;
			case 0:
				break;
			}

		} while (input != 0);
		StorerItemService.str = "";
	}

}
