package game.view.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameMenu1 {

	Scanner sc = new Scanner(System.in);
	
	GameMenu2 start = new GameMenu2();
	
	public void menu() {
		
		int input = -1;
		System.out.println("      [♣Kong Tree♣]\n"
							+ "잭에겐 어머니의 유품인 씨앗 하나가 있었고,\n" 
							+ "심자마자 잭의 키를 넘길 만큼 커져버렸다.\n"
							+ "소문을 들은 마을 사람들은 이 나무를 탐내게 되는데....\n"
							);
		do {
			try {
				System.out.println("1. 새 게임시작");
				System.out.println("2. 로딩");
				
				System.out.println("0. 프로그램 종료");
				
				System.out.print("메뉴 선택 : ");
				input = sc.nextInt();
				
				System.out.println();
				
				switch (input) {
				case 1:
					start.menu();
					break;
				case 2:
					break;
				case 0:
					System.out.println("프로그램을 종료합니다.");
					break;
				default:
					System.out.println("잘못 입력 하셨습니다.");
				}
			} catch (InputMismatchException e) {
				System.out.println("[잘못된 형식의 입력입니다.]");
				sc.nextLine(); // 입력 버퍼에 잘못 입력된 내용 제거
				input = -1; // 반복문이 종료 되는 것을 방지
			}
			System.out.println();
		} while (input != 0);
	}
}
