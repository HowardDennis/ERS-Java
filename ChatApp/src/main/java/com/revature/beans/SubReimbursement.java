package com.revature.beans;

import java.math.BigDecimal;

public class SubReimbursement {
	private Integer id;
	private BigDecimal reimb_amount;
	private String reimb_description;
	private String reimb_type;
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public BigDecimal getReimb_amount() {
		return reimb_amount;
	}
	public void setReimb_amount(BigDecimal reimb_amount) {
		this.reimb_amount = reimb_amount;
	}
	public String getReimb_description() {
		return reimb_description;
	}
	public void setReimb_description(String reimb_description) {
		this.reimb_description = reimb_description;
	}
	public String getReimb_type() {
		return reimb_type;
	}
	public void setReimb_type(String reimb_type) {
		this.reimb_type = reimb_type;
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((reimb_amount == null) ? 0 : reimb_amount.hashCode());
		result = prime * result + ((reimb_description == null) ? 0 : reimb_description.hashCode());
		result = prime * result + ((reimb_type == null) ? 0 : reimb_type.hashCode());
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
		SubReimbursement other = (SubReimbursement) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (reimb_amount == null) {
			if (other.reimb_amount != null)
				return false;
		} else if (!reimb_amount.equals(other.reimb_amount))
			return false;
		if (reimb_description == null) {
			if (other.reimb_description != null)
				return false;
		} else if (!reimb_description.equals(other.reimb_description))
			return false;
		if (reimb_type == null) {
			if (other.reimb_type != null)
				return false;
		} else if (!reimb_type.equals(other.reimb_type))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SubReimbursement [id=" + id + ", reimb_amount=" + reimb_amount + ", reimb_description="
				+ reimb_description + ", reimb_type=" + reimb_type + ", name=" + name + "]";
	}
	public SubReimbursement(Integer id, BigDecimal reimb_amount, String reimb_description, String reimb_type,
			String name) {
		super();
		this.id = id;
		this.reimb_amount = reimb_amount;
		this.reimb_description = reimb_description;
		this.reimb_type = reimb_type;
		this.name = name;
	}
	public SubReimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
