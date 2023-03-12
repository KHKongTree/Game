package game.service;

import game.dto.Item;
import game.dto.UserState;

public class TreeActionService extends Service { // Service 를 상속받아 객체 사용 가능 ex) meAndTree, item 등

	public void water() { // 나무돌보기(TreeCare)에서 쓸 메서드
		meAndTree.setTreeHeight(meAndTree.getTreeHeight() + (int) (20 * meAndTree.getGrowthrate())); // 가져온 나무키 + 20

		System.out.println("================================");
		System.out.println("2L를 주었습니다.");
		System.out.println("♣20m가 자랐습니다!♣");
		System.out.printf("잭! 내 키가 %dm 자라서 %dm가 됐어!", meAndTree.getTreeHeight(), meAndTree.getTreeHeight());
	}

	public void branchCut() { // 나무돌보기(TreeCare)에서 쓸 메서드
		if (item.getScissorCount() > 0) { // 가위가 있을 떄
			item.setScissorCount(item.getScissorCount() - 1); // 가위를 사용했을 때
			meAndTree.setGrowthrate(1.0); // 나무 비율 초기화-
			System.out.println("지저분한 가지를 정리했습니다!!*^v^*");
		} else {
			System.out.println("어? 가위가 없네? 가위 사줘!");
		}

	}

	public void fertiliser() { // 나무돌보기(TreeCare)에서 쓸 메서드

		if (item.getFertiliserCount() > 0) {
			item.setFertiliserCount(item.getFertiliserCount() - 1);
			meAndTree.setTreeHeight(meAndTree.getTreeHeight() + (int) (10 * meAndTree.getGrowthrate()));
			if (meAndTree.getGrowthrate() < 1) {
				System.out.println("가지치기 할거지?");
			} else if (meAndTree.getGrowthrate() <= 0.7) {
				System.out.println("가지치기 언제해줄거야? 내 가지를 봐 많아지잖아...!");
			} else if (meAndTree.getGrowthrate() <= 0.4) {
				System.out.println("가지가 너무 많아! 가지치기를 먼저 해줘!");
			}
			System.out.printf("잭! 내 키가 10m 자라서 %fm가 됐어! ", meAndTree.getTreeHeight());
		} else {
			System.out.println("비료 어딨어? 비료 사야지!");
		}

	}

	public void potion() { // 나무돌보기(TreeCare)에서 쓸 메서드

		if (item.getPotionCount() > 0) {
			item.setPotionCount(item.getPotionCount() - 1);
			meAndTree.setTreeHeight(meAndTree.getTreeHeight() + (int) (50 * meAndTree.getGrowthrate()));
			if (meAndTree.getGrowthrate() < 1) {
				System.out.println("가지치기 할거지?");
			} else if (meAndTree.getGrowthrate() <= 0.7) {
				System.out.println("가지치기 언제해줄거야? 내 가지를 봐 많아지잖아...!");
			} else if (meAndTree.getGrowthrate() <= 0.4) {
				System.out.println("가지가 너무 많아! 가지치기를 먼저 해줘!");
			}
			System.out.printf("잭! 내 키가 50m 자라서 %dm가 됐어! ", meAndTree.getTreeHeight());
		} else {
			System.out.println("물약이 있으면 빨리 자랄텐데.. 물약을 사러 가볼까?");
		}

	}

	public void bugKiller() { // 나무돌보기(TreeCare)에서 쓸 메서드

		if (item.getBugKillerCount() > 0) {
			item.setBugKillerCount(item.getBugKillerCount() - 1);
			meAndTree.setTreeHeight(meAndTree.getTreeHeight() + (int) (30 * meAndTree.getGrowthrate()));
			if (meAndTree.getGrowthrate() < 1) {
				System.out.println("가지치기 할거지?");
			} else if (meAndTree.getGrowthrate() <= 0.7) {
				System.out.println("가지치기 언제해줄거야? 내 가지를 봐 많아지잖아...!");
			} else if (meAndTree.getGrowthrate() <= 0.4) {
				System.out.println("가지가 너무 많아! 가지치기를 먼저 해줘!");
			}
			System.out.printf("잭! 내 키가 30m 자라서 %fm가 됐어! ", meAndTree.getTreeHeight());
		} else {
			System.out.println("으악! 벌레가 너무 많아! 해충제가 필요할거같아 상점으로 가자!");
		}
	}

}