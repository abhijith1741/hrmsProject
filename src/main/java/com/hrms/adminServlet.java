package com.hrms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.leave.leaveFetch;

/**
 * Servlet implementation class adminServlet
 */
@WebServlet("/adminServlet")
public class adminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	hrmsDao dao = new hrmsDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		adminBean ad = new adminBean();
		ad.setName(name);
		ad.setPassword(password);
		HttpSession session = request.getSession();
		if(dao.admin_validate(ad)) {
			List<displayEmployee> list = dao.userFetch();
			List<leaveFetch> leave = dao.leaveDisplay();
			session.setAttribute("list", list);
			session.setAttribute("leave", leave);
			session.setAttribute("admin", name);
			response.sendRedirect("admin.jsp");
			
		}else {
			response.sendRedirect("adminLogin.jsp");
		}
		
	}

}
