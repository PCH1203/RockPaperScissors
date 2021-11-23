package rpsg;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.framework.TcpApplication;

public class GameAppServer extends TcpApplication {

	//TcpApplication의 start 메소드 구현
	@Override
	public void start() {	
		
		System.out.println("게임 서버가 활성화되었습니다.");
		System.out.println();
		System.out.println("PLAYER 입장대기...");
		System.out.println();
		
		ServerSocket sServer = null;
		Socket cSocket		= null;
		Thread th		= null;		
		
		try {
			// 1. 서버소켓 생성
			sServer = new ServerSocket(PORT);			
			// 2. 클라이언트와 연결된 소켓 관리
			while(true) {
				cSocket = sServer.accept();	 // 설명: 클라이언트가 연결 될때 까지 대기		
				
				
				// 접속한 클라이언트 송수신을 담당할 스레드를 생성하여 소켓(cSocket)을 전달한다.
				// 접속자 수만큼 스레드가 생성된다. 				
				th = new Thread(new GameTcpServerHandler(cSocket));	
				th.start();				
			}					
			
		}catch (IOException ex) {
			ex.printStackTrace();			
		}	
	}

}
