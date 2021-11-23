package rpsg;
/*
 * AppServer�κ��� ���޹��� ������ �̿��Ͽ�
 * Ŭ���̾�Ʈ�� ���� ���� �� �ۼ��� ����� �����Ѵ�.
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
	
	//Ŭ���̾�Ʈ ID�� Ű(K)�� �ϴ� �۽�(V)�� ���� �� �ڷᱸ��.
	
	public static HashMap<String, PrintWriter> sendMap = new HashMap<>();
	
	// Ŭ���̾�Ʈ�� ����� ���� ��ü
	private Socket sock;	
	// Ŭ���̾�Ʈ IP �ּ�
	private String cAddr;	
	// Ŭ���̾�Ʈ ID
	private String id;			

	// [������] �޾ƿ� ������ �ʿ� ����.
	public GameTcpServerHandler(Socket cSocket) {
		this.sock = cSocket;		
		this.cAddr = sock.getInetAddress().getHostAddress();		
	}	

	@Override
	public void run() {
		try {
			// 1. �۽� ��Ʈ�� ���
			PrintWriter    pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));			
			// 2. ���� ��Ʈ�� ���
			BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));			
			// 3. Ŭ���̾�Ʈ �������� ����
			id = br.readLine(); // AppClient pw.println(id)���� ������ ����  �� br.readline���� �о id�� ����
			GameTcpServerHandler.sendMap.put(id, pw);		
		
			// 4. Ŭ���̾�Ʈ ���� ������ ��ε�ĳ����
			System.out.println();
			broadCast("[" + id + "] ���� �����Ͽ����ϴ�.");
			broadCast("����1�ο�: " + sendMap.size() + "��");
			System.out.println();
			
			System.out.println();
			System.out.println("[" + id + "] ���� �����Ͽ����ϴ�.");
//			System.out.println(cAddr + "�� connected");
			System.out.println("�����ο�: " + sendMap.size() + "��");
			
			if(sendMap.size() == 4) {
				System.out.println();
				System.out.println("6�� ���� ���� �Ͽ����ϴ�.");
				System.out.println();
				System.out.println("��� ��� �ϼ���~~~!");
				System.out.println();
			}else {
				broadCast("���� ���� �ϰڽ��ϴ�.");
			}
			
			// 5. ��/����	
			String line = null;
			while((line = br.readLine()) != null) {
				// �����ϴ� ���
				if(line.equalsIgnoreCase("0")) {
					// �������� ��ε�ĳ����
					GameTcpServerHandler.broadCast("[" + id + "] ���� �����ϼ̽��ϴ�..");
					System.out.println();
					sendMap.remove(id);
					break;
				}	
			}				
			/*
			 * / �����ϴ� ��� ó��
			 */
			// �� ����
			sendMap.remove(id);
			System.out.println("[" + id + "] ���� ���� �ϼ̽��ϴ�.");
			System.out.println();
			System.out.println("���� ������ ��: " + sendMap.size() + "��");
			
			pw.close();
			br.close();
			sock.close();			
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}finally {
			
		}		
	}	
	/* �޽��� �ϰ� ���� �޼���
	 *  : ��� �����ڿ��� �ϰ� ����.
	 */
	public static void broadCast(String message) {
		// sendMap�� ���� �����尡 �����ϹǷ� ����ȭ(synchronized) ó�� �ʿ�
		synchronized (sendMap) {
			
			// ������ ��� Ŭ���̾�Ʈ�鿡�� �޽��� ��
			for(PrintWriter cpw : GameTcpServerHandler.sendMap.values()) {				
				cpw.println(message);
				cpw.flush();				
			}
		}		
	}

}
