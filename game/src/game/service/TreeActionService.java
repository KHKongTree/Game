package game.service;

import game.dto.Item;
import game.dto.UserState;

public class TreeActionService {

	public static UserState me = new UserState();
	public static UserState tree = new UserState();
	public static Item item = new Item();
	
	public static String str1 = "";
	public static String str2 = "";
	public static String str3 = "";
	
	public void water() {
		double a = UserState.getTreeHeight();

		str1 = String.format("2.0L를 주었습니다.");
		str2 = String.format("♣5.m가 자랐습니다!♣");
		str3 = String.format("나무의 키가 %f가 되었습니다.", a);

	}

	public void branchCut() {
		if (Item.getScissorCount() > 0) { // 가위가 있을 떄
			Item.setScissorCount(Item.getScissorCount() - 1); // 가위를 사용했을 때
			UserState.setGrowthrate(1.0); // 나무 비율 초기화
			str2 = String.format("가지치기 완료");
		} else {
			str2 = String.format("가위가 없습니다.");
		}

	}

	public void fertiliser() {

		if (Item.getFertiliserCount() > 0) {
			Item.setFertiliserCount(Item.getFertiliserCount() - 1);
			UserState.setTreeHeight(UserState.getTreeHeight() + 10);
			str2 = String.format("나무가 10m 자라 %fm가 되었습니다. ", UserState.getTreeHeight());
		} else {
			str2 = String.format("비료가 없습니다.");
		}

	}

	public void potion() {

		if (Item.getPotionCount() > 0) {
			Item.setPotionCount(Item.getPotionCount() - 1);
			UserState.setTreeHeight(UserState.getTreeHeight() + 50);
			str2 = String.format("나무가 50m 자라 %fm가 되었습니다. ", UserState.getTreeHeight());
		} else {
			str2 = String.format("물약이 없습니다.");
		}

	}

	public void bugKiller() {

		if (Item.getBugKillerCount() > 0) {
			Item.setBugKillerCount(Item.getBugKillerCount() - 1);
			UserState.setTreeHeight(UserState.getTreeHeight() + 30);
			str2 = String.format("나무가 30m 자라 %fm가 되었습니다. ", UserState.getTreeHeight());
		} else {
			str2 = String.format("해충제가 없습니다.");
		}

	}
}