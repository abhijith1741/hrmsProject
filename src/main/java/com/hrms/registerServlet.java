package com.hrms;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class registerServlet
 */
@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	hrmsDao dao = new hrmsDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String password = request.getParameter("password");
		registerBean reg = new registerBean();
		reg.setName(username);
		reg.setEmail(email);
		reg.setMobile(mobile);
		reg.setPassword(password);
	    int result = dao.register(reg);
	    HttpSession session = request.getSession();
	    if(result>0) {
	    	session.setAttribute("result", "success");
//	    	response.sendRedirect("index.jsp");
	    }else {
	    	session.setAttribute("result", "failed");
	    }
		response.sendRedirect("register.jsp");
		
		
		
	}

}
