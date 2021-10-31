package com.hrms;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.salary.salaryDisplayUser;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	hrmsDao dao = new hrmsDao();

    /**
     * Default constructor. 
     */
    public loginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		loginBean log = new loginBean();
		log.setUsername(username);
		log.setPassword(password);
		HttpSession session = request.getSession();

		if(dao.validate(log)) {
			List<userDetailsBean> list = dao.get(username);
			List<salaryDisplayUser> userSalary = dao.showSalary();
			session.setAttribute("list", list);
			session.setAttribute("userSalary", userSalary);
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			response.sendRedirect("user.jsp");
		}else {
			response.sendRedirect("index.jsp");
		}
		
	}

}
