package project1;

public class Ticket1VO {

	private String theater;
	private String movie;
	private String date;
	private String seat;
	private int inwon;
	private int pay;
	private int tot;

	public String getTheater() {
		return theater;
	}
	public void setTheater(String theater) {
		this.theater = theater;
	}
	public String getMovie() {
		return movie;
	}
	public void setMovie(String movie) {
		this.movie = movie;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	public int getInwon() {
		return inwon;
	}
	public void setInwon(int inwon) {
		this.inwon = inwon;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	public int getTot() {
		return inwon*10000;
	}

	public void print() {
		
		System.out.println(movie + " (" + inwon + "명: " + getTot() + ")");
		for(int i=0;i<inwon;i++) {
			System.out.printf("좌석: %s", seat);
		}
		
	}

}
