package project1;

import java.util.List;

public interface MyPage {
	
	public void mypageMain(MyPageVO vo);
	public void checkBooking();
	public void cancleBooking(Ticket1VO voT);
	public void modifyBooking();
	public void searchInfo();
	public void logout();

}
