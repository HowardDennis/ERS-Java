package com.revature.beans;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Arrays;

public class Reimbursement {
	private int reimb_id;
	private BigDecimal reimb_amount;
	private Timestamp reimb_submitted;
	private String submit_time;
	private String resolve_time;
	public String getResolve_time() {
		return resolve_time;
	}
	public void setResolve_time(String resolve_time) {
		this.resolve_time = resolve_time;
	}
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getSubmit_time() {
		return submit_time;
	}
	public void setSubmit_time(String submit_time) {
		this.submit_time = submit_time;
	}
	public Reimbursement(int reimb_id, BigDecimal reimb_amount, Timestamp reimb_submitted, Timestamp reimb_resolved,
			String reimb_description, byte[] reimb_receipt, String reimb_author, String reimb_resolver,
			String reimb_status, String reimb_type) {
		super();
		this.reimb_id = reimb_id;
		this.reimb_amount = reimb_amount;
		this.reimb_submitted = reimb_submitted;
		this.reimb_resolved = reimb_resolved;
		this.reimb_description = reimb_description;
		this.reimb_receipt = reimb_receipt;
		this.reimb_author = reimb_author;
		this.reimb_resolver = reimb_resolver;
		this.reimb_status = reimb_status;
		this.reimb_type = reimb_type;
	}
	@Override
	public String toString() {
		return "Reimbursement [reimb_id=" + reimb_id + ", reimb_amount=" + reimb_amount + ", reimb_submitted="
				+ reimb_submitted + ", submit_time=" + submit_time + ", resolve_time=" + resolve_time
				+ ", reimb_resolved=" + reimb_resolved + ", reimb_description=" + reimb_description + ", reimb_receipt="
				+ Arrays.toString(reimb_receipt) + ", reimb_author=" + reimb_author + ", reimb_resolver="
				+ reimb_resolver + ", reimb_status=" + reimb_status + ", reimb_type=" + reimb_type + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((reimb_amount == null) ? 0 : reimb_amount.hashCode());
		result = prime * result + ((reimb_author == null) ? 0 : reimb_author.hashCode());
		result = prime * result + ((reimb_description == null) ? 0 : reimb_description.hashCode());
		result = prime * result + reimb_id;
		result = prime * result + Arrays.hashCode(reimb_receipt);
		result = prime * result + ((reimb_resolved == null) ? 0 : reimb_resolved.hashCode());
		result = prime * result + ((reimb_resolver == null) ? 0 : reimb_resolver.hashCode());
		result = prime * result + ((reimb_status == null) ? 0 : reimb_status.hashCode());
		result = prime * result + ((reimb_submitted == null) ? 0 : reimb_submitted.hashCode());
		result = prime * result + ((reimb_type == null) ? 0 : reimb_type.hashCode());
		result = prime * result + ((resolve_time == null) ? 0 : resolve_time.hashCode());
		result = prime * result + ((submit_time == null) ? 0 : submit_time.hashCode());
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
		Reimbursement other = (Reimbursement) obj;
		if (reimb_amount == null) {
			if (other.reimb_amount != null)
				return false;
		} else if (!reimb_amount.equals(other.reimb_amount))
			return false;
		if (reimb_author == null) {
			if (other.reimb_author != null)
				return false;
		} else if (!reimb_author.equals(other.reimb_author))
			return false;
		if (reimb_description == null) {
			if (other.reimb_description != null)
				return false;
		} else if (!reimb_description.equals(other.reimb_description))
			return false;
		if (reimb_id != other.reimb_id)
			return false;
		if (!Arrays.equals(reimb_receipt, other.reimb_receipt))
			return false;
		if (reimb_resolved == null) {
			if (other.reimb_resolved != null)
				return false;
		} else if (!reimb_resolved.equals(other.reimb_resolved))
			return false;
		if (reimb_resolver == null) {
			if (other.reimb_resolver != null)
				return false;
		} else if (!reimb_resolver.equals(other.reimb_resolver))
			return false;
		if (reimb_status == null) {
			if (other.reimb_status != null)
				return false;
		} else if (!reimb_status.equals(other.reimb_status))
			return false;
		if (reimb_submitted == null) {
			if (other.reimb_submitted != null)
				return false;
		} else if (!reimb_submitted.equals(other.reimb_submitted))
			return false;
		if (reimb_type == null) {
			if (other.reimb_type != null)
				return false;
		} else if (!reimb_type.equals(other.reimb_type))
			return false;
		if (resolve_time == null) {
			if (other.resolve_time != null)
				return false;
		} else if (!resolve_time.equals(other.resolve_time))
			return false;
		if (submit_time == null) {
			if (other.submit_time != null)
				return false;
		} else if (!submit_time.equals(other.submit_time))
			return false;
		return true;
	}
	public int getReimb_id() {
		return reimb_id;
	}
	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}
	public BigDecimal getReimb_amount() {
		return reimb_amount;
	}
	public void setReimb_amount(BigDecimal reimb_amount) {
		this.reimb_amount = reimb_amount;
	}
	public Timestamp getReimb_submitted() {
		return reimb_submitted;
	}
	public void setReimb_submitted(Timestamp reimb_submitted) {
		this.reimb_submitted = reimb_submitted;
	}
	public Timestamp getReimb_resolved() {
		return reimb_resolved;
	}
	public void setReimb_resolved(Timestamp reimb_resolved) {
		this.reimb_resolved = reimb_resolved;
	}
	public String getReimb_description() {
		return reimb_description;
	}
	public void setReimb_description(String reimb_description) {
		this.reimb_description = reimb_description;
	}
	public byte[] getReimb_receipt() {
		return reimb_receipt;
	}
	public void setReimb_receipt(byte[] reimb_receipt) {
		this.reimb_receipt = reimb_receipt;
	}
	public String getReimb_author() {
		return reimb_author;
	}
	public void setReimb_author(String reimb_author) {
		this.reimb_author = reimb_author;
	}
	public String getReimb_resolver() {
		return reimb_resolver;
	}
	public void setReimb_resolver(String reimb_resolver) {
		this.reimb_resolver = reimb_resolver;
	}
	public String getReimb_status() {
		return reimb_status;
	}
	public void setReimb_status(String reimb_status) {
		this.reimb_status = reimb_status;
	}
	public String getReimb_type() {
		return reimb_type;
	}
	public void setReimb_type(String reimb_type) {
		this.reimb_type = reimb_type;
	}
	private Timestamp reimb_resolved;
	private String reimb_description;
	private byte[] reimb_receipt;
	private String reimb_author;
	private String reimb_resolver;
	private String reimb_status;
	private String reimb_type;
}
