package com.are.users.dtos;

public class UserResponseDTO {
	
	private int id;
	private String username;
	private RoleResponseDTO role;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public RoleResponseDTO getRole() {
		return role;
	}
	public void setRole(RoleResponseDTO role) {
		this.role = role;
	}
}
