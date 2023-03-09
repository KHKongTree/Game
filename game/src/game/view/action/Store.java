package game.view.action;

import java.util.Scanner;

import game.dto.Item;
import game.image.GameUI;
import game.service.UserItemService;

public class Store {
	
	
	
	public void menu() {

		try (Scanner sc = new Scanner(System.in)) {
			Item item = new Item();
			
			UserItemService userItem = new UserItemService();
			
			int input = 0;
			do {
				
				GameUI.store();
				input = sc.nextInt();

				switch (input) {
				case 1:
					UserItemService.successBuyWeapon(item.getBronzeExe(), item.getBronzeExePrice(), item.getBronzeExeStriking());
					break;
				case 2:
					UserItemService.successBuyWeapon(item.getSilverExe(), item.getSilverExePrice(), item.getSilverExeStriking());
					break;
				case 3:
					UserItemService.successBuyWeapon(item.getGoldExe(), item.getGoldExePrice(), item.getGoldExeStrinking());
					break;
				case 4:
					Item.setFertiliserCount(
							Item.getFertiliserCount() + userItem.successBuyItem(item.getFertiliser(), item.getFertiliserPrice()));
					break;
				case 5:
					Item.setPotionCount(Item.getPotionCount() + userItem.successBuyItem(item.getPotion(), item.getPotionPrice()));
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
		}
		UserItemService.str = "";
	}

	

}
