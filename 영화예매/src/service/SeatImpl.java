package service;

import model.MovieSeat;
import view.MenuImpl;

public class SeatImpl implements Seat{
	

private static SeatImpl seatImpl = new SeatImpl();
	
	public static SeatImpl getInstance() {
		if(seatImpl == null) {
			
			seatImpl = new SeatImpl();
		}
		return seatImpl;
	}
	MenuImpl menu = MenuImpl.getInstance();

	
	public void init() {
		MovieSeat.seatMap.put(1,new MovieSeat(1,10000,1));
		MovieSeat.seatMap.put(2,new MovieSeat(2,10000,1));
		MovieSeat.seatMap.put(3,new MovieSeat(3,10000,1));
		MovieSeat.seatMap.put(4,new MovieSeat(4,10000,1));
		MovieSeat.seatMap.put(5,new MovieSeat(5,10000,1));
		MovieSeat.seatMap.put(6,new MovieSeat(6,10000,1));
		MovieSeat.seatMap.put(7,new MovieSeat(7,10000,1));
		MovieSeat.seatMap.put(8,new MovieSeat(8,10000,1));
		MovieSeat.seatMap.put(9,new MovieSeat(9,10000,1));
		MovieSeat.seatMap.put(10,new MovieSeat(10,10000,1));
	}
	
	
	@Override
	public void seatList() {
		
		int cnt = 0;
		System.out.println("\n                 [  좌석 리스트  ]");
		System.out.println("*  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *");
		for(int key:MovieSeat.seatMap.keySet()) {
			MovieSeat value = MovieSeat.seatMap.get(key);
			int count = MovieSeat.seatMap.get(key).getCount();
			String view = (count==1)?"|   |":"| X |";
			System.out.print(value.toString()+view);
			cnt++;
			if(cnt % 5 == 0) System.out.println("\n");
		
		}
	
	}
}
