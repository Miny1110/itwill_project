package project1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MyPageImpl implements MyPage{
	
	Scanner sc=new Scanner(System.in);
	
	MyPageVO vo = null;
	Ticket1VO voT = null;
	private List<Ticket1VO>listsT1 = null;

	
	public MyPageImpl(List<Ticket1VO> listsT1) {
		this.listsT1=listsT1;
	}
	
	public MyPageImpl(Ticket1VO voT) {
		this.voT=voT;
	}
	
	public MyPageImpl() {
		
	}
	
	@Override
	public void mypageMain(MyPageVO vo) {
		
		
		this.vo = vo;
		while(true) {
			System.out.println("1.예매확인 2.예매변경 3.예매취소 4.내 정보 5.로그아웃");
			int ch=sc.nextInt();
			

			switch(ch) {
			case 1: checkBooking(); break;
			case 2: modifyBooking(); break;
			case 3: cancleBooking(voT); break;
			case 4: searchInfo(); break;
			case 5: logout(); break;
		
			default : System.out.println("잘못된 선택입니다."); 
			System.exit(0);
			}
		}
		
		
		
		
		
	}

	@Override
	public void checkBooking() {
		
	}

	@Override
	public void cancleBooking(Ticket1VO voT) {
		
		
		Scanner sc= new Scanner(System.in);
		//this.listsTheater;
		
		
		Iterator<Ticket1VO> it = listsT1.iterator();
		voT=it.next();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("취소하시겠습니까? [yes/no]");
		String a=sc.next();
		
		if(a=="yes") {
			listsT1.remove(voT);
			System.out.println("취소되었습니다.");
		}else System.out.println("종료합니다.");
		
	
		
		
		
		
		
		
		
		
		
	}

	@Override
	public void modifyBooking() {
		
	}

	@Override
	public void searchInfo() {
		
		System.out.println("이름 : "+vo.getName());
		System.out.println("회원등급 : "+vo.getLevel());
		System.out.println("포인트 : "+vo.getPoint());
		System.out.println("영화관람횟수 : "+vo.getMoviecount());
	}

	@Override
	public void logout() {
		System.out.println("로그아웃을 완료하였습니다.");
		System.exit(0);
	}

}
