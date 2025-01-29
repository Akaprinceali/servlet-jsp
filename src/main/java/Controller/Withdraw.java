package Controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Dao.BankDao;
import Dto.Bank_account;

@WebServlet("/withdraw")
public class Withdraw extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String amt =req.getParameter("amnt");
		
		double amount = Double.parseDouble(amt);
		
		Long acno= (Long) req.getSession().getAttribute("acc_number");
		
		BankDao bankDao = new BankDao();
		
		
		Bank_account bank_account = bankDao.find(acno);
		
		if(bank_account.getAmount()< amount)
		{
			res.getWriter().print("<h1>Insufficient balance your available balance is :"+ bank_account.getAmount()+"</h1>");
		}
		else
		{
			if(amount>bank_account.getAcc_limit())
			{
				res.getWriter().print("<h1>you are exceeding your account limit your actual limit is  :"+ bank_account.getAcc_limit()+"</h1>");
			}
			else {
				
				bank_account.setAmount(bank_account.getAmount()-amount);
				bankDao.update_the_details(bank_account);
				res.getWriter().print("<h1>Amount has been withdrawn successfully</h1>");
				

			}
		}
		
	}
}
