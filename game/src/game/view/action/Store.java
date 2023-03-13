package game.view.action;

import java.util.Scanner;

import game.dto.Item;
import game.dto.UserState;
import game.service.Service;
import game.service.UserStateService;

public class Store {
	UserStateService us = new UserStateService();  			// 유저상태 서비스(buyWeapon, buyItem)를 가져오기 위한 객체 us
	Scanner sc = new Scanner(System.in);
	
	public void menu() {
		Service service = new Service(); 					// 서비스 클래스에 있는 객체를 가져오기 위함
		UserState me = service.getMeAndTree();
		Item item = service.getItem();
		System.out.println("[아이템 상점]");
		

		int input = 0;
		do {
			System.out.println();
			System.out.println("내가 가지고 있는 골드 : " + me.getGold());

			System.out.println("1. 동도끼 (100G)");
			System.out.println("2. 은도끼 (200G)");
			System.out.println("3. 금도끼 (300G)");
			System.out.println("4. 비료 (50G)");
			System.out.println("5. 물약 (100G)");
			System.out.println("6. 해충제 (200G)");
			System.out.println("7. 가위 (10G)");
			System.out.println("0. 상점 나가기");
			System.out.println();
			
			System.out.print("메뉴 선택 : ");
			input = sc.nextInt();
			System.out.println("================================");
			System.out.println();
			
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
				item.setFertiliserCount(item.getFertiliserCount()+ 1);
				successBuyItem(item.getFertiliser(), item.getFertiliserPrice(), item.getFertiliserCount());
				break;
			case 5:
				item.setPotionCount(item.getPotionCount()+1);
				successBuyItem(item.getPotion(), item.getPotionPrice(), item.getPotionCount());
				break;
			case 6:
				item.setBugKillerCount(item.getBugKillerCount()+1); 
				successBuyItem(item.getBugKiller(), item.getBugKillerPrice(), item.getBugKillerCount());
				break;
			case 7:
				item.setScissorCount(item.getScissorCount()+1);
				successBuyItem(item.getScissor(), item.getScissorPrice(), item.getScissorCount());
				break;
			case 0:
				break;
			}

		} while (input != 0);

	}

	private void successBuyWeapon(String item, int price, int exStrike) {

		if (us.buyWeapon(item, price, exStrike)) {
			System.out.printf("%s를 획득했습니다.\n", item);
			System.out.println("================================");
		} else {
			System.out.println("소지한 골드가 부족합니다.\n");
			System.out.println("================================");
		}
	}

	private int successBuyItem(String item, int price, int count) {

		if (us.buyItem(price)) {
			System.out.printf("%s를 획득했습니다 총 개수는 %d개 입니다..\n", item,count);
			System.out.println("================================");
			return 1;
		} else {
			System.out.println("소지한 골드가 부족합니다.\n");
			System.out.println("================================");
			return 0;
		}
	}

}
