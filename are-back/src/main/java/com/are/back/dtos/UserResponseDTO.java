package com.are.back.dtos;

public class UserResponseDTO {
	
	private int id;
	private String email;
	private String alias;
	private String token;
	private RoleResponseDTO role;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public RoleResponseDTO getRole() {
		return role;
	}
	public void setRole(RoleResponseDTO role) {
		this.role = role;
	}
}
