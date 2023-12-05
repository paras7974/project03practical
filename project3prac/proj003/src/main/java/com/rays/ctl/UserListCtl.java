package com.rays.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.dto.UserDto;
import com.rays.model.UserModelHibImp;

@WebServlet("/UserListCtl")
public class UserListCtl extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int pageNo = 1;
		int pageSize = 10;
		
		List list = null;
		
		String op = req.getParameter("operation");
		UserDto dto = new UserDto();
		
		UserModelHibImp userModel = new UserModelHibImp();
		
		try {
		list =	userModel.search(dto, pageNo, pageSize);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("list", list);
		req.setAttribute("pageNo", pageNo);
		req.setAttribute("pageSize", pageSize);
		
		RequestDispatcher rd = req.getRequestDispatcher("UserListView.jsp");
		rd.forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int pageNo = 1;
		int pageSize = 10;
		
		List list = null;
		
		String op = req.getParameter("operation");
		UserDto dto = new UserDto();
		
		UserModelHibImp userModel = new UserModelHibImp();
		
		dto.setFirstName(req.getParameter("firstName"));
		dto.setLastName(req.getParameter("lastName"));
		if(op.equals("search")) {
			
			pageNo = 1;
		
		
		try {
		list =	userModel.search(dto, pageNo, pageSize);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("list", list);
		req.setAttribute("pageNo", pageNo);
		req.setAttribute("pageSize", pageSize);
		
		RequestDispatcher rd = req.getRequestDispatcher("UserListView.jsp");
	    rd.forward(req, resp);
	    
		}
		if(op.equals("DELETE")) {
			
	    //    dto.setId( Integer.parseInt( req.getParameter("id")));
	    String[] ids =  req.getParameterValues("id");
	    
	    for(String id : ids) {
	    	 UserDto deletedto = new UserDto();
	    	
	    	 deletedto.setId(Integer.parseInt(id));
	    	 
	    	 try {
				userModel.delete(deletedto);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	 
	    	
	    }
	         //resp.sendRedirect("UserListView.jsp");
	  
		}
	} 
	
		
	
		
	}


	

