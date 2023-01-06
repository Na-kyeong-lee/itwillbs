package com.itwillbs.cart.db;

public class CartDTO {

	private int crt_num;
	private String cus_id;
	private int menu_num;
	private int crt_price;
	private int crt_count;
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
	public int getMenu_num() {
		return menu_num;
	}
	public void setMenu_num(int menu_num) {
		this.menu_num = menu_num;
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
