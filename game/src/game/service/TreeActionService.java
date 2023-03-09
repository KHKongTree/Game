package game.service;

import game.dto.Item;
import game.dto.UserState;

public class TreeActionService {

	public static UserState me = new UserState();
	public static UserState tree = new UserState();
	public static Item item = new Item();
	
	public void water() {
		double a = UserState.getTreeHeight();

		System.out.println("================================");
		System.out.println("2.0L를 주었습니다.");
		System.out.println("♣5.m가 자랐습니다!♣");
		System.out.printf("나무의 키가 %f가 되었습니다.", a);

	}

	public void branchCut() {
		if (Item.getScissorCount() > 0) { // 가위가 있을 떄
			Item.setScissorCount(Item.getScissorCount() - 1); // 가위를 사용했을 때
			UserState.setGrowthrate(1.0); // 나무 비율 초기화
			System.out.println("가지치기 완료");
		} else {
			System.out.println("가위가 없습니다.");
		}

	}

	public void fertiliser() {

		if (Item.getFertiliserCount() > 0) {
			Item.setFertiliserCount(Item.getFertiliserCount() - 1);
			UserState.setTreeHeight(UserState.getTreeHeight() + 10);
			System.out.printf("나무가 10m 자라 %fm가 되었습니다. ", UserState.getTreeHeight());
		} else {
			System.out.println("비료가 없습니다.");
		}

	}

	public void potion() {

		if (Item.getPotionCount() > 0) {
			Item.setPotionCount(Item.getPotionCount() - 1);
			UserState.setTreeHeight(UserState.getTreeHeight() + 50);
			System.out.printf("나무가 50m 자라 %fm가 되었습니다. ", UserState.getTreeHeight());
		} else {
			System.out.println("물약이 없습니다.");
		}

	}

	public void bugKiller() {

		if (Item.getBugKillerCount() > 0) {
			Item.setBugKillerCount(Item.getBugKillerCount() - 1);
			UserState.setTreeHeight(UserState.getTreeHeight() + 30);
			System.out.printf("나무가 30m 자라 %fm가 되었습니다. ", UserState.getTreeHeight());
		} else {
			System.out.println("해충제가 없습니다.");
		}

	}
}