package rpsg;

import java.util.Scanner;

import com.framework.TcpApplication;

public class GameTcpClient {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		showMenu3();
		showMenu1();	
		
		while(true) {
		int select = sc.nextInt();
		
		switch (select) {
	
		case 1:
			account();			
			break;			

		case 0:
			programout();
			System.exit(0);	
			break;			
			

		default:
			System.out.println("다시 입력하세요");
			break;
		}
		
		}// while문 스코프	

} //***********************메인 스코프************************************
	
	// 메소드 구현부 //
	
	private static void account() {
		TcpApplication app = new GameAppClient();
		app.init();		
		app.start();			
		sc.close();			
	}

	private static void programout() {
		System.out.println("잠시후 프로그램을 종료합니다.");
		System.out.println();
		try {
			Thread.sleep(1000);
			System.out.println(" ......1");
			System.out.println();
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		try {
			Thread.sleep(1000);
			System.out.println(" ......2");
			System.out.println();
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		try {
			Thread.sleep(1000);
			System.out.println(" ......3");
			System.out.println();
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		try {
			Thread.sleep(1000);
			System.out.println(" ......프로그램 종료");
			System.out.println();
		} catch (InterruptedException e) {		
			e.printStackTrace();
		}	
		try {
			Thread.sleep(1000);			
		} catch (InterruptedException e) {		
			e.printStackTrace();
		}		
	}

	private static void showMenu1() {
	System.out.printf("                                      \n");
	System.out.printf("                                      \n");
    System.out.printf("          ■■■■■■■■■■■■■■■■■■■■■■■■■■■■\n");
    System.out.printf("          ■                          ■                        ■\n");
    System.out.printf("          ■      <<< CLIENT >>>      ■   <<< 211기 6조 >>>    ■\n");
    System.out.printf("          ■                          ■                        ■\n");
    System.out.printf("          ■■■■■■■■■■■■■■■■■■■■■■■■■■■■\n");
    System.out.printf("                                      \r\n");
    System.out.printf("                                                               	       Ver.1\n");
    System.out.printf("                                      \n"); 
    System.out.printf("서버에 접속 하시겠습니까?                   \n");
    System.out.printf("                                      \n");
    System.out.printf("          [1] → 접속            ");
    System.out.printf("[0] → 나가기                     \n");
    System.out.printf("                                      \n");
    System.out.printf("                                      \n");		
	
}
	
	public static void showMenu3() {
		System.out.printf("                                      \n");
		System.out.printf("                                      \n");
		System.out.printf("\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				" ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■                                       \r\n" + 
				" ■                          .*           *,           *~                ■     \r\n" + 
				" ■      :;;;;: -@    ,@@@@~ .@   ~:   :  @~    $@@@*  @;    :.    :.    ■     \r\n" + 
				" ■      @@@@@@ -@    @#  *@ .@   $@   @  @~   =@  .@  @;    @,    @-    ■     \r\n" + 
				" ■          @$ -@    @    @ .@   $@   @  @~   #*   @* @;    @#$$$$@-    ■     \r\n" + 
				" ■         .@  -@    #@--@@ .@   $@@@@@  @~   !@:-#@  @;    @$====@-    ■     \r\n" + 
				" ■         @@  -@##   #@@$  .@   $@..,@  @@@.  ~@@@   @;    @,    @-    ■     \r\n" + 
				" ■        =@.  -@;;    .-:;;.@   $@   @  @*;.   .,~;;-@;    @@@@@@@-    ■     \r\n" + 
				" ■       @@-   -@   @@@@@@@#.@   $@..,@  @~  *@@@@@@@:@;       @;       ■     \r\n" + 
				" ■     -@@,    -@      *@   .@   $@@@@@  @~      @.   @;       @;       ■     \r\n" + 
				" ■      *      -@      *@   .@           @~      @.   @;  ~~~~~@*~~~~   ■     \r\n" + 
				" ■             -@      *@   .@           @~      @.   @;  @@@@@@@@@@@   ■     \r\n" + 
				" ■             -@      *@   .@           @~      @.   @;                ■     \r\n" + 
				" ■                                                                      ■     \r\n" + 
				" ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ \n");


		
		System.out.printf("                                      \n");	
	}	
	
}


