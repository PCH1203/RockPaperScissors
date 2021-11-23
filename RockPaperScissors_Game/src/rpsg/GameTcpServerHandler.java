package rpsg;
/*
 * AppServer로부터 전달받은 소켓을 이용하여
 * 클라이언트의 접속 정보 및 송수신 기능을 관리한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;

import com.framework.TcpApplication;

public class GameTcpServerHandler implements Runnable {
	
	//클라이언트 ID를 키(K)로 하는 송신(V)을 위한 맵 자료구조.
	
	public static HashMap<String, PrintWriter> sendMap = new HashMap<>();
	
	// 클라이언트와 연결된 소켓 객체
	private Socket sock;	
	// 클라이언트 IP 주소
	private String cAddr;	
	// 클라이언트 ID
	private String id;			

	// [생성자] 받아온 소켓을 맵에 저장.
	public GameTcpServerHandler(Socket cSocket) {
		this.sock = cSocket;		
		this.cAddr = sock.getInetAddress().getHostAddress();		
	}	

	@Override
	public void run() {
		try {
			// 1. 송신 스트림 얻기
			PrintWriter    pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));			
			// 2. 수신 스트림 얻기
			BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));			
			// 3. 클라이언트 접속정보 저장
			id = br.readLine(); // AppClient pw.println(id)에서 데이터 전송  → br.readline으로 읽어서 id에 리턴
			GameTcpServerHandler.sendMap.put(id, pw);		
		
			// 4. 클라이언트 입장 정보를 브로드캐스팅
			System.out.println();
			broadCast("[" + id + "] 님이 접속하였습니다.");
			broadCast("참여1인원: " + sendMap.size() + "명");
			System.out.println();
			
			System.out.println();
			System.out.println("[" + id + "] 님이 접속하였습니다.");
//			System.out.println(cAddr + "← connected");
			System.out.println("참여인원: " + sendMap.size() + "명");
			
			if(sendMap.size() == 4) {
				System.out.println();
				System.out.println("6조 전원 입장 하였습니다.");
				System.out.println();
				System.out.println("모두 즐겜 하세요~~~!");
				System.out.println();
			}else {
				broadCast("게임 시작 하겠습니다.");
			}
			
			// 5. 송/수신	
			String line = null;
			while((line = br.readLine()) != null) {
				// 퇴장하는 경우
				if(line.equalsIgnoreCase("0")) {
					// 퇴장정보 브로드캐스팅
					GameTcpServerHandler.broadCast("[" + id + "] 님이 퇴장하셨습니다..");
					System.out.println();
					sendMap.remove(id);
					break;
				}	
			}				
			/*
			 * / 퇴장하는 경우 처리
			 */
			// 맵 삭제
			sendMap.remove(id);
			System.out.println("[" + id + "] 님이 퇴장 하셨습니다.");
			System.out.println();
			System.out.println("남은 접속자 수: " + sendMap.size() + "명");
			
			pw.close();
			br.close();
			sock.close();			
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}finally {
			
		}		
	}	
	/* 메시지 일괄 전송 메서드
	 *  : 모든 참여자에게 일괄 전송.
	 */
	public static void broadCast(String message) {
		// sendMap에 여러 스레드가 접근하므로 동기화(synchronized) 처리 필요
		synchronized (sendMap) {
			
			// 접속한 모든 클라이언트들에게 메시지 전
			for(PrintWriter cpw : GameTcpServerHandler.sendMap.values()) {				
				cpw.println(message);
				cpw.flush();				
			}
		}		
	}

}
