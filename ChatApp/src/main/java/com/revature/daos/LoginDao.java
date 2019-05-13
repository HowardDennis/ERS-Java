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
public class LoginDao {

	/**
	 * Attempts to retrieve User instance from a provided username.
	 * 
	 * @param username - Username as a string
	 * @return User instance
	 * @throws HttpException if user does not exist with status 400 and when any
	 *                       SQLException occurs with status 500
	 */
	public User getPasswordByUsername(String username) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM ers_users WHERE ers_username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				String password = rs.getString("ers_password");
				int id = rs.getInt("ers_user_id");
				int user_role_id = rs.getInt("user_role_id");
				String name = rs.getString("user_first_name");
				return new User(id, username, password, null, null, user_role_id, name);
			} else {
				throw new HttpException(400);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new HttpException(500);
		}
	}

	public List<Reimbursement> getMyReimbursements(int id) {
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionUtil.getConnection()) {

			List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_author = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Reimbursement reimbursement = new Reimbursement();
				reimbursement.setReimb_amount(rs.getBigDecimal("reimb_amount"));
				reimbursement.setReimb_id(rs.getInt("reimb_id"));
				reimbursement.setReimb_description(rs.getString("reimb_description"));
				reimbursement.setReimb_resolved(rs.getTimestamp("reimb_resolved"));

				reimbursement.setResolve_time(
						reimbursement.getReimb_resolved() != null ? reimbursement.getReimb_resolved().toString()
								: null);
				Integer r = rs.getInt("reimb_resolver");
				String name = "";
				if (r == null) {

				} else if (r == 12) {
					name = "Mitch Goshorn";
				} else if (r == 11) {
					name = "Howard Dennis";
				}
				reimbursement.setReimb_resolver(name);

				String stat = "";
				Integer s = rs.getInt("reimb_status_id");

				switch (s) {
				case 1:
					stat = "Pending";
					break;
				case 2:
					stat = "Denied";
					break;
				case 3:
					stat = "Approved";
					break;
				}

				reimbursement.setReimb_status(stat);

				reimbursement.setReimb_submitted(rs.getTimestamp("reimb_submitted"));

				Timestamp time = reimbursement.getReimb_submitted();

				String timeStr = new SimpleDateFormat("MM/dd/yyyy hh:mma").format(time);

				reimbursement.setSubmit_time(timeStr);

				String type = "";

				s = rs.getInt("Reimb_type_id");
				switch (s) {
				case 1:
					type = "Lodging";
					break;
				case 2:
					type = "Travel";
					break;
				case 3:
					type = "Food";
					break;
				case 4:
					type = "Other";
					break;
				}

				reimbursement.setReimb_type(type);

				reimbursements.add(reimbursement);
			}

			return reimbursements;

//			if(rs.next()) {
//				String password = rs.getString("ers_password");
//				int id = rs.getInt("ers_user_id");
//				return new User(id, username, password);
//			} else {
//				throw new HttpException(400);
//			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new HttpException(500);
		}
	}

	public List<Reimbursement> getAssignedReimbursements(int id) {
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionUtil.getConnection()) {

			List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_resolver = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String stat = "";
				Integer s = rs.getInt("reimb_status_id");

				if (s != 1) {
					continue;
				}
				switch (s) {
				case 1:
					stat = "Pending";
					break;
				case 2:
					stat = "Denied";
					break;
				case 3:
					stat = "Approved";
					break;
				}

				Reimbursement reimbursement = new Reimbursement();
				reimbursement.setReimb_status(stat);
				reimbursement.setReimb_amount(rs.getBigDecimal("reimb_amount"));
				reimbursement.setReimb_id(rs.getInt("reimb_id"));
				reimbursement.setReimb_description(rs.getString("reimb_description"));
				reimbursement.setReimb_resolved(rs.getTimestamp("reimb_resolved"));

				reimbursement.setReimb_submitted(rs.getTimestamp("reimb_submitted"));

				Timestamp time = reimbursement.getReimb_submitted();

				String timeStr = new SimpleDateFormat("MM/dd/yyyy hh:mma").format(time);

				reimbursement.setSubmit_time(timeStr);

				String type = "";

				s = rs.getInt("Reimb_type_id");
				switch (s) {
				case 1:
					type = "Lodging";
					break;
				case 2:
					type = "Travel";
					break;
				case 3:
					type = "Food";
					break;
				case 4:
					type = "Other";
					break;
				}

				reimbursement.setReimb_type(type);

				reimbursements.add(reimbursement);
			}

			return reimbursements;

//			if(rs.next()) {
//				String password = rs.getString("ers_password");
//				int id = rs.getInt("ers_user_id");
//				return new User(id, username, password);
//			} else {
//				throw new HttpException(400);
//			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new HttpException(500);
		}
	}

}
