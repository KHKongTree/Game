package game.image;

import game.dto.UserState;
import game.service.BattleService;
import game.service.StorerItemService;

public class GameUI {
	
	BattleService battlesub = new BattleService();
	
	public static void clearConsoleE() {
		for (int i = 0; i < 35; i++) {
			System.out.println();
		}
	}
	

	public static void clearConsole() {
		try {
			if (System.getProperty("os.name").contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
		} catch (Exception e) {
			System.out.println("콘솔을 지우는 동안 오류가 발생했습니다.");
		}
	}

	public static void gameMenu1() {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@$---~@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@-..----@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@=....---~@##@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@:,,!.........----~@@@@@@@@@@@@@@@@@@");
		System.out.println("=============================================");
		System.out.println("=# #   #   # #   ##       ###  ##   ###  ###=");
		System.out.println("=# #  # #  ###  #          #   # #  #    #  =");
		System.out.println("=##   # #  ###  # #        #   ##   ##   ## =");
		System.out.println("=# #  # #  ###  # #        #   # #  #    #  =");
		System.out.println("=# #   #   # #   ##        #   # #  ###  ###=");
		System.out.println("==============[♣Kong Tree♣]==================");
		System.out.println("@@@*........................----@@@@@@@@@@@@@");
		System.out.println("@@@@.........................---@@@@@@@@@@@@@");
		System.out.println("@@@..........................---!@@@@@@@@@@@@");
		System.out.println("@@@..........................---*@@@@@@@@@@@@");
		System.out.println("@@:..........................---@@@@@@@@@@@@@");
		System.out.println("@@#..........................--;@@@@@@@@@@@@@");
		System.out.println("@@@.............#@@.........,-:@@@@@@@@@@@@@@");
		System.out.println("@@@@.......=....@-@-...,*...;@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@....@=@,.,@-@-..#@$*--$@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@-...@*~@.-@-;!,@#-@!--$@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@....@-*@;!-~@@~-@$---@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@!...:@-@@~-~@--@;.--:@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@#...@=-@-----@-.,-*@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@:.@-----:@$.@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@----@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@$---@@@@@@@@@@@@==============");
		System.out.println("@@@@@@@@@@@@@@@!---@@@@@@@@@@@@= 1. 새 이야기  ");
		System.out.println("@@@@@@@@@@@@@@@----@@@@@@@@@@@@= 2. 이어하기   ");
		System.out.println("@@@@@@@@@@@@@@@----#@@@@@@@@@@@=            ");
		System.out.println("@@@@@@@@@@@@@@@----~@@@@@@@@@@@= 0. 끝내기    ");
		System.out.println("@@@@@@@@@@@@@@#-----@@@@@@@@@@@==============");
		System.out.println("@@@@@@@@@@@@@@:-----@@@@@@@@@@@=   메뉴입력    ");
		  System.out.print("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@=   >>");
	}

	public static void newStartUi() {

		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@===========================================@");
		System.out.println("@=                                         =@");
		System.out.println("@=             [♣Kong Tree♣]               =@");
		System.out.println("@=                                         =@");
		System.out.println("@= 잭에겐 어머니의 유품인 씨앗 하나가 있었고,          =@");
		System.out.println("@=                                         =@");
		System.out.println("@= 심자마자 잭의 키를 넘길 만큼 커져버렸다.           =@");
		System.out.println("@=                                         =@");
		System.out.println("@= 소문을 들은 마을 사람들은 이 나무를 탐내게 되는데...  =@");
		System.out.println("@=                                         =@");
		System.out.println("@===========================================@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@==============");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@=계속하려면      ");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@= Enter 입력하기 ");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@==============");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@=   입력       ");
		  System.out.print("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@=   >>");
	}

	public static void gameMenu2() {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@$---~@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@-..----@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@=....---~@##@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@:,,!.........----~@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@;................----@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@*..................---#@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@=.....................,---$@@@@@@@@@@@@@");
		System.out.println("@@@*........................----@@@@@@@@@@@@@");
		System.out.println("@@@.........................,--#@@@@@@@@@@@@@");
		System.out.println("@@@*........................----@@@@@@@@@@@@@");
		System.out.println("@@@@.........................---@@@@@@@@@@@@@");
		System.out.println("@@@*........................----@@@@@@@@@@@@@");
		System.out.println("@@@@.........................---@@@@@@@@@@@@@");
		System.out.println("@@@..........................---!@@@@@@@@@@@@");
		System.out.println("@@@..........................---*@@@@@@@@@@@@");
		System.out.println("@@:..........................---@@@@@@@@@@@@@");
		System.out.println("@@#..........................--;@@@@@@@@@@@@@");
		System.out.println("@@@.............#@@.........,-:@@@@@@@@@@@@@@");
		System.out.println("@@@@.......=....@-@-...,*...;@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@....@=@,.,@-@-..#@$*--$@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@-...@*~@.-@-;!,@#-@!--$@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@....@-*@;!-~@@~-@$---@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@!...:@-@@~-~@--@;.--:@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@#...@=-@-----@-.,-*@@================");
		System.out.println("@@@@@@@@@@@:.@-----:@$.@@@@@@= 1. 나무 돌보기    ");
		System.out.println("@@@@@@@@@@@@@@@----@@@@@@@@@@= 2. 나무꾼을 이겨라 ");
		System.out.println("@@@@@@@@@@@@@@@$---@@@@@@@@@@= 3. 상점         ");
		System.out.println("@@@@@@@@@@@@@@@!---@@@@@@@@@@= 4. 내정보 확인    ");
		System.out.println("@@@@@@@@@@@@@@@----@@@@@@@@@@=               ");
		System.out.println("@@@@@@@@@@@@@@@----#@@@@@@@@@=               ");
		System.out.println("@@@@@@@@@@@@@@@----~@@@@@@@@@= 0. 메뉴로 나가기  ");
		System.out.println("@@@@@@@@@@@@@@#-----@@@@@@@@@================");
		System.out.println("@@@@@@@@@@@@@@:-----@@@@@@@@@=    행동입력     ");
		  System.out.print("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@=     >>");
	}

	public static void treeCare() {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@######@######@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@##$;.,$###$,.;$##@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@#:,....~#:....,;#@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@##,......,......,##@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@#-......###......~#@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@#-......# #......~#@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@###@@#-...-### ###-...~#@@###@@@@@@@@@@@@@");
		System.out.println("@@##$##@##...-#     #-..,##@##$##@@@@@@@@@@@@");
		System.out.println("@@#, ;#@##~..-#== ==#-..:##@#; ,#@@@@@@@@@@@@");
		System.out.println("@###=.#@@##:.,~~# #~~,.:##@@#.=###@@@@@@@@@@@");
		System.out.println("@#~ *~!#@@##:...#;#...:##@@#!~* ~#@@@@@@@@@@@");
		System.out.println("@#- .#~#@@@##~..!!!..:##@@@#~#. -#@@@@@@@@@@@");
		System.out.println("@#$  $.#@@@@##-.....~##@@@@#.$  $#@@@@@@@@@@@");
		System.out.println("@#$  ;;##@@@@##-...~##@@@@##;;  $#@@@@@@@@@@@");
		System.out.println("@@#. -$,#@@@@@##~.~##@@@@@#,$- .#@@@@@@@@@@@@");
		System.out.println("@@#~  ####@@@@@##*##@@@@@####  ~#@@@@@@@@@@@@");
		System.out.println("@@##  #, ;##@@@@###@@@@##; ,#  ##@@@@@@@@@@@@");
		System.out.println("@@##  #   ~=##@@@@@@@##=~   #  ##@@@@@@@@@@@@");
		System.out.println("@@@#- ;#.   -$#$@@@$#$-   .#; -#@@@@@@@@@@@@@");
		System.out.println("@@@#-  ,##    ##@@@##    ##,  -#@@@@@@@@@@@@@");
		System.out.println("@@@##    ,#    #$@##    #,    #$@@@@@@@@@@@@@");
		System.out.println("@@@@@#*         =#@#=         *#@@@@@@@@@@@@@");
		System.out.println("@@@@@@#=.       =#@#=       .=#@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@#$-      =#@#=      -$#@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@##.     =#@#=     .##@@==============");
		System.out.println("@@@@@@@@@#$     =#@#=     $#@@@=  [돌보기 메뉴] ");
		System.out.println("@@@@@@@@@$#     =#@#=     #$@@@= 1. 물주기     ");
		System.out.println("@@@@@@@@@##;;;;;$#@#$;;;;;##@@@= 2. 가지치기   ");
		System.out.println("@@@@@@@@@#!;;;;;;#@#;;;;;;!#@@@= 3. 아이템 사용 ");
		System.out.println("@@@@@@@@@#,      #@#      ,#@@@=            ");
		System.out.println("@@@@@@@@@#,      #@#      ,#@@@= 0. 나가기    ");
		System.out.println("@@@@@@@@@#,      #@#      ,#@@@==============");
		System.out.println("@@@@@@@@@#########@#########@@@=   행동입력    ");
		  System.out.print("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@=   >>");

	}

	public static void battle() {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@=@=@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@!@;@;@*@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@!@!;@;!@*@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@#;@!;@;!@!#@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@$@$$@$$@$@@@@@@@@@@==============");
		System.out.println("@@@@@@@@@@@#$$$$$$$$$$$#@@@@@@@=    나무꾼    =");
		 System.out.printf("@@@@@@@@@@@=;;; ;@; ;;!$@@@@@@@= %s =\n", BattleService.enemyHP);
		System.out.println("@@@@@@@@@@@=;;;;;;;;;;!$@@@@@@@==============");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@*         *@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@$  !!!!!  $@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@-;@# @===@ #@;-@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@=#@@~~~@@#$@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@=~~~~~~~~:$@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@=~~~~~~~~:$@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@=~~~~~~~~:$@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@=~~~~~~~~:$@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@=~~~~~~~~:$@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@$~~~~~~~~:$@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@~~~~~~~~:@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@....;@~~~~~~:@;....@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@....:@@=~~~=@@:....@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@..:~:$-@@@@@-$:~:..@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@..=;:$ @...@ $:;=..@@@@==============");
		System.out.println("@@@@@@@@..=;:$ @...@ $:;=..@@@@=     잭       ");
		 System.out.printf("@@@@@@@@..=;:$ @...@ $:;=..@@@@= %s =\n", BattleService.myHP);
		System.out.println("@@@@@@@@..=;:@@@...@@@:;=..@@@@==============");
		System.out.println("@@@@@@@@..=;:$ @...@ $:;=..@@@@=  [전투 행동]   ");
		System.out.println("@@@@@@@@@@@@;:@@@...@@@:;@@@@@@=  1. 공격     ");
		System.out.println("-------------------------------=  2. 회복     ");
		System.out.println("                               =  3. 도망     ");
		 System.out.printf("%-28s    \n", BattleService.str1);
		 System.out.printf("%-28s    \n", BattleService.str2);
		  System.out.print("                               =   >>");

	}

	public static void battleResult() {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@===========================================@");
		System.out.println("@=                                         =@");
		 System.out.printf("  %-40s\n", BattleService.str1);
		System.out.println("@=                                         =@");
		 System.out.printf("  %-40s\n", BattleService.str2);
		System.out.println("@=                                         =@");
		System.out.println("@===========================================@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@==============");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@=계속하려면      ");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@= 아무키나 입력하기");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@==============");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@= 입력후 Enter  ");
		  System.out.print("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@=   >>");
	}
	

	public static void store() {

		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@===========================================@");
		System.out.println("@=                                         =@");
		System.out.println("@=                [상  점]                  =@");
		System.out.println("@=                                         =@");
		System.out.println("@= 1. 동도끼 (100G)                          =@");
		System.out.println("@= 2. 은도끼 (200G)                          =@");
		System.out.println("@= 3. 금도끼 (300G)                          =@");
		System.out.println("@= 4. 비료 (50G)                            =@");
		System.out.println("@= 5. 물약 (100G)                            =@");
		System.out.println("@= 6. 해충제 (80G)                           =@");
		System.out.println("@= 7. 가위 (20G)                            =@");
		System.out.println("@=                                         =@");
		System.out.println("@= 0. 상점 나가기                             =@");
		System.out.println("@=                                         =@");
		System.out.println("@===========================================@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@==============");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@=   소유 골드    ");
		 System.out.printf("-------------------------------=  %d\n",UserState.getGold());
		 System.out.printf("       %s\n", StorerItemService.str);
		System.out.println("-------------------------------=   메뉴 선택    ");
		  System.out.print("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@=   >>");
	}
	
	
	public static void treeCareItem() {

		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@===============================@@@@@@@@@@@@@");
		System.out.println("@=    ...       ...       ...    =@@@@@@@@@@@@");
		System.out.println("@=   !@@@#     $@@@$     #@@@!   =@@@@@@@@@@@@");
		System.out.println("@=   !@~@@     #@~@#     @@~@!   =@@@@@@@@@@@@");
		System.out.println("@=   !@.@@     #@.@#     @@.@!   =@@@@@@@@@@@@");
		System.out.println("@=   !@.@@     #@.@#     @@.@!   =@@@@@@@@@@@@");
		System.out.println("@=   !@.@@     #@.@#     @@.@!   =@@@@@@@@@@@@");
		System.out.println("@=   !@.@@     #@.@#     @@.@!   =@@@@@@@@@@@@");
		System.out.println("@=  *@,.-@=   #@,.,@#   =@-.,@*  =@@@@@@@@@@@@");
		System.out.println("@=  =!...;@   @;...;@   @;...!=  =@@@@@@@@@@@@");
		System.out.println("@=  =;....@   @-...-@   @....;=  =@@@@@@@@@@@@");
		System.out.println("@=  =*::::@   @;:::;@   @::::*=  =@@@@@@@@@@@@");
		System.out.println("@=  =#$$$$@   @$$$$$@   @$$$$#=  =@@@@@@@@@@@@");
		System.out.println("@=  =:    @   @,   ,@   @    :=  =@@@@@@@@@@@@");
		System.out.println("@@##@#$$$$@###@#$$$#@###@$$$$#@##@@@@@@@@@@@@@");
		System.out.println("@#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#@@@@@@@@@@@@");
		System.out.println("@$                               $@@@@@@@@@@@@");
		System.out.println("@#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#@@@@@@@@@@@@");
		System.out.println("@@###############################@@@@@@@@@@@@@");
		System.out.println("@=                               =@@@@@@@@@@@@");
		System.out.println("@=   ;$$$~     !$$$!     ~$$$;   =============");
		System.out.println("@=   !@:@@     #@:@#     @@:@!   = [아이템 메뉴] ");
		System.out.println("@=   !@.@@     #@.@#     @@.@!   = 1. 비료     ");
		System.out.println("@=   !@.@@     #@.@#     @@.@!   = 2. 물약     ");
		System.out.println("@=   !@.@@     #@.@#     @@.@!   = 3. 해충제    ");
		System.out.println("@=   !@.@@     #@.@#     @@.@!   =            ");
		System.out.println("@=  .@=.;@-    @!.!@    -@;.=@   = 0. 나가기    ");
		System.out.println("---------------------------------=============");
		System.out.println("                                              ");
		System.out.println("                                              ");
		System.out.println("                                              ");
		System.out.println("---------------------------------=============");
		System.out.println("@@==@#====@===@$===$@===@====#@=== 사용할 아이템은?");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@=    >>");
	}
	
	
	
}