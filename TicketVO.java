package project1;

public class TicketVO {

//	private int choice;
	private String theater;
	private String moive;
	private String date;
	private int inwon;
	private int seatRow;
	private int seatNum;
	private int tot;
	private int pay;
	
	/*
	public int getChoice() {
		return choice;
	}
	public void setChoice(int choice) {
		this.choice = choice;
	}
	*/
	public String getTheater() {
		return theater;
	}
	public void setTheater(String theater) {
		this.theater = theater;
	}
	public String getMoive() {
		return moive;
	}
	public void setMoive(String moive) {
		this.moive = moive;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getInwon() {
		return inwon;
	}
	public void setInwon(int inwon) {
		this.inwon = inwon;
	}
	public int getSeatRow() {
		return seatRow;
	}
	public void setSeatRow(int seatRow) {
		this.seatRow = seatRow;
	}
	public int getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}
	public int getTot() {
		return inwon*10000;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}

	
	
}
