package service;

import model.MovieSeat;
import model.MovieUser;
import view.MenuImpl;

public class UserImpl implements User{
	
private static UserImpl userImpl = new UserImpl();
	
	public static UserImpl getInstance() {
		if(userImpl == null) {
			userImpl = new UserImpl();
		}
		return userImpl;
	}
	
	public static MenuImpl menu = MenuImpl.getInstance();
	public static SeatImpl seatimpl = SeatImpl.getInstance();
	
	String userId;
	String userPw;	
	
	private UserImpl() {}
	
	public UserImpl(String userId, String userPw) {
		this.userId = userId;
		this.userPw = userPw;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	
	public void init() {
		MovieUser.join.put("aaa", "aaa");
		MovieUser.join.put("bbb", "bbb");
		MovieUser.join.put("ccc", "ccc");
		MovieUser.join.put("ddd", "ddd");
		MovieUser.join.put("eee", "eee");			
		
	}

	@Override
	public void ticketList() {
		System.out.println(userId);
		System.out.println("\n                 [  영화 예매 현황  ]");
		System.out.println("*  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *");
		System.out.println("             좌석번호      |      가격    ");
		int total = 0;
		try {
			for(int key:MovieUser.userMap.keySet()) {			
				if(userId.equals(MovieUser.userMap.get(key).getUserId())) {
					MovieUser value = MovieUser.userMap.get(key);
					System.out.println(value.toString());
					total += MovieUser.userMap.get(key).getPrice();
				}
			}
			System.out.println("총가격:"+total+"원");
		}catch(Exception e) {
			System.out.println("      예매 내역이 없습니다.");
		}
		System.out.println();
		menu.userView();
		// 메인으로 돌아갑니다.
	}

	@Override
	public void ticketAdd() {
		
		System.out.println("\n                 [  영화 예매 하기  ]");
		System.out.println("*  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *");
		int cnt = 0;
		for(int key:MovieSeat.seatMap.keySet()) {
			
			int count = MovieSeat.seatMap.get(key).getCount();
			String view = (count==1)?"| O |":"| X |";
			System.out.print(view);
			cnt++;
			if(cnt % 5 == 0) System.out.println("\n");
		
		}
		System.out.println("*  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *");
		System.out.println("              좌석번호 를 입력하세요 (1 ~ 10) [0] 취소");
		
		String sel = MenuImpl.scan.next();
		if(sel.equals("0")) {			
			menu.userView();
			// 메인으로 돌아갑니다.
		}else {
			
			try {
				int seatNum = Integer.parseInt(sel);
				int count = MovieSeat.seatMap.get(seatNum).getCount();
				if(count == 1) {
					//좌석의 여부와 빈자리(1)인지 체크 *
						
					// seatMap - > int seatNo, int price, int count
					// userMap - > int seatNo, int price, int count, String userId
					
					int price = MovieSeat.seatMap.get(seatNum).getPrice();
					MovieSeat.seatMap.put(seatNum, new MovieSeat(seatNum,price,0));
						// count -1 해서 0으로 만들어준다. (좌석 빈자리 체크)				
					MovieUser.userMap.put(seatNum, new MovieUser(seatNum,price,count,userId));
					System.out.println("예매가 완료되었습니다.");	
									
				}else {
					System.out.println("이미 예매된 좌석입니다.");
				}					
			}catch(Exception e) {
				System.out.println("다시 입력해주세요.");
				MenuImpl.scan.next();
			}
			menu.userView();
			// 메인으로 돌아갑니다.
		}
	}

	@Override
	public void ticketRemove() {
		
		try {
			for(int key:MovieUser.userMap.keySet()) {			
				if(userId.equals(MovieUser.userMap.get(key).getUserId())) {
					MovieUser value = MovieUser.userMap.get(key);
					System.out.println(value.toString());
				}
			}

		}catch(Exception e) {
			System.out.println("      예매 내역이 없습니다.");
			menu.userView();
			// 메인으로 돌아갑니다.
		}
	
		System.out.println("*  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *");
		System.out.println("            취소하실 티켓번호 를 입력하세요 [0] 취소");
		
		String sel = MenuImpl.scan.next();
		if(sel.equals("0")) {			
			menu.userView();
			// 메인으로 돌아갑니다.
		}
		try {
			int seatNum = Integer.parseInt(sel);
			String id = MovieUser.userMap.get(seatNum).getUserId();
			if(id.equals(userId)) {
				//회원의 예매현황 확인 *
						
				// seatMap - > int seatNo, int price, int count
				// userMap - > int seatNo, int price, int count, String userId
					
				int price = MovieSeat.seatMap.get(seatNum).getPrice();
				MovieSeat.seatMap.put(seatNum, new MovieSeat(seatNum,price,1));
						// count +1 해서 1으로 만들어준다. (좌석 자리 체크)				
				MovieUser.userMap.remove(seatNum);
				System.out.println("예매가 취소되었습니다.");	
									
			}else {
				System.out.println("좌석 번호를 확인해주세요.");
			}					
		}catch(Exception e) {
			System.out.println("다시 입력해주세요.");
		}
		menu.userView();
		// 메인으로 돌아갑니다.
	}	
}