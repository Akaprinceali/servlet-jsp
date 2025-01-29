package Controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import Dao.CustomerDao;
import Dto.Bank_account;
import Dto.Customer;

@WebServlet("/customersignup")
public class Customersignup extends HttpServlet {

		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			String name=req.getParameter("name");
			String mob=req.getParameter("mob");
			
			long mobile=Long.parseLong(mob);
			
			String pwd=req.getParameter("pwd");
			String email=req.getParameter("email");
			String gender=req.getParameter("gender");
			String dob=req.getParameter("dob");
			
			List<Bank_account> list;
			
//			resp.getWriter().print("<h1>"+name+"</h1>"
//					+ "<h1>"+mobile+"</h1>"
//					+ "<h1>"+pwd+"</h1>"
//					+ "<h1>"+email+"</h1>"
//					+ "<h1>"+gender+"</h1>"
//					+ "<h1>"+dob+"</h1>");
//			
//			
//			resp.getWriter().print("<h1>"+mobile+"</h1>");
//			resp.getWriter().print("<h1>"+pwd+"</h1>");
//			resp.getWriter().print("<h1>"+email+"</h1>");
//			resp.getWriter().print("<h1>"+gender+"</h1>");
//			resp.getWriter().print("<h1>"+dob+"</h1>");
			
			
			Date date=Date.valueOf(dob);
			
			Period period=Period.between(date.toLocalDate(),LocalDate.now());
			
			int age = period.getYears();
			
			Customer customer=new Customer();
			
			CustomerDao customerDao=new CustomerDao();
			
			
			if(age>18)
			{
				
				if(customerDao.check1(email).isEmpty() && customerDao.check2(mobile).isEmpty())
				{
					
						
				customer.setCname(name);
				customer.setEmail(email);
				customer.setGender(gender);
				customer.setMob(mobile);
				customer.setDate(date);
				customer.setPwd(pwd);
				customer.setBankaccounts(null);
				
				customerDao.save(customer);
	
				
				
				Customer customer2=customerDao.check1(email).get(0);
				
				if(customer2.getGender().equals("female"))
				{
					resp.getWriter().print("<h1>Hello Mrs. "+customer2.getCname()+"</h1>");
				}
				else
				{
					resp.getWriter().print("<h1>Hello Mr. "+customer2.getCname()+"</h1>");
				}
				
				resp.getWriter().print("<h1>Account has been created successfully your customer id is : "+customer2.getCid()+"</h1>");
				req.getRequestDispatcher("customerlogin.html").include(req, resp);
			}
				
			
			else
			{
				resp.getWriter().print("<h1>This email id : "+email+" and this mobile no: "+mobile+" already exists</h1>");
			}
			}
			else
			{
				resp.getWriter().print("<h1>Not eligible to create account</h1>");
			}
			
			
			
			
		}
}
