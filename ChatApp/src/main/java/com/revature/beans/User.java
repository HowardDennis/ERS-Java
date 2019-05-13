package com.revature.beans;

import java.util.Arrays;
import java.util.List;

public class User {
	private int id;
	private String username;
	private String password;
	private List<Reimbursement> myReimbursements;
	private List<Reimbursement> assignedReimbursements;
	private int user_role_id;
	private String name;
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Reimbursement> getMyReimbursements() {
		return myReimbursements;
	}
	public void setMyReimbursements(List<Reimbursement> myReimbursements) {
		this.myReimbursements = myReimbursements;
	}
	public List<Reimbursement> getAssignedReimbursements() {
		return assignedReimbursements;
	}
	public void setAssignedReimbursements(List<Reimbursement> assignedReimbursements) {
		this.assignedReimbursements = assignedReimbursements;
	}
	public int getUser_role_id() {
		return user_role_id;
	}
	public void setUser_role_id(int user_role_id) {
		this.user_role_id = user_role_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assignedReimbursements == null) ? 0 : assignedReimbursements.hashCode());
		result = prime * result + id;
		result = prime * result + ((myReimbursements == null) ? 0 : myReimbursements.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + user_role_id;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (assignedReimbursements == null) {
			if (other.assignedReimbursements != null)
				return false;
		} else if (!assignedReimbursements.equals(other.assignedReimbursements))
			return false;
		if (id != other.id)
			return false;
		if (myReimbursements == null) {
			if (other.myReimbursements != null)
				return false;
		} else if (!myReimbursements.equals(other.myReimbursements))
			return false;
		if (name != other.name)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (user_role_id != other.user_role_id)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", myReimbursements="
				+ myReimbursements + ", assignedReimbursements=" + assignedReimbursements + ", user_role_id="
				+ user_role_id + ", name=" + name + "]";
	}
	public User(int id, String username, String password, List<Reimbursement> myReimbursements,
			List<Reimbursement> assignedReimbursements, int user_role_id, String name) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.myReimbursements = myReimbursements;
		this.assignedReimbursements = assignedReimbursements;
		this.user_role_id = user_role_id;
		this.name = name;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
