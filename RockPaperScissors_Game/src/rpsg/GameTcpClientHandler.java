package rpsg;

import java.io.IOException;

import org.omg.CORBA.portable.ApplicationException;

/**
 * 
 * 
 * AppClient의 소켓을 이용하여
 * 서버의 수신 기능을 관리한다.
 * 
 */
public class GameTcpClientHandler implements Runnable {

	@Override
	public void run() {
		try {
			// 서버로부터 메시지 수신
			String line = null;
			while(true) {
				line = GameAppClient.br.readLine();
				if(line != null) {
					System.out.println(line);
				}
				
			}			
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}finally {
			try {
				if(GameAppClient.keyboard != null) {GameAppClient.keyboard.close();}
				if(GameAppClient.pw != null) {GameAppClient.pw.close();}
				if(GameAppClient.br != null) {GameAppClient.br.close();}
				if(GameAppClient.sSock != null) {GameAppClient.sSock.close();}
				
			} catch(IOException ex) { ex.printStackTrace();}
		}
				
	}
	
	
	

}
