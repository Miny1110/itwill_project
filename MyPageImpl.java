package project1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MyPageImpl extends StartPageImpl implements MyPage{
	
	Scanner sc=new Scanner(System.in);
	//Map<String, MyPageVO> hMap=new TreeMap<>();
	//Map<String, Ticket1Impl> hMap2=new TreeMap<>();
	Ticket1Impl tkImpl = new Ticket1Impl();
	
	
	@Override
	public void mypageMain() {
		
		new MyPageImpl();
		
		while(true) {
			System.out.println("1.예매확인 2.예매변경 3.예매취소 4.내 정보 5.로그아웃");
			int ch=sc.nextInt();
			//System.out.println(hMap);

			switch(ch) {
			case 1: checkBooking(); break;
			case 2: cancleBooking(); break;
			case 3: modifyBooking(); break;
			case 4: searchInfo(); break;
			case 5: logout(); break;
		
			default : System.out.println("잘못된 선택입니다."); 
			System.exit(0);
			}
		}

	}

	@Override
	public void checkBooking() {
		
		
		Iterator<Ticket1VO> it = tkImpl.listsT1.iterator();
		while(it.hasNext()) {
			Ticket1VO vo = it.next();
			vo.print();
		}
		
		/*
		Iterator<String> it = hMap2.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next(); //key
			
			if(key.equals(id)) {
				tki = hMap2.get(id); //value를 꺼내온다.
				
			}
		}
		*/
		
	}

	@Override
	public void cancleBooking() {
	}

	@Override
	public void modifyBooking() {
	}

	@Override
	public void searchInfo() {
		
		MyPageVO vo = hMap.get(checkID);
			
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
