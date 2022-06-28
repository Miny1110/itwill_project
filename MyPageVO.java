package project1;

public class MyPageVO {
	
	
	private String id;
	private String password;
	private String name;
	private String birth;
	private int point;
	private String level;
	private int moviecount;
	
	
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getLevel() {
		
		if(getPoint()>=50000 || getMoviecount()>=10) {
			level="플래티넘";
		}else if(getPoint()>=30000 || getMoviecount()>=3) {
			level="골드";
		}else  {
				level="베이직";
		}
		
		return level;
	}
	
	public int getMoviecount() {
		return moviecount;
	}
	public void setMoviecount(int moviecount) {
		this.moviecount = moviecount;
	}
	
	

}
