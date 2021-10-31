package com.hrms;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class leaveServlet
 */
@WebServlet("/leaveServlet")
public class leaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private hrmsDao dao = new hrmsDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public leaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String reason = request.getParameter("reason");
		dao.applied(name, 0, email, mobile,reason);
		response.sendRedirect("user.jsp");
	}	

}
