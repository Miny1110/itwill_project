package project1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class MovieMain {
	

	String id;
	String checkID;

	
	static Scanner sc=new Scanner(System.in);

	public static void main(String[] args) {	//여러 곳에서 쓰일 데이터 객체생성을 main절에 하기
		
		List<MyPageVO> lists = new ArrayList<>();
		List<Ticket1VO> listsT1 = new ArrayList<>();

		
		StartPageImpl spi = new StartPageImpl(lists);	//그 데이터를 쓸 클래스 객체생성해서 데이터 보내는거 나타내기
		Ticket1Impl tki = new Ticket1Impl(listsT1);	//메인에서 선언하고 티켓임플리로 보내서 데이터를 담고 다른데로 보내기
		
		int ch;
			
		
		while(true) {
			do{
				System.out.println();
				System.out.println("[메가박스] ");
				System.out.println("서비스를 이용하시려면 로그인이 필요합니다.");
				System.out.println("1.로그인 2.회원가입");
				ch=sc.nextInt();
			}while(ch!=1 && ch!=2);

			switch(ch) {
			case 1: spi.login(); break;
			case 2: spi.input(); break;
		
			}
		}

	}

}

	
	
	

