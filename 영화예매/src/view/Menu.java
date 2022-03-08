package view;

public interface Menu {

	public void init();
	public void mainMenu(); //첫 시작화면
	public void commonMenu(int menuNo); 
	
	public void userJoin(); //회원가입 
	public void userLogin(); //회원 로그인
	public void userView(); //회원 메뉴 

}

