package project1;


import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class StartPageImpl implements StartPage {

	static Scanner sc=new Scanner(System.in);

	String id;
	String checkID;
	Map<String, MyPageVO> hMap=new TreeMap<>();
	Map<String, Ticket1Impl> hMap2=new TreeMap<>();


	StartPageImpl mpi= new StartPageImpl();
	int ch;

	
	public void input() {
		
		while(true) {
			do{
				System.out.println();
				System.out.println("[메가박스] ");
				System.out.println("서비스를 이용하시려면 로그인이 필요합니다.");
				System.out.println("1.로그인 2.회원가입");
				ch=sc.nextInt();
			}while(ch!=1 && ch!=2);
			
			switch(ch) {
			case 1: mpi.login(); break;
			case 2: mpi.join(); break;
			
			}
		}
	}




	@Override
	public void login() {
		Ticket1Impl tki= new Ticket1Impl();
		MyPageImpl mpi= new MyPageImpl();

		//Iterator<String> it=hMap.keySet().iterator();	//it.keyset => 키값들의 모임을 불러내는것
		//출력을 하거나 비교하거나 이런 행위를 할때 정렬이 필요해서 iterator를 해
		System.out.println("ID를 입력하세요.");
		checkID = sc.next();

		//Iterator<String> it=hMap.keySet().iterator();
		MyPageVO vo = hMap.get(checkID);

		if(!hMap.containsKey(checkID))
			System.out.println("존재하지 않는 아이디입니다.");
		else {
			System.out.println("비밀번호를 입력하세요");
			String checkPW=sc.next();
			if(!vo.getPassword().equals(checkPW)){

				System.out.println("[로그인실패]아이디/비밀번호가 일치하지 않습니다.");


			}else {

				System.out.println("[로그인완료]"+checkID+"님 반갑습니다.");
				System.out.println("-------------------------------------");

				while(true) {
					System.out.println("1.영화정보 2.영화예매 3.마이페이지 4.로그아웃");
					int ch=sc.nextInt();

					switch(ch) {
					case 1:  break;
					case 2: tki.choice(); hMap2.put(id, tki); break;
					case 3: mpi.mypageMain(); break;
					case 4: mpi.logout(); break;

					default : System.out.println("잘못된 선택입니다."); 
					System.exit(0);
					}
				}

			}
		}
	}

	@Override
	public void join() {

		MyPageVO vo = new MyPageVO();

		System.out.println("회원가입을 시작하겠습니다.");
		System.out.println("---------------------------");

		System.out.println("ID를 입력하세요");
		id=sc.next();

		while(true) {
			if(hMap.containsKey(id)) {
				System.out.println("이미 존재하는 아이디입니다.");
				System.out.println("새로운 id를 입력해주세요");
				id=sc.next();

			} break;
		}

		System.out.println("비밀번호를 입력해주세요");
		vo.setPassword(sc.next());

		while(true) {
			if(vo.getPassword().length()>2) break;
			else{
				System.out.println("비밀번호는 2자 이상이여야합니다.");
				System.out.println("비밀번호를 입력해주세요");
				vo.setPassword(sc.next());
			}
		}

		System.out.println("비밀번호를 재입력해주세요");
		String checkPW=sc.next();

		while(true) {
			if(vo.getPassword().equals(checkPW)) break;
			else{
				System.out.println("비밀번호가 다릅니다. 다시 입력해주세요.");
				checkPW=sc.next();
			}
		} 


		System.out.println("이름을 입력해주세요");
		vo.setName(sc.next());

		System.out.println("생년월일을 입력해주세요[yymmdd]");
		vo.setBirth(sc.next());

		vo.setPoint(500);
		vo.setMoviecount(0);

		hMap.put(id, vo);


		System.out.println("회원가입이 완료되었습니다. 가입축하적립금 500P를 드렸습니다.");
		System.out.println("로그인 페이지로 이동합니다.");

		System.out.println("----------------------------");

		login();


	}





}
