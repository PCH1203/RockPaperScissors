package rpsg;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Shop extends GameAppClient {
	
	String bookName = "책이름";
	int bookCoin = 0;

      public static void shopIn() { // 메소드로 묶어주었다 (호출하면 반복하게)   
    	  
       Scanner sc = new Scanner(System.in);   
    	
    	shopMain();
    	shopManu();
     	  
      while(true) {   
    	  
      int select2 = sc.nextInt();             
      switch (select2) {
      case 1 : menuSwitch("추억의 쫀드기", 3); break;
      case 2 : menuSwitch("이빨나가는 밭두렁", 5); break;
      case 3 : menuSwitch("옥수수 브이콘", 4); break;      
      case 4 : menuSwitch("안주용 숏다리", 6); break;
      case 5 : menuSwitch("개발자", 99); break;
      case 0 :     	  
    	  GameAppClient.showMenu5();   

  		switch (select2) {	
  		
  		case 1:			           
  			Game.play();
  			break;
  			
  		case 2:		
  			Shop.shopIn();
  			break;				
  			
  		case 0:
  			System.out.println("프로그램을 종료합니다.");
  			
  			System.exit(0);	
  			
  		default:
  			System.out.println("다시 입력하세요");
  		    break;		
  		}      
    	  
    	  break;                     
      default : System.out.println("메뉴에 없는 항목입니다 다시 선택하세요");
                System.out.print("   > ");      
                continue;             
      }
  }// while 스코프    
      
    
 
 } //shopIn() 스코프     
  
   public static void shopMain() { 
	     System.out.println(" ──────────────────────────────────────────────────────────────────────── ");
         System.out.println("                                                      ");
         System.out.println("                                                     \r\n" + 
               "    ______             ____      _____  _   _  _____ ______    \r\n" + 
               "    | ___ \\           / ___|    /  ___|| | | ||  _  || ___ \\   \r\n" + 
               "    | |_/ /  ______  / /___     \\ `--. | |_| || | | || |_/ /   \r\n" + 
               "    | ___ \\ |______| | ___ \\     `--. \\|  _  || | | ||  __/    \r\n" + 
               "    | |_/ /          | \\_/ |    /\\__/ /| | | |\\ \\_/ /| |       \r\n" + 
               "    \\____/           \\_____/    \\____/ \\_| |_/ \\___/ \\_|       \r\n" + 
               "                                                               \r\n" + 
               "                                                               " );
         System.out.println(" ──────────────────────────────────────────────────────────────────────── ");      
      }
      
   public static void shopManu() {    
       System.out.println();

       System.out.println("\r\n" + 
             "\r\n" + 
             "		___  ___ _____  _   _  _   _ \r\n" + 
             "		|  \\/  ||  ___|| \\ | || | | |\r\n" + 
             "		| .  . || |__  |  \\| || | | |\r\n" + 
             "		| |\\/| ||  __| | . ` || | | |\r\n" + 
             "		| |  | || |___ | |\\  || |_| |\r\n" + 
             "		\\_|  |_/\\____/ \\_| \\_/ \\___/ \r\n" + 
             "                             \r\n" + 
             "                             \r\n" + 
             "" 
             );
//       System.out.println(" ──────────────────────────────────────────────────────────────────── ");
       System.out.println();
       System.out.println("    1. 추억의 쫀드기  …………………………… (3코인)");
       System.out.println("    2. 이빨나가는 밭두렁  ………………… (5코인)");
       System.out.println("    3. 옥수수 브이콘  ………………………………… (4코인)");
       System.out.println("    4. 안주용 숏다리   ……………………………… (6코인)");
       System.out.println("    5. 개발자   …………………………………………… (99코인)");
       System.out.println();
       System.out.println();
       System.out.println(" …………………………………………………………………………………  ");
       System.out.println();
       System.out.println("    0. 메인화면으로 ");
       System.out.println();
       System.out.println();
       System.out.println(" ──────────────────────────────────────────────────────────────────── ");
       System.out.println();
       System.out.println("   ● [" + id +"님의 현재 코인 : " + coin + "]");
       System.out.println("   구매하실 상품의 번호를 입력하세요.");
       System.out.println();
       System.out.print("   > ");         
   }   
   
   static void menuSwitch(String bookName, int bookCoin) {
   
   System.out.println();
   System.out.println(" > [" + bookName + "]은(는) [" + bookCoin + "코인]입니다. 구입할까요? ");
   System.out.println("   ● (" + id + "님의 현재 코인 :" + coin + ")");
   System.out.println();
   System.out.println("      ☞ 1. YES      ☞ 2. NO      ");
   System.out.print("   > ");
   System.out.println();
   
   int select2 = sc.nextInt();
   
   
// 현재 코인보다 사려는 물품이 클때엔 에러메시지 출력하게함
   if (coin >= bookCoin) {
   
   switch (select2) {
   
   case 1 :
	   coin = coin-bookCoin;
	   System.out.println(bookName + "구매했습니다.");
	   System.out.println();
	   System.out.println(id+"님의 잔여 코인: " + (coin) );
	   System.out.println();
	   try {
			Thread.sleep(1000);
			System.out.println();
			System.out.println(" ......3");
		} catch (InterruptedException e) {		
			e.printStackTrace();
		}
		   try {
			   Thread.sleep(1000);
			   System.out.println();
			   System.out.println(" ......2");
		   } catch (InterruptedException e) {		
			   e.printStackTrace(); 
		   }
		   try {
			   Thread.sleep(1000);
			   System.out.println();
			   System.out.println(" ......1");
		   } catch (InterruptedException e) {		
			   e.printStackTrace();
		   }	   
		   try {
			   Thread.sleep(1000);
		
		   } catch (InterruptedException e) {		
			   e.printStackTrace();
		   }	   
	   shopManu();
	   break;
	   
   case 2 :
	   System.out.println();
	   System.out.println(bookName + "구매를 취소 하였습니다.");
	   System.out.println();	
	   System.out.println("3초후에 메뉴로 돌아 갑니다.");
	   
	   try {
		Thread.sleep(1000);
		System.out.println();
		System.out.println(" 3");
	} catch (InterruptedException e) {		
		e.printStackTrace();
	}
	   try {
		   Thread.sleep(1000);
		   System.out.println();
		   System.out.println(" 2");
	   } catch (InterruptedException e) {		
		   e.printStackTrace();
	   }
	   try {
		   Thread.sleep(1000);
		   System.out.println();
		   System.out.println(" 1");
	   } catch (InterruptedException e) {		
		   e.printStackTrace();
	   }	   
	   
	   shopManu();
   
	   break;
   }
   
   } else {
       System.out.println (" > 코인이 부족합니다. 다시 확인해주세요.");
       System.out.println(" 구매를 취소하고 메뉴 화면으로 돌아갑니다. ");
      System.out.println("3초후에 메뉴로 돌아 갑니다.");
      try {
      Thread.sleep(3000);
      System.out.println();
      System.out.println(" 3");
   } catch (InterruptedException e) {      
      e.printStackTrace();
   }
       shopManu();

   
   }  

   }
}
