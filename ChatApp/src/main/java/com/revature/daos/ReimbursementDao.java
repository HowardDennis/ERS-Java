package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Reimbursement;
import com.revature.beans.SubReimbursement;
import com.revature.beans.Reimbursement;
import com.revature.beans.User;
import com.revature.util.ConnectionUtil;
import com.revature.util.HttpException;

/**
 * LoginDao is responsible for performing persistance related tasks on a
 * database for Login related operations.
 * 
 * @author mitch
 */
public class ReimbursementDao {

	/**
	 * Attempts to retrieve User instance from a provided username.
	 * 
	 * @param status   TODO
	 * @param username - Username as a string
	 * 
	 * @return User instance
	 * @throws HttpException if user does not exist with status 400 and when any
	 *                       SQLException occurs with status 500
	 */
	public void changeReimbursementStatus(int reimb_id, String status) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "UPDATE ers_reimbursement SET reimb_status_id = ?, reimb_resolved = ? WHERE reimb_id = ?";

			int reimb_status_id = -1;

			switch (status) {
			case "Denied":
				reimb_status_id = 2;
				break;
			case "Approved":
				reimb_status_id = 3;
				break;
			}

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, reimb_status_id);
			ps.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
			ps.setInt(3, reimb_id);

			int a = ps.executeUpdate();

			if (a == 0) {
				throw new HttpException(400);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new HttpException(500);
		}
	}

	public Reimbursement insertReimbursement(SubReimbursement subReimbursement) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO ers_reimbursement (REIMB_AMOUNT, REIMB_SUBMITTED, REIMB_DESCRIPTION, REIMB_AUTHOR, REIMB_RESOLVER, REIMB_STATUS_ID, REIMB_TYPE_ID)"
					+ "VALUES(?, ?, ?, ?, ?, 1, ?) RETURNING reimb_id";

			PreparedStatement ps = conn.prepareStatement(sql);
			Reimbursement reimbursement = new Reimbursement();

			ps.setBigDecimal(1, subReimbursement.getReimb_amount());
			reimbursement.setReimb_amount(subReimbursement.getReimb_amount());

			ps.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
			Timestamp time = new Timestamp(System.currentTimeMillis());
			reimbursement.setReimb_submitted(time);
			reimbursement.setSubmit_time(new SimpleDateFormat("MM/dd/yyyy hh:mma").format(time));

			ps.setString(3, subReimbursement.getReimb_description());
			reimbursement.setReimb_description(subReimbursement.getReimb_description());

			Integer uid = subReimbursement.getId();
			ps.setInt(4, uid);
			reimbursement.setReimb_author(subReimbursement.getName());

			Integer res = 11;
			String name = "Howard Dennis";
			if (uid == 11) {
				res = 12;
				name = "Mitch Goshorn";
			}
			ps.setInt(5, res);
			reimbursement.setReimb_resolver(name);

			String s = subReimbursement.getReimb_type();
			Integer type = -1;
			
			switch (s) {
			case "Lodging":
				type = 1;
				break;
			case "Travel":
				type = 2;
				break;
			case "Food":
				type = 3;
				break;
			case "Other":
				type = 4;
				break;
			}

			ps.setInt(6, type);
			reimbursement.setReimb_type(s);
			
			reimbursement.setReimb_status("Pending");

			ResultSet rs = ps.executeQuery();
			
			rs.next();
			reimbursement.setReimb_id(rs.getInt(1));
			
			return reimbursement;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new HttpException(500);
		}
	}

}
