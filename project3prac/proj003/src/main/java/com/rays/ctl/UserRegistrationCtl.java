package com.rays.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.dto.UserDto;
import com.rays.model.UserModelHibImp;

@WebServlet("/UserRegistrationCtl")
public class UserRegistrationCtl extends HttpServlet {

	public static final String OP_SIGN_UP = "signUp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
              
		String op = req.getParameter("operation");
		UserModelHibImp userModel = new UserModelHibImp();
		
		UserDto dto = new UserDto();
		dto.setFirstName(req.getParameter("firstName"));
		dto.setLastName(req.getParameter("lastName"));
		dto.setLogin(req.getParameter("login"));
		dto.setPassword(req.getParameter("password"));
		dto.setAddress(req.getParameter("address"));
		
		try {
			userModel.add(dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String op = req.getParameter("operation");
		System.out.println("dopsot");

		if (OP_SIGN_UP.equalsIgnoreCase(op)) {
			System.out.println("step1");
			
			UserModelHibImp userModel = new UserModelHibImp();
			
			UserDto dto = new UserDto();
			
System.out.println("step 2");
			dto.setFirstName(req.getParameter("firstName"));
			dto.setLastName(req.getParameter("lastName"));
			dto.setLogin(req.getParameter("login"));
			dto.setPassword(req.getParameter("password"));
			dto.setAddress(req.getParameter("address"));

			try {
				userModel.add(dto);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		RequestDispatcher rd = req.getRequestDispatcher("Welcome.jsp");
		rd.forward(req, resp);
	}

}
