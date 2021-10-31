package com.hrms.salary;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.hrmsDao;

/**
 * Servlet implementation class addSalaryServlet
 */
@WebServlet("/addSalaryServlet")
public class addSalaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addSalaryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sal = request.getParameter("sal");
		HttpSession session = request.getSession();
		session.setAttribute("sal", sal);
		String name = (String) session.getAttribute("salary");
		String id = (String) session.getAttribute("id");
		hrmsDao dao = new hrmsDao();
		dao.addSalary(id, name, sal);
		response.sendRedirect("admin.jsp");
	}

}
