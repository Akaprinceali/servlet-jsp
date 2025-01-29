package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import Dto.Bank_account;
import Dto.Customer;

@WebServlet("/fetchactiveaccount")
public class Fetch_active_accounts extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Customer customer = (Customer) req.getSession().getAttribute("customer");
		
		List<Bank_account> list = customer.getBankaccounts();  //all accounts details
		
		List<Bank_account> list2 = new ArrayList<Bank_account>();  //only active accounts details
		
		for(Bank_account bank_account: list)
		{
			if(bank_account.isStatus())
			{
				System.out.println("status is active");
				list2.add(bank_account);
			}
		}
		
		req.getSession().setAttribute("list", list2);
		req.getRequestDispatcher("Accounts.jsp").include(req, resp);
	}
	
}
