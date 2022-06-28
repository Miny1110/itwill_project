package project1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Ticket1Impl implements Ticket{

	String[] theaterArr = {"강남","역삼","상봉"};
	String[] dateArr = {"6/30","7/1","7/2","7/3","7/4","7/5","7/6"};
	String[] timeArr = {"11:00","12:50","15:40","18:50"};
	String[] movieArr = {"탑건:매버릭","범죄도시2","마녀 part 2","브로커","버즈 라이트 이어","쥬라기월드:도미니언","헤어질 결심","미친능력","고스트랜드","보통의 용기","컴온컴온"};


	private List<DataVO> listsMovie = new ArrayList<>(); //영화상영 시간표를 넣을 리스트생성
	Random rd = new Random(); //movieArr 랜덤 추출
	List<Ticket1VO> listsT1 = new ArrayList<>(); //Ticket1VO 타입 클래스 정보를 넣을 리스트 (사용자가 입력한 영화관, 날짜, 영화가 있다.)
	List<String> listsT2 = new ArrayList<>(); //좌석정보를 넣을 리스트 생성

	int i,j,k;
	int n;

	public Ticket1Impl() { //생성자

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
		Iterator<DataVO> it = listsMovie.iterator();
		while(it.hasNext()) {
			DataVO data = it.next();
			System.out.println(data.toString());
		}
		 */
	}

	//------------------------------------------------------------------------------------------	

	Scanner sc = new Scanner(System.in);
	int ch;

	public void choice() { //사용자가 예매방법을 선택한다.

		do {
			System.out.println("***예매방법을 선택하세요***");
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
		
		List<DataVO> listsMovie2 = new ArrayList<>(); //입력날짜,시간의 전체영화목록을 담을 리스트
		Ticket1VO voT1 = new Ticket1VO(); //사용자의 입력값을 넣을 Ticket1VO 객체생성
		int j = 1;

		System.out.println("***영화관을 선택하세요***");
		for(int i=0;i<theaterArr.length;i++) { //영화관 목록 출력
			System.out.printf("%d.%s  ", i+1, theaterArr[i]);
		}
		voT1.setTheater(theaterArr[sc.nextInt()-1]);

		System.out.println("***날짜를 선택하세요***");
		for(int i=0;i<dateArr.length;i++) { //날짜 목록 출력
			System.out.printf("%d.%s  ", i+1, dateArr[i]);
		}
		voT1.setDate(dateArr[sc.nextInt()-1]);

		System.out.println("***영화를 선택하세요***"); //영화 목록 출력
		Iterator<DataVO> it = listsMovie.iterator(); //listsMovie 리스트에서 데이터를 가져온다.
		while(it.hasNext()) {
			DataVO voD = it.next();
			if(voT1.getTheater().equals(voD.getTheater()) && voT1.getDate().equals(voD.getDate())) {
				listsMovie2.add(voD);
				System.out.println(j + "." + voD.toString()); //입력날짜,시간의 영화목록 출력
				j++;
			}
		}
		
		n = sc.nextInt(); //사용자가 입력한 영화 번호
		voT1.setMovie(listsMovie2.get(n-1).toString()); //listsMovie2에서 사용자가 입력한 번호번째 데이터를 voT.setMoive에 대입
		
		listsT1.add(voT1);
		
		inputUserChoice2VO();
		
	}

	@Override
	public void movie() {
		
		List<DataVO> listsMovie2 = new ArrayList<>(); //입력영화,영화관의 전체영화목록을 담을 리스트
		Ticket1VO voT1 = new Ticket1VO(); //사용자의 입력값을 넣을 Ticket1VO 객체생성
		int j = 1;

		System.out.println("***영화를 선택하세요***");
		for(int i=0;i<movieArr.length;i++) { //영화 목록 출력
			System.out.printf("%d.%s  ", i+1, movieArr[i]);
		}
		voT1.setMovie(movieArr[sc.nextInt()-1]);

		System.out.println("***영화관을 선택하세요***");
		for(int i=0;i<theaterArr.length;i++) { //영화관 목록 출력
			System.out.printf("%d.%s  ", i+1, theaterArr[i]);
		}
		voT1.setTheater(theaterArr[sc.nextInt()-1]);

		System.out.println("***날짜를 선택하세요***"); //날짜 목록 출력
		Iterator<DataVO> it = listsMovie.iterator(); //listsMovie 리스트에서 데이터를 가져온다.
		while(it.hasNext()) {
			DataVO voD = it.next();
			if(voT1.getMovie().equals(voD.getMovie()) && voT1.getTheater().equals(voD.getTheater())) {
				listsMovie2.add(voD);
				System.out.println(j + "." + voD.toString()); //입력영화,영화관의 영화목록 출력
				j++;
			}
		}
		
		n = sc.nextInt(); //사용자가 입력한 영화 번호
		voT1.setDate(listsMovie2.get(n-1).toString()); //listsMovie2에서 사용자가 입력한 번호번째 데이터를 voT.setDate에 대입
		
		listsT1.add(voT1);
		
		inputUserChoice2VO();
		
	}

	@Override
	public void date() {
		
		List<DataVO> listsMovie2 = new ArrayList<>(); //입력날짜,영화관의 전체영화목록을 담을 리스트
		Ticket1VO voT1 = new Ticket1VO(); //사용자의 입력값을 넣을 Ticket1VO 객체생성
		int j = 1;

		System.out.println("***날짜를 선택하세요***");
		for(int i=0;i<dateArr.length;i++) { //날짜 목록 출력
			System.out.printf("%d.%s  ", i+1, dateArr[i]);
		}
		voT1.setDate(dateArr[sc.nextInt()-1]);

		System.out.println("***영화관을 선택하세요***");
		for(int i=0;i<theaterArr.length;i++) { //영화관 목록 출력
			System.out.printf("%d.%s  ", i+1, theaterArr[i]);
		}
		voT1.setTheater(theaterArr[sc.nextInt()-1]);

		System.out.println("***영화를 선택하세요***"); //영화 목록 출력
		Iterator<DataVO> it = listsMovie.iterator(); //listsMovie 리스트에서 데이터를 가져온다.
		while(it.hasNext()) {
			DataVO voD = it.next();
			if(voT1.getDate().equals(voD.getDate()) && voT1.getTheater().equals(voD.getTheater())) {
				listsMovie2.add(voD);
				System.out.println(j + "." + voD.toString()); //입력날짜,영화관의 영화목록 출력
				j++;
			}
		}
		
		n = sc.nextInt(); //사용자가 입력한 영화 번호
		voT1.setMovie(listsMovie2.get(n-1).toString()); //listsMovie2에서 사용자가 입력한 번호번째 데이터를 voT.setMoive에 대입
		
		listsT1.add(voT1);
		
		inputUserChoice2VO();
		
	}
	
	
	public void inputUserChoice2VO() {

		Ticket1VO voT1 = new Ticket1VO(); //입력값을 넣을 객체 생성
		String str;
		
		do {
			System.out.print("***인원을 입력하세요***");
			voT1.setInwon(sc.nextInt());
		}while(voT1.getInwon()<0);

		System.out.printf("***[총인원 %d명]***\n",voT1.getInwon());

		
		for(int i=1;i<=voT1.getInwon();i++) {

			do {
				
			System.out.print("***[" + i + "]번째 좌석을 입력하세요(열-번호:1-10)***");
			str = sc.next();
			
			}while (!Pattern.matches("[0-9]+-[0-9]+", str));
			
			
			if(listsT2.contains(str)) {
				System.out.println("이미 선택된 좌석입니다");
				i--;
			}
			voT1.setSeat(str);
			listsT2.add(str);
		}
		
		System.out.printf("***결제방법을 선택하세요[1.카드/2.현금] (총금액: %d)***\n", voT1.getTot());
		voT1.setPay(sc.nextInt());

		System.out.println("***예매 완료!***");
		
		listsT1.add(voT1);
		
		/*
		System.out.printf("%s %d명\n", voT1.getMovie(), voT1.getInwon());
		
		Iterator<String> it4 = listsT2.iterator();
		while(it4.hasNext()) {
			String vo = it4.next();
			System.out.printf("좌석(열-번호): %s\n",vo);
		}
		*/
		
	}
	
	/*
	public void print() {
		
		Ticket1VO voT1 = new Ticket1VO();
		
		System.out.printf("%s %d명\n", voT1.getMovie(), voT1.getInwon());
		
		Iterator<String> it4 = listsT2.iterator();
		while(it4.hasNext()) {
			String vo = it4.next();
			System.out.printf("좌석(열-번호): %s\n",vo);
		}
		
	}
	*/
	/*
	public static void main(String[] args) {
		Ticket1Impl impl = new Ticket1Impl();
		impl.choice();
		
	}
	*/
}
