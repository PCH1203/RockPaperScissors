package rpsg;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

import com.framework.TcpApplication;

public class Game extends GameAppClient  {			
	
public static void play() {	         

        //입력 메서드 객체화
        Scanner sc = new Scanner(System.in);        
        //컴퓨터와 유저가 무었을 내었는지 확인
        String comStr="",userStr="";        
        //결과
        int fail=0;
        
        //게임 시작
        System.out.println("\r\n" + 
                "■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■\r\n" +
                "■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■\r\n" +
                "\r\n"+
        		"   _____   ___  ___  ___ _____   _____  _____   ___  ______  _____ \r\n" + 
        		"  |  __ \\ / _ \\ |  \\/  ||  ___| /  ___||_   _| / _ \\ | ___ \\|_   _|\r\n" + 
        		"  | |  \\// /_\\ \\| .  . || |__   \\ `--.   | |  / /_\\ \\| |_/ /  | |  \r\n" + 
        		"  | | __ |  _  || |\\/| ||  __|   `--. \\  | |  |  _  ||    /   | |  \r\n" + 
        		"  | |_\\ \\| | | || |  | || |___  /\\__/ /  | |  | | | || |\\ \\   | |  \r\n" + 
        		"   \\____/\\_| |_/\\_|  |_/\\____/  \\____/   \\_/  \\_| |_/\\_| \\_|  \\_/  \r\n" + 
        		"                                                                 \r\n" + 
        		"                                                                 \r\n" + 
        		  "■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■\r\n" +
        		  "■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■\r\n" +
        		"");
        System.out.println();
        System.out.println(" ┏			┓");
        System.out.println("	잔여코인: " + coin);
        System.out.println(" ┗			┛");
        System.out.println();
        System.out.println();
        System.out.println("가위[1] 바위[2] 보[3] 나가기[0]");
        System.out.println();
                
        for(int i=0; i<1000; i++) {
            //1~3의 랜덤 숫자
            int computer =(int)(Math.random()*3)+1;
            //사용자 입력값
            int user = sc.nextInt();
            //컴퓨터 값
            if(computer == 1) {
                comStr="가위";
            }else if(computer == 2) {
                comStr="바위";
            }else if(computer == 3) {
                comStr="보";
            }else {
                comStr="시스템 오류";
            }
            //유저의 값
            if(user == 1) {
                userStr="가위";
            }else if(user == 2) {
                userStr="바위";
            }else if(user == 3) {
                userStr="보";
            }else {
                userStr="손가락 오류";
            }if(user == 0) { // 게임 나오기
            	
            	GameAppClient.showMenu5();
            	
            	int select2 = sc.nextInt();

        		switch (select2) {	
        		
        		case 1:        			
        			Game.play();
        			break;            	
        			
        		case 2:
        			Shop.shopIn();
					break;		
        			
        		case 0:
        			System.out.println("프로그램을 종료합니다.");
        			pw.close();		      	
        			
        			System.exit(0);   		
        		} 
            }
            
            if(user >= 1 && user <= 3) {
                if((computer == 1 && user == 2) || (computer == 2 && user == 3) || (computer == 3 && user == 1)) {                    
                    coin = coin+2;
                    System.out.println("━━━━━━━━━━━ [ 승리 ] ━━━━━━━━━━━");
                    System.out.println();
                    System.out.println(" [유저] "+userStr+"  =VS= "+comStr+" [컴퓨터] ");
                    System.out.println();
                    System.out.println(" 2코인 획득!");
                    System.out.println();
                    System.out.println(" 잔여코인: " + coin);
                    System.out.println();
                    System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
                    
                }else if(computer == user) {                                        
                    System.out.println("━━━━━━━━━━ [ 무승부 ] ━━━━━━━━━━");
                    System.out.println();   
                    System.out.println(" [유저] "+userStr+"  =VS= "+comStr+" [컴퓨터] ");
                    System.out.println();
                    System.out.println(" 코인유지!");
                    System.out.println();
                    System.out.println(" 잔여코인: " + coin);
                    System.out.println();
                    System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
                 
                }else {                   
                    coin = coin-2;
                    System.out.println("━━━━━━━━━━━ [ 패배 ] ━━━━━━━━━━━");
                    System.out.println();
                    System.out.println(" [유저] "+userStr+"  =VS= "+comStr+" [컴퓨터] ");
                    System.out.println();
                    System.out.println(" 2코인 손실!");
                    System.out.println();
                    System.out.println(" 잔여코인: " + coin);
                    System.out.println();
                    System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
                    if(coin == 0) {
                   	 System.out.println();
                	 System.out.println("코인을 모두 소진 하였습니다.");
                	 System.out.println();    
                    System.out.println("잠시후 메인화면으로 돌아갑니다..");
                    System.out.println();
                    try {
            			Thread.sleep(1000);
            			System.out.println(" 1......");
            			System.out.println();
            		} catch (InterruptedException e) {			
            			e.printStackTrace();
            		}
                    try {
                    	Thread.sleep(1000);
                    	System.out.println(" 2......");
                    	System.out.println();
                    } catch (InterruptedException e) {			
                    	e.printStackTrace();
                    }
                    try {
                    	Thread.sleep(1000);
                    	System.out.println(" 3......");
                    	System.out.println();
                    } catch (InterruptedException e) {			
                    	e.printStackTrace();
                    }
                    try {
                    	Thread.sleep(1000);  
                    	System.out.println("※경고※ 지나친게임은 건강에 헤롭습니다...");
                    } catch (InterruptedException e) {			
                    	e.printStackTrace();
                    }
                    try {
                    	Thread.sleep(1000);                    	
                    } catch (InterruptedException e) {			
                    	e.printStackTrace();
                    }
                    
                    showMenu5();
                    	
                    }
                 
                }
            }else {
                fail++;
                System.out.println("값을 잘못 입력 하였습니다.");    
            }
     
            System.out.println();       
            System.out.println();  
        }        
 
        sc.close();
    }
}
 

	


