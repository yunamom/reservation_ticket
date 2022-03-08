package model;

import java.util.HashMap;
import java.util.Map;

public class MovieSeat {

	public static Map<Integer,MovieSeat> seatMap = new HashMap<Integer,MovieSeat>(); 
	//좌석
	
	private int seatNo; //좌석번호
	private int price; //가격
	private int count; //수량
	
	private MovieSeat() {}
	// 생성자는 외부에서 호출못하게 private 으로 지정해야 한다.
	
	public MovieSeat(int seatNo, int price, int count) {
		
		this.seatNo = seatNo;
		this.price = price;
		this.count = count;	
	}

	public static Map<Integer, MovieSeat> getSeatMap() {
		return seatMap;
	}
	public static void setSeatMap(Map<Integer, MovieSeat> seatMap) {
		MovieSeat.seatMap = seatMap;
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

	public String toString() { // 좌석번호 , 가격 , 수량 
		return "["+seatNo+"]";
	}
}
