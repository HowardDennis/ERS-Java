package com.revature.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.servlets.DefaultServlet;

import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Credentials;
import com.revature.beans.Reimbursement;
import com.revature.beans.SubReimbursement;
import com.revature.beans.User;
import com.revature.daos.ReimbursementDao;
import com.revature.services.LoginService;
import com.revature.util.HttpException;

public class ReimbursementServlet extends DefaultServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.addHeader("Access-Control-Allow-Headers", "content-type");
		response.addHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		super.service(request, response);
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String[] parts = request.getPathInfo().split("/");
		int id = -1;
		if (parts.length > 1) {
			id = Integer.parseInt(parts[1]);
		} else {
			response.setStatus(400);
		}

		StringBuilder status = new StringBuilder();
		BufferedReader bufferedReader = request.getReader();
		String line = "";

		while ((line = bufferedReader.readLine()) != null) {
			status.append(line);
		}

		ReimbursementDao reimbursementDao = new ReimbursementDao();

		reimbursementDao.changeReimbursementStatus(id, status.toString());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		ObjectMapper om = new ObjectMapper();
		SubReimbursement subReimbursement = om.readValue(request.getInputStream(), SubReimbursement.class);

		ReimbursementDao reimbursementDao = new ReimbursementDao();
		
		Reimbursement reimbursement = reimbursementDao.insertReimbursement(subReimbursement);
		
		String json = om.writeValueAsString(reimbursement);
		
		om.writeValue(response.getWriter(), json);
	}
}













