package project1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicketImpl implements Ticket{

	String[] theaterArr = {"강남","역삼","상봉"};
	String[] dateArr = {"6/30","7/1","7/2","7/3","7/4","7/5","7/6"};
	String[] timeArr = {"11:00","12:50","15:40","18:50"};
	String[] movieArr = {"탑건:매버릭","범죄도시2","마녀 part 2","브로커","버즈 라이트 이어","쥬라기월드:도미니언","헤어질 결심","미친능력","고스트랜드","보통의 용기","컴온컴온"};


	private List<DataVO> listsMovie = new ArrayList<>(); //영화상영 시간표를 넣을 리스트생성
	Random rd = new Random(); //movieArr 랜덤 추출
	List<TicketVO> listsTheater = new ArrayList<>();

	int i,j,k;

	public TicketImpl() { //생성자

		for(i=0;i<theaterArr.length;i++) {
			for(j=0;j<dateArr.length;j++) {
				for(k=0;k<timeArr.length;k++) {

					int n = rd.nextInt(movieArr.length);

					DataVO data = new DataVO(); //객체 생성해서
					data.setTheater(theaterArr[i]); //데이터 넣고
					data.setDate(dateArr[j]);
					data.setTime(timeArr[k]);
					data.setMovie(movieArr[n]);

					listsMovie.add(data); //데이터가 들어간 클래스를 리스트에 넣는다.
				}
			}
		}

		/*
		Iterator<Data> it = listsMovie.iterator();
		while(it.hasNext()) {
			Data data = it.next();
			System.out.println(data.toString());
		}*/

	}

	//------------------------------------------------------------------------------------------	

	Scanner sc = new Scanner(System.in);
	int ch;

	public void choice() { //사용자가 예매방법을 선택한다.

		do {
			System.out.println("예매방법을 선택하세요");
			System.out.print("1.상영관예매 2.영화예매 3.날짜예매  ");

			ch = sc.nextInt();

		}while(ch<0 || ch>3); //입력값이 0미만이거나 3초과면 다시 질문한다.

		switch(ch) {

		case 1: theater(); break; //상영관예매
		case 2: movie(); break; //영화예매
		case 3: date(); break; //날짜예매

		}
	}


	@Override
	public void theater() { //영화관예매
		
		List<DataVO> tLists = new ArrayList<>(); //사용자의 입력조건에 맞는 영화목록을 담을 리스트
		TicketVO voT = new TicketVO(); //사용자의 입력값을 넣을 TicketVO 객체생성
		int j = 1;

		System.out.println("영화관을 선택하세요");
		for(int i=0;i<theaterArr.length;i++) { //영화관 목록 출력
			System.out.printf("%d.%s  ", i+1, theaterArr[i]);
		}
		voT.setTheater(theaterArr[sc.nextInt()-1]);

		System.out.println("날짜를 선택하세요");
		for(int i=0;i<dateArr.length;i++) { //날짜 목록 출력
			System.out.printf("%d.%s  ", i+1, dateArr[i]);
		}
		voT.setDate(dateArr[sc.nextInt()-1]);

		System.out.println("영화를 선택하세요"); //영화 목록 출력
		Iterator<DataVO> it = listsMovie.iterator(); //DataVO 리스트에서 데이터를 가져온다.
		while(it.hasNext()) {
			DataVO voD = it.next();
			if(voT.getTheater().equals(voD.getTheater()) && voT.getDate().equals(voD.getDate())) {
				tLists.add(voD);
				System.out.println(j + "." + voD.toString());
				j++;
			}
		}
		int n = sc.nextInt();
		
		System.out.print("인원을 입력하세요");
		voT.setInwon(sc.nextInt());

		for(int i=1;i<=voT.getInwon();i++) {
			System.out.print("좌석열을 선택하세요(1~10)");
			voT.setSeatRow(sc.nextInt());
			
			System.out.print("좌석번호를 선택하세요(1~10)");
			voT.setSeatNum(sc.nextInt());
		}

		System.out.printf("결제방법을 선택하세요[1.카드/2.현금] (금액: %d)\n", voT.getTot());
		voT.setPay(sc.nextInt());
		
		System.out.println("예매 완료!");
		listsTheater.add(voT);
	}

	@Override
	public void movie() {
	}

	@Override
	public void date() {
	}


	public static void main(String[] args) {
		TicketImpl impl = new TicketImpl();
		impl.choice();
		impl.theater();
	}
}
