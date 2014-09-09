package com.lihb.MyServices;

import com.lihb.service.UserService;

public class GetThreadNum {
	public static final int RECORD_NUM = 30000;    //每个线程处理的记录数目
	private int num;
	private int residue;
	private int sum;
	UserService userService;

	public void getNumAndResidue() {
		//@SuppressWarnings("resource")
		
		sum = userService.countAll();    //1010010
		//sum = 50000;
		if(sum >= RECORD_NUM){  
            num = sum / RECORD_NUM;  
            residue = sum % RECORD_NUM;  
        }else{  
            residue = sum;  
        }  
		
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getResidue() {
		return residue;
	}

	public void setResidue(int residue) {
		this.residue = residue;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	
	
	

}
