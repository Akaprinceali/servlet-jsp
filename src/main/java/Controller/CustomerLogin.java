package Controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Dao.CustomerDao;
import Dto.Customer;

@WebServlet("/customerlogin")
public class CustomerLogin extends HttpServlet {
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cid=req.getParameter("custid");
		
		int customerid=Integer.parseInt(cid);
		
		String password=req.getParameter("pwd");
		
		CustomerDao customerDao=new CustomerDao();
		
		Customer customer=customerDao.login(customerid);
		
		if(customer==null)
		{
			resp.getWriter().print("<h1>Invalid cust id</h1>");
			req.getRequestDispatcher("Home.html").include(req, resp);
			
		}
		else {
			if(customer.getPwd().equals(password))
			{
				resp.getWriter().print("<h1>Login success</h1>");
				req.getSession().setAttribute("customer", customer);//it is use to store or set the information of customer
				req.getRequestDispatcher("Customerhome.html").include(req, resp);
			}
			else {
				
				resp.getWriter().print("<h1>Invalid password</h1>");
				
				req.getRequestDispatcher("Home.html").include(req, resp);

			}
		}
	}

}
