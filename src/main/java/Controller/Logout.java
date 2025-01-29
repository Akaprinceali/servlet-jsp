package Controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/logout")

public class Logout extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.getSession().invalidate();  // it is used to destroy or kill the session
		
		res.getWriter().print("<h1>Logout successfull</h1>");
		
		req.getRequestDispatcher("Home.html").include(req, res);
		
		
		
	}
}
