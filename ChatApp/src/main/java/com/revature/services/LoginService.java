package com.revature.services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.revature.beans.Credentials;
import com.revature.beans.Reimbursement;
import com.revature.beans.User;
import com.revature.daos.LoginDao;
import com.revature.util.HttpException;

public class LoginService {
	LoginDao loginDao = new LoginDao();

	public User login(Credentials credentials) {

		// 1. If credentials lacks a password, throw HttpException with status 422
		// 2. If credentials lacks a username, throw HttpException with status 422
		if (credentials.getPassword() == null || credentials.getUsername() == null) {
			throw new HttpException(422);
		}

		// attempt to retrieve username/password from database
		User user = loginDao.getPasswordByUsername(credentials.getUsername());
		// compare them
		
//		String passwordToHash = user.getPassword();
//		String generatedPassword = null;
////		if (!credentials.getUsername().equals("howardDennis") && !credentials.getUsername().equals("mitchGoshorn")) {
//		try {
//            // Create MessageDigest instance for MD5
//            MessageDigest md = MessageDigest.getInstance("MD5");
//            //Add password bytes to digest
//            md.update(passwordToHash.getBytes());
//            //Get the hash's bytes
//            byte[] bytes = md.digest();
//            //This bytes[] has bytes in decimal format;
//            //Convert it to hexadecimal format
//            StringBuilder sb = new StringBuilder();
//            for(int i=0; i< bytes.length ;i++)
//            {
//                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
//            }
//            //Get complete hashed password in hex format
//            generatedPassword = sb.toString();
//        }
//        catch (NoSuchAlgorithmException e)
//        {
//            e.printStackTrace();
//        }
//        
//		}
//		else {
//			generatedPassword = credentials.getUsername();
//		}
        
// 3. If returned user password does not match credentials password, throw
		// HttpException with status 400
		if (!credentials.getPassword().equals(credentials.getPassword())) {
			throw new HttpException(400);
		}
		// 4. if returned user password matches credentials password, return integer
		// value equal to the id on the returned user object

		List<Reimbursement> myReimbursements = loginDao.getMyReimbursements(user.getId());
		
		user.setMyReimbursements(myReimbursements);
		
		List<Reimbursement> assignedReimbursements = null;
		
		if (user.getUser_role_id() == 2) {
			
			assignedReimbursements = loginDao.getAssignedReimbursements(user.getId());
		}
		
		user.setAssignedReimbursements(assignedReimbursements);

		return user;
	}

	public LoginService(LoginDao loginDao) {
		super();
		this.loginDao = loginDao;
	}

	public LoginService() {
		super();
		this.loginDao = new LoginDao();
	}
}
