package com.itwillbs.member.db;

import java.sql.Timestamp;

public class MemberDTO {
	// 회원가입 한 내용을 담아서 전달해주는 바구니
	// 멤버변수 => 접근 제한 => 데이터 은닉, 캡슐화
	private String id;
	private String pass;
	private String name;
	private Timestamp date;
	//추가 email  address  phone mobile
	private String email;
	private String address;
	private String phone;
	private String mobile;
	
	// 생성자
	
	//멤버함수(메서드)
	//  set() : 멤버변수에 외부에 데이터를 저장
	//  get() : 외부에서 멤버변수 데이터를 가져다 사용
	

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	//추가
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
