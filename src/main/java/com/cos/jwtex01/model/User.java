package com.cos.jwtex01.model;

import java.sql.Timestamp;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
	private int id;
	private String username;
	private String password;
	private String provider;
	private String providerId;
	private String email;
	private String name;
	private String gender;
	private String phone;
	private String address;
	private String detail_address;
	private Timestamp birthday;
	private int total_amount;
	private String role;
	private String cancel;
	private String profile;
	private Timestamp createDate;
	
	/*
	 * //ENUM으로 안하고 ,로 구분해서 ROLE을 입력 -> 그걸 파싱!! 
	 * public List<String> getRoleList(){
	 * if(this.roles.length() > 0){ 
	 * return Arrays.asList(this.roles.split(","));
	 *  }
	 * return new ArrayList<>(); 
	 * }
	 * 
	 * public List<String> getPermissionList(){ 
	 * if(this.permissions.length() > 0){
	 * return Arrays.asList(this.permissions.split(","));
	 *  } return new ArrayList<>(); 
	 *  }
	 */
}