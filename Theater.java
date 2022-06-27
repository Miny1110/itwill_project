package project1;

import java.util.Scanner;

public class Theater {

	Scanner sc = new Scanner(System.in);

	public void theaterChoice() {
	
		TheaterVO vo = new TheaterVO();
		
	do {
		System.out.println("영화관을 선택하세요");
		System.out.println("1.강남 2.역삼 3.상봉");
		
		vo.setTheater(sc.nextInt());
		
	}while(vo.getTheater()<0 || vo.getTheater()>4);
	
	}
	
	
}
