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

@WebServlet("/UserCtl")
public class UserCtl extends HttpServlet {

	public static final String OP_UPDATE = "UPDATE";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String op = req.getParameter("op");

		UserModelHibImp userModel = new UserModelHibImp();
		UserDto dto = new UserDto();

		int id = Integer.parseInt(req.getParameter("id"));

		try {
			dto = userModel.findByPk(id);
			req.setAttribute("dto", dto);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd = req.getRequestDispatcher("UserView.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String op = req.getParameter("operation");

		System.out.println("dopost");

		if (OP_UPDATE.equalsIgnoreCase(op)) {
			System.out.println("step1");
			
			
			UserModelHibImp userModel = new UserModelHibImp();

			int id = Integer.parseInt(req.getParameter("id"));
			UserDto dto = new UserDto();

			dto.setId(id);
			dto.setFirstName(req.getParameter("firstName"));
			dto.setLastName(req.getParameter("lastName"));
			dto.setLogin(req.getParameter("login"));
			dto.setPassword(req.getParameter("password"));
			dto.setAddress(req.getParameter("address"));

			// int id = Integer.parseInt(req.getParameter("id"));

			try {
				userModel.update(dto);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
