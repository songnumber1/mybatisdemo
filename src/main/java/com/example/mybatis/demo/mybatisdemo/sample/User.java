package com.example.mybatis.demo.mybatisdemo.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
	private long id;

	private String username;

	private String password;

	private String roles;

	@JsonIgnore
	private String token;

	@JsonIgnore
	private String tokenExpired;

	private boolean active;

	private String email;

	private String remark;

	public List<String> GetRoleList() {
		if (this.roles.length() > 0) {
			return Arrays.asList(this.roles.split(","));
		}

		return new ArrayList<>();
	}

	public User(long id, String username, String roles, boolean active, String email) {
		this.id = id;
		this.username = username;
		this.roles = roles;
		this.active = active;
		this.email = email;
	}
}