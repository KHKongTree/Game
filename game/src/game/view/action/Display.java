package game.view.action;

import game.dto.Item;
import game.dto.UserState;
import game.service.Service;

public class Display {
	Service service = new Service();
	
	UserState me = service.getMeAndTree();
	Item item = service.getItem();
	
    public void display() {
    	System.out.println("정보 확인");
    	System.out.println("성장률 : " + me.getGrowthrate());
    	System.out.println("골드 : " + me.getGold());
    	System.out.println("무기 : " + me.getWeapon());
    	System.out.println("나무 길이 : "+ me.getTreeHeight());
    	System.out.printf("비료 : %d 개, 물약 : %d 개, 해충제 : %d 개, 가위 : %d 개", 
    			item.getFertiliserCount(), item.getPotionCount(), item.getBugKillerCount(), item.getScissorCount());
    	
    }
}	
