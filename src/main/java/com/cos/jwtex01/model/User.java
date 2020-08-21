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
	 * public List<String> getPermissionList(){ 
	 * if(this.permissions.length() > 0){
	 * return Arrays.asList(this.permissions.split(","));
	 *  } return new ArrayList<>(); 
	 *  }
	 */
}