package com.example.demo.bean;


public class Role {
	
	private int role_id;
	private String role;
	
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", role=" + role + "]";
	}
	
	
	
	
}
