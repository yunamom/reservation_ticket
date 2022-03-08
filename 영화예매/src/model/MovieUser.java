package model;

import java.util.HashMap;
import java.util.Map;

public class MovieUser {

	public static Map<String,String>join = new HashMap<String,String>(); 
	//회원가입
	public static Map<Integer,MovieUser> userMap = new HashMap<Integer,MovieUser>(); 
	//좌석
	
	private int seatNo; //좌석번호
	private int price; //가격
	private int count; //수량
	private String userId; //회원 id
	
	private MovieUser() {}
	// 생성자는 외부에서 호출못하게 private 으로 지정해야 한다.
	
	public MovieUser(int seatNo, int price, int count, String userId) {
		
		this.seatNo = seatNo;
		this.price = price;
		this.count = count;	
		this.userId = userId;
	}

	public static Map<Integer, MovieUser> getUserMap() {
		return userMap;
	}

	public static void setUserMap(Map<Integer, MovieUser> userMap) {
		MovieUser.userMap = userMap;
	}

	public static Map<String, String> getJoin() {
		return join;
	}

	public static void setJoin(Map<String, String> join) {
		MovieUser.join = join;
	}

	public int getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String toString() { // 좌석번호 , 가격 , 수량 , 회원아이디
		return "------------|"+ "\t" + seatNo + "번\t" + price + "원\t" + "|------------";
	}
}