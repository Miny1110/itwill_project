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
	String[] moiveArr = {"탑건:매버릭","범죄도시2","마녀 part 2","브로커","버즈 라이트 이어","쥬라기월드:도미니언","헤어질 결심","미친능력","고스트랜드","보통의 용기","컴온컴온"};


	private List<DataVO> listsMovie = new ArrayList<DataVO>(); //리스트생성
	Random rd = new Random();

	int i,j,k;

	public TicketImpl() { //생성자

		for(i=0;i<theaterArr.length;i++) {
			for(j=0;j<dateArr.length;j++) {
				for(k=0;k<timeArr.length;k++) {

					int n = rd.nextInt(moiveArr.length);

					DataVO data = new DataVO();
					data.setTheater(theaterArr[i]);
					data.setDate(dateArr[j]);
					data.setTime(timeArr[k]);
					data.setMovie(moiveArr[n]);

					listsMovie.add(data);
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

	public void choice() {

		boolean flag = true;

		while(flag) {

			do {
				System.out.println("예매방법을 선택하세요");
				System.out.println("1.상영관예매 2.영화예매 3.날짜예매");

				ch = sc.nextInt();

			}while(ch<0 || ch>3);


			switch(ch) {

			case 1: theater(); break;

			case 2: movie(); break;

			case 3: date(); break;

			default: flag = false; break;

			}
		}
	}


	@Override
	public void theater() {
		
		
		
	}

	@Override
	public void movie() {
	}

	@Override
	public void date() {
	}


	public static void main(String[] args) {
		TicketImpl impl = new TicketImpl();

	}
}
