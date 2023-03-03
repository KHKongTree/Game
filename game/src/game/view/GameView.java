package game.view;

import java.util.Scanner;

import game.dto.Hero;
import game.dto.Item;
import game.dto.Tree;
import game.service.GameService;

public class GameView {
	
	Scanner sc = new Scanner(System.in);
	
	private GameService service = new GameService();
	
	private Hero signUpUser;
	
	public static Hero loginUser = null;

	public static Tree tree;
	
	public static Item item;
	
	
	
    public void Menu() {
    	
       int input = 0;
       System.out.println("[♣Kong Tree♣]\n잭에겐 어머니의 유품인 씨앗 하나가 있었고,\n심자마자 잭의 키를 넘길 만큼 커져버렸다.\n소문을 들은 마을 사람들은 이 나무를 탐내게 되는데....\n");
       
       do {
    	   System.out.println("1. 회원가입");
    	   System.out.println("2. 로그인");
    	   System.out.println("3. 나무 돌보기");
    	   System.out.println("4. 나무꾼을 이겨라");
    	   System.out.println("5. 상점");
    	   System.out.println("0. 프로그램 종료");
    	   
    	   System.out.print("메뉴 선택 : ");
    	   input = sc.nextInt();
    	   
    	   System.out.println();
    	   
    	   switch(input) {
    	   case 1 : this.signUp(); break;
    	   case 2 : if(this.login()) {
    		   			treeCareMenu();
    	   			}
    	   			break;
    	   case 0 : System.out.println("프로그램을 종료합니다."); break;
    	   default : System.out.println("잘못 입력 하셨습니다.");
    	   
    	   
    	   }
    	   System.out.println();
        } while (input != 0);

	}
    
//    private void menu2() {
//		// TODO Auto-generated method stub
//		
//	}

	private void signUp() {
    	System.out.println("--- 회원 가입 ---");
    	
    	System.out.print("ID : ");
    	String userId = sc.next();
    	
    	System.out.print("Pw : ");
    	String userPw = sc.next();
    	
    	System.out.print("Pw 확인 : ");
    	String userPwConfirm = sc.next();
    	
    	
    	signUpUser = GameService.signUp(userId, userPw, userPwConfirm);
    	tree = new Tree();
    	item = new Item();
    	
    	
    	if(signUpUser != null) {
    		
    		System.out.println("회원 가입 완료");
    	} else {
    		System.out.println("비밀번호가 일치하지 않습니다");
    	}
    	
    }
    
	private boolean login() {
		
		System.out.println("--- 로그인 ---");
		
		if(signUpUser == null) {
			System.out.println("회원 가입 후 진행해주세요.");
			return false;
		}
		
		System.out.print("ID : ");
		String userId = sc.next();
		
		System.out.print("Pw : ");
		String userPw = sc.next();
		
		
		GameService gameService = new GameService();
		gameService.login(userId, userPw, signUpUser);
		
		
		
		if(GameView.loginUser !=null) {
			System.out.println("환영합니다.");
			return true;
		} else {
			System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
			return false;
		}
		
	}
	

	  public void treeCareMenu() {
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
		double a = service.Tree(tree.getTreeHeight());
	
		
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
			System.out.println("가위 없습니다.");
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
