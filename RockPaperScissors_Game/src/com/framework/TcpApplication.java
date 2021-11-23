package com.framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public abstract class TcpApplication { //추상메소드

	public static String IP;
	public static int PORT;
	public static String CONFIG = "config/applicationcontext.ini";	
	
	//[초기화] IP,PORT 초기화
	public void init() {
		
		//설정데이터로부터 필요한 항목을 추출
		Properties settings = new Properties();
				
		try {
			settings.load(new FileInputStream(CONFIG)); //load를 통행 정보 저장.
			IP = settings.getProperty("IP"); // "IP"의 벨류 값을 리턴
			PORT = Integer.parseInt(settings.getProperty("PORT")); //"PORT"의 벨류값을 리턴

		}catch (IOException e) {
			System.out.println("설정파일(applicationcontext.ini)를 찾을수 없습니다.");
			System.out.println("프로그램을 종료합니다.");
			System.exit(0);			
				}		
	}	

	public abstract void start();	
	//GameAppServer에서 상속받아서 구현
	//GameAppClient에서 상속받아서 구현

}

