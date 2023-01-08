package com.itwillbs.cart.db;

public class CartDTO {
	//멤버변수
	private int crt_num;  //카트번호
	private String cus_id;	  //회원아이디
	private int menu_id; //제품번호
	private int crt_price;//금액
	private int crt_count;//수량
	
	
	
	// private으로 멤버변수 선언했으므로
	// get, set메서드 해줌
	public int getCrt_num() {
		return crt_num;
	}
	public void setCrt_num(int crt_num) {
		this.crt_num = crt_num;
	}
	public String getCus_id() {
		return cus_id;
	}
	public void setCus_id(String cus_id) {
		this.cus_id = cus_id;
	}
	public int getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}
	public int getCrt_price() {
		return crt_price;
	}
	public void setCrt_price(int crt_price) {
		this.crt_price = crt_price;
	}
	public int getCrt_count() {
		return crt_count;
	}
	public void setCrt_count(int crt_count) {
		this.crt_count = crt_count;
	}
	
	
	
	
}
