package rpsg;

import java.util.Scanner;

import com.framework.TcpApplication;

public class GameTcpServer {	
	public static void main(String[] args) {
		
		// 스캐너 생성
		Scanner sc = new Scanner(System.in);		
		// 첫번째 메뉴 보여주기
		showMenu4();
		showMenu();

		int select = sc.nextInt();		
		
		switch (select) {
		//서버 활성화
		case 1:
			TcpApplication app = new GameAppServer();
			app.init();
			app.start();
			sc.close();
			break;
		//프로그램 종료
		case 0:	
			System.out.println("프로그램을 종료합니다.");
			System.exit(0);			
		}//switch scope		

	}//main scope

	private static void showMenu() {
		System.out.printf("                                      \n");
		System.out.printf("                                      \n");
        System.out.printf("          ■■■■■■■■■■■■■■■■■■■■■■■■■■■■\n");
        System.out.printf("          ■                          ■                        ■\n");
        System.out.printf("          ■      <<< SERVER >>>      ■   <<< 211기 6조 >>>    ■\n");
        System.out.printf("          ■                          ■                        ■\n");
        System.out.printf("          ■■■■■■■■■■■■■■■■■■■■■■■■■■■■\n");
        System.out.printf("                                      \n");

        System.out.printf("                                      \n"); 
        System.out.printf("서버를 활성화 하시겠습니까?                   \n");
        System.out.printf("                                      \n");
        System.out.printf("          [1] → yes            ");
        System.out.printf("[0] → No                     \n");
        System.out.printf("                                      \n");
        System.out.printf("                                      \n");		
		
	}
	
	public static void showMenu4() {
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
