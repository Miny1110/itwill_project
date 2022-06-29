package project1;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class StartPageImpl implements StartPage {
	
	
	
	private List<MyPageVO> lists = null;	//list선언-main절에서 보내주는 list데이터 받을 곳 생성
	Scanner sc = new Scanner(System.in);


	public StartPageImpl(List<MyPageVO> lists) {	//기본생성자 만들어주기. 데이터 어떻게 처리할건지 startpageimpl list를 변수로 받는다
		this.lists = lists;	//받은 list를 이 클래스의 list에 넣어라
	}

	@Override
	public void input() {

		MyPageVO vo = new MyPageVO();	//vo 선언&객체생성	list타입을 받았으니까 vo만들고 사용하기 가능

		System.out.println("회원가입을 시작하겠습니다.");
		System.out.println("---------------------------");

		System.out.println("ID를 입력하세요");
		String id = sc.next();

		while (true) {
			if (id.equals(vo.getId())) {
				System.out.println("이미 존재하는 아이디입니다.");
				System.out.println("다시 입력해주세요.");
				id = sc.next();
			} else {
				vo.setId(id);
				break;
			}
		}

		System.out.println("비밀번호를 입력하세요.");
		String pw = sc.next();

		while (true) {
			if (pw.length() < 2) {
				System.out.println("비밀번호는 2자 이상이여야합니다.");
				System.out.println("다시 입력해주세요.");
				pw = sc.next();
			} else {
				vo.setPassword(pw);
				break;
			}
		}

		System.out.println("비밀번호를 다시 입력해주세요");
		pw = sc.next();

		while (true) {
			if (!pw.equals(vo.getPassword())) {
				System.out.println("비밀번호가 같지 않습니다.");
				System.out.println("다시 입력해주세요.");
				pw = sc.next();
			} else
				break;

		}

		System.out.println("이름을 입력해주세요");
		vo.setName(sc.next());

		System.out.println("생년월일을 입력해주세요[yymmdd]");
		vo.setBirth(sc.next());

		vo.setPoint(500);
		vo.setMoviecount(0);

		lists.add(vo);	//list생성

		System.out.println("회원가입이 완료되었습니다. 가입축하적립금 500P를 드렸습니다.");
		System.out.println("로그인 페이지로 이동합니다.");

		System.out.println("----------------------------");

		login();

	}

	@Override
	public void login() {

		Ticket1Impl tki = new Ticket1Impl();
		MyPageImpl mpi = new MyPageImpl();

		
		Iterator<MyPageVO> it = lists.iterator();	//이터레이터 만들기

		boolean result = false;
		System.out.println("ID를 입력하세요.");
		String checkID = sc.next();
		MyPageVO vo=null;

		while (it.hasNext()) {
			vo = it.next();
			if (checkID.equals(vo.getId())) {
				result = true;
				
				break;
			}
		}

		if (!result) {
			System.out.println("존재하지 않는 아이디입니다.");
			return;

			
			
		}
		System.out.println("비밀번호를 입력하세요.");
		String checkPW = sc.next();

		if (!checkPW.equals(vo.getPassword())) {

			System.out.println("[로그인실패]아이디/비밀번호가 일치하지 않습니다.");

		} else {

			System.out.println("[로그인완료]" + checkID + "님 반갑습니다.");
			System.out.println("-------------------------------------");

			while (true) {
				System.out.println("1.영화정보 2.영화예매 3.마이페이지 4.로그아웃");
				int ch = sc.nextInt();
				
				

				switch (ch) {
				case 1:
					break;
				case 2: tki.choice(); break;
				case 3: mpi.mypageMain(vo); break;
				case 4: mpi.logout(); break;

				default:
					System.out.println("잘못된 선택입니다.");
					System.exit(0);
				}
			}

		}
	}

}
