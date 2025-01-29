package Controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/setactiveaccount")
public class Set_active_account extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String acc_no=req.getParameter("acno");
		
		long ac_number=Long.parseLong(acc_no);
		
		req.getSession().setAttribute("acc_number", ac_number);
		req.getRequestDispatcher("Account_home.html").include(req, res);
		
		
	}
}
