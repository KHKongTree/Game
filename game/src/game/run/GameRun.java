package game.run;


import game.image.GameUI;
import game.view.menu.GameMenu1;

public class GameRun {
	public static void main(String[] args) {
		GameUI ui = new GameUI();
		GameMenu1 runner = new GameMenu1();
		ui.gameMenu1();
		runner.menu();
		
		
	}
}

 