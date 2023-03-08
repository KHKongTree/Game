package game.view.action;

import java.util.Random;
import java.util.Scanner;

import game.dto.Hero;
import game.dto.Item;
import game.dto.Tree;
import game.dto.Woodcutter;

public class TreeCare {
	
	Scanner sc = new Scanner(System.in);
	Random random = new Random();
	private GameService service = new GameService();

	private Hero signUpUser;

	public static Hero loginUser = null;
	Woodcutter enemy = new Woodcutter();
	public static Tree tree = new Tree();
	public static Item item;
	
	  public void Menu() {
	       int input = 0;
	    	
	       do {
	    	   System.out.println("[돌보기 메뉴]");
	    	   System.out.println("1. 물주기");
	    	   System.out.println("2. 가지치기");
	    	   System.out.println("3. 아이템 사용하기");
	    	   System.out.println("0. 나가기");
	    	   
	    	   System.out.println();

	    	   System.out.print("돌보기 메뉴를 선택해주세요. : ");
	    	   input = sc.nextInt(); 
	    	   
	    	   System.out.println();
	    	   
	    	   switch(input) {
	    	   case 1 : this.water(); break;
	    	   case 2 : this.branchCut(); break;
	    	   case 3 : this.useItem();  break;
	  	       case 0 : System.out.println("나무 돌보기를 나갑니다."); break;
	    	   default : System.out.println("잘못 입력 하셨습니다.");
	    	   }
	    	   System.out.println();
	        } while (input != 0);

		}

	private void water() {
		double a = tree.getTreeHeight();
	
		
		System.out.println("================================");
		System.out.println("2.0L를 주었습니다.");
		System.out.println("♣5.m가 자랐습니다!♣");
		System.out.printf("나무의 키가 %f가 되었습니다.", a);

	}

	private void branchCut() {
		
		if(item.getScissorCount()>0) { //가위가 있을 떄
			item.setScissorCount(item.getScissorCount()-1); //가위를 사용했을 때
			tree.setGrowthrate(1.0); // 나무 비율 초기화
			System.out.println("가지치기 완료"); 
		}else {
			System.out.println("가위가 없습니다.");
		}
		
		
	}

	private void useItem() {
		int input = 0;
   	
	       do {
	    	   System.out.println("[아이템 메뉴]");
	    	   System.out.println("1. 비료");
	    	   System.out.println("2. 물약");
	    	   System.out.println("3. 해충제");
	    	   System.out.println("0. 나가기");
	    	
	    	 
	    	   
	    	   System.out.println();

	    	   System.out.print("아이템 메뉴를 선택해주세요. : ");
	    	   input = sc.nextInt(); 
	    	   
	    	   System.out.println();
	    	   
	    	   switch(input) {
	    	   case 1 : this.fertiliser(); break;
	    	   case 2 : this.potion();  break;
	    	   case 3 : this.bugKiller();  break;
	  	       case 0 : System.out.println("아이템 메뉴를 나갑니다."); break;
	    	   default : System.out.println("잘못 입력 하셨습니다.");
	    	   }
	    	   System.out.println();
	        } while (input != 0);
	       
	  

		}

	private void fertiliser() {
		
		if(item.getFertiliserCount()>0) {
			item.setFertiliserCount(item.getFertiliserCount()-1);
			tree.setTreeHeight(tree.getTreeHeight()+10);
			System.out.printf("나무가 10m 자라 %fm가 되었습니다. ",tree.getTreeHeight());
		} else {
			System.out.println("비료가 없습니다.");
		}
		
	}

	private void potion() {
	
		if(item.getPotionCount()>0) {
			item.setPotionCount(item.getPotionCount()-1);
			tree.setTreeHeight(tree.getTreeHeight()+50);
			System.out.printf("나무가 50m 자라 %fm가 되었습니다. ",tree.getTreeHeight());
		} else {
			System.out.println("물약이 없습니다.");
		}
	
		
	}

	private void bugKiller() {
		
		if(item.getBugKillerCount()>0) {
			item.setBugKillerCount(item.getBugKillerCount()-1);
			tree.setTreeHeight(tree.getTreeHeight()+30);
			System.out.printf("나무가 30m 자라 %fm가 되었습니다. ",tree.getTreeHeight());
		} else {
			System.out.println("해충제가 없습니다.");
		}
	
		
	}

}
