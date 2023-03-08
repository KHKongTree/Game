package game.view.action;

public class Display {

    private void display() {
    	System.out.println("정보 확인");
    	System.out.println("HP : " + loginUser.getHp());
    	System.out.println("골드 : " + loginUser.getGold());
    	System.out.println("무기 : " + loginUser.getWeapon());
    	System.out.println("나무 길이 : "+ tree.getTreeHeight());
    	
    }
}	
