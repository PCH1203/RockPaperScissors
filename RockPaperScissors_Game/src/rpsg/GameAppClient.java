package rpsg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import com.framework.TcpApplication;

public class GameAppClient extends TcpApplication {
	
	public static PrintWriter pw = null;
	public static BufferedReader keyboard = null;
	public static BufferedReader br = null;
	public static Socket sSock = null;
	static Scanner sc = new Scanner(System.in);
	
	//기본 코인 할당		   
	static int coin = 10;
	
	// 서버 IP 주소
	private static String sAddr = null;
	
	// 클라이언트 ID
	static String id = null;	
	
	// 어플리케이션 초기화
	@Override
	public void init() {		
		super.init();
	}
	
	//어플리케이션 실행
	@Override
	public void start() {		
		
		try {
			// 1. 서버연결			
			sSock = new Socket(TcpApplication.IP, TcpApplication.PORT);
			sAddr = sSock.getInetAddress().getHostAddress();
			
		   // 2.1 송신 스트림 얻기			
		   pw = new PrintWriter(new OutputStreamWriter(sSock.getOutputStream()));

		   // 2.2 수신 스트림 얻기
		   br = new BufferedReader(new InputStreamReader(sSock.getInputStream()));
		   
		   // 2.3 키보드 스트림 얻기
		   keyboard = new BufferedReader(new InputStreamReader(System.in));
		   			
		   // 3. 클라이언트의 id를 전송한다.
		   System.out.println("서버에 접속하셨습니다.");
		   System.out.println("ID를 생성하세요");
		   System.out.println();
		   System.out.print("ID: ");		   

		   // id 변수에 버퍼에 저장된 입력 값 저장
		   id = keyboard.readLine();
		   System.out.println();
		   System.out.println(" ┌────────────────────────────────────────	안내	───────────────────────────────────────┐");
		   System.out.println();
		   System.out.println();
		   System.out.println("	[" + id + "]님 가위바위보 게임에 접속 하신걸 환영합니다.           	");
		   System.out.println();
		   System.out.println("	게임을 통해 COIN 을 획득 하시고 상점에 방문하여 원하는 상품을 구매해 보세요.	");
		   System.out.println();
		   System.out.println("	서버접속기념[ " + coin +"코인 ]이 지급 되었습니다.");
		   
		   // 서버에 id 전송
		   pw.println(id);	 
		   pw.flush();
		   
		   
		  //두번째 메뉴 출력
				showMenu2();
//				while(true) {
					
				int select2 = sc.nextInt();
				switch (select2) {	
				
				case 1:			           
					Game.play();
					break;
					
				case 2:		
					Shop.shopIn();
					break;				
					
				case 0:
					programout();					
					System.out.println("프로그램을 종료합니다.");
					pw.close();
					br.close();
					keyboard.close();
					sSock.close();
					System.exit(0);	
					
				default:
					System.out.println("다시 입력하세요");
				    break;					    
			}
//		} // while문 스코프
				// 4. 접속한 서버의 데이터 수신을 담당할 스레드를 생성하여 실행
				Thread thread = new Thread(new GameTcpClientHandler());
				thread.start();		
		   
			
		}catch (IOException ex) {
			ex.printStackTrace();
		}		
		   
	}
	public static void showMenu2() {
		  System.out.printf("					          		 \n");
		   System.out.printf("	접속할 장소를 선택하세요 .          		 \n");
		   System.out.println();
		   System.out.printf("                   			     \n");
		   System.out.printf("           [1] → 게임             ");
	       System.out.printf("[2] → 상점                 ");
	       System.out.printf("[0] → 나가기                    \n");
	       System.out.printf("                   			     \n");
	       System.out.println(" └────────────────────────────────────────────────────────────────────────────────────────────┘");
        
		}
	public static void showMenu5() {
		System.out.printf("					          		 \n");
		System.out.println(" ┌────────────────────────────────────────	안내	───────────────────────────────────────┐");
		System.out.printf("					          		 \n");
		System.out.printf("					          		 \n");
		System.out.printf("	접속할 장소를 선택하세요 .          		 \n");
		System.out.println();
		System.out.printf("                   			     \n");
		System.out.printf("           [1] → 게임             ");
		System.out.printf("[2] → 상점                 ");
		System.out.printf("[0] → 나가기                    \n");
		System.out.printf("                   			     \n");
		System.out.println(" └────────────────────────────────────────────────────────────────────────────────────────────┘");
		
		
	         int select2 = sc.nextInt();

	  		switch (select2) {	
	  		
	  		case 1:			           
	  			TcpApplication app = new GameAppClient();	
	  			Game.play();
	  			break;            	
	  			
	  		case 2:
	  			Shop.shopIn();
	 				break;		
	  			
	  		case 0:
	  			programout();
	  			
	  			
	  			break;
	  		}	          
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
	}

