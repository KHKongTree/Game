package game.view.action;

import game.dto.UserState;

public class Display {
	
	UserState me = new UserState();
	
    public void display() {
    	System.out.println("정보 확인");
    	System.out.println("HP : " + me.getHp());
    	System.out.println("골드 : " + me.getGold());
    	System.out.println("무기 : " + me.getWeapon());
    	System.out.println("나무 길이 : "+ me.getTreeHeight());
    	
    }
}	
